package Persistencia;

import java.io.*;
import java.util.ArrayList;

public class UtilsDisc {
    String database = "./DB/";

    public ArrayList<String> carrega(String path) throws IOException {
        FileReader fr = new FileReader(path);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> lineas = new ArrayList<>();
        String linea;
        while ((linea = br.readLine()) != null) {
            lineas.add(linea);
        }
        br.close();
        return lineas;
    }

    public void guardaMultiple(String path, ArrayList<String> jsons) throws IOException {
        FileWriter fw = new FileWriter(database + path);
        BufferedWriter bw = new BufferedWriter(fw);
        for (String json : jsons) {
            bw.write(json + "\n");
        }
        bw.close();
    }

}
