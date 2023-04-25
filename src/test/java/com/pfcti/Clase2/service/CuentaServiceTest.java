package com.pfcti.Clase2.service;

import com.pfcti.Clase2.dto.ClienteDto;
import com.pfcti.Clase2.dto.CuentaDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CuentaServiceTest {

    @Autowired
    private CuentaService cuentaService;
    @Test
    void busquedaDinamicamentePorCriterios() {
    CuentaDto cuentaDto = new CuentaDto();
    cuentaDto.setEstado(true);
        List<CuentaDto> cuentaDtos = cuentaService.busquedaDinamicamentePorCriterios(cuentaDto);
        assertFalse(cuentaDtos.isEmpty());
        System.out.println("<<<<<<<<<<<<<<<<<Clientes>>>>>>>>>>>>>>>>>>>>");
        cuentaDtos.forEach(cliente -> System.out.println("Cliente: " + cliente.getNumero()));
        assertTrue(cuentaDtos.size() > 1);
    }
}