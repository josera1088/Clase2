package com.pfcti.Clase2.jms;

import com.pfcti.Clase2.dto.CuentaDto;
import com.pfcti.Clase2.service.CuentaService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class NotificationSenderTest {
    @Autowired
    private CuentaService cuentaService;

    @Test
    void crearCuentaYNotificar() {
        CuentaDto cuentaDto = new CuentaDto();
        cuentaDto.setEstado(true);
        cuentaDto.setNumero("4788987255");
        cuentaDto.setTipo("AHO");
        cuentaDto.setClienteid(1);
        this.cuentaService.creacionDeCuenta(cuentaDto);
    }

    @Test
    void crearCuentaPubSub() {
        CuentaDto cuentaDto = new CuentaDto();
        cuentaDto.setEstado(true);
        cuentaDto.setNumero("4788987255");
        cuentaDto.setTipo("AHO");
        cuentaDto.setClienteid(1);
        cuentaService.creacionDeCuentaPublishSub(cuentaDto);
    }
}
