package com.pfcti.Clase2.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdministradorClientesScopeTest {

    @Autowired
    @Qualifier("defaultNombres")
    private AdministradorClientes prototype1;

    @Autowired
    @Qualifier("defaultNombres")
    private AdministradorClientes prototype2;

    @Autowired
    @Qualifier("defaultNombres")
    private AdministradorClientes prototype3;

    @Autowired
    @Qualifier("defaultNombresSingleton")
    private AdministradorClientes singleton1;

    @Autowired
    @Qualifier("defaultNombresSingleton")
    private AdministradorClientes singleton2;

    @Autowired
    @Qualifier("defaultNombresSingleton")
    private AdministradorClientes singleton3;

    @Test
    void instacia(){
        System.out.println("Singleton 1  " + singleton1);
        System.out.println("Singleton 2  " + singleton2);
        System.out.println("Singleton 3  " + singleton3);
        System.out.println("Prototype 1  " + prototype1);
        System.out.println("Protorype 2  " + prototype2);
        System.out.println("Protorype 2  " + prototype3);
        Assertions.assertEquals(1,1);
    }
}
