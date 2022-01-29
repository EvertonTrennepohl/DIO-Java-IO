package one.digitalinnovation.iobytes.ioobject;

import java.io.*;

public class IOObject {

    public static void serealizacao() throws IOException {
        Cachorro cachorro = new Cachorro("Kiron", 8, "Preto, Branco, Marrom");

        File f = new File("cachorro");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f.getName()));

        oos.writeObject(cachorro);

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo \"%s\" criado com sucesso! Tamanho '%d' bytes.", f.getName(), f.length());

        oos.close();
        ps.close();
    }

    public static void desserealizacao(String arquivo) {

    }

    public static void main(String[] args) throws IOException {
        serealizacao();
    }
}
