
# Nullbank: Angular + SpringBoot CRUD de Clientes

Este projeto demonstra como construir uma aplicação web básica de CRUD (Create, Read, Update, Delete) utilizando Angular como framework de frontend e SpringBoot como framework de backend. A aplicação permite que usuários gerenciem dados de clientes realizando operações CRUD em um banco de dados.

## Começando

Para começar com este projeto, siga os seguintes passos:

1.  Clone o repositório em sua máquina local.
2.  Certifique-se de ter o seguinte software instalado em sua máquina:
    -   Java 11 ou superior
    -   Node.js e NPM
3.  Abra uma janela do terminal e navegue até o diretório raiz do projeto.
4.  Execute o seguinte comando para iniciar o backend do SpringBoot:
    
    
    `./mvnw spring-boot:run` 
    
5.  Abra outra janela do terminal e navegue até o diretório "frontend".
6.  Execute o seguinte comando para instalar as dependências necessárias para o frontend do Angular:
    
    Copy code
    
    `npm install` 
    
7.  Execute o seguinte comando para iniciar o frontend do Angular:
    
    Copy code
    
    `ng serve` 
    
8.  Abra um navegador da web e navegue até [http://localhost:4200](http://localhost:4200/) para visualizar a aplicação.

## Estrutura da aplicação

A aplicação é dividida em dois componentes principais: o frontend do Angular e o backend do SpringBoot.

### Frontend

O frontend é construído usando Angular, um framework popular para construir aplicações de página única. O código para o frontend está localizado no diretório "frontend". O frontend se comunica com o backend usando requisições HTTP.

O código do frontend está organizado nos seguintes componentes:

-   **CustomersService**: Este componente detém todas operações  http de crud de clientes e permite que a aplicação liste, crie, edite e exclua clientes.
-   **CustomerListComponent**: Este componente exibe os detalhes de um único cliente e permite que o usuário vá para edição ou exclua o cliente.
-   **CustomerCreateUpdateComponent**: Este componente exibe um formulário para criar ou editar um cliente.

### Backend

O backend é construído usando SpringBoot, um framework popular para construir aplicações web Java. O código para o backend está localizado no diretório "src". O backend fornece uma API RESTful para o frontend se comunicar.

O código do backend está organizado nos seguintes componentes:

-   **Customer**: Esta classe representa um cliente no banco de dados.
-   **CustomerRepository**: Esta interface define métodos para interagir com o banco de dados.
-   **CustomerController**: Esta classe fornece endpoints RESTful para operações CRUD em clientes.
- **CustomerController**: Esta classe fornece endpoints RESTful para operações CRUD em clientes.
-   **Loan**: Esta classe representa um empréstimo no banco de dados.
- **LoanRepository**: Esta interface define métodos para interagir com o banco de dados.
- **LoanController**: Esta classe fornece endpoints RESTful para operações CRUD em empréstimos.
-   **App**: Esta classe contém o método principal para iniciar a aplicação SpringBoot.

## Tecnologias usadas

As seguintes tecnologias foram usadas para construir esta aplicação:

-   Angular
-   SpringBoot
-  MapStruct
-   H2
-   Bootstrap
-  SweetAlert2

## Conclusão

Este projeto fornece um exemplo básico de aplicação web de CRUD usando Angular e SpringBoot. Ele pode ser usado como ponto de partida para construir aplicações mais complexas que exigem gerenciamento de usuários, autenticação e autorização.
