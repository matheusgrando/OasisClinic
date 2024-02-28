# OasisClinic
API Rest do projeto Oasis  


## Requisitos

- [ ] CRUD de Agendamentos 
- [ ] CRUD de Movimentações
- [ ] CRUD de Usuarios
- [ ] Autenticação
- [ ] Dashboard

## Documentação do API

### Endpoints

- [Listar Agendamentos](#listar-agendamentos)
- [Cadastrar Agendamentos](#cadastrar-agendamentos)
- [Apagar Agendamentos](#apagar-agendamentos)
- [Detalhar Agendamentos](#detalhar-agendamentos)
- [Atualizar Agendamentos](#atualizar-agendamentos)

### Listar Categorias

`GET` /agendamentos

Retorna um array com todos as agendamentos cadastradas pelo usuario atual.

##### Exemplo de Respostas

```js
[
    {
        "id": 1,
        "nome":"Serviço",
        "icone":"book"
    }
]
```

#### Códigos de Resposta

| código | descrição |
|--------|-----------|
|200| Agendamento retornado com sucesso
|401| Não autorizado. Realize a autenticação em /login

---

### Cadastrar Categoria

`POST` /agendamentos

Cadastra um agendamento com os dados enviados no corpo da requisição.

#### Corpo de Requisição

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
| nome  | string| ✅ | Um nome curto para identificar o agendamentos
| icone | string| ❌ | O nome do ícone conforme bibilioteca Material Icons 

```js
{
    "nome": "Serviços",
    "icone: "book"
}
```

##### Exemplo de Respostas

```js
[
    {
        "id": 1,
        "nome":"Serviços",
        "icone":"book"
    }
]
```

#### Código de Resposta

| código | descrição |
|--------|-----------|
|201| Agendamento cadastrado com sucesso
|400| Validação falhou. Verifique os dados enviados no corpo da aquisição
|401| Não autorizado. Realize a autenticação em /login

---

### Apagar categoria

`DELETE` /agendamento/`{id}`

Apaga o agendamento com o `id` informado no parâmetro de path.

#### Código de Resposta

| código | descrição |
|--------|-----------|
|204| Agendamento apagado com sucesso
|401| Não autorizado. Realize a autenticação em /login

---
### Detalhar Categoria

`GET` /AGENDAMENTO/`{id}`

Retorna os dados do agendamento com o `id` informado no parâmetro de path.

##### Exemplo de Respostas

```js
// requisição / agendamento /1
[
    {
        "id": 1,
        "nome":"Serviço",
        "icone":"book"
    }
]
```

#### Código de Resposta

| código | descrição |
|--------|-----------|
|200| Agendamento retornado com sucesso
|401| Não autorizado. Realize a autenticação em /login
|404| Não existe agendamento com o `id` informado

---

### Atualizar Categoria

`PUT` /agendamento/`{id}`

Atualiza os dados o agendamento com o `id` informado no path

#### Corpo de Requisição

| campo | tipo | obrigatório | descrição
|-------|------|:-------------:|----------
| nome  | string| ✅ | Um nome curto para identificar o agendamento
| icone | string| ✅ | O nome do ícone conforme bibilioteca Material Icons 

```js
{
    "nome": "Serviço",
    "icone: "book"
}
```

##### Exemplo de Respostas

```js
[
    {
        "id": 1,
        "nome":"Serviços",
        "icone":"book"
    }
]
```

#### Código de Resposta

| código | descrição |
|--------|-----------|
|200| Sgendamento cadastrada com sucesso
|400| Validação falhou. Verifique os dados enviados no corpo da requisição
|401| Não autorizado. Realize a autenticação em /login
|404| Não existe agendamento com o `id` informado

---
