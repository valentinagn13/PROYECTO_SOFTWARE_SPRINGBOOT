package com.vehiculos.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "vehiculo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_vehiculo", discriminatorType = DiscriminatorType.STRING)
public abstract class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private int anio;
    private double velocidadMaxima;
    private double velocidadActual = 0;
    
    // ✅ Este método es virtual, no se guarda en la BD
    @Transient
    public String getTipoVehiculo() {
        return this.getClass().getAnnotation(DiscriminatorValue.class) != null
                ? this.getClass().getAnnotation(DiscriminatorValue.class).value()
                : this.getClass().getSimpleName(); // fallback
    }
    
    public Vehiculo() {
    }
    
    public Vehiculo(String marca, String modelo, int anio, double velocidadMaxima) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.velocidadMaxima = velocidadMaxima;
    }
    
    // Getters y Setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public int getAnio() {
        return anio;
    }
    
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }
    
    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }
    
    public double getVelocidadActual() {
        return velocidadActual;
    }
    
    public void setVelocidadActual(double velocidadActual) {
        this.velocidadActual = velocidadActual;
    }
    
    // Métodos de comportamiento
    public void acelerar(double incremento) {
        velocidadActual = Math.min(velocidadMaxima, velocidadActual + incremento);
    }
    
    public void frenar(double decremento) {
        velocidadActual = Math.max(0, velocidadActual - decremento);
    }
    
    public String mostrarInfo() {
        return "Info: " + marca + " " + modelo + " (" + anio + ") - Vmax=" + velocidadMaxima + " km/h";
    }
}