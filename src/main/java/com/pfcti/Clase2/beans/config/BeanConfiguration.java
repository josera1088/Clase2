package com.pfcti.Clase2.beans.config;

import com.pfcti.Clase2.beans.AdministradorClientes;
import com.pfcti.Clase2.dto.enums.ClienteQueryType;
import com.pfcti.Clase2.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class BeanConfiguration {
    @Autowired
    private ClienteRepository clienteRepository;

    @Bean({"defaultCedula", "criterioCedula"})
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public AdministradorClientes administradorClientes(){
        return  new AdministradorClientes(clienteRepository, ClienteQueryType.CEDULA);
    }

    @Bean({"defaultNombres"})
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @Lazy
    public AdministradorClientes administradorClientesByNombre(){
        return  new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }

    @Bean({"defaultNombresSingleton"})
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    @Lazy
    public AdministradorClientes administradorClientesByNombreSingleton(){
        return  new AdministradorClientes(clienteRepository, ClienteQueryType.NOMBRES);
    }

}
