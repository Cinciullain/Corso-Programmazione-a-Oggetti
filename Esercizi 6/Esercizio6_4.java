/*
    Esercizio 6.4
    Descrizione: Scrivere un’applicazione che legge una sequenza indefinita di figure geometriche (classe Figura)
     e quindi:
     1) le elenca in output organizzate per tipo (ad esempio prima tutti i quadrati, poi tutti i rettangoli etc.)
     2) indica la figura con area più vicina a quella media, specificandone l’area, il tipo e le caratteristiche
     geometriche (es. il raggio se cerchio, base ed altezza se rettangolo etc.).
     Si suggerisce di utilizzare una classe collezione (ad esempio ArrayList<Figura>) sfruttando il fatto che un
     oggetto di superclasse può sempre essere usato per riferirsi ad oggetti di sue sottoclassi.
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.*;

import java.util.ArrayList;

public class Esercizio6_4 {

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        ArrayList<Figura> figure = new ArrayList<>();
        Figura nuovaFigura;

        int numeroFigure = in.readInt("Numero figure: ");
        int i = 0;
        char figura; //Figura selezionata
        do{
            figura = in.readChar("Figura? c/r/q/t ");
            switch(figura){
                case 'c': //Inserisco cerchio nella lista
                    nuovaFigura = new Cerchio(in.readInt("Raggio: "));
                    figure.add(nuovaFigura);
                    if(figure.size() == (i+1))
                        i++;
                    break;
                case 'r': //Inserisco rettangolo nella lista
                    nuovaFigura = new Rettangolo(in.readInt("Base: "), in.readInt("Altezza: "));
                    figure.add(nuovaFigura);
                    if(figure.size() == (i+1))
                        i++;
                    break;
                case 'q': //Inserisco quadrato nella lista
                    nuovaFigura = new Quadrato(in.readInt("Lato: "));
                    figure.add(nuovaFigura);
                    if(figure.size() == (i+1))
                        i++;
                    break;
                case 't': //Inserisco triangolo nella lista
                    nuovaFigura = new Triangolo(in.readDouble("Base: "), in.readDouble("Lato: "), in.readDouble("Angolo: "));
                    figure.add(nuovaFigura);
                    if(figure.size() == (i+1))
                        i++;
                    break;
                default: //In caso di carattere errato inserito
                    out.println("Carattere errato");
            }
        }while(i < numeroFigure);

        //Calcolo area media
        double media = 0.0;
        for(Figura a : figure)
            media += a.getArea();
        media /= numeroFigure;

        //Trovo la figura con area maggiore fra tutte quelle minori della media
        Figura vicina = null;
        for(Figura a : figure) {
            if(vicina == null){
                if(a.getArea() < media)
                    vicina = a;
            }
            else if ((a.haAreaMaggiore(vicina) && a.getArea() < media))
                vicina = a;
        }

        //Stampo la figura e l'area più vicina calcolata prima
        if(vicina instanceof Cerchio)
            out.println("Cerchio: " + vicina.getArea() + vicina);
        else if(vicina instanceof Quadrato)
            out.println("Quadrato: " + vicina.getArea() + vicina);
        else if(vicina instanceof Rettangolo)
            out.println("Rettangolo: " + vicina.getArea() + vicina);
        else
            out.println("Triangolo: " + vicina.getArea() + vicina);
    }
}
