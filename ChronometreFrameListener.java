import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ChronometreFrameListener implements ActionListener {
    private final ChronometreFrame chronometreFrame;
    private int time;
    private Timer timer;
    private final int SPEED = 1000;         // Vitesse de mise à jour du chronomètre (1 seconde = 1000 millisecondes)
    private final int INITIALDELAY = 100;   // Délai initial avant le démarrage du chronomètre (100 millisecondes)

    public ChronometreFrameListener(ChronometreFrame chronometreFrame) {
        this.chronometreFrame = chronometreFrame;
        this.time = 0;
        this.timer = new Timer(SPEED, this);     // Création du timer avec la vitesse de mise à jour et l'actionListener
        this.timer.setInitialDelay(INITIALDELAY); // Configuration du délai initial
        this.timer.start();                       // Démarrage du timer
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chronometreFrame.getStartButton()) {    // Si l'événement provient du bouton de démarrage
            timer.start();                                                  // Démarrer le chronomètre (reprendre la mise à jour)
        } else if (e.getSource() == chronometreFrame.getStopButton()) {  // Si l'événement provient du bouton d'arrêt
            timer.stop();                                                   // Arrêter le chronomètre (arrêter la mise à jour)
        } else if (e.getSource() == chronometreFrame.getResetButton()) {    // Si l'événement provient du bouton de réinitialisation
            time = 0;                                                  // Réinitialiser la variable de temps
            chronometreFrame.setTime(time);                                 // Mettre à jour l'affichage du temps avec la valeur réinitialisée
            timer.stop();                                                   // Arrêter le chronomètre (arrêter la mise à jour)
        } else if (e.getSource() == timer) {                            // Si l'événement provient du timer (mise à jour régulière)
            time++;                                                         // Augmenter la valeur du temps
            chronometreFrame.setTime(time);                                 // Mettre à jour l'affichage du temps avec la nouvelle valeur
        }
    }
}
