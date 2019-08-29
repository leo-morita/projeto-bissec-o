import java.util.List;
import java.util.ArrayList;

public class Bisseccao {
    private List<Float> resultadosDoX = new ArrayList<>();
    private List<Float> resultadosCriterioParada = new ArrayList<>();

    public Bisseccao(List<Float> resultadosDoX, List<Float> resultadosCriterioParada) {
        this.resultadosDoX = resultadosDoX;
        this.resultadosCriterioParada = resultadosCriterioParada;
    }

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
            System.out.println("K=" + k + ", x=" + rr);
        }
        return rr;
    }

}