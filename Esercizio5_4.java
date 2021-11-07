/*
Utilizzando la classe Insieme e la classe Character, scrivete un'applicazione che legga due stringhe
e visualizzi l'insieme dei caratteri che appaiono in almeno una delle due stringhe e
un elenco dei caratteri che appaiono in entrambe le stringhe.
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;
import prog.utili.Insieme;

public class Esercizio5_4 {

    static Insieme<Character> stringToSet(String s){
        Insieme<Character> set = new Insieme<Character>();
        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
        }
        return set;
    }

    static Insieme<Character> unione(Insieme<Character> set1, Insieme<Character> set2){
        Insieme<Character> unione = new Insieme<Character>();
        for(Character c : set1)
            unione.add(c);
        for(Character c : set2)
            unione.add(c);

        return unione;
    }

    static Insieme<Character> intersezione(Insieme<Character> set1, Insieme<Character> set2){
        Insieme<Character> intersezione = new Insieme<Character>();
        for(Character c : set2){
            if(!set1.add(c))
                intersezione.add(c);
        }

        return intersezione;
    }

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        Insieme<Character> s1 = stringToSet(in.readLine("String 1: "));
        Insieme<Character> s2 = stringToSet(in.readLine("String 2: "));

        out.println("Unione: " + unione(s1, s2));
        out.println("Intersezione: " + intersezione(s1, s2));


    }
}
