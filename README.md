This program build two REST and SOAP Web Services



-------------------------REST WEB SERVICE---------------------

Rest Web services can be accessed via the URLS :

http://localhost:8080/UnicoAssignment/rest/unico/push/1/2

http://localhost:8080/UnicoAssignment/rest/unico/list

Assumption - The ActiveMQ details have been assumed



-------------------------SOAP Web Service----------------------

SOAP Web service has been built using Bottom up approach

The WSDL file has been generated using the web service class

The Web Service has been tested using the Web Services Explorer

The Web service provides the greatest common divisor , the list of all the greatest common divisors and the sum of all the greatest common divisors stored in the database.


------------------------------------------------------------------
Below tables have been created in the database as mentioned in the hibernate.cfg.xml

CREATE  TABLE Users (
  UserId INTEGER not null,
  UserName VARCHAR(45) NOT NULL ,
  Password VARCHAR(45) NOT NULL ,  
  PRIMARY KEY (UserId));
  
  INSERT INTO Users VALUES ('user1','123456');
INSERT INTO Users VALUES ('user2','123456');


CREATE TABLE InputNumbers
(
InputNumberId INTEGER not null,
InputNumber INTEGER not null,
PRIMARY KEY (InputNumberId));
)


CREATE TABLE Gcd
(
GcdId INTEGER not null,
Gcd INTEGER not null,
PRIMARY KEY (GcdId));
)

---------------------------------------------------------------------------------------------------