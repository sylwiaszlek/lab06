package magazyn;


import magazyn.lab2.FulfillmentCenterContainer;
import magazyn.lab2.Item;
import magazyn.lab2.ItemCondition;

public class InitializationData {

    public static final FulfillmentCenterContainer fulfillmentCenterContainer = new FulfillmentCenterContainer();

    public static void initialize() {

        Item item1 = new Item("Ksiazka", ItemCondition.NEW, 100d, 10);
        Item item2 = new Item("Dlugopis", ItemCondition.REFURBISHED, 1900d, 7000);
        Item item3 = new Item("Ksiazka", ItemCondition.NEW, 7d, 2);
        Item item4 = new Item("Mis", ItemCondition.NEW, 1d, 1);
        Item item5 = new Item("Ksiazka dla dzieci", ItemCondition.NEW, 1d, 7);
        Item item6 = new Item("Aniol", ItemCondition.USED, 100d, 99);

//        FulfillmentCenter fulfillmentCenter = new FulfillmentCenter("Magazyn", new LinkedList<Item>(), 1500d);

//        //punkt a
//        System.out.println("Dodawanie produktow");
//        fulfillmentCenter.addProduct(item1);
//        fulfillmentCenter.addProduct(item2); //Pojemnosc przekroczona
//        fulfillmentCenter.addProduct(item3); //Zsumowanie ilosci
//        fulfillmentCenter.addProduct(item4);
//        fulfillmentCenter.addProduct(item5);
//        fulfillmentCenter.addProduct(item6);
//        System.out.println("=========================\n");
//
//        //punkt b
//        System.out.println("Wez jeden produkt");
//        fulfillmentCenter.getProduct(item4); //Wez produkt i go usun bo jego ilosc==0
//        System.out.println("=========================\n");
//
//        //punkt c
//        System.out.println("Usun calkowicie produkt");
//        fulfillmentCenter.removeProduct(item5); //Usun calkowicie produkt
//        System.out.println("=========================\n");
//
//        //punkt d
//        System.out.println("Znajdz produkt ksiazka");
//        System.out.println(fulfillmentCenter.search("Ksiazka").toString());
//        System.out.println("=========================\n");
//
//        //punkt e
//        System.out.println("Znajdz wszystkie pasujace do ksiazki");
//        System.out.println(fulfillmentCenter.searchPartial("Ksiazka").toString());
//        System.out.println("=========================\n");
//
//        //punkt f
//        System.out.println("Znajdz ile jest nowych produktow");
//        System.out.println(fulfillmentCenter.countByCondition(ItemCondition.NEW));
//        System.out.println("=========================\n");
//
//        //punkt g
//        System.out.println("Wypisanie wszystkich informacji na ekran");
//        fulfillmentCenter.summary();
//        System.out.println("=========================\n");
//
//        //punkt h
//        System.out.println("Sortuj po nazwie");
//        fulfillmentCenter.sortByName();
//        System.out.println(fulfillmentCenter.getListaProduktow().toString());
//        System.out.println("=========================\n");
//
//        //punkt i
//        System.out.println("Sortuj po ilosci malejaco");
//        fulfillmentCenter.sortByAmount();
//        System.out.println(fulfillmentCenter.getListaProduktow().toString());
//        System.out.println("=========================\n");
//
//        //punkt j
//        System.out.println("Ktorego produktu jest najwiecej");
//        System.out.println(fulfillmentCenter.max().toString());
//        System.out.println("=========================\n");

        //punkt a
        System.out.println("Dodawanie magazynow do spisu");
        fulfillmentCenterContainer.addCenter("Tokio", 10000);
        fulfillmentCenterContainer.addCenter("Ohio", 19000);
        fulfillmentCenterContainer.addCenter("Wuhan", 29000);
        fulfillmentCenterContainer.addCenter("Hajduszloboszlo", 100000);

        //Dodanie do magazynow kilku przedmiotow. Magazyn w wuhan bedzie pusty
        fulfillmentCenterContainer.getMagazinesMap().get("Tokio").addProduct(item1);
        fulfillmentCenterContainer.getMagazinesMap().get("Tokio").addProduct(item2);
        fulfillmentCenterContainer.getMagazinesMap().get("Tokio").addProduct(item5);
        fulfillmentCenterContainer.getMagazinesMap().get("Ohio").addProduct(item3);
        System.out.println("=========================\n");

//        //punkt b
//        System.out.println("Usuwanie wegierskiego magazynu");
//        fulfillmentCenterContainer.removeCenter("Hajduszloboszlo");
//        System.out.println("=========================\n");
//
//        //punkt c
//        System.out.println("Puste magazyny sa w ...");
//        System.out.println(fulfillmentCenterContainer.findEmpty().toString());
//        System.out.println("=========================\n");
//
//        //punkt d
//        System.out.println("Wszystkie magazyny:");
//        fulfillmentCenterContainer.summary();
//        System.out.println("=========================\n");
//
//        System.out.println("Mala uwaga. Informacja o przekroczeniu wyswietla sie w roznym miejscu");
//        System.out.println("Dzieje sie tak, poniewaz System.out i System.err to dwa osobne streamy");
//        System.out.println("Flushowane sa w roznym dla siebie czasie. Probowalam wymusic flush, ale tez nie dziala...");
    }
}


