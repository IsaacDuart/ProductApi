# Product API

A **Product API** é uma aplicação desenvolvida em **Spring Boot** que permite realizar operações CRUD (Create, Read, Update, Delete) em produtos. Esta API fornece endpoints para criar, atualizar, excluir, buscar um único produto e listar todos os produtos.

## Endpoints

### 1. **Criar Produto**
**Método**: `POST`  
**URL**: `/products`  
**Descrição**: Cria um novo produto no sistema.  
**Request Body**:
```json
{
  "name": "Product Name",
  "description": "Product Description",
  "price": 10.99
}
```

**Resposta** (status 200):
```json
{
  "id": 1,
  "name": "Product Name",
  "description": "Product Description",
  "price": 10.99
}
```

### 2. **Atualizar Produto**
**Método**: `PUT`  
**URL**: `/products`  
**Descrição**: Atualiza as informações de um produto existente.  
**Request Body**:
```json
{
  "id": 1,
  "name": "Updated Product Name",
  "description": "Updated Product Description",
  "price": 12.99
}
```

**Resposta** (status 200):
```json
{
  "id": 1,
  "name": "Updated Product Name",
  "description": "Updated Product Description",
  "price": 12.99
}
```

**Resposta** (status 404 - caso o produto não seja encontrado):
```json
{
  "message": "Product not found"
}
```

### 3. **Excluir Produto**
**Método**: `DELETE`  
**URL**: `/products/{id}`  
**Descrição**: Exclui um produto do sistema.  
**Parâmetro**: `id` (ID do produto a ser excluído).

**Resposta** (status 200):  
Sem corpo de resposta.

**Resposta** (status 404 - caso o produto não seja encontrado):
```json
{
  "message": "Product not found"
}
```

### 4. **Buscar Produto por ID**
**Método**: `GET`  
**URL**: `/products/{id}`  
**Descrição**: Retorna os detalhes de um produto com base no seu ID.  
**Parâmetro**: `id` (ID do produto).

**Resposta** (status 200):
```json
{
  "id": 1,
  "name": "Product Name",
  "description": "Product Description",
  "price": 10.99
}
```

**Resposta** (status 404 - caso o produto não seja encontrado):
```json
{
  "message": "Product not found"
}
```

### 5. **Listar Todos os Produtos**
**Método**: `GET`  
**URL**: `/products`  
**Descrição**: Retorna uma lista de todos os produtos disponíveis no sistema.

**Resposta** (status 200):
```json
[
  {
    "id": 1,
    "name": "Product Name",
    "description": "Product Description",
    "price": 10.99
  },
  {
    "id": 2,
    "name": "Another Product",
    "description": "Another Description",
    "price": 15.99
  }
]
```

## Tecnologias Utilizadas

- **Spring Boot**: Framework para construção de aplicações Java baseadas em microserviços.
- **Spring Web**: Para criação de RESTful APIs.
- **Spring Data JPA**: Para persistência dos dados no banco de dados.
- **Hibernate**: ORM utilizado para mapeamento entre objetos Java e banco de dados.
- **Validation API (javax.validation)**: Para validação de entradas de dados.

## Como Rodar a Aplicação

1. Clone o repositório para sua máquina local:
   ```bash
   git clone https://github.com/usuario/product-api.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd product-api
   ```

3. Compile e rode o projeto com o Maven ou Gradle:
   - Usando Maven:
     ```bash
     ./mvnw spring-boot:run
     ```
   - Usando Gradle:
     ```bash
     ./gradlew bootRun
     ```

4. A API estará disponível em: [http://localhost:8080](http://localhost:8080)

