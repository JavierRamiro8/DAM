CREATE OR REPLACE TYPE cubo AS OBJECT (
   largo INTEGER,
   ancho INTEGER,
   alto INTEGER,

   MEMBER FUNCTION superficie RETURN INTEGER,

   MEMBER FUNCTION volumen RETURN INTEGER,

   MEMBER PROCEDURE mostrar
);

/

CREATE OR REPLACE TYPE BODY cubo AS

   MEMBER FUNCTION superficie RETURN INTEGER IS
   BEGIN
      RETURN 2*(largo*ancho+largo*alto+ancho*alto);
   END;

   MEMBER FUNCTION volumen RETURN INTEGER IS
   BEGIN
      RETURN largo*alto*ancho;
   END;

   MEMBER PROCEDURE mostrar IS
   BEGIN
      DBMS_OUTPUT.PUT_LINE('Largo: ' || self.largo);
      DBMS_OUTPUT.PUT_LINE('Ancho: ' || self.ancho);
      DBMS_OUTPUT.PUT_LINE('Alto: ' || self.alto);
      DBMS_OUTPUT.PUT_LINE('Volumen: ' || self.volumen());
      DBMS_OUTPUT.PUT_LINE('Superficie: ' || self.superficie());
   END;

END;
/

CREATE OR REPLACE TYPE BODY cubo AS
   MEMBER FUNCTION superficie RETURN INTEGER IS
   BEGIN
      RETURN 2*(largo*ancho+largo*alto+ancho*alto);
   END;

   MEMBER FUNCTION volumen RETURN INTEGER IS
   BEGIN
      RETURN largo*alto*ancho;
   END;

   MEMBER PROCEDURE mostrar IS
   BEGIN
      DBMS_OUTPUT.PUT_LINE('Largo: ' || self.largo);
      DBMS_OUTPUT.PUT_LINE('Ancho: ' || self.ancho);
      DBMS_OUTPUT.PUT_LINE('Alto: ' || self.alto);
      DBMS_OUTPUT.PUT_LINE('Volumen: ' || self.volumen());
      DBMS_OUTPUT.PUT_LINE('Superficie: ' || self.superficie());
   END;
END;
/

-- Crear la tabla cubos con una columna de tipo cubo
CREATE TABLE cubos (
   id NUMBER,
   cubo cubo
);
/
-- Insertar dos cubos en la tabla cubos
INSERT INTO cubos (id, cubo) VALUES (1, cubo(10, 10, 10));
INSERT INTO cubos (id, cubo) VALUES (2, cubo(3, 4, 5));
/

-- Listar todos los cubos
-- Listar todos los cubos
SELECT id, c.cubo.largo, c.cubo.ancho, c.cubo.alto, c.cubo.volumen() AS Volumen, c.cubo.superficie() AS Superficie
FROM cubos c;
/

SELECT c.id, c.cubo.volumen() AS Volumen, c.cubo.superficie() AS Superficie
FROM cubos c
WHERE c.cubo.largo = 10;
/
DECLARE
  v_largo NUMBER;
  v_ancho NUMBER;
  v_alto NUMBER;
BEGIN
  -- Encuentra el cubo con un largo de 10 y obtiene sus dimensiones
  SELECT c.cubo.largo, c.cubo.ancho, c.cubo.alto
  INTO v_largo, v_ancho, v_alto
  FROM cubos c
  WHERE c.cubo.largo = 10;

  -- Muestra los datos de largo, ancho y alto
  DBMS_OUTPUT.PUT_LINE('Largo: ' || v_largo);
  DBMS_OUTPUT.PUT_LINE('Ancho: ' || v_ancho);
  DBMS_OUTPUT.PUT_LINE('Alto: ' || v_alto);

  -- Llama al procedimiento mostrar() del cubo con un largo de 10
  FOR c IN (SELECT c.cubo FROM cubos c WHERE c.cubo.largo = 10) LOOP
    c.cubo.mostrar();
  END LOOP;
END;
/









