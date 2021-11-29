/*
    Esercizio: 11.2
    Descrizione: Scrivere una classe Prodotto che rappresenta un generico prodotto acquistabile su uno specifico
    store online. La classe deve avere almeno i campi privati che memorizzano: un numero intero che rappresenta un
    identificativo univoco, un nome, un prezzo (di tipo Importo). Inoltre la classe ha il costruttore
    Prodotto(int codice, String nome, Importo prezzo) e i metodi String getNome(), Importo getImporto(),
    int getCodice(), String toString(), con ovvio significato (la classe Importo è quella già usata nel corso).
    Si implementi inoltre una classe Carrello che contiene tra i suoi campi privati un elenco di riferimenti
    ad oggetti di tipo Prodotto. La classe Carrello ha il costruttore Carrello() e i metodi:
        • void aggiungiProdotto(Prodotto p) [aggiunge il prodotto rappresentato dal riferimento p]
        • void rimuoviProdotto(Prodotto p) [elimina il prodotto p se esistente nel carrello e solleva un’eccezione
          non controllata di tipo ProductNotPresent altrimenti]
        • Prodotto[] lista() [restituisce un array dei prodotti presenti nel carrello]
        • Importo totale() [restituisce l’importo complessivo corrispondente ai prodotti nel carrello]
    Scrivere infine una classe di prova per le classi Prodotto e Carrello.
 */

import prog.utili.Importo;

public class Prodotto {
    private int idProdotto;
    private String nomeProdotto;
    private Importo prezzoProdotto;

    public Prodotto(int id, String n, Importo p){
        idProdotto = id;
        nomeProdotto = n;
        prezzoProdotto = p;
    }

    public int getIdProdotto() {
        return idProdotto;
    }

    public String getNomeProdotto() {
        return nomeProdotto;
    }

    public Importo getPrezzoProdotto() {
        return prezzoProdotto;
    }

    public String toString(){
        return "ID: " + idProdotto + "\nNome: " + nomeProdotto + prezzoProdotto.toString();
    }
}
