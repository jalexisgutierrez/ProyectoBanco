package com.co.proyecto.banco.modelo;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    
    @NotEmpty
    private String nombres;
    
    @NotEmpty
    @Email
    private String correo;
    
    @NotEmpty
    private String contrasena;
    
    @NotNull
    private String identificacion;
    
    @NotNull
    private int numeroCuenta;
    
    @NotNull
    private double monto;
}
