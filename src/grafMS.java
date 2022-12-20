import java.util.ArrayList;

public class grafMS {

    private class wieszcholek{
        String kolor;
        String nazwa;
        String poprzednik;
        int odleglosc = 0;
        double dystans = Double.POSITIVE_INFINITY;
        public wieszcholek(String k, String n ){
            kolor = k;
            nazwa = n;
        }

    }

    private class krawedz{
        wieszcholek wiescholek1;
        wieszcholek wiescholek2;
        int waga;
        public krawedz(wieszcholek w1, wieszcholek w2, int w){
            wiescholek1 = w1;
            wiescholek2 = w2;
            waga = w;
        }

        @Override
        public String toString() {
            return "krawedz{" +
                    "wiescholek1='" + wiescholek1.nazwa + '\'' +
                    ", wiescholek2='" + wiescholek2.nazwa + '\'' +
                    ", waga=" + waga +
                    '}';
        }
    }
    private ArrayList<wieszcholek> wieszcholki = new ArrayList<>();
    private ArrayList<krawedz> krawedzie = new ArrayList<>();
    private ArrayList<ArrayList<String>> macierz = new ArrayList<ArrayList<String>>();
    private int liczbaWierzch = 0;
    private boolean czySkierowany;
    private int time = 0;


    public grafMS(boolean czySkier){
        czySkierowany = czySkier;
        ArrayList<String> a = new ArrayList<>();
        macierz.add(a);
        macierz.get(0).add("/");
    }

    public void dodajWierzch(String nazwa){
        ArrayList<String> a = new ArrayList<>();
        wieszcholek w = new wieszcholek("b", nazwa);
        wieszcholki.add(w);
        liczbaWierzch++;
        macierz.get(0).add(nazwa);
        if(liczbaWierzch>=macierz.size())
            macierz.add(a);
        macierz.get(macierz.size()-1).add(nazwa);
        for(int i = 1; i< macierz.size()-1; i++)
            macierz.get(macierz.size()-1).add("0");
        for(int i = 1; i< macierz.size()-1; i++)
            macierz.get(i).add("0");
        macierz.get(macierz.size()-1).add("x");
    }

    public int dodajKrawedz(String wieszch1,String wieszch2){
        wieszcholek temp1 = null;
        wieszcholek temp2 = null;
        for (int i = 0; i< wieszcholki.size(); i++){
            if (wieszcholki.get(i).nazwa.equals(wieszch1))
                temp1 = wieszcholki.get(i);
            if (wieszcholki.get(i).nazwa.equals(wieszch2))
                temp2 = wieszcholki.get(i);
        }
        if (temp1 == temp2)
            return -1;

        krawedz k1 = new krawedz(temp1, temp2, 1);
        krawedzie.add(k1);
        int indexWieszch1 = -1, indexWieszch2= -1;
        if (wieszch1.equals(wieszch2)) {
            System.out.println("wieszcholek nie moze miec krawedzi sam ze soba");
            return -1;
        }
        if(czySkierowany){
            for(int i = 1; i< macierz.size(); i++) {
                if (macierz.get(0).get(i).equals(wieszch1))
                    indexWieszch1 = i;
                if (macierz.get(0).get(i).equals(wieszch2))
                    indexWieszch2 = i;
            }
            if (indexWieszch1 == -1 || indexWieszch2 == -1) {
                System.out.println("nie ma takiego wieszcholka");
                return -1;
            }
            macierz.get(indexWieszch1).set(indexWieszch2, "1");


        }else{
            for(int i = 1; i< macierz.size(); i++) {
                if (macierz.get(0).get(i).equals(wieszch1))
                    indexWieszch1 = i;
                if (macierz.get(0).get(i).equals(wieszch2))
                    indexWieszch2 = i;
            }
            if (indexWieszch1 == -1 || indexWieszch2 == -1) {
                System.out.println("nie ma takiego wieszcholka");
                return -1;
            }
            macierz.get(indexWieszch1).set(indexWieszch2, "1");
            macierz.get(indexWieszch2).set(indexWieszch1, "1");
        }
        return 0;
    }

    public int dodajKrawedz(String wieszch1,String wieszch2, String waga){
        wieszcholek temp1 = null;
        wieszcholek temp2 = null;
        for (int i = 0; i< wieszcholki.size(); i++){
            if (wieszcholki.get(i).nazwa.equals(wieszch1))
                temp1 = wieszcholki.get(i);
            if (wieszcholki.get(i).nazwa.equals(wieszch2))
                temp2 = wieszcholki.get(i);
        }
        if (temp1 == temp2)
            return -1;

        krawedz k1 = new krawedz(temp1, temp2, Integer.parseInt(waga));
        krawedzie.add(k1);
        int indexWieszch1 = -1, indexWieszch2= -1;
        if (wieszch1.equals(wieszch2)) {
            System.out.println("wieszcholek nie moze miec krawedzi sam ze soba");
            return -1;
        }

        if(czySkierowany){
            for (int i = 1; i < macierz.size(); i++) {
                if (macierz.get(0).get(i).equals(wieszch1))
                    indexWieszch1 = i;
                if (macierz.get(0).get(i).equals(wieszch2))
                    indexWieszch2 = i;
            }
            if (indexWieszch1 == -1 || indexWieszch2 == -1) {
                System.out.println("nie ma takiego wieszcholka");
                return -1;
            }
            macierz.get(indexWieszch1).set(indexWieszch2, waga);

        }else {

            for (int i = 1; i < macierz.size(); i++) {
                if (macierz.get(0).get(i).equals(wieszch1))
                    indexWieszch1 = i;
                if (macierz.get(0).get(i).equals(wieszch2))
                    indexWieszch2 = i;
            }
            if (indexWieszch1 == -1 || indexWieszch2 == -1) {
                System.out.println("nie ma takiego wieszcholka");
                return -1;
            }
            macierz.get(indexWieszch1).set(indexWieszch2, waga);
            macierz.get(indexWieszch2).set(indexWieszch1, waga);
        }
        return 0;
    }

    public void Kurskal() {
        if (czySkierowany)
            System.out.println("Kurskal tylko dla grafow nieskierowanych");
            else {
            sortowanieWag();
            ArrayList<String> wynik = new ArrayList<>();
            ArrayList<krawedz> S = new ArrayList<>(krawedzie);
            ArrayList<ArrayList<String>> las = new ArrayList<ArrayList<String>>(liczbaWierzch);
            for (int i = 1; i < macierz.get(0).size(); i++) {
                ArrayList<String> s = new ArrayList<>();
                las.add(s);
                las.get(i - 1).add(macierz.get(0).get(i));
            }
            int indexWieszch1 = -1, indexWieszch2 = -1;
            while (S.size() > 0) {
                for (int i = 0; i < las.size(); i++)
                    for (int j = 0; j < las.get(i).size(); j++) {
                        if (las.get(i).get(j).equals(S.get(0).wiescholek1.nazwa))
                            indexWieszch1 = i;
                        if (las.get(i).get(j).equals(S.get(0).wiescholek2.nazwa))
                            indexWieszch2 = i;
                    }
                if (indexWieszch1 != indexWieszch2) {
                    for (int i = 0; i < las.get(indexWieszch2).size(); i++)
                        las.get(indexWieszch1).add(las.get(indexWieszch2).get(i));
                    wynik.add(S.get(0).wiescholek1.nazwa + S.get(0).wiescholek2.nazwa);
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

    public void BFS(String start){
        System.out.println("BFS przeszukiwanie wszerz");
        int index = 0;
        ArrayList<String> sasiedzi = new ArrayList<>();
        sasiedzi.add(start);
        for (int i=0; i<wieszcholki.size();i++){
            if(wieszcholki.get(i).nazwa.equals(start)) {
                wieszcholki.get(i).kolor = "s";
                wieszcholki.get(i).poprzednik = "x";
            }
        }
        while(sasiedzi.size() > 0) {
            start = sasiedzi.get(0);
            for (int i=0; i<wieszcholki.size();i++)
                if (wieszcholki.get(i).nazwa.equals(start)) {
                    wieszcholki.get(i).kolor = "c";
                    sasiedzi.remove(0);
                    index = i;
                }

            for (int i = 0; i < krawedzie.size(); i++) {
                if(krawedzie.get(i).wiescholek1.nazwa.equals(start) && krawedzie.get(i).wiescholek2.kolor.equals("b") ) {
                    sasiedzi.add(krawedzie.get(i).wiescholek2.nazwa);
                }
                if(krawedzie.get(i).wiescholek2.nazwa.equals(start) && krawedzie.get(i).wiescholek1.kolor.equals("b")) {
                    sasiedzi.add(krawedzie.get(i).wiescholek1.nazwa);
                }
            }

            for (int i = 0; i< sasiedzi.size(); i++)
                for (int j = 0 ; j< wieszcholki.size(); j++) {
                    if (sasiedzi.get(i).equals(wieszcholki.get(j).nazwa) && wieszcholki.get(j).kolor.equals("b")) {
                        wieszcholki.get(j).kolor = "s";
                        wieszcholki.get(j).poprzednik = start;
                        wieszcholki.get(j).odleglosc = wieszcholki.get(index).odleglosc +1;
                    }
                }
        }
        for (int i = 0; i< wieszcholki.size(); i++)
            System.out.println("wieszcholek: "+wieszcholki.get(i).nazwa+" <-(poprzednik) "+wieszcholki.get(i).poprzednik+ " odleglosc: "+ wieszcholki.get(i).odleglosc );
        System.out.println();
        resetWieszch();
    }

    public void DFS(String start){
        System.out.println("BFS przeszukiwanie w glab");
        int index = 0;
        for (int i=0; i<wieszcholki.size();i++){
            if(wieszcholki.get(i).nazwa.equals(start)) {
                index = i;
            }
        }
        DFS_Visit(index);
        for (int i=0; i<wieszcholki.size();i++) {
            if(wieszcholki.get(i).kolor.equals("b"))
                DFS_Visit(i);
        }

        for (int i = 0; i< wieszcholki.size(); i++)
            System.out.println("wieszcholek: "+wieszcholki.get(i).nazwa+" czas: "+wieszcholki.get(i).dystans+ " / "+ wieszcholki.get(i).odleglosc );
        System.out.println();
        time = 0;
        resetWieszch();
    }

    private void DFS_Visit(int index){
        String n;
        time++;
        wieszcholki.get(index).kolor = "s";
        wieszcholki.get(index).dystans = time;
        for (int i = 0; i < krawedzie.size(); i++) {
            if(krawedzie.get(i).wiescholek1.nazwa.equals(wieszcholki.get(index).nazwa) && krawedzie.get(i).wiescholek2.kolor.equals("b") ) {
                for (int j=0; j<wieszcholki.size();j++){
                    if(wieszcholki.get(j).nazwa.equals(krawedzie.get(i).wiescholek2.nazwa)) {
                        DFS_Visit(j);
                    }
                }
            }
            if(krawedzie.get(i).wiescholek2.nazwa.equals(wieszcholki.get(index).nazwa) && krawedzie.get(i).wiescholek1.kolor.equals("b")) {
                for (int j=0; j<wieszcholki.size();j++){
                    if(wieszcholki.get(j).nazwa.equals(krawedzie.get(i).wiescholek1.nazwa)) {
                        DFS_Visit(j);
                    }
                }
            }
        }
        wieszcholki.get(index).kolor = "c";
        wieszcholki.get(index).odleglosc = time;
        time++;
    }

    public void SSSP(String start){
        if(!czySkierowany) {
            ArrayList<wieszcholek> wynik = new ArrayList<>();
            ArrayList<wieszcholek> wieszcholki2 = new ArrayList<>(wieszcholki);


            for (int i = 0; i < wieszcholki2.size(); i++)
                if (wieszcholki2.get(i).nazwa.equals(start)) {
                    wieszcholki2.get(i).dystans = 0;
                    wieszcholki2.get(i).poprzednik = "x";
                    wynik.add(wieszcholki2.get(i));
                    wieszcholki2.remove(i);
                }
            int index = 0;
            while (wieszcholki2.size() > 0) {

                for (int i = 0; i < krawedzie.size(); i++) {
                    if (krawedzie.get(i).wiescholek1.nazwa.equals(wynik.get(index).nazwa)) {
                        krawedzie.get(i).wiescholek2.dystans = MIN(krawedzie.get(i).wiescholek2.dystans, wynik.get(index).dystans + krawedzie.get(i).waga);
                        if (krawedzie.get(i).wiescholek2.poprzednik == null)
                            krawedzie.get(i).wiescholek2.poprzednik = wynik.get(index).nazwa;
                    }
                    if (krawedzie.get(i).wiescholek2.nazwa.equals(wynik.get(index).nazwa)) {
                        krawedzie.get(i).wiescholek1.dystans = MIN(krawedzie.get(i).wiescholek1.dystans, wynik.get(index).dystans + krawedzie.get(i).waga);
                        if (krawedzie.get(i).wiescholek1.poprzednik == null)
                            krawedzie.get(i).wiescholek1.poprzednik = wynik.get(index).nazwa;
                    }
                }
                double temp = Double.POSITIVE_INFINITY;
                int indexWieszch = 0;
                for (int i = 0; i < wieszcholki2.size(); i++)
                    if (wieszcholki2.get(i).dystans < temp) {
                        indexWieszch = i;
                        temp = wieszcholki2.get(i).dystans;
                    }
                wynik.add(wieszcholki2.get(indexWieszch));
                wieszcholki2.remove(indexWieszch);
                index++;
            }
            for (int i = 0; i < wieszcholki.size(); i++)
                System.out.println("wieszcholek: " + wieszcholki.get(i).nazwa + " <-(poprzednik) " + wieszcholki.get(i).poprzednik + " odleglosc: " + wieszcholki.get(i).dystans);
            resetWieszch();
            System.out.println();
        }else{
            System.out.println("SSSP tylko dla grafow nie skierowanych");
        }
    }

    private double MIN(double a, double b){
        if (a>b)
            return b;
        return a;
    }
    public void wyswietlKraw(){
        for (int i = 0 ; i < krawedzie.size(); i++)
            System.out.println(krawedzie.get(i));
        System.out.println();
    }

    private void resetWieszch(){
        for (int i = 0; i< wieszcholki.size();i++){
            wieszcholki.get(i).dystans = Double.POSITIVE_INFINITY;
            wieszcholki.get(i).odleglosc = 0;
            wieszcholki.get(i).kolor = "b";
            wieszcholki.get(i).poprzednik = null;
        }
    }
}
