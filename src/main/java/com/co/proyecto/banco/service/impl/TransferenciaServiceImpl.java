package com.co.proyecto.banco.service.impl;

import com.co.proyecto.banco.commons.GenericServiceImpl;
import com.co.proyecto.banco.dao.TransferenciaDao;
import com.co.proyecto.banco.modelo.Transferencia;
import com.co.proyecto.banco.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class TransferenciaServiceImpl extends GenericServiceImpl<Transferencia, Long> implements TransferenciaService{

    @Autowired
    TransferenciaDao transferenciaDao;
    
    @Override
    public CrudRepository<Transferencia, Long> getDao() {
        return transferenciaDao;
    }
    
}
