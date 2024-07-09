CREATE TABLE Topico (
    id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje TEXT NOT NULL,
    fechaCreacion DATETIME NOT NULL,
    status VARCHAR(50) NOT NULL,
    autor INT NOT NULL,
    curso INT NOT NULL,
    respuestas INT NOT NULL,
    FOREIGN KEY (autor) REFERENCES Usuario(id),
    FOREIGN KEY (curso) REFERENCES Curso(id),
    CONSTRAINT unique_titulo_mensaje UNIQUE (titulo, mensaje)

);