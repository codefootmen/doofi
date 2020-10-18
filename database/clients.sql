Create table Addresses(
	addressId bigint not null PRIMARY KEY,
	street varchar(100) not null,
	houseNumber int not null,
	details varchar(100),
	neighbourhood varchar(100),
	city varchar(100) not null
)

Create table Clients(
	clientId bigint not null PRIMARY KEY,
	name varchar(100),
	cpf varchar(20),
	username varchar(20) not null,
	userPassword varchar(100) not null,
	addressId bigint FOREIGN KEY REFERENCES Addresses(addressId)
)


CREATE TABLE Businesses(
	businessId bigint not null PRIMARY KEY,
	name varchar(100),
	cnpj varchar(20),
	addressId bigint FOREIGN KEY REFERENCES Addresses(addressId)
)



CREATE TABLE Orders(
	orderId bigint not null PRIMARY KEY,
	createdAt DATETIME not null,
	finishedAt DATETIME,
	orderDescription varchar(100),
	clientId bigint FOREIGN KEY REFERENCES Clients(clientId)
)