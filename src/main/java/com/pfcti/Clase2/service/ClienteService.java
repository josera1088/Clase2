package com.pfcti.Clase2.service;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.pfcti.Clase2.dto.ClienteDto;
import com.pfcti.Clase2.model.Cliente;
import com.pfcti.Clase2.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;

    public  void insertatCliente(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellidos(clienteDto.getApellidos());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());
        clienteRepository.save(cliente);
    }

    public  ClienteDto obtenerCliente(int id){
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

        return  clienteDto;
    }


    public void actualizarCliente(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setId(cliente.getId());
        cliente.setNombre(clienteDto.getNombre());
        cliente.setApellidos(clienteDto.getApellidos());
        cliente.setCedula(clienteDto.getCedula());
        cliente.setTelefono(clienteDto.getTelefono());
        clienteRepository.save(cliente);
    }

    public List<Cliente> obtnerClientes(){
        return clienteRepository.findAll();
    }
}
