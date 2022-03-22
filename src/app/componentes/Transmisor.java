package app.componentes;

import app.modelo.Trama;
import app.recursos.Resource;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Transmisor extends JPanel {
    // referencia de la ventana principal
    private final Sistema sistema;

    // componentes
    private JLabel lSemantica;
    private JTextField tfMensaje;
    private JTextField tfNoFrames;
    private JTextField tfIndicadorInicial;
    private JTextField tfACK;
    private JTextField tfENQ;
    private JTextField tfCTR;
    private JTextField tfDAT;
    private JTextField tfPPT;
    private JTextField tfLPR;
    private JTextField tfNUM;
    private JTextField tfInformacion;
    private JTextField tfIndicadorFinal;
    private JCheckBox cbPPT;
    private JCheckBox cbCTR;
    private JCheckBox cbENQ;
    private JCheckBox cbDAT;
    private final JButton btEnviar;

    public Transmisor(Sistema sistema) {
        this.sistema = sistema;

        setProperties();
        initLabels();
        initTextFields();
        initCheckBoxes();

        btEnviar = new JButton("ENVIAR");
        btEnviar.setBounds(794, 110, 100, 28);
        btEnviar.addActionListener(e->enviar());
        add(btEnviar);

        updateSemantica();
    }

    public void inhabilitar() {
        btEnviar.setEnabled(false);
    }

    private void updateSemantica() {
        Trama trama = new Trama(tfIndicadorInicial.getText(), tfACK.getText(), tfENQ.getText(), tfCTR.getText(), tfDAT.getText(),
                tfPPT.getText(), tfLPR.getText(), tfNUM.getText(), tfInformacion.getText(), tfIndicadorFinal.getText());
        lSemantica.setText(Sistema.obtenerSemantica(trama));
    }

    private void enviar() {
        Trama trama = new Trama(tfIndicadorInicial.getText(), tfACK.getText(), tfENQ.getText(), tfCTR.getText(), tfDAT.getText(),
                tfPPT.getText(), tfLPR.getText(), tfNUM.getText(), tfInformacion.getText(), tfIndicadorFinal.getText());
        if(Sistema.validarTrama(trama, "Tx")) {
            sistema.enviar(trama, "Tx");
        }
        else {
            JOptionPane.showMessageDialog(null, "No se pudo enviar trama: trama inválida. Por favor verifique" +
                            " cada dato introducido, incluyendo el número de la trama.", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setProperties() {
        setBounds(32, 32, 920, 230);
        setLayout(null);
        setBorder(Resource.grayBorder);
    }

    private void initLabels() {
        lSemantica = new JLabel();
        lSemantica.setFont(Resource.fontText);
        lSemantica.setBounds(200, 165, 500, 30);
        add(lSemantica);

        JLabel lTransmisor = new JLabel("TRANSMISOR");
        lTransmisor.setFont(Resource.fontTitleMini);
        lTransmisor.setBounds(46, 26, 100, 30);
        add(lTransmisor);

        JLabel lTransmitir = new JLabel("MENSAJE A TRANSMITIR:");
        lTransmitir.setFont(Resource.fontText);
        lTransmitir.setBounds(48, 56, 150, 30);
        add(lTransmitir);

        JLabel lNoFrames = new JLabel("Frames:");
        lNoFrames.setFont(Resource.fontText);
        lNoFrames.setBounds(710, 56, 50, 30);
        add(lNoFrames);

        JLabel lIndicador = new JLabel("INDICADOR");
        lIndicador.setFont(Resource.fontTextMini1);
        lIndicador.setBounds(65, 86, 100, 30);
        add(lIndicador);

        JLabel lACK = new JLabel("ACK");
        lACK.setFont(Resource.fontTextMini1);
        lACK.setBounds(153, 86, 48, 30);
        add(lACK);

        JLabel lCTR = new JLabel("CTR");
        lCTR.setFont(Resource.fontTextMini1);
        lCTR.setBounds(254, 86, 50, 30);
        add(lCTR);

        JLabel lDAT = new JLabel("DAT");
        lDAT.setFont(Resource.fontTextMini1);
        lDAT.setBounds(304, 86, 50, 30);
        add(lDAT);

        JLabel lPPT = new JLabel("PPT");
        lPPT.setFont(Resource.fontTextMini1);
        lPPT.setBounds(354, 86, 50, 30);
        add(lPPT);

        JLabel lLPR = new JLabel("LPR");
        lLPR.setFont(Resource.fontTextMini1);
        lLPR.setBounds(404, 86, 50, 30);
        add(lLPR);

        JLabel lENQ = new JLabel("ENQ");
        lENQ.setFont(Resource.fontTextMini1);
        lENQ.setBounds(203, 86, 50, 30);
        add(lENQ);

        JLabel lNUM = new JLabel("NUM");
        lNUM.setFont(Resource.fontTextMini1);
        lNUM.setBounds(452, 86, 40, 30);
        add(lNUM);

        JLabel lInformacion = new JLabel("INFORMACIÓN");
        lInformacion.setFont(Resource.fontTextMini1);
        lInformacion.setBounds(555, 86, 100, 30);
        add(lInformacion);

        JLabel lIndicador1 = new JLabel("INDICADOR");
        lIndicador1.setFont(Resource.fontTextMini1);
        lIndicador1.setBounds(713, 86, 100, 30);
        add(lIndicador1);
    }

    private void initTextFields() {
        tfIndicadorInicial = new JTextField("10000001");
        tfIndicadorInicial.setFont(Resource.fontTextBold);
        tfIndicadorInicial.setBounds(49, 110, 90, 28);
        tfIndicadorInicial.setHorizontalAlignment(JTextField.CENTER);
        add(tfIndicadorInicial);

        tfACK = new JTextField("0");
        tfACK.setFont(Resource.fontTextBold);
        tfACK.setBounds(140, 110, 48, 28);
        tfACK.setHorizontalAlignment(JTextField.CENTER);
        tfACK.setEditable(false);
        add(tfACK);

        tfENQ = new JTextField("0");
        tfENQ.setFont(Resource.fontTextBold);
        tfENQ.setBounds(190, 110, 48, 28);
        tfENQ.setHorizontalAlignment(JTextField.CENTER);
        tfENQ.setEditable(false);
        add(tfENQ);

        tfCTR = new JTextField("0");
        tfCTR.setFont(Resource.fontTextBold);
        tfCTR.setBounds(240, 110, 48, 28);
        tfCTR.setHorizontalAlignment(JTextField.CENTER);
        tfCTR.setEditable(false);
        add(tfCTR);

        tfDAT = new JTextField("0");
        tfDAT.setFont(Resource.fontTextBold);
        tfDAT.setBounds(290, 110, 48, 28);
        tfDAT.setHorizontalAlignment(JTextField.CENTER);
        tfDAT.setEditable(false);
        add(tfDAT);

        tfPPT = new JTextField("0");
        tfPPT.setFont(Resource.fontTextBold);
        tfPPT.setBounds(340, 110, 48, 28);
        tfPPT.setHorizontalAlignment(JTextField.CENTER);
        tfPPT.setEditable(false);
        add(tfPPT);

        tfLPR = new JTextField("0");
        tfLPR.setFont(Resource.fontTextBold);
        tfLPR.setBounds(390, 110, 48, 28);
        tfLPR.setHorizontalAlignment(JTextField.CENTER);
        tfLPR.setEditable(false);
        add(tfLPR);

        tfNUM = new JTextField("0");
        tfNUM.setFont(Resource.fontTextBold);
        tfNUM.setBounds(440, 110, 48, 28);
        tfNUM.setHorizontalAlignment(JTextField.CENTER);
        tfNUM.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                updateSemantica();
            }
            public void removeUpdate(DocumentEvent e) {
                updateSemantica();
            }
            public void insertUpdate(DocumentEvent e) {
                updateSemantica();
            }
        });
        add(tfNUM);

        tfInformacion = new JTextField();
        tfInformacion.setFont(Resource.fontTextBold);
        tfInformacion.setBounds(490, 110, 200, 28);
        tfInformacion.setHorizontalAlignment(JTextField.CENTER);
        add(tfInformacion);

        tfIndicadorFinal = new JTextField("10000001");
        tfIndicadorFinal.setFont(Resource.fontTextBold);
        tfIndicadorFinal.setBounds(692, 110, 100, 28);
        tfIndicadorFinal.setHorizontalAlignment(JTextField.CENTER);
        add(tfIndicadorFinal);

        tfMensaje = new JTextField();
        tfMensaje.setFont(Resource.fontTextBold);
        tfMensaje.setBounds(200, 56, 500, 28);
        add(tfMensaje);

        tfNoFrames = new JTextField();
        tfNoFrames.setFont(Resource.fontTextBold);
        tfNoFrames.setBounds(762, 56, 28, 28);
        tfNoFrames.setHorizontalAlignment(JTextField.CENTER);
        add(tfNoFrames);
    }

    private void initCheckBoxes() {
        JCheckBox cbACK = new JCheckBox();
        cbACK.setBounds(153, 140, 20, 20);
        cbACK.addActionListener(e->{
            tfACK.setText(cbACK.isSelected()?"1":"0");
            updateSemantica();
        });
        add(cbACK);

        cbENQ = new JCheckBox();
        cbENQ.setBounds(203, 140, 20, 20);
        cbENQ.addActionListener(e->{
            tfENQ.setText(cbENQ.isSelected()?"1":"0");
            updateSemantica();
        });
        add(cbENQ);

        cbCTR = new JCheckBox();
        cbCTR.setBounds(253, 140, 20, 20);
        cbCTR.addActionListener(e->{
            tfCTR.setText(cbCTR.isSelected()?"1":"0");
            updateSemantica();
        });
        add(cbCTR);

        cbDAT = new JCheckBox();
        cbDAT.setBounds(303, 140, 20, 20);
        cbDAT.addActionListener(e-> {
            tfDAT.setText(cbDAT.isSelected() ? "1" : "0");
            updateSemantica();
        });
        add(cbDAT);

        cbPPT = new JCheckBox();
        cbPPT.setBounds(353, 140, 20, 20);
        cbPPT.addActionListener(e-> {
            tfPPT.setText(cbPPT.isSelected() ? "1" : "0");
            updateSemantica();
        });
        add(cbPPT);

        JCheckBox cbLPT = new JCheckBox();
        cbLPT.setBounds(403, 140, 20, 20);
        cbLPT.addActionListener(e-> {
            tfLPR.setText(cbLPT.isSelected() ? "1" : "0");
            updateSemantica();
        });
        add(cbLPT);
    }

    public int getNoFrames() {
        return Integer.parseInt(tfNoFrames.getText());
    }

    public String getMensajeATransmitir() {
        return tfMensaje.getText();
    }

    public void establecerProximaTrama(Trama trama) {
        int posicion = Integer.parseInt(trama.getNum());

        // first trama
        if (cbPPT.isSelected()) {
            cbPPT.setSelected(false);
            tfPPT.setText("0");
            cbCTR.setSelected(false);
            tfCTR.setText("0");
            cbDAT.setSelected(true);
            tfDAT.setText("1");
        }

        // last trama
        if(posicion-1 == sistema.getLastPosicion()) {
            cbENQ.setSelected(true);
            tfENQ.setText("1");
        }

        // cualquier trama
        if(posicion-1 <= sistema.getLastPosicion()) {
            tfNUM.setText(posicion+"");
            tfInformacion.setText(sistema.getFrameAt(posicion-1));
        }

    }
}
