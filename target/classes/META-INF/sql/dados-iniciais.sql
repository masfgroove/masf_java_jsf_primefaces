insert into ramo_atividade (id, descricao) values (1, 'Distribuição de alimentos');
insert into ramo_atividade (id, descricao) values (2, 'Telecomunicações');
insert into ramo_atividade (id, descricao) values (3, 'Vestuário');
insert into ramo_atividade (id, descricao) values (4, 'Lavanderia');
insert into ramo_atividade (id, descricao) values (5, 'Gráfica');
insert into ramo_atividade (id, descricao) values (6, 'Mecânica');
insert into ramo_atividade (id, descricao) values (7, 'Turismo');
insert into ramo_atividade (id, descricao) values (8, 'Saúde');
insert into ramo_atividade (id, descricao) values (9, 'Educação');
insert into ramo_atividade (id, descricao) values (10, 'Lazer');

insert into empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao, ramo_atividade_id) values (1, '70.311.193/0001-87', 'Mercado do João', 'João Mercado e Distribuidor de Alimentos Ltda', 'LTDA', '2009-03-02', 1);
insert into empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao, ramo_atividade_id) values (2, '52.822.994/0001-25', 'Fale Mais', 'Fale Mais Telecom S.A.', 'SA', '1997-12-10', 2);
insert into empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao, ramo_atividade_id) values (3, '41.952.519/0001-57', 'Maria de Souza da Silva', 'Maria de Souza da Silva', 'MEI', '2014-10-15', 3);
insert into empresa (id, cnpj, nome_fantasia, razao_social, tipo, data_fundacao, ramo_atividade_id) values (4, '16.134.777/0001-89', 'Gomes Inovação', 'José Fernando Gomes EIRELI ME', 'EIRELI', '2009-03-02', 4);

-- Dados para a tabela investimento
insert into investimento (id, data, entrada, porcentagem, lucro_dolar, lucro_reais, total_dolares, dias, dolar_hoje, total_reais, data_criacao, data_atualizacao) values
(1, '2024-01-15', 10000.00, 5.5, 550.00, 2750.00, 2000.00, 30, 5.0, 10000.00, '2024-01-01', '2024-01-15'),
(2, '2024-02-20', 20000.00, 6.0, 1200.00, 7200.00, 4000.00, 45, 5.2, 20800.00, '2024-02-01', '2024-02-20'),
(3, '2024-03-10', 15000.00, 4.5, 675.00, 3375.00, 3000.00, 60, 5.1, 15300.00, '2024-03-01', '2024-03-10'),
(4, '2024-04-05', 25000.00, 7.0, 1750.00, 8750.00, 5000.00, 90, 5.3, 26500.00, '2024-04-01', '2024-04-05'),
(5, '2024-05-25', 12000.00, 6.2, 744.00, 3552.00, 2200.00, 15, 5.4, 12800.00, '2024-05-01', '2024-05-25');


INSERT INTO `cursojsfprimefaces`.`investimento`
(`id`, `data`, `data_atualizacao`, `data_criacao`, `dias`, `dolar_hoje`, `entrada`, `lucro_dolar`, `lucro_reais`, `porcentagem`, `razao_social`, `total_dolares`, `total_reais`)
VALUES
(1, '2024-01-15', '2024-01-15', '2024-01-01', 30, 5.0, 10000.00, 500.00, 2500.00, 5.0, 'Empresa A', 2000.00, 10000.00),
(2, '2024-02-20', '2024-02-20', '2024-02-01', 45, 5.2, 20000.00, 1040.00, 5200.00, 5.2, 'Empresa B', 4000.00, 20800.00),
(3, '2024-03-10', '2024-03-10', '2024-03-01', 60, 5.1, 15000.00, 765.00, 3825.00, 5.1, 'Empresa C', 3000.00, 15300.00),
(4, '2024-04-05', '2024-04-05', '2024-04-01', 90, 5.3, 25000.00, 1325.00, 6625.00, 5.3, 'Empresa D', 5000.00, 26500.00),
(5, '2024-05-25', '2024-05-25', '2024-05-01', 15, 5.4, 12000.00, 648.00, 3240.00, 5.4, 'Empresa E', 2400.00, 12800.00);
