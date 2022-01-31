
CREATE TABLE  IF NOT EXISTS `serasa`.`user`(
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(150) NULL,
  `cpf` VARCHAR(11) NULL,
  `email` VARCHAR(250) NULL,
  `phone_number` varchar(20) NULL,
  `created_at` DATETIME NULL, 
  `updated_at` DATETIME NULL,   
  PRIMARY KEY (`id`));


  