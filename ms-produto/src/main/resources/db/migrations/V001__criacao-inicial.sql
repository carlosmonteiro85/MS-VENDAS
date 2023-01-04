CREATE TABLE `produtos`(
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codigo_barras` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `preco` decimal(19,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_daeo2r0ngi2v5ejdny1pcus89` (`codigo_barras`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;