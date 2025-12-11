# 🎬 Gestión de Películas - Spring Boot

Aplicación web desarrollada con Spring Boot para gestionar un catálogo de películas y sus géneros. Permite realizar operaciones CRUD completas sobre las tablas `peliculas` y `generos`.

Este proyecto fue realizado como parte del Trabajo Práctico N.º 6 de la materia **Laboratorio de Programación (2025)**.

---

## 📌 Funcionalidades principales

- ✅ Listado de películas con su género
- ✅ Alta, edición y eliminación de películas
- ✅ Gestión de géneros (alta, edición, eliminación)
- ✅ Validaciones en los formularios
- ✅ **Sistema de Login y Seguridad** con Spring Security
- ✅ **Roles de Usuario** (ADMIN, VA)
- ✅ **Documentación de API** con Swagger UI
- ✅ Visualización de los datos en PhpMyAdmin

---

## 🧱 Estructura del proyecto

El proyecto sigue el patrón MVC (Modelo - Vista - Controlador) y está dividido en capas:

| Capa          | Descripción                                                       |
| ------------- | ----------------------------------------------------------------- |
| `modelo`      | Entidades `Pelicula`, `Genero` y `Usuario`, mapeadas con JPA      |
| `repositorio` | Interfaces que extienden `JpaRepository` para el acceso a datos   |
| `servicio`    | Lógica de negocio y seguridad (`UserDetailsServiceImpl`, etc.)    |
| `controlador` | Controladores web y REST para manejar rutas y API                 |
| `config`      | Configuraciones de Seguridad, Datos iniciales y OpenAPI           |
| `templates`   | Páginas HTML con Thymeleaf para mostrar formularios, listas, etc. |
| `resources`   | Configuración en `application.properties`                         |

---

## 🛠️ Tecnologías utilizadas

- Java 21
- Spring Boot 3.5.x
- Spring Data JPA
- Spring Security
- Thymeleaf
- MySQL
- Maven
- SpringDoc OpenAPI (Swagger)
- Lombok

---

## 🗃️ Base de datos

**Nombre de la base:** `cine`  
Tablas incluidas:

### 🎬 Tabla `peliculas`

| Campo        | Tipo     | Longitud | Notas                           |
| ------------ | -------- | -------- | ------------------------------- |
| id           | Numérico | 5        | Clave primaria, autogenerado    |
| titulo       | Texto    | 40       | Obligatorio, con validación     |
| director     | Texto    | 30       | Obligatorio                     |
| protagonista | Texto    | 30       | Obligatorio                     |
| anio         | Numérico | 4        | Rango entre 1888 y 2100         |
| genero_id    | FK       | -        | Relación con la tabla `generos` |

### 🗂️ Tabla `generos`

| Campo  | Tipo     | Longitud | Notas          |
| ------ | -------- | -------- | -------------- |
| id     | Numérico | 5        | Clave primaria |
| nombre | Texto    | 30       | Obligatorio    |

### 👤 Tabla `usuario`

| Campo    | Tipo     | Notas                                    |
| -------- | -------- | ---------------------------------------- |
| id       | Numérico | Clave primaria, autogenerado             |
| username | Texto    | Único, utilizado para login              |
| password | Texto    | Almacenada (puede requerir encriptación) |
| rol      | Texto    | Roles: ADMIN, VA                         |

---

## ⚙️ Configuración

Archivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/cine
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
```

### 🔑 Usuarios por defecto

Al iniciar la aplicación, si no existe, se crea automáticamente:

- **Usuario:** `admin`
- **Contraseña:** `admin`
- **Rol:** `ADMIN`

### 📚 Documentación API

La documentación interactiva de la API está disponible en:

- **Swagger UI:** `http://localhost:8080/swagger-ui/index.html`
