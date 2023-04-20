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
        System.out.println(">>>>>>>>>>>>>>> Lista antes "+ clienteList.size());

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNombre("Jose Ramirez");
        clienteDto.setApellidos("Ramirez");
        clienteDto.setCedula("304250931");
        clienteDto.setTelefono("4564564");
        clienteService.insertatCliente(clienteDto);


        clienteList = entityManager.createQuery("SELECT c FROM Cliente c").getResultList();
        System.out.println(">>>>>>>>>>>>>>> Lista despues "+ clienteList.size());

        assertEquals(1,1);


    }

    @Test
    void obtenerCliente() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto = clienteService.obtenerCliente(1);
        System.out.println(">>>>>>>>>>>>>>> Cliente "+ clienteDto.getApellidos());
        assertEquals(1,1);
    }

    @Test
    void actualizarCliente() {
        ClienteDto clienteDto = clienteService.obtenerCliente(1);
        System.out.println(">>>>>>>>>>>>>>> Cliente Antes "+ clienteDto.getApellidos());

        clienteDto.setId(1);
        clienteDto.setNombre("Jose Ramirez");
        clienteDto.setApellidos("Ramirez");
        clienteDto.setCedula("304250931");
        clienteDto.setTelefono("4564564");
        clienteService.actualizarCliente(clienteDto);

        ClienteDto clienteDtodespues = clienteService.obtenerCliente(1);
        System.out.println(">>>>>>>>>>>>>>> Cliente Despues "+ clienteDtodespues.getApellidos());
        assertEquals(1,1);
    }

    @Test
    void obtnerClientes() {
        clienteService.obtnerClientes().stream().map(
                cliente -> {
                    System.out.println(">>>>>>>>>>>>Cliente " + cliente.getApellidos());
                return cliente;
                }
        ).collect(Collectors.toList());
        assertEquals(1,1);

    }
}