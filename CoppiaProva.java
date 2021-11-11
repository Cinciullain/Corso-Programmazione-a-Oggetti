/*
    Capitolo: 9.2
    Descrizione: Test classe Coppia
 */

import prog.io.ConsoleOutputManager;
import prog.utili.Data;
import prog.utili.Sequenza;

public class CoppiaProva {
    public static void main(String[] args) {
        ConsoleOutputManager out = new ConsoleOutputManager();
        out.println("Coppie: " + Coppia.numeroCoppie());

        Data d = new Data(22, 1, 2005);
        Orario o = new Orario(23,33);

        Coppia<Data, Orario> tempo = new Coppia<>(d, o);
        Coppia<Data, Orario> adesso = new Coppia<>(new Data(), new Orario());

        out.println("Tempo: " + tempo);
        out.println("Adesso: " + adesso);
        out.println("Coppie: " + Coppia.numeroCoppie());

        Coppia<String, Integer> x = new Coppia<>("Pippo", 4);
        out.println("X: " + x);
        out.println("Coppie: " + Coppia.numeroCoppie());

        //Test metodo generico
        Coppia.creaIdentica("Pippo");
        Coppia.creaIdentica(10);
        Coppia.creaIdentica(new Data());

        //Test coppiaDaArray
        out.println(Coppia.coppiaDaArray(null));
        String[] array1 = new String[0];
        out.println(Coppia.coppiaDaArray(array1));
        String[] array2 = {"pippo", null};
        out.println(Coppia.coppiaDaArray(array2));
        String[] array3 = {"pippo", "paolo"};

        //Test trovaMinimo
        Sequenza<Integer> seqInteri = new Sequenza<>();
        seqInteri.add(11);
        seqInteri.add(5);
        seqInteri.add(20);
        seqInteri.add(19);
        seqInteri.add(14);
        out.println(Coppia.trovaMinimo(seqInteri));
    }
}
