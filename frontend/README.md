# Frontend - Interface de Gerenciamento

Interface web desenvolvida em Vue 3 com Vite para gerenciar Produtos e Insumos via API REST.

## 📋 Descrição

Aplicação de gerenciamento de Produtos e Insumos com:
- Lista de produtos
- Lista de insumos
- Criar novos produtos
- Criar novos insumos
- Associar insumos a produtos
- Sugestões de produtos/insumos

## 🛠️ Tecnologias

- **Vue 3**: Framework JavaScript progressivo
- **Vite**: Build tool e dev server
- **Vue Router**: Roteamento
- **Node.js**: Runtime JavaScript
- **npm**: Gerenciador de pacotes

## ✅ Pré-requisitos

- Node.js 20.19.0+ ou 22.12.0+
  - Baixe de [nodejs.org](https://nodejs.org/)
  - Verifique: `node --version` e `npm --version`
- Backend rodando em `http://localhost:8080`

## 🚀 Instalação e Execução Rápida

### 1. Instalar Dependências

```bash
cd frontend

npm install
```

Isto baixará todas as dependências definidas em `package.json`

### 2. Executar em Modo Desenvolvimento

```bash
npm run dev
```

Você verá no terminal algo como:
```
VITE v7.3.1  ready in 234 ms

➜  Local:   http://localhost:5173/
➜  press h + enter to show help
```

Acesse **http://localhost:5173** no seu navegador

## 📁 Estrutura de Páginas

### Rotas Disponíveis

- `/` - Home (pode redirecionar para lista de produtos)
- `/products` - Lista de Produtos
- `/insumes` - Lista de Insumos
- `/new-product` - Criar Novo Produto
- `/new-insume` - Criar Novo Insumo
- `/suggestion` - Sugestões
- `/insume-manager` - Gerenciador de Insumos por Produto

## 📚 Componentes

### ListComponent.vue
Exibe listas de produtos ou insumos com opções de editar e deletar

### CreateComponent.vue
Componente genérico para criar novos itens

### NewProductComponent.vue
Formulário específico para criar novos produtos
- Campo: Nome
- Campo: Valor

### NewInsumeComponent.vue
Formulário específico para criar novos insumos
- Campo: Nome
- Campo: Quantidade

### SugestionComponent.vue
Exibe sugestões de produtos ou insumos

## 🧪 Testando a Aplicação

### Pré-requisito
Certifique-se de que o **backend está rodando** em `http://localhost:8080`

### Fluxo de Teste Completo

#### 1. Criar Insumos

1. No navegador, acesse **http://localhost:5173**
2. Clique em **"Novo Insumo"** (ou navegue para `/new-insume`)
3. Preencha os campos:
   - Nome: `Pão`
   - Quantidade: `100`
4. Clique em **"Salvar"**

5. Crie mais insumos:
   - Nome: `Queijo`, Quantidade: `50`
   - Nome: `Alface`, Quantidade: `200`
   - Nome: `Tomate`, Quantidade: `150`

#### 2. Visualizar Insumos

1. Clique em **"Insumos"** para ver a lista
2. Verifique se todos os insumos aparecem

#### 3. Criar Produtos

1. Clique em **"Novo Produto"** (ou navegue para `/new-product`)
2. Preencha os campos:
   - Nome: `Sanduíche`
   - Valor: `25.50`
3. Clique em **"Salvar"**

4. Crie mais produtos:
   - Nome: `Salada`, Valor: `18.90`
   - Nome: `Pizza`, Valor: `45.90`

#### 4. Visualizar Produtos

1. Clique em **"Produtos"** para ver a lista
2. Verifique se todos os produtos aparecem

#### 5. Associar Insumos a Produtos

1. Clique em **"Gerenciador de Insumos"** (ou navegue para `/insume-manager`)
2. Selecione um produto
3. Escolha os insumos que compõem o produto
4. Confirme a associação

#### 6. Editar Produtos/Insumos

1. Na lista de **Produtos** ou **Insumos**
2. Clique no botão **Editar** de um item
3. Modifique os dados
4. Clique em **Salvar**

#### 7. Deletar Produtos/Insumos

1. Na lista de **Produtos** ou **Insumos**
2. Clique no botão **Deletar** de um item
3. Confirme a exclusão
4. Verifique se o item foi removido da lista

## 🔧 Comandos npm

```bash
cd frontend

# Instalar dependências
npm install

# Executar em desenvolvimento (hot-reload)
npm run dev

# Build para produção
npm run build

# Visualizar build de produção localmente
npm run preview

# Executar linter
npm run lint

# Corrigir problemas de linter automaticamente
npm run lint:eslint -- --fix
```

## 🚀 Build para Produção

```bash
npm run build
```

Isto criará uma pasta `dist/` com os arquivos otimizados prontos para deploy.

Para testar localmente:
```bash
npm run preview
```

## 🛠️ IDE Recomendada

### VS Code + Extensões

1. Instale [VS Code](https://code.visualstudio.com/)

2. Extensões recomendadas:
   - **Vue (Official)** - Suporte completo para Vue 3
     - [https://marketplace.visualstudio.com/items?itemName=Vue.volar](https://marketplace.visualstudio.com/items?itemName=Vue.volar)
   - **Vite** - Suporte para Vite
   - **ESLint** - Linting JavaScript
   - **REST Client** - Testar API REST

3. No VS Code, desative a extensão **Vetur** se tiver instalada (conflita com Vue Official)

### Ferramentas Browser

#### Chrome/Edge/Brave
1. Instale **Vue DevTools**
   - [Chrome Web Store](https://chromewebstore.google.com/detail/vuejs-devtools/nhdogjmejiglipccpnnnanhbledajbpd)

2. Enable Custom Object Formatter:
   - DevTools → Settings → Custom formatters

#### Firefox
1. Instale **Vue DevTools**
   - [Mozilla Add-ons](https://addons.mozilla.org/en-US/firefox/addon/vue-js-devtools/)

2. Enable Custom Object Formatter:
   - DevTools → Settings → Custom object formatters

## 📁 Estrutura do Projeto

```
frontend/
├── src/
│   ├── App.vue                     # Componente raiz
│   ├── main.js                     # Ponto de entrada
│   ├── Components/
│   │   ├── ListComponent.vue       # Componente genérico de lista
│   │   ├── CreateComponent.vue     # Componente genérico de criação
│   │   ├── NewProductComponent.vue # Criar novo produto
│   │   ├── NewInsumeComponent.vue  # Criar novo insumo
│   │   └── SugestionComponent.vue  # Sugestões
│   ├── icons/                      # SVGs de ícones
│   └── router/
│       └── index.js                # Configuração de rotas
├── public/                         # Arquivos estáticos
├── package.json                    # Dependências npm
├── vite.config.js                  # Configuração Vite
├── eslint.config.js                # Configuração ESLint
├── jsconfig.json                   # Configuração JavaScript
├── index.html                      # HTML principal
└── README.md                       # Este arquivo
```

## 🔌 Consumindo a API

A aplicação faz requisições HTTP para o backend em `http://localhost:8080`

### Exemplos de Endpoints Consumidos

```javascript
// Listar Produtos
GET http://localhost:8080/api/products

// Criar Produto
POST http://localhost:8080/api/products
{
  "name": "Sanduíche",
  "value": 25.50
}

// Listar Insumos
GET http://localhost:8080/api/insumes

// Criar Insumo
POST http://localhost:8080/api/insumes
{
  "name": "Pão",
  "quantity": "100"
}
```

## ⚙️ Configuração

### Variáveis de Ambiente

Crie um arquivo `.env` na raiz do `frontend/`:

```env
VITE_API_BASE_URL=http://localhost:8080/api
```

Acesse em componentes Vue:
```javascript
const apiUrl = import.meta.env.VITE_API_BASE_URL;
```

### CORS

O backend deve estar configurado para aceitar requisições de `http://localhost:5173`

## 🐛 Solução de Problemas

### Erro: "Port 5173 already in use"
```
Solução 1: Mude a porta em vite.config.js
  export default {
    server: {
      port: 5174
    }
  }

Solução 2: Finalize o processo usando a porta
  Windows: netstat -ano | findstr :5173
  Linux/Mac: lsof -i :5173
```

### Erro: "Cannot connect to backend"
```
Verifique:
1. Backend está rodando em http://localhost:8080?
2. Há CORS configurado no backend?
3. Console do navegador tem erros CORS?

Solução: Adicione CORS ao backend em application.properties
```

### Erro: "Module not found"
```
Solução: Reinstale dependências
npm install
```

### Componentes não renderizam
```
Verifique:
1. Vue DevTools (Chrome/Firefox) para debug
2. Console do navegador para erros
3. Se todas as rotas estão configuradas em router/index.js
```

### Hot-reload não funcionando
```
Salve o arquivo novamente (Ctrl+S)
Se persistir, reinicie:
npm run dev
```

## 📚 Documentação

- [Vue 3 Official Docs](https://vuejs.org/)
- [Vite Official Docs](https://vite.dev/)
- [Vue Router Docs](https://router.vuejs.org/)
- [ESLint Docs](https://eslint.org/)

## 🧪 Fluxo de Teste Recomendado

1. **Inicializar ambas as aplicações**
   - Terminal 1: Backend (`mvn spring-boot:run`)
   - Terminal 2: Frontend (`npm run dev`)

2. **Testar criação de insumos**
   - Acesse `/new-insume`
   - Crie 5 insumos diferentes

3. **Testar criação de produtos**
   - Acesse `/new-product`
   - Crie 3 produtos diferentes

4. **Testar listagem**
   - Verifique `/insumes`
   - Verifique `/products`

5. **Testar edição**
   - Edite um insumo
   - Edite um produto
   - Verifique se as alterações aparecem na lista

6. **Testar deleção**
   - Delete um insumo
   - Delete um produto
   - Verifique se foram removidos da lista

7. **Testar associação**
   - Acesse `/insume-manager`
   - Associe insumos a produtos

## ✨ Melhorias Futuras

- Adicionar validação de formulário
- Adicionar paginação nas listas
- Adicionar busca/filtro
- Adicionar notificações (toast)
- Adicionar loading indicators
- Adicionar confirmação de deleção
- Adicionar autenticação
- Adicionar modo escuro

## 👨‍💻 Suporte

Para dúvidas ou problemas:
1. Verifique se Node.js está instalado: `node --version`
2. Verifique se npm está instalado: `npm --version`
3. Verifique se backend está rodando: `http://localhost:8080/api/products`
4. Verifique console do navegador (F12) para erros
5. Verifique console do terminal para logs

