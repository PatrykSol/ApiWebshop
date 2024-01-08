package com.example.webshopapi.seeder;

import com.example.webshopapi.dao.ProductDAO;
import com.example.webshopapi.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductSeeder {

    @Autowired
    private ProductDAO productDAO;

    public void seed() {
        Product product1 = new Product();
        product1.setCategoryId(1);
        product1.setDescription("Wanneer je iets groots wilt toevoegen aan je DAW en computer set-up kom je zonder twijfel bij de Arturia Keylab 88 MKII uit! Een stevig MIDI/USB keyboard in de kleur zwart, voorzien van alles wat je nodig hebt. Deze versie beschikt over maar liefst 88 toetsen, 9 faders, 9 encoders en 16 RGB verlichte pads. Je muis kun je bij deze Arturia gerust links laten liggen (of rechts), want met de transportknoppen kun je nagenoeg alles bedienen. Hierdoor gaat je workflow er enorm op vooruit en zul je synths bedienen als nooit tevoren.");
        String[] imageUrls1 = new String[]{
                "https://static.bax-shop.nl/image/product/720015/2528361/5e18eab4/1606466554keylab-88-mkii-black_1.jpg",
                "https://static.bax-shop.nl/image/product/720015/2528361/5e18eab4/1606466554keylab-88-mkii-black_2.jpg"
        };
        product1.setImageUrls(imageUrls1);
        product1.setManufacturer("Yamaha");
        product1.setName("Arturia Keylab 88 MKII BK USB/MIDI keyboard zwart");
        product1.setPrice(999.99);
        product1.setStockquantity(7);

        this.productDAO.save(product1);

//        Product product2 = new Product();
//        product2.setName("Jackson X Series Rhoads RRX24 Matte Army Drab elektrische gitaar");
//        product2.setDescription("Achter de Jackson Rhoads X Series schuilt natuurlijk de onsterfelijke gitaarheld, Randy Rhoads. Deze instrumenten staan bekend om hun 'zeer snelle' bespeelbaarheid, geweldige klank en de uitstekende betaalbaarheid. Dit instrument is uitgerust met een populier houten body en een neck-through-body constructie. Dat laatste geeft de gitaar een ongelofelijke sustain en een prima stabiliteit waardoor wijzigingen in de temperatuur en vochtigheid weinig grip krijgen op de neck. Met name door de versteviging van grafiet in de hals. Dit gekoppeld aan de compound radius van de laurier toets, speelt het instrument bijzonder comfortabel. Doordat de toetsradius langzaam verloopt van 12 naar 16 inch, kun je hoger op het fretboard de snaren gemakkelijker opdrukken, terwjl het bespelen van akkoorden vertrouwd aanvoelt. De onmiskenbare sharkfin inlays, in dit geval 'reversed', zijn altijd een feest van herkenning. ");
//        product2.setPrice(792.00);
//        product2.setStockquantity(0);
//        product2.setCategoryid(2);
//        product2.setManufacturer("Jackson");
//
//        String[] imageUrls2 = new String[]{
//                "https://static.bax-shop.nl/image/product/1061690/4120067/8e80229d/450x450/16764589122913636520_jac_ins_frt_1_rr.jpg",
//                "https://static.bax-shop.nl/image/product/1061690/4120069/1a532745/450x450/16764589132913636520_jac_ins_fbd_1_nr.jpg",
//                "https://static.bax-shop.nl/image/product/1061690/4120070/10e9cd46/450x450/16764589132913636520_jac_ins_cbr_1_nr.jpg",
//                "https://static.bax-shop.nl/image/product/1061690/4120071/45f43a86/450x450/16764589142913636520_jac_ins_hft_1_nr.jpg"
//        };
//        product2.setImageUrls(imageUrls2);
//
//        this.productDAO.save(product2);
//
//        Product product3 = new Product();
//        product3.setName("Arturia Keylab 88 MKII BK USB/MIDI keyboard zwart");
//        product3.setDescription("Wanneer je iets groots wilt toevoegen aan je DAW en computer set-up kom je zonder twijfel bij de Arturia Keylab 88 MKII uit! Een stevig MIDI/USB keyboard in de kleur zwart, voorzien van alles wat je nodig hebt. Deze versie beschikt over maar liefst 88 toetsen, 9 faders, 9 encoders en 16 RGB verlichte pads. Je muis kun je bij deze Arturia gerust links laten liggen (of rechts), want met de transportknoppen kun je nagenoeg alles bedienen. Hierdoor gaat je workflow er enorm op vooruit en zul je synths bedienen als nooit tevoren.");
//        product3.setPrice(999.99);
//        product3.setStockquantity(25);
//        product3.setCategoryid(3);
//        product3.setManufacturer("Yamaha");
//
//        String[] imageUrls3 = new String[]{
//                "https://static.bax-shop.nl/image/product/720015/2528361/5e18eab4/1606466554keylab-88-mkii-black_1.jpg",
//                "https://static.bax-shop.nl/image/product/720015/2528361/5e18eab4/1606466554keylab-88-mkii-black_2.jpg"
//        };
//        product3.setImageUrls(imageUrls3);
//
//        this.productDAO.save(product3);

    }
}
