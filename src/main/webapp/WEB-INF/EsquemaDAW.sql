CREATE TABLE Usuarios (
    dni         INTEGER NOT NULL PRIMARY KEY,
    nombre      VARCHAR(25) NOT NULL,
    apellidos   VARCHAR(100),
    email       VARCHAR(50),
    direccion   VARCHAR(50),
    usuario     VARCHAR(25),
    pass        VARCHAR(10)
);

drop table Animales;

CREATE TABLE Animales (
    id          INTEGER PRIMARY KEY,
    nombre      VARCHAR(25) NOT NULL,
    edad        INTEGER,
    sexo        BOOLEAN,
    especie     VARCHAR(15) NOT NULL,
    raza        VARCHAR(15),
    estado      VARCHAR(15),
    chip        BOOLEAN,
    vacunas     BOOLEAN,
    descripcion VARCHAR(140),
    dnidueno    INTEGER,

CONSTRAINT FK_dnidueno FOREIGN KEY(dnidueno) REFERENCES Usuarios
);

insert into Usuarios values (77360609, 'Daniel',   'Moya',     'dani@uja.es',      'C/ Anonima' ,          'dml',  '123');
insert into Usuarios values (23000579, 'Juanfra',  'Abán',     'juanfra@uja.es',   'Plaza de España, 5',   'jfaf', '555');
insert into Usuarios values (57923023, 'Ana',      'Frank',    'ana@uja.es',       'C/ Germania',          'af',   '666');

insert into Animales values (0, 'Bolita de nieve',   5, true,    'perro',    'mestizo',          'Perfecto', true,   true,   'Gracioso y divertido', 77360609);
insert into Animales values (1, 'Esperanza',         3, false,   'gato',     'siamés',           'Enfermo',  true,   false,  'Muy elegante',         23000579);
insert into Animales values (2, 'Colgantitos',       1, true,    'perro',    'pastor alemán',    'Atlético', false,  true,   'Mucha energía',        57923023);
