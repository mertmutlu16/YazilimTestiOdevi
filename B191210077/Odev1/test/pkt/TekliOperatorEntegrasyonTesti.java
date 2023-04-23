/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	TekliOperatorSayaci ve DosyaOku için entegrasyon testi.
* </p>
*/
package pkt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TekliOperatorEntegrasyonTesti {
	
	 @Test
	 @DisplayName("Entegrasyon testi (Tekli operator)")  
	    public void entegrasyonTesti() throws FileNotFoundException {
		 DosyaOku dosyaOku = new DosyaOku();
		 	TekliOperatorSayaci tekliOperatorSayaci = new TekliOperatorSayaci();
			File dosya =new File("dosya.java");
		 	String okunmusDosya=dosyaOku.stringOku(dosya);
	
	        assertEquals(35, tekliOperatorSayaci.sayac(okunmusDosya));

	    }
}
