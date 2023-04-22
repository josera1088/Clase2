package com.pfcti.Clase2.repository;

import com.pfcti.Clase2.model.Cuenta;
import com.pfcti.Clase2.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>, JpaSpecificationExecutor<Cuenta> {
    void deleteAllByCliente_Id(int cliente_Id);
}
