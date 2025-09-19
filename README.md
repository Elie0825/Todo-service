# Todo Service (Spring Boot + MongoDB)

## Kör
1) Starta MongoDB:
   docker run -d --name mongo-todo -p 27017:27017 mongo:6
2) Starta appen:
   mvn spring-boot:run
- API: http://localhost:8080/api/todos
- Swagger: http://localhost:8080/swagger-ui.html

## Exempel (curl)
curl -i -X POST http://localhost:8080/api/todos -H "Content-Type: application/json" -d "{\"title\":\"Plugga\",\"description\":\"Spring + Mongo\",\"status\":\"TODO\",\"dueDate\":\"2025-09-30\"}"
curl -i http://localhost:8080/api/todos
## Felkoder (sammanfattning)
- 201 Created – POST /api/todos
- 200 OK – GET/PUT /api/todos
- 204 No Content – DELETE /api/todos/{id}
- 400 Bad Request – valideringsfel (t.ex. title saknas)
- 404 Not Found – felaktigt id
