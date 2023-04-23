/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	IkiliOperatorSayaci ve DosyaOku için entegrasyon testi.
* </p>
*/
package pkt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IkiliOperatorEntegrasyonTesti {

	 @Test
	 @DisplayName("Entegrasyon testi (İkili operator)")  
	    public void entegrasyonTestiIkiliOperator() throws FileNotFoundException {
		 	DosyaOku dosyaOku = new DosyaOku();
		 	IkiliOperatorSayaci ikiliOperatorSayaci = new IkiliOperatorSayaci();
			File dosya =new File("dosya.java");
		 	String okunmusDosya=dosyaOku.stringOku(dosya);
	
	        assertEquals(14, ikiliOperatorSayaci.sayac(okunmusDosya));

	    }

}
