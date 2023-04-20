package com.pfcti.Clase2.repository;

import com.pfcti.Clase2.model.Cliente;
import com.pfcti.Clase2.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
