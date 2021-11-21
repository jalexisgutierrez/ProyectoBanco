package com.co.proyecto.banco.controller;

import com.co.proyecto.banco.modelo.Cliente;
import com.co.proyecto.banco.modelo.Deposito;
import com.co.proyecto.banco.service.ClienteService;
import com.co.proyecto.banco.service.DepositoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deposito")
public class DepositoController {
    
    @Autowired
    DepositoService depositoService;
    
    @Autowired
    ClienteService clienteService;
    
    @PostMapping()
    public Deposito save(@RequestBody Deposito deposito) {
      Cliente cliente = clienteService.get(deposito.getIdCliente());
      cliente.setMonto(cliente.getMonto() + deposito.getMontoDeposito());
      clienteService.save(cliente);
      return depositoService.save(deposito);
    }
    
     @GetMapping
    public List<Deposito> getAll() {
       return depositoService.getAll();
    }
    
    @GetMapping("/{id}")
    public Deposito find(@PathVariable Long id) {
        return depositoService.get(id);
    }
    
    @GetMapping("/eliminardeposito/{id}")
    public ResponseEntity<Deposito> delete(@PathVariable Long id) {
        Deposito deposito = depositoService.get(id);
        if(deposito != null) {
            depositoService.delete(id);
    } else {
            return new ResponseEntity<Deposito>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Deposito>(deposito, HttpStatus.OK);
    }
}
