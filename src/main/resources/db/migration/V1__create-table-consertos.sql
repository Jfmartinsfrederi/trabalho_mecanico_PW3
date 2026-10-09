create table consertos(
    id bigint not null auto_increment,
    data_entrada date not null ,
    data_saida date not null ,
    nome VARCHAR(50) not null,
    anos_exp int,
    marca VARCHAR(50) not null,
    modelo VARCHAR(50) not null,
    ano_lancamento VARCHAR(4) not null,
    primary key (id)




)