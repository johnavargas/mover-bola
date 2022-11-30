# mover-bola
Primer programa orientado a eventos.

Para compilar el cliente:
javac -sourcepath ./src/ -d ./out/ ./src/MainCliente.java 

Para compilar el servidor
javac -sourcepath ./src/ -d ./out/ ./src/model/Servidor.java

Para ejecutar el servidor:
cd out 

java model.Servidor &

Para ejecutar un cliente:
java MainCliente &
