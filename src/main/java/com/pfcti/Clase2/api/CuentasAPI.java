package com.pfcti.Clase2.api;

import com.pfcti.Clase2.dto.ClienteDto;
import com.pfcti.Clase2.dto.CuentaDto;
import com.pfcti.Clase2.service.CuentaService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/cuenta")
public class CuentasAPI {

    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/{id}")
    public List<CuentaDto> buscarCuentaCliente(@PathVariable int id) {
        log.info("Busqueda de cliente : {}", id);
        return cuentaService.BuscarCuentaCliente(id);
    }
    @GetMapping(value = "/all")
    public List<CuentaDto> buscarTodosCuentas(){
        return cuentaService.obtnerCuentas(); }

    @PostMapping
    public void guardarCuenta(@RequestBody CuentaDto cuentaDto){
        log.info("Cuenta a guardar : {}", cuentaDto);
        cuentaService.insertarCuenta(cuentaDto); }

    @PutMapping
    public void actualizarCuenta(@Valid @RequestBody CuentaDto cuentaDto){
        log.info("Cuenta a guardar : {}", cuentaDto);
        cuentaService.actualizarCuenta(cuentaDto); }
}
