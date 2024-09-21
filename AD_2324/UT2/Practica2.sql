CREATE OR REPLACE TYPE Direccion AS OBJECT (
    calle VARCHAR2(25),
    ciudad VARCHAR2(20),
    codigo_post NUMBER(5)
);
/
CREATE OR REPLACE TYPE Persona AS OBJECT (
    codigo NUMBER,
    nombre VARCHAR2(35),
    direc Direccion,
    fecha_nac DATE
);
/
DECLARE
DIR DIRECCION:=DIRECCION(NULL,NULL,NULL);
P PERSONA:=PERSONA(NULL,NULL,NULL,NULL);
BEGIN
    DIR.CALLE:='Calle del aguila 21';
    DIR.CIUDAD:='Madrid';
    DIR.CODIGO_POST:=28005;
    P.CODIGO:=1;
    P.NOMBRE:='JAVI';
    P.DIREC:=DIR;
    P.FECHA_NAC:='11/03/2004';
END;
/
CREATE TABLE alumnos OF Persona;
/
-- Insertar el primer alumno
INSERT INTO alumnos (SELECT Persona(1, 'Juan Pérez', Direccion('Calle A', 'Ciudad Real', 12345), TO_DATE('2000-01-15', 'YYYY-MM-DD')) FROM dual);
/
-- Insertar el segundo alumno
INSERT INTO alumnos (SELECT Persona(2, 'María López', Direccion('Calle B', 'CATALUYA', 54321), TO_DATE('1999-07-20', 'YYYY-MM-DD')) FROM dual);
INSERT INTO alumnos (SELECT Persona(2, 'María López', Direccion('Calle B', 'GUADALAJARA', 54321), TO_DATE('1999-07-20', 'YYYY-MM-DD')) FROM dual);
/
SELECT p.direc.ciudad FROM alumnos p WHERE p.direc.ciudad = 'guadalajara';
/
SELECT p.codigo, p.direc.calle, p.direc.ciudad, p.direc.codigo_post FROM alumnos p;
/
UPDATE alumnos a
SET a.direc = Direccion(LOWER(a.direc.calle), LOWER(a.direc.ciudad), a.direc.codigo_post)
WHERE a.direc.ciudad = 'GUADALAJARA';
/
DECLARE
    v_nombre VARCHAR2(35);
    v_calle VARCHAR2(25);
BEGIN
    FOR rec IN (SELECT p.nombre, p.direc.calle FROM alumnos p) LOOP
        v_nombre := rec.nombre;
        v_calle := rec.calle;
        DBMS_OUTPUT.PUT_LINE('Nombre: ' || v_nombre || ', Calle: ' || v_calle);
    END LOOP;
END;
/


DELETE FROM alumnos a
WHERE a.direc.ciudad = 'GUADALAJARA';
/












