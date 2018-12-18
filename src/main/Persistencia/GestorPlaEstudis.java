package main.Persistencia;
import java.io.*;
import java.util.ArrayList;


public class GestorPlaEstudis {

    public String carrega(String nomFitxer) throws IOException {
        //Carpeta pot ser: Assignatura, Pla Estudis, Aula
        FileReader fr = new FileReader("./DB/PlaEstudis/"+ nomFitxer + ".txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        System.out.println(line);
        return line;
    }

    public ArrayList<Domini.PlaEstudis> agafa() throws IOException {

        String linea = carrega("pe");
        return new ArrayList<>();
    }

    public void guarda(String nomFitxer, String json) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("PlaEstudis/" + nomFitxer + ".txt"));
        writer.write(json);
        writer.close();
    }

    public boolean esborra (String nomFitxer) {
        File file = new File("PlaEstudis/" + nomFitxer + ".txt");
        return file.delete();
    }

    public ArrayList<String> llistaPlaEstudis() {
        ArrayList<String> res = new ArrayList<String>();
        final File folder = new File ("../../../DB/PlaEstudis");

        File[] fold = folder.listFiles();
        if (fold == null) throw new NullPointerException();
        for (int i = 0; i < fold.length; ++i) {
            res.add(fold[i].getName());
        }
        return res;
    }
}
