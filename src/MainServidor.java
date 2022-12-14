import model.Servidor;

public class MainServidor
{
    public static void main(String[] args) {
        try {
            Servidor servidor = new Servidor(1234, 6);
            servidor.conectar();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
