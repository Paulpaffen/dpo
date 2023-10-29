package uniandes.dpoo.taller4.modelo;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.Color;

public class PanelOpcionesJuego extends JPanel {
    private VentanaPrincipal principal;
    private JButton btnnuevo;
    private JButton btnreiniciar;
    private JButton btntop10;
    private JButton btnCamJugador;
    
    public PanelOpcionesJuego(VentanaPrincipal pPrincipal)
    {
        principal=pPrincipal;
        btnnuevo = new JButton("Nuevo");
        btnnuevo.setBackground(new Color(27, 62, 228));
        btnnuevo.setForeground(Color.WHITE);
        btnreiniciar = new JButton("Reiniciar");
        btnreiniciar.setBackground(new Color(27, 62, 228));
        btnreiniciar.setForeground(Color.WHITE);
        btntop10 = new JButton("Top-10");
        btntop10.setBackground(new Color(27, 62, 228));
        btntop10.setForeground(Color.WHITE);
        btnCamJugador = new JButton("Cambiar jugador");
        btnCamJugador.setBackground(new Color(27, 62, 228));
        btnCamJugador.setForeground(Color.WHITE);
        
        btnnuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Nuevo");
            }
        });
        
        btnreiniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Reiniciar");
            }
        });
        
        btntop10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Top-10");
            }
        });
        
        btnCamJugador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cambiar jugador");
            }
        });
        
        this.setLayout(new GridLayout(4, 1)); 
        
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 0, 10)); 
        buttonPanel.add(btnnuevo);
        buttonPanel.add(btnreiniciar);
        buttonPanel.add(btntop10);
        buttonPanel.add(btnCamJugador);
        
        this.add(new JLabel()); 
        this.add(buttonPanel); 
        this.add(new JLabel());
    }
}
