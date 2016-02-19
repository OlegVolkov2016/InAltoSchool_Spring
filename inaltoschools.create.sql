CREATE DATABASE IF NOT EXISTS inaltoschool_s CHARACTER SET utf8 COLLATE utf8_bin;
USE inaltoschool_s;
CREATE TABLE IF NOT EXISTS roles (
	role_id INT(11) AUTO_INCREMENT COMMENT 'Role\'s ID', 
	role_name VARCHAR(50) NOT NULL COMMENT 'Role\'s name', 
	role_details TEXT COMMENT 'Role\'s Information', 
	created TIMESTAMP DEFAULT NOW(),
	PRIMARY KEY (role_id), UNIQUE (role_name)
) ENGINE = InnoDB COMMENT = 'Users roles (rights) table';
INSERT INTO roles (role_name, role_details) VALUES
	("Administrator","Database administrator"),
	("Teacher","School teacher"),
	("Student","School student");
CREATE TABLE IF NOT EXISTS logins (
	login_id INT(11) AUTO_INCREMENT COMMENT 'Login\'s ID', 
	role_id INT(11) NOT NULL COMMENT 'Appropriate role\'s ID', 
	login_name VARCHAR(50) NOT NULL COMMENT 'Login\'s name', 
	login_password INT(11) NOT NULL COMMENT 'Login\'s password hashcode', 
	login_question VARCHAR(50) NOT NULL COMMENT 'Login\'s security question', 
	login_answer INT(11) NOT NULL COMMENT 'Login\'s security answer hashcode', 
	created TIMESTAMP DEFAULT NOW(),
	PRIMARY KEY (login_id), 
	FOREIGN KEY (role_id) REFERENCES roles (role_id) ON DELETE CASCADE ON UPDATE CASCADE, 
	UNIQUE (login_name)
) ENGINE = InnoDB COMMENT = 'Users logins table';
CREATE TABLE IF NOT EXISTS users (
	user_id INT(11) AUTO_INCREMENT COMMENT 'User\'s ID', 
	login_id INT(11) NOT NULL COMMENT 'Appropriate login\'s ID', 
	user_firstname VARCHAR(50) COMMENT 'User\'s first name', 
	user_lastname VARCHAR(50) COMMENT 'User \'s last name', 
	user_birthday DATE COMMENT 'User\'s birthday', 
	user_address VARCHAR(50) COMMENT 'User\'s address', 
	user_phone VARCHAR(13) COMMENT 'User\'s phone', 
	user_email VARCHAR(50) COMMENT 'User\'s email', 
	user_skype VARCHAR(50) COMMENT 'User\'s skype login', 
	user_details TEXT COMMENT 'User\'s information', 
	created TIMESTAMP DEFAULT NOW(),
	PRIMARY KEY (user_id), 
	FOREIGN KEY (login_id) REFERENCES logins (login_id) ON DELETE CASCADE ON UPDATE CASCADE, 
	UNIQUE (login_id)
) ENGINE = InnoDB COMMENT = 'Users data table';