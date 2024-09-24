CREATE TABLE Enfermero (
UUID_Enfermero VARCHAR(100),
Nombre_Enfermero VARCHAR2(100),
Edad_Enfermero INT,
Peso_Enfermero NUMBER,
Correo_Enfermero VARCHAR2(100))
;

//inserts ejemplo
INSERT INTO Enfermero (UUID_Enfermero, Nombre_Enfermero, Edad_Enfermero, Peso_Enfermero, Correo_Enfermero)
VALUES ('1a2b3c4d', 'Juan Perez', 30, 70.5, 'juanp@gmail.com');

INSERT INTO Enfermero (UUID_Enfermero, Nombre_Enfermero, Edad_Enfermero, Peso_Enfermero, Correo_Enfermero)
VALUES ('2b3c4d5e', 'Maria Lopez', 28, 65.0, 'marial@gmail.com');

INSERT INTO Enfermero (UUID_Enfermero, Nombre_Enfermero, Edad_Enfermero, Peso_Enfermero, Correo_Enfermero)
VALUES ('3c4d5e6f', 'Carlos Sanchez', 35, 80.2, 'carloss@gmail.com');

select * from enfermero
