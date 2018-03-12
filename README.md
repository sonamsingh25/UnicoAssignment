This program build two REST and SOAP Web Services



-------------------------REST WEB SERVICE---------------------

Rest Web service takes the input parameters and push them to the ActiveMQ

Rest Web Service gets the list of all input numbers from the DB

The Listener listening to the queue read the numbers and pushes it to a Java Queue so that the numbers can be read in the SOAP WEb service for finding the greatest common divisor

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