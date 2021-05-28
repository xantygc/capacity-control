DROP ALL OBJECTS;

CREATE TABLE Location (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    uuid BINARY(16) NOT NULL UNIQUE,
    name VARCHAR(32) NOT NULL UNIQUE,
    capacity INT NOT NULL,
    attendance INT NOT NULL,
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    last_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
);

CREATE TABLE Subscription (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    uuid BINARY(16) NOT NULL UNIQUE,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    type VARCHAR(32) NOT NULL,
    paid BOOLEAN DEFAULT False,
    cost DECIMAL NOT NULL,
    times TINYINT DEFAULT -1,
    payment VARCHAR(32),
    sales_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    last_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    location_id INT REFERENCES Location(id)
);

CREATE TABLE Subscriber (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    uuid BINARY(16) NOT NULL UNIQUE,
    barcode VARCHAR(13) NOT NULL,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    document_id VARCHAR(32) NOT NULL,
    birthdate DATE NOT NULL,
    address VARCHAR(250) NOT NULL,
    register BOOLEAN NOT NULL DEFAULT False,
    relationship VARCHAR(32),
    subscription_id BINARY(16) REFERENCES Subscription(id),
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(6),
    last_modified DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
);

CREATE TABLE Entry (
    id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    uuid BINARY(16) NOT NULL,
    subscriber BINARY(16) NOT NULL REFERENCES Subscriber(uuid),
    type_entry VARCHAR(15) NOT NULL,
    entry_date DATE NOT NULL DEFAULT CURRENT_DATE,
    entry_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP(6)
);

INSERT INTO Location (uuid, name, capacity, attendance) VALUES ('95715f5088e0466b82bbe35371d6536b','PISCINA',100,0 );
INSERT INTO Location (uuid, name, capacity, attendance) VALUES ('3fa85f6457174562b3fc2c963f66afa6','POLIDEPORTIVO',500,0 );

INSERT INTO Subscription (uuid, start_date, end_date, type, cost, payment, times, location_id)
VALUES ('3fa85f6457174562b3fc2c963f66afa6','2021-06-11','2021-09-15','0',90,'0',-1, 1);
INSERT INTO Subscription (uuid, start_date, end_date, type, cost, payment, times, location_id)
VALUES ('95715f5088e0466b82bbe35371d6536b','2021-06-11','2021-09-15','1',45,'0', 10, 1);
INSERT INTO Subscriber (uuid, name, surname, document_id, birthdate, address, register, subscription_id,  barcode)
VALUES ( '3fa85f6457174562b3fc2c963f66afa6','SANTIAGO','GONZALEZ','49010835C','1982-06-21','CALLE DE CASTILLA MADRID',False, 1, '400763000011');
INSERT INTO Subscriber (uuid, name, surname, document_id, birthdate, address, register, subscription_id,  barcode)
VALUES ( '95715f5088e0466b82bbe35371d6536b','JORGE','GONZALEZ','49010835C','1990-02-05','PLAZA DE PARIS FUENLABRADA',False, 2, '400763000012');


