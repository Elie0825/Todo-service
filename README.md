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

## Reflektion
- Webbtjänster: Lärt mig modellera resurser, använda korrekta HTTP-statuskoder och konsekvent JSON.
- Databaser: Sparar/hämtar via Spring Data MongoDB, validerar indata och hanterar fel globalt.
- Säkerhet: Grundkonfig via Spring Security (tillfälligt öppen i dev), stängt CSRF för API-klienter.
- Versionshantering: Branch → PR-flöde, issues kopplade till Project board.
- DevOps: Dockerfile + docker-compose för app + Mongo (+ mongo-express), reproducibel körning.

## Kurskrav – checklista
- [x] GitHub-repo med branches/PR och tydliga commits
- [x] GitHub Project board + user stories (issues)
- [x] Minst 2 endpoints (CRUD för /api/todos)
- [x] Korrekt statuskoder (200/201/204/400/404) och felhantering
- [x] Data lagras/manipuleras i MongoDB
- [x] Dokumentation: README + Swagger UI + Postman-samling
- [x] .gitignore korrekt, inga hemligheter i repo
- [x] Docker (Dockerfile) och docker-compose
