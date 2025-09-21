package com.vehiculos.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("COMBUSTION")
public class Combustion extends Vehiculo {
    private double capacidadTanque; // litros
    
    public Combustion() {
    }
    
    public Combustion(String marca, String modelo, int anio, double velocidadMaxima, double capacidadTanque) {
        super(marca, modelo, anio, velocidadMaxima);
        this.capacidadTanque = capacidadTanque;
    }
    
    // Getters y Setters
    public double getCapacidadTanque() {
        return capacidadTanque;
    }
    
    public void setCapacidadTanque(double capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
    }
    
    // Métodos específicos
    public void repostar(double litros) {
        if (litros > capacidadTanque) {
            System.out.println(getMarca() + " " + getModelo() + " no puede repostar más que la capacidad del tanque (" + capacidadTanque + "L).");
            litros = capacidadTanque;
        }
        System.out.println(getMarca() + " " + getModelo() + " repostando " + litros + " litros (tanque: " + capacidadTanque + "L).");
    }
    
    public void conducir() {
        System.out.println(getMarca() + " " + getModelo() + " se conduce manualmente (combustión).");
    }
}