package com.pfcti.Clase2.beans;

import com.pfcti.Clase2.dto.ClienteDto;
import com.pfcti.Clase2.dto.ClienteQueryDto;
import com.pfcti.Clase2.dto.enums.ClienteQueryType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AdminiatradorClientesAsBeanTest {

    @Autowired
    private AdministradorClientes defaultNombres;

    @Autowired
    @Qualifier("defaultNombres")
    private AdministradorClientes administradorClientes;
    @Test
    void obtenerListaClientesPorCriterio() {
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setClienteQueryType(ClienteQueryType.NOMBRES);
        clienteQueryDto.setTextoBusqueda("ROBERTO");

        List<ClienteDto> clienteDtos = defaultNombres.obtenerListaClientesPorCriterio(clienteQueryDto);
        System.out.println("<<<<<<<<<<<<<<<<<Clientes Perez>>>>>>>>>>>>>>>>>>>>");
        clienteDtos.forEach(cliente -> System.out.println("Cliente: " + cliente.getApellidos()));
        assertTrue(clienteDtos.size() == 1);
    }


    @Test
    void obtenerListaClientesPorCriterioConAnotacion() {
        ClienteQueryDto clienteQueryDto = new ClienteQueryDto();
        clienteQueryDto.setClienteQueryType(ClienteQueryType.NOMBRES);
        clienteQueryDto.setTextoBusqueda("ROBERTO");

        List<ClienteDto> clienteDtos = administradorClientes.obtenerListaClientesPorCriterio(clienteQueryDto);
        System.out.println("<<<<<<<<<<<<<<<<<Clientes Perez>>>>>>>>>>>>>>>>>>>>");
        clienteDtos.forEach(cliente -> System.out.println("Cliente: " + cliente.getApellidos()));
        assertTrue(clienteDtos.size() == 1);
    }

}
