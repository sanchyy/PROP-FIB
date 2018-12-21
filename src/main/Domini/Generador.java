package Domini;

import java.util.ArrayList;

public class Generador {

    private Horari horari;
    private PlaEstudis pe;
    private ArrayList<Sessio> sessions;
    private TaulaAules aulesDisponibles;
    private CjtRestriccions restriccions;

    public Generador(Horari horariBuit, PlaEstudis plaEstudis, ArrayList<Sessio> sessions, CjtRestriccions restriccions) {
        this.horari       = horariBuit;
        this.pe           = plaEstudis;
        this.sessions     = sessions;
        this.restriccions = restriccions;
    }

    public void generarHorari(ArrayList<Aula> aules) {
        this.aulesDisponibles = new TaulaAules(aules);
        ArrayList<Sessio> fallen = new ArrayList<>();
        for (Sessio s : clonarSessionsDisponibles(sessions)) {
            Integer Acount = 0;
            for (Aula a : aules) {
                if (restriccions.comprovarRestriccionsAula(s, a)) ++Acount;
            }
            if (Acount == 0) {
                fallen.add(s);
                sessions.remove(s);
            }
        }
        if (fallen.size() > 0) {
            System.out.println("LES SEGÜENTS SESSIONS NO TENEN CAP AULA DISPONIBLE, ES TREU ATOMATICAMENT");
            for (Sessio s : fallen) {
                System.out.println("    > " + s.mostrarSessio());
            }
        }
        produirHorari(horari, aulesDisponibles, sessions, 0, 0);
    }

    public Horari getHorari() {
        return horari;
    }

    public ArrayList<Sessio> clonarSessionsDisponibles(ArrayList<Sessio> sessionsDisponibles) {
        ArrayList<Sessio> novaLlista = new ArrayList<>();
        for (Sessio s : sessionsDisponibles) {
            novaLlista.add(s);
        }
        return novaLlista;
    }

    public boolean potAnarAqui(Sessio sessio, Integer dia, Integer hora, Horari hor) {
        return restriccions.comprovarRestriccionsColocar(sessio, hor.getAtoms(dia, hora), dia, hora, hor);
    }

    private Aula buscarAula(Sessio sessio, TaulaAules aules, Integer dia, Integer hora) {
        ArrayList<Aula> disponibles = aules.agafar(dia, hora);
        if (disponibles.size() == 0) return null;
        for (Aula aula : disponibles) {
            if (restriccions.comprovarRestriccionsAula(sessio, aula)) return aula;
        }
        return null;
    }

    private boolean produirHorari(Horari hor, TaulaAules aules, ArrayList<Sessio> sessions, Integer dia, Integer hora) {
        if (sessions.size() == 0) {
            // Hem trobat una solució valida
            this.horari = hor;
            this.horari.setSolucionat(true);
            return true;
        } else if (dia == hor.columnes) {
            // Hem acabat els dies de l'horari
            return true;
        } else if (hora == hor.files) {
            // Saltem al seguent dia
            return produirHorari(hor, aules, sessions, dia+1, 0);
        } else {
            boolean found = false;
            for (Sessio sessioActual : sessions) {
                Horari cHor = hor.clonarHorari();
                ArrayList<Sessio> cSessions = clonarSessionsDisponibles(sessions);
                TaulaAules cAules = aules.clonarTaulaAules();

                // Mirem si la sessio que tenim pot anar a aquest slot
                if (potAnarAqui(sessioActual, dia, hora, cHor)) {
                    // Li busquem una aula adequada
                    Aula a = buscarAula(sessioActual, cAules, dia, hora);
                    if (a != null) {
                        sessioActual.setAula(a);
                        cHor.setSessio(sessioActual, dia, hora);
                        cAules.borrar(a, dia, hora);
                        cSessions.remove(sessioActual);
                        found = found || produirHorari(cHor, cAules, cSessions, dia, hora);
                        if (found) {
                            hor = cHor;
                            aules = cAules;
                            sessions = cSessions;
                            break;
                        }
                    }
                }

            }
            if (!found) {
                return produirHorari(hor, aules, sessions, dia, hora+1);
            } else {
                return true;
            }
        }
    }
}
