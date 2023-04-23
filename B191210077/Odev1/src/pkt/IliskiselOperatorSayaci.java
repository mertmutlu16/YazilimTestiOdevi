/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	Test edilecek java kodunda toplam kaç adet ilişkisel operatör(<,>,<=,>=,==,!=) 
* 	bulunduğunu hesaplayan sınıf.
* </p>
*/
package pkt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IliskiselOperatorSayaci  extends Sayac {
	
	// Koddaki ilişkisel operatorler regex ile bulunuyor ve sayısı hesaplanıyor.

	@Override
	public int sayac(String veri) {
		String regex = "[<>]=?|==|!=";
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(veri);
    	int toplamIliskiselOperatorSayisi = 0;
    	while (matcher.find()) {
    		toplamIliskiselOperatorSayisi++;
    	}
    	return toplamIliskiselOperatorSayisi;
    }
}
