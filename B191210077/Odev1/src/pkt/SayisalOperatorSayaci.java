/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	Test edilecek java kodunda toplam kaç adet sayısal operator(+,++,-,--,*,/,%,&,|,^,=,+=,-=,/=,*=,%=,&=,|=,^=)
* 	 bulunduğunu hesaplayan sınıf.
* </p>
*/
package pkt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SayisalOperatorSayaci  extends Sayac {
	
	
	@Override
	public int sayac(String veri) {
		
		// Önce ilişkisel ve mantıksal operatorler bulunuyor ve koddan çıkartılıyor. Daha sonra tekli ve ikili 
		// operatorler bulunarak toplam sayısal operator sayısı bulunuyor.
		String regex = "[<>]=?|==|!=";
		String sonuc = veri.replaceAll(regex, "");
		
		String regex2 = "(?!<!=)(&&|\\|\\||!)(?!=)";
		String sonuc2 = sonuc.replaceAll(regex2, "");
		
		TekliOperatorSayaci tekliOperatorSayaci=new TekliOperatorSayaci();
		int tekliSayisalOperatorSayisi  = tekliOperatorSayaci.sayac(sonuc2);
		
		IkiliOperatorSayaci ikiliOperatorSayaci = new IkiliOperatorSayaci();
		int ikiliSayisalOperatorSayisi = ikiliOperatorSayaci.sayac(sonuc2);

		return tekliSayisalOperatorSayisi+ ikiliSayisalOperatorSayisi;
    }
}




