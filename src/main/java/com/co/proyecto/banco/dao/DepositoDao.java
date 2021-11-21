package com.co.proyecto.banco.dao;

import org.springframework.data.repository.CrudRepository;
import com.co.proyecto.banco.modelo.Deposito;

public interface DepositoDao extends CrudRepository<Deposito, Long>{
    
}
