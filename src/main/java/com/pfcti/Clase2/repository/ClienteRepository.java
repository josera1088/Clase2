package com.pfcti.Clase2.repository;

import com.pfcti.Clase2.model.Cliente;
import com.pfcti.Clase2.model.Cuenta;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    List<Cliente> findClientesByPaisAndCuentas_EstadoIsTrue(String pais);

    @Query(value = "select c from Cliente c where c.apellidos =:apellidos")
    List<Cliente> buscarPorApellido(String apellidos);


    @Query(value = "select ID, APELLIDOS, CEDULA, NOMBRE, PAIS, TELEFONO from TCLIENTE where apellidos =:apellidos", nativeQuery = true)
    List<Tuple> buscarPorApellidoQueryNativo(String apellidos);

    @Modifying
    @Query(value = "update Cliente c set c.nombre =:nombre where c.apellidos =:apellidos")
    void actualizaClientePorApellido(String nombre, String apellido);

    List<Cliente> findByApellidosAndNombre(String apellidos, String nombre);

    List<Cliente> findClienteByPaisIsNotContainingIgnoreCaseAndAndTarjetas_estadoIsFalse (String pais);



}
