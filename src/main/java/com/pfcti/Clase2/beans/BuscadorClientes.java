package com.pfcti.Clase2.beans;

import com.pfcti.Clase2.dto.ClienteDto;
import com.pfcti.Clase2.dto.ClienteQueryDto;

import java.util.List;

public interface BuscadorClientes {
    List<ClienteDto> obtenerListaCliente(ClienteQueryDto clienteQueryDto);
}


