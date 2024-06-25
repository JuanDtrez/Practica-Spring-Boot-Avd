-- Tabla para Mascota
CREATE TABLE TBL_PETS (
    id_pets BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    fecha_nac DATE,
    raza VARCHAR(255) NOT NULL,
    peso DOUBLE NOT NULL,
    tiene_chip BOOLEAN NOT NULL,
    url_foto VARCHAR(255) NOT NULL
);

-- Tabla para Usuario
CREATE TABLE TBL_USERS (
    id_user BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    telefono VARCHAR(255)
);

-- Tabla para MascotaAdoptada
CREATE TABLE TBL_ADOPTIONS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    usuario_id BIGINT,
    mascota_id BIGINT,
    fecha_adopcion DATE,
    CONSTRAINT fk_usuario FOREIGN KEY (usuario_id) REFERENCES TBL_USERS(id_user),
    CONSTRAINT fk_mascota FOREIGN KEY (mascota_id) REFERENCES TBL_PETS(id_pets)
);
