package vista;

import lib.sRAD_java.gui.component.Resource;
import modelo.Trama;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    // colors
    private final Color bgColor = new Color(248, 248, 248);

    // transmisor components
    private PTransmisor pTransmisor;

    // receptor components
    private JTextField tfMensajeRecibido;
    private JTextField tfIndicadorReceptor;
    private JTextField tfACKReceptor;
    private JTextField tfENQReceptor;
    private JTextField tfCTRReceptor;
    private JTextField tfDATReceptor;
    private JTextField tfPPTReceptor;
    private JTextField tfLPTReceptor;
    private JTextField tfNUMReceptor;
    private JTextField tfInformacionReceptor;
    private JTextField tfInformacion1Receptor;
    private JTextField tfIndicador1Receptor;
    private JTextField tfHeader;
    private JTextField tfHeader1;
    private JTextField tfTrailer;

    // secuencia de tramas
    private JTextArea taSecuenciaDeTramas;

    public View() {
        initComponents();
        setProperties();
    }

    /**
     * Crea la ventana principal
     */
    public void initComponents() {
        pTransmisor = new PTransmisor(this);
        add(pTransmisor);

        initReceptorComponents();
        initSecuenciaDeTramasComponents();
    }

    private void setProperties() {
        getContentPane().setBackground(bgColor);
        setTitle("Protocolo de transmisión de datos");
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280, 720);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initReceptorComponents() {
        JPanel container = new JPanel();
        container.setBounds(32, 292, 920, 352);
        container.setLayout(null);
        container.setBorder(Resource.grayBorder);
        add(container);

        JLabel lReceptor = new JLabel("RECEPTOR");
        lReceptor.setFont(Resource.fontTitleMini);
        lReceptor.setBounds(46, 26, 100, 30);
        container.add(lReceptor);

        JLabel lTramaRecibida = new JLabel("TRAMA RECIBIDA");
        lTramaRecibida.setFont(Resource.fontText);
        lTramaRecibida.setBounds(46, 60, 100, 30);
        container.add(lTramaRecibida);

        JLabel lHeader = new JLabel("HEADER");
        lHeader.setFont(Resource.fontTextMini1);
        lHeader.setBounds(75, 86, 100, 30);
        container.add(lHeader);

        tfHeader = new JTextField();
        tfHeader.setFont(Resource.fontTextBold);
        tfHeader.setBounds(49, 110, 90, 28);
        tfHeader.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfHeader);

        tfHeader1 = new JTextField();
        tfHeader1.setFont(Resource.fontTextBold);
        tfHeader1.setBounds(141, 110, 90, 28);
        tfHeader1.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfHeader1);

        JLabel lInformacion = new JLabel("INFORMACIÓN");
        lInformacion.setFont(Resource.fontTextMini1);
        lInformacion.setBounds(295, 86, 100, 30);
        container.add(lInformacion);

        tfInformacionReceptor = new JTextField();
        tfInformacionReceptor.setFont(Resource.fontTextBold);
        tfInformacionReceptor.setBounds(233, 110, 200, 28);
        tfInformacionReceptor.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfInformacionReceptor);

        JLabel lTrailer = new JLabel("TRAILER");
        lTrailer.setFont(Resource.fontTextMini1);
        lTrailer.setBounds(457, 86, 100, 30);
        container.add(lTrailer);

        tfTrailer = new JTextField();
        tfTrailer.setFont(Resource.fontTextBold);
        tfTrailer.setBounds(435, 110, 90, 28);
        tfTrailer.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfTrailer);

        JLabel lRespuesta = new JLabel("RESPUESTA:");
        lRespuesta.setFont(Resource.fontText);
        lRespuesta.setBounds(48, 151, 150, 30);
        container.add(lRespuesta);

        JLabel lIndicador = new JLabel("INDICADOR");
        lIndicador.setFont(Resource.fontTextMini1);
        lIndicador.setBounds(65, 181, 100, 30);
        container.add(lIndicador);

        tfIndicadorReceptor = new JTextField();
        tfIndicadorReceptor.setFont(Resource.fontTextBold);
        tfIndicadorReceptor.setBounds(49, 205, 90, 28);
        tfIndicadorReceptor.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfIndicadorReceptor);

        JLabel lACK = new JLabel("ACK");
        lACK.setFont(Resource.fontTextMini1);
        lACK.setBounds(153, 181, 48, 30);
        container.add(lACK);

        tfACKReceptor = new JTextField("0");
        tfACKReceptor.setFont(Resource.fontTextBold);
        tfACKReceptor.setBounds(140, 205, 48, 28);
        tfACKReceptor.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfACKReceptor);

        JLabel lENQ = new JLabel("ENQ");
        lENQ.setFont(Resource.fontTextMini1);
        lENQ.setBounds(203, 181, 50, 30);
        container.add(lENQ);

        tfENQReceptor = new JTextField("0");
        tfENQReceptor.setFont(Resource.fontTextBold);
        tfENQReceptor.setBounds(190, 205, 48, 28);
        tfENQReceptor.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfENQReceptor);

        JLabel lCTR = new JLabel("CTR");
        lCTR.setFont(Resource.fontTextMini1);
        lCTR.setBounds(254, 181, 50, 30);
        container.add(lCTR);

        tfCTRReceptor = new JTextField("0");
        tfCTRReceptor.setFont(Resource.fontTextBold);
        tfCTRReceptor.setBounds(240, 205, 48, 28);
        tfCTRReceptor.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfCTRReceptor);

        JLabel lDAT = new JLabel("DAT");
        lDAT.setFont(Resource.fontTextMini1);
        lDAT.setBounds(304, 181, 50, 30);
        container.add(lDAT);

        tfDATReceptor = new JTextField("0");
        tfDATReceptor.setFont(Resource.fontTextBold);
        tfDATReceptor.setBounds(290, 205, 48, 28);
        tfDATReceptor.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfDATReceptor);

        JLabel lPPT = new JLabel("PPT");
        lPPT.setFont(Resource.fontTextMini1);
        lPPT.setBounds(354, 181, 50, 30);
        container.add(lPPT);

        tfPPTReceptor = new JTextField("0");
        tfPPTReceptor.setFont(Resource.fontTextBold);
        tfPPTReceptor.setBounds(340, 205, 48, 28);
        tfPPTReceptor.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfPPTReceptor);

        JLabel lLPT = new JLabel("LPT");
        lLPT.setFont(Resource.fontTextMini1);
        lLPT.setBounds(404, 181, 50, 30);
        container.add(lLPT);

        tfLPTReceptor = new JTextField("0");
        tfLPTReceptor.setFont(Resource.fontTextBold);
        tfLPTReceptor.setBounds(390, 205, 48, 28);
        tfLPTReceptor.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfLPTReceptor);

        JLabel lNUM = new JLabel("NUM");
        lNUM.setFont(Resource.fontTextMini1);
        lNUM.setBounds(452, 181, 40, 30);
        container.add(lNUM);

        tfNUMReceptor = new JTextField();
        tfNUMReceptor.setFont(Resource.fontTextBold);
        tfNUMReceptor.setBounds(440, 205, 48, 28);
        tfNUMReceptor.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfNUMReceptor);

        JLabel lInformacion1 = new JLabel("INFORMACIÓN");
        lInformacion1.setFont(Resource.fontTextMini1);
        lInformacion1.setBounds(550, 181, 100, 30);
        container.add(lInformacion1);

        tfInformacion1Receptor = new JTextField();
        tfInformacion1Receptor.setFont(Resource.fontTextBold);
        tfInformacion1Receptor.setBounds(490, 205, 200, 28);
        tfInformacion1Receptor.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfInformacion1Receptor);

        JLabel lIndicador1 = new JLabel("INDICADOR");
        lIndicador1.setFont(Resource.fontTextMini1);
        lIndicador1.setBounds(713, 181, 100, 30);
        container.add(lIndicador1);

        tfIndicador1Receptor = new JTextField();
        tfIndicador1Receptor.setFont(Resource.fontTextBold);
        tfIndicador1Receptor.setBounds(692, 205, 100, 28);
        tfIndicador1Receptor.setHorizontalAlignment(JTextField.CENTER);
        container.add(tfIndicador1Receptor);

        JButton btResponder = new JButton("RESPONDER");
        btResponder.setBounds(794, 205, 105, 28);
        container.add(btResponder);

        JLabel lSemantica = new JLabel("SEMÁNTICA: TRAMA DE CONTROL, TRAMA RECIBIDA CON ÉXITO");
        lSemantica.setFont(Resource.fontText);
        lSemantica.setBounds(200, 233, 500, 30);
        container.add(lSemantica);

        JLabel lMensajeRecibido = new JLabel("MENSAJE RECIBIDO:");
        lMensajeRecibido.setFont(Resource.fontText);
        lMensajeRecibido.setBounds(48, 263, 150, 30);
        container.add(lMensajeRecibido);

        JTextField tfMensajeRecibido = new JTextField();
        tfMensajeRecibido.setBounds(200, 263, 500, 28);
        tfMensajeRecibido.setFont(Resource.fontTextBold);
        container.add(tfMensajeRecibido);
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

        JScrollPane scrollPane = new JScrollPane(taSecuenciaDeTramas);
        scrollPane.setBounds(16, 16, 230-32, 568-32);
        scrollPane.setBorder(null);
        container.add(scrollPane);
    }

    public void enviar(Trama trama) {

    }
}
