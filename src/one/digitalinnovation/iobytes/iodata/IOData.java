package one.digitalinnovation.iobytes.iodata;

import java.io.*;
import java.util.Scanner;

public class IOData {

    public static void incluirProduto() throws IOException {
        File f = new File("C:\\workspace\\DIO\\DIO-Java-IO\\peca-de-roupa.bin");

        PrintStream ps = new PrintStream(System.out);
        ps.flush();

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f.getPath()));

        Scanner scan = new Scanner(System.in);

        ps.print("Nome da peça: ");
        String nome = scan.nextLine();
        dos.writeUTF(nome);

        ps.print("Tamanho da peça (P/M/G/U): ");
        char tamanho = (char)System.in.read();
        dos.writeChar(tamanho);

        ps.print("Quantidade: ");
        int quant = scan.nextInt();
        dos.writeInt(quant);

        ps.print("Preço unitário: ");
        double preco = scan.nextDouble();
        dos.writeDouble(preco);

        ps.printf("O arquivo %s foi criado com %d bytes no diretório '%s'.\n",
                f.getName(), f.length(), f.getAbsolutePath());

        lerProduto(f.getPath());

        dos.close();
        scan.close();
        ps.close();
    }

    public static void lerProduto(String caminhoArquivo) throws IOException {
        File f = new File(caminhoArquivo);
        DataInputStream dis = new DataInputStream(new FileInputStream(f.getPath()));
        String nome = dis.readUTF();
        char tamanho = dis.readChar();
        int quantidade = dis.readInt();
        double preco = dis.readDouble();

        System.out.printf("\nNome.................: %s", nome);
        System.out.printf("\nQuantidade...........: %d", quantidade);
        System.out.printf("\nTamanho..............: %s", tamanho);
        System.out.printf("\nPreço................: %.2f", preco);
        System.out.printf("\nTotal do valor das peças: R$ %.2f", quantidade * preco);

        dis.close();
    }

    public static void main(String[] args) throws IOException {
        incluirProduto();
    }
}
