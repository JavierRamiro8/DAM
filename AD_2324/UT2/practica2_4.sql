-- Crear el tipo_tri�ngulo con los atributos base y altura
CREATE OR REPLACE TYPE tipo_tri�ngulo AS OBJECT (
  base NUMBER,
  altura NUMBER,
  CONSTRUCTOR FUNCTION tipo_tri�ngulo (base NUMBER, altura NUMBER) RETURN SELF AS RESULT,
  MEMBER FUNCTION area RETURN NUMBER
);
/

-- Implementar el constructor
CREATE OR REPLACE TYPE BODY tipo_tri�ngulo AS
  CONSTRUCTOR FUNCTION tipo_tri�ngulo (base NUMBER, altura NUMBER) RETURN SELF AS RESULT IS
  BEGIN
    SELF.base := base;
    SELF.altura := altura;
    RETURN;
  END;

  -- M�todo para calcular el �rea del tri�ngulo
  MEMBER FUNCTION area RETURN NUMBER IS
  BEGIN
    RETURN (SELF.base * SELF.altura) / 2;
  END;
END;
/

CREATE OR REPLACE TYPE BODY tipo_tri�ngulo AS
  CONSTRUCTOR FUNCTION tipo_tri�ngulo (base NUMBER, altura NUMBER) RETURN SELF AS RESULT IS
  BEGIN
    SELF.base := base;
    SELF.altura := altura;
    RETURN;
  END;

  -- M�todo para calcular el �rea del tri�ngulo
  MEMBER FUNCTION area RETURN NUMBER IS
  BEGIN
    RETURN (SELF.base * SELF.altura) / 2;
  END;
END;
/

-- Crear la tabla triangulos
CREATE TABLE triangulos (
  Id NUMBER,
  triangulo tipo_tri�ngulo
);
/

-- Insertar el primer tri�ngulo (Id=1, base=5, altura=5)
INSERT INTO triangulos (Id, triangulo) VALUES (1, tipo_tri�ngulo(5, 5));

-- Insertar el segundo tri�ngulo (Id=2, base=10, altura=10)
INSERT INTO triangulos (Id, triangulo) VALUES (2, tipo_tri�ngulo(10, 10));
/

-- Listar todos los tri�ngulos
SELECT t.Id, t.triangulo.base AS Base, t.triangulo.altura AS Altura
FROM triangulos t;
/

DECLARE
  v_id NUMBER;
  v_area NUMBER;
BEGIN
  -- Recorre la tabla de tri�ngulos
  FOR tri IN (SELECT Id, triangulo FROM triangulos) LOOP
    v_id := tri.Id;  -- Obtiene el Id del tri�ngulo
    v_area := tri.triangulo.area();  -- Calcula el �rea del tri�ngulo
    
    -- Muestra el Id y el �rea del tri�ngulo
    DBMS_OUTPUT.PUT_LINE('Tri�ngulo con Id ' || v_id || ', �rea: ' || v_area);
  END LOOP;
END;
/
