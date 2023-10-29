package uniandes.dpoo.taller4.modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelJava2D extends JPanel implements MouseListener {
    private VentanaPrincipal principal;
    private Tablero tablero;
    private int tamano;

    public PanelJava2D(VentanaPrincipal ventanaPrincipal) {
        principal = ventanaPrincipal;
        add(new JLabel("                                   "));
        addMouseListener(this);
        tamano = 5;
        tablero = new Tablero(tamano); 
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int dificultad = 1;
        int anchoPanelTablero = getWidth() / 2;
        int altoPanelTablero = getHeight();
        double anchoCasilla = (anchoPanelTablero / tamano) * 1.8;
        double altoCasilla = (altoPanelTablero / tamano) * 1;
        double margen = 1;
        double x = ((getWidth() - anchoPanelTablero) / 2) * 0.3;
        double y = ((getHeight() - altoPanelTablero) / 2);
        if (tablero.darJugadas() == 0) {
            for (int i = 0; i < tamano; i++) {
                for (int j = 0; j < tamano; j++) {
                    Rectangle rect = new Rectangle((int) (x + i * anchoCasilla + margen),
                            (int) (y + j * altoCasilla + margen), (int) (anchoCasilla - 2 * margen),
                            (int) (altoCasilla - 2 * margen));
                    tablero.desordenar(dificultad);
                    if (tablero.darTablero()[i][j] == true) {
                        g2d.setColor(Color.BLACK);
                    } else {
                        g2d.setColor(Color.YELLOW);
                    }
                    g2d.fill(rect);
                    g2d.draw(rect);
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
                        g2d.setColor(Color.BLACK);
                    } else {
                        g2d.setColor(Color.YELLOW);
                    }
                    g2d.fill(rect);
                    g2d.draw(rect);
                }
            }
        }
        tablero.salvar_tablero();
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
        repaint();
    }

    private int[] convertirCoordenadasACasilla(int x, int y) {
        boolean[][] tablero_a = tablero.darTablero();
        int ladoTablero = tablero_a.length;
        int altoPanelTablero = getHeight();
        int anchoPanelTablero = getWidth();
        int altoCasilla = altoPanelTablero / ladoTablero;
        int anchoCasilla = anchoPanelTablero / ladoTablero;
        int fila = (int) (y / altoCasilla);
        int columna = (int) (x / anchoCasilla);
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

}
