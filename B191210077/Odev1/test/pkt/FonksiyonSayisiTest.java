/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	Fonksiyon sayısı test ediliyor. 
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

class FonksiyonSayisiTest {


	private Kutuphane kutuphane ;
	@BeforeEach
	void setup() throws IOException {
		File dosya =new File("dosya.java");
		kutuphane= new Kutuphane(dosya);
	}
	
	@Test
    @DisplayName("Fonksiyon sayısı testi 1")
    public void fonksiyonSayisiTesti1() {
        assertEquals(2, kutuphane.fonksiyonSayisi());

    }
    @Test
    @DisplayName("Fonksiyon sayısı testi 2")
    public void fonksiyonSayisiTesti2() {
    	FonksiyonSayaci fonksiyonSayaci = new FonksiyonSayaci();
        assertEquals(1, fonksiyonSayaci.sayac("public boolean javaFonkTest(){ return false;} "));

    }
    @Test
    @DisplayName("Fonksiyon sayısı testi 3")
    public void fonksiyonSayisiTesti3() {
    	FonksiyonSayaci fonksiyonSayaci = new FonksiyonSayaci();
        assertEquals(4, fonksiyonSayaci.sayac("	public int sayac(String veri) {\r\n"
        		+ "		String regex = \"\\\\b\\\\w+\\\\(\";\r\n"
        		+ "    	Pattern pattern = Pattern.compile(regex);\r\n"
        		+ "    	Matcher matcher = pattern.matcher(veri);\r\n"
        		+ "    	int toplamFonksiyonSayisi = 0;\r\n"
        		+ "    	while (matcher.find()) {\r\n"
        		+ "    		toplamFonksiyonSayisi++;\r\n"
        		+ "    	}\r\n"
        		+ "    	return toplamFonksiyonSayisi;\r\n"
        		+ "    	\r\n"
        		+ "    }"));

    }
    @Test
    @DisplayName("Fonksiyon sayısı testi 4")
    public void fonksiyonSayisiTesti4() {
    	FonksiyonSayaci fonksiyonSayaci = new FonksiyonSayaci();
        assertEquals(1, fonksiyonSayaci.sayac("helloWorld()"));
    }

	 	@ParameterizedTest
	    @DisplayName("Parametreli Fonksiyon Sayısı testi 1")
		@CsvSource({"&& != ,0 ","public String fonksiyonSayisi(String str){ return str+' '+str },1"})
	    public void parametreliFonksiyonSayısıTesti1(String veri , int beklenen) {
		 	FonksiyonSayaci fonksiyonSayaci = new FonksiyonSayaci();

	        assertEquals(beklenen, fonksiyonSayaci.sayac(veri));
	    }
		
		@ParameterizedTest
	    @DisplayName("Parametreli Fonksiyon Sayısı testi 2")
		@CsvSource({"int sonuc=((a++ * b) + 10) /(a % b);, 0","public static int factorial(int n) {"
																+ "if (n == 0) {  "
																+ "        return 1;"
																+ "    } else {"
																+ "        return n * factorial(n-1); }} ,2 " })
	    public void parametreliFonksiyonSayısıTesti2(String veri , int beklenen) {
			FonksiyonSayaci fonksiyonSayaci = new FonksiyonSayaci();

	        assertEquals(beklenen, fonksiyonSayaci.sayac(veri));
	    }
		 
		   	@Test
		    @DisplayName("Mocklu Fonksiyon Sayısı testi")
		    public void mockIleFonksiyonSayisiTesti() {
			   Kutuphane ktp= Mockito.mock(Kutuphane.class);
			   Mockito.when(ktp.fonksiyonSayisi()).thenReturn(2);
		        assertEquals(2, ktp.fonksiyonSayisi());

		    }
		   	@RepeatedTest(10)
		    @DisplayName("Tekrarlanan Fonksiyon Sayısı testi")
		    public void tekrarlananFonksiyonSayisiTesti() {
		        assertEquals(2, kutuphane.fonksiyonSayisi());
		    }
		   	
			@Test
		    @DisplayName("Faker ile Fonksiyon Sayısı testi")
		    public void fakerIleFonksiyonTestiTesti() throws FileNotFoundException {
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
}
