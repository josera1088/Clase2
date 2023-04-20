package com.pfcti.Clase2.repository;

import com.pfcti.Clase2.model.Cuenta;
import com.pfcti.Clase2.model.Inversion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InversionRepository extends JpaRepository<Inversion, Integer> {
}
