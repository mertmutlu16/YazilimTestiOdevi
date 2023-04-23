/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	FonksiyonSayacı ve DosyaOku için entegrasyon testi.
* </p>
*/
package pkt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FonksiyonSayisiEntegrasyonTesti {

	 @Test
	 @DisplayName("Entegrasyon testi (Fonksiyon Sayısı)")  
	    public void entegrasyonTestFonksiyonSayisi() throws FileNotFoundException {
		 	DosyaOku dosyaOku = new DosyaOku();
		 	FonksiyonSayaci fonksiyonSayaci = new FonksiyonSayaci();
			File dosya =new File("dosya.java");
		 	String okunmusDosya=dosyaOku.stringOku(dosya);
	
	        assertEquals(2, fonksiyonSayaci.sayac(okunmusDosya));

	    }

}
