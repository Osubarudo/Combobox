package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ModeloClientes;
import vista.FormVentas;

/**
 *
 * @author osval
 */
public class Controlador implements ActionListener {

    private FormVentas vista;
    private ModeloClientes modCli;
    private Cliente cli;

    public Controlador(FormVentas vista, ModeloClientes modCli, Cliente cli) {
        this.vista = vista;
        this.modCli = modCli;
        this.cli = cli;

        this.vista.btnMostrar.addActionListener(this);
    }

    public void iniciar() {
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        llenarClientes();
        vista.cbxClientes.setSelectedIndex(-1);
        vista.cbxClientes.setToolTipText("Selecciona un Cliente");

    }

    public void llenarClientes() {
        ModeloClientes modClientes = new ModeloClientes();
        ArrayList<Cliente> listaClientes = modClientes.getClientes();
        //vista.cbxClientes.removeAllItems();

        for (int i = 0; i < listaClientes.size(); i++) {
            vista.cbxClientes.addItem(new Cliente(listaClientes.get(i).getId(), listaClientes.get(i).getClave(), listaClientes.get(i).getNombre()));

        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

//         int id = vista.cbxClientes.getItemAt(vista.cbxClientes.getSelectedIndex()).getId();
//         cli.setId(id);
//                JOptionPane.showMessageDialog(null, id);
//                 JOptionPane.showMessageDialog(null, cli.getId());
        if (vista.btnMostrar == ae.getSource()) {
//            try {
//                cli.setId(vista.cbxClientes.getItemAt(vista.cbxClientes.getSelectedIndex()).getId());
//
//            } catch (NullPointerException ex) {
//
//            }

            if (vista.cbxClientes.getSelectedIndex() == -1) {
                //JOptionPane.showMessageDialog(null, "Mal, debes seleccionar algo");
                cli.setId(0);
            } else {
                cli.setId(vista.cbxClientes.getItemAt(vista.cbxClientes.getSelectedIndex()).getId());
                  JOptionPane.showMessageDialog(null, cli.getId());
            }
            
            if(cli.validar()){
                JOptionPane.showMessageDialog(null, "Bien");
            }else{
                JOptionPane.showMessageDialog(null, "Mal");
            }

        }

    }

//    public boolean validarCombobox() {
//        boolean ok = true;
//        if (vista.cbxClientes.getSelectedIndex() == -1) {
//        }
//        return ok;
//    }

}
