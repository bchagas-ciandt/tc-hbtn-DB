-- TABLE
CREATE TABLE tb_aluno (id  integer, email varchar(255), matricula varchar(255), data_nascimento date, nome_completo varchar(255), primary key (id));
CREATE TABLE tb_aluno_tb_endereco (Aluno_id bigint not null, enderecos_id bigint not null, primary key (Aluno_id, enderecos_id), unique (enderecos_id));
CREATE TABLE tb_aluno_tb_telefone (Aluno_id bigint not null, telefones_id bigint not null, primary key (Aluno_id, telefones_id), unique (telefones_id));
CREATE TABLE tb_curso (id  integer, nome varchar(255), sigla varchar(255), materialCurso_id bigint, professor_id bigint, primary key (id));
CREATE TABLE tb_curso_tb_aluno (Curso_id bigint not null, alunos_id bigint not null, primary key (Curso_id, alunos_id));
CREATE TABLE tb_endereco (id  integer, bairro varchar(255), cep integer, cidade varchar(255), endereco varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), primary key (id));
CREATE TABLE tb_material_curso (id  integer, url varchar(255), primary key (id));
CREATE TABLE tb_professor (id  integer, email varchar(255), matricula varchar(255), nomeCompleto varchar(255), primary key (id));
CREATE TABLE tb_telefone (id  integer, ddd varchar(255), numero varchar(255), primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
