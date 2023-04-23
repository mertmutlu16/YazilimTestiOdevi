/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	IliskiselOperatorSayaci ve DosyaOku için entegrasyon testi.
* </p>
*/
package pkt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IliskiselOperatorEntegrasyonTesti {

	@Test
	 @DisplayName("Entegrasyon testi (İlişkisel operator)")  
	 public void entegrasyonTestiIliskiselOperator() throws FileNotFoundException {
		 	DosyaOku dosyaOku = new DosyaOku();
		 	IliskiselOperatorSayaci iliskiselOperatorSayaci = new IliskiselOperatorSayaci();
			File dosya =new File("dosya.java");
		 	String okunmusDosya=dosyaOku.stringOku(dosya);
	
	        assertEquals(6, iliskiselOperatorSayaci.sayac(okunmusDosya));

	    }

}
