/*
    I/O su file
 */

import prog.io.ConsoleInputManager;
import prog.io.FileInputManager;
import prog.io.FileOutputManager;

import java.io.File;

public class Capitolo6_10 {

    public static void main(String[] args) {

        ConsoleInputManager in = new ConsoleInputManager();

        String nomeFile = in .readLine("Nome file ingresso: ");
        FileInputManager ingresso = null;
        if(FileInputManager.exists(nomeFile))
            ingresso = new FileInputManager(nomeFile);
        else
            System.exit(0);

        nomeFile = in.readLine("Nome file uscita:");
        FileOutputManager output = new FileOutputManager(nomeFile);

        String riga;
        while((riga = ingresso.readLine()) != null)
            output.println(riga);

        ingresso.close();
    }
}
