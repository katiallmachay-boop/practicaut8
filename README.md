# Práctica UT8-Gestión de Campamento de Verano

Aplicación web desarrollada con **Spring Boot**, **JPA/Hibernate**, **Thymeleaf** y **MySQL** para gestionar las actividades y participantes de un campamento de verano.

> Práctica UT8 - C.F.G.S DAW | Programación

---

## Descripción

Esta aplicación permite gestionar de forma completa un campamento de verano:

- Actividades: registro de actividades con su monitor responsable, edad mínima requerida y número de plazas disponibles.
- Participantes: registro de los niños/as inscritos con sus datos personales y alergias alimentarias.

## Entidades

### Clase Actividad
 id: Identificador autoincremental
 nombre String: Nombre de la actividad
 monitor String: Monitor responsable
 edadMinima int:  Edad mínima para participar
 plazas int: Número de plazas disponibles
 duracion int: Duración en minutos

### Clase Participante
  id: Identificador autoincremental
  nombre String: Nombre del participante
  apellidos String: Apellidos del participante
  edad int: Edad del participante
  alergiaAlimentaria String: Alergia alimentaria
  
## Endpoints disponibles
  GET `/inicio`: Página principal
  GET  `/listadoActividades`: Listado de todas las actividades
  GET  `/listadoParticipantes`: Listado de todos los participantes
  GET/POST `/altaActividad`: Formulario de nueva actividad
  GET/POST `/altaParticipante` : Formulario de nuevo participante

##  Despliegue en producción

La aplicación está desplegada en Railway:practicaut8-production.up.railway.app

## Requisitos previos
- Java 17
- MySQL 8.0+
- Maven 3.8+
- Spring Boot 3.x

## Instalación y ejecución local

### 1. Clonar el repositorio

```bash
git clone https://github.com/katiallmachay-boop/practicaut8.git
cd practicaut8
```

### 2. Crear la base de datos

Ejecuta el script `schema.sql` que está en la raíz del proyecto:

```bash
mysql -u root -p < schema.sql
```

O manualmente en MySQL Workbench.

### 3. Configurar application.properties

Edita el archivo `src/main/resources/application.properties` con tus credenciales locales:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/campamento
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.thymeleaf.cache=false
```

### 4. Ejecutar la aplicación

```bash
mvn spring-boot:run
```
Accede en: **http://localhost:8080/inicio**

## Script SQL

El archivo `schema.sql` en la raíz del proyecto crea la base de datos y un usuario con permisos:

```sql
CREATE DATABASE IF NOT EXISTS campamento;
CREATE USER IF NOT EXISTS 'campamento_user'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON campamento.* TO 'campamento_user'@'localhost';
FLUSH PRIVILEGES;
```
Las tablas las genera automáticamente Hibernate con `ddl-auto=update`.

## Estructura del proyecto

```
practicaut8/
├── src/
│   ├── main/
│   │   ├── java/com/kllm/practicaut8/
│   │   │   ├── controller/    # AppController.java
│   │   │   ├── model/         # Actividad.java, Participante.java
│   │   │   ├── repository/    # ActividadRepository, ParticipanteRepository
│   │   │   └── PracticaUT8Application.java
│   │   └── resources/
│   │       ├── templates/     # Plantillas Thymeleaf
│   │       └── application.properties
├── schema.sql
├── system.properties
├── pom.xml
└── README.md
```

---

## Despliegue en Railway

Variables de entorno configuradas en Railway:
 `DATABASE_URL`:URL de conexión MySQL
 `MYSQLUSER`: Usuario de la base de datos
 `MYSQLPASSWORD`: Contraseña de la base de datos
 `PORT`: Puerto (8080)
## Capturas de pantalla
### Página principal
<img width="960" height="477" alt="inicio" src="https://github.com/user-attachments/assets/522ca148-da12-4369-929c-18bc0e80875a" />


### Listado de Actividades



### Formulario Nueva Actividad

