package one.digitalinnovation.iobytes.ioobject;

import java.io.Serializable;

public class Cachorro implements Serializable {

    private static final long serialVersionUID = 2L;
    private String nome;
    private int idade;
    private String cor;
    private boolean preso;

    public boolean isVacinado() {
        return vacinado;
    }

    public void setVacinado(boolean vacinado) {
        this.vacinado = vacinado;
    }

    private transient boolean vacinado;

    public Cachorro() {
    }

    public Cachorro(String nome, int idade, String cor, boolean preso, boolean vacinado) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
        this.preso = preso;
        this.vacinado = vacinado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public boolean isPreso() {
        return preso;
    }

    public void setPreso(boolean preso) {
        this.preso = preso;
    }

    @Override
    public String toString() {
        return "Cachorro{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                ", preso=" + preso + '\'' +
                ", vacinado=" + vacinado +
                '}';
    }
}
