package com.vehiculos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiculos.model.Combustion;
import com.vehiculos.model.Electrico;
import com.vehiculos.model.Hibrido;
import com.vehiculos.model.Vehiculo;
import com.vehiculos.repository.VehiculoRepository;

@Service
public class VehiculoService {
    
    @Autowired
    private VehiculoRepository vehiculoRepository;
    
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }
    
    public Optional<Vehiculo> getVehiculoById(Long id) {
        return vehiculoRepository.findById(id);
    }
    
    public Vehiculo saveVehiculo(Vehiculo vehiculo) {
        return vehiculoRepository.save(vehiculo);
    }
    
    public void deleteVehiculo(Long id) {
        vehiculoRepository.deleteById(id);
    }
    
    public List<Vehiculo> getVehiculosByMarca(String marca) {
        return vehiculoRepository.findByMarca(marca);
    }
    
    public Vehiculo acelerarVehiculo(Long id, double incremento) {
        Optional<Vehiculo> optionalVehiculo = vehiculoRepository.findById(id);
        if (optionalVehiculo.isPresent()) {
            Vehiculo vehiculo = optionalVehiculo.get();
            vehiculo.acelerar(incremento);
            return vehiculoRepository.save(vehiculo);
        }
        return null;
    }
    
    public Vehiculo frenarVehiculo(Long id, double decremento) {
        Optional<Vehiculo> optionalVehiculo = vehiculoRepository.findById(id);
        if (optionalVehiculo.isPresent()) {
            Vehiculo vehiculo = optionalVehiculo.get();
            vehiculo.frenar(decremento);
            return vehiculoRepository.save(vehiculo);
        }
        return null;
    }
    
    public Electrico activarPilotoAutomaticoElectrico(Long id) {
        Optional<Vehiculo> optionalVehiculo = vehiculoRepository.findById(id);
        if (optionalVehiculo.isPresent() && optionalVehiculo.get() instanceof Electrico) {
            Electrico electrico = (Electrico) optionalVehiculo.get();
            electrico.activarPilotoAutomatico();
            return (Electrico) vehiculoRepository.save(electrico);
        }
        return null;
    }
    
    public Hibrido cambiarModoHibrido(Long id, String nuevoModo) {
        Optional<Vehiculo> optionalVehiculo = vehiculoRepository.findById(id);
        if (optionalVehiculo.isPresent() && optionalVehiculo.get() instanceof Hibrido) {
            Hibrido hibrido = (Hibrido) optionalVehiculo.get();
            hibrido.cambiarModo(nuevoModo);
            return (Hibrido) vehiculoRepository.save(hibrido);
        }
        return null;
    }
    
    public Combustion repostarCombustion(Long id, double litros) {
        Optional<Vehiculo> optionalVehiculo = vehiculoRepository.findById(id);
        if (optionalVehiculo.isPresent() && optionalVehiculo.get() instanceof Combustion) {
            Combustion combustion = (Combustion) optionalVehiculo.get();
            combustion.repostar(litros);
            return (Combustion) vehiculoRepository.save(combustion);
        }
        return null;
    }
}