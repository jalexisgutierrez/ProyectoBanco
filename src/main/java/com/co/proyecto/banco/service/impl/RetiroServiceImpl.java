package com.co.proyecto.banco.service.impl;

import com.co.proyecto.banco.commons.GenericServiceImpl;
import com.co.proyecto.banco.dao.RetiroDao;
import com.co.proyecto.banco.modelo.Retiro;
import com.co.proyecto.banco.service.RetiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RetiroServiceImpl extends GenericServiceImpl<Retiro, Long> implements RetiroService{

    @Autowired
    RetiroDao retiroDao;
    
    @Override
    public CrudRepository<Retiro, Long> getDao() {
        return retiroDao;
    }
    
}
