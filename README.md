# Employee Database Management System

## Описание проекта

REST API приложение для управления данными сотрудников, разработанное на **Java Spring Boot**. Приложение предоставляет CRUD операции для работы с таблицей `employee` в базе данных.

## Технологии

| Технология | Назначение |
|------------|------------|
| Java 17 | Язык программирования |
| Spring Boot 3.x | Фреймворк для создания приложения |
| Spring Data JPA | Работа с базой данных |
| Spring Web | REST API |
| H2 Database | In-memory база данных |
| Lombok | Уменьшение boilerplate кода |
| Maven | Сборка проекта |

## Функциональность

| Метод | Endpoint | Описание |
|-------|----------|----------|
| POST | `/api/employers` | Создание нового сотрудника |
| GET | `/api/employers/{id}` | Получение сотрудника по ID |
| GET | `/api/employers` | Получение списка всех сотрудников |
| PUT | `/api/employers/{id}` | Обновление данных сотрудника |
| DELETE | `/api/employers/{id}` | Удаление сотрудника |

## Структура проекта

```
src/main/java/mystartup/assignment8/
├── Assignment8Application.java      # Главный класс приложения
├── config/
│   └── AppConfig.java                # Конфигурация CORS
├── controller/
│   └── EmployerController.java       # REST контроллер
├── dto/
│   ├── CreateEmployer.java           # DTO для создания
│   └── UpdateEmployer.java           # DTO для обновления
├── models/
│   └── Employer.java                 # Сущность Employee
├── repository/
│   └── EmployerRepository.java       # JPA репозиторий
└── service/
    └── EmployerService.java          # Бизнес-логика
```

## Модель данных (Employee)

| Поле | Тип | Описание |
|------|-----|----------|
| id | Long | Уникальный идентификатор (автоинкремент) |
| name | String | Имя сотрудника |
| position | String | Должность |
| salary | BigDecimal | Зарплата |
| hireDate | String | Дата найма |

## Установка и запуск

### Требования

- Java 17 или выше
- Maven 3.6+
- Git

### Инструкция по запуску

1. **Клонировать репозиторий:**
   ```bash
   git clone https://github.com/your-username/assignment8.git
   cd assignment8
   ```

2. **Собрать проект:**
   ```bash
   mvn clean install
   ```

3. **Запустить приложение:**
   ```bash
   mvn spring-boot:run
   ```

4. **Приложение запустится на порту 8080:**
   ```
   http://localhost:8080
   ```

5. **H2 Console (для просмотра базы данных):**
   ```
   http://localhost:8080/h2-console
   ```
   - JDBC URL: `jdbc:h2:mem:employerdb`
   - Username: `sa`
   - Password: (оставить пустым)

## Примеры использования API

### 1. Создание сотрудника (POST)

**Запрос:**
```bash
curl -X POST http://localhost:8080/api/employers \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Иван Петров",
    "position": "Senior Java Developer",
    "salary": 250000.00,
    "hireDate": "2024-01-15"
  }'
```

**Ответ:**
```json
{
  "id": 1,
  "name": "Иван Петров",
  "position": "Senior Java Developer",
  "salary": 250000.00,
  "hireDate": "2024-01-15"
}
```

### 2. Получение сотрудника по ID (GET)

**Запрос:**
```bash
curl http://localhost:8080/api/employers/1
```

**Ответ:**
```json
{
  "id": 1,
  "name": "Иван Петров",
  "position": "Senior Java Developer",
  "salary": 250000.00,
  "hireDate": "2024-01-15"
}
```

### 3. Получение всех сотрудников (GET)

**Запрос:**
```bash
curl http://localhost:8080/api/employers
```

**Ответ:**
```json
[
  {
    "id": 1,
    "name": "Иван Петров",
    "position": "Senior Java Developer",
    "salary": 250000.00,
    "hireDate": "2024-01-15"
  },
  {
    "id": 2,
    "name": "Мария Сидорова",
    "position": "Project Manager",
    "salary": 200000.00,
    "hireDate": "2024-02-01"
  }
]
```

### 4. Обновление сотрудника (PUT)

**Запрос:**
```bash
curl -X PUT http://localhost:8080/api/employers/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Иван Петров",
    "position": "Lead Java Developer",
    "salary": 300000.00,
    "hireDate": "2024-01-15"
  }'
```

**Ответ:**
```json
{
  "id": 1,
  "name": "Иван Петров",
  "position": "Lead Java Developer",
  "salary": 300000.00,
  "hireDate": "2024-01-15"
}
```

### 5. Удаление сотрудника (DELETE)

**Запрос:**
```bash
curl -X DELETE http://localhost:8080/api/employers/1
```

**Ответ:** `204 No Content`

## Конфигурация базы данных

Файл `src/main/resources/application.properties`:

```properties
# H2 Database
spring.datasource.url=jdbc:h2:mem:employerdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

# JPA
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```


## Тестирование

Для тестирования API можно использовать:

- **Postman** — графический инструмент для тестирования API

## Автор

[Diyaz]
```
