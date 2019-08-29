
import java.util.List;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        Bisseccao bisseccao = new Bisseccao();
        List<Float> resultadosDoX = new ArrayList<>();
        List<Float> resultadosCriterioParada = new ArrayList<>();

        bisseccao.tabelaDeSinais();
        bisseccao.identificarIntervalos();

        System.out.println(bisseccao.bisseccao(0, 1, -3));

        resultadosDoX = bisseccao.getResultadosDoX();
        resultadosCriterioParada = bisseccao.getResultadosCriterioParada();
        for (int i = 0; i < resultadosDoX.size(); i++) {
            int k = i + 1;
            float x = resultadosDoX.get(i);
            double funcao = ((Math.pow(resultadosDoX.get(i), 3)) - (9 * resultadosDoX.get(i)) + 3);
            String saida = "K=" + k + ", x=" + x + ", f(x)=" + funcao + ", criterio de parada=" +
                    Math.abs(resultadosCriterioParada.get(i));
            System.out.println(saida);
        }
    }

}
