//Dimostrazione for-each

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

public class ArrayString {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        String[] array = {"cane", "gatto", "elefante"};
        for(String s: array){
            out.println("Stringa: " + s);
            s = in.readLine("Nuova Stringa? ");
            out.println("Nuova stringa: " + s);
        }

        out.println("Contenuto array");
        for(String s: array)
            out.println(s);
    }
}
