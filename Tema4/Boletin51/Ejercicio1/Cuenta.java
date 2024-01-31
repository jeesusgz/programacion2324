package Tema4.Boletin51.Ejercicio1;

public class Cuenta {
    public static final double SALDO_DEFAULT = 0;
    private double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public Cuenta() {
        this.saldo = SALDO_DEFAULT;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingresarDinero(double dineroAIngresar) throws CuentaException {
        if (dineroAIngresar <= 0) {
            throw new CuentaException(" Debes ingresar una cantidad positiva");
        }
        this.saldo += dineroAIngresar;

    }

    public void sacarDinero(double dineroASacar) throws CuentaException, CuentaCreditoException {
        if (dineroASacar <= 0) {
            throw new CuentaException("Debes sacar un dinero positivo");

        }
        if (dineroASacar > saldo) {
            throw new CuentaException("No puedes sacar mas del saldo disponible (" + saldo + "€)");
        }
        saldo -= dineroASacar;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "saldo=" + saldo +
                '}';
    }
}
