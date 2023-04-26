package com.pfcti.Clase2.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@Data
public class ClienteDto {

    private int id;
    @NotNull
    @Size(max = 10)
    private  String nombre;
    private  String apellidos;
    @NotNull
    @Size(max = 10)
    private  String cedula;
    private  String telefono;
    private List<DireccionDto> direcciones;
    private List<CuentaDto> cuentas;
    private  String pais;
}
