import controller.Controlador;
import view.VentanaPrincipal;

/**
 * clase ejecutable para el cliente.
 * Muestra una interface grafica de usuario
 */
public class MainCliente {
    public static void main(String[] args)
    {
        // Vista
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);

        // Controlador
        Controlador controlador = new Controlador(ventana);
        ventana.getLienzo().addKeyListener(controlador);

        controlador.conectar();
    }
}
