CREATE OR REPLACE PACKAGE cuerpo_cubo AS
  -- Método estático para crear un nuevo cubo
  PROCEDURE nuevoCubo(V_largo INTEGER, V_ancho INTEGER, V_alto INTEGER);
END cuerpo_cubo;
/

CREATE OR REPLACE PACKAGE BODY cuerpo_cubo AS
  PROCEDURE nuevoCubo(V_largo INTEGER, V_ancho INTEGER, V_alto INTEGER) IS
    nuevo_cubo_obj cubo; -- Crear una nueva instancia del tipo cubo
  BEGIN
    nuevo_cubo_obj := cubo(V_largo, V_ancho, V_alto); -- Inicializar el nuevo cubo con los parámetros dados
    -- Puedes hacer cualquier otra operación que desees aquí
    DBMS_OUTPUT.PUT_LINE('Se ha creado un nuevo cubo con dimensiones: Largo=' || V_largo || ', Ancho=' || V_ancho || ', Alto=' || V_alto);
    -- Si necesitas utilizar esta instancia para alguna otra operación, puedes hacerlo aquí
  END nuevoCubo;
END cuerpo_cubo;

--2

CREATE OR REPLACE PACKAGE cuerpo_cubo AS
  -- Método estático para crear un nuevo cubo y realizar un INSERT en la tabla cubos
  PROCEDURE nuevoCubo(V_largo INTEGER, V_ancho INTEGER, V_alto INTEGER);
END cuerpo_cubo;
/

CREATE OR REPLACE PACKAGE BODY cuerpo_cubo AS
  PROCEDURE nuevoCubo(V_largo INTEGER, V_ancho INTEGER, V_alto INTEGER) IS
    nuevo_cubo_obj cubo; -- Crear una nueva instancia del tipo cubo
  BEGIN
    nuevo_cubo_obj := cubo(V_largo, V_ancho, V_alto); -- Inicializar el nuevo cubo con los parámetros dados

    -- Realizar el INSERT en la tabla cubos con el nuevo cubo
    INSERT INTO cubos (id, cubo) VALUES ((SELECT NVL(MAX(id), 0) + 1 FROM cubos), nuevo_cubo_obj);

    -- Mostrar mensaje de confirmación
    DBMS_OUTPUT.PUT_LINE('Se ha creado y almacenado un nuevo cubo en la tabla cubos.');
  END nuevoCubo;
END cuerpo_cubo;

--3

DECLARE
BEGIN
  cuerpo_cubo.nuevoCubo(1, 8, 1);
END;
/
