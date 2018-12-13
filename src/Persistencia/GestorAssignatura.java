package Persistencia;
import java.io.*;

public class GestorAssignatura {

    public String carrega(String carpeta, String nomFitxer) throws IOException {
        //Carpeta pot ser: Assignatura, Pla Estudis, Aula
        FileReader fr = new FileReader("../../DB/Assignatura/"+ nomFitxer + ".txt");
        BufferedReader br = new BufferedReader(fr);
        return  br.readLine();
    }

    public void guarda(String carpeta, String nomFitxer, String json) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("../../DB/Assignatura/"+ nomFitxer + ".txt"));
        writer.write(json);
        writer.close();
    }

    public boolean esborra (String nomFitxer) {
        File file = new File("../../DB/Assignatura/"+ nomFitxer + ".txt");
        return file.delete();
    }
}
