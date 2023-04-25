package com.pfcti.Clase2.beans;

import com.pfcti.Clase2.dto.ClienteDto;
import com.pfcti.Clase2.dto.ClienteQueryDto;
import com.pfcti.Clase2.dto.enums.ClienteQueryType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BuscadorClientesBddTest {

    @Autowired
    private BuscadorClientes baseDatos;

    @Autowired
    @Qualifier("baseDatos")
    private BuscadorClientes buscadorClientesBaseDatos;

    @Autowired
    @Qualifier("sistemaExterno")
    private BuscadorClientes buscadorClientes;
    @Test
    void obtenerListaCliente() {
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setClienteQueryType(ClienteQueryType.NOMBRES);
        clienteQueryDto.setTextoBusqueda("ROBERTO");

        List<ClienteDto> clienteDtos = baseDatos.obtenerListaCliente(clienteQueryDto);
        System.out.println("<<<<<<<<<<<<<<<<<Clientes Perez>>>>>>>>>>>>>>>>>>>>");
        clienteDtos.forEach(cliente -> System.out.println("Cliente: " + cliente.getApellidos()));
        assertTrue(clienteDtos.size() == 1);

    }

    @Test
    void obtenerListaClientesBDDConQualifier() {
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setTextoBusqueda("ROBERTO");
        clienteQueryDto.setClienteQueryType(ClienteQueryType.NOMBRES);
        List<ClienteDto> clienteDtos = buscadorClientesBaseDatos.obtenerListaCliente(clienteQueryDto);
        clienteDtos.forEach(clienteDto -> {System.out.println("Cliente: " +clienteDto.getApellidos());});
        assertTrue(clienteDtos.size() == 1);
    }

    @Test
    void obtenerListaClientesSistemaExterno() {
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setTextoBusqueda("ROBERTO");
        clienteQueryDto.setClienteQueryType(ClienteQueryType.NOMBRES);
        List<ClienteDto> clienteDtos = buscadorClientes.obtenerListaCliente(clienteQueryDto);
        clienteDtos.forEach(clienteDto -> {System.out.println("Cliente: " +clienteDto.getApellidos());});
        assertTrue(clienteDtos.size() == 0);
    }


}