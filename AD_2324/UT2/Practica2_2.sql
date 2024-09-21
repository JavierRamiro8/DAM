CREATE TABLE Veterinario (
    id INT PRIMARY KEY,
    nombre VARCHAR(50),
    direccion VARCHAR(100)
);
/
CREATE TABLE Mascota (
    id INT PRIMARY KEY,
    raza VARCHAR(50),
    nombre VARCHAR(50),
    vet INT,
    FOREIGN KEY (vet) REFERENCES Veterinario(id)
);
/
INSERT INTO Veterinario (id, nombre, direccion) 
VALUES (1, 'Jesus Perez', 'C/El mareo,29');
/
INSERT INTO Mascota (id, raza, nombre, vet) 
VALUES (1, 'perro', 'Sproket', 1);
/
SELECT * FROM Mascota;
/
SELECT id, raza, nombre, vet FROM Mascota;
/
SELECT M.nombre AS NombreMascota, M.raza AS RazaMascota, V.nombre AS NombreVeterinario
FROM Mascota M
INNER JOIN Veterinario V ON M.vet = V.id;
/
-- Elimina la tabla "Mascota" y su tipo
DROP TABLE Mascota;

-- Elimina la tabla "Veterinario" y su tipo
DROP TABLE Veterinario;
/