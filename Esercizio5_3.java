/*
Scrivete un'applicazione che legga una sequenza di frazioni e, successivamente, una frazione g.
L'applicazione deve comunicare:
1) la più grande frazione della sequenza che risulti minore di g;
2) la più piccola frazione della sequenza che risulti maggiore di g
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Frazione;
import prog.utili.Sequenza;

public class Esercizio5_3 {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        Sequenza<Frazione> seq = new Sequenza<Frazione>();
        Frazione input;
        int nFrazioni = in.readInt("Numero frazioni: ");
        for(int i = 0; i < nFrazioni; i++) {
            input = new Frazione(in.readInt("Numeratore: "), in.readInt("Denominatore: "));
            seq.add(input);
        }

        out.println("Inserisci frazione g");
        input = new Frazione(in.readInt("Numeratore: "), in.readInt("Denominatore: "));

        //Calcolo maggiore della seq ma minore di g
        Frazione maxMin = null;
        for(Frazione f : seq){
            if(maxMin == null || (f.isMaggiore(maxMin) && f.isMinore(input)))
                maxMin = f;
        }
        out.println(maxMin);

        //Calcolo minore della seq ma maggiore di g
        Frazione minMax = null;
        for(Frazione f : seq){
            if(minMax == null || (f.isMinore(maxMin) && f.isMaggiore(input)))
                minMax = f;
        }
        out.println(minMax);
    }
}
