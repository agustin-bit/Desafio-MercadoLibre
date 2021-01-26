# Desafio MercadoLibre
Por Matías Gonzalo Luna

## Contexto
Magneto quiere reclutar la mayor cantidad de mutantes para poder luchar contra los X-Mens.
Te ha contratado a ti para que desarrolles un proyecto que detecte si un humano es mutante basándose en su secuencia de ADN.

## Tecnologías
- Java 8
- Spring Boot
- MySQL
- JPA
- AWS Elastic Beanstalk
- AWS RDS
- AWS CodePipeline
- Apache JMeter

## Ejecución de la aplicación
Para ejecutar la aplicación posicionese sobre la raiz del proyecto y escriba en la consola el comando correspondiente a sus necesidades de ambiente:

#### Para ambiente de desarrollo (local):
```curl
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```
Tenga en cuenta que para ejecutar el proyecto localmente debera de tener instalado mysql, java 8 y crear una base de datos llamada 'meli'.

#### Para ambiente de produción:
```curl
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```
Tenga en cuenta que no podra ejecutar el profile de produción en local debido a que la base de datos de AWS RDS esta restringuida solo para el uso dentro del entorno de AWS Elastic Beanstalk.

## Url's utiles
#### Desarrollo
http://localhost:5000

#### Producción
http://meli-env.eba-u5gqtpvm.sa-east-1.elasticbeanstalk.com

## Request utiles

#### Mutant checker
- POST http://localhost:5000/api/mutant/

- POST http://meli-env.eba-u5gqtpvm.sa-east-1.elasticbeanstalk.com/api/mutant/

Body de ejemplo:
```json
{
    "dna": [
        "ATGCGA",
        "CCGTCC",
        "TTAAGT",
        "ATAAGG",
        "CCTTTA",
        "TTTTGG"
    ]
}
```

Estados HTTP validos:
- 403: Human
- 200: Mutant

***

#### Stats info
- GET http://localhost:5000/api/stats

- GET http://meli-env.eba-u5gqtpvm.sa-east-1.elasticbeanstalk.com/api/stats

Respuesta de ejemplo:
```json
{
    "ratio": 0.7083333,
    "count_mutant_dna": 34,
    "count_human_dna": 14
}
```

***

#### Swagger Documentation
http://localhost:5000/api/swagger-ui/#/

http://meli-env.eba-u5gqtpvm.sa-east-1.elasticbeanstalk.com/api/swagger-ui/#/

## Code Coverage
Se testearon las clases con logica elemental para el funcionamiento de la aplicación. Los bajos niveles de coverage en DTO y Model es debido al uso de lombok.

![Code coverage](/files/coverage.png)

## Pipeline
Se implemento el uso del pipeline AWS CodePipeline, permitiendo así la entrega continua del producto final en cuestión. Se adjunta una demostración:

![AWS CodePipeline](/files/pipeline.png)

## Pruebas de carga
Para ejecutar las pruebas de carga de la aplicación debe de descargar Apache JMeter en el siguiente enlace:

https://jmeter.apache.org/

Luego descargar la siguiente configuración: 

https://github.com/mtsluna/Desafio-MercadoLibre/blob/master/files/jmeterload.jmx

Una vez descargada debe abrirla dentro de Apache JMeter, por defecto se encuentra configurado en 100 threads y 100 peticiones por hilo, que dan un total de 10000 request, ya sea de stats o de checkeo de mutantes.

## Diagramas
Se adjunta a continuación un enlace al pdf con los diagramas de secuencia del funcionamiento de la aplicación:
https://github.com/mtsluna/Desafio-MercadoLibre/blob/master/files/diagrams.pdf
