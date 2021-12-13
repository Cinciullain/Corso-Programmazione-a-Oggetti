/*
    Esercizio: 7.3
    Descrizione: Gestire opportunamente tutte le eccezioni del programma seguente, stampando
    i messaggi di errore che descrivono il tipo di errore che si è verificato
 */

import prog.io.ConsoleInputManager;

public class Esercizio7_3 {
    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();

        int n = 10;
        int[] v = new int[n];

        int i = 0;

        try {
            String linea = in.readLine("Inserire un intero: ");
            while (!linea.equals("")) {
                v[i] = Integer.parseInt(linea);
                linea = in.readLine("Inserire un intero: ");
                i++;
            }
        }catch (NullPointerException e){
            System.out.println("Nullo");
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Fuori dal array");
        }
        catch (NumberFormatException e){
            System.out.println("Formato invalido");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
