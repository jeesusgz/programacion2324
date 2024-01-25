package Tema3.ExamenCorregido;

public class Televisor {
    private int altura;
    private int anchura;
    private String protocolos;
    private String conexiones;
    private Pixel[][] panel;

    public Televisor(int anchura, int altura, String conexiones, String protocolos) {
        this.altura = altura;
        this.anchura = anchura;
        this.protocolos = protocolos;
        this.conexiones = conexiones;
        panel = new Pixel[altura][anchura];
        inicializarPanel();
    }

    public int getAltura() {
        return altura;
    }

    public int getAnchura() {
        return anchura;
    }

    private void inicializarPanel(){
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                double r = Math.random();

                panel[i][j] = new Pixel(r <= 0.03);
            }
        }
    }

    public boolean isDefectuoso(){
        int cont = 0;

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                if (panel[i][j].isDefectuoso()){
                    cont++;
                }
            }
        }

        return cont >= altura * anchura * 0.03;
    }

    public void setImagen(String[][] imagen){
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                int r = Integer.parseInt(imagen[i][j].substring(1,3), 16);
                int g = Integer.parseInt(imagen[i][j].substring(3,5), 16);
                int b = Integer.parseInt(imagen[i][j].substring(5,7), 16);

                panel[i][j].setR(r);
                panel[i][j].setG(g);
                panel[i][j].setB(b);
            }
        }
    }


    public String getColorPromedio() {
        long r = 0, g = 0, b = 0;

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < anchura; j++) {
                r += panel[i][j].getR();
                g += panel[i][j].getG();
                b += panel[i][j].getB();
            }
        }

        int colorPromedioR = (int) r / (altura * anchura);
        int colorPromedioG = (int) g / (altura * anchura);
        int colorPromedioB = (int) b / (altura * anchura);

        return String.format("#%02X%02X%02X", colorPromedioR, colorPromedioG, colorPromedioB);
    }

    public String conectar(Dispositivo dispositivo) throws DispositivoNoCompatibleException{
        String[] conexionesTelevisor = conexiones.split(" ");
        String[] conexionesDispositivo = dispositivo.getConexiones().split(" ");
        String conexionUtilizada = null;

        for (int i = 0; i < conexionesTelevisor.length && conexionUtilizada == null; i++) {
            for (int j = 0; j < conexionesDispositivo.length && conexionUtilizada == null; j++) {
                if (conexionesTelevisor[i].equals(conexionesDispositivo[j])){
                    conexionUtilizada = conexionesDispositivo[j];
                }
            }
        }

        if (conexionUtilizada == null) {
            throw new DispositivoNoCompatibleException("El dispositivo " + dispositivo.getNombre() + " no tiene ninguna conexión compatible ");
        }

        String[] protocolosTelevisor = conexiones.split(" ");
        String[] protocolosDispositivo = dispositivo.getConexiones().split(" ");
        String protocolosUtilizada = null;

        for (int i = 0; i < protocolosTelevisor.length && protocolosUtilizada == null; i++) {
            for (int j = 0; j < protocolosDispositivo.length && protocolosUtilizada == null; j++) {
                if (protocolosTelevisor[i].equals(protocolosDispositivo[j])){
                    protocolosUtilizada = protocolosDispositivo[j];
                }
            }
        }

        if (protocolosUtilizada == null) {
            throw new DispositivoNoCompatibleException("El dispositivo" + dispositivo.getNombre() + "no tiene ningún protocolo compatible");
        }

        return String.format("Dispositivo %s conectado en el puerto HDMI usando el protocolo %s", dispositivo.getNombre(), conexionUtilizada, protocolosUtilizada);
    }
}
