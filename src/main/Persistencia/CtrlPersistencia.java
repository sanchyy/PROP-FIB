package main.Persistencia;

import main.Domini.PlaEstudis;

import java.io.IOException;
import java.util.ArrayList;

public class CtrlPersistencia {
    GestorAssignatura gAs;
    GestorPlaEstudis  gPe;
    GestorAula        gAu;
    GestorRestriccio  gRe;
    GestorHorari      gHo;

    public CtrlPersistencia() {
        gAs = new GestorAssignatura();
        gPe = new GestorPlaEstudis();
        gAu = new GestorAula();
        gRe = new GestorRestriccio();
        gHo = new GestorHorari();

    }


    public ArrayList<PlaEstudis> getPlansEstudis() throws IOException{
        return gPe.agafa();
    }

    //LLISTATS
    public ArrayList<String> treuLlistaAssignatura() {
        return gAs.llistaAssignatura();
    }

    public ArrayList<String> treuLlistaPlaEstudis() {
        return gPe.llistaPlaEstudis();
    }

    public ArrayList<String> treuLlistaAula() {
        return gAu.llistaAula();
    }

    public ArrayList<String> treuLlistaRestriccio() {
        return gRe.llistaRestriccio();
    }

    public ArrayList<String> treuLlistaHorari() {
        return gHo.llistaHorari();
    }


    //MODIFICAR
    public void modificaAssignatura(String nomAssig, String contingut) throws IOException {
        gAs.guarda(nomAssig,contingut);
    }

    public void modificaPlaEstudis(String nomPlaEstudis, String contingut) throws IOException {
        gPe.guarda(nomPlaEstudis,contingut);
    }

    public void modificaAula(String nomAula, String contingut) throws IOException {
        gAu.guarda(nomAula,contingut);
    }

    public void modificaRestriccio(String nomRestriccio, String contingut) throws IOException {
        gRe.guarda(nomRestriccio,contingut);
    }

    public void modificaHorari(String nomHorari, String contingut) throws IOException {
        gHo.guarda(nomHorari,contingut);
    }

    //GUARDAR

    public void guardaAssignatura(String nomAssig, String contingut) throws IOException {
        gAs.guarda(nomAssig,contingut);
    }

    public void guardaPlaEstudis(String nomPlaEstudis, String contingut) throws IOException {
        gPe.guarda(nomPlaEstudis,contingut);
    }

    public void guardaAula(String nomAula, String contingut) throws IOException {
        gAu.guarda(nomAula,contingut);
    }

    public void guardaRestriccio(String nomRestriccio, String contingut) throws IOException {
        gRe.guarda(nomRestriccio,contingut);
    }

    public void guardaHorari(String nomHorari, String contingut) throws IOException {
        gHo.guarda(nomHorari,contingut);
    }

    //CARREGAR

    public void carregaAssignatura (String nomAssig) throws IOException {
        gAs.carrega(nomAssig);
    }

    public void carregaPlaEstudis (String nomPlaEstudis) throws IOException {
        gAs.carrega(nomPlaEstudis);
    }

    public void carregaAula (String nomAula) throws IOException {
        gAs.carrega(nomAula);
    }

    public void carregaRestriccio (String nomRestriccio) throws IOException {
        gAs.carrega(nomRestriccio);
    }

    public void carregaHorari (String nomHorari) throws IOException {
        gAs.carrega(nomHorari);
    }



    public void guardaPlaEstudis() throws IOException {
        gPe.guarda("FIB 2018", "HOLIII");
    }
}
