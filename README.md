Simple bank account manager with login and register connected to mysql database
Table declared as :
Create table users (
user_id int not null AUTO_INCREMENT, 
login varchar(32) UNIQUE NOT NULL,
password varchar(32) NOT NULL,
email varchar(32) NOT NULL,
balance int NOT NULL,
PRIMARY KEY(user_id)
);
