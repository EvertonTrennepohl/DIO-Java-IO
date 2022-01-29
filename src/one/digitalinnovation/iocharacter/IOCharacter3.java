package one.digitalinnovation.iocharacter;

import java.io.*;

public class IOCharacter3 {

    public static void copiarArquivo() throws IOException {
        File f = new File("C:\\workspace\\DIO\\DIO-Java-IO\\filmes.txt");
        String nameArquivo = f.getName();
        /*
        Reader reader = new FileReader(nameArquivo);
        BufferedReader br = new BufferedReader(reader);
        */
        BufferedReader br = new BufferedReader(new FileReader(nameArquivo));
        String line = br.readLine();

        String nameArquivoCopy = nameArquivo.substring(0, nameArquivo.indexOf(".")).concat("copy.txt");
        File fcopy = new File(nameArquivoCopy);

        BufferedWriter bw = new BufferedWriter(new FileWriter(fcopy.getName()));

        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = br.readLine();
        }while(line != null);
        System.out.printf("Arquivo \"%s\" copiado com sucesso! Com o tamanho '%d' bytes.\n", f.getName(), f.length());
        System.out.printf("Arquivo \"%s\" criado com sucesso! Com o tamanho '%d' bytes.\n", fcopy.getName(), fcopy.length());
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Recomende 3 livros: ");
        pw.flush();

        adicionarInfoNoArquivo(fcopy.getName());

        pw.printf("Ok! Tudo certo. Tamanho do arquivo %d bytes.", fcopy.length());

        br.close();
        bw.close();
        pw.close();
    }

    public static void adicionarInfoNoArquivo(String arquivo) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));
        bw.newLine();
        bw.write("Livros:");
        bw.newLine();
        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = br.readLine();
        }while(!line.equalsIgnoreCase("fim"));
    }

    public static void main (String[] args) throws IOException {
        copiarArquivo();
    }
}
