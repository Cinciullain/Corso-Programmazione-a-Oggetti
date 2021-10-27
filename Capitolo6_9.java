/*
Uso Sequenza ed ereditarietà
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.*;

public class Capitolo6_9 {

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        Sequenza<Figura> figure = new Sequenza<Figura>();

        Figura f = null;
        double x, y;
        char scelta;

        do{
            out.println("Scelte: Rettangolo, Quadrato, Cerchio, Fine. (r/q/c/f)");
            scelta = in.readChar("Scelta? ");

            //Inserimento figura
            boolean inserita = false;
            switch(scelta){
                case 'r':
                    out.println("Rettangolo");
                    x = in.readDouble("Base? ");
                    y = in.readDouble("Altezza? ");
                    if(x < 0 || y < 0)
                        out.println("Dati errati");
                    else{
                        f = x == y ? new Quadrato(x) : new Rettangolo(x, y);
                        inserita = true;
                    }
                    break;
                case 'q':
                    out.println("Quadrato");
                    x = in.readDouble("Lato? ");
                    if(x < 0)
                        out.println("Dati errati");
                    else{
                        f = new Quadrato(x);
                        inserita = true;
                    }
                    break;
                case 'c':
                    out.println("Cerchio");
                    x = in.readDouble("Raggio? ");
                    if(x < 0)
                        out.println("Dati errari");
                    else{
                        f = new Cerchio(x);
                        inserita = true;
                    }
                    break;
                case 'f':
                default:
                    out.println("Fine");
                    break;
            }

            if(inserita){
                out.println(f.toString());
                out.println("Area: " + f.getArea());
                out.println("Perimetro: " + f.getPerimetro());

                figure.add(f);
            }
        }while(in.readSiNo("Continuare (s/n)"));

        out.println("Elenco Cerchi: ");
        for(Figura a : figure)
            if(a instanceof Cerchio)
                out.println(a.toString());

        out.println("Elenco Quadrati: ");
        for(Figura a : figure)
            if(a instanceof Quadrato)
                out.println(a.toString());

        out.println("Elenco Rettangoli: ");
        for(Figura a : figure)
            if(a instanceof Rettangolo && !(a instanceof Quadrato))
                out.println(a.toString());
    }
}
