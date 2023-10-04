CREATE DATABASE ecoswap;
USE ecoswap;

CREATE TABLE IF NOT EXISTS Usuarios (
  id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(45) NOT NULL UNIQUE,
  senha VARCHAR(45) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  cidade VARCHAR(45) NOT NULL,
  UF CHAR(2) NOT NULL,
  CEP INT NOT NULL,
  rua VARCHAR(45) NOT NULL,
  numero_rua INT NOT NULL,
  complemento VARCHAR(45) NULL
);

CREATE TABLE IF NOT EXISTS Categorias (
  id_categoria INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(45) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Produtos (
  id_produto INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_categoria INT NOT NULL,
  id_usuario INT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  FOREIGN KEY (id_categoria) REFERENCES Categorias (id_categoria),
  FOREIGN KEY (id_usuario) REFERENCES Usuarios (id_usuario)
);

CREATE TABLE IF NOT EXISTS Trocas (
  id_troca INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  id_usuario INT NOT NULL,
  id_produto INT NOT NULL,
  finalizada TINYINT NULL,
  data_criacao DATETIME NOT NULL,
  data_conclusao VARCHAR(45) NULL,
  FOREIGN KEY (id_usuario) REFERENCES Usuarios (id_usuario),
  FOREIGN KEY (id_produto) REFERENCES Produtos (id_produto)
);

CREATE TABLE IF NOT EXISTS Propostas (
  id_proposta INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_troca INT NOT NULL,
  id_usuario INT NOT NULL,
  id_produto INT NOT NULL,
  aceito TINYINT NULL,
  data_criacao DATETIME NOT NULL,
  data_conclusao VARCHAR(45) NULL,
  FOREIGN KEY (id_troca) REFERENCES Trocas (id_troca),
  FOREIGN KEY (id_usuario) REFERENCES Usuarios (id_usuario),
  FOREIGN KEY (id_produto) REFERENCES Produtos (id_produto)
);

CREATE TABLE IF NOT EXISTS Avaliacoes (
  id_avaliacao INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  id_proposta INT NOT NULL,
  id_troca INT NOT NULL,
  id_usuario_troca INT NOT NULL,
  id_usuario_proposta INT NOT NULL,
  avaliacao_proposta DOUBLE NULL,
  avaliacao_troca DOUBLE NULL,
  FOREIGN KEY (id_troca) REFERENCES Trocas (id_troca),
  FOREIGN KEY (id_usuario_troca) REFERENCES Usuarios (id_usuario),
  FOREIGN KEY (id_proposta) REFERENCES Propostas (id_proposta),
  FOREIGN KEY (id_usuario_proposta) REFERENCES Usuarios (id_usuario)
);