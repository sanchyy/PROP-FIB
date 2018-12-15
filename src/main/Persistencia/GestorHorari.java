package main.Persistencia;

import java.io.*;

public class GestorHorari {
    public String carrega(String nomFitxer) throws IOException {
        FileReader fr = new FileReader("../../DB/Horari/"+ nomFitxer + ".txt");
        BufferedReader br = new BufferedReader(fr);
        return  br.readLine();
    }

    public void guarda(String nomFitxer, String json) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("../../DB/Horari/"+ nomFitxer + ".txt"));
        writer.write(json);
        writer.close();
    }

    public boolean esborra (String nomFitxer) {
        File file = new File("../../DB/Horari/"+ nomFitxer + ".txt");
        return file.delete();
    }
}
