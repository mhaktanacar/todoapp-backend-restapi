# todoapp-backend-restapi
REST API for TO-DO Application

This REST API is created with using Spring framework and it is connected to a MySQL database.
Database's endpoint is 'mhacar-todo.cbfu5uvtisja.us-east-2.rds.amazonaws.com' with 3306 port.
Api can be reached from 'http://whattodo-env.eba-8mztkigm.us-east-2.elasticbeanstalk.com/api/'.

GET mappings:

* /api/todolists
* /api/todolists/{id}
* /api/users/{username}
* /api/todoelement/{id}
* /api//todoelements/{id}
* /api/{username}/todolists

POST mappings:

* /api/todolists
* /api/todoelement/{id}
* /api/users

DELETE mappings:

* /api/todolists/{id}
* /api/todoelement/{id}
