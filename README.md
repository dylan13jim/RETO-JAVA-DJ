
RETO JAVA
--
MICROSERVICIO DE PERSONA Y CLIENTE
--
BDD RELACIONAL
--
```
# Nombre de la aplicación
spring.application.name=retomicroservices
server.port=8080

# Configuración de la base de datos
spring.datasource.url=jdbc:postgresql://localhost:5432/retovf
spring.datasource.username=dylan
spring.datasource.password=130900

# Configuración de Hibernate y JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Puerto de ejeución 8080
```
http://localhost:8080
```
PERSONA
-
GET
```
http://localhost:8080/person
```
![image](https://github.com/user-attachments/assets/352ff18c-87d0-42ba-ac48-7fa2b6e6d785)
![image](https://github.com/user-attachments/assets/0f3e1c0a-0748-4625-a8e0-7d89fec7d5c5)

-
POST
```
http://localhost:8080/person
```
```
{    
    "nameperson": "Bryan Mateo ",
    "genderperson": "M",
    "ageperson": "20",
    "identification": "1721421621",
    "addressperson": "Chilibulo",
    "phoneperson": "0999992214"
}
```
![image](https://github.com/user-attachments/assets/23d98a5e-4172-4db1-a27e-4df4c8887917)
![image](https://github.com/user-attachments/assets/c908f05d-f36c-4380-896e-11bdb18740fc)
![image](https://github.com/user-attachments/assets/95a837b4-c8a1-48e8-8181-a1b0c319179c)


CLIENTE
```
http://localhost:8080
```

MICROSERVICIO DE PERSONA Y CLIENTE
--
PRUEBAS DE FUNCIONAMIENTO
--
