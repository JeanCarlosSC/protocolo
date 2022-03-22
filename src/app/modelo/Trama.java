package app.modelo;

public class Trama {
    private final String indicadorInicial;
    private String ack;
    private final String enq;
    private String ctr;
    private String dat;
    private String ppt;
    private String lpr;
    private String num;
    private final String informacion;
    private final String indicadorFinal;

    public Trama(String indicadorInicial, String ack, String enq, String ctr, String dat, String ppt, String lpr, String num,
                 String informacion, String indicadorFinal) {
        this.indicadorInicial = indicadorInicial;
        this.ack = ack;
        this.enq = enq;
        this.ctr = ctr;
        this.dat = dat;
        this.ppt = ppt;
        this.lpr = lpr;
        this.num = num;
        this.informacion = informacion;
        this.indicadorFinal = indicadorFinal;
    }

    public String getIndicadorInicial() {
        return indicadorInicial;
    }

    public String getAck() {
        return ack;
    }

    public String getEnq() {
        return enq;
    }

    public String getCtr() {
        return ctr;
    }

    public String getDat() {
        return dat;
    }

    public String getPpt() {
        return ppt;
    }

    public String getLpr() {
        return lpr;
    }

    public String getNum() {
        return num;
    }

    public String getInformacion() {
        return informacion;
    }

    public String getIndicadorFinal() {
        return indicadorFinal;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }

    public void setCtr(String ctr) {
        this.ctr = ctr;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public void setPpt(String ppt) {
        this.ppt = ppt;
    }

    public void setLpr(String lpr) {
        this.lpr = lpr;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
