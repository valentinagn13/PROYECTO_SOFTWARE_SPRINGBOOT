package com.vehiculos.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("HIBRIDO")
public class Hibrido extends Vehiculo {
    private double eficienciaEnergetica; // km/l o equivalente
    private String modoActual = "hibrido"; // "electrico" | "combustion" | "hibrido"
    
    public Hibrido() {
    }
    
    public Hibrido(String marca, String modelo, int anio, double velocidadMaxima, double eficienciaEnergetica) {
        super(marca, modelo, anio, velocidadMaxima);
        this.eficienciaEnergetica = eficienciaEnergetica;
    }
    
    // Getters y Setters
    public double getEficienciaEnergetica() {
        return eficienciaEnergetica;
    }
    
    public void setEficienciaEnergetica(double eficienciaEnergetica) {
        this.eficienciaEnergetica = eficienciaEnergetica;
    }
    
    public String getModoActual() {
        return modoActual;
    }
    
    public void setModoActual(String modoActual) {
        this.modoActual = modoActual;
    }
    
    // Métodos específicos
    public void cambiarModo(String nuevoModo) {
        modoActual = nuevoModo;
        System.out.println(getMarca() + " " + getModelo() + " cambió a modo: " + modoActual);
    }
    
    public void activarPilotoAutomatico() {
        System.out.println(getMarca() + " " + getModelo() + " -> piloto automático activado.");
    }
    
    public void desactivarPilotoAutomatico() {
        System.out.println(getMarca() + " " + getModelo() + " -> piloto automático desactivado.");
    }
    
    public void conducir() {
        System.out.println(getMarca() + " " + getModelo() + " se conduce manualmente (modo: " + modoActual + ").");
    }
}