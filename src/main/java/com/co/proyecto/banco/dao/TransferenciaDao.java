package com.co.proyecto.banco.dao;

import org.springframework.data.repository.CrudRepository;
import com.co.proyecto.banco.modelo.Transferencia;

public interface TransferenciaDao extends CrudRepository<Transferencia, Long>{
    
}
