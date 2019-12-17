insert into credencial (nome) values ('admin');
insert into autorizacao (nome) values ('admin');
insert into credencial_autorizacoes values (1,1);

insert into credencial (nome) values ('web');
insert into autorizacao (nome) values ('web');
insert into credencial_autorizacoes values (2,2);

insert into credencial (nome) values ('usuario');
insert into autorizacao (nome) values ('cadastra_usuario');
insert into autorizacao (nome) values ('atualiza_usuario');
insert into autorizacao (nome) values ('remove_usuario');
insert into autorizacao (nome) values ('consulta_usuario');
insert into credencial_autorizacoes values (3,3);
insert into credencial_autorizacoes values (3,4);
insert into credencial_autorizacoes values (3,5);
insert into credencial_autorizacoes values (3,6);

insert into credencial (nome) values ('credencial');
insert into autorizacao (nome) values ('cadastra_credencial');
insert into autorizacao (nome) values ('atualiza_credencial');
insert into autorizacao (nome) values ('remove_credencial');
insert into autorizacao (nome) values ('consulta_credencial');
insert into credencial_autorizacoes values (4,7);
insert into credencial_autorizacoes values (4,8);
insert into credencial_autorizacoes values (4,9);
insert into credencial_autorizacoes values (4,10);

insert into credencial (nome) values ('autorizacao');
insert into autorizacao (nome) values ('cadastra_autorizacao');
insert into autorizacao (nome) values ('atualiza_autorizacao');
insert into autorizacao (nome) values ('remove_autorizacao');
insert into autorizacao (nome) values ('consulta_autorizacao');
insert into credencial_autorizacoes values (5,11);
insert into credencial_autorizacoes values (5,12);
insert into credencial_autorizacoes values (5,13);
insert into credencial_autorizacoes values (5,14);

insert into usuario (username, password, first_name, last_name, email, enabled, locked) values ('kleber', '$2a$04$q8j56WcbSTMViRYqBOfGPOVbUKqSR0tdUoa9awU/cA/TRdPA/krRW', 'Kleber', 'Mota', 'kleber@mail.com', true, false);
insert into usuario_credenciais values (1,1);
insert into usuario_credenciais values (1,3);
insert into usuario_credenciais values (1,4);
insert into usuario_credenciais values (1,5);
