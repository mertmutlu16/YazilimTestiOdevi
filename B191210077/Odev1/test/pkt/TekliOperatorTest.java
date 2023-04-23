/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	Tekli operator sayısı test ediliyor. 
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

class TekliOperatorTest {


	private Kutuphane kutuphane ;
	@BeforeEach
	void setup() throws IOException {
        //File file = new File("C://Users//DELL//eclipse-workspace//Odev1//test//pkt//dosya.java");
		File dosya =new File("dosya.java");
		kutuphane= new Kutuphane(dosya);
	}
	
	 @Test
	    @DisplayName("Tekli operatör testi")
	    public void tekliOperatorTesti() {
	        assertEquals(35, kutuphane.tekliOperatorSayisi());

	    }
	 @Test
	    @DisplayName("Tekli operatör testi 2")
	    public void tekliOperatorTesti2() {
		 TekliOperatorSayaci tekliOperatorSayaci = new TekliOperatorSayaci();
	        assertEquals(5, tekliOperatorSayaci.sayac("int a=1+(2^3)*(4/5)"));

	    }

	
	@ParameterizedTest
    @DisplayName("Parametreli Tekli operatör testi 1")
	@CsvSource({"int a=1+(2^3)*(4/5), 5","for(int i=0;i<100;i++),2"})
    public void parametreliTekliOperatorTesti1(String veri , int beklenen) {
	 	TekliOperatorSayaci tekliOperatorSayaci = new TekliOperatorSayaci();

        assertEquals(beklenen, tekliOperatorSayaci.sayac(veri));
    }
	
	@ParameterizedTest
    @DisplayName("Parametreli Tekli operatör testi 2")
	@CsvSource({"x ^= y, 0","System.out.println(string1+' '+string2),2"})
    public void parametreliTekliOperatorTesti2(String veri , int beklenen) {
	 	TekliOperatorSayaci tekliOperatorSayaci = new TekliOperatorSayaci();

        assertEquals(beklenen, tekliOperatorSayaci.sayac(veri));
    }
	
	@Test
    @DisplayName("Faker ile Tekli operatör testi")
    public void fakerIleTekliOperatorTesti() throws FileNotFoundException {
        Faker faker = new Faker();
        DosyaOku dsyOku= new DosyaOku();
		File dosya1 =new File("dosya1.java");
	 	String fakerSecenek1=dsyOku.stringOku(dosya1);
		File dosya2 =new File("dosya2.java");
	 	String fakerSecenek2=dsyOku.stringOku(dosya2);

        String nesneFaker= faker.options().option(fakerSecenek1,fakerSecenek2);

        TekliOperatorSayaci tekliOperatorSayaci = new TekliOperatorSayaci();
        assertEquals(3, tekliOperatorSayaci.sayac(nesneFaker));

    } 
	
	@Test
    @DisplayName("Faker ile Tekli operatör testi 2")
    public void fakerIleTekliOperatorTesti2()  {
        Faker faker = new Faker();
        String nesneFaker= faker.options().option("+","-","/","%","&","|","!","<",">","^","=");
        int intFaker1 = faker.random().nextInt(49) + 1;
        int intFaker2 = faker.random().nextInt(9) + 1;
        TekliOperatorSayaci tekliOperatorSayaci = new TekliOperatorSayaci();
        assertEquals(1, tekliOperatorSayaci.sayac(Integer.toString(intFaker1)+nesneFaker+Integer.toString(intFaker2)));
       
    }


	
	   @Test
	    @DisplayName("Mocklu Tekli operatör testi")
	    public void mockIleTekliOperatorTesti() {
		   Kutuphane ktp= Mockito.mock(Kutuphane.class);
		   Mockito.when(ktp.tekliOperatorSayisi()).thenReturn(35);
	        assertEquals(35, ktp.tekliOperatorSayisi());

	    }
	
	
	   @RepeatedTest(10)
	    @DisplayName("Tekrarlanan Tekli operatör testi")
	    public void tekrarlananTekliOperatorTesti() {
	        assertEquals(35, kutuphane.tekliOperatorSayisi());
	    }



}
