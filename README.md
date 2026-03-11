# Teste_projedata

Sistema de gerenciamento de Produtos e Insumos desenvolvido com Spring Boot e Vue 3.

## 📋 Descrição do Projeto

Esta aplicação permite gerenciar:
- **Produtos**: Cadastro e consulta de produtos com seus valores
- **Insumos**: Cadastro e consulta de insumos/ingredientes utilizados nos produtos
- **Relacionamento**: Associação entre produtos e insumos (um produto pode ter múltiplos insumos)

## 🏗️ Arquitetura

### Backend
- **Framework**: Spring Boot 4.0.3
- **Java**: Versão 21
- **Banco de Dados**: H2 (em memória, configurável)
- **Build Tool**: Maven

### Frontend
- **Framework**: Vue 3
- **Build Tool**: Vite
- **Router**: Vue Router 5.0.3
- **Node**: ^20.19.0 || >=22.12.0

## 🚀 Início Rápido

### Pré-requisitos

#### Backend
- Java 21 JDK instalado
- Maven 3.6+ instalado

#### Frontend
- Node.js 20.19.0+ ou 22.12.0+

### Instalação e Execução

#### Backend

```bash
cd backend

# Compilar e executar (Windows)
mvnw.cmd clean install

# Ou com Maven já instalado
mvn clean install

# Executar a aplicação
mvnw.cmd spring-boot:run
# ou
mvn spring-boot:run
```

A aplicação backend estará disponível em: **http://localhost:8080**

#### Frontend

```bash
cd frontend

# Instalar dependências
npm install

# Executar em modo desenvolvimento
npm run dev
```

A aplicação frontend estará disponível em: **http://localhost:5173** (ou a porta indicada no terminal)

## 🧪 Testando a Aplicação

### 1. Backend - API REST

#### Cria um Produto
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Hambúrguer","value":25.50}'
```

#### Lista todos os Produtos
```bash
curl http://localhost:8080/api/products
```

#### Cria um Insumo
```bash
curl -X POST http://localhost:8080/api/insumes \
  -H "Content-Type: application/json" \
  -d '{"name":"Pão","quantity":"100"}'
```

#### Lista todos os Insumos
```bash
curl http://localhost:8080/api/insumes
```

#### Obtém um Produto por ID
```bash
curl http://localhost:8080/api/products/1
```

#### Obtém um Insumo por ID
```bash
curl http://localhost:8080/api/insumes/1
```

#### Atualiza um Produto
```bash
curl -X PUT http://localhost:8080/api/products/1 \
  -H "Content-Type: application/json" \
  -d '{"name":"Hambúrguer Premium","value":35.00}'
```

#### Deleta um Produto
```bash
curl -X DELETE http://localhost:8080/api/products/1
```

### 2. Frontend - Interface Web

1. Acesse **http://localhost:5173**
2. Você verá as seguintes páginas:
   - **Produtos**: Criar, listar e gerenciar produtos
   - **Insumos**: Criar, listar e gerenciar insumos
   - **Gerenciador de Insumos por Produto**: Associar insumos aos produtos

#### Fluxo de Teste Completo

1. **Criar Insumos**
   - Clique em "Novo Insumo"
   - Preencha: Nome (ex: "Pão") e Quantidade (ex: "100")
   - Clique em "Salvar"

2. **Criar Produtos**
   - Clique em "Novo Produto"
   - Preencha: Nome (ex: "Hambúrguer") e Valor (ex: "25.50")
   - Clique em "Salvar"

3. **Associar Insumos a Produtos**
   - Vá para "Gerenciador de Insumos"
   - Selecione um produto
   - Adicione os insumos desejados
   - Confirme

4. **Visualizar Dados**
   - Consulte as listas de Produtos e Insumos
   - Verifique os relacionamentos

## 📁 Estrutura do Projeto

```
Teste_projedata/
├── backend/
│   ├── src/main/java/com/example/backend/
│   │   ├── BackendApplication.java     # Classe principal
│   │   ├── Product.java                # Entidade Produto
│   │   ├── Insume.java                 # Entidade Insumo
│   │   ├── controller/                 # Controladores REST
│   │   └── repository/                 # Interfaces de Repositório
│   ├── pom.xml                         # Configuração Maven
│   └── mvnw                            # Maven Wrapper (Unix)
│
├── frontend/
│   ├── src/
│   │   ├── App.vue                     # Componente raiz
│   │   ├── main.js                     # Ponto de entrada
│   │   ├── Components/
│   │   │   ├── ListComponent.vue       # Lista de itens
│   │   │   ├── CreateComponent.vue     # Criar novo item
│   │   │   ├── NewProductComponent.vue # Novo produto
│   │   │   ├── NewInsumeComponent.vue  # Novo insumo
│   │   │   └── SugestionComponent.vue  # Sugestões
│   │   └── router/
│   │       └── index.js                # Configuração de rotas
│   ├── package.json                    # Dependências npm
│   └── vite.config.js                  # Configuração Vite
│
└── README.md                           # Este arquivo
```

## 📝 Endpoints da API

### Produtos
- `GET /api/products` - Listar todos os produtos
- `GET /api/products/{id}` - Obter produto por ID
- `POST /api/products` - Criar novo produto
- `PUT /api/products/{id}` - Atualizar produto
- `DELETE /api/products/{id}` - Deletar produto

### Insumos
- `GET /api/insumes` - Listar todos os insumos
- `GET /api/insumes/{id}` - Obter insumo por ID
- `POST /api/insumes` - Criar novo insumo
- `PUT /api/insumes/{id}` - Atualizar insumo
- `DELETE /api/insumes/{id}` - Deletar insumo

## 🛠️ Desenvolvimento

### Backend - Comandos Maven Úteis

```bash
cd backend

# Compilar sem executar testes
mvn clean compile

# Executar testes
mvn test

# Empacotar JAR
mvn clean package

# Executar aplicação
mvn spring-boot:run

# Ver dependências
mvn dependency:tree
```

### Frontend - Comandos npm Úteis

```bash
cd frontend

# Instalar dependências
npm install

# Executar em desenvolvimento
npm run dev

# Build para produção
npm run build

# Preview da build de produção
npm run preview

# Executar linter
npm run lint
```

## 🔧 Configuração

### Backend - application.properties

O arquivo `backend/src/main/resources/application.properties` pode ser configurado com:

```properties
# Porta da aplicação
server.port=8080

# Banco de dados H2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.h2.console.enabled=true

# JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
```

### Frontend - CORS

Certifique-se de que o backend está configurado para aceitar requisições do frontend em `localhost:5173`.

## 🐛 Solução de Problemas

### Backend não inicia
- Verifique se a porta 8080 está disponível
- Verifique se Java 21 está instalado: `java -version`
- Limpe e reconstrua: `mvn clean install`

### Frontend não conecta ao backend
- Certifique-se de que o backend está rodando em `http://localhost:8080`
- Verifique o console do navegador para erros CORS
- Reinicie o servidor Vite

### Banco de dados vazio
- O banco H2 está em memória por padrão
- Os dados são perdidos ao reiniciar a aplicação
- Para persistência, configure um banco PostgreSQL ou MySQL

## 📚 Recursos Adicionais

- [Documentação Spring Boot](https://spring.io/projects/spring-boot)
- [Documentação Vue 3](https://vuejs.org/)
- [Documentação Vite](https://vite.dev/)
- [Documentação Maven](https://maven.apache.org/)

## 👨‍💻 Autor

Projeto desenvolvido para fins de testes e demonstração.

## 📄 Licença

Este projeto é de código aberto e está disponível para uso e modificação.