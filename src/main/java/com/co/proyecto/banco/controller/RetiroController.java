package com.co.proyecto.banco.controller;

import com.co.proyecto.banco.modelo.Cliente;
import com.co.proyecto.banco.modelo.Retiro;
import com.co.proyecto.banco.service.ClienteService;
import com.co.proyecto.banco.service.RetiroService;
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
@RequestMapping("/retiro")
public class RetiroController {
    
    @Autowired
    RetiroService retiroService;
    
    @Autowired
    ClienteService clienteService;
    
    @PostMapping()
    public ResponseEntity<Retiro> save(@RequestBody Retiro retiro) {
      Cliente cliente = clienteService.get(retiro.getIdCliente());
      if(cliente.getMonto() > retiro.getMontoRetiro()) {
          cliente.setMonto(cliente.getMonto() - retiro.getMontoRetiro());
          clienteService.save(cliente);
          Retiro retioNew = retiroService.save(retiro);
          return ResponseEntity.ok(retioNew);
      }
      return (ResponseEntity<Retiro>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }
    
     @GetMapping
    public List<Retiro> getAll() {
       return retiroService.getAll();
    }
    
    @GetMapping("/{id}")
    public Retiro find(@PathVariable Long id) {
        return retiroService.get(id);
    }
    
    @GetMapping("/eliminarretiro/{id}")
    public ResponseEntity<Retiro> delete(@PathVariable Long id) {
        Retiro retiro = retiroService.get(id);
        if(retiro != null) {
            retiroService.delete(id);
    } else {
            return new ResponseEntity<Retiro>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Retiro>(retiro, HttpStatus.OK);
    }
}
