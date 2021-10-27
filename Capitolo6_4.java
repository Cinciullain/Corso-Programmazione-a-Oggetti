/*
    Utilizzo instanceof ed ereditarietà
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Quadrato;
import prog.utili.Rettangolo;

public class Capitolo6_4 {

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        Rettangolo r, rAreaMax = null;
        double x, y;

        //Legge dati figura
        do{
            out.println("Inserisci dati figura");
            x = in.readDouble("Base: ");
            y = in.readDouble("Altezza: ");
            if(x < 0 || y < 0)
                out.print("Dati sbagliati");
            else{
                if(x == y){
                    r = new Quadrato(x);
                    out.println("Quadrato");
                }else{
                    r = new Rettangolo(x, y);
                    out.println("Rettangolo");
                }

                out.println(r.toString());
                out.println("Area: " + r.getArea());
                out.println("Perimetro: " + r.getPerimetro());

                if(rAreaMax == null || r.haAreaMaggiore(rAreaMax))
                    rAreaMax = r;
            }
        }while(in.readSiNo("Altra figura? (s/n): "));

        if(rAreaMax == null)
            out.println("Figura non inserita");
        else{
            out.print("Figura area maggiore: ");
            if(rAreaMax instanceof Quadrato)
                out.println("Quadrato");
            else
                out.println("Rettangolo");

            out.println(rAreaMax.toString());
            out.println("Area: " + rAreaMax.getArea());
            out.println("Perimetro: " + rAreaMax.getPerimetro());
        }
    }
}
