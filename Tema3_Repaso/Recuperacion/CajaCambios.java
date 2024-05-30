package Tema3_Repaso.Recuperacion;

public class CajaCambios {
    private int numVelocidades;
    private boolean estado;

    public CajaCambios(int numVelocidades, boolean estado) throws CocheException {
        setNumVelocidades(numVelocidades);
        this.estado = estado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setNumVelocidades(int numVelocidades) throws CocheException {
        if (numVelocidades < 1 || numVelocidades > 7){
            throw new CocheException("número de velocidades incorrecto");
        }
        this.numVelocidades = numVelocidades;
    }
}
