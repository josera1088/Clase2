package com.pfcti.Clase2.service;

import com.pfcti.Clase2.repository.ClienteRepository;
import com.pfcti.Clase2.repository.CuentaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CuentaService {
    private CuentaRepository cuentaRepository;
}
