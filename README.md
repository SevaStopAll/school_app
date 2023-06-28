# Проект Умное Школьное Приложение

## Описание
Умное школьное приложение - попытка создать проект с реальной задачей. А именно - возможность дать школе альтернативу существующим сервисам на случай их отключения. 

## Что должно быть выполнено по готовности проекта
Администратор - валидация пользователей, создание классов, дисциплин, создание расписания.
Учитель - просмотр расписания классов, выставление оценок и домашних заданий
Ученик - просмотр расписания классов (в частности, своего), возможность посмотреть домашнее задание и оценки

### Стек:
- **Java 17**
- **Spring Boot 2.7.10**
- **PostgreSQL 14**
- **Spring (Data, MVC)**

### Запуск
Из IDE: Main.class /src/main/java/ru.sevastopall.schoolapp

Docker-Compose:
1. клонируем проект через git clone; 
2. переходим в папку проекта;
3. вводим команду docker-compose build;
4. после завершения сборки вводим docker-compose up;
5. работа с проектом доступна через 127.0.0.1:80:8080;

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

### Текущие задачи:
        Увеличение количества информации, доступной в отчетах.     
