-- Insertar vehículos eléctricos
INSERT INTO vehiculo (id, marca, modelo, anio, velocidad_maxima, velocidad_actual, tipo_vehiculo, capacidad_bateria, nivel_autonomia) 
VALUES (1, 'Tesla', 'Model S', 2023, 250, 0, 'ELECTRICO', 100, 5);

INSERT INTO vehiculo (id, marca, modelo, anio, velocidad_maxima, velocidad_actual, tipo_vehiculo, capacidad_bateria, nivel_autonomia) 
VALUES (2, 'Nissan', 'Leaf', 2022, 180, 0, 'ELECTRICO', 60, 3);

-- Insertar vehículos híbridos
INSERT INTO vehiculo (id, marca, modelo, anio, velocidad_maxima, velocidad_actual, tipo_vehiculo, eficiencia_energetica, modo_actual) 
VALUES (3, 'Toyota', 'Prius', 2023, 180, 0, 'HIBRIDO', 25.6, 'hibrido');

INSERT INTO vehiculo (id, marca, modelo, anio, velocidad_maxima, velocidad_actual, tipo_vehiculo, eficiencia_energetica, modo_actual) 
VALUES (4, 'Ford', 'Fusion Hybrid', 2022, 185, 0, 'HIBRIDO', 20.3, 'electrico');

-- Insertar vehículos de combustión
INSERT INTO vehiculo (id, marca, modelo, anio, velocidad_maxima, velocidad_actual, tipo_vehiculo, capacidad_tanque) 
VALUES (5, 'Ford', 'Mustang', 2023, 250, 0, 'COMBUSTION', 60);

INSERT INTO vehiculo (id, marca, modelo, anio, velocidad_maxima, velocidad_actual, tipo_vehiculo, capacidad_tanque) 
VALUES (6, 'Chevrolet', 'Camaro', 2022, 240, 0, 'COMBUSTION', 55);