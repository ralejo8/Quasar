# Quasar
Han Solo ha sido recientemente nombrado General de la Alianza
Rebelde y busca dar un gran golpe contra el Imperio Galáctico para
reavivar la llama de la resistencia.
El servicio de inteligencia rebelde ha detectado un llamado de auxilio de
una nave portacarga imperial a la deriva en un campo de asteroides. El
manifiesto de la nave es ultra clasificado, pero se rumorea que
transporta raciones y armamento para una legión entera.
Desafío
Como jefe de comunicaciones rebelde, tu misión es crear un programa en Golang que retorne
la fuente y contenido del mensaje de auxilio. Para esto, cuentas con tres satélites que te
permitirán triangular la posición, ¡pero cuidado! el mensaje puede no llegar completo a cada
satélite debido al campo de asteroides frente a la nave.
Posición de los satélites actualmente en servicio
● Kenobi: [-500, -200]
● Skywalker: [100, -100]
● Sato: [500, 100]

# Documentación

En la siguiente url puede encontrar la documentacion de los servicios rest
http://3.230.72.2:1426/Quasar/swagger-ui.html#/comunicacion-controlador

# Urls
servicio Post
-http://3.230.72.2:1426/Quasar/topSecret

servicio Post
-http://3.230.72.2:1426/Quasar/topsecret_split/{name}

servicio Get
-http://localhost:8085/Quasar/api/topsecret_split

# Requisitos
instalar el jdk de java version 8. para ejecutar el proyecto se recomienda IDE para java eclipse
el IDE sele debe intalar el la libreria de lombok para el manejo de los modelos

# Ejecucion proyecto
En el IDE java se importa como un proyecto existente maven y se configura el arcchivo 
 application.properties con los siguientes parametros 
server.port= puerto por el va salir la aplicacion
server.servlet.context-path= nombre del path que desee
spring.data.mongodb.database= nombre base datos mongo
spring.data.mongodb.port= puerto mongo
spring.data.mongodb.host= ip mongo
spring.data.mongodb.username= usuario de mongo
spring.data.mongodb.password= clave db mongo

las pruebas unitarias estan desarrolladas en Junit
# Herramientas
-SpringBoot java
-maven
-Swagger
-Junit
-MongoDB
# Autor
Alejandro Monsalve Gutierrez
