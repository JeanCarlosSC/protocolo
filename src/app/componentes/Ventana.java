package app.componentes;

import app.recursos.Resource;

import javax.swing.*;

import static app.recursos.Resource.lightGray;

public class Ventana extends JFrame {

    // componentes
    private JTextArea taSecuenciaDeTramas; // secuencia de tramas

    public Ventana() {
        initComponents();
        setProperties();
    }

    /**
     * Imprime un mensaje en la secuencia de tramas
     * @param message mensaje para imprimir en la secuencia de tramas
     */
    public void printMessageLine(String message) {
        taSecuenciaDeTramas.append(message+"\n");
    }

    /**
     * Crea la ventana principal
     */
    private void initComponents() {
        initSecuenciaDeTramasComponents();
    }

    private void setProperties() {
        getContentPane().setBackground(lightGray);
        setTitle("Protocolo de transmisión de datos");
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initSecuenciaDeTramasComponents() {
        JLabel lSecuenciaDeTramas = new JLabel("SECUENCIA DE TRAMAS:");
        lSecuenciaDeTramas.setFont(Resource.fontTitleMini);
        lSecuenciaDeTramas.setBounds(1010, 38, 200, 26);
        add(lSecuenciaDeTramas);

        JPanel container = new JPanel();
        container.setBounds(992, 78, 230, 568);
        container.setLayout(null);
        container.setBackground(Resource.WHITE);
        container.setBorder(Resource.grayBorder);
        add(container);

        taSecuenciaDeTramas = new JTextArea();
        taSecuenciaDeTramas.setEditable(false);
        taSecuenciaDeTramas.setLineWrap(true);

        JScrollPane scrollPane = new JScrollPane(taSecuenciaDeTramas);
        scrollPane.setBounds(16, 16, 230-32, 568-32);
        scrollPane.setBorder(null);
        container.add(scrollPane);
    }

}
