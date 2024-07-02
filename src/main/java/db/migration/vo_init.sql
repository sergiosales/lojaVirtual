/*
SQLyog Ultimate - MySQL GUI v8.21 
MySQL - 8.3.0 : Database - lojavirtual
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lojavirtual` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `lojavirtual2`;

/*Table structure for table `acessos` */

DROP TABLE IF EXISTS `acessos`;

CREATE TABLE `acessos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `acessos` */

/*Table structure for table `avaliacao_produto` */

DROP TABLE IF EXISTS `avaliacao_produto`;

CREATE TABLE `avaliacao_produto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `nota` int NOT NULL,
  `pessoa_id` bigint NOT NULL,
  `produto_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `produt_fk` (`produto_id`),
  CONSTRAINT `produt_fk` FOREIGN KEY (`produto_id`) REFERENCES `produtos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `avaliacao_produto` */

insert  into `avaliacao_produto`(`id`,`descricao`,`nota`,`pessoa_id`,`produto_id`) values (1,'bola',5,1,1);

/*Table structure for table `categorias` */

DROP TABLE IF EXISTS `categorias`;

CREATE TABLE `categorias` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `categorias` */

/*Table structure for table `conta_pagar` */

DROP TABLE IF EXISTS `conta_pagar`;

CREATE TABLE `conta_pagar` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `dt_pagamento` date DEFAULT NULL,
  `dt_vencimento` date NOT NULL,
  `status` tinyint NOT NULL,
  `valor_desconto` decimal(38,2) DEFAULT NULL,
  `valor_total` decimal(38,2) NOT NULL,
  `pessoa_id` bigint NOT NULL,
  `pessoa_forn_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `conta_pagar_chk_1` CHECK ((`status` between 0 and 4))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `conta_pagar` */

/*Table structure for table `conta_receber` */

DROP TABLE IF EXISTS `conta_receber`;

CREATE TABLE `conta_receber` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `dt_pagamento` date DEFAULT NULL,
  `dt_vencimento` date NOT NULL,
  `status` tinyint NOT NULL,
  `valor_desconto` decimal(38,2) DEFAULT NULL,
  `valor_total` decimal(38,2) NOT NULL,
  `pessoa_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `conta_receber_chk_1` CHECK ((`status` between 0 and 3))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `conta_receber` */

/*Table structure for table `cupom_desconto` */

DROP TABLE IF EXISTS `cupom_desconto`;

CREATE TABLE `cupom_desconto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cod_descricao` varchar(255) NOT NULL,
  `data_validade_cupon` datetime(6) NOT NULL,
  `valor_porcent_desc` decimal(38,2) DEFAULT NULL,
  `valor_real_desconto` decimal(38,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `cupom_desconto` */

/*Table structure for table `enderecos` */

DROP TABLE IF EXISTS `enderecos`;

CREATE TABLE `enderecos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) NOT NULL,
  `cep` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `complemento` varchar(255) NOT NULL,
  `logradouro` varchar(255) NOT NULL,
  `numero` varchar(255) NOT NULL,
  `tipo_endereco` enum('Cobrança','Entrega') NOT NULL,
  `uf` varchar(255) NOT NULL,
  `pessoa_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `enderecos` */

/*Table structure for table `forma_pagamento` */

DROP TABLE IF EXISTS `forma_pagamento`;

CREATE TABLE `forma_pagamento` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `forma_pagamento` */

/*Table structure for table `imagem_produtos` */

DROP TABLE IF EXISTS `imagem_produtos`;

CREATE TABLE `imagem_produtos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `imagem_miniaturar` text NOT NULL,
  `imagem_original` text NOT NULL,
  `produto_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `produto_fk` (`produto_id`),
  CONSTRAINT `produto_fk` FOREIGN KEY (`produto_id`) REFERENCES `produtos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `imagem_produtos` */

/*Table structure for table `item_venda` */

DROP TABLE IF EXISTS `item_venda`;

CREATE TABLE `item_venda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `qtd` double NOT NULL,
  `produto_id` bigint NOT NULL,
  `venda_loja_virutal_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `produto_id_fk` (`produto_id`),
  KEY `venda_loja_virutal_fk` (`venda_loja_virutal_id`),
  CONSTRAINT `produto_id_fk` FOREIGN KEY (`produto_id`) REFERENCES `produtos` (`id`),
  CONSTRAINT `venda_loja_virutal_fk` FOREIGN KEY (`venda_loja_virutal_id`) REFERENCES `venda_loja_virtual` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `item_venda` */

/*Table structure for table `marcas` */

DROP TABLE IF EXISTS `marcas`;

CREATE TABLE `marcas` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `marcas` */

/*Table structure for table `nota_fiscal_compra` */

DROP TABLE IF EXISTS `nota_fiscal_compra`;

CREATE TABLE `nota_fiscal_compra` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_compra` date NOT NULL,
  `descricao_obs` varchar(255) DEFAULT NULL,
  `numero_nota` varchar(255) NOT NULL,
  `serie_nota` varchar(255) NOT NULL,
  `valor_desconto` decimal(38,2) DEFAULT NULL,
  `valor_icms` decimal(38,2) NOT NULL,
  `valor_total` decimal(38,2) NOT NULL,
  `conta_pagar_id` bigint NOT NULL,
  `pessoa_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `conta_pagar_fk` (`conta_pagar_id`),
  CONSTRAINT `conta_pagar_fk` FOREIGN KEY (`conta_pagar_id`) REFERENCES `conta_pagar` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `nota_fiscal_compra` */

/*Table structure for table `nota_fiscal_venda` */

DROP TABLE IF EXISTS `nota_fiscal_venda`;

CREATE TABLE `nota_fiscal_venda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `numero` varchar(255) NOT NULL,
  `pdf` text NOT NULL,
  `serie` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `xml` text NOT NULL,
  `venda_loja_virtual_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `venda_loja_virtual_fk` (`venda_loja_virtual_id`),
  CONSTRAINT `venda_loja_virtual_fk` FOREIGN KEY (`venda_loja_virtual_id`) REFERENCES `venda_loja_virtual` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `nota_fiscal_venda` */

/*Table structure for table `nota_item_produto` */

DROP TABLE IF EXISTS `nota_item_produto`;

CREATE TABLE `nota_item_produto` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `qtd` double NOT NULL,
  `nota_fiscal_compra_id` bigint NOT NULL,
  `produto_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nota_fiscal_produto_fk` (`nota_fiscal_compra_id`),
  KEY `nota_produto_fk` (`produto_id`),
  CONSTRAINT `nota_fiscal_produto_fk` FOREIGN KEY (`nota_fiscal_compra_id`) REFERENCES `nota_fiscal_compra` (`id`),
  CONSTRAINT `nota_produto_fk` FOREIGN KEY (`produto_id`) REFERENCES `produtos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `nota_item_produto` */

/*Table structure for table `pessoa_fisica` */

DROP TABLE IF EXISTS `pessoa_fisica`;

CREATE TABLE `pessoa_fisica` (
  `id` bigint NOT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `cpf` varchar(255) NOT NULL,
  `data_nascimento` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `pessoa_fisica` */

/*Table structure for table `pessoa_juridica` */

DROP TABLE IF EXISTS `pessoa_juridica`;

CREATE TABLE `pessoa_juridica` (
  `id` bigint NOT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `telefone` varchar(255) NOT NULL,
  `cnpj` varchar(255) NOT NULL,
  `ins_estadual` varchar(255) NOT NULL,
  `ins_municipal` varchar(255) DEFAULT NULL,
  `nome_fantasia` varchar(255) NOT NULL,
  `razao_social` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `pessoa_juridica` */

/*Table structure for table `produtos` */

DROP TABLE IF EXISTS `produtos`;

CREATE TABLE `produtos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `alerta_qtd_estoque` bit(1) DEFAULT NULL,
  `altura` double NOT NULL,
  `ativo` bit(1) NOT NULL,
  `descricao` text,
  `largura` double NOT NULL,
  `link_youtube` varchar(255) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `peso` double NOT NULL,
  `profundidade` double NOT NULL,
  `qt_alertaestoque` int DEFAULT NULL,
  `qtd_clique` int DEFAULT NULL,
  `qtd_estoque` int NOT NULL,
  `tipo_unidade` varchar(255) NOT NULL,
  `valor_venda` decimal(38,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `produtos` */

insert  into `produtos`(`id`,`alerta_qtd_estoque`,`altura`,`ativo`,`descricao`,`largura`,`link_youtube`,`nome`,`peso`,`profundidade`,`qt_alertaestoque`,`qtd_clique`,`qtd_estoque`,`tipo_unidade`,`valor_venda`) values (1,'',10,'','lkkkkkk',1,NULL,'bola',12,1,20,1,200,'2','200.00');

/*Table structure for table `seq_pessoa` */

DROP TABLE IF EXISTS `seq_pessoa`;

CREATE TABLE `seq_pessoa` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `seq_pessoa` */

insert  into `seq_pessoa`(`next_val`) values (1);

/*Table structure for table `status_rastreio` */

DROP TABLE IF EXISTS `status_rastreio`;

CREATE TABLE `status_rastreio` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `centro_distribuicao` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `venda_loja_virtual_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `venda_loja_virtualfk` (`venda_loja_virtual_id`),
  CONSTRAINT `venda_loja_virtualfk` FOREIGN KEY (`venda_loja_virtual_id`) REFERENCES `venda_loja_virtual` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `status_rastreio` */

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_atual` date NOT NULL,
  `login` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL,
  `pessoa_id` bigint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `usuarios` */

/*Table structure for table `usuarios_acessos` */

DROP TABLE IF EXISTS `usuarios_acessos`;

CREATE TABLE `usuarios_acessos` (
  `usuario_id` bigint NOT NULL,
  `acesso_id` bigint NOT NULL,
  KEY `unique_acesso_user` (`usuario_id`,`acesso_id`),
  KEY `acesso_fk` (`acesso_id`),
  CONSTRAINT `acesso_fk` FOREIGN KEY (`acesso_id`) REFERENCES `acessos` (`id`),
  CONSTRAINT `usuario_fk` FOREIGN KEY (`usuario_id`) REFERENCES `usuarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `usuarios_acessos` */

/*Table structure for table `venda_loja_virtual` */

DROP TABLE IF EXISTS `venda_loja_virtual`;

CREATE TABLE `venda_loja_virtual` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_entrega` date NOT NULL,
  `data_venda` date NOT NULL,
  `dia_entrega` int NOT NULL,
  `valor_desconto` decimal(38,2) DEFAULT NULL,
  `valor_frete` decimal(38,2) NOT NULL,
  `valor_total` decimal(38,2) NOT NULL,
  `cupom_desconto_id` bigint NOT NULL,
  `endereco_compra_id` bigint NOT NULL,
  `endereco_entrega_id` bigint NOT NULL,
  `forma_pagamento_id` bigint NOT NULL,
  `nota_fiscal_venda_id` bigint DEFAULT NULL,
  `pessoa_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cupom_desconto_fk` (`cupom_desconto_id`),
  KEY `endereco_compra_fk` (`endereco_compra_id`),
  KEY `endereco_entrega_fk` (`endereco_entrega_id`),
  KEY `forma_pagamento_fk` (`forma_pagamento_id`),
  KEY `nota_fiscal_venda_fk` (`nota_fiscal_venda_id`),
  CONSTRAINT `cupom_desconto_fk` FOREIGN KEY (`cupom_desconto_id`) REFERENCES `cupom_desconto` (`id`),
  CONSTRAINT `endereco_compra_fk` FOREIGN KEY (`endereco_compra_id`) REFERENCES `enderecos` (`id`),
  CONSTRAINT `endereco_entrega_fk` FOREIGN KEY (`endereco_entrega_id`) REFERENCES `enderecos` (`id`),
  CONSTRAINT `forma_pagamento_fk` FOREIGN KEY (`forma_pagamento_id`) REFERENCES `forma_pagamento` (`id`),
  CONSTRAINT `nota_fiscal_venda_fk` FOREIGN KEY (`nota_fiscal_venda_id`) REFERENCES `nota_fiscal_venda` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `venda_loja_virtual` */

/* Trigger structure for table `avaliacao_produto` */

DELIMITER $$

/*!50003 DROP TRIGGER*//*!50032 IF EXISTS */ /*!50003 `validaChaveAvalizacaoProduto` */$$

/*!50003 CREATE */ /*!50017 DEFINER = 'root'@'localhost' */ /*!50003 TRIGGER `validaChaveAvalizacaoProduto` BEFORE UPDATE ON `avaliacao_produto` FOR EACH ROW BEGIN
  call validaChave;
    END */$$


DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
