/*
    Esercizio: 10.2
    Descrizione: Costruite un’applicazione che controlli se in un sorgente Java le parentesi graffe aperte sono
    chiuse correttamente (si noti che non è sufficiente controllare che il numero di parentesi graffe aperte sia
    uguale al numero di parentesi graffe chiuse).
 */

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Esercizio10_2 {
    public static void metodo1() throws IOException{
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome file: ");
        String fileName = sc.nextLine();
        FileReader fileReader = new FileReader(fileName);
        */
        FileReader fileReader = new FileReader("C:\\Users\\casul\\Desktop\\Programmazione\\IntelliJ\\Test\\src\\File2.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String linea;
        int counterAperte = 0;
        while((linea = bufferedReader.readLine()) != null){
            for(char c : linea.toCharArray()){
                if(c == '{')
                    counterAperte++;
                else if(c == '}'){
                    if(counterAperte > 0)
                        counterAperte--;
                    else{
                        System.out.println("Errore");
                        System.exit(1);
                    }
                }
            }
        }

        if(counterAperte != 0)
            System.out.println("Errore");
    }

    public static void metodo2() throws IOException{
        /*
        Scanner sc = new Scanner(System.in);
        System.out.println("Nome file: ");
        String fileName = sc.nextLine();
        FileReader fileReader = new FileReader(fileName);
        */
        FileReader fileReader = new FileReader("C:\\Users\\casul\\Desktop\\Programmazione\\IntelliJ\\Test\\src\\File2.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        Stack<Character> parentesi = new Stack<>();
        String linea;
        int ln = 0;
        while((linea = bufferedReader.readLine()) != null){
            ln++;
            for(char c : linea.toCharArray()){
                if(c == '{')
                    parentesi.push('{');
                else if(c == '}'){
                    if(parentesi.empty()){
                        System.out.println("Errore linea: " + ln);
                        return;
                    }
                    parentesi.pop();
                }
            }
        }

        if(!parentesi.empty())
            System.out.println("Errore");
    }

    public static void main(String[] args) throws IOException{
        //metodo1();
        metodo2();
    }
}
