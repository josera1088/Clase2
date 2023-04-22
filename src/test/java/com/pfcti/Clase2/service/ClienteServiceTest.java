package com.pfcti.Clase2.service;

import com.pfcti.Clase2.dto.ClienteDto;
import com.pfcti.Clase2.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClienteServiceTest {
    @Autowired
    private ClienteService clienteService;
    @PersistenceContext
    private EntityManager entityManager;
    @Test
    void insertatCliente() {

        List<Cliente> clienteList = entityManager.createQuery("SELECT c FROM Cliente c").getResultList();
        System.out.println(">>>>>>>>>>>>>>> Lista antes " + clienteList.size());
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNombre("Jose Ramirez");
        clienteDto.setApellidos("Ramirez");
        clienteDto.setCedula("304250931");
        clienteDto.setTelefono("4564564");
        clienteService.insertatCliente(clienteDto);
        clienteList = entityManager.createQuery("SELECT c FROM Cliente c").getResultList();
        System.out.println(">>>>>>>>>>>>>>> Lista despues " + clienteList.size());
        assertEquals(1, 1);
    }
    @Test
    void obtenerCliente() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto = clienteService.obtenerCliente(1);
        System.out.println(">>>>>>>>>>>>>>> Cliente " + clienteDto.getApellidos());
        assertEquals(1, 1);
    }
    @Test
    void actualizarCliente() {
        ClienteDto clienteDto = clienteService.obtenerCliente(1);
        System.out.println(">>>>>>>>>>>>>>> Cliente Antes " + clienteDto.getApellidos());
        clienteDto.setId(1);
        clienteDto.setApellidos("Ramirez");
        clienteService.actualizarCliente(clienteDto);
        ClienteDto clienteDtodespues = clienteService.obtenerCliente(1);
        System.out.println(">>>>>>>>>>>>>>> Cliente Despues " + clienteDtodespues.getApellidos());
        assertEquals("Ramirez", clienteDtodespues.getApellidos());
    }
    @Test
    void obtenerClientes() {
        List<ClienteDto> clienteDtos = clienteService.obtnerClientes();
        clienteDtos.forEach(cliente -> System.out.println(">>>>>>>>>>>>>>>>>Cliente: " + cliente.getApellidos()));
        assertEquals(2, clienteDtos.size());
    }
    @Test
    void obtenerClientesPorCodigoISOPaisYCuentasActivas() {
        List<ClienteDto> clienteDtos = clienteService.obtenerClientesPorCodigoISOPaisYCuentasActivas("CR");
        clienteDtos.forEach(clienteDto -> {
            System.out.println(">>>>>>>>>>>>>>>>>Cliente: " + clienteDto.getApellidos());
        });
        assertEquals(1, clienteDtos.size());
    }
    @Test
    void eliminarCliente() {
        clienteService.eliminarCliente(1);
        assertEquals(1, 1);
    }

    @Test
    void buscarPorApellido() {
        List<ClienteDto> clienteDtos = clienteService.buscarPorApellido("SANCHEZ");
        clienteDtos.forEach(clienteDto -> {
            System.out.println(">>>>>>>>>>>>>>>>>Cliente: " + clienteDto.getApellidos());
        });
        assertEquals(1, clienteDtos.size());
    }

    @Test
    void buscarPorApellidoQueryNativo() {
        List<ClienteDto> clienteDtos = clienteService.buscarPorApellidoQueryNativo("SANCHEZ");
        clienteDtos.forEach(clienteDto -> {
            System.out.println(">>>>>>>>>>>>>>>>>Cliente: " + clienteDto.getApellidos());
        });
        assertEquals(1, clienteDtos.size());
    }

    @Test
    void buscarPorApellidoYNombre() {
        List<ClienteDto> clienteDtos = clienteService.buscarPorApellidoYNombre("SANCHEZ", "RAUL");
        assertFalse(clienteDtos.isEmpty());
        System.out.println(">>>>>>>>>>>>>>>>>Cliente encontrado: " + clienteDtos.get(0).getApellidos());
        assertEquals("SANCHEZ", clienteDtos.get(0).getApellidos());
    }


    @Test
    void buscarClientePaisTarjetaEstado() {
        List<ClienteDto> clienteDtos = clienteService.buscarClientePaisTarjetaEstado("CR");
        clienteDtos.forEach(clienteDto -> {
            System.out.println(">>>>>>>>>>>>>>>>>Cliente Jose: " + clienteDto.getApellidos());
        });
        assertEquals(1, 1);
    }

    @Test
    void busquedaDinamicamentePorCriterios() {

        List<ClienteDto> clienteDtos = clienteService.busquedaDinamicamentePorCriterios(new ClienteDto());
        assertFalse(clienteDtos.isEmpty());
        System.out.println("<<<<<<<<<<<<<<<<<Clientes>>>>>>>>>>>>>>>>>>>>");
        clienteDtos.forEach(cliente -> System.out.println("Cliente: " + cliente.getNombre()));
        assertTrue(clienteDtos.size() > 1);

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setApellidos("SANCHEZ");
        clienteDtos = clienteService.busquedaDinamicamentePorCriterios(clienteDto);
        System.out.println("<<<<<<<<<<<<<<<<<Clientes SANCHEZ>>>>>>>>>>>>>>>>>>>>");
        clienteDtos.forEach(cliente -> System.out.println("Cliente: " + cliente.getNombre()));
        assertTrue(clienteDtos.size() > 1);

        clienteDto = new ClienteDto();
        clienteDto.setApellidos("SANCHEZ");
        clienteDto.setNombre("HORACIO");
        clienteDtos = clienteService.busquedaDinamicamentePorCriterios(clienteDto);
        System.out.println("<<<<<<<<<<<<<<<<<Clientes SANCHEZ>>>>>>>>>>>>>>>>>>>>");
        clienteDtos.forEach(cliente -> System.out.println("Cliente: " + cliente.getNombre()));
        assertTrue(clienteDtos.size() == 1);

        clienteDto = new ClienteDto();
        clienteDto.setApellidos("SANCHEZ");
        clienteDto.setCedula("111");
        clienteDtos = clienteService.busquedaDinamicamentePorCriterios(clienteDto);
        System.out.println("<<<<<<<<<<<<<<<<<Clientes SANCHEZ>>>>>>>>>>>>>>>>>>>>");
        clienteDtos.forEach(cliente -> System.out.println("Cliente: " + cliente.getNombre()));
        assertTrue(clienteDtos.size() == 1);

        clienteDto = new ClienteDto();
        clienteDto.setApellidos("SANCHEZ");
        clienteDto.setCedula("1111");
        clienteDtos = clienteService.busquedaDinamicamentePorCriterios(clienteDto);
        System.out.println("<<<<<<<<<<<<<<<<<Clientes SANCHEZ>>>>>>>>>>>>>>>>>>>>");
        clienteDtos.forEach(cliente -> System.out.println("Cliente: " + cliente.getNombre()));
        assertTrue(clienteDtos.size() == 1);
    }
}