package principal;

import controlador.Controlador;
import modelo.Cliente;
import modelo.ModeloClientes;
import vista.FormVentas;

/**
 *
 * @author osval
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FormVentas fv = new FormVentas();
        ModeloClientes mc = new ModeloClientes();
        Cliente cli = new Cliente();
        
        Controlador c = new Controlador(fv, mc, cli);
        c.iniciar();
    }
    
}
