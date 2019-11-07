package lista2_faktur;

import java.util.ArrayList;
import java.util.List;

public class Faktura
{
    lista2_faktur.Klient klient;
    List<String> ListaNazwProduktu = new ArrayList<String>();
    List<Integer> ListaIlosciProduktu = new ArrayList<Integer>();
    List<Float> ListaKwotProduktu = new ArrayList<Float>();



    public float Pokaz_sume( List<Float> ListaKwotProduktu,  List<Integer> ListaIlosciProduktu )
    {
        float suma=0;
        for(int j=0; j< ListaKwotProduktu.size(); j++)
        {
            suma=suma+ListaKwotProduktu.get(j)*ListaIlosciProduktu.get(j);
        }
        return suma;
    }



    String getNIP(){return klient.NIP;}
    String getNazwa(){return klient.nazwa;}
    String getAdres(){return klient.adres;}
    List<String> getNazwaProduktu(){return ListaNazwProduktu;}
    List<Integer> getIloscProduktu(){return ListaIlosciProduktu;}
    List<Float> getKwotaProduktu(){return ListaKwotProduktu;}

    Float getSuma(){return Pokaz_sume( ListaKwotProduktu,  ListaIlosciProduktu );}
}
