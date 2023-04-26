package com.pfcti.Clase2.service;

import com.pfcti.Clase2.criteria.CuentaSpecification;
import com.pfcti.Clase2.dto.ClienteDto;
import com.pfcti.Clase2.dto.CuentaDto;
import com.pfcti.Clase2.model.Cliente;
import com.pfcti.Clase2.model.Cuenta;
import com.pfcti.Clase2.repository.ClienteRepository;
import com.pfcti.Clase2.repository.CuentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CuentaService {
    private CuentaRepository cuentaRepository;
    private CuentaSpecification cuentaSpecification;

    public List<CuentaDto> busquedaDinamicamentePorCriterios(CuentaDto cuentaDtoFilter){
        return cuentaRepository.findAll(cuentaSpecification.builFilter(cuentaDtoFilter))
                .stream()
                .map(this::fromCuentaToCuentaDto)
                .collect(Collectors.toList());
    }
    public  List<CuentaDto> BuscarCuentaCliente(int cliente_id){
        List<CuentaDto> cuentaDtos = new ArrayList<>();
        List<Cuenta> cuentas = new ArrayList<>();
        cuentas = cuentaRepository.findCuentaByCliente_Id(cliente_id);
        cuentas.forEach(cuenta -> {
            cuentaDtos.add(fromCuentaToCuentaDto(cuenta));
        });

        return cuentaDtos;
    }
    public void insertarCuenta(CuentaDto cuentaDto) {
        Cuenta cuenta = new Cuenta();
        Cliente cliente = new Cliente();
        cliente.setId(cuentaDto.getClienteid());
        cuenta.setCliente(cliente);
        cuenta.setEstado(cuentaDto.getEstado());
        cuenta.setTipo(cuentaDto.getTipo());
        cuenta.setNumero(cuentaDto.getNumero());
        cuentaRepository.save(cuenta);
    }
    public void actualizarCuenta(CuentaDto cuentaDto){
        Cuenta cuenta = cuentaRepository.findById(cuentaDto.getId())
                .orElseThrow(() -> {
                            throw new RuntimeException("NO Existe el cliente");
                        }
                );
        cuenta.setId (cuentaDto.getId());
        cuenta.setEstado(cuentaDto.getEstado());
        cuentaRepository.save(cuenta);
    }
    public List<CuentaDto> obtnerCuentas() {
        List<CuentaDto> cuentaDtos = new ArrayList<>();
        List<Cuenta> cuentas = cuentaRepository.findAll();
        cuentas.forEach(cliente -> {
            cuentaDtos.add(fromCuentaToCuentaDto(cliente));
        });

        return cuentaDtos;
    }
    private CuentaDto fromCuentaToCuentaDto(Cuenta cuenta) {
        CuentaDto cuentaDto = new CuentaDto();
        BeanUtils.copyProperties(cuenta, cuentaDto);
        return cuentaDto;
    }

}
