package main.Persistencia;
import java.io.*;
import java.util.ArrayList;


public class GestorPlaEstudis {

    public String carrega(String carpeta, String nomFitxer) throws IOException {
        //Carpeta pot ser: Assignatura, Pla Estudis, Aula
        FileReader fr = new FileReader("./DB/PlaEstudis/"+ nomFitxer + ".txt");
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        System.out.println(line);
        return line;
    }

    public ArrayList<Domini.PlaEstudis> agafa() {
        try {
            String linea = carrega("", "pe");
            return new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void guarda(String carpeta, String nomFitxer, String json) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("PlaEstudis/" + nomFitxer + ".txt"));
        writer.write(json);
        writer.close();
    }

    public boolean esborra (String nomFitxer) {
        File file = new File("PlaEstudis/" + nomFitxer + ".txt");
        return file.delete();
    }
}
