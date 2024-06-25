# Practica-Spring-Boot-Avd

## AdoptaMe - Plataforma de Adopción de Mascotas
AdoptaMe es una plataforma de adopción de mascotas que permite a los usuarios buscar y adoptar mascotas que necesitan un hogar. El proyecto está desarrollado utilizando Spring Boot y H2 para el backend, y proporciona una API REST para interactuar con la plataforma.

## Tecnologías Utilizadas

- Spring Boot: Framework de desarrollo de aplicaciones Java.
- H2: Sistema de gestión de bases de datos relacional.
- Swagger: Herramienta para documentar y probar API REST.
- Lombok: Biblioteca Java que agiliza el desarrollo reduciendo la necesidad de escribir código repetitivo.

## Configuración del Proyecto

1. **Clonar el Repositorio**:
   ```bash
   git clone https://github.com/JuanDtrez/Practica-Spring-Boot-Avd
   ```

2. **Configurar la Base de Datos**:
    - Crear una base de datos H2 llamada `testdb`.
    - Actualizar las credenciales de la base de datos en el archivo `application.properties`.

3. **Compilar y Ejecutar el Proyecto**:
   ```bash
   cd AdoptaMe
   mvn spring-boot:run
   ```

4. **Acceder a la Documentación de la API**:
    - Una vez que la aplicación esté en funcionamiento, puedes acceder a la documentación de la API en: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

5. **Acceso a la consola web de H2**:
    - Para acceder a la consola web de H2, visita: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
    - Usuario: sa
    - Contraseña: sa

## Contribuir

Si deseas contribuir a este proyecto, puedes seguir estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu función: `git checkout -b feature/NuevaFuncion`.
3. Realiza tus cambios y haz commit: `git commit -am 'Agrega una nueva función'`.
4. Sube tus cambios: `git push origin feature/NuevaFuncion`.
5. Abre un pull request para solicitar la incorporación de tus cambios.

## Autor

- Juan Caicedo ([@juanCaicedo](https://github.com/JuanDtrez))
