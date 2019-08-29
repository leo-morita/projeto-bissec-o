import java.util.List;
import java.util.ArrayList;

public class Main {
    static List<Float> resultadosDoX = new ArrayList<>();
    static List<Float> resultadosCriterioParada = new ArrayList<>();

    public static float bisseccao(float primeiroIntervalo, float segundoIntervalo, int expoente) {
        float epsilon = (float) Math.pow(10, expoente);
        boolean proximo = false;

        float in1, in2;
        float rr = 0;

        int k = 0;

        while (proximo == false) {
            rr = in1 = divide(primeiroIntervalo, segundoIntervalo);

            if (k % 2 == 0) {
                segundoIntervalo = in1;
            } else {
                primeiroIntervalo = in1;
            }

            float criterioDeParada = (primeiroIntervalo - segundoIntervalo) / 2;
            resultadosCriterioParada.add(criterioDeParada);

            if (criterioDeParada < 0) {
                criterioDeParada *= -1;
            }

            if (criterioDeParada > epsilon) {
                proximo = false;
            } else {
                proximo = true;
            }

            k++;
            resultadosDoX.add(rr);
            System.out.println("K=" + k + ", x=" + rr);
        }
        return rr;
    }

    public static float divide(float x1, float x2) {
        return (x1 + x2) / 2;
    }

    public static void main(String[] args) {
        List<Double> resultados = new ArrayList<>();
        List<Integer> indices = new ArrayList<>();
        tabelaDeSinais(resultados, indices);
        List<Integer> intervaloA = new ArrayList<>();
        List<Integer> intervaloB = new ArrayList<>();

        identificarIntervalos(resultados, indices, intervaloA, intervaloB);

        for (int i = 0; i < intervaloA.size(); i++) {
            System.out.format("[%d, %d]", intervaloA.get(i), intervaloB.get(i));
        }

        System.out.println();
        System.out.println(bisseccao(intervaloA.get(1), intervaloB.get(1), -3));
        System.out.println(resultadosDoX);

        // Resultados do x na função
        for (int i = 0; i < resultadosDoX.size(); i++) {
            int k = i + 1;
            float x = resultadosDoX.get(i);
            double funcao = ((Math.pow(resultadosDoX.get(i), 3)) - (9 * resultadosDoX.get(i)) + 3);
            String saida = "K=" + k + ", x=" + x + ", f(x)=" + funcao + ", criterio de parada="
                    + Math.abs(resultadosCriterioParada.get(i));
            System.out.println(saida);
        }
    }

    private static void identificarIntervalos(List<Double> resultados, List<Integer> indices, List<Integer> intervaloA,
            List<Integer> intervaloB) {
        for (int i = 0; i < resultados.size() - 1; i++) {

            if (resultados.get(i) < 0 && resultados.get(i + 1) > 0) {
                // System.out.format("[%f, %f]", resultados.get(i), resultados.get(i + 1));
                // System.out.format("[%d, %d]", indices.get(i), indices.get(i + 1));
                intervaloA.add(indices.get(i));
                intervaloB.add(indices.get(i + 1));
            } else if (resultados.get(i) > 0 && resultados.get(i + 1) < 0) {
                // System.out.format("[%d, %d]", indices.get(i), indices.get(i + 1));
                intervaloA.add(indices.get(i));
                intervaloB.add(indices.get(i + 1));
            }
        }
    }

    private static void tabelaDeSinais(List<Double> resultados, List<Integer> indices) {
        double resultado;
        for (int i = -5; i <= 5; i++) {
            resultado = ((Math.pow(i, 3)) - (9 * i) + 3);
            // System.out.print(resultado + " ");
            resultados.add(resultado);
            indices.add(i);
        }
    }

    public void test() {
        System.out.println("");
    }
}