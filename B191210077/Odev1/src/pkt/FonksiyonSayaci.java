
/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	Test edilecek java kodunda toplam kaç adet fonksiyon bulunduğunu hesaplayan sınıf.
* </p>
*/
package pkt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FonksiyonSayaci extends Sayac {
	
	// Koddaki fonksiyonlar regex ile bulunuyor ve sayısı hesaplanıyor  .
	@Override
	public int sayac(String veri) {
		String regex = "\\b\\w+\\(";
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(veri);
    	int toplamFonksiyonSayisi = 0;
    	while (matcher.find()) {
    		toplamFonksiyonSayisi++;
    	}
    	return toplamFonksiyonSayisi;
    	
    }

}
