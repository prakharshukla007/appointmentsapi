# appointmentsapi
APPOINTMENTS RESTful API

This is a basic REST api built for creating, reading, updating and deleting appointments to/from a H2 database.

Steps to run the applicatin :-
	1. Clone/download the project from the link - https://github.com/prakharshukla007/appointmentsapi/tree/master
	2. Import the project into Spring Tool Suite 4 or any other Java IDE.
	3. Run the application as Spring Boot Application.
	4. DISCLAIMER : The data stored with POST requests in the present running session of the aplication will not be available when a new session is invoked. New POST requests need to be executed before using GET requests, in order to see any data.

Sample payloads :-

    {
        "appointmentTimeStamp": "2022-08-01 15:30:00",
        "purpose": "Spring Boot exam",
        "appointmentDuraton": 2.5
    }
    {
        "appointmentTimeStamp": "2022-07-16 11:00:00",
        "purpose": "Java Lecture",
        "appointmentDuraton": 3.0
    }
    {
        "appointmentTimeStamp": "2022-07-30 12:30:00",
        "purpose": "Councelling",
        "appointmentDuraton": 1.0
    }
    {
        "appointmentTimeStamp": "2022-08-01 10:30:00",
        "purpose": "Therapy",
        "appointmentDuraton": 1.5
    }

Steps to execute application :-
	1. Use the payloads given above in Postman or any client application one by one with a POST request. 
	   URL for the same is - http://localhost:8080/appointments
	   One can try to give empty details in these payloads to see different custom error messages.
	2. Upon posting all these payloads to the DB, we can now retrieve them using the following URL using a GET request - http://localhost:8080/appointments
	   If no appointments are committed to the DB, we can observe a custom error message being returned in response.
	3. To retrieve an appointment based on it's ID, we can use this url in a GET request - http://localhost:8080/appointments/3
	   Here 3 is the ID of an appointment. If no appointment is found with the given ID, a customer error message is displayed.
	4. To delete an appointment we can use this URL in a DELETE request - http://localhost:8080/appointments/2
	   Here 2 is the ID of the appointment. If no appointment is found for the ID, a customer error message is displayed.
	5. To update the duration of an appointment, we can use this URL in a PUT request - http://localhost:8080/appointments/2
	   Here, 2 is the ID of the appointment being updated. We also need to give the updated appointment object values in the request body.
	6. We can also obtain appointments in a certain range of dates. For this, we can use the following URL :-
	   http://localhost:8080/appointments/2022-07-17/2022-08-02
	   Here, two dates are mentioned in the format "yyyy-MM-dd". This request will return all the appointments belonging to the given range.
	   
To view the data saved in the H2 Database, follow the following steps :-
	1. Run the application following the steps mentioned above for the same.
	2. Access the URL - http://localhost:8080/h2-console to access the H2 console.
	3. Use this entry in the JDBC url field - jdbc:h2:mem:appointmentdb
	4. User Name - root, Password - root
	4. Use the query "select * from appointment;" to view the data stored in the DB.
