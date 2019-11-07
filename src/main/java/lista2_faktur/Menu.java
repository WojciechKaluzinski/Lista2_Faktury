package lista2_faktur;
import java.util.Scanner;



public class Menu {
    /** przechowywacz wyboru*/
    private static int wybor;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        PanelGlowny();

    }
    /** Menu*/
    static void PanelGlowny()
    {
        System.out.println("Wtaj w generatorze faktur!\n" );
        System.out.println("1 - Dodaj Klienta\n" );
        System.out.println("2 - Wystaw fakture\n" );
        System.out.println("3 - Wyswietl klientow\n" );
        System.out.println("4 - Wyswietl faktury\n" );
        System.out.println("5 - Wyswietl 1 konkretnego klienta\n" );
        System.out.println("6 - Wgraj wszystkie dotychczasow zmiany do bazy\n" );
        wybor = scanner.nextInt();


        switch (wybor) {
            case 1:
                ZarzadzajKlientami.DodajKlienta();
            case 2:
                ZarzadzajFakturami.WystawFakture();
            case 3:
                ZarzadzajKlientami.WyswietlKlientow();
            case 4:
                ZarzadzajFakturami.WyswietlFaktury();
            case 5:
            {
                System.out.println("Podaj jego ID" );
                wybor = scanner.nextInt();
                ZarzadzajKlientami.WyswietlKlienta(wybor);
            }
            case 6:
                ZarzadzanieZewnetrznaBaza.DodajDoBazy();
        }
    }
}

