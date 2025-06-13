# Spring Security Role-Based Authorization Example

This is a simple Spring Boot project demonstrating **Spring Security with role-based authorization**, using an **H2 in-memory database** for authentication with the default schema (`users` and `authorities` tables).

## 🔐 Features

- Basic Authentication with Spring Security
- In-memory H2 database integration
- Role-based access control using `@PreAuthorize`
- H2 Console enabled at `/h2-console`
- JDBC-based user management (`JdbcUserDetailsManager`)
- Users and roles preloaded on application startup

## ✅ Endpoints

| Endpoint   | Access Role | Description      |
|------------|-------------|------------------|
| `/admin`   | `ADMIN`     | Admin-only route |
| `/user`    | `USER`      | User-only route  |
| `/h2-console` | Public | H2 DB web console |

## 👤 Preloaded Users

| Username | Password | Role  |
|----------|----------|-------|
| `admin`  | `admin`  | ADMIN |
| `user`   | `user`   | USER  |

**Note:** Passwords are encoded using `BCryptPasswordEncoder`.

## 🛠️ Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Security
- H2 Database
- JDBC Authentication

## 📁 Database Schema

Spring Security uses the following default schema:

```sql
create table users (
  username varchar_ignorecase(50) not null primary key,
  password varchar_ignorecase(500) not null,
  enabled boolean not null
);

create table authorities (
  username varchar_ignorecase(50) not null,
  authority varchar_ignorecase(50) not null,
  constraint fk_authorities_users foreign key(username) references users(username)
);

create unique index ix_auth_username on authorities (username, authority);
