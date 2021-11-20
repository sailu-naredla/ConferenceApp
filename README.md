
1. import project in to Eclipse/STS

2. Run the project

3. On application bootstarp springboot populates the data in to H2 tables- refer src/main/resoutce/data.sql file
in source code --  This inserts Rooms master data in H2 DB

INSERT INTO ROOMS (id, room_number, status, created_on) VALUES (1, 'R1001', true, CURRENT_TIMESTAMP());    
INSERT INTO ROOMS (id, room_number, status, created_on) VALUES (2, 'R1002', true, CURRENT_TIMESTAMP());    
INSERT INTO ROOMS (id, room_number, status, created_on) VALUES (3, 'R1003', true, CURRENT_TIMESTAMP()); 

4. Access H2 console http://localhost:8080/h2-console

NOTE : no password required and click on connect


5. Access Swagger UI to test API's

http://localhost:8080/swagger-ui.html#/

6. Add new talk wih Room details

URL : http://localhost:8080/api/v1/talksto
Http Method: POST
Content-Type : application/json

Input:
{
	"title":"TalkOnCreditSuisse",
	"talkAbstract":"Discussion on Investment Banking",
	"room":"R1001",
	"speaker": {
		"name":"Sailu Naredla",
		"company":"Credit Suisse",
		"email":"infonaredla@gmail.com",
		"bio":"Technologist"
	}
}

Output:

{
    "title": "TalkOnCreditSuisse",
    "response": "ok"
}


7. Add New Attendees to Attendees database

URL : http://localhost:8080/api/v1/attendees
Http Method: POST
Content-Type : application/json

Input:
{
	"name":"Sailu Naredla",
	"company":"Credit Suisse",
	"email":"infonaredla1@gmail.com"
}


Output:
{
    "email": "infonaredla1@gmail.com",
    "response": "ok"
}

8. Enroll Attendees to the specific talk

URL : http://localhost:8080/api/v1/talks/1/attendees/2
Http Method: PUT

Output:

{
    "email": "infonaredla@gmail.com",
    "title": "TalkOnCreditSuisse",
    "response": "ok"
}

9. GET attendees by talk

URL : http://localhost:8080/api/v1/attendees/TalkOnCreditSuisse
Http Method: POST

Output:
[
  {
    "title": "TalkOnCreditSuisse",
    "talkAbstract": "Discussion on Investment Banking",
    "room": "R1001",
    "speaker": {
      "name": "Sailu Naredla",
      "company": "Credit Suisse",
      "email": "infonaredla@gmail.com",
      "bio": "Technologist"
    },
    "attendees": [
      {
        "name": "Sailu Naredla",
        "compnay": null,
        "email": "infonaredla1@gmail.com",
        "registered": "2021-11-20 15:33:17.187"
      }
    ]
  }
]
