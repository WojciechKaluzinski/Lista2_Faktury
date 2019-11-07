package lista2_faktur;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class ZarzadzajFakturami {
    private static Scanner scanner = new Scanner(System.in);
    /** Listy Faktur*/
    static List<Faktura> ListaFaktur = new ArrayList<Faktura>();
    int kwota;


    /** Wystawianie faktury*/
    static void WystawFakture()
    {
        int a=-1;
        String dodawanieProduktu = "y";
        String nazwaProduktu;
        Float cenaProduktu;
        int iloscProduktu;
        Faktura faktura2 = new Faktura();

        List<String> ListaNazw = new ArrayList<String>();
        List<Integer> ListaIlosci = new ArrayList<Integer>();
        List<Float> ListaCen = new ArrayList<Float>();


        for(int i=0; i< ZarzadzajKlientami.ListaKlientow.size(); i++)
        {
            System.out.println("ID: "+i+" NIP: "+""+ZarzadzajKlientami.ListaKlientow.get(i).getNIP()+" Nazwa: "+ZarzadzajKlientami.ListaKlientow.get(i).getNazwa()+"Adres: "+ZarzadzajKlientami.ListaKlientow.get(i).getAdres());
        }
        System.out.println("Witaj w kreatorze faktur! \nU gory zostali wyswietleni klienci" );
        while(a> (ZarzadzajKlientami.ListaKlientow.size()-1) || a<0)
        {
            System.out.println("Podaj ID Klienta na ktorego bedzie wystawiona faktura:" );
            a = scanner.nextInt();
        }
        while (dodawanieProduktu.equals("y"))
        {
            System.out.println("Podaj nazwe produktu: " );
            nazwaProduktu=scanner.nextLine();
            nazwaProduktu=scanner.nextLine();
            ListaNazw.add(nazwaProduktu);

            System.out.println("Ilosc: " );
            iloscProduktu = scanner.nextInt();
            ListaIlosci.add(iloscProduktu);

            System.out.println("Cene: " );
            cenaProduktu = scanner.nextFloat();
            ListaCen.add(cenaProduktu);

            System.out.println("Czy chcesz dodac nastepny produkt(y/n)? " );
            dodawanieProduktu = scanner.nextLine();
            dodawanieProduktu = scanner.nextLine();
        }
        faktura2.ListaNazwProduktu=ListaNazw;
        faktura2.ListaKwotProduktu =ListaCen;
        faktura2.ListaIlosciProduktu=ListaIlosci;
        Klient klientTMP = (Klient)ZarzadzajKlientami.ListaKlientow.get(a);
        faktura2.klient=klientTMP;

        ListaFaktur.add(faktura2);
        System.out.println("1- Wystaw nowa fakture" );
        System.out.println("(inny numer) - Wroc do menu" );
        if(scanner.nextInt()==1) WystawFakture();
        Menu.PanelGlowny();

    }
    /** Wyswietlanie faktur*/
    static void WyswietlFaktury()
    {
        for(int i=0; i< ListaFaktur.size(); i++)
        {

            System.out.println("Faktura nr "+i+" Dane Kupujacego:\n NIP: "+""+ListaFaktur.get(i).getNIP()+" Nazwa: "+ListaFaktur.get(i).getNazwa()+" Adres: "+ListaFaktur.get(i).getAdres()+ "\nLista produktow: ");
            List<String> ListaNazwProduktu =new ArrayList<String>();
            List<Integer> ListaIlosciProduktu = new ArrayList<Integer>();
            List<Float> ListaKwotaProduktu =new ArrayList<Float>();;
            ListaNazwProduktu=ListaFaktur.get(i).getNazwaProduktu();
            ListaIlosciProduktu=ListaFaktur.get(i).getIloscProduktu();
            ListaKwotaProduktu=ListaFaktur.get(i).getKwotaProduktu();
            System.out.println("Nazwa:       | Ilosc:     |Cena:  ");

            for(int j=0; j< ListaNazwProduktu.size(); j++)
            {
                System.out.println(ListaNazwProduktu.get(j)+"   "+ListaIlosciProduktu.get(j)+"   "+ListaKwotaProduktu.get(j));
            }

            System.out.println("Suma: "+ListaFaktur.get(i).getSuma());

        }
        System.out.println("1- Wystaw nowa fakture" );
        System.out.println("(inny numer) - Wroc do menu" );
        if(scanner.nextInt()==1) WystawFakture();
        Menu.PanelGlowny();
    }
}