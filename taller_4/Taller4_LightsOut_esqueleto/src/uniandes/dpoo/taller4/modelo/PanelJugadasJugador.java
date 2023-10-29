package uniandes.dpoo.taller4.modelo;



import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelJugadasJugador extends JPanel
{
    
    
    private JTextField txtjugadas;
    private JTextField txtnumjugadas;
    private JTextField txtjugador;
    private JTextField txtnomjugador;

    private VentanaPrincipal principal;
    
    public PanelJugadasJugador(VentanaPrincipal pPrincipal)
    {
        principal=pPrincipal;
        
        setLayout(new GridLayout( 1, 4 ));
        txtjugadas= new JTextField("Jugadas:");
        add(txtjugadas);
        
        txtnumjugadas= new JTextField("0");
        add(txtnumjugadas);
        txtjugador= new JTextField("Jugador:");
        add(txtjugador);
        txtnomjugador= new JTextField("Nombre");
        add(txtnomjugador);
        
        txtjugadas.setEditable(false);
        txtnumjugadas.setEditable(false);
        txtjugador.setEditable(false);
        txtnomjugador.setEditable(false);
    }

}