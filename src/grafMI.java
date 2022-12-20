import java.util.ArrayList;

public class grafMI {
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
            return "krawedz{" +
                    "wiescholek1='" + wiescholek1 + '\'' +
                    ", wiescholek2='" + wiescholek2 + '\'' +
                    ", waga=" + waga +
                    '}';
        }
    }
    private ArrayList<krawedz> krawedzie = new ArrayList<>();
    private ArrayList<ArrayList<String>> macierz = new ArrayList<ArrayList<String>>();
    private int liczbaWierzch = 0;
    private boolean czySkierowany;

    public grafMI(boolean czySkier){
        czySkierowany = czySkier;
        ArrayList<String> a = new ArrayList<>();
        macierz.add(a);
        macierz.get(0).add("/");
    }

    public void dodajWierzch(String nazwa){
        ArrayList<String> a = new ArrayList<>();
        liczbaWierzch++;
        if(liczbaWierzch>=macierz.size())
            macierz.add(a);
        macierz.get(macierz.size()-1).add(nazwa);
        for(int i = 1; i< macierz.get(i).size(); i++)
            macierz.get(macierz.size()-1).add("0");
        for(int i = 1; i< macierz.get(i).size()-1; i++)
            macierz.get(i).add("0");
    }

    public int dodajKrawedz(String wieszch1,String wieszch2){
        krawedz k1 = new krawedz(wieszch1, wieszch2, 1);
        krawedzie.add(k1);
        macierz.get(0).add("k"+krawedzie.size());
        int indexWieszch1 = -1, indexWieszch2= -1;
        if (wieszch1.equals(wieszch2)) {
            System.out.println("wieszcholek nie moze miec krawedzi sam ze soba");
            return -1;
        }
        if(czySkierowany){
            for(int i = 1; i< macierz.size(); i++) {
                if (macierz.get(i).get(0).equals(wieszch1))
                    indexWieszch1 = i;
                if (macierz.get(i).get(0).equals(wieszch2))
                    indexWieszch2 = i;
            }
            if (indexWieszch1 == -1 || indexWieszch2 == -1) {
                System.out.println("nie ma takiego wieszcholka");
                return -1;
            }
            for (int i = 1 ; i < macierz.size(); i++)
                macierz.get(i).add("0");
            macierz.get(indexWieszch1).set(krawedzie.size(), "-1");
            macierz.get(indexWieszch2).set(krawedzie.size(), "1");


        }else{
            for(int i = 1; i< macierz.size(); i++) {
                if (macierz.get(i).get(0).equals(wieszch1))
                    indexWieszch1 = i;
                if (macierz.get(i).get(0).equals(wieszch2))
                    indexWieszch2 = i;
            }
            if (indexWieszch1 == -1 || indexWieszch2 == -1) {
                System.out.println("nie ma takiego wieszcholka");
                return -1;
            }
            for (int i = 1 ; i < macierz.size(); i++)
                macierz.get(i).add("0");
            macierz.get(indexWieszch1).set(krawedzie.size(), "1");
            macierz.get(indexWieszch2).set(krawedzie.size(), "1");
        }
        return 0;
    }

    public int dodajKrawedz(String wieszch1,String wieszch2, String waga){
        krawedz k1 = new krawedz(wieszch1, wieszch2, Integer.parseInt(waga));
        krawedzie.add(k1);
        macierz.get(0).add(""+krawedzie.size());
        int indexWieszch1 = -1, indexWieszch2= -1;
        if (wieszch1.equals(wieszch2)) {
            System.out.println("wieszcholek nie moze miec krawedzi sam ze soba");
            return -1;
        }
        if(czySkierowany){
            System.out.println("nie ma skierowanego wazonego");
            return -1;

        }else{
            for(int i = 1; i< macierz.size(); i++) {
                if (macierz.get(i).get(0).equals(wieszch1))
                    indexWieszch1 = i;
                if (macierz.get(i).get(0).equals(wieszch2))
                    indexWieszch2 = i;
            }
            if (indexWieszch1 == -1 || indexWieszch2 == -1) {
                System.out.println("nie ma takiego wieszcholka");
                return -1;
            }
            for (int i = 1 ; i < macierz.size(); i++)
                macierz.get(i).add("0");
            macierz.get(indexWieszch1).set(krawedzie.size(), waga);
            macierz.get(indexWieszch2).set(krawedzie.size(), waga);
        }
        return 0;
    }

    public void Kurskal() {
        if (czySkierowany){
            System.out.println("Kurskal tylko dla nieskierowanych");

        }
        else {
            sortowanieWag();
            ArrayList<String> wynik = new ArrayList<>();
            ArrayList<krawedz> S = new ArrayList<>(krawedzie);
            ArrayList<ArrayList<String>> las = new ArrayList<ArrayList<String>>(liczbaWierzch);
            for (int i = 1; i < macierz.size(); i++) {
                ArrayList<String> s = new ArrayList<>();
                las.add(s);
                las.get(i - 1).add(macierz.get(i).get(0));
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
            System.out.println();
        }
    }

    public void wyswietlgraf(){
        for (int i = 0; i<macierz.size(); i++) {
            for (int j = 0; j < macierz.get(i).size(); j++)
                System.out.print(macierz.get(i).get(j) + " ");
            System.out.println();
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
}

