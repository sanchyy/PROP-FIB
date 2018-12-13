package Persistencia;
import java.io.*;

public class GestorRequisit {

    public String carrega(String carpeta, String nomFitxer) throws IOException {
        //Carpeta pot ser: Assignatura, Pla Estudis, Aula
        FileReader fr = new FileReader("../../DB/Requisit/"+ nomFitxer + ".txt");
        BufferedReader br = new BufferedReader(fr);
        return  br.readLine();
    }

    public void guarda(String carpeta, String nomFitxer, String json) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("../../DB/Requisit/"+ nomFitxer + ".txt"));
        writer.write(json);
        writer.close();
    }

    public boolean esborra (String nomFitxer) {
        File file = new File("../../DB/Requisit/"+ nomFitxer + ".txt");
        return file.delete();
    }
}
