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

    private CuentaDto fromCuentaToCuentaDto(Cuenta cuenta) {
        CuentaDto cuentaDto = new CuentaDto();
        BeanUtils.copyProperties(cuenta, cuentaDto);
        return cuentaDto;
    }





}
