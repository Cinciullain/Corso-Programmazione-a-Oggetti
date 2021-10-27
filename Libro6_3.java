/*
Indicare output programma
 */

import prog.utili.Quadrato;
import prog.utili.Rettangolo;

public class Libro6_3 {

    public static void main(String[] args) {

        Rettangolo r = null;
        System.out.println(r instanceof Rettangolo); //False
        System.out.println(r instanceof Quadrato); //False
        r = new Quadrato(1);
        System.out.println(r instanceof Rettangolo); //True
        System.out.println(r instanceof Quadrato); //True
        r = new Rettangolo(1, 1);
        System.out.println(r instanceof Rettangolo); //True
        System.out.println(r instanceof Quadrato); //False
    }
}
