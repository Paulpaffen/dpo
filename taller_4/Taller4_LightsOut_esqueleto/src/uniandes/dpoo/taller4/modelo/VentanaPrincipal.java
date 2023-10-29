package uniandes.dpoo.taller4.modelo;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import java.awt.Color;


public class VentanaPrincipal extends JFrame {
    private PanelJugadasJugador panelSur;
    private PanelJava2D panelEste;
    private PanelAjustesJuego panelNorte;
    private PanelOpcionesJuego panelOeste;
    

    public VentanaPrincipal() {
        super("LightsOut"); 
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        panelSur = new PanelJugadasJugador(this);
        add(panelSur, BorderLayout.SOUTH);

        panelNorte = new PanelAjustesJuego(this);
        add(panelNorte, BorderLayout.NORTH);

        panelOeste = new PanelOpcionesJuego(this);
        add(panelOeste, BorderLayout.WEST);

        // Create a nested BorderLayout for the center section
        JPanel centerPanel = new JPanel(new BorderLayout());
        panelEste = new PanelJava2D(this);
        centerPanel.add(panelEste, BorderLayout.CENTER);
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
    }
}
