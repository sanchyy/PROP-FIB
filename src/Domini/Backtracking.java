package Domini;

import java.util.ArrayList;

// Berni
public class Backtracking {

    private Horari horari;
    private PlaEstudis pe;
    private ArrayList<Sessio> sessions;
    private ArrayList< ArrayList< ArrayList <Aula> > > aules_disponibles = new ArrayList<>();

    public Backtracking(Horari horariBuit, PlaEstudis plaEstudis, ArrayList<Sessio> sessios) {
        this.horari = horariBuit;
        this.pe = plaEstudis;
        this.sessions = sessios;
    }

    public void generarHorari() {
        generarTaulaAules(pe.getAules_disponibles());
        produirHorari(horari, aules_disponibles, sessions, 0, 0);
    }

    public Horari getHorari() {
        return horari;
    }

    public void generarTaulaAules(ArrayList<Aula> aulas) {
        for (int i=0; i<5; ++i) {
            ArrayList< ArrayList<Aula> > dia = new ArrayList<>();
            for (int j=0; j<12; ++j) {
                dia.add(clonarAulesDisponibles(aulas));
            }
            aules_disponibles.add(dia);
        }
    }

    public void mostrarTaulaAules(ArrayList< ArrayList< ArrayList <Aula> > > taulaaules) {
        System.out.println("----------------------------");
        System.out.println("---------- AULES  ----------");
        System.out.println("----------------------------");
        Integer dayI = 0;
        for (ArrayList< ArrayList<Aula>> dia : taulaaules) {
            System.out.println(dayI++);
            for (ArrayList<Aula> hora : dia) {
                System.out.println("Size: " + hora.size());
                for (Aula aula : hora) {
                    System.out.println("    " + aula.getNom_aula());
                }
            }
        }
    }

    public ArrayList< ArrayList< ArrayList <Aula> > > clonarTaulaAules(ArrayList< ArrayList< ArrayList <Aula> > > taulaAules) {
        ArrayList< ArrayList< ArrayList <Aula> > > novaTaula = new ArrayList<>();
        for (ArrayList< ArrayList<Aula>> dia : taulaAules) {
            ArrayList< ArrayList<Aula>> nDia = new ArrayList<>();
            for (ArrayList<Aula> hora : dia) {
                ArrayList<Aula> nHora = new ArrayList<>();
                for (Aula aula : hora) {
                    nHora.add(aula);
                }
                nDia.add(nHora);
            }
            novaTaula.add(nDia);
        }
        return novaTaula;
    }

    public ArrayList< ArrayList< ArrayList <Aula> > > borrarAula(ArrayList< ArrayList< ArrayList <Aula> > > taulaAules, Aula a, Integer dia, Integer hora) {
        taulaAules.get(dia).get(hora).remove(a);
        return taulaAules;
    }

    public ArrayList<Aula> clonarAulesDisponibles(ArrayList<Aula> aulesDisponibles) {
        ArrayList<Aula> novaLlista = new ArrayList<>();
        for (Aula a : aulesDisponibles) {
            novaLlista.add(a);
        }
        return novaLlista;
    }

    public ArrayList<Sessio> clonarSessionsDisponibles(ArrayList<Sessio> sessionsDisponibles) {
        ArrayList<Sessio> novaLlista = new ArrayList<>();
        for (Sessio s : sessionsDisponibles) {
            novaLlista.add(s);
        }
        return novaLlista;
    }

    private boolean potAnarAqui(Sessio sessio, Integer dia, Integer hora) {
        // Mirar si aquesta sessió pot anar a aquest slot horari

        Pair<Integer, Integer> restriccio = sessio.getRestriccio();
        return restriccio.getFirst() == (hora+8);
    }

    private Aula buscarAula(Sessio sessio, ArrayList< ArrayList< ArrayList <Aula> > > aules, Integer dia, Integer hora) {
        // Buscar una aula que es correspongui amb els requeriments de la sessio
        if (aules.get(dia).get(hora).size() == 0) return null;
        else return aules.get(dia).get(hora).get(0);
    }

    // TODO: El tema de les aules està malament, no són aules generals, són aules per cada slot de hora
    private boolean produirHorari(Horari hor, ArrayList< ArrayList< ArrayList <Aula> > > aules, ArrayList<Sessio> sessions, Integer dia, Integer hora) {
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
                Horari cHor = hor.clonar();
                ArrayList<Sessio> cSessions = clonarSessionsDisponibles(sessions);
                ArrayList< ArrayList< ArrayList <Aula> > > cAules = clonarTaulaAules(aules);

                // Mirem si la sessio que tenim pot anar a aquest slot
                if (potAnarAqui(sessioActual, dia, hora)) {
                    // Li busquem una aula adequada
                    Aula a = buscarAula(sessioActual, cAules, dia, hora);
                    if (a != null) {
                        sessioActual.setAula(a);
                        cHor.setSessio(sessioActual, dia, hora);
                        borrarAula(cAules, a, dia, hora);
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
