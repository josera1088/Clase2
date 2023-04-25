package com.pfcti.Clase2.beans;

import com.pfcti.Clase2.dto.ClienteDto;
import com.pfcti.Clase2.dto.ClienteQueryDto;
import com.pfcti.Clase2.dto.enums.ClienteQueryType;
import com.pfcti.Clase2.model.Cliente;
import com.pfcti.Clase2.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class AdministradorClientes {
    private ClienteRepository clienteRepository;

    private ClienteQueryType defaultClienteQueryType;

    public AdministradorClientes(ClienteRepository clienteRepository, ClienteQueryType defaultClienteQueryType) {
        System.out.println(">>>>> AdministradorClientes INSTANCIA: " + this);
        this.clienteRepository = clienteRepository;
        this.defaultClienteQueryType = defaultClienteQueryType;
    }

    public AdministradorClientes(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDto> obtenerListaClientesPorCriterio(ClienteQueryDto clienteQueryDto){
    List<Cliente> clientes = null;
    if (ClienteQueryType.CEDULA.equals(clienteQueryDto.getClienteQueryType())) {
        clientes = clienteRepository.findClientesByCedula(clienteQueryDto.getTextoBusqueda());
    } else if (ClienteQueryType.NOMBRES.equals(clienteQueryDto.getClienteQueryType())) {
        clientes = clienteRepository.findClientesByNombreContainingIgnoreCaseOrApellidosContainingIgnoreCase(clienteQueryDto.getTextoBusqueda(), clienteQueryDto.getTextoBusqueda());
    }

        return clientes.stream()
                .map(this::fromClienteToClienteDto)
                .collect(Collectors.toList());
    }

    private ClienteDto fromClienteToClienteDto(Cliente cliente) {
        ClienteDto clienteDto = new ClienteDto();
        BeanUtils.copyProperties(cliente, clienteDto);
        return clienteDto;
    }
}
