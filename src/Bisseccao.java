import java.util.List;
import java.util.ArrayList;

public class Bisseccao {
    private List<Float> resultadosDoX = new ArrayList<>();
    private List<Float> resultadosCriterioParada = new ArrayList<>();
    private List<Double> resultadosFuncao = new ArrayList<>();
    private List<Integer> indicesX = new ArrayList<>();
    private List<Integer> intervaloA = new ArrayList<>();
    private List<Integer> intervaloB = new ArrayList<>();

    public float bisseccao(float primeiroIntervalo, float segundoIntervalo, int expoente) {
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
            this.resultadosCriterioParada.add(criterioDeParada);

            if (criterioDeParada < 0) {
                criterioDeParada *= -1;
            }

            if (criterioDeParada > epsilon) {
                proximo = false;
            } else {
                proximo = true;
            }

            k++;
            this.resultadosDoX.add(rr);
            // System.out.println("K=" + k + ", x=" + rr);
        }
        return rr;
    }

    public float divide(float x1, float x2) {
        return (x1 + x2) / 2;
    }

    public void tabelaDeSinais() {
        double resultado;
        for (int i = -5; i <= 5; i++) {
            resultado = ((Math.pow(i, 3)) - (9 * i) + 3);
            // System.out.print(resultado + " ");
            this.resultadosFuncao.add(resultado);
            this.indicesX.add(i);
        }
    }

    public List<Integer> identificarIntervalos() {
        for (int i = 0; i < this.resultadosFuncao.size()-1; i++) {

            if (this.resultadosFuncao.get(i) < 0 && this.resultadosFuncao.get(i + 1) > 0) {
                // System.out.format("[%f, %f]", resultados.get(i), resultados.get(i + 1));
                // System.out.format("[%d, %d]", indices.get(i), indices.get(i + 1));
                this.intervaloA.add(this.indicesX.get(i));
                this.intervaloB.add(this.indicesX.get(i + 1));
            } else if (this.resultadosFuncao.get(i) > 0 && this.resultadosFuncao.get(i + 1) < 0) {
                // System.out.format("[%d, %d]", indices.get(i), indices.get(i + 1));
                this.intervaloA.add(this.indicesX.get(i));
                this.intervaloB.add(this.indicesX.get(i + 1));
            }
        }

        return intervaloA;
    }

    public void imprimirResultado() {
        for (int i = 0; i < this.resultadosDoX.size(); i++) {
            int k = i+1;
            float x = this.resultadosDoX.get(i);
            double funcao = ((Math.pow(this.resultadosDoX.get(i), 3)) - (9 * this.resultadosDoX.get(i)) + 3);
            String saida = "K=" + k + ", x=" + x + ", f(x)=" + funcao + ", criterio de parada=" +
                    Math.abs(this.resultadosCriterioParada.get(i));
        }
    }

    public List<Float> getResultadosDoX() {
        return this.resultadosDoX;
    }

    public List<Float> getResultadosCriterioParada() {
        return this.resultadosCriterioParada;
    }

    public List<Double> getResultadosFuncao() {
        return this.resultadosFuncao;
    }

    public List<Integer> getIntervaloA() {
        return this.intervaloA;
    }

    public List<Integer> getIntervaloB() {
        return this.intervaloB;
    }

}