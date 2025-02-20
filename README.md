# Proyecto: ERP-LIMA S.A.C - Gestión de Médicos

Este proyecto implementa un sistema CRUD para la gestión de médicos utilizando tecnologías como Spring Boot, Maven, Git, GitHub, JPA, JPQL y MySQL.
Presentacion: [https://youtu.be/ABQHuAsZZcs](https://youtu.be/ABQHuAsZZcs)
## 📌 Tecnologías Utilizadas

- **Spring Boot** - Framework para desarrollo de aplicaciones en Java.
- **Maven** - Manejador de dependencias y construcción del proyecto.
- **Git & GitHub** - Control de versiones y repositorio remoto.
- **JPA (Java Persistence API) & JPQL** - Manejo de persistencia de datos.
- **MySQL** - Base de datos relacional para almacenamiento de la información.
- **HTML** - Vistas del proyecto en formato web.
```

## 📌 Base de Datos

La base de datos utilizada es **MySQL** y debe crearse con el siguiente nombre:

```
BDTUAPELLIDO
```

### 📋 Estructura de la Tabla `TBL_MEDICO`

```sql
-- Crear la base de datos 
CREATE DATABASE IF NOT EXISTS bd_coila_lp2_ef;
USE bd_coila_lp2_ef;

-- Crear la tabla medico
CREATE TABLE IF NOT EXISTS tbl_medico (
    id_medico INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    dni VARCHAR(20) NOT NULL,
    estado_civil VARCHAR(50),
    fecha_nacimiento DATE NOT NULL
);

```

## 🛠 Instalación y Configuración

1. **Clonar el repositorio**

   ```sh
   git clone https://github.com/JeniferCoila/lp_II_25_EF.git
   ```

2. **Configurar MySQL**

   - Crear la base de datos `bd_coila_lp2_ef`.

   - Configurar `application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/bd_coila_lp2_ef
   spring.datasource.username=tuusuario
   spring.datasource.password=tupassword
   ```

3. **Compilar y ejecutar la aplicación**

   ```sh
   mvn spring-boot:run
   ```

## 📌 Funcionalidades Implementadas

- CRUD de médicos (Crear, Leer, Actualizar, Eliminar).
- Interfaz basada en HTML.
- Persistencia de datos con MySQL y JPA.
- Uso de JPQL para consultas avanzadas.

## 🔁 Control de Versiones (Git)

Este proyecto sigue una estructura de commits bien definida:

1. **Inicio del proyecto** (`git commit -m "Inicio del proyecto"`)
2. **Implementación de CRUD** (`git commit -m "Implementación CRUD"`)
3. **Finalización y ajustes finales** (`git commit -m "Proyecto finalizado"`)

## 📌 Autores

- **Jenifer Coila** - Desarrollador Web

## 📜 Licencia

Este proyecto está bajo la licencia MIT. 

---

¡Gracias por usar este sistema! 🚀

