# SUSE 
## Sistema de supervisão de semáforos com JSF.

### Criação do banco de dados:
Neste trabalho, foi-se utilizado o banco de dados PostgreSQL na sua versão 10.0. Para criar o banco utilizado no projeto, use o seguinte comando no bash do postgres:
`CREATE DATABASE tjw WITH TABLESPACE = pg_default TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'pt_BR.UTF-8' LC_CTYPE = 'pt_BR.UTF-8' CONNECTION LIMIT = -1;`

### Rodando a aplicação:
Durante o desenvolvimento, foi-se utilizado o servidor de aplicação Wildfly na versão 19.1.0. Baixe o mesmo no endereço: https://www.wildfly.org/downloads/ para fazer o deploy da aplicação.
