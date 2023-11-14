 <h1> ms User </h1>

Status: finished ✅
>
+ Description :
+ This project is made with 5 endponts, a post to create new users, post to create login, put to update the password, put to update the user, get users by id.
>

### The fields used in the Entity User class are:
+ Id
+ firstName (Minimum of 3 characters)
+ lastName ( Minimum of 3 characters)
+ cpf (Valid Format Required)
+ birthdate ( YYYY-MM-DD )
+ email  (Valid Format Required)
+ password (Minimum of 6 characters)
+ active (boolean)

### The fields used in the Entity Login class are:

+ email  (Valid Format Required)
+ password (Minimum of 6 characters)

>
### To add a user you need to fill in the following fields:

+ firstName 
+ lastName 
+ cpf 
+ birthdate 
+ email
+ password 
+ active 
>
### Example of how to add users to the database using POST users:
curl --location 'http://localhost:8080/v1/users' \
--data
```bash

--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "joao",
    "lastName": "silva",
    "cpf": "408.446.570-42",
    "birthdate": "2000-11-20",
    "email": "joao22@email.com",
    "password": "123456789",
    "active": true
}'
```
### To create login you need to fill in the following fields:
> obs:  Email and password registered in the database
+ email 
+ password 
>
### Example of how to login using POST:
curl --location 'http://localhost:8080/v1/users/login' \
--data
```bash

--header 'Content-Type: application/json' \
--data-raw '{
    "email": "joao22@email.com",
    "password": "123456789"
}'
```
>
### Example of how to update user, using the put users:
curl --location --request PUT 'http://localhost:8080/v1/users/{id}' \
>
--data '
```bash

--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "maria",
    "lastName": "alves",
    "cpf": "408.446.570-41",
    "birthdate": "2000-10-19",
    "email": "maria22@email.com",
    "password": "123456789",
    "active": true
}'
```
### Example of how to update the password by id, using the put password:
curl --location --request PUT 'http://localhost:8080/v1/users/{id}/password' \
>
--data '
```bash

--header 'Content-Type: application/json' \
--data '{
    "id": 1,
    "password": "123456789"
}'
```  

>
### Example of how to get users by id:
>
#### curl --location --request GET '(http://localhost:8080/v1/users/{id})' 



