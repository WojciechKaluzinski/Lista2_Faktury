package testFaktura;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import lista2_faktur.Faktura;

public class TestFaktura extends Faktura {


    @Test
    public void test() {
        List<Integer> ListaIlosciProduktu = new ArrayList<Integer>();
        List<Float> ListaKwotProduktu = new ArrayList<Float>();
        ListaKwotProduktu.add((float) 5.5);
        ListaIlosciProduktu.add(2);
        Faktura test= new Faktura();
        float output = test.Pokaz_sume(ListaKwotProduktu,ListaIlosciProduktu);
        float a=(float) 11.0;

        assert(a==output);

    }

}