drop table Usuarios;

CREATE TABLE Usuarios (
dni         INTEGER NOT NULL PRIMARY KEY,
nombre      VARCHAR(25) NOT NULL,
apellidos   VARCHAR(100),
email       VARCHAR(50),
usuario     VARCHAR(25),
pass        VARCHAR(10)
);

CREATE TABLE Animales (
especie VARCHAR(15) NOT NULL,
nombre VARCHAR(25) PRIMARY KEY,
estado VARCHAR(15),
edad INTEGER,
chip BOOLEAN,
vacunas BOOLEAN,
dnidueno INTEGER,

CONSTRAINT CK_especie CHECK (especie = 'PERRO' || especie = 'GATO' || especie='MONO'),
CONSTRAINT FK_dnidueno FOREIGN KEY dnidueño REFERENCES Usuarios(dni)
);

insert into  Usuarios values (77360609, 'Daniel', 'Moya', 'dani@uja.es', 'dml', '123');
insert into  Usuarios values (23000579, 'Juanfra', 'Abán', 'juanfra@uja.es', 'jfaf', '555');
insert into  Usuarios values (57923023, 'Ana', 'Frank', 'ana@uja.es', 'af', '666');

insert into Animales values('PERRO', 'Bolita de nieve', 'PERFECTO', 5, true, true, 230000579));
insert into Animales values('PERRO','Esperanza', 'PERFECTO', 5, true, true, 230000579);
insert into Animales values('PERRO', 'Colgantitos', 'PERFECTO', 5, true, true, 230000579);
