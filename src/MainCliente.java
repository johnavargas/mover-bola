import controller.Controlador;
import model.Cliente;
import view.VentanaPrincipal;

public class MainCliente {
    public static void main(String[] args)
    {
        // Vista
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);

        // Controlador
        Controlador controlador = new Controlador(ventana);
        ventana.lienzo.addKeyListener(controlador);

        Cliente c = new Cliente();
        controlador.despachador = c.conectar(ventana, ventana.lienzo);

        if (controlador.despachador != null) {
            controlador.conectar();
        }
    }
}
