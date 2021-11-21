package com.co.proyecto.banco.service.impl;

import com.co.proyecto.banco.commons.GenericServiceImpl;
import com.co.proyecto.banco.dao.DepositoDao;
import com.co.proyecto.banco.modelo.Deposito;
import com.co.proyecto.banco.service.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Service;

@Service
public class DepositoServiceImpl extends GenericServiceImpl<Deposito, Long> implements DepositoService{

    @Autowired
    DepositoDao depositoDao;
    
    @Override
    public CrudRepository<Deposito, Long> getDao() {
        return depositoDao;
    }
    
}
