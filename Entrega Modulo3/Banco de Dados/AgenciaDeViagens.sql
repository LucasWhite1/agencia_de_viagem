DROP DATABASE IF EXISTS bdagencia;

CREATE DATABASE IF NOT EXISTS bdAgencia;

USE bdAgencia;

CREATE TABLE cliente (
    nome_cliente varchar(40),
    RG varchar(15) PRIMARY KEY,
    passaporte varchar(20),
    endereco_email varchar(40),
    numero_telefone varchar(20)
);

CREATE TABLE reserva (
    num_reserva INT PRIMARY KEY auto_increment,
    data_reserva varchar(15),
    metodo_pagamento varchar(20),
    RG_cliente varchar(30),
    FOREIGN KEY(RG_cliente) REFERENCES cliente(RG)
);

CREATE TABLE voo (
    id_voo INT PRIMARY KEY auto_increment,
    quantidade_passageiros INT,
    cidade_origem varchar(30),
    cidade_destino varchar(30),
    num_reserva INT,
    valor_voo float(7,2),
    FOREIGN KEY(num_reserva) REFERENCES reserva(num_reserva)
);

-- Inserindo (create) dados

INSERT INTO cliente (nome_cliente, RG, passaporte, endereco_email, numero_telefone) VALUES

('Carlos Silva', '98765432100', 'CS123456', 'carlos@email.com', '81234567890'),

('Juliana Santos', '98765432101', 'JS123456', 'juliana@email.com', '82345678901');

INSERT INTO reserva (data_reserva, metodo_pagamento, RG_cliente) VALUES

('18/09/2023', 'cartão de crédito', '98765432100'),

('04/02/2022', 'boleto bancário', '98765432101');

INSERT INTO voo (quantidade_passageiros, cidade_origem, cidade_destino, num_reserva, valor_voo) VALUES

(2, 'Rio de Janeiro', 'Salvador', 1, 800.00),
(2, 'Brasília', 'Recife', 2, 750.00);

-- Consultando (read) dados

SELECT * FROM cliente;

SELECT * FROM reserva;

SELECT * FROM voo;

-- Atualizando (update) dados

UPDATE cliente SET nome_cliente = 'Felipe Pereira', passaporte = 'FP123456', endereco_email = 'felipe@email', numero_telefone = '89987654321' WHERE RG = '98765432101';
UPDATE voo SET quantidade_passageiros = 3, cidade_origem = 'Manaus', cidade_destino = 'Cuiabá', valor_voo = 500.00 WHERE id_voo = 2;
UPDATE reserva SET data_reserva = '10/09/2023', metodo_pagamento = 'PIX' WHERE num_reserva = 2;

-- Deletando (delete) dados

DELETE FROM cliente WHERE RG = '98765432102';

DELETE FROM voo WHERE id_voo = 2;

DELETE FROM reserva WHERE num_reserva = 2;