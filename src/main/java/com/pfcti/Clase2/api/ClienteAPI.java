package com.pfcti.Clase2.api;

import com.pfcti.Clase2.dto.ClienteDto;
import com.pfcti.Clase2.service.ClienteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1/api/cliente")
public class ClienteAPI {
    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/all")
    public List<ClienteDto> buscarTodosClientes() {
        return clienteService.obtnerClientes();
    }

    @GetMapping("/{id}")
    public ClienteDto buscarCliente(@PathVariable int id) {
        log.info("Busqueda de cliente : {}", id);
        return clienteService.obtenerCliente(id);
    }

    @GetMapping(value = "/xml/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ClienteDto buscarClienteXml(@PathVariable int id) {
        log.info("Busqueda de cliente : {}", id);
        return clienteService.obtenerCliente(id);
    }

    @GetMapping(value = "/xml/json/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ClienteDto buscarClienteXmlJson(@PathVariable int id) {
        log.info("Busqueda de cliente : {}", id);
        return clienteService.obtenerCliente(id);
    }

    @GetMapping(value = "/parameter")
    public ClienteDto buscarClienteParameter(@RequestParam int id) {
        log.info("Busqueda de cliente : {}", id);
        return clienteService.obtenerCliente(id);
    }

    @PostMapping
    public void guardarCliente(@Valid @RequestBody ClienteDto clienteDto){
        log.info("cliente de cliente : {}", clienteDto);
        clienteService.insertatCliente(clienteDto); }

    @PutMapping
    public void actualizarCliente(@RequestBody ClienteDto clienteDto){
        log.info("cliente de cliente : {}", clienteDto);
        clienteService.actualizarCliente(clienteDto); }

    @DeleteMapping(value = "/{id}")
    public void eliminarCliente(@PathVariable int id){
        log.info("cliente de cliente : {}", id);
        clienteService.eliminarCliente(id); }

}

