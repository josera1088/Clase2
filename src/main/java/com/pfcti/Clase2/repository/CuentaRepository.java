package com.pfcti.Clase2.repository;

import com.pfcti.Clase2.model.Cuenta;
import com.pfcti.Clase2.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer> {
}
