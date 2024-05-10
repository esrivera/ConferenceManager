# Gestión del Seguimiento de Conferencias

Este programa está diseñado para ayudar en la gestión del seguimiento de conferencias. Con base en las limitaciones de tiempo del día y las duraciones de las charlas, el programa planifica y organiza las charlas en sesiones de mañana y tarde para una conferencia.

## Descripción del Problema

- La conferencia tiene múltiples temas, cada uno con sesiones de mañana y tarde.
- Cada sesión contiene varias charlas.
- Las sesiones de mañana comienzan a las 9:00 a.m. y deben finalizar a las 12:00 p.m. para el almuerzo.
- Las sesiones de la tarde comienzan a la 1:00 p.m. y deben finalizar a tiempo para el evento de networking.
- El evento de networking no puede comenzar antes de las 4:00 p.m. ni después de las 5:00 p.m.
- Ningún título de charla tiene números.
- La duración de todas las charlas está expresada en minutos (no en horas) o en relámpagos (5 minutos).
- No hay intervalos entre sesiones.

## Solución

El programa toma como entrada una lista de charlas con sus respectivas duraciones y planifica estas charlas en sesiones de mañana y tarde de acuerdo con las limitaciones de tiempo establecidas. Utiliza un algoritmo para asignar las charlas de manera eficiente, asegurándose de cumplir con las restricciones de tiempo.

## Instrucciones de Uso

1. Clona este repositorio en tu máquina local
2. Dentro de la carpeta src\conference\conferencemanager se encuentra la clase main para ejecutar el aplicativo
3. Ingrese las charlas en el formato "Título Duración". Ejemplo:
4. El programa organizará automáticamente las charlas en sesiones de mañana y tarde y generará el horario de la conferencia.
5. Revise el horario de la conferencia generado.

## Ejemplo de Entrada y Salida

**Entrada de Prueba:**
```
Writing Fast Tests Against Enterprise Rails 60
Overdoing it in Python 45
Lua for the Masses 30
Ruby Errors from Mismatched Gem Versions 45
Common Ruby Errors 45
Rails for Python Developers lightning
Communicating Over Distance 60
Accounting-Driven Development 45
Woah 30
Sit Down and Write 30
Pair Programming vs Noise 45
Rails Magic 60
Ruby on Rails: Why We Should Move On 60
Clojure Ate Scala (on my project) 45
Programming in the Boondocks of Seattle 30
Ruby vs. Clojure for Back-End Development 30
Ruby on Rails Legacy App Maintenance 60
A World Without HackerNews 30
User Interface CSS in Rails Apps 30
```

**Salida de Prueba:**
```
>>===== CONFERENCE =====<<
=========================================================

Track 1

09:00 a. m. Writing Fast Tests Against Enterprise Rails 60
10:00 a. m. Overdoing it in Python 45
10:45 a. m. Lua for the Masses 30
11:15 a. m. Ruby Errors from Mismatched Gem Versions 45
12:00 p. m. Lunch 60
01:00 p. m. Common Ruby Errors 45
01:45 p. m. Rails for Python Developers 5
01:50 p. m. Communicating Over Distance 60
02:50 p. m. Accounting-Driven Development 45
03:35 p. m. Woah 30
04:05 p. m. Sit Down and Write 30
05:00 p. m. Networking Event 0
=========================================================

Track 2

09:00 a. m. Pair Programming vs Noise 45
09:45 a. m. Rails Magic 60
10:45 a. m. Ruby on Rails: Why We Should Move On 60
12:00 p. m. Lunch 60
01:00 p. m. Clojure Ate Scala (on my project) 45
01:45 p. m. Programming in the Boondocks of Seattle 30
02:15 p. m. Ruby vs. Clojure for Back-End Development 30
02:45 p. m. Ruby on Rails Legacy App Maintenance 60
03:45 p. m. A World Without HackerNews 30
04:15 p. m. User Interface CSS in Rails Apps 30
05:00 p. m. Networking Event 0
=========================================================
```
## Ejecución

Adicional se creo un archivo jar (ConferenceApp.jar) que se peude ejecutar desde la terminal:

1. Abra una terminal.
2. Navegue hasta el directorio raíz del proyecto.
3. Ejecute el siguiente comando:

```bash
java -jar .\ConferenceApp.jar
```