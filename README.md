### Overview
- The 'tasks-logging-api' is responsible for the task status and has been implemented data (CSV) import function.

### task-logging-api
- Spring boot(Server) to develop RESTful web services and microservices.

### Description:

**'Tasks-logging-api'** is a REST API service using a monolithic architecture for manipulating data and working with Tasks objects. API is divided into several layers:

- Controller
- restController
- Entities
- Validation
- Repositories
- Services


**Entities**
- Task
- TaskStatus


**Services**
- CsvFileServices
- TaskService


### Prerequisites
- JDK 11
- Spring Boot
- Spring RestController
- Swagger
- MySql
- Without Lombok


### Repository
- [repo](https://github.com/duoqdzj/TasksLoggingApi.git)

### These are the API's

- Create task : /api/createTask
- Edit task : /api/editTask
- Delete task : /api/taskId
- Get all task : /api/getTask

