import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unused")

public class ProblemSolved {
    // Objectos
    private final Random random = new Random();
    private final Scanner scanner = new Scanner(System.in);
    // Vetores
    private final ArrayList<Integer> array = new ArrayList<>(Arrays.asList(4, 5, 1, 2, 9, 5, 2));
    private final ArrayList<Integer> arrayAux = new ArrayList<Integer>();

    // Outros
    private int auxSwitch;
    private boolean verify = true;
    private int contExecute;

    private void cloneArray(ArrayList<Integer> origin, ArrayList<Integer> clone) {
        for (int i = 0; i < origin.size(); i++) {
            // Adiciona o array original para o auxiliar
            if (clone.isEmpty()) {
                clone.addAll(origin);
                return;
            } else {
                // Modificas a posicao do arney clone previamente clonado pelo addAll(Origin)
                clone.set(i, origin.get(i));
            }
        }
    }

    private void organizeArray(ArrayList<Integer> array, ArrayList<Integer> arrayAux) {
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

    public ProblemSolved() {
        cloneArray(array, arrayAux);
        System.out.println(array);
        organizeArray(array, arrayAux);
        System.out.println(arrayAux);

    }
}
