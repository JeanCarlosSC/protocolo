package modelo;

public class Sistema {
    public static String obtenerSemantica (Trama trama) {
        String configuracion = trama.getAck()+trama.getEnq()+trama.getCtr()+trama.getDat()+trama.getPpt()+trama.getLpr()+
                trama.getNum();
        if(configuracion.equals("0010100")) {
            return "SEMÁNTICA: TRAMA DE CONTROL, PERMISO PARA TRANSMITIR";
        }
        else {
            return "SEMÁNTICA: TRAMA INVÁLIDA";
        }
    }

    public static boolean validarTrama (Trama trama) {
        return !obtenerSemantica(trama).equals("SEMÁNTICA: TRAMA INVÁLIDA");
    }
}
