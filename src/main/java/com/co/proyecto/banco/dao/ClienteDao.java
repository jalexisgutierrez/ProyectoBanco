package com.co.proyecto.banco.dao;


import com.co.proyecto.banco.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;


public interface ClienteDao extends CrudRepository<Cliente, Integer>{
    
}
