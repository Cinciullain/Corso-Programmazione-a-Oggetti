import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Frazione;

/*
    Scrivere una applicazione che, letta da tastiera una sequenza di frazioni
    dove il numero di elementi della sequenza è stabilito dall'utente, produce
    in output la sequenza di frazioni in ordine crescente.
 */
public class Libro5_5 {
    public static void main(String[] args) {

        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        int input = in.readInt("Lunghezza array: ");
        Frazione[] frazioni = new Frazione[input];
        int i;
        for(i = 0; i < input; i++)
            frazioni[i] =  new Frazione(in.readInt("Numeratore"),in.readInt("Denominatore"));

        Frazione tmp;
        int j, min;
        for(i = 0; i < input; i++){
            min = i;
            for(j = i + 1; j < input; j++){
                if(frazioni[j].isMinore(frazioni[min])){
                    tmp = frazioni[min];
                    frazioni[min] = frazioni[j];
                    frazioni[j] = tmp;
                }
            }
        }

        for(Frazione f : frazioni)
            out.println(f.toString());
    }
}
