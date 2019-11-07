package lista2_faktur;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/** Dodawanie klienta*/
class ZarzadzajKlientami{
    private static Scanner scanner = new Scanner(System.in);
    /** Listy Klientow*/
    static List<Klient> ListaKlientow = new ArrayList<Klient>();

    /** Wyswietlanie klientow*/
    static void WyswietlKlientow()
    {
        for(int i=0; i< ListaKlientow.size(); i++)
        {
            System.out.println("ID: "+i+" NIP: "+""+ListaKlientow.get(i).getNIP()+" Nazwa: "+ListaKlientow.get(i).getNazwa()+"Adres: "+ListaKlientow.get(i).getAdres());
        }

        Menu.PanelGlowny();

    }

    /** Wyswietlanie 1 klienta*/
    static void WyswietlKlienta(int id)
    {
        System.out.println("DANE KLIENTA");
        System.out.println("ID: "+id+" NIP: "+""+ListaKlientow.get(id).getNIP()+" Nazwa: "+ListaKlientow.get(id).getNazwa()+"Adres: "+ListaKlientow.get(id).getAdres());
        System.out.println("JEGO FAKTURY");
        /** Wyswietlanie faktur tego 1 klienta*/
        for(int i=0; i< ZarzadzajFakturami.ListaFaktur.size(); i++)
        {
            /** Sprawdzanie ktora faktura jest jego i wyswietlanie*/

            if(ZarzadzajFakturami.ListaFaktur.get(i).getNIP()==ListaKlientow.get(id).getNIP()) //NIP jest unikalny- nie moze sie powtorzyc 2 razy. Dlatego go sprawdzam
            {
                System.out.println("Faktura nr "+i+" Dane Kupujacego:\n NIP: "+""+ZarzadzajFakturami.ListaFaktur.get(i).getNIP()+" Nazwa: "+ZarzadzajFakturami.ListaFaktur.get(i).getNazwa()+" Adres: "+ZarzadzajFakturami.ListaFaktur.get(i).getAdres()+ "\nLista produktow: ");
                List<String> ListaNazwProduktu =new ArrayList<String>();
                List<Integer> ListaIlosciProduktu = new ArrayList<Integer>();
                List<Float> ListaKwotaProduktu =new ArrayList<Float>();
                ListaNazwProduktu=ZarzadzajFakturami.ListaFaktur.get(i).getNazwaProduktu();
                ListaIlosciProduktu=ZarzadzajFakturami.ListaFaktur.get(i).getIloscProduktu();
                ListaKwotaProduktu=ZarzadzajFakturami.ListaFaktur.get(i).getKwotaProduktu();
                System.out.println("Nazwa:       | Ilosc:     |Cena:  ");
                for(int j=0; j< ListaNazwProduktu.size(); j++)
                {
                    System.out.println(ListaNazwProduktu.get(j)+"   "+ListaIlosciProduktu.get(j)+"   "+ListaKwotaProduktu.get(j));
                }
                System.out.println("Suma: "+ZarzadzajFakturami.ListaFaktur.get(i).getSuma());
            }
        }
        Menu.PanelGlowny();

    }



    static void DodajKlienta()
    {
        Klient klient2 = new Klient();
        System.out.println("Dodawanie klienta" );
        System.out.println("Podaj nazwe: " );
        klient2.nazwa = scanner.nextLine();
        System.out.println("Podaj NIP: " );
        klient2.NIP= scanner.nextLine();
      	 /*while( NIP.length()!=10)
      	{
           	 System.out.println("Podales zly NIP: \nPodaj NIP:" );
          	 NIP = scanner.nextLine();
      	}*/
        System.out.println("Podaj adres: " );
        klient2.adres = scanner.nextLine();





        ListaKlientow.add(klient2);
        Menu.PanelGlowny();
    }

}
