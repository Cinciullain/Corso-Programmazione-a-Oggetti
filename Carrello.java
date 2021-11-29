/*
    Esercizio: 11.2
    Descrizione: Scrivere una classe Prodotto che rappresenta un generico prodotto acquistabile su uno specifico
    store online. La classe deve avere almeno i campi privati che memorizzano: un numero intero che rappresenta un
    identificativo univoco, un nome, un prezzo (di tipo Importo). Inoltre la classe ha il costruttore
    Prodotto(int codice, String nome, Importo prezzo) e i metodi String getNome(), Importo getImporto(),
    int getCodice(), String toString(), con ovvio significato (la classe Importo è quella già usata nel corso).
    Si implementi inoltre una classe Carrello che contiene tra i suoi campi privati un elenco di riferimenti
    ad oggetti di tipo Prodotto.
    La classe Carrello ha il costruttore Carrello() e i metodi:
        • void aggiungiProdotto(Prodotto p) [aggiunge il prodotto rappresentato dal riferimento p]
        • void rimuoviProdotto(Prodotto p) [elimina il prodotto p se esistente nel carrello e solleva un’eccezione
          non controllata di tipo ProductNotPresent altrimenti]
        • Prodotto[] lista() [restituisce un array dei prodotti presenti nel carrello]
        • Importo totale() [restituisce l’importo complessivo corrispondente ai prodotti nel carrello]
    Scrivere infine una classe di prova per le classi Prodotto e Carrello.
 */

import prog.utili.Importo;

import java.util.ArrayList;

public class Carrello {
    ArrayList<Prodotto> spesa;

    public Carrello(){
        spesa = new ArrayList<Prodotto>();
    }

    public Carrello(ArrayList<Prodotto> sp){
        spesa = new ArrayList<Prodotto>(sp);
    }

    public void aggiungiProdotto(Prodotto p){
        if(spesa.add(p))
            System.out.println("Prodotto aggiunto");
        else
            System.out.println("Prodotto non aggiunto");
    }

    public Prodotto[] lista(){
        if(spesa.size() > 0)
            return (Prodotto[]) spesa.toArray();
        else {
            System.out.println("Lista vuota");
            return null;
        }
    }

    public void rimuoviProdotto(Prodotto p){
        if(spesa.contains(p)) {
            System.out.println("Prodotto: " + p.toString() + " rimosso");
            spesa.remove(p);
        }
    }

    public Importo totale(){
        Importo totale = new Importo(0);
        if(this.spesa.isEmpty());
        else{
            for(Prodotto p : spesa)
                totale.piu(p.getPrezzoProdotto());
        }
        return totale;
    }
}
