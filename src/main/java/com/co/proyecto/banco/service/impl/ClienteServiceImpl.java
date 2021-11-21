package com.co.proyecto.banco.service.impl;

import com.co.proyecto.banco.commons.GenericServiceImpl;
import com.co.proyecto.banco.modelo.Cliente;
import com.co.proyecto.banco.service.ClienteService;
import org.springframework.data.repository.CrudRepository;
import com.co.proyecto.banco.dao.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Integer> implements ClienteService{

    @Autowired
    private ClienteDao clienteDao;
    
    @Override
    public CrudRepository<Cliente, Integer> getDao() {
        return clienteDao;
    }
    
}
