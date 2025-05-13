# SpringBoot-API

# 🔐 API REST de Autenticação de Usuários com JWT (Stateless)

Este projeto é uma API REST construída com Java e Spring Boot, que permite o **registro**, **autenticação** e **autorização** de usuários usando **JWT (JSON Web Token)**. A autenticação é **stateless**, ou seja, sem armazenamento de sessões no servidor.

---

## ⚙️ Tecnologias utilizadas

- Java 17+
- Spring Boot 3.x
- Spring Security
- JWT (jjwt ou java-jwt)
- Spring Data JPA
- PostgreSQL (pode trocar por H2 para testes)
- Lombok
- Maven

---

## 📌 Funcionalidades

- ✅ Cadastro de usuário (com criptografia de senha)
- ✅ Login e geração de token JWT
- ✅ Autenticação via token (Bearer Token)
- ✅ Autorização baseada em perfis/roles
- ✅ Endpoints públicos e protegidos
- ✅ Validação de token e controle de acesso

---

## 🔐 Estrutura do JWT

O token JWT gerado contém:
- `sub` (username/email)
- `iat` (data de emissão)
- `exp` (data de expiração)
- `roles` (papéis do usuário, se aplicável)
