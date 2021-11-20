
1. import project in to eclipse/STS

2. run the project

3. on application bootstarp springboot populates the data in to H2 tables- refer src/main/resoutce/data.sql file
in source code

4. access H2 console http://localhost:8080/h2-console

NOTE : no password required and click on connect

5. Run below queries on H2 console - To insert Rooms master data

INSERT INTO ROOMS (id, room_number, status, created_on) VALUES (1, 'R1001', true, CURRENT_TIMESTAMP());    
INSERT INTO ROOMS (id, room_number, status, created_on) VALUES (2, 'R1002', true, CURRENT_TIMESTAMP());    
INSERT INTO ROOMS (id, room_number, status, created_on) VALUES (3, 'R1003', true, CURRENT_TIMESTAMP()); 

6. Add new tlk

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


7. Add New Attendee

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

8. Add Attendees to talk

URL : http://localhost:8080/api/v1/talks/1/attendees/2
Http Method: PUT

Output:

{
    "email": "infonaredla@gmail.com",
    "title": "TalkOnCreditSuisse",
    "response": "ok"
}
