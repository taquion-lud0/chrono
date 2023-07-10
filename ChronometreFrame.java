import javax.swing.*;
import java.awt.*;

public class ChronometreFrame extends JFrame {
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private JPanel panel;
    private JLabel timeLabel;

    public ChronometreFrame() {
        initComponents();
        this.setTitle("Chronometre");
        this.setLocationRelativeTo(null);
        this.setPreferredSize(new Dimension(300, 50));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Définition de la disposition des composants dans la fenêtre
        this.setLayout(new GridLayout(1, 2));
        
        // Ajout du label de temps et centrage du texte
        this.add(this.timeLabel);
        this.timeLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // Ajout du panneau contenant les boutons
        this.add(this.panel);
        
        // Configuration du layout du panneau
        this.panel.setLayout(new GridLayout(3, 1));
        
        // Ajout des boutons au panneau
        this.panel.add(this.startButton);
        this.panel.add(this.stopButton);
        this.panel.add(this.resetButton);

        ChronometreFrameListener listener = new ChronometreFrameListener(this);
        
        // Ajout des écouteurs d'événements aux boutons
        this.startButton.addActionListener(listener);
        this.stopButton.addActionListener(listener);
        this.resetButton.addActionListener(listener);

        this.pack();
        this.setVisible(true);
    }

    private void initComponents() {
        // Initialisation des composants
        this.panel = new JPanel();
        this.startButton = new JButton("Start");
        this.stopButton = new JButton("Stop");
        this.resetButton = new JButton("Reset");
        this.timeLabel = new JLabel("00:00:00");
    }

    public JButton getStartButton() {
        return this.startButton;
    }

    public JButton getStopButton() {
        return this.stopButton;
    }

    public JButton getResetButton() {
        return this.resetButton;
    }

    public void setTime(int time) {
        // Conversion du temps en heures, minutes et secondes
        int hours = time / 3600;
        int minutes = (time % 3600) / 60;
        int seconds = time % 60;
        
        // Mise à jour du texte du label avec le format hh:mm:ss
        this.timeLabel.setText(String.format("%02d:%02d:%02d", hours, minutes, seconds));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ChronometreFrame().setVisible(true);
            }
        });
    }
}
