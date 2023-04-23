/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	Test edilecek java kodunda toplam kaç adet tekli operator(+,-,*,/,%,&,|,^,<,>,!) 
* 	bulunduğunu hesaplayan sınıf.
* </p>
*/
package pkt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TekliOperatorSayaci  extends Sayac {
	
	@Override
	// Tekli operatorleri bulmak için ilk önce tüm operatorler bulnuyor . Daha sonra tüm ikili operatorler bulunuyor 
	// ve tümünden çıkartılarak tekli operator sayısı bulunuyor.
	public int sayac(String veri) {
		String regex = "[+\\-*/|&%^=!<>]";
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(veri);
    	int toplamTekliOperatorSayisi = 0;
    	while (matcher.find()) {
    		toplamTekliOperatorSayisi++;
    	}
    	
		String regex2 = "\\+\\+|--|[+\\-*/%&|^]=|<=|>=|==|!=|&&|\\|\\|";
    	Pattern pattern2 = Pattern.compile(regex2);
    	Matcher matcher2 = pattern2.matcher(veri);
    	int toplamIkiliOperatorSayisi = 0;
    	while (matcher2.find()) {
    		toplamIkiliOperatorSayisi++;
    	}
    	return (toplamTekliOperatorSayisi-(toplamIkiliOperatorSayisi*2));
    }
}
