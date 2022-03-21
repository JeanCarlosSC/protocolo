package app;

import app.modelo.Trama;

import javax.swing.*;

public class Receptor extends JPanel {
    // referencia
    private Sistema sistema;

    // componentes
    private JLabel lSemantica;
    private JTextField tfMensajeRecibido;
    private JTextField tfIndicadorInicial;
    private JTextField tfACK;
    private JTextField tfENQ;
    private JTextField tfCTR;
    private JTextField tfDAT;
    private JTextField tfPPT;
    private JTextField tfLPR;
    private JTextField tfNUM;
    private JTextField tfInformacion;
    private JTextField tfInformacion1;
    private JTextField tfIndicadorFinal;
    private JTextField tfHeader;
    private JTextField tfHeader1;
    private JTextField tfTrailer;

    // datos
    private boolean estaRecibiendo;

    public Receptor(Sistema sistema) {
        this.sistema = sistema;
        estaRecibiendo = false;

        setProperties();
        initLabels();
        initTextFields();

        JButton btResponder = new JButton("RESPONDER");
        btResponder.setBounds(794, 205, 105, 28);
        btResponder.addActionListener(e->responder());
        add(btResponder);
    }

    public void recibir(Trama trama) {
        // trama recibida
        tfHeader.setText(trama.getIndicadorInicial());
        tfHeader1.setText(trama.getAck()+trama.getEnq()+trama.getCtr()+trama.getDat()+trama.getPpt()+trama.getLpr()+trama.getNum());
        tfInformacion.setText(trama.getInformacion());
        tfTrailer.setText(trama.getIndicadorFinal());

        // procesar trama y calcular respuesta
        if(Sistema.obtenerSemantica(trama).equals("SEMÁNTICA: TRAMA DE CONTROL, PERMISO PARA TRANSMITIR")) {
            estaRecibiendo = true;
            trama.setLpr("1");
            trama.setPpt("0");
        }// solicita permiso para transmitir -> otorga permiso para recibir

        // mostrar respuesta
        updateGUI(trama);
    }

    private void responder() {
        Trama trama = new Trama(tfIndicadorInicial.getText(), tfACK.getText(), tfENQ.getText(), tfCTR.getText(), tfDAT.getText(),
                tfPPT.getText(), tfLPR.getText(), tfNUM.getText(), tfInformacion.getText(), tfIndicadorFinal.getText());
        if(Sistema.validarTrama(trama)) {
            sistema.enviar(trama, "Rx");
        }
        else {
            JOptionPane.showMessageDialog(null, "No se pudo enviar trama: trama inválida.", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void setProperties() {
        setBounds(32, 292, 920, 352);
        setLayout(null);
        setBorder(lib.sRAD_java.gui.component.Resource.grayBorder);
    }

    private void initLabels() {
        lSemantica = new JLabel("SEMÁNTICA: ESPERANDO UNA TRAMA");
        lSemantica.setFont(lib.sRAD_java.gui.component.Resource.fontText);
        lSemantica.setBounds(200, 233, 550, 30);
        add(lSemantica);

        JLabel lReceptor = new JLabel("RECEPTOR");
        lReceptor.setFont(lib.sRAD_java.gui.component.Resource.fontTitleMini);
        lReceptor.setBounds(46, 26, 100, 30);
        add(lReceptor);

        JLabel lTramaRecibida = new JLabel("TRAMA RECIBIDA");
        lTramaRecibida.setFont(lib.sRAD_java.gui.component.Resource.fontText);
        lTramaRecibida.setBounds(46, 60, 100, 30);
        add(lTramaRecibida);

        JLabel lHeader = new JLabel("HEADER");
        lHeader.setFont(lib.sRAD_java.gui.component.Resource.fontTextMini1);
        lHeader.setBounds(75, 86, 100, 30);
        add(lHeader);

        JLabel lInformacion = new JLabel("INFORMACIÓN");
        lInformacion.setFont(lib.sRAD_java.gui.component.Resource.fontTextMini1);
        lInformacion.setBounds(295, 86, 100, 30);
        add(lInformacion);

        JLabel lTrailer = new JLabel("TRAILER");
        lTrailer.setFont(lib.sRAD_java.gui.component.Resource.fontTextMini1);
        lTrailer.setBounds(457, 86, 100, 30);
        add(lTrailer);

        JLabel lRespuesta = new JLabel("RESPUESTA:");
        lRespuesta.setFont(lib.sRAD_java.gui.component.Resource.fontText);
        lRespuesta.setBounds(48, 151, 150, 30);
        add(lRespuesta);

        JLabel lIndicador = new JLabel("INDICADOR");
        lIndicador.setFont(lib.sRAD_java.gui.component.Resource.fontTextMini1);
        lIndicador.setBounds(65, 181, 100, 30);
        add(lIndicador);

        JLabel lACK = new JLabel("ACK");
        lACK.setFont(lib.sRAD_java.gui.component.Resource.fontTextMini1);
        lACK.setBounds(153, 181, 48, 30);
        add(lACK);

        JLabel lENQ = new JLabel("ENQ");
        lENQ.setFont(lib.sRAD_java.gui.component.Resource.fontTextMini1);
        lENQ.setBounds(203, 181, 50, 30);
        add(lENQ);

        JLabel lCTR = new JLabel("CTR");
        lCTR.setFont(lib.sRAD_java.gui.component.Resource.fontTextMini1);
        lCTR.setBounds(254, 181, 50, 30);
        add(lCTR);

        JLabel lDAT = new JLabel("DAT");
        lDAT.setFont(lib.sRAD_java.gui.component.Resource.fontTextMini1);
        lDAT.setBounds(304, 181, 50, 30);
        add(lDAT);

        JLabel lPPT = new JLabel("PPT");
        lPPT.setFont(lib.sRAD_java.gui.component.Resource.fontTextMini1);
        lPPT.setBounds(354, 181, 50, 30);
        add(lPPT);

        JLabel lLPT = new JLabel("LPT");
        lLPT.setFont(lib.sRAD_java.gui.component.Resource.fontTextMini1);
        lLPT.setBounds(404, 181, 50, 30);
        add(lLPT);

        JLabel lNUM = new JLabel("NUM");
        lNUM.setFont(lib.sRAD_java.gui.component.Resource.fontTextMini1);
        lNUM.setBounds(452, 181, 40, 30);
        add(lNUM);

        JLabel lInformacion1 = new JLabel("INFORMACIÓN");
        lInformacion1.setFont(lib.sRAD_java.gui.component.Resource.fontTextMini1);
        lInformacion1.setBounds(550, 181, 100, 30);
        add(lInformacion1);

        JLabel lIndicador1 = new JLabel("INDICADOR");
        lIndicador1.setFont(lib.sRAD_java.gui.component.Resource.fontTextMini1);
        lIndicador1.setBounds(713, 181, 100, 30);
        add(lIndicador1);

        JLabel lMensajeRecibido = new JLabel("MENSAJE RECIBIDO:");
        lMensajeRecibido.setFont(lib.sRAD_java.gui.component.Resource.fontText);
        lMensajeRecibido.setBounds(48, 263, 150, 30);
        add(lMensajeRecibido);
    }

    private void initTextFields() {
        tfHeader = new JTextField();
        tfHeader.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        tfHeader.setBounds(49, 110, 90, 28);
        tfHeader.setHorizontalAlignment(JTextField.CENTER);
        add(tfHeader);

        tfHeader1 = new JTextField();
        tfHeader1.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        tfHeader1.setBounds(141, 110, 90, 28);
        tfHeader1.setHorizontalAlignment(JTextField.CENTER);
        add(tfHeader1);

        tfInformacion = new JTextField();
        tfInformacion.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        tfInformacion.setBounds(233, 110, 200, 28);
        tfInformacion.setHorizontalAlignment(JTextField.CENTER);
        add(tfInformacion);

        tfTrailer = new JTextField();
        tfTrailer.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        tfTrailer.setBounds(435, 110, 90, 28);
        tfTrailer.setHorizontalAlignment(JTextField.CENTER);
        add(tfTrailer);

        tfIndicadorInicial = new JTextField();
        tfIndicadorInicial.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        tfIndicadorInicial.setBounds(49, 205, 90, 28);
        tfIndicadorInicial.setHorizontalAlignment(JTextField.CENTER);
        add(tfIndicadorInicial);

        tfACK = new JTextField();
        tfACK.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        tfACK.setBounds(140, 205, 48, 28);
        tfACK.setHorizontalAlignment(JTextField.CENTER);
        add(tfACK);

        tfENQ = new JTextField();
        tfENQ.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        tfENQ.setBounds(190, 205, 48, 28);
        tfENQ.setHorizontalAlignment(JTextField.CENTER);
        add(tfENQ);

        tfCTR = new JTextField();
        tfCTR.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        tfCTR.setBounds(240, 205, 48, 28);
        tfCTR.setHorizontalAlignment(JTextField.CENTER);
        add(tfCTR);

        tfDAT = new JTextField();
        tfDAT.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        tfDAT.setBounds(290, 205, 48, 28);
        tfDAT.setHorizontalAlignment(JTextField.CENTER);
        add(tfDAT);

        tfPPT = new JTextField();
        tfPPT.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        tfPPT.setBounds(340, 205, 48, 28);
        tfPPT.setHorizontalAlignment(JTextField.CENTER);
        add(tfPPT);

        tfLPR = new JTextField();
        tfLPR.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        tfLPR.setBounds(390, 205, 48, 28);
        tfLPR.setHorizontalAlignment(JTextField.CENTER);
        add(tfLPR);

        tfNUM = new JTextField();
        tfNUM.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        tfNUM.setBounds(440, 205, 48, 28);
        tfNUM.setHorizontalAlignment(JTextField.CENTER);
        add(tfNUM);

        tfInformacion1 = new JTextField();
        tfInformacion1.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        tfInformacion1.setBounds(490, 205, 200, 28);
        tfInformacion1.setHorizontalAlignment(JTextField.CENTER);
        add(tfInformacion1);

        tfIndicadorFinal = new JTextField();
        tfIndicadorFinal.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        tfIndicadorFinal.setBounds(692, 205, 100, 28);
        tfIndicadorFinal.setHorizontalAlignment(JTextField.CENTER);
        add(tfIndicadorFinal);

        tfMensajeRecibido = new JTextField();
        tfMensajeRecibido.setBounds(200, 263, 500, 28);
        tfMensajeRecibido.setFont(lib.sRAD_java.gui.component.Resource.fontTextBold);
        add(tfMensajeRecibido);
    }

    private void updateGUI(Trama trama) {
        // text fields
        tfIndicadorInicial.setText(trama.getIndicadorInicial());
        tfACK.setText(trama.getAck());
        tfENQ.setText(trama.getEnq());
        tfCTR.setText(trama.getCtr());
        tfDAT.setText(trama.getDat());
        tfPPT.setText(trama.getPpt());
        tfLPR.setText(trama.getLpr());
        tfNUM.setText(trama.getNum());
        tfInformacion1.setText(trama.getInformacion());
        tfIndicadorFinal.setText(trama.getIndicadorFinal());
        tfMensajeRecibido.setText(tfMensajeRecibido.getText()+" "+trama.getInformacion());

        // semántica
        lSemantica.setText(Sistema.obtenerSemantica(trama)+", TRAMA RECIBIDA CON ÉXITO");
    }
}
