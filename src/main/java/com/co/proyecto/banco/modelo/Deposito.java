package com.co.proyecto.banco.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "deposito")
public class Deposito {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeposito;
    
    private double montoDeposito;
    
    private int idCliente;
}
