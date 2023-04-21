package com.pfcti.Clase2.service;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.pfcti.Clase2.dto.ClienteDto;
import com.pfcti.Clase2.model.Cliente;
import com.pfcti.Clase2.repository.*;
import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import jakarta.transaction.UserTransaction;
import lombok.AllArgsConstructor;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;
    private TarjetaRepository tarjetaRepository;
    private CuentaRepository cuentaRepository;
    private InversionRepository inversionRepository;
    private DireccionRepository direccionRepository;
    public void insertatCliente(ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellidos(clienteDto.getApellidos());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());
        clienteRepository.save(cliente);
    }

    public ClienteDto obtenerCliente(int id) {
        ClienteDto clienteDto = new ClienteDto();
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> {
                    throw new RuntimeException("Cliente no existe");
                }
        );

        clienteDto.setNombre(cliente.getNombre());
        clienteDto.setTelefono(cliente.getTelefono());
        clienteDto.setId(cliente.getId());
        clienteDto.setApellidos(cliente.getApellidos());
        clienteDto.setCedula(cliente.getCedula());

        return clienteDto;
    }

    public void actualizarCliente(ClienteDto clienteDto) {
        Cliente cliente = clienteRepository.findById(clienteDto.getId())
                .orElseThrow(() -> {
                            throw new RuntimeException("NO Existe el cliente");
                        }
                );
        cliente.setId(clienteDto.getId());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellidos(clienteDto.getApellidos());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());

        clienteRepository.save(cliente);
    }

    public List<ClienteDto> obtnerClientes() {
        List<ClienteDto> clienteDtos = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.findAll();
        clientes.forEach(cliente -> {
            clienteDtos.add(fromClienteToClienteDto(cliente));
        });

        return clienteDtos;
    }

    public List<ClienteDto> obtenerClientesPorCodigoISOPaisYCuentasActivas(String codigoISOPais) {
        List<ClienteDto> clienteDtos = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.findClientesByPaisAndCuentas_EstadoIsTrue(codigoISOPais);
        clientes.forEach(cliente -> {
            clienteDtos.add(fromClienteToClienteDto(cliente));
        });
        return clienteDtos;
    }

    public void eliminarCliente(int clienteId){

        direccionRepository.deleteAllByCliente_Id(clienteId);
        cuentaRepository.deleteAllByCliente_Id(clienteId);
        inversionRepository.deleteAllByCliente_Id(clienteId);
        tarjetaRepository.deleteAllByCliente_Id(clienteId);
        clienteRepository.deleteById(clienteId);
    }

    public List<ClienteDto> buscarPorApellido(String apellidos ){
        List<ClienteDto> clienteDtos = new ArrayList<>();
        List<Cliente> clientes = clienteRepository.buscarPorApellido(apellidos);
        clientes.forEach(cliente -> {
            clienteDtos.add(fromClienteToClienteDto(cliente));
        });

        return clienteDtos;
    }

    public List<ClienteDto> buscarPorApellidoQueryNativo(String apellidos){
        List<ClienteDto> clienteDtos = new ArrayList<>();
        List<Tuple>  tuples = clienteRepository.buscarPorApellidoQueryNativo(apellidos);
        tuples.forEach(tuple -> {
            ClienteDto dto = new ClienteDto();
            dto.setId((Integer) tuple.get("id"));
            dto.setNombre((String) tuple.get("nombre"));
            dto.setApellidos((String) tuple.get("apellidos"));
            dto.setCedula((String) tuple.get("cedula"));
            dto.setTelefono((String) tuple.get("telefono"));
            dto.setPais((String) tuple.get("pais"));
            clienteDtos.add(dto);
        });
        return clienteDtos;
    }

    public void actualizaClientePorApellido(String nombre, String apellidos) {
        clienteRepository.actualizaClientePorApellido(nombre,apellidos);
    }

    public  List<ClienteDto> buscarPorApellidoYNombre(String apellidos, String nombre){
        return clienteRepository
                .findByApellidosAndNombre(apellidos,nombre)
                .stream()
                .map(this::fromClienteToClienteDto)
                .collect(Collectors.toList());
    }

    public  List<ClienteDto> buscarClientePaisTarjetaEstado(String pais){
        return clienteRepository
                .findClienteByPaisIsNotContainingIgnoreCaseAndAndTarjetas_estadoIsFalse(pais)
                .stream()
                .map(this::fromClienteToClienteDto)
                .collect(Collectors.toList());
    }

    private ClienteDto fromClienteToClienteDto(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }




}
