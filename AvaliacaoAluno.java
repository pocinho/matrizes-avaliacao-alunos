/**
 * Created by Paulo Pocinho on 06/04/2017.
 */
public class AvaliacaoAluno {
    private int numAlunos;
    private int testes;
    private double[][] avaliacoes;
    private double[] mediaAlunos;
    private double[] mediaTestes;

    public int getNumAlunos() {
        return numAlunos;
    }

    public int getTestes() {
        return testes;
    }

    public double[][] getAvaliacoes() {
        return avaliacoes;
    }

    public double[] getMediaAlunos() {
        return mediaAlunos;
    }

    public double[] getMediaTestes() {
        return mediaTestes;
    }

    private void preencheAvaliacao(double[][] a) {
        for (int l = 0; l < a.length; ++l) {
            for (int c = 0; c < a[0].length; ++c) {
                avaliacoes[l][c] = a[l][c];
            }
        }
    }

    private void preencheMediaAlunos() {
        for (int i = 0; i < numAlunos; ++i) {
            mediaAlunos[i] = 0;
        }

        for (int l = 0; l < numAlunos; ++l) {
            for (int c = 0; c < testes; ++c) {
                mediaAlunos[l] += avaliacoes[l][c];
            }
        }

        for (int i = 0; i < numAlunos; ++i) {
            mediaAlunos[i] /= testes;
        }
    }

    private void preencheMediaTestes() {
        for (int i = 0; i < testes; ++i) {
            mediaTestes[i] = 0;
        }

        for (int l = 0; l < testes; ++l) {
            for (int c = 0; c < numAlunos; ++c) {
                mediaTestes[l] += avaliacoes[c][l];
            }
        }

        for (int i = 0; i < testes; ++i) {
            mediaTestes[i] /= numAlunos;
        }
    }

    public AvaliacaoAluno(double[][] a) {
        numAlunos = a.length;
        testes = a[0].length;
        avaliacoes = new double[numAlunos][testes];
        mediaAlunos = new double[numAlunos];
        mediaTestes = new double[testes];
        preencheAvaliacao(a);
        preencheMediaAlunos();
        preencheMediaTestes();
    }

    @Override
    public String toString() {
        String resultado = "Avaliações: \n";

        int aluno = 0;
        for (double[] l : avaliacoes) {
            resultado += "Aluno " + aluno + ": ";
            for (double c : l) {
                resultado += c + " ";
            }
            resultado += "\n";
            aluno++;
        }

        resultado += "\nMedia alunos:\n";

        for (int i = 0; i < numAlunos; ++i) {
            resultado += "Aluno " + i + ": " + mediaAlunos[i] + "\n";
        }

        resultado += "\nMedia testes:\n";

        for (int i = 0; i < testes; ++i) {
            resultado += "Teste " + i + ": " + mediaTestes[i] + "\n";
        }

        return resultado;
    }
}
