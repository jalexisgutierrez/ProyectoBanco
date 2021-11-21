package com.co.proyecto.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.co.proyecto.banco.modelo.Cliente;
import com.co.proyecto.banco.service.ClienteService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;
    
    @PostMapping()
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente) {
        if(cliente.getContrasena().matches("[0-9a-zA-Z]*")){
        cliente.setMonto(1000000d);
        cliente.setNumeroCuenta((int) (Math.random()*(1000000000+1)));
        Cliente clienteNew = clienteService.save(cliente);
       return ResponseEntity.ok(clienteNew);
        }
        return (ResponseEntity<Cliente>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/login")
    public boolean login(@RequestBody Cliente cliente){
        boolean login = false;
        List<Cliente> clientes = clienteService.getAll();
        for(int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getCorreo().equalsIgnoreCase(cliente.getCorreo()) && clientes.get(i).getContrasena().equals(cliente.getContrasena())) {
                login = true;
            }
        }
        return login;
    }
    
    @GetMapping
    public List<Cliente> getAll() {
       return clienteService.getAll();
    }
    
    @GetMapping("/{id}")
    public Cliente find(@PathVariable int id) {
        return clienteService.get(id);
    }
    
    @GetMapping("/eliminarcliente/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable int id) {
        Cliente cliente = clienteService.get(id);
        if(cliente != null) {
        clienteService.delete(id);
    } else {
            return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
    }
}
