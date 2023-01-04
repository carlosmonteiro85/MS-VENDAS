set foreign_key_checks = 0;

delete from vendas_itens;
delete from itens;
delete from vendas;

INSERT INTO vendas
(cpf, nome, numero_nf, status, sub_total, total)
VALUES('12345678911', 'Carlos H Monteiro', '', 0, 0, 0);
