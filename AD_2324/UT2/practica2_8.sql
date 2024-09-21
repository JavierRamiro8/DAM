-- Crear un tipo de tabla para la colección de nombres de departamentos
CREATE TYPE colec_tipo_nombres_dept AS TABLE OF VARCHAR2(30);

--2
-- Crear una tabla para almacenar los nombres de los departamentos por región
-- Crear la tabla departamentos con Region varchar(25) y Nombres_dept de tipo coleccion
CREATE TABLE departamentos (
    Region VARCHAR2(25),
    Nombres_dept colec_tipo_nombres_dept
) NESTED TABLE Nombres_dept STORE AS dept_tab;


--3

-- Insertar datos en la tabla departamentos
INSERT INTO departamentos VALUES ('Europa', colec_tipo_nombres_dept('shipping', 'sales', 'finances'));
INSERT INTO departamentos VALUES ('America', colec_tipo_nombres_dept('sales', 'finances', 'shipping'));
INSERT INTO departamentos VALUES ('Asia', colec_tipo_nombres_dept('finances', 'payroll', 'shipping', 'sales'));

--4
-- Consulta para visualizar todos los departamentos
SELECT Region, COLUMN_VALUE AS Nombre_departamento
FROM departamentos, TABLE(Nombres_dept);

--5
DECLARE
   -- Crear una variable de tipo colección para almacenar los nuevos nombres de los departamentos de la región de Europa
   TYPE nombres_departamentos IS TABLE OF VARCHAR2(30);

   -- Inicializar la colección con los nuevos nombres de los departamentos
   nuevos_nombres_departamentos nombres_departamentos := nombres_departamentos('benefits', 'advertising', 'contracting', 'executive', 'marketing');

BEGIN
   -- Actualizar los nombres de los departamentos en la región de Europa
   FOR i IN 1..nuevos_nombres_departamentos.COUNT LOOP
      UPDATE TABLE(SELECT Nombres_dept FROM departamentos WHERE Region = 'Europa') d
      SET COLUMN_VALUE = nuevos_nombres_departamentos(i)
      WHERE COLUMN_VALUE = nuevos_nombres_departamentos(i);
   END LOOP;

   -- Consultar y visualizar los nuevos nombres de los departamentos en la región de Europa
   FOR r IN (SELECT Region, COLUMN_VALUE AS Nombre_departamento FROM departamentos, TABLE(Nombres_dept) WHERE Region = 'Europa') LOOP
      DBMS_OUTPUT.PUT_LINE('Región: ' || r.Region || ', Nombre del departamento en Europa: ' || r.Nombre_departamento);
   END LOOP;
END;
/
--6
DECLARE
   -- Declarar un cursor para seleccionar las regiones y departamentos
   CURSOR c_departamentos IS
      SELECT Region, COLUMN_VALUE AS Nombre_departamento
      FROM departamentos, TABLE(Nombres_dept);

   -- Variables para almacenar los resultados del cursor
   v_region VARCHAR2(25);
   v_nombre_departamento VARCHAR2(30);

BEGIN
   -- Abrir el cursor
   OPEN c_departamentos;

   -- Recorrer el cursor y mostrar los resultados
   LOOP
      FETCH c_departamentos INTO v_region, v_nombre_departamento;
      EXIT WHEN c_departamentos%NOTFOUND;

      -- Mostrar la información
      DBMS_OUTPUT.PUT_LINE('Región: ' || v_region || ', Nombre del departamento: ' || v_nombre_departamento);
   END LOOP;

   -- Cerrar el cursor
   CLOSE c_departamentos;

END;
/





