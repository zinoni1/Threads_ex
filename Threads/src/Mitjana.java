public class Mitjana extends Thread {
    private static int contador = 1;
    private int[] array;
    private int PosInicial;
    private int PosFinal;
    private double resultat;

    private int cont;

    public Mitjana(int[] array, int PosInicial, int PosFinal) {
        this.array = array;
        this.PosInicial = PosInicial;
        this.PosFinal = PosFinal;
        this.cont = contador++;
    }

    public double getResultat() {
        return resultat;
    }

    @Override
    public void run() {
        calcularMitjana();
    }

    private void calcularMitjana() {
        double sum = 0;
        for (int i = PosInicial; i < PosFinal; i++) {
            sum += array[i];

        }
        resultat = sum / (PosFinal - PosInicial);
        System.out.println("Mitjana del thread " + cont + ": " + resultat);
    }

}
