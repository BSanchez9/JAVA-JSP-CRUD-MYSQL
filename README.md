# CRUD Maven (CRUD_UMC)

Este projeto é uma aplicação web simples desenvolvida em Java, utilizando o Maven como ferramenta de construção e o padrão CRUD (Create, Read, Update, Delete) para gerenciar a entidade `Candidato`.

## 🚀 Tecnologias Utilizadas

*   **Linguagem:** Java (versão 1.8)
*   **Build Tool:** Apache Maven
*   **Web:** Java EE (Servlets, JSP)
*   **Banco de Dados:** MySQL
*   **Conexão:** JDBC

## 🛠️ Pré-requisitos

Para executar este projeto, você precisará ter instalado:

1.  **JDK 8** ou superior.
2.  **Apache Maven** (para compilar e empacotar).
3.  Um **Servidor de Aplicação Web** compatível com Java EE (ex: Apache Tomcat, WildFly).
4.  Um servidor **MySQL** em execução.

## ⚙️ Configuração do Banco de Dados

O projeto está configurado para se conectar a um banco de dados MySQL.

### 1. Criação do Banco de Dados e Tabela

Execute o seguinte script SQL no seu servidor MySQL para criar o banco de dados `CANDIDATO` e a tabela `CANDIDATOS`:

```sql
CREATE DATABASE CANDIDATO;
USE CANDIDATO;
CREATE TABLE CANDIDATOS (
    ID SERIAL NOT NULL,
    NOME VARCHAR(500) NOT NULL,
    CPF VARCHAR(11) NOT NULL,
    NASCIMENTO DATE NOT NULL,
    ENDERECO VARCHAR(40) NOT NULL,
    NUMERO FLOAT(30) NOT NULL,
    CEP float(8) NOT NULL,
    BAIRRO VARCHAR(500) NOT NULL,
    AREAINTERESSE VARCHAR(500) NOT NULL,
    DEFICIENCIA BOOLEAN,
    PRIMARY KEY (ID)
);
```

**Nota sobre Tipos de Dados:** Os campos `NUMERO` e `CEP` foram definidos como `FLOAT` no script fornecido. Embora o projeto funcione com essa definição, é uma prática recomendada usar `VARCHAR` ou `INT` para esses campos, pois eles não são valores matemáticos que exigem precisão de ponto flutuante.

### 2. Configuração da Conexão

Os parâmetros de conexão estão definidos no arquivo `src/main/java/com/da/crudmaven/util/Conexao.java`.

| Parâmetro | Valor Padrão |
| :--- | :--- |
| **URL** | `jdbc:mysql://127.0.0.1:3306/candidato` |
| **USUARIO** | `root` |
| **SENHA** | `(vazio)` |

**Atenção:** Se o seu usuário MySQL (`root`) tiver uma senha, você deve alterar a constante `SENHA` no arquivo `Conexao.java`.

## 📦 Como Compilar e Executar

### 1. Compilação

Navegue até o diretório raiz do projeto (`com.da_CRUDMaven_war_1.0-SNAPSHOT`) e execute o Maven para compilar e gerar o arquivo `.war`:

```bash
mvn clean install
```

O arquivo `.war` será gerado no diretório `target/`.

### 2. Implantação (Deploy)

Copie o arquivo `CRUDMavenre-1.0-SNAPSHOT.war` (ou o nome gerado) para o diretório de implantação (`webapps/`) do seu servidor de aplicação (ex: Tomcat).

### 3. Acesso

Após a implantação, a aplicação estará acessível em:

```
http://localhost:8080/CRUDMavenre-1.0-SNAPSHOT/
```
(O nome exato do contexto pode variar dependendo do seu servidor e do nome do arquivo `.war`).

O ponto de entrada inicial é o `index.html` ou o `CandidatoControle.java` (Servlet) que gerencia as requisições.

## 📂 Estrutura do Projeto

O projeto segue a estrutura padrão de um projeto Maven Web:

```
.
├── pom.xml               # Arquivo de configuração do Maven
└── src/
    ├── main/
    │   ├── java/         # Código-fonte Java
    │   │   └── com/da/crudmaven/
    │   │       ├── controller/  # Servlets (CandidatoControle.java)
    │   │       ├── dao/         # Data Access Objects (CandidatoDAO.java)
    │   │       ├── model/       # Entidades (Candidato.java)
    │   │       └── util/        # Utilitários (Conexao.java)
    │   └── webapp/       # Conteúdo Web (JSP, HTML, CSS, Imagens)
    │       ├── WEB-INF/
    │       ├── imagens/
    │       ├── index.html
    │       └── *.jsp           # Páginas JSP (formularios, resultados)
    └── test/
```
