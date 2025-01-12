# Ejercicio Técnico - Líder Técnico Junior

Este repositorio contiene la solución al ejercicio técnico solicitado, implementado en **Java** y **Node.js**, organizados en carpetas separadas para facilitar su navegación y comprensión.

## Descripción del Ejercicio

El objetivo es implementar un API REST que gestione la información de clientes utilizando diferentes opciones de almacenamiento (memoria temporal, archivo JSON o bases de datos temporales/permanentes). Las funcionalidades requeridas son:

1. **Crear el repositorio del proyecto.**
2. **Realizar commits y push por cada servicio implementado.**
3. **Desarrollar los primeros 3 servicios en la rama principal.**
4. **Crear la rama `clientes-promedio` y desarrollar el servicio 4.**
5. **Realizar un merge entre la rama principal y `clientes-promedio`.**
6. **Servicios requeridos:**
   - Registro de clientes con los campos:
     - Nombre completo
     - Documento de identidad
     - Correo electrónico
     - Fecha de nacimiento (zona horaria local)
   - Listado de clientes ordenados alfabéticamente.
   - Listado de clientes ordenados por edad (de menor a mayor) mostrando nombre y edad.
   - Cantidad de clientes y promedio de edad.

## Estructura del Repositorio

```plaintext
├── java/clientapi
│   ├── src/
│   │   └── main/
│   │       └── java/
│   │           └── com/
│   │               └── example/
│   │                   └── clientapi/
│   │                       ├── controllers/
│   │                       ├── models/
│   │                       ├── services/
│   │                       └── repositories/
│   │                       └── exception/
│   └── pom.xml
├── node/
│   ├── src/
│   │   ├── controllers/
│   │   ├── models/
│   │   ├── routes/
│   │   └── services/
│   ├── package.json
│   └── server.js
└── README.md
```

### Java

La solución en Java utiliza:

- **Framework:** Spring Boot
- **Almacenamiento:** Temporal
- **Ejecución:**

  1. Navega a la carpeta `java/clientapi`.

  ```bash
  cd java/clientapi/
  ```

  2. Ejecuta `mvn spring-boot:run` para iniciar el servidor.

  ```bash
   mvn spring-boot:run
  ```

  3.  Accede a los servicios en `http://localhost:8080`.

### Node.js

La solución en Node.js utiliza:

- **Framework:** Express.js
- **Almacenamiento:** Archivo JSON.
- **Ejecución:**

  1. Navega a la carpeta `nodejs/`.

  ```bash
  cd nodejs/
  ```

  2. Ejecuta `npm install` para instalar dependencias.

  ```bash
  npm i
  ```

  3. Inicia el servidor con `npm run start`.

  ```bash
  npm run start
  ```

  4. Accede a los servicios en `http://localhost:3000`.

## Funcionalidades Implementadas

1. **Registro de clientes:** Permite registrar clientes con los campos requeridos.
2. **Listado alfabético:** Retorna los clientes ordenados alfabéticamente por nombre.
3. **Listado por edad:** Devuelve los clientes ordenados por edad de menor a mayor.
4. **Estadísticas:** Muestra el número total de clientes y el promedio de edad.

## Gestión de Ramas

1. La implementación inicial de los servicios se encuentra en la rama `main`.
2. El servicio de promedio de edad se desarrolló en la rama `clientes-promedio`, que posteriormente fue fusionada con `main`.
