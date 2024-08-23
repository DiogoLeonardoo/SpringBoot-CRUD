INSERT INTO aluno (apelido, celular, cpf, dtNascimento, email, matricula, nome) VALUES('Lelê', '(79)98888-8888', '856.095.680-80', '2009-11-30', 'lele_maria@gmail.com', '123','Letícia Maria Leite de Carvalho');
INSERT INTO aluno (apelido, celular, cpf, dtNascimento, email, matricula, nome) VALUES('Lulu', '(79)99999-9999', '167.832.820-07', '2016-03-30', 'lulu_maria@gmail.com', '456','Luiza Maria Leite de Carvalho');
INSERT INTO aluno (apelido, celular, cpf, dtNascimento, email, matricula, nome) VALUES('Jojo', '(79)97777-7777', '123.456.789-10', '2005-06-15', 'jojo@gmail.com', '789', 'João Silva');
INSERT INTO aluno (apelido, celular, cpf, dtNascimento, email, matricula, nome) VALUES('Mimi', '(79)96666-6666', '234.567.890-11', '2006-07-25', 'mimi@gmail.com', '101', 'Maria Santos');
INSERT INTO aluno (apelido, celular, cpf, dtNascimento, email, matricula, nome) VALUES('Zezo', '(79)95555-5555', '345.678.901-12', '2007-08-05', 'zezo@gmail.com', '112', 'José Pereira');
INSERT INTO aluno (apelido, celular, cpf, dtNascimento, email, matricula, nome) VALUES('Lili', '(79)94444-4444', '456.789.012-13', '2008-09-15', 'lili@gmail.com', '126', 'Lívia Costa');
INSERT INTO aluno (apelido, celular, cpf, dtNascimento, email, matricula, nome) VALUES('Gugu', '(79)93333-3333', '567.890.123-14', '2009-10-25', 'gugu@gmail.com', '134', 'Gustavo Almeida');


INSERT INTO disciplina (id, nome, numeroCreditos) VALUES(1,'Programação I', 4);
INSERT INTO disciplina (id, nome, numeroCreditos) VALUES(2,'Programação II', 4);
INSERT INTO disciplina (id, nome, numeroCreditos) VALUES(3,'Programação III', 4);
INSERT INTO disciplina (id, nome, numeroCreditos) VALUES(4,'Banco de Dados I', 4);
INSERT INTO disciplina (id, nome, numeroCreditos) VALUES(5,'Banco de Dados II', 4);


INSERT INTO professor (id, nome, cpf, email, dataNascimento, celular, matricula) VALUES(1, 'Glauco Luiz Rezende de Carvalho', '009.717.570-62', 'glauco.carvalho@academico.ifs.edu.br', '1979-10-09', '(79)98113-0366', 'PROF12345');

/* Ao inserir uma turma, consigo relacionar um ID de professor e um ID de discplina */

INSERT INTO turma (dataInicio, idProfessor, idDisciplina) VALUES ('2022-01-01', 1, 1);
INSERT INTO turma (dataInicio, idProfessor, idDisciplina) VALUES ('2022-01-01', 1, 2);
INSERT INTO turma (dataInicio, idProfessor, idDisciplina) VALUES ('2022-01-01', 1, 3);
INSERT INTO turma (dataInicio, idProfessor, idDisciplina) VALUES ('2022-01-01', 1, 4);
INSERT INTO turma (dataInicio, idProfessor, idDisciplina) VALUES ('2022-01-01', 1, 5);


/*  Inserindo matriculas e linkando com alunos */

INSERT INTO matricula (idAluno) VALUES
(1),
(2),
(3),
(4),
(5),
(6),
(7);

/* Inserindo matriculas e linkando com turmas */

INSERT INTO turma_matricula (matricula_id, turma_id) VALUES
(1, 1),
(2, 2),
(3, 2),
(5, 1),
(6, 3),
(7, 3),
(2, 1),
(3, 4),
(6, 5);










