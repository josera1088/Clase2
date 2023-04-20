package com.pfcti.Clase2.service;

import com.pfcti.Clase2.repository.InversionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class InversionService {
    private InversionRepository inversionRepository;
}
