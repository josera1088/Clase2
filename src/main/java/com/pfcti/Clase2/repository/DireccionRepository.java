package com.pfcti.Clase2.repository;

import com.pfcti.Clase2.model.Cuenta;
import com.pfcti.Clase2.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DireccionRepository extends JpaRepository<Direccion, Integer> {
    void deleteAllByCliente_Id(int cliente_Id);
}
