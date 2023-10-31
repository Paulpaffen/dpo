package uniandes.dpoo.taller4.modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelJava2D extends JPanel implements MouseListener {
    private VentanaPrincipal principal;
    private Tablero tablero;
    private int tamano = 9;
    private boolean reiniciar = false;
    private int dificultad = 1;

    public PanelJava2D(VentanaPrincipal ventanaPrincipal) {
        principal = ventanaPrincipal;
        add(new JLabel("                                   "));
        addMouseListener(this);
        tablero = new Tablero(tamano); 
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        int anchoPanelTablero = getWidth() / 2;
        int altoPanelTablero = getHeight();
        double anchoCasilla = (anchoPanelTablero / tamano) * 2;
        double altoCasilla = (altoPanelTablero / tamano) * 1;
        double margen = 1;
        double x = ((getWidth() - anchoPanelTablero) / 2) * 0;
        double y = ((getHeight() - altoPanelTablero) / 2);
        if (tablero.darJugadas() == 0 && !reiniciar) {
            tablero.desordenar(dificultad);
            for (int i = 0; i < tamano; i++) {
                for (int j = 0; j < tamano; j++) {
                    Rectangle rect = new Rectangle((int) (x + i * anchoCasilla + margen),
                            (int) (y + j * altoCasilla + margen), (int) (anchoCasilla - 2 * margen),
                            (int) (altoCasilla - 2 * margen));
                    
                    if (tablero.darTablero()[i][j] == true) {
                        g2d.setColor(Color.YELLOW);
                    } else {
                        g2d.setColor(Color.BLACK);
                    }
                    g2d.fill(rect);
                    g2d.draw(rect);
                    tablero.salvar_tablero();
                }
            }
        } else {
            boolean[][] tablero_a = tablero.darTablero();
            for (int i = 0; i < tamano; i++) {
                for (int j = 0; j < tamano; j++) {
                    Rectangle rect = new Rectangle((int) (x + i * anchoCasilla + margen),
                            (int) (y + j * altoCasilla + margen), (int) (anchoCasilla - 2 * margen),
                            (int) (altoCasilla - 2 * margen));
                    if (tablero_a[i][j] == true) {
                        g2d.setColor(Color.YELLOW);
                    } else {
                        g2d.setColor(Color.BLACK);
                    }
                    g2d.fill(rect);
                    g2d.draw(rect);
                }
            }
        }
        if(tablero.tableroIluminado() == true){
            int puntaje = tablero.calcularPuntaje();
            JOptionPane.showMessageDialog(this, "Ganaste! tu puntaje es: " + puntaje);
            principal.setVisible(true);
            tablero.desordenar(dificultad);
            nuevoTablero();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int click_x = e.getX();
        int click_y = e.getY();
        int[] casilla = convertirCoordenadasACasilla(click_y, click_x);
        boolean[][] tablero_a = tablero.darTablero();
        tablero.jugar(casilla[0], casilla[1]);
        int jugadas = tablero.darJugadas(); 
        principal.jugadas(jugadas);
        repaint();
    }

    private int[] convertirCoordenadasACasilla(int x, int y) {
        boolean[][] tablero_a = tablero.darTablero();
        int ladoTablero = tablero_a.length;
        int altoPanelTablero = 600-126;
        int anchoPanelTablero = getWidth();
        double anchoCasilla = (anchoPanelTablero / ladoTablero);
        double altoCasilla = (altoPanelTablero / ladoTablero);
        int fila = (int)  Math.floor(y / altoCasilla);
        int columna = (int) Math.floor( x / anchoCasilla);
        return new int[] { fila, columna };
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // no se implementa
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // no se implementa

    }
    
    public void reiniciarTablero() {
        tablero.reiniciar();
        reiniciar = true;
        paint(getGraphics());
    }

    public void nuevoTablero() {
        reiniciarTablero();
        reiniciar = false;
        paint(getGraphics());
    }

    public void dificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public void tamano(int tamano) {
        this.tamano = tamano;
        tablero = new Tablero(tamano);
    }

}
