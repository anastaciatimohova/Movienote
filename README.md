# Movienote

__Movienote__ – сервис для поиска фильма. Который позволит Вам сохранить фильм в избранное, напомнит о фильмах которые ещё не посмотрели, позволит выставить собственную оценку и оставить заметку «ваше впечатление».

## Технологии

- Внедрённые:
  - Java SE 15
  - Springboot
  - Spring Web
  - Spring Data JPA
  - Hibernate
  - PostgreSQL
  - Liquibase
  - Spring Security
  
- В планах:
  - ELK stack
  

## Первый запуск программы в тестовом режиме

1. Клонируйте этот репозиторий командой:
```sh
$ git clone https://github.com/AnastasiyaIlkevich/Movienote.git
```
2. В IntelliJ IDEA собирите проек в формате jar. Для этого выполните следующие действия:
	- откройте build.gradle:
	- запустите bootJar - ___Run___.

3. Запуск:
	- откройте папку с проектом …\Movienote\build\libs
	- Запустите командную строку в этой папке и введите для старта команду:
  ```sh
java -jar -DSpring.profiles.active=dev Movienote-0.0.1-SNAPSHOT.jar
```
  - Запустите браузер и введите http://localhost:8084/registration
  - Зарегестрируйтесь и войдите
  - Для тестирования rest controller пройдите по одному из ниже предложеных вариантов http://localhost:8084/"..."
  
|Значение “...”|RestController|
|----|-----|
|user|UserController| 
|genre|GenreController| 
|movie|MovieController| 
|status|StatusController| 
|notes|UserMoviesController|


## UserController localhost:8084/user: 
Методы работы GET/POST/PUT/DELETE с пользователем и БД.
### Method : GET
localhost:8084/user - предоставляет всех пользователь сохраненных в БД

localhost:8084/user/{username} - предостовляет конкретного пользователя сохранённого в БД
### Method : POST
localhost:8084/user - сохраняет пользователя в БД

__RequestBody__ :
 {"username": "say","email": "say@gmail.com","password": "1111"}

### Method : PUT
localhost:8084/user - изменяет пользователя в БД

__RequestBody__ :
 {"id": 1,"username": "say","email": "say@gmail.com","password": "2222"}

### Method : DELETE
localhost:8084/user/{id} - удаляет пользователя по ID в БД


Access address to UI Swagger
  ```sh
http://localhost:8080/swagger-ui/index.html
```

