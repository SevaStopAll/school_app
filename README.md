# Проект Умное Школьное Приложение

## Описание
Умное школьное приложение - попытка создать проект с реальной задачей. А именно - возможность дать школе альтернативу существующим сервисам на случай их отключения. 

## Что выполнено на данный момент:
Администратор - валидация пользователей, создание классов, дисциплин, создание расписания.
Учитель - просмотр расписания классов, выставление оценок и домашних заданий
Ученик - просмотр расписания классов (в частности, своего), возможность посмотреть домашнее задание и оценки

### Задачи на будущее:
Тестирование функционала end-to-end. findByMessagesContaining - отладить работу данного сервиса.

### Стек:
- **Java 17**
- **Spring Boot 2.7.10**
- **PostgreSQL 14**
- **Spring (Boot, Data, MVC)**
- **JUnit 5, AssertJ, Mockito,testContainers**

### Запуск
Из IDE: Application.class /src/main/java/ru.sevastopall.schoolapp

Docker-Compose:
1. В стадии переработки. 

### Требования:
- **Java 17**
- **Maven 3.8**
- **PostgresSQL 14**
- **Docker**
- **Docker-compose**

### Скриншоты:
Окно регистрации


![](src//main/resources/static/Register.png)

Окно расписания


![](src//main/resources/static/ClassesSchedule.png)

Добавление учебного дня для класса


![](src/main/resources/static/createClassDay.png)

Окно урока 

![](src/main/resources/static/LessonScreen.png)

