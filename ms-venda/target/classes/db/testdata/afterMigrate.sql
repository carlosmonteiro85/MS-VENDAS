set foreign_key_checks = 0;

delete from unidade_federativa;
delete from municipio;
delete from complexo;
delete from unidade;
delete from hierarquia;
delete from historico_alteracao_unidade;
delete from rev_auditoria;
delete from vinculo_unidade_servico_pessoal;
delete from setor;
delete from historico_alteracao_setor;
delete from historico_alteracao_hierarquia;



set foreign_key_checks = 1;

INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (1, 'Acre', 'AC');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (2, 'Alagoas', 'AL');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (3, 'Amapá', 'AP');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (4, 'Amazonas', 'AM');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (5, 'Bahia', 'BA');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (6, 'Ceará', 'CE');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (7, 'Distrito Federal', 'DF');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (8, 'Espírito Santo', 'ES');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (9, 'Goiás', 'GO');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (10, 'Maranhão', 'MA');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (11, 'Mato Grosso', 'MT');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (12, 'Mato Grosso do Sul', 'MS');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (13, 'Minas Gerais', 'MG');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (14, 'Pará', 'PA');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (15, 'ParaÍba', 'PB');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (16, 'Paraná', 'PR');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (17, 'Pernambuco', 'PE');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (18, 'Piauí', 'PI');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (19, 'Rio de Janeiro', 'RJ');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (20, 'Rio Grande do Norte', 'RN');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (21, 'Rio Grande do Sul', 'RS');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (22, 'Rondônia', 'RO');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (23, 'Roraima', 'RR');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (24, 'Santa Catarina', 'SC');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (25, 'São Paulo', 'SP');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (26, 'Sergipe', 'SE');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (27, 'Tocantins', 'TO');
INSERT INTO unidade_federativa (id, descricao, sigla) VALUES (28, 'Exterior', 'EX');

INSERT INTO municipio (id, descricao, uf_id) VALUES (1, 'Não Informado', '13');
INSERT INTO municipio (id, descricao, uf_id) VALUES (19, 'Assis Brasil', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (27, 'Brasileia', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (35, 'Cruzeiro do Sul', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (43, 'Feijo', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (51, 'Jordao', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (60, 'Mancio Lima', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (78, 'Manoel Urbano', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (86, 'Marechal Thaumaturgo', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (94, 'Placido de Castro', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (108, 'Porto Acre', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (116, 'Porto Walter', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (124, 'Rio Branco', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (132, 'Sena Madureira', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (140, 'Senador Guiomard', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (159, 'Tarauaca', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (167, 'Xapuri', '1');
INSERT INTO municipio (id, descricao, uf_id) VALUES (175, 'Agua Branca', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (191, 'Anadia', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (213, 'Arapiraca', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (221, 'Atalaia', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (256, 'Barra de Santo Antonio', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (264, 'Barra de Sao Miguel', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (280, 'Batalha', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (299, 'Belem', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (302, 'Belo Monte', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (329, 'Boca da Mata', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (345, 'Branquinha', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (353, 'Cacimbinhas', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (361, 'Cajueiro', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (396, 'Campo Alegre', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (400, 'Campo Grande', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (442, 'Canapi', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (469, 'Capela', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (477, 'Carneiros', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (485, 'Cha Preta', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (493, 'Coite do Noia', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (507, 'Colonia Leopoldina', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (523, 'Coqueiro Seco', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (531, 'Coruripe', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (540, 'Craibas', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (558, 'Delmiro Gouveia', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (566, 'Dois Riachos', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (582, 'Feira Grande', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (590, 'Teotonio Vilela', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (604, 'Feliz Deserto', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (620, 'Flexeiras', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (647, 'Girau do Ponciano', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (655, 'Ibateguara', '2');
INSERT INTO municipio (id, descricao, uf_id) VALUES (663, 'Igaci', '2');

INSERT INTO complexo (id, descricao, status) VALUES (1, 'Descricao teste1', 1);
INSERT INTO complexo (id, descricao, status) VALUES (2, 'Descricao teste2', 1);
INSERT INTO complexo (id, descricao, status) VALUES (3, 'Descricao teste3', 1);
INSERT INTO complexo (id, descricao, status) VALUES (4, 'Descricao teste4', 0);
INSERT INTO complexo (id, descricao, status) VALUES (5, 'Descricao teste5', 1);

INSERT INTO unidade (id, ativo , cnes ,cnpj , data_vigencia ,descricao , email, bairro, cep, complemento, logradouro, numero, justificativa, porte, sigla, status, telefone1, telefone2, complexo_id, municipio, unidade_federativa) VALUES (1, 1,'02615455000147', '93887766554433', utc_timestamp  ,'UNIDADE DE EMERGENCIA','gerusa.chagas@fhemig.mg.gov.br','Bairro teste','15647976','complemento teste','logradouro teste',123,'Justificativa teste','I','test',1,99999999,88888888,1,'Goiania','go');
INSERT INTO unidade (id, ativo , cnes ,cnpj , data_vigencia ,descricao , email, bairro, cep, complemento, logradouro, numero, justificativa, porte, sigla, status, telefone1, telefone2, complexo_id, municipio, unidade_federativa) VALUES (2, 1,'02615455066147', '94887766554433', utc_timestamp  ,'UNIDADE DE TESTE','carlos.monteiro@fhemig.mg.gov.br','Bairro teste','15647976','complemento teste','logradouro teste',132,'Justificativa teste','II','test',1,99999999,88888888,1,'Goiania','go');
INSERT INTO unidade (id, ativo , cnes ,cnpj , data_vigencia ,descricao , email, bairro, cep, complemento, logradouro, numero, justificativa, porte, sigla, status, telefone1, telefone2, complexo_id, municipio, unidade_federativa) VALUES (3, 1,'02615455880147', '95887766554433', utc_timestamp  ,'UNIDADE DE RADIO','everson.ortega@fhemig.mg.gov.br','Bairro teste','15647976','complemento teste','logradouro teste',121,'Justificativa teste','III','test',1,99999999,88888888,1,'Goiania','go');
INSERT INTO unidade (id, ativo , cnes ,cnpj , data_vigencia ,descricao , email, bairro, cep, complemento, logradouro, numero, justificativa, porte, sigla, status, telefone1, telefone2, complexo_id, municipio, unidade_federativa) VALUES (4, 1,'02615455330147', '96887766554433', utc_timestamp  ,'UNIDADE DE AMBULANCIA','camila.silva@fhemig.mg.gov.br','Bairro teste','15647976','complemento teste','logradouro teste',131,'Justificativa teste','IV','test',1,99999999,88888888,1,'Goiania','go');
INSERT INTO unidade (id, ativo , cnes ,cnpj , data_vigencia ,descricao , email, bairro, cep, complemento, logradouro, numero, justificativa, porte, sigla, status, telefone1, telefone2, complexo_id, municipio, unidade_federativa) VALUES (5, 1,'02615455990147', '97887766554433', utc_timestamp  ,'UNIDADE DE ENFERMEIRO','joana.fragoso@fhemig.mg.gov.br','Bairro teste','15647976','complemento teste','logradouro teste',111,'Justificativa teste','I','test',1,99999999,88888888,1,'Goiania','go');

INSERT INTO hierarquia (id, descricao, formula, nivel, sigla, status, subordinacao_id)  VALUES(1, 'hierarquia teste', 1, 1, 'TST', 1, NULL);


INSERT INTO sigespapi.historico_alteracao_unidade(id, cnes, cnpj, data_vigencia, descricao, email, bairro, cep, complemento, logradouro, numero, justificativa, porte, revtype, sigla, status, telefone1, telefone2, rev, complexo_id, municipio, unidade_federativa)
VALUES(1, '654321', '38960356000140', '2022-01-01', 'teste rr update', 'testeupdateasdf@asdf.com', 'bairro', '72231422', 'complemento', 'logradouro', 'numero', 'juffffstificativa unidade', 'I', 0, 'TESTE2133', 1, '33333663333', '333333333333', 9, 1, NULL, 'uf');
INSERT INTO sigespapi.historico_alteracao_unidade(id, cnes, cnpj, data_vigencia, descricao, email, bairro, cep, complemento, logradouro, numero, justificativa, porte, revtype, sigla, status, telefone1, telefone2, rev, complexo_id, municipio, unidade_federativa)
VALUES(1, '654321', '38960356000140', '2022-01-01', 'teste rr update', 'testeupdateasdf@asdf.com', 'bairro', '72231422', 'complemento', 'logradouro', 'numero', 'juffffstificativa unidade', 'I', 1, 'TESTE 125', 1, '33333663333', '333333333333', 10, 1, NULL, 'uf');
INSERT INTO sigespapi.historico_alteracao_unidade(id, cnes, cnpj, data_vigencia, descricao, email, bairro, cep, complemento, logradouro, numero, justificativa, porte, revtype, sigla, status, telefone1, telefone2, rev, complexo_id, municipio, unidade_federativa)
VALUES(1, '654321', '38960356000140', '2022-01-01', 'teste rr update', 'testeupdateasdf@asdf.com', 'bairro', '72231422', 'complemento', 'logradouro', 'numero', 'juffffstificativa unidade', 'I', 1, 'TESTE 125', 1, '8598569696', '333333333333', 11, 1, NULL, 'uf');



INSERT INTO sigespapi.rev_auditoria (rev, timestemp, usuario) VALUES (9, 1641736282000, 'Usuario Logado');
INSERT INTO sigespapi.rev_auditoria (rev, timestemp, usuario) VALUES (10, 1665171419959, 'Usuario Logado');
INSERT INTO sigespapi.rev_auditoria(rev, timestemp, usuario) VALUES (11, 1665171427826, 'Usuario Logado');

INSERT INTO sigespapi.vinculo_unidade_servico_pessoal(id, status, data_cadastro, data_remocao, unidade_id, unidade_vinculada_id)VALUES(1, 1, '2022-10-01', NULL, 2, 1);
INSERT INTO sigespapi.vinculo_unidade_servico_pessoal(id, status, data_cadastro, data_remocao, unidade_id, unidade_vinculada_id)VALUES(2, 1, '2022-10-01', NULL, 3, 4);

INSERT INTO sigespapi.setor
(id, acordo_resultado, descricao, email, permite_estagio, sigla, status, unidade_administrativa, hierarquia_id, setor_id, unidade_id)VALUES(1, 1, 'teste 1', 'email@email.com', 1, 'adc', 1, 1, 1, NULL, 1);
INSERT INTO sigespapi.setor
(id, acordo_resultado, descricao, email, permite_estagio, sigla, status, unidade_administrativa, hierarquia_id, setor_id, unidade_id)VALUES(2, 1, 'teste 2', 'email2@email.com', 1, 'def', 1, 1, 1, 1, 1);
INSERT INTO sigespapi.setor
(id, acordo_resultado, descricao, email, permite_estagio, sigla, status, unidade_administrativa, hierarquia_id, setor_id, unidade_id)VALUES(3, 1, 'teste 3', 'email3@email.com', 1, 'ghi', 1, 1, 1, 1, 1);
INSERT INTO sigespapi.setor
(id, acordo_resultado, descricao, email, permite_estagio, sigla, status, unidade_administrativa, hierarquia_id, setor_id, unidade_id)VALUES(4, 1, 'teste 4', 'email4@email.com', 1, 'jhl', 1, 1, 1, 1, 1);

INSERT INTO setor (id, acordo_resultado, descricao, email, permite_estagio, sigla, status, unidade_administrativa, hierarquia_id, setor_id, unidade_id, justificativa, data_vigencia, data_criacao, data_ultima_alteracao) VALUES (5, 1, "descricao_teste", "email@email.com", 1, "sigla", 1, 1, 1, null, 1, null, null, null, null);

INSERT INTO setor(id, acordo_resultado, descricao, email, permite_estagio, sigla, status, unidade_administrativa, hierarquia_id, setor_id, unidade_id, justificativa, data_vigencia, data_criacao, data_ultima_alteracao)
VALUES(6, 0, 'Descricao', 'teste@teste.com', 0, 'AC/DC', 1, 0, 1, 1, 1, NULL, NULL, '2022-10-07 20:33:54', '2022-10-07 20:33:54');

INSERT INTO rev_auditoria (rev, timestemp, usuario) VALUES(12, 1665174833870, 'Usuario Logado');

INSERT INTO historico_alteracao_setor (id, acordo_resultado, data_vigencia, descricao, email, justificativa, permite_estagio, revtype, sigla, status, unidade_administrativa, rev, hierarquia_id, setor_id, unidade_id)
VALUES(6, 0, NULL, 'Descricao', 'teste@teste.com', NULL, 0, 0, 'AC/DC', 1, 0, 12, 1, 1, 1);

INSERT INTO rev_auditoria (rev, timestemp, usuario) VALUES(13, 1665174915156, 'Usuario Logado');

INSERT INTO historico_alteracao_setor (id, acordo_resultado, data_vigencia, descricao, email, justificativa, permite_estagio, revtype, sigla, status, unidade_administrativa, rev, hierarquia_id, setor_id, unidade_id)
VALUES(6, 0, NULL, 'TESTE', 'teste@teste.com', NULL, 0, 1, 'AC/DC', 1, 1, 13, 1, 1, 1);

INSERT INTO rev_auditoria (rev, timestemp, usuario) VALUES(14, 1666700008692, 'Usuario Logado');
INSERT INTO rev_auditoria (rev, timestemp, usuario) VALUES(15, 1666700008692, 'Usuario Logado');

INSERT INTO historico_alteracao_hierarquia
(id, data_vigencia, descricao, formula, justificativa, nivel, revtype, sigla, status, rev, subordinacao_id)
VALUES(1, NULL, 'teste_edicao', 9, NULL, 1, 0, 'TST', 1, 14, NULL);

INSERT INTO historico_alteracao_hierarquia
(id, data_vigencia, descricao, formula, justificativa, nivel, revtype, sigla, status, rev, subordinacao_id)
VALUES(1, NULL, 'teste_edicao', 9, NULL, 1, 1, 'AC/DC', 1, 15, NULL);