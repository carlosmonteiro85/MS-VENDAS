CREATE TABLE `complexo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `status` int NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `unidade_federativa` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `sigla` varchar(255) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `municipio` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `uf_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
CONSTRAINT fk_municipio_uf_id FOREIGN KEY (`uf_id`) REFERENCES `unidade_federativa` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `unidade` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ativo` bit(1) NOT NULL DEFAULT b'1',
  `cnes` varchar(255) DEFAULT NULL,
  `cnpj` varchar(14) NOT NULL,
  `data_vigencia` date NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `justificativa` varchar(255) NOT NULL,
  `porte` varchar(255) DEFAULT NULL,
  `sigla` varchar(10) NOT NULL,
  `status` int DEFAULT NULL,
  `telefone1` varchar(255) DEFAULT NULL,
  `telefone2` varchar(255) DEFAULT NULL,
  `complexo_id` bigint DEFAULT NULL,
  `municipio` varchar(255) DEFAULT NULL,
  `unidade_federativa` varchar(255) DEFAULT NULL,
  `data_criacao` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `data_atualizacao` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  CONSTRAINT fk_unidade_complexo_id FOREIGN KEY (`complexo_id`) REFERENCES `complexo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `hierarquia` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(80) NOT NULL,
  `formula` int DEFAULT NULL,
  `nivel` int NOT NULL,
  `sigla` varchar(10) NOT NULL,
  `status` int DEFAULT NULL,
  `subordinacao_id` bigint DEFAULT NULL,
  `justificativa` varchar(255) DEFAULT NULL,
  `data_vigencia` date DEFAULT NULL,
  `data_criacao` date DEFAULT NULL,
  `data_ultima_alteracao` date DEFAULT NULL,
  PRIMARY KEY (`id`),
CONSTRAINT fk_hierarquia_subordinacao_id FOREIGN KEY (`subordinacao_id`) REFERENCES `hierarquia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `setor` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `acordo_resultado` int DEFAULT NULL,
  `descricao` varchar(80) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `permite_estagio` int DEFAULT NULL,
  `sigla` varchar(10) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `unidade_administrativa` int DEFAULT NULL,
  `hierarquia_id` bigint DEFAULT NULL,
  `setor_id` bigint DEFAULT NULL,
  `unidade_id` bigint NOT NULL,
  `justificativa` varchar(255) DEFAULT NULL,
  `data_vigencia` date DEFAULT NULL,
  `data_criacao` date DEFAULT NULL,
  `data_ultima_alteracao` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT fk_setor_setor_id FOREIGN KEY (`setor_id`) REFERENCES `setor` (`id`),
  CONSTRAINT fk_setor_unidade_id FOREIGN KEY (`unidade_id`) REFERENCES `unidade` (`id`),
  CONSTRAINT fk_setor_hierarquia_id FOREIGN KEY (`hierarquia_id`) REFERENCES `hierarquia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `centro_custo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `abono_emergencia` int NOT NULL,
  `nome` varchar(255) NOT NULL,
  `centro_custo_replica_setor_id` bigint DEFAULT NULL,
  `setor_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT fk_centro_custo_replica_setor_id FOREIGN KEY (`centro_custo_replica_setor_id`) REFERENCES `setor` (`id`),
  CONSTRAINT fk_centro_custo_setor_id FOREIGN KEY (`setor_id`) REFERENCES `setor` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `vinculo_unidade_servico_pessoal` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `status` int DEFAULT NULL,
  `data_cadastro` date NOT NULL,
  `data_remocao` date DEFAULT NULL,
  `unidade_id` bigint DEFAULT NULL,
  `unidade_vinculada_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT fk_vinculo_unidade_servico_pessoal_unidade_vinculada_id FOREIGN KEY (`unidade_vinculada_id`) REFERENCES `unidade` (`id`),
  CONSTRAINT fk_vinculo_unidade_servico_pessoal_unidade_id FOREIGN KEY (`unidade_id`) REFERENCES `unidade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `rev_auditoria` (
  `rev` bigint(20) NOT NULL AUTO_INCREMENT,
  `timestemp` bigint(20) DEFAULT NULL,
  `usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rev`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

CREATE TABLE `historico_alteracao_unidade` (
  `id` bigint(20) NOT NULL,
  `cnes` varchar(255) DEFAULT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `data_vigencia` date DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `logradouro` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `justificativa` varchar(255) DEFAULT NULL,
  `porte` varchar(255) DEFAULT NULL,
  `revtype` int(11) DEFAULT NULL,
  `sigla` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `telefone1` varchar(255) DEFAULT NULL,
  `telefone2` varchar(255) DEFAULT NULL,
  `rev` bigint(20) NOT NULL,
  `complexo_id` bigint(20) DEFAULT NULL,
  `municipio` varchar(255) DEFAULT NULL,
  `unidade_federativa` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK1lilho4rpt4n3tbo2simcpjyw` (`rev`),
  KEY `FK4s91f5xp4hvj5eef8wdbdcyxq` (`complexo_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- sigespapi.historico_alteracao_hierarquia definition

CREATE TABLE `historico_alteracao_hierarquia` (
  `id` bigint NOT NULL,
  `data_vigencia` date DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `formula` int DEFAULT NULL,
  `justificativa` varchar(255) DEFAULT NULL,
  `nivel` int DEFAULT NULL,
  `revtype` int DEFAULT NULL,
  `sigla` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `rev` bigint NOT NULL,
  `subordinacao_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FKi8ik8jsf7evb2lo1g2riw47ne` (`subordinacao_id`),
  CONSTRAINT `FKi8ik8jsf7evb2lo1g2riw47ne` FOREIGN KEY (`subordinacao_id`) REFERENCES `hierarquia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `classe_teste` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) ,
  `classe_aninhada1` bigint ,
  `classe_aninhada2` bigint ,
  `classe_aninhada3` bigint ,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ;

-- sigespapi.historico_alteracao_setor definition

CREATE TABLE `historico_alteracao_setor` (
  `id` bigint NOT NULL,
  `acordo_resultado` int DEFAULT NULL,
  `data_vigencia` date DEFAULT NULL,
  `descricao` varchar(80) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `justificativa` varchar(255) DEFAULT NULL,
  `permite_estagio` int DEFAULT NULL,
  `revtype` int DEFAULT NULL,
  `sigla` varchar(10) DEFAULT NULL,
  `status` int DEFAULT NULL,
  `unidade_administrativa` int DEFAULT NULL,
  `rev` bigint NOT NULL,
  `hierarquia_id` bigint DEFAULT NULL,
  `setor_id` bigint DEFAULT NULL,
  `unidade_id` bigint NOT NULL,
  PRIMARY KEY (`id`,`rev`),
  KEY `FK87wj6ejirxuclkhchq3ryqaig` (`hierarquia_id`),
  KEY `FK60rc7lrel64k02pkq6w50d3uf` (`setor_id`),
  KEY `FKdcscwaethjhnmc5kna8ppaqem` (`unidade_id`),
  CONSTRAINT `FK60rc7lrel64k02pkq6w50d3uf` FOREIGN KEY (`setor_id`) REFERENCES `setor` (`id`),
  CONSTRAINT `FK87wj6ejirxuclkhchq3ryqaig` FOREIGN KEY (`hierarquia_id`) REFERENCES `hierarquia` (`id`),
  CONSTRAINT `FKdcscwaethjhnmc5kna8ppaqem` FOREIGN KEY (`unidade_id`) REFERENCES `unidade` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
