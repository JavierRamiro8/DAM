-- Crear el tipo_triángulo con los atributos base y altura
CREATE OR REPLACE TYPE tipo_triángulo AS OBJECT (
  base NUMBER,
  altura NUMBER,
  CONSTRUCTOR FUNCTION tipo_triángulo (base NUMBER, altura NUMBER) RETURN SELF AS RESULT,
  MEMBER FUNCTION area RETURN NUMBER
);
/

-- Implementar el constructor
CREATE OR REPLACE TYPE BODY tipo_triángulo AS
  CONSTRUCTOR FUNCTION tipo_triángulo (base NUMBER, altura NUMBER) RETURN SELF AS RESULT IS
  BEGIN
    SELF.base := base;
    SELF.altura := altura;
    RETURN;
  END;

  -- Método para calcular el área del triángulo
  MEMBER FUNCTION area RETURN NUMBER IS
  BEGIN
    RETURN (SELF.base * SELF.altura) / 2;
  END;
END;
/

CREATE OR REPLACE TYPE BODY tipo_triángulo AS
  CONSTRUCTOR FUNCTION tipo_triángulo (base NUMBER, altura NUMBER) RETURN SELF AS RESULT IS
  BEGIN
    SELF.base := base;
    SELF.altura := altura;
    RETURN;
  END;

  -- Método para calcular el área del triángulo
  MEMBER FUNCTION area RETURN NUMBER IS
  BEGIN
    RETURN (SELF.base * SELF.altura) / 2;
  END;
END;
/

-- Crear la tabla triangulos
CREATE TABLE triangulos (
  Id NUMBER,
  triangulo tipo_triángulo
);
/

-- Insertar el primer triángulo (Id=1, base=5, altura=5)
INSERT INTO triangulos (Id, triangulo) VALUES (1, tipo_triángulo(5, 5));

-- Insertar el segundo triángulo (Id=2, base=10, altura=10)
INSERT INTO triangulos (Id, triangulo) VALUES (2, tipo_triángulo(10, 10));
/

-- Listar todos los triángulos
SELECT t.Id, t.triangulo.base AS Base, t.triangulo.altura AS Altura
FROM triangulos t;
/

DECLARE
  v_id NUMBER;
  v_area NUMBER;
BEGIN
  -- Recorre la tabla de triángulos
  FOR tri IN (SELECT Id, triangulo FROM triangulos) LOOP
    v_id := tri.Id;  -- Obtiene el Id del triángulo
    v_area := tri.triangulo.area();  -- Calcula el área del triángulo
    
    -- Muestra el Id y el área del triángulo
    DBMS_OUTPUT.PUT_LINE('Triángulo con Id ' || v_id || ', Área: ' || v_area);
  END LOOP;
END;
/
