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

CREATE TABLE Subscriptor (
    id BINARY(16) NOT NULL PRIMARY KEY,
    name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    document_id VARCHAR(32) NOT NULL,
    birthdate DATE NOT NULL,
    address VARCHAR(250) NOT NULL,
    subscription_id BINARY(16) REFERENCES Subscription(id)
);

CREATE TABLE Attendance (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP(6)

);