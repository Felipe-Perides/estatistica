import java.util.ArrayList;
import java.util.Arrays;

public class trabalho1 {

    private static double q1, q2, q3;     //Instanciação das variáveis que serão utilizadas em mais de um método

    public static void main(String[] args) {
        baseDados base = new baseDados();
        base.addTitulos("Titulo 1");
        base.addTitulos("Titulo 2");
        base.addAno(1995);
        base.addAno(2006);
        base.addNota(8, 7, 5);
        base.addNota(8.5, 6.5, 9.7);

        System.out.println("Análise da base de dados: \n");

        System.out.print("|Título     | Ano | Nota Google | Nota Amazon | Nota IMDB |\n");
        System.out.print("|"+base.getTitulos()[0]+"   |"+base.getAnos()[0]+" |"+base.getNotas()[0]+"\n");
        System.out.print("|"+base.getTitulos()[1]+"   |"+base.getAnos()[1]+" |"+base.getNotas()[1]+"\n");


        System.out.println("\n");
        int[] anos = base.getAnos();
        notas[] nota = base.getNotas();
        Arrays.sort(anos);
        Arrays.sort(nota[0].getNotas());
        Arrays.sort(nota[1].getNotas());

        if(isQuantitativa(base, "anos")&&isQuantitativa(base, "notas")){
            System.out.print("média aritmética anos: ");
            System.out.printf("%.3f\n",(double)aritmeticaAnos(anos));
            System.out.print("média aritmética notas: ");
            System.out.printf("%.3f\n",(double)aritmeticaNotas(nota));
            System.out.print("média harmônica anos: ");
            System.out.printf("%.3f\n",(double)harmonicaAnos(anos));
            System.out.print("média harmônica notas: ");
            System.out.printf("%.3f\n",(double)harmonicaNotas(nota));
            System.out.print("média geométrica anos: ");
            System.out.printf("%.3f\n",geometricaAno(anos));
            System.out.print("média geométrica notas: ");
            System.out.printf("%.3f\n",(double)geometricaNotas(nota));
            System.out.print("mediana anos: ");
            System.out.printf("%.3f\n",medianaAnos(anos, 0, anos.length));
            System.out.print("mediana notas: ");
            System.out.printf("%.3f\n",medianaNotas(nota, 0, nota.length-1));
            System.out.print("amplitude anos: ");
            System.out.printf("%.3f\n",(double)amplitudeAnos(anos));
            System.out.print("amplitude notas: ");
            System.out.printf("%.3f\n",amplitudeNotas(nota));
            System.out.print("variância anos: ");
            System.out.printf("%.3f\n",(double)varianciaAnos(anos));
            System.out.print("variância notas: ");
            System.out.printf("%.3f\n",varianciaNotas(nota));
            System.out.print("Desvio Padrão anos: ");
            System.out.printf("%.3f\n",desvioPadrao(varianciaNotas(nota)));
            System.out.print("Desvio Padrão notas: ");
            System.out.printf("%.3f\n",desvioPadrao(varianciaAnos(anos)));
            quartisAnos(anos);
            System.out.println();
            quartisNotas(nota);
        }

        //System.out.println(base);
        //System.out.println(isQuantitativa(base, "anos"));
        //System.out.println(isQuantitativa(base, "titulos"));
        //System.out.println(isQuantitativa(base, "notas"));

    }

    public static boolean isQuantitativa(baseDados b, String tipoArray){
        switch (tipoArray.toLowerCase()) {
            case "titulos":
                return false; // Títulos são sempre qualitativos (String)
            case "anos":
                return true;  // Anos são sempre quantitativos (int)
            case "notas":
                return true;  // Notas são sempre quantitativas (double)
            default:
                throw new IllegalArgumentException("Tipo de array inválido: " + tipoArray);
        }   
    }

    public static double[] conversorNotas(notas[] num){
        double[] todasNotas = new double[num.length];
        int index = 0;

        // Preencher o array com todas as notas dos objetos válidos
        for (int i = 0; i < num.length; i++) {
            if (num[i] != null) {
                todasNotas[index++] = num[i].getNota1();
                todasNotas[index++] = num[i].getNota2();
                todasNotas[index++] = num[i].getNota3();
            }
        }

        // Redimensionar o array para o tamanho real
        double[] notas = new double[index];
        System.arraycopy(todasNotas, 0, notas, 0, index);

        // Ordenar o array para encontrar a mediana
        Arrays.sort(notas);
        return notas;
    }

    public static double aritmeticaAnos(int[] num) {
        double result = 0, n = num.length;             //Instanciação das variáveis
        for (int i = 0; i < num.length; i++) {      //Somatória dos valores do array
            result += num[i];
        }
        return result / n;
    }

    public static double aritmeticaNotas(notas[] num) {
        double result = 0, n = num.length;             //Instanciação das variáveis
        for (notas no : num) {      //Somatória dos valores do array
            if(no!=null){
                result = no.getNota1() + no.getNota2() + no.getNota3() + result;
            }
        }
        return result / n;
    }

    private static double aritmeticaNotas(double[] num) {
        double result = 0, n = num.length;             //Instanciação das variáveis
        for (int i = 0; i<num.length; i++) {      //Somatória dos valores do array
            result += num[i];
        }
        return result / n;
    }

    public static double harmonicaAnos(int[] num) {
        double result = 0, n = num.length;             //Instanciação das variáveis
        for (int i = 0; i < num.length; i++) {      //Somatória dos valores do array
            result += num[i];
        }
        return n / result;
    }

    public static double harmonicaNotas(notas[] num) {
        double result = 0, n = num.length;             //Instanciação das variáveis
        for (notas no : num) {      //Somatória dos valores do array
            if(no!=null){
                result = no.getNota1() + no.getNota2() + no.getNota3() + result;
            }
        }
        return n / result;
    }

    public static double geometricaAno(int[] num) {
        int result = 1, n = num.length;             //Instanciação das variáveis
        for (int i = 0; i < num.length; i++) {      //Somatória de multiplicações dos valores do array
            result = num[i] * result;
        }
        return Math.pow(result, (1 / n));
    }

    public static double geometricaNotas(notas[] num) {
        double result = 1, n = num.length;             //Instanciação das variáveis
        for (notas no : num) {      //Somatória das multiplicações dos valores do array
            if(no!=null){
                result = no.getNota1() * no.getNota2() * no.getNota3() * result;
            }
        }
        return Math.pow(result, (1 / n));
    }

    public static double medianaAnos(int[] num, int inicio, int fim) {
        int tamanho = fim - inicio + 1;    //Instanciação da variável que indica o tamanho do array
        int meio = inicio + tamanho / 2;  //Instanciação da variável que indica o meio do array

        if (tamanho % 2 == 0) {  //Verifica se o array é de tamanho par ou ímpar e se for calcula do jeito necessário
            
            return (num[meio - 1] + num[meio]) / 2;
        } else {
            return num[meio];
        }
    }

    public static double medianaNotas(notas[] num, int inicio, int fim) {
        double[] notas = conversorNotas(num);

        // Calcular a mediana
        if (notas.length % 2 == 0) {  // Tamanho par
            return (notas[notas.length/2 - 1] + notas[notas.length/2]) / 2.0;
        } else {  // Tamanho ímpar
            return notas[notas.length/2];
        }
    }

    public static int amplitudeAnos(int[] num) {
        int n = num.length;     //Instanciação da variável
        return num[n - 1] - num[0];
    }

    public static double amplitudeNotas(notas[] num){
        double[] notas = conversorNotas(num);

        return notas[notas.length-1] - notas[0];
    }

    public static double varianciaAnos(int[] num) {
        double result = 0, m = aritmeticaAnos(num), n = num.length;  //Instanciação das variáveis
        for (int i = 0; i < n; i++) {       //Somatório da equação (Xi - x)^2
            result += Math.pow((i - m), 2);
        }
        return result / (n - 1);
    }

    public static double varianciaNotas(notas[] num) {
        double[] notas = conversorNotas(num);
    
        double result = 0, m = aritmeticaNotas(notas), n = notas.length;  //Instanciação das variáveis

        for (int i = 0; i < n; i++) {       //Somatório da equação (Xi - x)^2
            result += Math.pow((i - m), 2);
        }
        return result / (n - 1);
    }

    public static double desvioPadrao(double var) {
        return Math.sqrt(var);
    }

    public static void quartisAnos(int[] num) {
        int n = num.length;     //Instanciação da variável

        double posQ1 = (n + 1) / 4.0;       //Instanciação das variáveis com o calculo de posição
        double posQ3 = 3 * (n + 1) / 4.0;   //Instanciação das variáveis com o calculo de posição

        q1 = interpolarAnos(num, posQ1);            //Instanciação da variável Q1
        q2 = interpolarAnos(num, (n + 1) / 2.0);    //Instanciação da variável Q2(Mediana)
        q3 = interpolarAnos(num, posQ3);            //Instanciação da variável Q3

        System.out.println("Q1: " + q1);
        System.out.println("Q2 (Mediana): " + q2);
        System.out.println("Q3: " + q3);

        outliersAnos(num);                          //Cálcular os outliers desse array
    }



    private static double interpolarAnos(int[] num, double pos) {
        int indiceInferior = (int) Math.floor(pos) - 1;     //Instanciação da variável do limite inferior
        int indiceSuperior = (int) Math.ceil(pos) - 1;      //Instanciação da variável do limite superior

        if (indiceInferior == indiceSuperior) {
            return num[indiceInferior];                     // Se a posição for exata, retorna o valor
        }

        double parteDecimal = pos - Math.floor(pos);        //Parte decimal
        return num[indiceInferior] + parteDecimal * (num[indiceSuperior] - num[indiceInferior]);
    }

    public static void outliersAnos(int[] num) {
        double iqr = q3 - q1;                       //Instanciação da variável
        int index = 0;

        double limSup = q3 + (1.5 * iqr);           //Instanciação da variável do limite superior
        double limInf = q1 - (1.5 * iqr);           //Instanciação da variável do limite inferior

        System.out.println("\nOutliers:");
        for (int i = 0; i < num.length; i++) {      //Loop
            if (num[i] > limSup || num[i] < limInf) {           //Verifica se o número é menor ou maior que os limites inferior/superiores
                System.out.println("O valor: " + num[i] + " é outlier.");
                index++;
            }
        }
        if(index == 0){
            System.out.println("Não há outliers!");
        }
    }

    public static void quartisNotas(notas[] num) {
        double[] notas = conversorNotas(num);
        int n = notas.length;     //Instanciação da variável

        double posQ1 = (n + 1) / 4.0;       //Instanciação das variáveis com o calculo de posição
        double posQ3 = 3 * (n + 1) / 4.0;   //Instanciação das variáveis com o calculo de posição

        q1 = interpolarNotas(notas, posQ1);            //Instanciação da variável Q1
        q2 = interpolarNotas(notas, (n + 1) / 2.0);    //Instanciação da variável Q2(Mediana)
        q3 = interpolarNotas(notas, posQ3);            //Instanciação da variável Q3

        System.out.println("Q1: " + q1);
        System.out.println("Q2 (Mediana): " + q2);
        System.out.println("Q3: " + q3);

        outliersNotas(notas);                          //Cálcular os outliers desse array
    }

    private static double interpolarNotas(double[] num, double pos) {
        int indiceInferior = (int) Math.floor(pos) - 1;     //Instanciação da variável do limite inferior
        int indiceSuperior = (int) Math.ceil(pos) - 1;      //Instanciação da variável do limite superior

        if (indiceInferior == indiceSuperior) {
            return num[indiceInferior];                     // Se a posição for exata, retorna o valor
        }

        double parteDecimal = pos - Math.floor(pos);        //Parte decimal
        return num[indiceInferior] + parteDecimal * (num[indiceSuperior] - num[indiceInferior]);
    }

    public static void outliersNotas(double[] num) {
        double iqr = q3 - q1;                       //Instanciação da variável
        int index = 0;

        double limSup = q3 + (1.5 * iqr);           //Instanciação da variável do limite superior
        double limInf = q1 - (1.5 * iqr);           //Instanciação da variável do limite inferior

        System.out.println("\nOutliers:");
        for (int i = 0; i < num.length; i++) {      //Loop
            if (num[i] > limSup || num[i] < limInf) {           //Verifica se o número é menor ou maior que os limites inferior/superiores
                System.out.println("O valor: " + num[i] + " é outlier.");
                index++;
            }
        }
        if(index == 0){
            System.out.println("Não há outliers!");
        }
    }
}