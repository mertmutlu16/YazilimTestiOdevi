/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	Test edilecek java kodunda toplam kaç adet ikili operatör(++,--,+=,-=,/=,*=,%=,&=,|=,^=,>=,<=,==,!=,&&,||) 
* 	bulunduğunu hesaplayan sınıf.
* </p>
*/
package pkt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IkiliOperatorSayaci extends Sayac {
	
	// Koddaki ikili operatorler regex ile bulunuyor ve sayısı hesaplanıyor.
	@Override
	public int sayac(String veri) {
		String regex = "\\+\\+|--|[+\\-*/%&|^]=|<=|>=|==|!=|&&|\\|\\|";
    	Pattern pattern = Pattern.compile(regex);
    	Matcher matcher = pattern.matcher(veri);
    	int toplamİkiliOperatorSayisi = 0;
    	while (matcher.find()) {
    		toplamİkiliOperatorSayisi++;
    	}
    	return toplamİkiliOperatorSayisi;
    }
}
