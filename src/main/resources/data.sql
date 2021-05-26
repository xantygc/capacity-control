DROP ALL OBJECTS;

CREATE TABLE Subscription (
    id BINARY(16) NOT NULL PRIMARY KEY,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    type VARCHAR(32) NOT NULL,
    paid BOOLEAN DEFAULT False,
    cost DECIMAL NOT NULL,
    times TINYINT DEFAULT -1,
    payment VARCHAR(32)
);

CREATE TABLE Location (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    name VARCHAR(32) NOT NULL UNIQUE,
    capacity INT NOT NULL,
    attendance INT NOT NULL
);

CREATE TABLE Subscriber (
    id BINARY(16) NOT NULL PRIMARY KEY,
    barcode VARCHAR(13) NOT NULL,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    document_id VARCHAR(32) NOT NULL,
    birthdate DATE NOT NULL,
    address VARCHAR(250) NOT NULL,
    register BOOLEAN NOT NULL DEFAULT False,
    subscription_id BINARY(16) REFERENCES Subscription(id),
    location_id INT REFERENCES Location(id)
);

INSERT INTO Location (name, capacity, attendance) VALUES ('PISCINA',100,0 );
INSERT INTO Location (name, capacity, attendance) VALUES ('POLIDEPORTIVO',500,0 );

INSERT INTO Subscription (id, start_date, end_date, type, cost, payment, times)
VALUES ('3fa85f6457174562b3fc2c963f66afa6','2021-06-11','2021-09-15','0',90,'0',-1);
INSERT INTO Subscription (id, start_date, end_date, type, cost, payment, times)
VALUES ('95715f5088e0466b82bbe35371d6536b','2021-06-11','2021-09-15','1',45,'0', 10);
INSERT INTO Subscriber (id, name, surname, document_id, birthdate, address, register, subscription_id, location_id, barcode)
VALUES ( '3fa85f6457174562b3fc2c963f66afa6','SANTIAGO','GONZALEZ','49010835C','1982-06-21','CALLE DE CASTILLA MADRID',False, '3fa85f6457174562b3fc2c963f66afa6', 1 , '400763000011');
INSERT INTO Subscriber (id, name, surname, document_id, birthdate, address, register, subscription_id, location_id, barcode)
VALUES ( '95715f5088e0466b82bbe35371d6536b','JORGE','GONZALEZ','49010835C','1990-02-05','PLAZA DE PARIS FUENLABRADA',False, '95715f5088e0466b82bbe35371d6536b', 1 ,'400763000012');
