CREATE DATABASE IF NOT EXISTS eventos_db;
USE eventos_db;

-- Tabla: Intereses
CREATE TABLE Intereses (
    id_interes INT AUTO_INCREMENT PRIMARY KEY,
    int_v1 VARCHAR(45),
    int_v2 VARCHAR(45),
    int_v3 VARCHAR(45)
);

-- Tabla: Usuarios
CREATE TABLE Usuarios (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    d_nombre VARCHAR(45),
    d_ap1 VARCHAR(45),
    d_ap2 VARCHAR(45),
    d_email VARCHAR(45),
    d_password VARCHAR(45),
    -- Campos de dirección integrados
    dir_tipoVia VARCHAR(45),
    dir_via VARCHAR(45),
    dir_numVia VARCHAR(45),
    dir_piso VARCHAR(45),
    dir_puerta VARCHAR(45),
    dir_codigo VARCHAR(45),
    dir_provin VARCHAR(45),
    dir_pobla VARCHAR(45),
    dir_infoExtra VARCHAR(255),
    -- Otros campos
    id_interes INT,
    d_rol ENUM('admin','organizador','usuario'),
    FOREIGN KEY (id_interes) REFERENCES Intereses(id_interes)
        ON DELETE SET NULL
        ON UPDATE CASCADE
);

-- Tabla: Eventos
CREATE TABLE Eventos (
    id_evento INT AUTO_INCREMENT PRIMARY KEY,
    ev_organ INT,
    ev_fecha DATE,
    ev_titulo VARCHAR(80),
    ev_desc VARCHAR(200),
    ev_maxPartic INT,
    ev_pro TINYINT,
    ev_tag1 VARCHAR(45),
    ev_tag2 VARCHAR(45),
    ev_tag3 VARCHAR(45),
    ev_precio VARCHAR(45),
    -- Campos de dirección integrados
    dir_tipoVia VARCHAR(45),
    dir_via VARCHAR(45),
    dir_numVia VARCHAR(45),
    dir_piso VARCHAR(45),
    dir_puerta VARCHAR(45),
    dir_codigo VARCHAR(45),
    dir_provin VARCHAR(45),
    dir_pobla VARCHAR(45),
    dir_infoExtra VARCHAR(255),
    FOREIGN KEY (ev_organ) REFERENCES Usuarios(id_cliente)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

-- Tabla intermedia: Usuarios_Eventos (relación N:M)
CREATE TABLE Usuarios_Eventos (
    idUsuarios_Eventos INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT,
    id_evento INT,
    FOREIGN KEY (id_cliente) REFERENCES Usuarios(id_cliente)
        ON DELETE CASCADE
        ON UPDATE CASCADE,
    FOREIGN KEY (id_evento) REFERENCES Eventos(id_evento)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);
