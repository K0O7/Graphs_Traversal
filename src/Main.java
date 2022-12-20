public class Main {

    public static void main(String[] args) {
        grafMS g1 = new grafMS(false);
        g1.dodajWierzch("a");
        g1.dodajWierzch("b");
        g1.dodajWierzch("c");
        g1.dodajWierzch("d");
        g1.dodajWierzch("e");
        g1.dodajKrawedz("a", "b","3");
        g1.dodajKrawedz("e", "d","1");
        g1.dodajKrawedz("e", "a","4");
        g1.dodajKrawedz("c", "b","2");
        g1.dodajKrawedz("d", "c", "1");
        g1.dodajKrawedz("a", "d", "3");
        g1.wyswietlgraf();
        g1.wyswietlKraw();
        g1.Kurskal();
        g1.BFS("b");
        g1.DFS("b");
        g1.SSSP("b");
        System.out.println();

       grafMI g2 = new grafMI(false);
       g2.dodajWierzch("a");
       g2.dodajWierzch("b");
       g2.dodajWierzch("c");
       g2.dodajWierzch("d");
       g2.dodajKrawedz("a", "b","3");
       g2.dodajWierzch("e");
       g2.dodajKrawedz("e", "d","1");
       g2.dodajKrawedz("e", "a","4");
       g2.dodajKrawedz("c", "b","2");
       g2.dodajKrawedz("d", "c", "1");
       g2.dodajKrawedz("a", "d", "3");
       g2.wyswietlgraf();
       g2.wyswietlKraw();
       g2.Kurskal();
        System.out.println();

       grafLS g3 = new grafLS(false);
        g3.dodajWierzch("a");
        g3.dodajWierzch("b");
        g3.dodajWierzch("c");
        g3.dodajWierzch("d");
        g3.dodajWierzch("e");
        g3.dodajKrawedz("a", "b","3");
        g3.dodajKrawedz("e", "d","1");
        g3.dodajKrawedz("e", "a","4");
        g3.dodajKrawedz("c", "b","2");
        g3.dodajKrawedz("d", "c", "1");
        g3.dodajKrawedz("a", "d", "3");
        g3.wyswietl();
        g3.Kurskal();
        System.out.println();
        System.out.println();
        grafMS g4 = new grafMS(true);
        g4.dodajWierzch("a");
        g4.dodajWierzch("b");
        g4.dodajWierzch("c");
        g4.dodajWierzch("d");
        g4.dodajWierzch("e");
        g4.dodajKrawedz("a", "b","3");
        g4.dodajKrawedz("e", "d","1");
        g4.dodajKrawedz("e", "a","4");
        g4.dodajKrawedz("c", "b","2");
        g4.dodajKrawedz("d", "c", "1");
        g4.dodajKrawedz("a", "d", "3");
        g4.wyswietlgraf();
        g4.wyswietlKraw();
        g4.Kurskal();
        g4.BFS("b");
        g4.DFS("b");
        g4.SSSP("b");
        System.out.println();

    }
}
