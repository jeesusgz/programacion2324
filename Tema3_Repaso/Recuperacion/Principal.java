package Tema3_Repaso.Recuperacion;

public class Principal {
    public static void main(String[] args) {
        try {

            Coche coche1 = new Coche("porche","Panamera", TColor.NEGRO,
                    new Motor("a","o", "i", 3, 0.97, 0.8, 0.65),
                    new Bateria(13, 13, 78),
                    new DepositoGasolina(true, 128, 80),
                    new CajaCambios(7, true));

            System.out.println(coche1);
            coche1.arrancar();
        } catch (CocheException e) {
            System.out.println(e.getMessage());
        }


        try {
            Coche coche2 = new Coche("toyota","o", TColor.BLANCO,
                    new Motor("a","o", "i", 3, 0.97, 0.5, 0.65),
                    new Bateria(13, 13, 78),
                    new DepositoGasolina(true, 128, 80),
                    new CajaCambios(7, true));
            System.out.println(coche2);
            coche2.arrancar();
        } catch (CocheException e) {
            System.out.println(e.getMessage());
        }

        try {
            Coche coche3 = new Coche("supra","achu", TColor.AMARILLO,
                    new Motor("a","o", "i", 3, 0.94, 0.5, 0.65),
                    new Bateria(13, 13, 78),
                    new DepositoGasolina(true, 128, 80),
                    new CajaCambios(7, true));
            System.out.println(coche3);
            coche3.arrancar();
        } catch (CocheException e) {
            System.out.println(e.getMessage());
        }
    }
}
