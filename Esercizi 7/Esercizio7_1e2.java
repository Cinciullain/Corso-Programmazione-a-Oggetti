/*
    Esercizio: 7.1
    Descrizione: Implementare l’applicazione per il calcolo di espressioni aritmetiche in notazione postfissa
    nella forma in cui è illustrata nelle slides della lezione
    Esercizio: 7.2
    Descrizione: Usare il metodo split di String
 */

import prog.io.ConsoleInputManager;
import prog.io.ConsoleOutputManager;

import java.util.Stack;

public class Esercizio7_1e2 {

    static int operazione(int x, int y, char op) throws ArithmeticException, Exception{
        switch (op){
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '/':
                return x / y;
            case '*':
                return x * y;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        ConsoleInputManager in = new ConsoleInputManager();
        ConsoleOutputManager out = new ConsoleOutputManager();

        Stack<Integer> pila = new Stack<>();
        String input = in.readLine("Inserisci intera riga");
        String[] splitted = input.split("\\s");
        try {
            for (String c : splitted) {
                switch (c) {
                    case "+":
                    case "-":
                    case "/":
                    case "*":
                        pila.push(operazione(pila.pop(), pila.pop(), c.charAt(0)));
                        break;
                    default:
                        pila.push(Integer.parseInt(c));
                        break;
                }
            }

            System.out.println("Risultato: " + pila.pop());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
