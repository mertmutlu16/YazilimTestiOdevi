/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	MantiksalOperatorSayaci ve DosyaOku için entegrasyon testi.
* </p>
*/
package pkt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MantiksalOperatorEntegrasyonTesti {

	 @Test
	 @DisplayName("Entegrasyon testi (Mantıksal operator)") 
	    public void entegrasyonTestMantiksalOperator() throws FileNotFoundException {
		 	DosyaOku dosyaOku = new DosyaOku();
		 	MantiksalOperatorSayaci mantiksalOperatorSayaci = new MantiksalOperatorSayaci();
			File dosya =new File("dosya.java");
		 	String okunmusDosya=dosyaOku.stringOku(dosya);
	
	        assertEquals(3, mantiksalOperatorSayaci.sayac(okunmusDosya));

	    }

}
