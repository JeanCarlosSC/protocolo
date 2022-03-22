package app.components;

import app.components.Receptor;
import app.components.Transmisor;
import app.components.Ventana;
import app.modelo.Trama;

import javax.swing.*;
import java.util.ArrayList;

public class Sistema {
    // contadores
    private static int nextSecuenciaID = 1;
    private static int nextTramaID = 0;

    // componentes
    private Ventana ventana;
    private Transmisor transmisor;
    private Receptor receptor;

    // frames
    private ArrayList<String> frames;

    public Sistema() {
        initComponents();
        frames = null;
    }

    public static String obtenerSemantica (Trama trama) {
        String configuracion = trama.getAck()+trama.getEnq()+trama.getCtr()+trama.getDat()+trama.getPpt()+trama.getLpr()+
                trama.getNum();
        if(configuracion.equals("0010100")) {
            return "SEMÁNTICA: TRAMA DE CONTROL, PERMISO PARA TRANSMITIR";
        }
        else if(configuracion.startsWith("001001")) {
            return  "SEMÁNTICA: TRAMA DE CONTROL, LISTO PARA RECIBIR";
        }
        else if(configuracion.startsWith("000100")) {
            return "SEMÁNTICA: TRAMA DE DATOS";
        }
        else if(configuracion.startsWith("010100")) {
            return "SEMÁNTICA: ÚLTIMA TRAMA DE DATOS";
        }
        else if(configuracion.startsWith("101000")) {
            return "SEMÁNTICA: TRAMA DE CONTROL";
        }
        else if(configuracion.startsWith("111000")) {
            return "SEMÁNTICA: ÚLTIMA TRAMA DE CONTROL";
        }
        else {
            return "SEMÁNTICA: TRAMA INVÁLIDA";
        }
    }

    public static boolean validarTrama (Trama trama, String origen) {
        if (origen.equals("Rx")) {
            // verifica que el id de la trama recibida + 1 sea igual al id de la próxima trama
            trama.setNum((Integer.parseInt(trama.getNum())+1)+"");
        }
        if(!trama.getNum().equals(nextTramaID + "")) {
            // retorna modificación
            if (origen.equals("Rx")) {
                trama.setNum((Integer.parseInt(trama.getNum())-1)+"");
            }
            return false;
        }
        return !obtenerSemantica(trama).equals("SEMÁNTICA: TRAMA INVÁLIDA");
    }

    public void enviar(Trama trama, String origen) {
        // inicializa los frames si aún no se han inicializado
        if(frames == null) {
            frames = new ArrayList<>();
            int size = transmisor.getMensajeATransmitir().length()/transmisor.getNoFrames();
            int module = transmisor.getMensajeATransmitir().length()%transmisor.getNoFrames();
            for (int i=0; i<transmisor.getNoFrames(); i++) {
                int start = i*size;
                int end = (i+1)*size+ (i==transmisor.getNoFrames()-1?module:0);
                frames.add(transmisor.getMensajeATransmitir().substring(start, end));
            }
        }

        // validación de ACK
        if(trama.getAck().equals("1") && !receptor.estaRecibiendo()) {
            JOptionPane.showMessageDialog(null, "No es posible enviar un ACK porque no se ha iniciado la" +
                    "transmisión.", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // enviar
        String semantica = obtenerSemantica(trama);

        switch (semantica) {
            case "SEMÁNTICA: TRAMA DE CONTROL, PERMISO PARA TRANSMITIR":
                // verifica origen adecuado de la trama
                if (origen.equals("Rx")) {
                    mostrarOrigenIncorrecto(origen);
                    return;
                } else {
                    ventana.printMessageLine("Trama " + getID() + ": (" + origen + ") Control, permiso para transmitir.");
                    receptor.recibir(trama);
                    nextTramaID++;
                }
                break;
            case "SEMÁNTICA: TRAMA DE CONTROL, LISTO PARA RECIBIR":
                // verifica origen adecuado de la trama
                if (origen.equals("Tx")) {
                    mostrarOrigenIncorrecto(origen);
                    return;
                } else {
                    ventana.printMessageLine("Trama " + getID() + ": (" + origen + ") Control, listo para recibir.");
                    transmisor.establecerProximaTrama(trama);
                }
                break;
            case "SEMÁNTICA: TRAMA DE DATOS":
            case "SEMÁNTICA: ÚLTIMA TRAMA DE DATOS":
                // verifica origen adecuado de la trama
                if (origen.equals("Rx")) {
                    mostrarOrigenIncorrecto(origen);
                    return;
                } else if (receptor.estaRecibiendo()) {
                    String last = "";
                    if (trama.getEnq().equals("1")) {
                        last = " finales";
                        transmisor.inhabilitar();
                    }
                    ventana.printMessageLine("Trama " + getID() + ": (" + origen + ") Datos" + last + ", Trama " + nextTramaID + ".");
                    receptor.recibir(trama);
                    nextTramaID++;
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo enviar: trama inválido. Verifique los campos y" +
                            " los permisos con el receptor.", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                break;
            case "SEMÁNTICA: TRAMA DE CONTROL":
                // verifica origen adecuado de la trama
                if (origen.equals("Tx")) {
                    mostrarOrigenIncorrecto(origen);
                    return;
                } else {
                    ventana.printMessageLine("Trama " + getID() + ": (" + origen + ") Control, Trama " + (nextTramaID - 1) + ".");
                    transmisor.establecerProximaTrama(trama);
                }
                break;
            case "SEMÁNTICA: ÚLTIMA TRAMA DE CONTROL":
                // verifica origen adecuado de la trama
                if (origen.equals("Tx")) {
                    mostrarOrigenIncorrecto(origen);
                    return;
                } else {
                    ventana.printMessageLine("Trama " + getID() + ": (" + origen + ") Último control, Trama " + (nextTramaID - 1) + ".");
                    receptor.inhabilitar();
                }
                break;
        }
    }

    private void initComponents() {
        ventana = new Ventana();

        transmisor = new Transmisor(this);
        ventana.add(transmisor);

        receptor = new Receptor(this);
        ventana.add(receptor);

        ventana.repaint();
    }

    private static int getID() {
        return nextSecuenciaID++;
    }

    private void mostrarOrigenIncorrecto(String origen) {
        String responsable = origen.equals("Tx")?"Transmisor":"Receptor";
        JOptionPane.showMessageDialog(null, "Esta trama no puede ser enviada por el "+responsable,
                "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public int getLastPosicion() {
        return frames.size()-1;
    }

    public String getFrameAt(int posicion) {
        return frames.get(posicion);
    }
}
