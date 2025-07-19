Postman url : http://localhost:8080/tasks

--------------------------------------------------------------------------------------------------------

Create a Task : POST/tasks
                Request
Method: POST

URL: /tasks

Headers:

Content-Type: application/json

Body :
JSON
'''{
  "title": "ABC",
  "description": "so and so",
  "status": "pending"
}
'''

------------------------------------------------------------------------------------------------------------

Read All : GET /tasks

Request

Method: GET

URL: /tasks

-----------------------------------------------------------------------------------------------------------

Update a Task – PUT /tasks/{id}
Request

Method: PUT

URL: /tasks/trk8jf2ks

Headers:

Content-Type: application/json

Body :
'''
{
  "title": "Write Updated README",
  "description": "Include CRUD API samples and JSON bodies",
  "status": "in-progress"
}
'''

-----------------------------------------------------------------------------------------------------------

Delete a Task – DELETE /tasks/{id}
Request

Method: DELETE

URL: /tasks/trk8jf2ks

Response

204 No Content (if successful)

404 Not Found (if ID does not exist)

------------------------------------------------------------------------------------------------------------


For H2 database:
in the chrome enter the url : http://localhost:8080/h2-console
update jdbc url :  jdbc:h2:mem:taskdb
then connect


