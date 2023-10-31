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

    String jugador = "DEF";
    int jugadas = 0;
    
    public PanelJugadasJugador(VentanaPrincipal pPrincipal)
    {
        
        principal=pPrincipal;
        
        setLayout(new GridLayout( 1, 4 ));
        txtjugadas= new JTextField("Jugadas:");
        add(txtjugadas);
        
        txtnumjugadas= new JTextField(jugadas+"");
        add(txtnumjugadas);
        txtjugador= new JTextField("Jugador:");
        add(txtjugador);
        txtnomjugador= new JTextField(jugador);
        add(txtnomjugador);
        
        txtjugadas.setEditable(false);
        txtnumjugadas.setEditable(false);
        txtjugador.setEditable(false);
        txtnomjugador.setEditable(false);
    }

    public void jugador(String jugador)
    {
        this.jugador = jugador;
        this.txtnomjugador.setText(jugador);
    }

    public void jugadas(int jugadas)
    {
        this.jugadas = jugadas;
        this.txtnumjugadas.setText(jugadas+"");
    }

}