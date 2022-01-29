package one.digitalinnovation.iobytes.ioobject;

import java.io.*;

public class IOObject {

    public static void serealizacao() throws IOException {
        Cachorro cachorro = new Cachorro("Kiron", 8, "Preto, Branco, Marrom", true, true);

        File f = new File("cachorro");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f.getName()));

        oos.writeObject(cachorro);

        PrintStream ps = new PrintStream(System.out);
        ps.printf("Arquivo \"%s\" criado com sucesso! Tamanho '%d' bytes.", f.getName(), f.length());

        oos.close();
        ps.close();
    }

    public static void desserealizacao(String arquivo) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo));
        Cachorro objectCachorro = (Cachorro) ois.readObject();

        System.out.printf("\nNome......................: %s", objectCachorro.getNome());
        System.out.printf("\nIdade.....................: %d", objectCachorro.getIdade());
        System.out.printf("\nCor.......................: %s", objectCachorro.getCor());
        System.out.printf("\nPreso.....................: %s\n", objectCachorro.isPreso());
        System.out.printf("\nVacinado..................: %s\n", objectCachorro.isVacinado());

        System.out.println(objectCachorro);
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //serealizacao();
        desserealizacao("C:\\workspace\\DIO\\DIO-Java-IO\\cachorro");
    }
}
