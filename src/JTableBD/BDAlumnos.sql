/*BASE DE DATOS DE EJEMPLO*/
CREATE DATABASE escuela;

USE escuela;

CREATE TABLE AlumnoComida(
    nombre varchar(100) NOT NULL,
    comidaFavorita varchar(100) NOT NULL,
    email varchar(50) NOT NULL,
    edad int NOT NULL
);

INSERT INTO escuela.alumnocomida VALUES
    ('María','Enchiladas rojas','maria@gmail.com',21),
	('Miguel','Pescado a la plancha','mike_09@gmail.com',27),
	('Pedro','Caldo de pollo','pedrito@gmail.com',20),
	('Martha','Lasagna','martha00@gmail.com',45),
	('Joanna','Torrejas','oaj@gmail.com',20),
	('Roberto','Filete de pescado','rob_to@gmail.com',18),
	('Hugo','Ensalada de frutas','hg_uo@gmail.com',25),
	('Virginia','Tamales','vr_gn@gmail.com',30),
	('Luis','Sopa','ilus@gmail.com',20),
	('Horacio','Hamburguesa','meti_cio@gmail.com',37);
    
SELECT * FROM escuela.alumnocomida;