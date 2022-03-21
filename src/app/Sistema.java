package app;

import app.modelo.Trama;

public class Sistema {
    private int nextID = 1;

    // componentes
    private Ventana ventana;
    private Transmisor transmisor;
    private Receptor receptor;

    public Sistema() {
        initComponents();
    }

    public static String obtenerSemantica (Trama trama) {
        String configuracion = trama.getAck()+trama.getEnq()+trama.getCtr()+trama.getDat()+trama.getPpt()+trama.getLpr()+
                trama.getNum();
        if(configuracion.equals("0010100")) {
            return "SEMÁNTICA: TRAMA DE CONTROL, PERMISO PARA TRANSMITIR";
        }
        else if(configuracion.equals("0010010")) {
            return  "SEMÁNTICA: TRAMA DE CONTROL, LISTO PARA RECIBIR";
        }
        else {
            return "SEMÁNTICA: TRAMA INVÁLIDA";
        }
    }

    public static boolean validarTrama (Trama trama) {
        return !obtenerSemantica(trama).equals("SEMÁNTICA: TRAMA INVÁLIDA");
    }

    public void enviar(Trama trama, String origen) {
        String semantica = obtenerSemantica(trama);
        if(semantica.equals("SEMÁNTICA: TRAMA DE CONTROL, PERMISO PARA TRANSMITIR")) {
            ventana.printMessageLine("Trama "+getID()+": ("+origen+") Control, permiso para transmitir.");
            receptor.recibir(trama);
        }
        else if(semantica.equals("SEMÁNTICA: TRAMA DE CONTROL, LISTO PARA RECIBIR")) {
            ventana.printMessageLine("Trama "+getID()+": ("+origen+") Control, listo para recibir.");
        }
    }

    private void initComponents() {
        ventana = new Ventana(this);

        transmisor = new Transmisor(this);
        ventana.add(transmisor);

        receptor = new Receptor(this);
        ventana.add(receptor);

        ventana.repaint();
    }

    private int getID() {
        return nextID++;
    }
}
