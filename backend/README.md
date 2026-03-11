# Backend - API REST de Gerenciamento

API REST desenvolvida em Spring Boot 4.0.3 com Java 21 para gerenciar Produtos e Insumos.

## 📋 Descrição

Esta aplicação fornece endpoints REST para:
- Gerenciar **Produtos** (criar, ler, atualizar, deletar)
- Gerenciar **Insumos** (criar, ler, atualizar, deletar)
- Associar insumos a produtos

## 🛠️ Tecnologias

- **Spring Boot**: 4.0.3
- **Java**: 21
- **Banco de Dados**: H2 (padrão) - Configurable para PostgreSQL, MySQL, etc.
- **Build Tool**: Maven 3.6+
- **ORM**: Jakarta Persistence (JPA/Hibernate)

## ✅ Pré-requisitos

- Java 21 JDK instalado
  - Windows: Baixe de [oracle.com](https://www.oracle.com/java/technologies/downloads/)
  - Verifique: `java -version`
- Maven 3.6+ instalado
  - Verifique: `mvn -version`
  - Ou use o Maven Wrapper incluído (`mvnw.cmd` no Windows)

## 🚀 Instalação e Execução Rápida

### 1. Compilar a Aplicação

```bash
cd backend

# Windows
mvnw.cmd clean install

# Linux/Mac
./mvnw clean install

# Ou com Maven instalado (todos os SOs)
mvn clean install
```

### 2. Executar a Aplicação

```bash
# Windows
mvnw.cmd spring-boot:run

# Linux/Mac
./mvnw spring-boot:run

# Ou com Maven instalado
mvn spring-boot:run
```

A aplicação estará disponível em: **http://localhost:8080**

No console você verá algo como:
```
2025-03-11 10:30:45.123  INFO: Tomcat started on port(s): 8080 (http)
```

## 📚 Entidades

### Produto (Product)
```json
{
  "id": 1,
  "name": "Hambúrguer",
  "value": 25.50,
  "insumes": [...]
}
```

**Campos:**
- `id` (Long) - Identificador único, gerado automaticamente
- `name` (String) - Nome do produto
- `value` (Double) - Preço do produto
- `insumes` (List<Insume>) - Lista de insumos utilizados

### Insumo (Insume)
```json
{
  "id": 1,
  "name": "Pão",
  "quantity": "100"
}
```

**Campos:**
- `id` (Long) - Identificador único, gerado automaticamente
- `name` (String) - Nome do insumo
- `quantity` (String) - Quantidade do insumo

## 🔌 Endpoints da API

### Produtos

#### Listar todos os produtos
```bash
GET /api/products

# cURL
curl http://localhost:8080/api/products

# Resposta (200 OK)
[
  {
    "id": 1,
    "name": "Hambúrguer",
    "value": 25.50,
    "insumes": []
  }
]
```

#### Obter produto por ID
```bash
GET /api/products/{id}

# Exemplo
curl http://localhost:8080/api/products/1
```

#### Criar novo produto
```bash
POST /api/products
Content-Type: application/json

{
  "name": "Hambúrguer",
  "value": 25.50
}

# cURL
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Hambúrguer","value":25.50}'

# Resposta (201 Created)
{
  "id": 1,
  "name": "Hambúrguer",
  "value": 25.50,
  "insumes": []
}
```

#### Atualizar produto
```bash
PUT /api/products/{id}
Content-Type: application/json

{
  "name": "Hambúrguer Premium",
  "value": 35.00
}

# cURL
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Hambúrguer Premium","value":35.00}'

# Resposta (200 OK)
{
  "id": 1,
  "name": "Hambúrguer Premium",
  "value": 35.00,
  "insumes": []
}
```

#### Deletar produto
```bash
DELETE /api/products/{id}

# cURL
curl -X DELETE http://localhost:8080/api/products/1

# Resposta (204 No Content)
```

### Insumos

#### Listar todos os insumos
```bash
GET /api/insumes

# cURL
curl http://localhost:8080/api/insumes

# Resposta (200 OK)
[
  {
    "id": 1,
    "name": "Pão",
    "quantity": "100"
  }
]
```

#### Obter insumo por ID
```bash
GET /api/insumes/{id}

# Exemplo
curl http://localhost:8080/api/insumes/1
```

#### Criar novo insumo
```bash
POST /api/insumes
Content-Type: application/json

{
  "name": "Pão",
  "quantity": "100"
}

# cURL
curl -X POST http://localhost:8080/api/insumes \
  -H "Content-Type: application/json" \
  -d '{"name":"Pão","quantity":"100"}'

# Resposta (201 Created)
{
  "id": 1,
  "name": "Pão",
  "quantity": "100"
}
```

#### Atualizar insumo
```bash
PUT /api/insumes/{id}
Content-Type: application/json

{
  "name": "Pão integral",
  "quantity": "150"
}

# cURL
curl -X PUT http://localhost:8080/api/insumes/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Pão integral","quantity":"150"}'

# Resposta (200 OK)
{
  "id": 1,
  "name": "Pão integral",
  "quantity": "150"
}
```

#### Deletar insumo
```bash
DELETE /api/insumes/{id}

# cURL
curl -X DELETE http://localhost:8080/api/insumes/1

# Resposta (204 No Content)
```

## 🧪 Testando a API

### Opção 1: cURL (Terminal/PowerShell)

Exemplos com PowerShell no Windows:

```powershell
# Criar um insumo
Invoke-WebRequest -Uri "http://localhost:8080/api/insumes" `
  -Method POST `
  -Headers @{"Content-Type"="application/json"} `
  -Body '{"name":"Queijo","quantity":"50"}'

# Listar insumos
Invoke-WebRequest -Uri "http://localhost:8080/api/insumes" -Method GET

# Criar um produto
Invoke-WebRequest -Uri "http://localhost:8080/api/products" `
  -Method POST `
  -Headers @{"Content-Type"="application/json"} `
  -Body '{"name":"Sanduíche","value":15.50}'

# Listar produtos
Invoke-WebRequest -Uri "http://localhost:8080/api/products" -Method GET
```

### Opção 2: Postman/Insomnia

1. Baixe [Postman](https://www.postman.com/downloads/) ou [Insomnia](https://insomnia.rest/download)
2. Crie as requisições (exemplos nos endpoints acima)
3. Teste cada endpoint

### Opção 3: VS Code Extension - REST Client

1. Instale a extensão "REST Client" no VS Code
2. Crie um arquivo `test.http`:

```http
### Listar Insumos
GET http://localhost:8080/api/insumes

###
### Criar Insumo
POST http://localhost:8080/api/insumes
Content-Type: application/json

{
  "name": "Alface",
  "quantity": "200"
}

###
### Listar Produtos
GET http://localhost:8080/api/products

###
### Criar Produto
POST http://localhost:8080/api/products
Content-Type: application/json

{
  "name": "Salada",
  "value": 18.90
}
```

3. Clique em "Send Request" em cada requisição

## 🔧 Comandos Maven Úteis

```bash
cd backend

# Compilar
mvn clean compile

# Executar testes
mvn test

# Compilar e empacotar JAR
mvn clean package

# Executar aplicação
mvn spring-boot:run

# Ver estrutura de dependências
mvn dependency:tree

# Limpar cache
mvn clean

# Atualizar dependências
mvn versions:update-properties
```

## ⚙️ Configuração

### application.properties

Localizado em `backend/src/main/resources/application.properties`

**Configuração padrão (H2 em memória):**
```properties
server.port=8080
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
```

**Para usar PostgreSQL:**
```properties
server.port=8080
spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
spring.datasource.username=postgres
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

**Para usar MySQL:**
```properties
server.port=8080
spring.datasource.url=jdbc:mysql://localhost:3306/testdb
spring.datasource.username=root
spring.datasource.password=password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

## 📁 Estrutura do Projeto

```
backend/
├── src/
│   ├── main/
│   │   ├── java/com/example/
│   │   │   ├── backend/
│   │   │   │   ├── BackendApplication.java    # Classe Principal
│   │   │   │   ├── Product.java               # Entidade Produto
│   │   │   │   └── Insume.java                # Entidade Insumo
│   │   │   ├── controller/
│   │   │   │   ├── ProductController.java     # Controlador para Produtos
│   │   │   │   └── InsumeController.java      # Controlador para Insumos
│   │   │   └── repository/
│   │   │       ├── ProductRepository.java     # Repositório de Produtos
│   │   │       └── InsumeRepository.java      # Repositório de Insumos
│   │   └── resources/
│   │       └── application.properties         # Configurações
│   └── test/
│       └── java/com/example/backend/
│           └── BackendApplicationTests.java   # Testes
├── pom.xml                   # Configuração Maven
├── mvnw                      # Maven Wrapper (Unix/Mac)
├── mvnw.cmd                  # Maven Wrapper (Windows)
├── HELP.md                   # Help Maven
└── README.md                 # Este arquivo
```

## 🐛 Solução de Problemas

### Erro: "Java not found"
```
Solução: Instale Java 21 JDK e adicione ao PATH
Verifique: java -version
```

### Erro: "Maven not found"
```
Solução 1: Use mvnw.cmd (Windows) ou ./mvnw (Linux/Mac)
Solução 2: Instale Maven e adicione ao PATH
Verifique: mvn -version
```

### Erro: "Port 8080 already in use"
```
Solução 1: Mude a porta em application.properties
  server.port=8081

Solução 2: Encontre o processo e finalize
  Windows (PowerShell): Get-Process | Where-Object Port -eq 8080
  Linux/Mac: lsof -i :8080 | grep LISTEN
```

### Erro: "Connection refused"
```
Solução: Certifique-se de que a aplicação está rodando
  npm run dev (para o backend)
```

### Banco de Dados vazio ao reiniciar
```
Motivo: H2 está em memória por padrão (dados perdidos ao reiniciar)
Solução: Configure um banco de dados persistente:
  - PostgreSQL
  - MySQL
  - ou use arquivo H2:
    spring.datasource.url=jdbc:h2:file:./data/testdb
```

## 📚 Documentação

- [Spring Boot Official Docs](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Java 21 Docs](https://docs.oracle.com/en/java/javase/21/)
- [Maven Guide](https://maven.apache.org/guides/index.html)

## 📝 Exemplos de Teste Completo

### Fluxo 1: Criar e Listar
```bash
# 1. Criar um insumo
curl -X POST http://localhost:8080/api/insumes \
  -H "Content-Type: application/json" \
  -d '{"name":"Tomate","quantity":"10"}'

# 2. Listar insumos
curl http://localhost:8080/api/insumes

# 3. Criar um produto
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Pizza","value":45.90}'

# 4. Listar produtos
curl http://localhost:8080/api/products
```

### Fluxo 2: Atualizar e Deletar
```bash
# 1. Atualizar um produto
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Pizza Grande","value":65.90}'

# 2. Verificar atualização
curl http://localhost:8080/api/products/1

# 3. Deletar um produto
curl -X DELETE http://localhost:8080/api/products/1

# 4. Verificar deleção (deve retornar 404 ou lista vazia)
curl http://localhost:8080/api/products/1
```

## ✨ Próximos Passos

- Conectar o Frontend (Vue 3) para consumir esta API
- Adicionar autenticação (JWT/OAuth2)
- Implementar validação mais robusta
- Adicionar paginação aos endpoints
- Criar documentação Swagger/OpenAPI
- Adicionar logging detalhado
- Implementar tratamento de erros global

## 👨‍💻 Suporte

Para dúvidas ou problemas, verifique:
1. Se Java 21 está instalado
2. Se Maven está funcionando
3. Se a porta 8080 está disponível
4. Os logs da aplicação no console
