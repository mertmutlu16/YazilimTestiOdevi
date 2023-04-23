/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	Mantıksal operator sayısı test ediliyor. 
* </p>
*/
package pkt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import com.github.javafaker.Faker;

class MantiksalOperatorTest {

	private Kutuphane kutuphane ;
	@BeforeEach
	void setup() throws IOException {
		File dosya =new File("dosya.java");
		kutuphane= new Kutuphane(dosya);
	}
	
	 @Test
	 @DisplayName(	"Mantıksal operator testi 1")
		 public void mantiksalOperatorTesti1() {
	        assertEquals(3, kutuphane.mantiksalOperatorSayisi());

		 }
	 @Test
	 @DisplayName(	"Mantıksal operator testi 2")
		 public void mantiksalOperatorTesti2() {
		 MantiksalOperatorSayaci mantiksalOperatorSayaci = new MantiksalOperatorSayaci();
	        assertEquals(1, mantiksalOperatorSayaci.sayac("boolean sonDurum = (durum1 && durum2);"));

		 }
	   	@RepeatedTest(10)
	    @DisplayName("Tekrarlanan Mantıksal operatör testi")
	    public void tekrarlananMantiksalOperatorTesti() {
	        assertEquals(3, kutuphane.mantiksalOperatorSayisi());
	    }
	   	
	   	@Test
	    @DisplayName("Mocklu Mantıksal operatör testi")
	    public void mockIleMantiksalOperatorTesti() {
		   Kutuphane ktp= Mockito.mock(Kutuphane.class);
		   Mockito.when(ktp.mantiksalOperatorSayisi()).thenReturn(3);
	        assertEquals(3, ktp.mantiksalOperatorSayisi());

	    }
		@Test
	    @DisplayName("Faker ile Mantıksal operatör testi ")
	    public void fakerIleMantiksalOperatorTesti()  {
	        Faker faker = new Faker();
	        String nesneFaker= faker.options().option("&&","||","!");// İstersen dosya1 dosya2 dosya3 oluştur
	        MantiksalOperatorSayaci mantiksalOperatorSayaci = new MantiksalOperatorSayaci();
	        assertEquals(1, mantiksalOperatorSayaci.sayac(nesneFaker));

	    }
	
		@ParameterizedTest
	    @DisplayName("Parametreli mantıksal operatör testi 1")
		@CsvSource({"boolean result = !condition1 || (condition2 && !condition1);,4 ","if(a!=b){return true;},0"})
	    public void parametreliMantiksalOperatorTesti1(String veri , int beklenen) {
		 	MantiksalOperatorSayaci mantiksalOperatorSayaci = new MantiksalOperatorSayaci();

	        assertEquals(beklenen, mantiksalOperatorSayaci.sayac(veri));
	    }
		
		@ParameterizedTest
	    @DisplayName("Parametreli mantıksal operatör testi 2")
		@CsvSource({"int x=5; int y=5; boolean son = true;  son = x&&y;, 1","boolean x=false; boolean y= true; boolean z= !x && y;,2"})
	    public void parametreliMantiksalOperatorTesti2(String veri , int beklenen) {
			MantiksalOperatorSayaci mantiksalOperatorSayaci = new MantiksalOperatorSayaci();

	        assertEquals(beklenen, mantiksalOperatorSayaci.sayac(veri));
	    }

}
