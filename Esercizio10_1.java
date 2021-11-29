/*
    Esercizio: 10.1
    Descrizione: Il comando wc di UNIX (word count) conta il numero di righe, di parole e di caratteri presento in
    un file di testo. Costruite un programma che abbia le stesse funzionalità e che produca l’output su un file
    e su schermo.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Esercizio10_1 {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(System.in);
        //System.out.println("Nome file: ");
        //String fileName = sc.nextLine();
        FileReader fileReader = new FileReader("C:\\Users\\casul\\Desktop\\Programmazione\\IntelliJ\\Test\\src\\File2.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linea;
        int ln = 0, wd = 0, c = 0;
        StringTokenizer tkn;
        while((linea = bufferedReader.readLine()) != null){
            ln++;
            tkn = new StringTokenizer(linea);
            while(tkn.hasMoreTokens()){
                wd++;
                c += tkn.nextToken().length();
            }
        }

        System.out.println("Linee: " + ln + " Words: " + wd + " Char: " + c);
    }
}
