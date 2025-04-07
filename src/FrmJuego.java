import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class FrmJuego extends JFrame {

    private JButton btnRepartir;
    private JButton btnVerificar;
    private JButton btnVerificadorDeEscalera;
    private JButton btnPuntajeJugador;
    private JPanel pnlJugador1;
    private JPanel pnlJugador2;
    private JTabbedPane tpJugadores;

    public FrmJuego() {
        btnRepartir = new JButton();
        btnVerificar = new JButton();
        btnVerificadorDeEscalera = new JButton();
        btnPuntajeJugador = new JButton();
        tpJugadores = new JTabbedPane();
        pnlJugador1 = new JPanel();
        pnlJugador2 = new JPanel();

        setSize(600, 300);
        setTitle("Juego de Cartas");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        pnlJugador1.setBackground(new Color(13, 25, 51));
        pnlJugador1.setLayout(null);
        pnlJugador2.setBackground(new Color(86, 8, 10));
        pnlJugador2.setLayout(null);

        tpJugadores.setBounds(10, 40, 550, 170);
        tpJugadores.addTab("Martín Estrada Contreras", pnlJugador1);
        tpJugadores.addTab("Raul Vidal", pnlJugador2);

        btnRepartir.setBounds(10, 10, 100, 25);
        btnRepartir.setText("Repartir");
        btnRepartir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnRepartirClick(evt);
            }
        });

        btnVerificar.setBounds(120, 10, 100, 25);
        btnVerificar.setText("Verificar");
        btnVerificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnVerificarClick(evt);
            }
        });
        
        btnVerificadorDeEscalera.setBounds(360, 10, 100, 25);
        btnVerificadorDeEscalera.setText("¿Escalera?");
        btnVerificadorDeEscalera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt2) {
                btnVerificarEscaleraClick(evt2);
            }
        });

        btnPuntajeJugador.setBounds(470, 10, 100, 25);
        btnPuntajeJugador.setText("Puntaje");
        btnPuntajeJugador.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt3) {
                btnPuntajeClick(evt3);
            }
        });

        getContentPane().setLayout(null);
        getContentPane().add(tpJugadores);
        getContentPane().add(btnRepartir);
        getContentPane().add(btnVerificar);
        getContentPane().add(btnVerificadorDeEscalera);
        getContentPane().add(btnPuntajeJugador);
    }

    Jugador jugador1 = new Jugador();
    Jugador jugador2 = new Jugador();

    private void btnRepartirClick(ActionEvent evt) {
        jugador1.repartir();
        jugador1.mostrar(pnlJugador1);

        jugador2.repartir();
        jugador2.mostrar(pnlJugador2);
    }

    private void btnVerificarClick(ActionEvent evt) {
        switch (tpJugadores.getSelectedIndex()) {
            case 0:
                JOptionPane.showMessageDialog(null, jugador1.getGrupos());
                break;
            case 1:
                JOptionPane.showMessageDialog(null, jugador2.getGrupos());
                break;
        }
    }
    private void btnVerificarEscaleraClick(ActionEvent evt2) {
        switch (tpJugadores.getSelectedIndex()) {
            case 0:
                JOptionPane.showMessageDialog(null, jugador1.getEscaleras());
                break;
            case 1:
                JOptionPane.showMessageDialog(null, jugador2.getEscaleras());
                break;
        }
    }

    private void btnPuntajeClick(ActionEvent evt3) {
        switch (tpJugadores.getSelectedIndex()) {
            case 0:
                JOptionPane.showMessageDialog(null, jugador1.Puntaje());
                break;
            case 1:
                JOptionPane.showMessageDialog(null, jugador2.Puntaje());
                break;
        }
    }
}