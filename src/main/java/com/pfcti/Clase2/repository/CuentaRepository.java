package com.pfcti.Clase2.repository;

import com.pfcti.Clase2.dto.CuentaDto;
import com.pfcti.Clase2.model.Cliente;
import com.pfcti.Clase2.model.Cuenta;
import com.pfcti.Clase2.model.Direccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>, JpaSpecificationExecutor<Cuenta> {
    void deleteAllByCliente_Id(int cliente_Id);
    List<Cuenta> findCuentaByCliente_Id(int cliente_Id );


}
