import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemeImpl extends javax.swing.JFrame implements SystemeIHM,ActionListener {

    private JButton [] boutons;
    String [] titreButton = {"nouvel employé en Manutention",
            "nouvel employé en Manutention a risque",
            "nouvel employé en Production",
            "nouvel employé en Production a risque",
            "nouvel employé Representant"};

    public SystemeImpl(){

        this.boutons = new JButton[5];
        JPanel panel = new JPanel();

        GridLayout gl = new GridLayout(5,1);

        gl.setHgap(5);
        gl.setVgap(5);

        panel.setLayout(gl);

        for (int i = 0; i < 5; i++){
            this.boutons[i] = new JButton(titreButton[i]);
            panel.add(this.boutons[i]);
        }

        this.addListener();

        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Ajout Employé");
        this.setResizable(false);

        this.setSize(300, 300);
        this.setLocation(50, 50);

        this.setVisible(true);

    }

    public void addListener()
    {
        for (int i = 0 ; i < 5 ; i++)
        {
                this.boutons[i].addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JButton btnSelect = (JButton) e.getSource();
        this.setTitle(btnSelect.getText());
        this.setContentPane(new nouveauEmploye().panel1);

    }




}
