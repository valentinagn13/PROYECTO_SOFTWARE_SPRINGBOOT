package com.vehiculos.controller;

import com.vehiculos.model.*;
import com.vehiculos.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehiculos")
@CrossOrigin(origins = "http://localhost:3000")
public class VehiculoController {
    
    @Autowired
    private VehiculoService vehiculoService;
    
    // Obtener todos los vehículos
    @GetMapping
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoService.getAllVehiculos();
    }
    
    // Obtener un vehículo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> getVehiculoById(@PathVariable Long id) {
        Optional<Vehiculo> vehiculo = vehiculoService.getVehiculoById(id);
        return vehiculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    // Crear un nuevo vehículo eléctrico
    @PostMapping("/electrico")
    public Electrico createElectrico(@RequestBody Electrico electrico) {
        return (Electrico) vehiculoService.saveVehiculo(electrico);
    }
    
    // Crear un nuevo vehículo híbrido
    @PostMapping("/hibrido")
    public Hibrido createHibrido(@RequestBody Hibrido hibrido) {
        return (Hibrido) vehiculoService.saveVehiculo(hibrido);
    }
    
    // Crear un nuevo vehículo de combustión
    @PostMapping("/combustion")
    public Combustion createCombustion(@RequestBody Combustion combustion) {
        return (Combustion) vehiculoService.saveVehiculo(combustion);
    }
    
    // Actualizar un vehículo
    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> updateVehiculo(@PathVariable Long id, @RequestBody Vehiculo vehiculoDetails) {
        Optional<Vehiculo> optionalVehiculo = vehiculoService.getVehiculoById(id);
        
        if (optionalVehiculo.isPresent()) {
            Vehiculo vehiculo = optionalVehiculo.get();
            vehiculo.setMarca(vehiculoDetails.getMarca());
            vehiculo.setModelo(vehiculoDetails.getModelo());
            vehiculo.setAnio(vehiculoDetails.getAnio());
            vehiculo.setVelocidadMaxima(vehiculoDetails.getVelocidadMaxima());
            vehiculo.setVelocidadActual(vehiculoDetails.getVelocidadActual());
            
            // Actualizar propiedades específicas según el tipo
            if (vehiculo instanceof Electrico && vehiculoDetails instanceof Electrico) {
                Electrico electrico = (Electrico) vehiculo;
                Electrico electricoDetails = (Electrico) vehiculoDetails;
                electrico.setCapacidadBateria(electricoDetails.getCapacidadBateria());
                electrico.setNivelAutonomia(electricoDetails.getNivelAutonomia());
            } else if (vehiculo instanceof Hibrido && vehiculoDetails instanceof Hibrido) {
                Hibrido hibrido = (Hibrido) vehiculo;
                Hibrido hibridoDetails = (Hibrido) vehiculoDetails;
                hibrido.setEficienciaEnergetica(hibridoDetails.getEficienciaEnergetica());
                hibrido.setModoActual(hibridoDetails.getModoActual());
            } else if (vehiculo instanceof Combustion && vehiculoDetails instanceof Combustion) {
                Combustion combustion = (Combustion) vehiculo;
                Combustion combustionDetails = (Combustion) vehiculoDetails;
                combustion.setCapacidadTanque(combustionDetails.getCapacidadTanque());
            }
            
            Vehiculo updatedVehiculo = vehiculoService.saveVehiculo(vehiculo);
            return ResponseEntity.ok(updatedVehiculo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Eliminar un vehículo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehiculo(@PathVariable Long id) {
        Optional<Vehiculo> vehiculo = vehiculoService.getVehiculoById(id);
        if (vehiculo.isPresent()) {
            vehiculoService.deleteVehiculo(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Acelerar un vehículo
    @PutMapping("/{id}/acelerar")
    public ResponseEntity<Vehiculo> acelerarVehiculo(@PathVariable Long id, @RequestParam double incremento) {
        Vehiculo vehiculo = vehiculoService.acelerarVehiculo(id, incremento);
        if (vehiculo != null) {
            return ResponseEntity.ok(vehiculo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Frenar un vehículo
    @PutMapping("/{id}/frenar")
    public ResponseEntity<Vehiculo> frenarVehiculo(@PathVariable Long id, @RequestParam double decremento) {
        Vehiculo vehiculo = vehiculoService.frenarVehiculo(id, decremento);
        if (vehiculo != null) {
            return ResponseEntity.ok(vehiculo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Activar piloto automático (solo eléctricos)
    @PutMapping("/{id}/activar-piloto")
    public ResponseEntity<Electrico> activarPilotoAutomatico(@PathVariable Long id) {
        Electrico electrico = vehiculoService.activarPilotoAutomaticoElectrico(id);
        if (electrico != null) {
            return ResponseEntity.ok(electrico);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Cambiar modo (solo híbridos)
    @PutMapping("/{id}/cambiar-modo")
    public ResponseEntity<Hibrido> cambiarModo(@PathVariable Long id, @RequestParam String modo) {
        Hibrido hibrido = vehiculoService.cambiarModoHibrido(id, modo);
        if (hibrido != null) {
            return ResponseEntity.ok(hibrido);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Repostar (solo combustión)
    @PutMapping("/{id}/repostar")
    public ResponseEntity<Combustion> repostar(@PathVariable Long id, @RequestParam double litros) {
        Combustion combustion = vehiculoService.repostarCombustion(id, litros);
        if (combustion != null) {
            return ResponseEntity.ok(combustion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Obtener vehículos por marca
    @GetMapping("/marca/{marca}")
    public List<Vehiculo> getVehiculosByMarca(@PathVariable String marca) {
        return vehiculoService.getVehiculosByMarca(marca);
    }
}