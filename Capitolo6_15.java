/*
    Sequenza<?>
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Sequenza;

import java.util.Iterator;

public class Capitolo6_15 {

    public static void main(String[] args) {

        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        char scelta = in.readChar("double, integer, string (d/i/s)?");
        while(scelta != 'd' && scelta != 'i' && scelta != 's'){
            out.println("Scelta non valida, ripetere");
            scelta = in.readChar("(d/i/s)");
        }

        Sequenza<?> seq = null;
        Sequenza<Double> sd;
        Sequenza<Integer> si;
        Sequenza<String> ss;

        double d;
        int i;
        String s;
        switch(scelta){
            case 'd':
                sd = new Sequenza<Double>();
                while((d = in.readDouble("Inserisci double, 0 per terminare")) != 0 )
                    sd.add(d);
                seq = sd;
                break;
            case 'i':
                si = new Sequenza<Integer>();
                while((i = in.readInt("Inserisci int, 0 per terminare")) != 0 )
                    si.add(i);
                seq = si;
                break;
            case 's':
                ss = new Sequenza<String>();
                while(!(s = in.readLine("Inserisci Stringa, 0 per terminare")).equals(""))
                    ss.add(s);
                seq = ss;
                break;
        }

        for(Object o : seq)
            out.println(o);

        //Stampa oggetto centrale
        if(!seq.isEmpty()){
            Iterator<?> elenco = seq.iterator();
            Object centrale = elenco.next();
            for(int c = 0; c < seq.size() / 2; c++)
                centrale  = elenco.next();
            out.println("Elemento centrale: " + centrale);
        }
    }
}
