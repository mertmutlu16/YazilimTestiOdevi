/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	İkili operator sayısı test ediliyor. 
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

import com.github.javafaker.Faker;

class IkiliOperatorTest {


	private Kutuphane kutuphane ;
	@BeforeEach
	void setup() throws IOException {
       
		
		//File file = new File("C://Users//DELL//eclipse-workspace//Odev1//test//pkt//dosya.java");
		File dosya =new File("dosya.java");
		kutuphane= new Kutuphane(dosya);
	}
	
	@Test
	@DisplayName("İkili operatör testi 1")
	public void ikiliOperatorTesti1() {
		assertEquals(14, kutuphane.ikiliOperatorSayisi());
	}
	@Test
	@DisplayName("İkili operatör testi 2")
	public void ikiliOperatorTesti2() {
		IkiliOperatorSayaci ikiliOperatorSayaci = new IkiliOperatorSayaci(); 
		assertEquals(1, ikiliOperatorSayaci.sayac("y=x||z"));
	}
	
	 	@ParameterizedTest
	    @DisplayName("Parametreli İkili operatör testi 1")
		@CsvSource({"int sayi1=1"
					+ " int sayi2=2 "
					+ " sayi1 *= sayi2,1" ,"public void fonksiyon(int a){},0","String adSoyad ='mert'+'mutlu' ,0"})
	    public void parametreliIkiliOperatorTesti1(String veri , int beklenen) {
		 	IkiliOperatorSayaci ikiliOperatorSayaci = new IkiliOperatorSayaci();

	        assertEquals(beklenen, ikiliOperatorSayaci.sayac(veri));
	    }
		
		@ParameterizedTest
	    @DisplayName("Parametreli İkili operatör testi 2")
		@CsvSource({"String stringArray[] = new String[5],0" ," String buyukEsittir != tekliOperator,1"})
	    public void parametreliIkiliOperatorTesti2(String veri , int beklenen) {
			IkiliOperatorSayaci ikiliOperatorSayaci = new IkiliOperatorSayaci();

	        assertEquals(beklenen, ikiliOperatorSayaci.sayac(veri));
	    }
		
		@Test
	    @DisplayName("Faker ile İkili operatör testi")
	    public void fakerIleIkiliOperatorTesti() throws FileNotFoundException {
	        Faker faker = new Faker();
	        DosyaOku dsyOku= new DosyaOku();
			File dosya1 =new File("dosya1.java");
		 	String fakerSecenek1=dsyOku.stringOku(dosya1);
			File dosya2 =new File("dosya2.java");
		 	String fakerSecenek2=dsyOku.stringOku(dosya2);

	        String nesneFaker= faker.options().option(fakerSecenek1,fakerSecenek2);// İstersen dosya1 dosya2 dosya3 oluştur

	        IkiliOperatorSayaci ikiliOperatorSayaci = new IkiliOperatorSayaci();
	        assertEquals(3, ikiliOperatorSayaci.sayac(nesneFaker));
        
	}
		
	@RepeatedTest(5)
	@DisplayName("Tekrarlanan İkili operatör testi")
		 public void tekrarlananIkiliOperatorTesti() {
			 assertEquals(14, kutuphane.ikiliOperatorSayisi());
		 }

}
