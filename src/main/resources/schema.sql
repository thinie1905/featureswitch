DROP TABLE IF EXISTS USERS_EMPLOYEE;

CREATE TABLE USERS_EMPLOYEE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  email VARCHAR(250) NOT NULL,
  feature_name VARCHAR(250) NOT NULL,
  enable BOOLEAN DEFAULT NULL
);