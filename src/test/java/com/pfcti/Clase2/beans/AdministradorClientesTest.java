package com.pfcti.Clase2.beans;

import com.pfcti.Clase2.dto.ClienteDto;
import com.pfcti.Clase2.dto.ClienteQueryDto;
import com.pfcti.Clase2.dto.enums.ClienteQueryType;
import com.pfcti.Clase2.repository.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AdministradorClientesTest {

    @Autowired
    ClienteRepository clienteRepository;
    @Test
    void obtenerListaClientesPorCriterio() {
       AdministradorClientes administradorClientes = new AdministradorClientes(clienteRepository,ClienteQueryType.NOMBRES);
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setClienteQueryType(ClienteQueryType.NOMBRES);
        clienteQueryDto.setTextoBusqueda("ROBERTO");

        List<ClienteDto> clienteDtos = administradorClientes.obtenerListaClientesPorCriterio(clienteQueryDto);
        System.out.println("<<<<<<<<<<<<<<<<<Clientes Perez>>>>>>>>>>>>>>>>>>>>");
        clienteDtos.forEach(cliente -> System.out.println("Cliente: " + cliente.getApellidos()));
        assertTrue(clienteDtos.size() == 1);
    }
}