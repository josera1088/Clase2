package com.pfcti.Clase2.dto;

import com.pfcti.Clase2.dto.enums.ClienteQueryType;
import lombok.Data;

@Data
public class ClienteQueryDto {

    private String textoBusqueda;
    private ClienteQueryType clienteQueryType;
}
