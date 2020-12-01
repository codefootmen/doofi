CREATE TABLE Addresses(
	address_id serial PRIMARY KEY,
	street varchar(100) not null,
	house_number int not null,
	details varchar(100),
	neighbourhood varchar(100),
	city varchar(100) not null
);

CREATE TABLE Clients(
	client_id serial PRIMARY KEY,
	client_name varchar(100),
	cpf varchar(20),
	username varchar(20) not null,
	user_password varchar(100) not null,
    address_id bigint, 
	FOREIGN KEY (address_id) 
        REFERENCES Addresses (address_id)
);

CREATE TABLE Businesses(
	business_id serial PRIMARY KEY,
	business_name varchar(100),
	cnpj varchar(20),
	address_id bigint,
    FOREIGN KEY (address_id)
        REFERENCES Addresses(address_id)
);

CREATE TABLE Products (
	product_id serial PRIMARY KEY,
	product_name varchar (100),
	product_description varchar(100),
	unitary_value int,
	business_id bigint,
	FOREIGN KEY (business_id)
        REFERENCES Businesses (business_id)
);

CREATE TABLE Orders(
	order_id serial PRIMARY KEY,
	created_at TIMESTAMP not null,
	finished_at TIMESTAMP,
	order_description varchar(100),
	quantity int,
    order_status int,
	client_id bigint,
	product_id bigint,
    FOREIGN KEY (client_id)
        REFERENCES Clients (client_id),
    FOREIGN KEY (product_id)
        REFERENCES Products (product_id)
);
