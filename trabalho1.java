import java.util.ArrayList;

public class trabalho1 {

    private static double q1, q2, q3;              //Instanciação das variáveis que serão utilizadas em mais de um método

    public static void main(String[] args) {
        baseDados base = new baseDados();
        base.addTitulos("Titulo 1");
        base.addTitulos("Titulo 2");
        base.addAno(1995);
        base.addAno(2006);
        base.addNota(8, 7, 5);
        base.addNota(8.5, 6.5, 9.7);

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

    public static int aritmetica(int[] num) {
        int result = 0, n = num.length;             //Instanciação das variáveis
        for (int i = 0; i < num.length; i++) {      //Somatória dos valores do array
            result += num[i];
        }
        return result / n;
    }

    public static int harmonica(int[] num) {
        int result = 0, n = num.length;             //Instanciação das variáveis
        for (int i = 0; i < num.length; i++) {      //Somatória dos valores do array
            result += num[i];
        }
        return n / result;
    }

    public static double geometrica(int[] num) {
        int result = 1, n = num.length;             //Instanciação das variáveis
        for (int i = 0; i < num.length; i++) {      //Somatória de multiplicações dos valores do array
            result = num[i] * result;
        }
        return Math.pow(result, (1 / n));
    }

    public static int mediana(int[] num, int inicio, int fim) {
        int tamanho = fim - inicio + 1;    //Instanciação da variável que indica o tamanho do array
        int meio = inicio + tamanho / 2;  //Instanciação da variável que indica o meio do array

        if (tamanho % 2 == 0) {  //Verifica se o array é de tamanho par ou ímpar e se for calcula do jeito necessário
            return (num[meio - 1] + num[meio]) / 2;
        } else {
            return num[meio];
        }
    }

    public static int amplitude(int[] num) {
        int n = num.length;     //Instanciação da variável
        return num[n - 1] - num[0];
    }

    public static double variancia(int[] num) {
        int result = 0, m = aritmetica(num), n = num.length;  //Instanciação das variáveis
        for (int i = 0; i < n; i++) {       //Somatório da equação (Xi - x)^2
            result += Math.pow((i - m), 2);
        }
        return result / (n - 1);
    }

    public static double desvioPadrao(double var) {
        return Math.sqrt(var);
    }

    public static void quartis(int[] num) {
        int n = num.length;     //Instanciação da variável

        double posQ1 = (n + 1) / 4.0;       //Instanciação das variáveis com o calculo de posição
        double posQ3 = 3 * (n + 1) / 4.0;   //Instanciação das variáveis com o calculo de posição

        q1 = interpolar(num, posQ1);            //Instanciação da variável Q1
        q2 = interpolar(num, (n + 1) / 2.0);    //Instanciação da variável Q2(Mediana)
        q3 = interpolar(num, posQ3);            //Instanciação da variável Q3

        System.out.println("Q1: " + q1);
        System.out.println("Q2 (Mediana): " + q2);
        System.out.println("Q3: " + q3);

        outliers(num);                          //Cálcular os outliers desse array
    }

    private static double interpolar(int[] num, double pos) {
        int indiceInferior = (int) Math.floor(pos) - 1;     //Instanciação da variável do limite inferior
        int indiceSuperior = (int) Math.ceil(pos) - 1;      //Instanciação da variável do limite superior

        if (indiceInferior == indiceSuperior) {
            return num[indiceInferior];                     // Se a posição for exata, retorna o valor
        }

        double parteDecimal = pos - Math.floor(pos);        //Parte decimal
        return num[indiceInferior] + parteDecimal * (num[indiceSuperior] - num[indiceInferior]);
    }

    public static void outliers(int[] num) {
        double iqr = q3 - q1;                       //Instanciação da variável

        double limSup = q3 + (1.5 * iqr);           //Instanciação da variável do limite superior
        double limInf = q1 - (1.5 * iqr);           //Instanciação da variável do limite inferior

        System.out.println("\nOutliers:");
        for (int i = 0; i < num.length; i++) {      //Loop
            if (num[i] > limSup || num[i] < limInf) {           //Verifica se o número é menor ou maior que os limites inferior/superiores
                System.out.println("O valor: " + num[i] + " é outlier.");
            }
        }
    }
}