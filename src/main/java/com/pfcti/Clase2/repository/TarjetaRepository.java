package com.pfcti.Clase2.repository;

import com.pfcti.Clase2.model.Cuenta;
import com.pfcti.Clase2.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarjetaRepository extends JpaRepository<Tarjeta, Integer> {
    void deleteAllByCliente_Id(int cliente_Id);
}
