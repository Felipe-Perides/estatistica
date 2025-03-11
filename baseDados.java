
public class baseDados {
    private String[] titulos;
    private int[] anos;
    private notas[] notas;
    private int titulosCount; // Contador para titulos
    private int anosCount;    // Contador para anos
    private int notasCount;  // Contador para notas

    public baseDados(){
        titulos = new String[50];
        anos = new int[50];
        notas = new notas[50];
        titulosCount = 0;
        anosCount = 0;
        notasCount = 0;
    }

    public boolean addNota(double notaG, double notaA, double notaIMDB) {
        notas novaNota = new notas(notaG, notaA, notaIMDB);
        for (int i = 0; i < notasCount; i++) {
            if (notas[i].equals(novaNota)) {
                System.out.println("Essas notas já foram adicionadas!");
                return false;
            }
        }
        // Adiciona a nova nota se houver espaço
        if (notasCount < notas.length) {
            notas[notasCount] = novaNota;
            notasCount++;
            return true;
        } else {
            System.out.println("Não há espaço para adicionar mais notas!");
            return false;
        }
    }

    public boolean addTitulos(String titulo) {
        // Verifica se o título já existe
        for (int i = 0; i < titulosCount; i++) {
            if (titulos[i].equals(titulo)) {
                System.out.println("Esse título já foi adicionado!");
                return false;
            }
        }

        // Adiciona o novo título se houver espaço
        if (titulosCount < titulos.length) {
            titulos[titulosCount] = titulo;
            titulosCount++;
            return true;
        } else {
            System.out.println("Não há espaço para adicionar mais títulos!");
            return false;
        }
    }

    public boolean addAno(int ano) {
        // Verifica se o ano já existe
        for (int i = 0; i < anosCount; i++) {
            if (anos[i] == ano) {
                System.out.println("Esse ano já foi adicionado!");
                return false;
            }
        }

        // Adiciona o novo ano se houver espaço
        if (anosCount < anos.length) {
            anos[anosCount] = ano;
            anosCount++;
            return true;
        } else {
            System.out.println("Não há espaço para adicionar mais anos!");
            return false;
        }
    }

    public String[] getTitulos(){return titulos;}
    public int[] getAnos(){return anos;}
    public notas[] getNotas(){return notas;}


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("baseDados{\n");

        sb.append("  titulos=[");
        for (int i = 0; i < titulosCount; i++) {
            sb.append(titulos[i]);
            if (i < titulosCount - 1) sb.append(", ");
        }
        sb.append("],\n");

        sb.append("  anos=[");
        for (int i = 0; i < anosCount; i++) {
            sb.append(anos[i]);
            if (i < anosCount - 1) sb.append(", ");
        }
        sb.append("],\n");

        sb.append("  notas=[");
        for (int i = 0; i < notasCount; i++) {
            sb.append(notas[i]);
            if (i < notasCount - 1) sb.append(", ");
        }
        sb.append("]\n");

        sb.append("}");
        return sb.toString();
    }
}
