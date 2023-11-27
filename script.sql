create database defaultdb;
use defaultdb;

create table usuarios(
    id_usuario int not null primary key auto_increment,
    nome varchar(100) not null,
    idade int not null,
    sexo varchar(100) not null,
    login varchar(100) not null unique,
    senha varchar(100) not null,
    adm int not null
);

create table livros(
	id_livro int not null primary key auto_increment,
    titulo varchar(100) not null,
    autor varchar(100) not null,
    genero varchar(100) not null,
    nota double null
);


