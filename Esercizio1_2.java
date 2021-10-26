/*
    Prima stringa? cane
    Seconda stringa? bovino
    Ordine alfabetico:
            bovino
            cane
    Ordine di lunghezza:
            cane
            bovino
*/

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

public class Esercizio1_2 {

    public static void main(String[] args) {
        ConsoleOutputManager out = new ConsoleOutputManager();
        ConsoleInputManager in = new ConsoleInputManager();

        String st1, st2;
        st1 = in.readLine("Prima stringa? ");
        st2 = in.readLine("Seconda stringa? ");

        out.println("Ordine alfabetico: ");
        if(st1.compareTo(st2) < 0){
            out.println(st1);
            out.println(st2);
        }
        else{
            out.println(st2);
            out.println(st1);
        }

        out.println("Ordine lunghezza: ");
        if(st1.length() < st2.length()){
            out.println(st1);
            out.println(st2);
        }
        else{
            out.println(st2);
            out.println(st1);
        }

    }
}
