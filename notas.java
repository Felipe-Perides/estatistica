public class notas {
    private double notaG;
    private double notaA;
    private double notaIMDB;

    public notas(double nota1, double nota2, double nota3) {
        this.notaG = nota1;
        this.notaA = nota2;
        this.notaIMDB = nota3;
    }

    public double getNota1() {
        return notaG;
    }

    public double getNota2() {
        return notaA;
    }

    public double getNota3() {
        return notaIMDB;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        notas other = (notas) obj;
        return notaG == other.notaG &&
               notaA == other.notaA &&
               notaIMDB == other.notaIMDB;
    }
    @Override
    public String toString() {
        return "notas{" +
                "notaG=" + notaG +
                ", notaA=" + notaA +
                ", notaIMDB=" + notaIMDB +
                '}';
    }
}
