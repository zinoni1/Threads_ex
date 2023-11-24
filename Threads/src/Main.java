import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[1000];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1;
        }

        Mitjana[] threads = new Mitjana[5];
        int thread200 = array.length / 5;

        for (int i = 0; i < 5; i++) {
            int PosInicial = i * thread200;
            int posFinal;
            if (i == 4) {
                posFinal = array.length;
            } else {
                posFinal = (i + 1) * thread200;
            }
            threads[i] = new Mitjana(array, PosInicial, posFinal);
            threads[i].start();
        }

        for (Mitjana thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        double mitjanaFinal = calcularMitjanaFinal(threads);
        double mitjanaNormal = calcularMitjanaNormal(array);

        System.out.println("Mitjana amb threads: " + (mitjanaFinal));
        System.out.println("Mitjana sense threads: " + (mitjanaNormal));
    }

    private static double calcularMitjanaFinal(Mitjana[] threads) {
        double sum = 0;
        for (Mitjana thread : threads) {
            sum += thread.getResultat();
        }
        return sum / threads.length;
    }

    private static double calcularMitjanaNormal(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / (array.length);
    }
}
