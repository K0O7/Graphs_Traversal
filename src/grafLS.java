import java.util.ArrayList;
import java.util.LinkedList;

public class grafLS {

    private class wieszcholek{
        String nazwa;
        LinkedList<krawedz> sasiedzi = new LinkedList<>();
        public wieszcholek(String nazwa){
            this.nazwa = nazwa;
        }

    }

    private class krawedz{
        String wiescholek1;
        String wiescholek2;
        int waga;
        public krawedz(String w1, String w2, int w){
            wiescholek1 = w1;
            wiescholek2 = w2;
            waga = w;
        }

        @Override
        public String toString() {
            return "{wiescholek1='" + wiescholek1 + '\'' +
                    ", wiescholek2='" + wiescholek2 + '\'' +
                    ", waga=" + waga +
                    "} -> ";
        }
    }

    grafLS(boolean czySkier){
        czySkierowany = czySkier;
    }

    ArrayList<wieszcholek> graf = new ArrayList<>();
    ArrayList<krawedz> krawedzie = new ArrayList<>();
    int liczbaWierzch = 0;
    boolean czySkierowany;

    public void dodajWierzch(String nazwa){
        liczbaWierzch++;
        wieszcholek w1 = new wieszcholek(nazwa);
        graf.add(w1);

    }

    public int dodajKrawedz(String wieszch1, String wieszch2){
        krawedz k1 = new krawedz(wieszch1, wieszch2, 1);
        krawedzie.add(k1);
        int indexWieszch1 = -1, indexWieszch2= -1;
        if (wieszch1.equals(wieszch2)) {
            System.out.println("wieszcholek nie moze miec krawedzi sam ze soba");
            return -1;
        }
        if(czySkierowany) {
            for(int i = 0; i< graf.size(); i++) {
                if (graf.get(i).nazwa.equals(wieszch1))
                    indexWieszch1 = i;
                if (graf.get(i).nazwa.equals(wieszch2))
                    indexWieszch2 = i;
            }
            if (indexWieszch1 == -1 || indexWieszch2 == -1) {
                System.out.println("nie ma takiego wieszcholka");
                return -1;
            }
            graf.get(indexWieszch1).sasiedzi.add(k1);

            return 0;

        }else{
            for(int i = 0; i< graf.size(); i++) {
                if (graf.get(i).nazwa.equals(wieszch1))
                    indexWieszch1 = i;
                if (graf.get(i).nazwa.equals(wieszch2))
                    indexWieszch2 = i;
            }
            if (indexWieszch1 == -1 || indexWieszch2 == -1) {
                System.out.println("nie ma takiego wieszcholka");
                return -1;
            }
            graf.get(indexWieszch1).sasiedzi.add(k1);
            graf.get(indexWieszch2).sasiedzi.add(k1);

            return 0;
        }

    }

    public int dodajKrawedz(String wieszch1, String wieszch2, String waga){
        krawedz k1 = new krawedz(wieszch1, wieszch2, Integer.parseInt(waga));
        krawedzie.add(k1);
        int indexWieszch1 = -1, indexWieszch2= -1;
        if (wieszch1.equals(wieszch2)) {
            System.out.println("wieszcholek nie moze miec krawedzi sam ze soba");
            return -1;
        }
        if(czySkierowany) {
            for(int i = 0; i< graf.size(); i++) {
                if (graf.get(i).nazwa.equals(wieszch1))
                    indexWieszch1 = i;
                if (graf.get(i).nazwa.equals(wieszch2))
                    indexWieszch2 = i;
            }
            if (indexWieszch1 == -1 || indexWieszch2 == -1) {
                System.out.println("nie ma takiego wieszcholka");
                return -1;
            }
            graf.get(indexWieszch1).sasiedzi.add(k1);

            return 0;

        }else{
            for(int i = 0; i< graf.size(); i++) {
                if (graf.get(i).nazwa.equals(wieszch1))
                    indexWieszch1 = i;
                if (graf.get(i).nazwa.equals(wieszch2))
                    indexWieszch2 = i;
            }
            if (indexWieszch1 == -1 || indexWieszch2 == -1) {
                System.out.println("nie ma takiego wieszcholka");
                return -1;
            }
            graf.get(indexWieszch1).sasiedzi.add(k1);
            graf.get(indexWieszch2).sasiedzi.add(k1);

            return 0;
        }

    }

    public void Kurskal() {
        if (czySkierowany){
            System.out.println("Kurskal tylko dla nieskierowanych");

        }
        else {
            sortowanieWag();
            ArrayList<String> wynik = new ArrayList<>();
            ArrayList<krawedz> S = new ArrayList<>(krawedzie);
            ArrayList<ArrayList<String>> las = new ArrayList<ArrayList<String>>();
            for (int i = 0; i < graf.size(); i++) {
                ArrayList<String> s = new ArrayList<>();
                las.add(s);
                las.get(i ).add(graf.get(i).nazwa);
            }
            int indexWieszch1 = -1, indexWieszch2 = -1;
            while (S.size() > 0) {
                for (int i = 0; i < las.size(); i++)
                    for (int j = 0; j < las.get(i).size(); j++) {
                        if (las.get(i).get(j).equals(S.get(0).wiescholek1))
                            indexWieszch1 = i;
                        if (las.get(i).get(j).equals(S.get(0).wiescholek2))
                            indexWieszch2 = i;
                    }
                if (indexWieszch1 != indexWieszch2) {
                    for (int i = 0; i < las.get(indexWieszch2).size(); i++)
                        las.get(indexWieszch1).add(las.get(indexWieszch2).get(i));
                    wynik.add(S.get(0).wiescholek1 + S.get(0).wiescholek2);
                    las.remove(indexWieszch2);
                    S.remove(0);
                } else {
                    S.remove(0);
                }
            }

            for (int i = 0; i < wynik.size(); i++)
                System.out.print(wynik.get(i) + " ");
        }
    }

    private void sortowanieWag(){
        krawedz temp;
        int a = 1;
        while(a>0){
            a=0;
            for (int i = 0; i< krawedzie.size()-1;i++)
                if(krawedzie.get(i).waga>krawedzie.get(i+1).waga) {
                    temp = krawedzie.get(i);
                    krawedzie.set(i, krawedzie.get(i+1));
                    krawedzie.set(i+1, temp);
                    a++;
                }
        }
    }

    public void wyswietlKraw(){
        for (int i = 0 ; i < krawedzie.size(); i++)
            System.out.println(krawedzie.get(i));
        System.out.println();
    }



    public void wyswietl(){
        for (int i = 0; i< graf.size(); i++){
            System.out.print(graf.get(i).nazwa+"-> ");
            if(graf.get(i).sasiedzi.size()>0) {
                    System.out.print(graf.get(i).sasiedzi);
                System.out.println();
            }
            else{
                System.out.println("brak sasiadow");
            }
        }
    }
}
