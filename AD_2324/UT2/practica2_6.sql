-- Creación del tipo empleado
CREATE OR REPLACE TYPE empleado AS OBJECT (
    Rut VARCHAR(10),
    Nombre VARCHAR(10),
    Cargo VARCHAR(9),
    fechaIng DATE,
    sueldo NUMBER(9),
    somision NUMBER(9),
    anticipo NUMBER(9),

    -- Función para calcular el sueldo líquido
    MEMBER FUNCTION sueldo_liquido RETURN NUMBER,

    -- Procedimiento para aumentar el sueldo
    MEMBER PROCEDURE aumento_sueldo(aumento NUMBER)
);
/

-- Cuerpo del tipo empleado
CREATE OR REPLACE TYPE BODY empleado AS
    -- Implementación de la función sueldo_liquido
    MEMBER FUNCTION sueldo_liquido RETURN NUMBER IS
    BEGIN
        -- Cálculo del sueldo líquido
        RETURN sueldo + somision - anticipo;
    END sueldo_liquido;

    -- Implementación del procedimiento aumento_sueldo
    MEMBER PROCEDURE aumento_sueldo(aumento NUMBER) IS
    BEGIN
        -- Aplicar el aumento al sueldo
        self.sueldo := self.sueldo + aumento;
    END aumento_sueldo;
END;
/

--2
CREATE OR REPLACE TYPE BODY empleado AS
    -- Implementación de la función sueldo_liquido
    MEMBER FUNCTION sueldo_liquido RETURN NUMBER IS
    BEGIN
        -- Cálculo del sueldo líquido
        RETURN self.sueldo + self.somision - self.anticipo;
    END sueldo_liquido;

    -- Implementación del procedimiento aumento_sueldo
    MEMBER PROCEDURE aumento_sueldo(aumento NUMBER) IS
    BEGIN
        -- Aplicar el aumento al sueldo
        self.sueldo := self.sueldo + aumento;
    END aumento_sueldo;
END;
/
--3
-- Crear el tipo Empleado con sus atributos
CREATE OR REPLACE TYPE empleado AS OBJECT (
    Rut VARCHAR(10),
    Nombre VARCHAR(10),
    Cargo VARCHAR(9),
    fechaIng DATE,
    sueldo NUMBER(9),
    somision NUMBER(9),
    anticipo NUMBER(9),
    
    -- Función para calcular el sueldo líquido
    MEMBER FUNCTION sueldo_liquido RETURN NUMBER,
    
    -- Procedimiento para aumentar el sueldo
    MEMBER PROCEDURE aumento_sueldo(aumento NUMBER),
    
    -- Procedimiento para establecer el anticipo
    MEMBER PROCEDURE setAnticipo(anticipo NUMBER)
);
/

-- Cuerpo del tipo empleado con implementaciones de funciones y procedimientos
CREATE OR REPLACE TYPE BODY empleado AS
    -- Implementación de la función sueldo_liquido
    MEMBER FUNCTION sueldo_liquido RETURN NUMBER IS
    BEGIN
        -- Cálculo del sueldo líquido
        RETURN self.sueldo + self.somision - self.anticipo;
    END sueldo_liquido;

    -- Implementación del procedimiento aumento_sueldo
    MEMBER PROCEDURE aumento_sueldo(aumento NUMBER) IS
    BEGIN
        -- Aplicar el aumento al sueldo
        self.sueldo := self.sueldo + aumento;
    END aumento_sueldo;
    
    -- Implementación del procedimiento setAnticipo
    MEMBER PROCEDURE setAnticipo(anticipo NUMBER) IS
    BEGIN
        -- Establecer el valor del anticipo
        self.anticipo := anticipo;
    END setAnticipo;
END;
/

--4
-- Cuerpo para el nuevo método setAnticipo del tipo Empleado
CREATE OR REPLACE TYPE BODY empleado AS
    -- ... (código previo)

    -- Implementación del procedimiento setAnticipo
    MEMBER PROCEDURE setAnticipo(anticipo NUMBER) IS
    BEGIN
        -- Establecer el valor del anticipo
        self.anticipo := anticipo;
    END setAnticipo;
END;
/

--5
CREATE TABLE empleados OF empleado;

--6
-- Corrección de los comandos de inserción
INSERT INTO empleados VALUES ('1', 'Pepe', 'director', sysdate, 2000, 500, 0);

INSERT INTO empleados VALUES ('2', 'Juan', 'vendedor', sysdate, 1000, 300, 0);

INSERT INTO empleados VALUES ('3', 'Elena', 'vendedor', sysdate, 1000, 400, 0);

--7

DECLARE
    v_sueldo_liquido NUMBER;
BEGIN
    -- Listar el sueldo líquido del empleado con Rut = '1'
    SELECT e.sueldo_liquido
    INTO v_sueldo_liquido
    FROM empleados e
    WHERE e.Rut = '1';

    -- Mostrar el sueldo líquido actual del empleado con Rut = '1'
    DBMS_OUTPUT.PUT_LINE('El sueldo líquido actual del empleado Rut=1 es: ' || v_sueldo_liquido);

    -- Aumentar el sueldo del empleado con Rut = '1' en 400 euros
    UPDATE empleados
    SET salario = salario + 400
    WHERE Rut = '1';
    
    -- Mostrar mensaje de confirmación del aumento
    DBMS_OUTPUT.PUT_LINE('Se ha aumentado el sueldo del empleado Rut=1 en 400 euros.');
END;
/

--8

DECLARE
    v_sueldo_liquido NUMBER;
BEGIN
    -- Aumentar el sueldo del empleado con Rut = '1' en 400 euros
    UPDATE empleados
    SET salario = salario + 400
    WHERE Rut = '1';

    -- Confirmar el aumento en la tabla
    DBMS_OUTPUT.PUT_LINE('Se ha aumentado el sueldo del empleado Rut=1 en 400 euros.');

    -- Mostrar el sueldo líquido actualizado del empleado con Rut = '1'
    SELECT e.sueldo_liquido
    INTO v_sueldo_liquido
    FROM empleados e
    WHERE e.Rut = '1';

    -- Mostrar el sueldo líquido actualizado
    DBMS_OUTPUT.PUT_LINE('El sueldo líquido actualizado del empleado Rut=1 es: ' || v_sueldo_liquido);
END;
/

--9

DECLARE
    CURSOR c_empleados IS
        SELECT e.salario AS sueldo,
               e.sueldo_liquido AS sueldo_liquido
        FROM empleados e;
        
    v_sueldo NUMBER;
    v_sueldo_liquido NUMBER;
BEGIN
    -- Recorrer el cursor y mostrar los sueldos y sueldos líquidos con alias
    FOR empleado IN c_empleados LOOP
        v_sueldo := empleado.sueldo;
        v_sueldo_liquido := empleado.sueldo_liquido;
        
        DBMS_OUTPUT.PUT_LINE('Sueldo: ' || v_sueldo || ' - Sueldo líquido: ' || v_sueldo_liquido);
    END LOOP;
END;
/


