
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
--

GET
-
```
http://localhost:8080/person
```
![image](https://github.com/user-attachments/assets/352ff18c-87d0-42ba-ac48-7fa2b6e6d785)
![image](https://github.com/user-attachments/assets/0f3e1c0a-0748-4625-a8e0-7d89fec7d5c5)


POST
-
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


PUT
-
```
http://localhost:8080/person/{/id}
```
![image](https://github.com/user-attachments/assets/15078389-78a3-4e7f-8683-893a3ff151f3)
![image](https://github.com/user-attachments/assets/ad41962d-3e0c-48b1-b14d-28508ab388b3)


DELETE
-
```
http://localhost:8080/person/{/id}
```
![image](https://github.com/user-attachments/assets/b258b599-53b6-4061-b823-163028a4f61c)


CLIENTE
--

GET
-
```
http://localhost:8080/client
```
![image](https://github.com/user-attachments/assets/e75583b6-2490-475b-9920-5a4cf87a6629)
![image](https://github.com/user-attachments/assets/4c69904c-f753-4b2c-b8ad-51d650687dc8)


POST
-
```
http://localhost:8080/client
```
```
{
  "password": "12345dylan",
  "estate": true,
  "person": {
    "idperson": 12
  }
}
```
![image](https://github.com/user-attachments/assets/b9c72cdf-0967-4233-998b-b379826f43fc)
![image](https://github.com/user-attachments/assets/d010a73d-1214-48ea-884f-f66683569d4f)
![image](https://github.com/user-attachments/assets/45603f7f-ec2d-4196-84c1-16b9ec47515f)


PUT
-
```
http://localhost:8080/client/{/id}
```
![image](https://github.com/user-attachments/assets/d91adb59-04ca-4c7a-857c-e1fb024e92bf)
![image](https://github.com/user-attachments/assets/c9756d10-fb1f-4ae4-a4fb-dfd32da868be)
![image](https://github.com/user-attachments/assets/e2205b42-231d-4498-9ded-ef48379bbbda)



DELETE
-
```
http://localhost:8080/client/{/id}
```
![image](https://github.com/user-attachments/assets/31276056-2a52-408d-8800-c00071231514)
![image](https://github.com/user-attachments/assets/c1ceabb3-f5dc-4760-80b2-4c0e36c2942b)


VALIDACIONES
--


MICROSERVICIO DE PERSONA Y CLIENTE
--
PRUEBAS DE FUNCIONAMIENTO
--
