/*
    Capitolo: 9.2
    Descrizione: Definizione di classi generiche e metodi generici
    Esercizio: 9.9: Scrivere un metodo generico statico, da aggiungere alla classe Coppia, che riceva come
    argomento il riferimento a un array di tipo base T, e restituisca il riferimento a una coppia di elementi
    ti tipo T: se l'argomento fornito è null, il metodo dovrà restituire null; se è un array di zero elementi,
    il metodo dovrà restituire una copia formata da due riferimenti null; se è un array di un solo elemento,
    il metodo dovrà restituire una coppia col primo elemento e il secondo null; infine, se ha almeno due elementi,
    dovrà restituire una coppia con i primi due
    Esercizio: 9.11: Scrivere un metodo statico che riceva come parametro una sequenza di oggetti di un tipo che
    implementa Comparable e restituisca il minimo
 */

import prog.utili.Sequenza;

public class Coppia<E, F> {
    //Variabili
    private E sinistro;
    private F destro;
    private static int nCoppie = 0;

    //Costruttore
    public Coppia(E e, F f){
        sinistro = e;
        destro = f;
        nCoppie++;
    }

    //Metodi
    public E getSinistro(){
        return sinistro;
    }

    public F getDestro(){
        return destro;
    }

    public String toString(){
        return "(" + sinistro + ", " + destro + ")";
    }

    public boolean equals(Coppia altra){
        return this.sinistro == altra.sinistro && this.destro == altra.destro;
    }

    //Metodi statici
    public static int numeroCoppie(){
        return nCoppie;
    }

    //Metodi generici
    public static <T> Coppia<T, T> creaIdentica(T t){
        return new Coppia<T, T>(t, t);
    }

    //<T extends Comparable<? super T> così da ereditare e poter usare il metodo .compareTo()
    public static <T extends Comparable<? super T>> int contaMinoriDi(Sequenza<T> s, T t){
        int n = 0;
        for(T o : s)
            if(o.compareTo(t) < 0)
                n++;
        return n;
    }

    //Esercizio 9.9
    public static <T> Coppia<T, T> coppiaDaArray(T[] a){
        if(a == null)
            return null;
        else if(a.length == 0)
            return new Coppia<>(null, null);
        else if(a.length == 1)
            return new Coppia<>(a[0], null);
        else
            return new Coppia<>(a[0], a[1]);
    }

    //Esercizio 9.11
    public static <T extends Comparable<? super T>> T trovaMinimo(Sequenza<T> s){
        T minimo = null;
        for(T o : s) {
            if (minimo == null)
                minimo = o;
            else if(o.compareTo(minimo) < 0)
                minimo = o;
        }

        return minimo;
    }
}
