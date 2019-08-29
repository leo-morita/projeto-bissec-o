
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Bisseccao bisseccao = new Bisseccao();
        Scanner teclado = new Scanner(System.in);
        List<Float> resultadosDoX = new ArrayList<>();
        List<Float> resultadosCriterioParada = new ArrayList<>();
        List<Integer> intervaloA = new ArrayList<>();
        List<Integer> intervaloB = new ArrayList<>();

        String funcao = "_x^5 + _xˆ4 + _x^3 + _x^2 + _x + _";
        System.out.println("Função: " + funcao);

        System.out.print("Digite o número _x^5: ");
        double n1 = teclado.nextDouble();
        funcao = String.format("%fx^5 + _xˆ4 + _x^3 + _x^2 + _x + _", n1);
        System.out.println(funcao);

        System.out.print("Digite o número _x^4: ");
        double n2 = teclado.nextDouble();
        funcao = String.format("%fx^5 + %fxˆ4 + _x^3 + _x^2 + _x + _", n1, n2);
        System.out.println(funcao);

        System.out.print("Digite o número _x^3: ");
        double n3 = teclado.nextDouble();
        funcao = String.format("%fx^5 + %fxˆ4 + %fx^3 + _x^2 + _x + _", n1, n2, n3);
        System.out.println(funcao);

        System.out.print("Digite o número _x^2: ");
        double n4 = teclado.nextDouble();
        funcao = String.format("%fx^5 + %fxˆ4 + %fx^3 + %fx^2 + _x + _", n1, n2, n3, n4);
        System.out.println(funcao);

        System.out.print("Digite o número _x: ");
        double n5 = teclado.nextDouble();
        funcao = String.format("%fx^5 + %fxˆ4 + %fx^3 + %fx^2 + %fx + _", n1, n2, n3, n4, n5);
        System.out.println(funcao);

        System.out.print("Digite o número _: ");
        double n6 = teclado.nextDouble();
        funcao = String.format("%fx^5 + %fxˆ4 + %fx^3 + %fx^2 + %fx + %f", n1, n2, n3, n4, n5, n6);
        System.out.println(funcao);

        System.out.print("£=10^");
        int expoente = teclado.nextInt();

        bisseccao.tabelaDeSinais(n1, n2, n3, n4, n5, n6);
        bisseccao.identificarIntervalos();

        intervaloA = bisseccao.getIntervaloA();
        intervaloB = bisseccao.getIntervaloB();

        System.out.println(bisseccao.bisseccao(0, 1, expoente));

        resultadosDoX = bisseccao.getResultadosDoX();
        resultadosCriterioParada = bisseccao.getResultadosCriterioParada();
        for (int i = 0; i < resultadosDoX.size(); i++) {
            int k = i + 1;
            float x = resultadosDoX.get(i);
            double fun = ((Math.pow(resultadosDoX.get(i), 3)) - (9 * resultadosDoX.get(i)) + 3);
            String saida = "K=" + k + ", x=" + x + ", f(x)=" + fun + ", criterio de parada=" +
                    Math.abs(resultadosCriterioParada.get(i));
            System.out.println(saida);
        }
    }

}
