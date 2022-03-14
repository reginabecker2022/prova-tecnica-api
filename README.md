## Prova técnica API

Este é o projeto da API "Restricoes" e "Simulacoes" automatizado.

##  Requisitos
 * Java 8+ JDK deve estar instalado
 * Maven deve estar instalado e configurado no path da aplicação
 
 
## Como executar a API automatizada 

a) Executar a Suíte de Testes Acceptance:
1) Na estrutura do projeto, abra a Classe: 📜Acceptance.java
```
📦restassured-api-testing
 ┣ 📂src
 ┃ ┣ 📂test
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┣ 📂br												
 ┃ ┃ ┃ ┃	┣ 📂com							 					
 ┃ ┃ ┃ ┃	┃  ┣ 📂restassuredapitesting							
 ┃ ┃ ┃ ┃	┃  ┃ ┣📂runners										
 ┃ ┃ ┃ ┃	┃  ┃ ┣ 📜Acceptance.java
```
2) Localize a class Acceptance
3) Acione Run Acceptance
4) Deverá executar toda a Suíte Acceptance

b) Executar a Suíte de Testes Contract:
1) Na estrutura do projeto, abra a Classe: 📜Contract.java
```
📦restassured-api-testing
 ┣ 📂src
 ┃ ┣ 📂test
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┣ 📂br												
 ┃ ┃ ┃ ┃	┣ 📂com							 					
 ┃ ┃ ┃ ┃	┃  ┣ 📂restassuredapitesting							
 ┃ ┃ ┃ ┃	┃  ┃ ┣📂runners										
 ┃ ┃ ┃ ┃	┃  ┃ ┣ 📜Contract.java
```
2) Localize a class Contract
3) Acione Run Contract
4) Deverá executar toda a Suíte Contract							

## Documentacão técnica da aplicação

A documentação técnica da API está disponível através do OpenAPI/Swagger em [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## Regras

### Restrições

`GET <host>/api/v1/restricoes/{cpf}`

O endpoint de Restrições tem a finalidade de consultar o CPF informando, retornando se ele possui ou não uma restrição. 

* Se não possui restrição do HTTP Status 204 é retornado
* Se possui restrição o HTTP Status 200 é retornado com a mensagem "O CPF 99999999999 possui restrição"

#### CPFs com restrição

| CPF |
| ----|
| 97093236014 |
| 60094146012 |
| 84809766080 |
| 62648716050 |
| 26276298085 |
| 01317496094 |
| 55856777050 |
| 19626829001 |
| 24094592008 |
| 58063164083 |

### Simulações

A simulação é um cadastro que ficará registrado informações importantes sobre o crédito como valor, parcelas, 
dados de contato, etc...

### Criar uma simulação

`POST <host>/api/v1/simulacoes`

Este endpoint é responsável por inserir uma nova simulação.

Existem os seguintes atributos a serem informados, com suas respectivas regras:

| Atributo | Obrigatório? | Regra |
|----------|--------------|-------|
| cpf | sim | texto informando o CPF não no formato 999.999.999-99 |
| nome | sim | texto informando o nome da pessoa |
| email | sim | texto informado um e-mail válido |
| valor | sim | valor da simulação que deve ser igual ou maior que R$ 1.000 e menor ou igual que R$ 40.000 |
| parcela | sim | número de parcelas para pagamento que deve ser igual ou maior que 2 e menor ou igual a 48 |
| seguro | sim | booleano `true` se com seguro e  `false` se sem seguro |

* Uma simulação cadastrada com sucesso retorna o HTTP Status 201 e os dados inseridos como retorno
* Uma simulação com problema em alguma regra retorna o HTTP Status 400 com a lista de erros
* Uma simulação para um mesmo CPF retorna um HTTP Status 409 com a mensagem "CPF já existente"

### Alterar uma simulação

`PUT <host>/api/v1/simulacoes/{cpf}`

Altera uma simulação já existente, onde o CPF deve ser informado para que a alteração possa ser efetuada.

* A alteração pode ser feita em qualquer atributo da simulação
* As mesmas regras se mantém
* Se o CPF não possuir uma simulação o HTTP Status 404 é retornado com a mensagem "CPF não encontrado"

### Consultar todas a simulações cadastradas

`GET <host>/api/v1/simulacoes`

Lista as simulações cadastradas.

* Retorna a lista de simulações cadastradas e existir uma ou mais
* Retorna HTTP Status 204 se não existir simulações cadastradas


### Consultar uma simulação pelo CPF

`GET <host>/api/v1/simulacoes/{cpf}`

Retorna a simulação previamente cadastrada pelo CPF.

* Retorna a simulação cadastrada
* Se o CPF não possuir uma simulação o HTTP Status 404 é retornado

### Remover uma simulação

`DELETE <host>/api/v1/simulacoes/{id}`

Remove uma simulação previamente cadastrada pelo seu ID.

* Retorna o HTTP Status 204 se simulação for removida com sucesso
* Retorna o HTTP Status 404 com a mensagem "Simulação não encontrada" se não existir a simulação pelo ID informado


## Arquitetura da API automatizada
```
📦restassured-api-testing
 ┣ 📂src
 ┃ ┣ 📂test
 ┃ ┃ ┣ 📂java
 ┃ ┃ ┃ ┣ 📂br												
 ┃ ┃ ┃ ┃	┣ 📂com							 					
 ┃ ┃ ┃ ┃	┃  ┣ 📂restassuredapitesting							
 ┃ ┃ ┃ ┃	┃  ┃ ┣📂runners										
 ┃ ┃ ┃ ┃	┃  ┃ ┣ 📜Acceptance.java								
 ┃ ┃ ┃ ┃	┃  ┃ ┣ 📜AllTests.java								
 ┃ ┃ ┃ ┃	┃  ┃ ┣ 📜Contract.java								
 ┃ ┃ ┃ ┃	┃  ┃ ┣📂suites										
 ┃ ┃ ┃ ┃	┃  ┃ ┣ 📜Acceptance.ja								
 ┃ ┃ ┃ ┃	┃  ┃ ┣ 📜AllTests.java								
 ┃ ┃ ┃ ┃	┃  ┃ ┣ 📜Contract.java								
 ┃ ┃ ┃ ┃	┃  ┃ ┣📂tests																
 ┃ ┃ ┃ ┃	┃  ┣ ┃ 📂base										
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📂requests					
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜BaseRequest.java		
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📂tests						
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜BaseTest.java
 ┃ ┃ ┃ ┃    ┃  ┣ ┃📂healthcheck
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📂requests			
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜GetHealthCheckRequest.java
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📂tests			
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜GetHealthCheckTest.java
 ┃ ┃ ┃ ┃	┃  ┣ ┃ 📂restricoes				
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📂contracts			
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜restricoes.json	
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📂requests			
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜GetRestricoesRequest.java
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📂tests			
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜GetRestricoesTest.java
 ┃ ┃ ┃ ┃	┃  ┣ ┃ 📂simulacoes				
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📂contracts			
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜simulacoes.json	
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📂requests			
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜DeleteSimulacoesRequest.java
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜GetSimulacoesRequest.java
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜PostSimulacoesRequest.java
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜PutSimulacoesRequest.java
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📂tests			
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜DeleteSimulacoesTest.java
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜GetSimulacoesTest.java
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜PostSimulacoesTest.java
 ┃ ┃ ┃ ┃	┃  ┣ ┃ ┣ 📜PutSimulacoesTest.java
 ┃ ┃ ┃ ┃	┃  ┃ ┣📂utils
 ┃ ┃ ┃ ┃	┃  ┃ ┣📜Utils.java
┣ 📜.gitignore 
┣ 📜pom.xml 
┣ 📜README.md 
```

## Wiki

Visite a Wiki para navegar no projeto da API "Restricoes" e "Simulacoes"
