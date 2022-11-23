# mover-bola
Primer programa orientado a eventos.

Para compilar el cliente:
javac -sourcepath ./src/ -d ./out/ ./src/Main.java 

Para compilar el servidor
javac -sourcepath ./src/ -d ./out/ ./src/net/Servidor.java

Para ejecutar el servidor:
cd out
java net.Servidor &

Para ejecutar un cliente:
java Main &
