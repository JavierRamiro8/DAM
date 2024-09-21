-- Crear un tipo de tabla para la colección de hijos
CREATE TYPE colec_hijos AS TABLE OF VARCHAR2(30);

-- Crear una tabla de empleados que incluya la colección de hijos
CREATE TABLE empleados (
    id NUMBER,
    nombre VARCHAR2(30),
    apellidos VARCHAR2(30),
    hijos colec_hijos
) NESTED TABLE hijos STORE AS hijos_tab;

-- Insertar datos de ejemplo
INSERT INTO empleados VALUES (1, 'Francisco', 'Pérez', colec_hijos('Luis', 'Ursula'));
INSERT INTO empleados VALUES (2, 'Esperanza', 'Jiménez', colec_hijos('José', 'Carlos', 'Pedro'));

-- Consulta para obtener los nombres de los hijos de un empleado por su ID
DECLARE
    v_id_empleado NUMBER := 1; -- Puedes cambiar el ID según tus necesidades
    v_hijos colec_hijos;
BEGIN
    SELECT hijos INTO v_hijos FROM empleados WHERE id = v_id_empleado;

    FOR i IN 1..v_hijos.COUNT LOOP
        DBMS_OUTPUT.PUT_LINE('Hijo: ' || v_hijos(i));
    END LOOP;
END;
/

--4
-- Consulta para visualizar todos los empleados
SELECT * FROM empleados;

--5

-- Consulta para visualizar los nombres de los hijos del empleado con ID 1
SELECT id, nombre, apellidos, COLUMN_VALUE AS nombre_hijo
FROM empleados, TABLE(empleados.hijos)
WHERE id = 1;
/
--6
-- Consulta para visualizar el nombre de todos los hijos de todos los empleados
SELECT e.id, e.nombre, e.apellidos, h.COLUMN_VALUE AS nombre_hijo
FROM empleados e
JOIN TABLE(e.hijos) h ON 1 = 1;
/

--7
DECLARE
    v_id_empleado NUMBER := 1;
    v_num_hijos NUMBER;

BEGIN
    -- Consulta para obtener el número de hijos del empleado con ID 1
    SELECT COUNT(*) INTO v_num_hijos
    FROM TABLE((SELECT hijos FROM empleados WHERE id = v_id_empleado));

    -- Mostrar el resultado
    DBMS_OUTPUT.PUT_LINE('El empleado con ID ' || v_id_empleado || ' tiene ' || v_num_hijos || ' hijos.');
END;
/
--8
DECLARE
    CURSOR empleados_cursor IS
        SELECT id, nombre, apellidos, hijos
        FROM empleados;

    v_id_empleado NUMBER;
    v_nombre_empleado VARCHAR2(30);
    v_hijo VARCHAR2(30);

BEGIN
    FOR empleado_rec IN empleados_cursor LOOP
        v_id_empleado := empleado_rec.id;
        v_nombre_empleado := empleado_rec.nombre || ' ' || empleado_rec.apellidos;

        DBMS_OUTPUT.PUT_LINE('Empleado: ' || v_nombre_empleado);

        -- Iterar sobre la colección de hijos
        FOR i IN 1..empleado_rec.hijos.COUNT LOOP
            v_hijo := empleado_rec.hijos(i);
            DBMS_OUTPUT.PUT_LINE('Hijo: ' || v_hijo);
        END LOOP;

        DBMS_OUTPUT.PUT_LINE('-----------------');
    END LOOP;
END;
/



--9
-- Consulta para visualizar cuántos hijos tienen todos los empleados
SELECT id, nombre, apellidos, COUNT(*) AS cantidad_hijos
FROM empleados, TABLE(hijos)
GROUP BY id, nombre, apellidos;
--10
-- Añadir un hijo más al empleado con ID 1
DECLARE
    v_id_empleado NUMBER := 1;
    v_nuevo_hijo VARCHAR2(30) := 'Antonio';
BEGIN
    UPDATE empleados
    SET hijos = hijos MULTISET UNION ALL colec_hijos(v_nuevo_hijo)
    WHERE id = v_id_empleado;
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Se añadió el hijo ' || v_nuevo_hijo || ' al empleado con ID ' || v_id_empleado);
END;
/
--11
-- Añadir al final de la colección 3 veces el hijo "Luis" para el empleado con ID 1
DECLARE
    v_id_empleado NUMBER := 1;
    v_nuevo_hijo VARCHAR2(30) := 'Luis';
BEGIN
    UPDATE empleados
    SET hijos = hijos MULTISET UNION ALL colec_hijos(v_nuevo_hijo, v_nuevo_hijo, v_nuevo_hijo)
    WHERE id = v_id_empleado;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Se añadió el hijo ' || v_nuevo_hijo || ' tres veces al final de la colección del empleado con ID ' || v_id_empleado);
END;
/
--12
-- Consulta para visualizar la vista USER_VARRAYS
SELECT * FROM USER_VARRAYS;

--13
-- Describe la tabla empleados para obtener información sobre la colección colec_hijos
DESCRIBE empleados;


