/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	Sayısal operator sayısı test ediliyor. 
* </p>
*/
package pkt;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import com.github.javafaker.Faker;

class SayisalOpertorTest {


	private Kutuphane kutuphane ;
	@BeforeEach
	void setup() throws IOException {
        //File file = new File("C://Users//DELL//eclipse-workspace//Odev1//test//pkt//dosya.java");
		File dosya =new File("dosya.java");
		kutuphane= new Kutuphane(dosya);
	}
	
    
    @Test
    @DisplayName("Sayısal operatör testi 1")
    public void sayisalOperatorTesti1() {
        assertEquals(40, kutuphane.sayisalOperatorSayisi());

    }
	@Test
	@DisplayName("Sayısal operatör testi 2")
	public void sayisalOperatorTesti2() {
		SayisalOperatorSayaci sayisalOperatorSayaci = new SayisalOperatorSayaci(); 
		assertEquals(1, sayisalOperatorSayaci.sayac("y=x||z"));
	}
	
	@ParameterizedTest
    @DisplayName("Parametreli sayısal operatör testi 1")
	@CsvSource({"int sonuc= ((a++ * b) + 10) / (a % b);, 6"," boolean sonuc2 = durum1 || durum2 ,1"})
    public void parametreliSayisalOperatorTesti1(String veri , int beklenen) {
	 	SayisalOperatorSayaci sayisalOperatorSayaci = new SayisalOperatorSayaci();

        assertEquals(beklenen, sayisalOperatorSayaci.sayac(veri));
    }
	
	@ParameterizedTest
    @DisplayName("Parametreli sayısal operatör testi 2")
	@CsvSource({"x != y, 0","public int kareAlFonk(int a){ return a*a },1"})
    public void parametreliSayisalOperatorTesti2(String veri , int beklenen) {
		SayisalOperatorSayaci sayisalOperatorSayaci = new SayisalOperatorSayaci();

        assertEquals(beklenen, sayisalOperatorSayaci.sayac(veri));
    }
	
	@Test
    @DisplayName("Faker ile Sayisal operatör testi")
    public void fakerIleSayisalOperatorTesti() throws FileNotFoundException {
        Faker faker = new Faker();
        DosyaOku dsyOku= new DosyaOku();
		File dosya1 =new File("dosya1.java");
	 	String fakerSecenek1=dsyOku.stringOku(dosya1);
		File dosya2 =new File("dosya2.java");
	 	String fakerSecenek2=dsyOku.stringOku(dosya2);

        String nesneFaker= faker.options().option(fakerSecenek1,fakerSecenek2);
        SayisalOperatorSayaci sayisalOperatorSayaci = new SayisalOperatorSayaci();
        assertEquals(5, sayisalOperatorSayaci.sayac(nesneFaker));
    
}
	
	
	   	@Test
	    @DisplayName("Mocklu Sayısal operatör testi")
	    public void mockIleSayisalOperatorTesti() {
		   Kutuphane ktp= Mockito.mock(Kutuphane.class);
		   Mockito.when(ktp.sayisalOperatorSayisi()).thenReturn(40);
	        assertEquals(40, ktp.sayisalOperatorSayisi());

	    }
	
	
	   	@RepeatedTest(10)
	    @DisplayName("Tekrarlanan Sayısal operatör testi")
	    public void tekrarlanansayisalOperatorTesti() {
	        assertEquals(40, kutuphane.sayisalOperatorSayisi());
	    }



}
