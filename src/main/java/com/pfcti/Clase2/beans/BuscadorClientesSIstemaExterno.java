package com.pfcti.Clase2.beans;

import com.pfcti.Clase2.dto.ClienteDto;
import com.pfcti.Clase2.dto.ClienteQueryDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("sistemaExterno")
public class BuscadorClientesSIstemaExterno implements BuscadorClientes{
    @Override
    public List<ClienteDto> obtenerListaCliente(ClienteQueryDto clienteQueryDto) {
        return new ArrayList<>();
    }
}
