package main.Persistencia;
import java.io.*;
import java.util.ArrayList;

public class GestorRestriccio {

    public String carrega(String nomFitxer) throws IOException {
        //Carpeta pot ser: Assignatura, Pla Estudis, Aula
        FileReader fr = new FileReader("DB/Restriccio/" + nomFitxer + ".txt");
        BufferedReader br = new BufferedReader(fr);
        return  br.readLine();
    }

    public void guarda(String nomFitxer, String json) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("DB/Restriccio/" + nomFitxer + ".txt"));
        writer.write(json);
        writer.close();
    }

    public boolean esborra (String nomFitxer) {
        File file = new File("DB/Restriccio/" + nomFitxer + ".txt");
        return file.delete();
    }

    public ArrayList<String> llistaRestriccio() {
        ArrayList<String> res = new ArrayList<String>();
        final File folder = new File ("../../../DB/Restriccio");

        File[] fold = folder.listFiles();
        if (fold == null) throw new NullPointerException();
        for (int i = 0; i < fold.length; ++i) {
            res.add(fold[i].getName());
        }
        return res;
    }
}
