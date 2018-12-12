import java.io.*;
import java.util.ArrayList;


public class GestorAula {
    public ArrayList<String> carrega(String carpeta, String nomFitxer) throws FileNotFoundException, IOException {
        //Carpeta pot ser: Assignatura, Pla Estudis, Aula
        FileReader fr = new FileReader("../../static/Aula/"+ nomFitxer + ".txt");
        ArrayList<String> res = new ArrayList<String>();
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        while (line != null) {
            res.add(line);
            line = br.readLine();
        }
        return res;
    }


    public void guarda(String carpeta, String nomFitxer, ArrayList<String> objectes) throws FileNotFoundException, IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("../../static/" + carpeta + "/"+ nomFitxer + ".txt"));
        writer.write("");

        for (String s : objectes) {
            writer.append(s);
            writer.append("\n");
        }
        writer.close();
    }

    public boolean esborra (String carpeta, String nomFitxer) {
        File file = new File("../../static/" + carpeta + "/"+ nomFitxer + ".txt");
        return file.delete();
    }
}
