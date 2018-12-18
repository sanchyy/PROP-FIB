package main.Persistencia;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;

public class UtilsDisc {
    String database = "./DB/";

    public ArrayList<String> carrega(String carpeta, String fitxer) throws IOException {
        FileReader fr = new FileReader(database + carpeta + "/"+ fitxer + ".txt");
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> lineas = new ArrayList<>();
        String linea;
        while ((linea = br.readLine()) != null) {
            lineas.add(linea);
        }
        br.close();
        return lineas;
    }

}