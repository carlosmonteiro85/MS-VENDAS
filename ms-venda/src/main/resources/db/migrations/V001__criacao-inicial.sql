CREATE TABLE `itens` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` decimal(19,2) DEFAULT NULL,
  `quantidade` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `vendas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `numero_nf` varchar(255) DEFAULT NULL,
  `status` int NOT NULL,
  `sub_total` decimal(19,2) DEFAULT NULL,
  `total` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- `ms-vendas`.vendas_itens definition

CREATE TABLE `vendas_itens` (
  `venda_id` bigint NOT NULL,
  `itens_id` bigint NOT NULL,
  KEY `FKaln8owmlfbfmdop0hb51a0ccu` (`itens_id`),
  KEY `FKs0689c5rg32oxo3apisu8h4k0` (`venda_id`),
  CONSTRAINT `FKaln8owmlfbfmdop0hb51a0ccu` FOREIGN KEY (`itens_id`) REFERENCES `itens` (`id`),
  CONSTRAINT `FKs0689c5rg32oxo3apisu8h4k0` FOREIGN KEY (`venda_id`) REFERENCES `vendas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
