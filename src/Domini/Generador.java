package Domini;

import java.util.ArrayList;

// Berni
public class Generador {

    private Horari horari;
    private PlaEstudis pe;
    private ArrayList<Sessio> sessions;
    private TaulaAules aulesDisponibles;

    private RestriccioSolapar rs;

    public Generador(Horari horariBuit, PlaEstudis plaEstudis, ArrayList<Sessio> sessions, RestriccioSolapar rs) {
        this.horari = horariBuit;
        this.pe = plaEstudis;
        this.sessions = sessions;

        this.rs = rs;
    }

    public void generarHorari(ArrayList<Aula> aules) {
        this.aulesDisponibles = new TaulaAules(aules);
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

    private boolean potAnarAqui(Sessio sessio, Integer dia, Integer hora, Horari hor) {
        // Mirar si aquesta sessió pot anar a aquest slot horari

        Pair<Integer, Integer> restriccio = sessio.getRestriccio();
        if (restriccio.getFirst() != (hora+8)) return false;

        if (!rs.comprovaRestriccio(sessio, hor.getAtoms(dia, hora))) return false;

        return true;
    }

    private Aula buscarAula(Sessio sessio, TaulaAules aules, Integer dia, Integer hora) {
        // Buscar una aula que es correspongui amb els requeriments de la sessio
        if (aules.agafar(dia, hora).size() == 0) return null;
        else return aules.agafar(dia, hora).get(0);
    }

    private boolean produirHorari(Horari hor, TaulaAules aules, ArrayList<Sessio> sessions, Integer dia, Integer hora) {
        if (sessions.size() == 0) {
            // Hem trobat una solució valida, retornem true
            this.horari = hor;
            return true;
        } else if (dia == 5) {
            // Hem acabat els dies de l'horari, retornem FALSE per indicar que no és una branca valida
            return false;
        } else if (hora == 12) {
            // Saltem al seguent dia
            return produirHorari(hor, aules, sessions, dia+1, 0);
        } else {
            // TODO: Ordenar les llistes per a que vagi més ràpid

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
                            aules = cAules;
                            sessions = cSessions;
                            break;
                        }
                    }
                }

            }
            if (!found) {
                return produirHorari(hor, aules, sessions, dia, hora + 1);
            } else {
                return true;
            }
        }
    }
}

// BACKTRACKING CRONOLOGIC
// Anar mirant per cada cosa que afegeixes si compleix les restriccions
// Agafes variable, li assignes valor, el que sigui, tornem adalt, satisfà les restriccions? (Si -> Seguim, No -> Agafem un altre valor)
// Tornem a preguntar, satisfa? Si -> Seguim, No -> Seguim, pero si s'han acabat els valors d'aquestes familia de variables fem backtracking cronologic amb la ultima vaiable assignada d'aquesta família

// HEURISTICA
// Aplicar heurisitques per agafar les variables que poden tenir mes exit, per evitar molta recursivitat
// Ordenar les variables ja es una heuristica
// [forward checking] Si faig aquesta assignacio, que passa al futur, es a dir les seguents assignacions
// A priori, reduim els dominis -> Arc consistencia (No hi haura backtracking a nivell 2)

// BACKJUMPING CRONOLOGIC (MOLA MÉS QUE EL BACKTRACKING)
// En comptes de tirar enrere a la variable anterior, anem a la variable anterior més bona

// RESUM - BACKTRACKING
// Primer de tot reduim dominis -> Arconsistència
// Apliquem un BACKJUMPING, quan hem acabat de posar i no satisfà les restriccions tirem enrere a la variable que mes ens escau