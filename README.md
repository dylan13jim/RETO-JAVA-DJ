
RETO JAVA
--
MICROSERVICIO DE PERSONA Y CLIENTE
--
BDD RELACIONAL
--
</br>Cabe mencionar que tiene que crear la bdd en el PGAdmin, ademas de que tiene que crear un usaurio y contraseña y modificar en el application properties</br>

```
# Configuración de la base de datos
spring.datasource.url=jdbc:postgresql://localhost:5432/retovf
spring.datasource.username=dylan
spring.datasource.password=130900
```
</br>Configuracion completa del application properties</br>
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
Cuando ingresa un CI que no cumple con parametros o requisitos
![image](https://github.com/user-attachments/assets/bd7975da-7056-4b67-818f-5a8ed48b0328)

Cuando ingresa una cdeula que ya existe dentro de la BDD
![image](https://github.com/user-attachments/assets/e07b5e58-b6ff-4ea2-94ed-238948dc3c21)

Cuando ingresa el id de una persona no existente o que no esat registrada dento de la BDD
![image](https://github.com/user-attachments/assets/db6a9eca-b080-4cb2-8546-0f324e230b1d)

Ingreso de contraseña obligatorio
![image](https://github.com/user-attachments/assets/92b035b7-14d3-45e2-965a-77bd1fa92067)

---
MICROSERVICIO DE CUENTA Y MOVIMIENTOS
---

BDD RELACIONAL
--
```
# Nombre de la aplicación
spring.application.name=retomicroservices2
server.port=8081

# Configuración de la base de datos
spring.datasource.url=jdbc:postgresql://localhost:5432/retovf
spring.datasource.username=dylan
spring.datasource.password=130900

# Configuración de Hibernate y JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Puerto de ejeución 8081
```
http://localhost:8081
```
CUENTA
--

GET
-
```
http://localhost:8081/account
```
![image](https://github.com/user-attachments/assets/b2922700-cc02-4e7e-aac3-9c7e23a041d4)
![image](https://github.com/user-attachments/assets/c9b28b75-01fe-44d8-b9aa-7010f9e76add)


POST
-
```
http://localhost:8081/account
```
```
{
  "numaccount": "9876543210",
  "typeaccount": "Ahorro",
  "inibalance": "150.00",
  "estateaccount": true,
  "client": {
    "idclient": 1
  }
}
```
![image](https://github.com/user-attachments/assets/95b562cb-3e6d-4d26-81ee-bde211938814)
![image](https://github.com/user-attachments/assets/1206a1fe-c368-41be-8688-4f0d3c9bcac5)
![image](https://github.com/user-attachments/assets/85a48cc7-7411-458f-b8f4-eb6f749a2a79)


PUT
-
```
http://localhost:8081/account/{/id}
```
![image](https://github.com/user-attachments/assets/376166ea-56f6-4298-8742-5aab947351e9)
![image](https://github.com/user-attachments/assets/f1405127-bc23-4e24-bd26-1e85491ccfdc)


DELETE
-
```
http://localhost:8080/account/{/id}
```
![image](https://github.com/user-attachments/assets/9765ad28-72f5-4f44-a3cd-e1d6411633d3)
![image](https://github.com/user-attachments/assets/1ab53f0a-707b-4439-a697-7fb12c2372d4)


MOVIMIENTOS
--

GET
-
```
http://localhost:8081/motion
```
![image](https://github.com/user-attachments/assets/5462aa7f-3fa6-4497-965c-ccd86474848b)
![image](https://github.com/user-attachments/assets/a8babd53-57b5-47f7-9af6-72e8a276e328)


POST
-
```
http://localhost:8081/motion
```
```
{
  "accountId": 1,
  "typemotion": "DEPOSITO",
  "value": 384.00
}
```
![image](https://github.com/user-attachments/assets/792c2e9b-e567-4c37-8549-a8f56de69feb)
![image](https://github.com/user-attachments/assets/270ad8b7-2640-4307-980c-89cdfb2b1d08)


PUT
-
```
http://localhost:8081/motion/{/id}
```
![image](https://github.com/user-attachments/assets/d4dc2a90-00c9-4186-b1a0-da5f15bc9f9a)
![image](https://github.com/user-attachments/assets/6b796d86-b06b-4f8c-9a7f-b13bc8f68584)


DELETE
-
```
http://localhost:8081/motion/{/id}
```
![image](https://github.com/user-attachments/assets/69c479f9-2449-403d-84c5-11a63854282d)
![image](https://github.com/user-attachments/assets/63e3df1d-fa2d-4576-999b-9fdd9b1c3f6d)


VALIDACIONES
--
Actualizacion del saldo cada vez que se realice un movimiento
Proceso relizado a la cuenta con ID: 4 con un monto inicial de 1050
![image](https://github.com/user-attachments/assets/b495294b-f7e4-42a3-afa1-b87d13da4a60)

DEPOSITO
-
Ingreso de monto de 729 $
![image](https://github.com/user-attachments/assets/e6958d93-f89a-482b-85fd-dcb5faa258ba)
![image](https://github.com/user-attachments/assets/c23bb732-035d-4df8-9314-3419506aa91f)


RETIRO
-
Retiro de 89 $
![image](https://github.com/user-attachments/assets/40efa0d0-0279-4c04-9670-d8e70919d301)
![image](https://github.com/user-attachments/assets/1e3428c6-e3c5-4a3e-8ba8-862e52b29f91)

Funcionamiento del deposito y retiro
-
Para que funciona correctamente el sistema, de manera obligatoria debe colocar ya sea (RETIRO - retiro - Retiro - etc puede alternar entre mayuscuala o minuscula, si cumple con la palabra estipulada funcionara ) o (DEPOSITO - deposito - Deposito), caso contrario el sistema generara un mensaje de alerta.
![image](https://github.com/user-attachments/assets/357df3ac-cf1a-40f3-951e-67feb8f674d2)

