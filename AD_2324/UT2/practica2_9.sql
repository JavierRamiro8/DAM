
-- Crear un nuevo tipo de tabla llamado tabla_hijos
CREATE TYPE tabla_hijos AS TABLE OF VARCHAR2(30);

-- Modificar la tabla de empleados para cambiar el tipo de la columna hijos
ALTER TABLE empleados
    MODIFY hijos tabla_hijos;
    
--2
-- Crear la tabla de empleados basándola en el tipo tabla_hijos
CREATE TABLE empleados2 (
    Idemp NUMBER,
    Nombre VARCHAR2(30),
    Apellidos VARCHAR2(30),
    Hijos tabla_hijos,
    CONSTRAINT pk_empleados PRIMARY KEY (Idemp)
)
NESTED TABLE Hijos STORE AS t_hijos;

select * from empleados2;

-- Consultar los datos
SELECT * FROM empleados;

--3
-- Otra opción más específica para obtener información detallada sobre las tablas anidadas
select object_name, object_type,status from user_objects where object_name like '%HIJO%';

select segment_name, segment_type from user_segments where segment_name like '%HIJO%';

--4
INSERT INTO empleados2 (Idemp, Nombre, Apellidos, Hijos)
VALUES (1, 'Fernando', 'Moreno', CAST(tabla_hijos('Elena', 'Pablo') AS tabla_hijos));
INSERT INTO empleados2 (Idemp, Nombre, Apellidos, Hijos)
VALUES (2, 'David', 'Sanchez', CAST(tabla_hijos('Carmen', 'Candela') AS tabla_hijos));

--5
SELECT * FROM empleados2;

--6
-- Actualizar los nombres de los hijos del empleado con Idemp igual a 1
-- Actualizar los nombres de los hijos del empleado con Idemp igual a 1
UPDATE empleados2
SET Hijos = tabla_hijos('Carmen', 'Candela', 'Cayetana')
WHERE Idemp = 1;

--7
SELECT COLUMN_VALUE AS hijo
FROM TABLE (SELECT Hijos FROM empleados2 WHERE Idemp = 1);

-- Listar todos los hijos del empleado con Idemp igual a 2
SELECT COLUMN_VALUE AS hijo
FROM TABLE (SELECT Hijos FROM empleados2 WHERE Idemp = 2);

--8





