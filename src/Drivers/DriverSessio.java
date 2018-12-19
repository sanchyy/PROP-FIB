package Drivers;

import main.Domini.CtrDomini;
import main.Domini.Quadrimestre;

import java.util.Scanner;

public class DriverSessio {

    public static Scanner scanner = new Scanner(System.in);
    public static CtrDomini ctrDomini = null;

    public static void runDriver(CtrDomini ctr, Scanner scnr) {
        ctrDomini = ctr;
        scanner = scnr;
        String[] str = new String[0];
        main(str);
    }

    public static void main(String[] args) {
        if (ctrDomini == null) new CtrDomini(6);
        System.out.println("---------------------------");
        System.out.println("Quina acció vols realitzar?");
        System.out.println("---------------------------");
        System.out.println(" [1] Mostrar Sessio");
        System.out.println(" [2] Seleccionar Sessio");
        System.out.println(" [3] Crear Sessio");
        System.out.println(" [4] Borrar Sessio");
        int sel = llegirNumero();
        if (sel == 1) {
            System.out.println(ctrDomini.llistaSessions());
        } else if (sel == 2) {
            System.out.println("Vols mostrar les Sessions (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) System.out.println(ctrDomini.llistaSessions());
            System.out.println("Quina Sessio vols seleccionar?");
            Integer b = llegirNumero();
            try { ctrDomini.getQuadrimestre().getSessio(b);}
            catch (Exception e) {System.out.println("No hi ha cap Sessio amb aquesta selecció");}
        } else if (sel == 3) {
            System.out.println("De quina assignatura és aquesta sessió?");
            String nomAssignatura = llegirString();
            System.out.println("Vols crear les sessions d'una assignatura automàticament? (S/N)");
            if (llegirString().equals("S")) {
                System.out.println("Quants grups té aquesta assignatura?");
                Integer grups = llegirNumero();
                System.out.println("Quants sub-grups té cada grup?");
                Integer subGrups = llegirNumero();
                System.out.println("Quants són de tardes?");
                Integer tardes = llegirNumero();
                for (int i=0; i<grups; ++i) {
                    Integer grup = i*10 + 10;
                    ctrDomini.afegirSessioQuadrimestre(grup, nomAssignatura);
                    Integer numSessio = ctrDomini.getQuadrimestre().getSessions().size()-1;
                    if (i > (grups-tardes-1)) {
                        ctrDomini.crearRestriccioTardes(numSessio);
                    } else {
                        ctrDomini.crearRestriccioMatins(numSessio);
                    }
                    ctrDomini.crearRestriccioCaracteristicaAula(numSessio, ctrDomini.getLlistaCaracteristiquesTeoria(nomAssignatura));
                    for (int j=0; j<subGrups; ++j) {
                        Integer subGrup = grup + j+1;
                        ctrDomini.afegirSessioQuadrimestre(subGrup, nomAssignatura);
                        Integer numSessioS = ctrDomini.getQuadrimestre().getSessions().size()-1;
                        ctrDomini.crearRestriccioSolapar(numSessio, numSessioS);
                        if (i > (grups-tardes-1)) {
                            ctrDomini.crearRestriccioTardes(numSessioS);
                        } else {
                            ctrDomini.crearRestriccioMatins(numSessioS);
                        }
                        ctrDomini.crearRestriccioCaracteristicaAula(numSessioS, ctrDomini.getLlistaCaracteristiquesLab(nomAssignatura));
                    }
                }
            } else {
                if (!ctrDomini.existeixAssignatura(nomAssignatura)) {
                    System.out.println("No existeix cap assignatura amb aquest nom");
                } else {
                    System.out.println("Indica el grup d'aquesta assignatura");
                    Integer grup = llegirNumero();
                    ctrDomini.afegirSessioQuadrimestre(grup, nomAssignatura);
                }
            }
        } else if (sel == 4) {
            System.out.println("Vols mostrar les sessions abans? (S/N)");
            String s = llegirString();
            if (s.equals("S") || s.equals("s")) System.out.println(ctrDomini.llistaSessions());
            System.out.println("Quina Sessió vols borrar?");
            Integer b = llegirNumero();
            try {
                Quadrimestre q = ctrDomini.getQuadrimestre(); q.borrarSessio(b);}
            catch (Exception e) {System.out.println("No existeix aquesta assignatura");}
        } else {
            System.out.println("No hi ha cap acció disponible");
        }
        System.out.println("Vols realitzar una altre acció? (S/N)");
        String sn = llegirString();
        if (sn.equalsIgnoreCase("s")) main(new String[0]);
    }

    public static String llegirString() {
        return scanner.next();
    }

    public static Integer llegirNumero() {
        return scanner.nextInt();
    }

}
