package teste;

import java.util.List;
import java.util.ArrayList;

public class Teste {
    
    public static void main(String[] args) {
        List<Float> resultadosDoX = new ArrayList<>();
        List<Float> resultadosCriterioParada = new ArrayList<>();
        Bisseccao b = new Bisseccao(resultadosDoX, resultadosCriterioParada);

        System.out.println(b.bisseccao(0, 1, -3));
    }

}