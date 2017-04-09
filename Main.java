/**
 * Created by Paulo Pocinho on 06/04/2017.
 */

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int testes = 0;
        int alunos = 0;
        Scanner s = new Scanner(System.in);
        s.useLocale(Locale.US);

        System.out.println("Introduza o numero de alunos:");
        alunos = validarInt(s);
        System.out.println("Introduza o numero de testes:");
        testes = validarInt(s);

        double[][] notas = new double[alunos][testes];

        for (int i = 0; i < alunos; ++i) {
            for (int j = 0; j < testes; ++j) {
                System.out.println("Introduza a nota do aluno " + i + " no teste " + j + ":");
                notas[i][j] = validarDouble(s);
            }
        }

        AvaliacaoAluno a = new AvaliacaoAluno(notas);

        System.out.println(a);

    }

    static double validarDouble(Scanner s) {
        double resultado = 0.0;
        for(;;) {
            if (!s.hasNextDouble()) {
                System.out.println("Numero Invalido.");
                s.nextLine();
            } else {
                resultado = Double.parseDouble(s.nextLine());
                break;
            }
        }
        return resultado;
    }

    static int validarInt(Scanner s) {
        int resultado = 0;
        for (;;) {
            if (!s.hasNextInt()) {
                System.out.println("Numero Invalido.");
                s.nextLine();
            } else {
                resultado = Integer.parseInt(s.nextLine());
                break;
            }
        }
        return resultado;
    }
}
