import java.util.Scanner;

/*
Java ile mesafeye ve şartlara göre uçak bileti fiyatı hesaplayan programı yapın.
Kullanıcıdan Mesafe (KM), yaşı ve yolculuk tipi (Tek Yön, Gidiş-Dönüş) bilgilerini alın.
Mesafe başına ücret 0,10 TL / km olarak alın.
İlk olarak uçuşun toplam fiyatını hesaplayın ve sonrasında ki
koşullara göre müşteriye aşağıdaki indirimleri uygulayın ;

Kullanıcıdan alınan değerler geçerli (mesafe ve yaş değerleri pozitif sayı,
yolculuk tipi ise 1 veya 2) olmalıdır. Aksi takdirde kullanıcıya "Hatalı Veri Girdiniz !"
şeklinde bir uyarı verilmelidir.
Kişi 12 yaşından küçükse bilet fiyatı üzerinden %50 indirim uygulanır.
Kişi 12-24 yaşları arasında ise bilet fiyatı üzerinden %10 indirim uygulanır.
Kişi 65 yaşından büyük ise bilet fiyatı üzerinden %30 indirim uygulanır.
Kişi "Yolculuk Tipini" gidiş dönüş seçmiş ise bilet fiyatı üzerinden %20 indirim uygulanır.
 */
public class Main {
    public static void main(String[] args) {

        int yas, yolculukTipi;
        double mesafe, ucret, indirimliUcret, yasIndirimi;
        Scanner yazici = new Scanner(System.in);
        System.out.println("Lutfen gidis mesafinizi girin(KM):");
        mesafe = yazici.nextFloat();
        System.out.println("Yasinizi girin: ");
        yas = yazici.nextInt();
        System.out.println("Yolculuk tipinizi girin 1=> Tek yon, 2=> Gidis-Gelis");
        yolculukTipi = yazici.nextInt();

        ucret = mesafe * 0.10;
        indirimliUcret = ucret;
        if (mesafe > 0) {
            if (yas > 0) {
                if (yas < 12) {
                    yasIndirimi = ucret * 0.5;
                    indirimliUcret = ucret - yasIndirimi;
                } else if (12 <= yas && yas < 24) {
                    yasIndirimi = ucret * 0.10;
                    indirimliUcret = ucret - yasIndirimi;
                } else if (yas >= 65) {
                    yasIndirimi = ucret * 0.2;
                    indirimliUcret = ucret - yasIndirimi;
                }
            } else
                System.out.println("Hatali Veri Girisi!");
            if (yolculukTipi == 2) {
                indirimliUcret = indirimliUcret - (indirimliUcret * 0.2);
                indirimliUcret = indirimliUcret * 2;
                System.out.println(indirimliUcret);
            } else if (!(yolculukTipi == 2 && yolculukTipi == 1)) {
                System.out.println("Hatali giris!");
            }
            else
                System.out.println(indirimliUcret);

        } else
            System.out.println("Hatali Giris!");
        }
}
