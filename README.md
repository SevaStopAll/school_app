# Проект Умное Школьное Приложение

## Описание
Умное школьное приложение - попытка создать проект с реальной задачей. А именно - возможность дать школе альтернативу существующим сервисам на случай их отключения. 

## Что выполнено на данный момент:
- Администратор - валидация пользователей, создание классов, дисциплин, создание расписания. Размещение новостей на главной странице. 
- Учитель - просмотр расписания классов, выставление оценок и домашних заданий
- Ученик - просмотр расписания классов (в частности, своего), возможность посмотреть домашнее задание и оценки
- Все пользователи могут пользоваться отправкой сообщений и групповыми чатами.
- После получения сообщения, выставления домашего задания или оценки, пользователь/ученик получает уведомление.
- Ученик или учитель может сформировать отчет по оценкам. 

### Текущие задачи:
Backend:
Пока срочных задач нет. 

Fronend:
Поработать с Bootstrap, поискать другие варианты оформления, добавить анимацию на некоторые страницы. 

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

