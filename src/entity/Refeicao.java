package entity;

public class Refeicao {

    private String nome;
    private String adjetivo;

    public Refeicao() {
    }

    public Refeicao(String nome, String adjetivo) {
        this.nome = nome;
        this.adjetivo = adjetivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAdjetivo() {
        return adjetivo;
    }

    public void setAdjetivo(String adjetivo) {
        this.adjetivo = adjetivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Refeicao refeicao = (Refeicao) o;

        if (nome != null ? !nome.equals(refeicao.nome) : refeicao.nome != null) return false;
        return adjetivo != null ? adjetivo.equals(refeicao.adjetivo) : refeicao.adjetivo == null;
    }

    @Override
    public int hashCode() {
        int result = nome != null ? nome.hashCode() : 0;
        result = 31 * result + (adjetivo != null ? adjetivo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Refeicao{" +
                "nome='" + nome + '\'' +
                ", adjetivo='" + adjetivo + '\'' +
                '}';
    }
}