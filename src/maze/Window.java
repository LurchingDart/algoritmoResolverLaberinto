package maze;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author NoeAV
 */
public class Window extends JFrame {
    // Definimos el constructor de la clase que llama al método initUI para
    // inicializar la ventana
    public Window() {
        initUI();
    }

    // Método que inicializa la ventana
    private void initUI() {
        // Creamos un contenedor de tipo JPanel
        JPanel Container = new JPanel();
        // Y le asignamos un layout de tipo BorderLayout
        Container.setLayout(new BorderLayout());
        // Agregamos el contenedor a la ventana
        add(Container);
        // Definimos el tamaño de la ventana
        setSize(420, 500);
        // Definimos el tamaño del contenedor
        Container.setSize(420, 500);
        // Creamos un objeto de tipo Board
        Board board = new Board();
        // Agregamos el objeto board al contenedor
        Container.add(board, BorderLayout.CENTER);
        // Creamos un boton
        JButton button = new JButton("Solve");
        // Agregamos un listener al boton
        button.addActionListener((ActionEvent e) -> {
            // Al hacer click en el botón se llama al método solve de la clase Board
            board.solve();
            // Y se repinta el contenedor
            this.repaint();
        });
        // Se agrega el botón al contenedor
        Container.add(button, BorderLayout.NORTH);
        // Se define el título de la ventana
        setTitle("Laberinto");
        // Se define el comportamiento de la ventana al cerrarse
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Se centra la ventana en la pantalla
        setLocationRelativeTo(null);
    }
}
