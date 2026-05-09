CREATE TABLE actividades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre_actividad VARCHAR(100) NOT NULL,
    monitor VARCHAR(100) NOT NULL,
    edad_minima INT NOT NULL,
    plazas INT NOT NULL
);

CREATE TABLE participantes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(150) NOT NULL,
    edad INT NOT NULL,
    alergia_alimentaria VARCHAR(200),
    actividad_id INT,
    FOREIGN KEY (actividad_id) REFERENCES actividades(id)
);
