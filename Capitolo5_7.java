/*
Dimostrazione utilizzo Sequenza<E>
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Sequenza;

public class Capitolo5_7 {

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        Sequenza<String> mem = new Sequenza<String>();
        String input = in.readLine();
        while(!input.equals("")){
            mem.add(input);
            input = in.readLine();
        }

        for(String stringa : mem)
            out.println(stringa);
    }
}
