package com.co.proyecto.banco.controller;

import com.co.proyecto.banco.modelo.Cliente;
import com.co.proyecto.banco.modelo.Retiro;
import com.co.proyecto.banco.modelo.Transferencia;
import com.co.proyecto.banco.service.ClienteService;
import com.co.proyecto.banco.service.TransferenciaService;
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
@RequestMapping("/transferencia")
public class TransferenciaController {
    
    @Autowired
    TransferenciaService transferenciaService;
    
    @Autowired
    ClienteService clienteService;
    
    @PostMapping()
    public ResponseEntity<Transferencia> save(@RequestBody Transferencia transferencia) {
         List<Cliente> clientes = clienteService.getAll();
         Cliente clienteTranferencia = new Cliente();
         Cliente cliente = clienteService.get(transferencia.getIdCliente());
         for(int i = 0; i < clientes.size(); i++) {
             if(clientes.get(i).getNumeroCuenta() == transferencia.getNumeroCuenta()) {
                 clienteTranferencia = clienteService.get(clientes.get(i).getIdCliente());
             }
         }
      if(cliente.getMonto() > transferencia.getMontoTranferencia()) {
          cliente.setMonto(cliente.getMonto() - transferencia.getMontoTranferencia());
          clienteTranferencia.setMonto(clienteTranferencia.getMonto() + transferencia.getMontoTranferencia());
          clienteService.save(cliente);
          clienteService.save(clienteTranferencia);
          Transferencia transferenciaNew = transferenciaService.save(transferencia);
          return ResponseEntity.ok(transferenciaNew);
      }
      return (ResponseEntity<Transferencia>) ResponseEntity.status(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping
    public List<Transferencia> getAll() {
       return transferenciaService.getAll();
    }
    
    @GetMapping("/{id}")
    public Transferencia find(@PathVariable Long id) {
        return transferenciaService.get(id);
    }
    
    @GetMapping("/eliminartransferencia/{id}")
    public ResponseEntity<Transferencia> delete(@PathVariable Long id) {
        Transferencia transferencia = transferenciaService.get(id);
        if(transferencia != null) {
            transferenciaService.delete(id);
    } else {
            return new ResponseEntity<Transferencia>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Transferencia>(transferencia, HttpStatus.OK);
    }
}
