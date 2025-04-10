import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ArraysAlgo {

    // Objectos
    static final Random random = new Random();
    static final Scanner scanner = new Scanner(System.in);
    // Vetores
    static final ArrayList<Integer> array = new ArrayList<Integer>();
    static final ArrayList<Integer> arrayAux = new ArrayList<Integer>();
    // Outros
    static int auxSwitch;
    static boolean verify = true;
    static int contExecute;

    static void cloneArray(ArrayList<Integer> original, ArrayList<Integer> copia) {
        for (int i = 0; i < original.size(); i++) {
            // Adiciona o array original para o auxiliar
            if (copia.isEmpty()) {
                copia.addAll(original);
                return;
            }
            // Modificas a posicao do arney copia previamente clonado pelo addAll(original)
            copia.set(i, original.get(i));
        }
    }

    static void organizeArray(ArrayList<Integer> array, ArrayList<Integer> arrayAux) {
        // Ordena os pares e verifica que ainda existe mais
        while (verify) {
            contExecute = 0;
            for (int i = 0; i < array.size() - 1; i++) {
                if ((array.get(i) == 1 || array.get(i) % 2 != 0) && (array.get(i + 1) % 2 == 0)) {
                    auxSwitch = arrayAux.get(i);
                    arrayAux.set(i, arrayAux.get(i + 1));
                    arrayAux.set(i + 1, auxSwitch);
                    contExecute++;
                }
            }
            // Verifica se houve alguma troca, se sim ele clona o arney auxiliar como e
            // refaz a troca!
            if (contExecute == 0)
                verify = false;
            else
                cloneArray(arrayAux, array);
        }
    }

    static void createRandom(int nrElementos, ArrayList<Integer> original) {
        for (int i = 0; i < nrElementos; i++) {
            original.add(1 + random.nextInt(100));
        }
    }

    public static void main(String[] a) {
        System.out.println("---------(Elementos Sao Gerados Aleatoriamente)-----------");
        System.out.print("Digite a Quantidade do Elemento DO Array : ");
        int nrElementos = scanner.nextInt();
        // Inicio(Do Processamento)
        createRandom(nrElementos, array);
        cloneArray(array, arrayAux);
        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }
        organizeArray(array, arrayAux);
        // Fim
        for (int i = 0; i < arrayAux.size(); i++) {
            System.out.println(arrayAux.get(i));
        }
    }
}
