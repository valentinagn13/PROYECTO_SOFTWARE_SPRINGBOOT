package com.vehiculos.repository;

import com.vehiculos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    List<Vehiculo> findByMarca(String marca);
    List<Vehiculo> findByMarcaAndModelo(String marca, String modelo);
}