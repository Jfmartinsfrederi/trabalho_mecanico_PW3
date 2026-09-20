create table consertos(
    id UUID not null,
    data_entrada date not null ,
    data_saida date not null ,
    cpf VARCHAR(20) not null unique ,
    nome VARCHAR(50) not null,
    anos_exp int,
    data_entrada_oficina date not null,
    marca VARCHAR(50) not null,
    modelo VARCHAR(50) not null,
    ano_lancamento date not null,
    primary key (id)




)