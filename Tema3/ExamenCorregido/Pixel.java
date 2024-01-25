package Tema3.ExamenCorregido;

public class Pixel {
    private int r, g, b;
    private boolean defectuoso;

    public Pixel(boolean defectuoso) {
        this.defectuoso = defectuoso;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public boolean isDefectuoso() {
        return defectuoso;
    }
}
