package one.digitalinnovation.iocharacter;

import java.io.*;
import java.util.Scanner;

public class IOCharacter2 {

    public static void lerTecladoEscreverDocumento() throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Digite 3 filmes: ");
        pw.flush();

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        File f = new File("filmes.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName()));
        bw.write("Filmes:");
        bw.newLine();

        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = scan.nextLine();
        } while(!line.equalsIgnoreCase("fim"));

        pw.printf("Arquivo \"%s\" foi criado com sucesso!", f.getName());

        pw.close();
        scan.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        lerTecladoEscreverDocumento();
    }

}
