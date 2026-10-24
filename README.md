## API Gestión Académica (PPOO)
Proyecto en desarrollo para la administración de datos universitarios.
Por ahora solo está implementado el módulo de profesores `(/api/v1/teachers)`, que permite crear, consultar (con paginación), actualizar y eliminar docentes, incluyendo validación de correos duplicados.
### Stack
- Java 21 / Spring Boot 4
- PostgreSQL + Spring Data JPA
- Gradle
- Swagger / Scalar (disponibles en `/scalar/` y `/swagger-ui/index.html`)
- Postman (colección disponible en [postman_collection/](/postman_collection/PPOO_Universidad.postman_collection.json))

## Pendiente
- Docker: Crear el Dockerfile y docker-compose.yml para levantar la app y la base de datos fácilmente.
- Entidades del sistema: Diseñar e implementar las clases de Estudiantes, Materias, Horarios y sus relaciones.
- Seguridad y tests: Implementar autenticación y pruebas unitarias/integración.
- Manejo de errores: Cubrir mas casos de error.