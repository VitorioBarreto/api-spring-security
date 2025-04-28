# Spring Security Example Project

Este projeto é uma API Web criada com **Spring Boot** e **Spring Security**, usando autenticação **HTTP Basic** e **H2 Database** para armazenamento de usuários.

---

## 📁 Tecnologias utilizadas

- Java 17+
- Spring Boot 3+
- Spring Security
- H2 Database (banco em memória)
- Maven

---

## 🔧 Como rodar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/spring-security-example.git
```

2. Acesse a pasta do projeto:

```bash
cd spring-security-example
```

3. Rode o projeto (via IDE ou linha de comando):

```bash
./mvnw spring-boot:run
```

O servidor iniciará em:

```
http://localhost:8080
```

---

## 🔐 Usuários padrão criados

| Username | Senha     | Role    |
|----------|-----------|---------|
| admin    | master123 | MANAGER |
| user     | user123   | USER    |

> As senhas são codificadas automaticamente com BCrypt.

---

## 🔗 Testando a API

Você pode testar usando **Postman**, **curl** ou pelo navegador.

### Rotas abertas (sem autenticação):
- `GET /` - Welcome message

### Rotas protegidas (requer autenticação):

- `GET /users` - Acesso para **USER** ou **MANAGER**
- `GET /managers` - Acesso apenas para **MANAGER**
- `GET /users-area` - Acesso autenticado (**USER** ou **MANAGER**)
- `GET /managers-area` - Acesso autenticado (**MANAGER**)

### Exemplo de requisição cURL:

```bash
# Acesso como USER
echo -n user:user123 | base64
# Resultado: dXNlcjp1c2VyMTIz

curl -H "Authorization: Basic dXNlcjp1c2VyMTIz" http://localhost:8080/users
```

```bash
# Acesso como MANAGER
echo -n admin:master123 | base64
# Resultado: YWRtaW46bWFzdGVyMTIz

curl -H "Authorization: Basic YWRtaW46bWFzdGVyMTIz" http://localhost:8080/managers
```

### Login HTTP Basic pelo Postman
- Autenticação: **Basic Auth**
- Username: `user` ou `admin`
- Password: `user123` ou `master123`

---

## 🎉 Sobre o projeto

Este projeto foi desenvolvido para estudo de autenticação e autorização usando **Spring Security** em aplicações REST APIs.

Inclui exemplos de:
- Controle de acesso por Roles.
- Criação automática de usuários na inicialização.
- Proteção de endpoints.
- Configuração de segurança moderna com `SecurityFilterChain` (sem estender `WebSecurityConfigurerAdapter`).

---

## 📅 Futuras melhorias (opcionais)

- Autenticação JWT (Bearer Token)
- Cadastro de usuários via API
- Melhorar o tratamento de exceções (401/403 personalizados)
- Front-end de login usando OAuth2 ou JWT

---

## 👤 Autor

- [Vitório Barreto]([https://github.com/seu-usuario](https://github.com/VitorioBarreto))

