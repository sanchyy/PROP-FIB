package Persistencia;

import com.google.gson.Gson;

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

    public void guarda(String carpeta, String fitxer, String json) throws IOException {
        FileWriter fw = new FileWriter(database + carpeta + "/"+ fitxer + ".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(json);
        bw.close();
    }

    public void guardaMultiple(String carpeta, String fitxer, ArrayList<String> jsons) throws IOException {
        FileWriter fw = new FileWriter(database + carpeta + "/"+ fitxer + ".txt");
        BufferedWriter bw = new BufferedWriter(fw);
        for (String json : jsons) {
            bw.write(json);
        }
        bw.close();
    }

}
