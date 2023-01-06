package Eken.Shops.model;

import Eken.Shops.model.CategoryFourth;
import Eken.Shops.model.CategoryMain;
import Eken.Shops.model.CategorySecond;
import Eken.Shops.model.CategoryThird;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;


@Entity
@Data
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private double currentPrice;
    private double oldPrice;
    private boolean isExist=true;
    private boolean isShow=true;
    private String name;
    private  String brand;
    private  String feature1;
    private  String feature2;
    private  String feature3;
    private  String feature4;
    private  String feature5;
    private  String feature6;
    private  String feature7;
    private  String feature8;
    private  String feature9;
    private  String feature10;
    private  String feature11;
    private  String feature12;
    private  String feature13;
    private  String feature14;
    private  String feature15;
    private  String feature16;
    private  String feature17;
    private  String feature18;
    private  String feature19;
    private  String feature20;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private String img5;
    private String img6;
    private String img7;
    private String img8;
    private String img9;
    private String img10;
    private double star;
    private int numComments;
    private String companyName;
    private Long compId;
    private boolean discount;
    private  Long discountRate;
    private Long soldCount;

    @JoinColumn(name="ctgm", nullable=true)
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    CategoryMain categoryMain;

    @JoinColumn(name="ctg2", nullable=true)
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    CategorySecond categorySecond;

    @JoinColumn(name="ctg3", nullable=true)
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    CategoryThird categoryThird;

    @JoinColumn(name="ctg4", nullable=true)
    @ManyToOne(fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
    CategoryFourth categoryFourth;

}
// urun ozellikleri feature1 = urunun ozeelik ismi, feature2 ise feature1 in aciklamasidir. karsina yazilacak
// urun aciklmalari ayri bir tablodan getirilebilir.
// amazon web sitesi ornek alinarak yapiliyor ... her urunun farkli sayida ozellikleri var. geneli 10 ozellikli
// ayni tip urunlerin ozellik isimleri (feature1 leri) bire bir yni olmali ki karsilastirma ekrani yapilip orda
// sag blok da ozellik isimleri yazilir, her urunun kendi ozelligi ise alt sirada yazilir.
// her ozellik ismi de bir kategory olarak onceden belirlenebilir.
// daha onceden belirlenmis kategorilere gore urun kayit sayfasi olusturulup, kayit esnasinda buna gore doldurulabilir
// her bir ozelligin ayri kategilere baglanmasi sistemin yavaslamasina sebep olur mu?
// aranilan urun dh HIZLI MI BULUNUR
// OZELLIK ISIMLERININ FARKLI YAZILMASININ VEYA UNUTULMSININ ONUNE GECMIS OLUNUR,
// URUNUN SON OZELLIGI ASLINDA BIR KATEGORI OLMUS OLUYOR, URUN KAYDI YAPILIRKEN OZELLIK SECENEKLERDEN SECILEREK ATAMASI
//YAPILIR,
// ILK 3 YA DA 4 KATEGORIDEN SONRA URUNLERIN ORTAK OZELLIKLERI BELIRTILIR.
// HER SON OZELLIGI KENDI UZMANI TARAFINDAN BELIRLENIP YAZILIR
// OZELLIKLERI BARIZ BILINEN VE ARASTIRILAN URUNLER ALT KATEGORILERE AYRILABILIR.
// DETAYLI OZELLIGI COK BILINMEYEN URUNLER ISE GENEL OZELLIKLERIYLE SINIFLANDIRILIYOR, GENEL BASIT URUN DETAYLARINA ATIF
// --- YAPILMAYAN OZELLIKLERI BELIRTILIR. BU URUNU KIM KULLANIR = YETISKIN, PILLE MI CALISIR = PILSIZ, ELEKTRIKSIZ GIBI.
//
