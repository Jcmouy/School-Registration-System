CREATE TABLE `schoolregistration`.`format` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created` DATE NOT NULL DEFAULT (DATE(CURRENT_TIMESTAMP)),
  `period` VARCHAR(45) NOT NULL,
  `type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `schoolregistration`.`course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created` DATE NOT NULL DEFAULT (DATE(CURRENT_TIMESTAMP)),
  `name` VARCHAR(45) NOT NULL,
  `date_start` DATE NOT NULL,
  `date_end` DATE NOT NULL,
  `formats` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `schoolregistration`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created` DATE NOT NULL DEFAULT (DATE(CURRENT_TIMESTAMP)),  
  `code` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `date_birth` DATE NOT NULL,
  `city` VARCHAR(45) NOT NULL,
  `country` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `schoolregistration`.`course_format` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created` DATE NOT NULL DEFAULT (DATE(CURRENT_TIMESTAMP)),
  `course_id` INT NOT NULL,
  `format_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `course_fk_idx` (`course_id` ASC) VISIBLE,
  INDEX `format_fk_idx` (`format_id` ASC) VISIBLE,
  CONSTRAINT `course_fk`
    FOREIGN KEY (`course_id`)
    REFERENCES `schoolregistration`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `format_fk`
    FOREIGN KEY (`format_id`)
    REFERENCES `schoolregistration`.`format` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
	
CREATE TABLE `schoolregistration`.`student_course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `created` DATE NOT NULL DEFAULT (DATE(CURRENT_TIMESTAMP)),
  `student_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `student_fk_course_idx` (`student_id` ASC) VISIBLE,
  INDEX `course_fk_student_idx` (`course_id` ASC) VISIBLE,
  CONSTRAINT `student_fk_course`
    FOREIGN KEY (`student_id`)
    REFERENCES `schoolregistration`.`student` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `course_fk_student`
    FOREIGN KEY (`course_id`)
    REFERENCES `schoolregistration`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);