/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	İlişksiel operator sayısı test ediliyor. 
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

class IliskiselOperatorTest {


	private Kutuphane kutuphane ;
	@BeforeEach
	void setup() throws IOException {
		File dosya =new File("dosya.java");
		kutuphane= new Kutuphane(dosya);
	}
	
	   
    @Test
    @DisplayName("İlişkisel operatör testi 1")
    public void iliskiselOperatorTesti1() { 
        assertEquals(6, kutuphane.iliskiselOperatorSayisi());
    }
    
    @Test
    @DisplayName("İlişkisel operatör testi 2")
    public void iliskiselOperatorTesti2() { 
    	IliskiselOperatorSayaci  iliskiselOperatorTesti = new IliskiselOperatorSayaci() ;
    	
        assertEquals(1, iliskiselOperatorTesti.sayac("if(a>=b) {return a-b};"
        											+ "else {return b-a;} "));
    }
    
	@ParameterizedTest
    @DisplayName("Parametreli ilişkisel operatör testi 1")
	@CsvSource({"if(a!=b) {return false },1","Tanimlama tanimlama = new Tanimlama(),0"})
    public void parametreliIliskiselOperatorTesti1(String veri , int beklenen) {
	 	IliskiselOperatorSayaci iliskiselOperatorSayaci = new IliskiselOperatorSayaci();

        assertEquals(beklenen, iliskiselOperatorSayaci.sayac(veri));
    }
	
	@ParameterizedTest
    @DisplayName("Parametreli ilişkisel operatör testi 2")
	@CsvSource({"x == y, 1"," boolean result = (a < b) && (b >= c) || (c != a);,3"})
    public void parametreliIliskiseOperatorTesti2(String veri , int beklenen) {
		IliskiselOperatorSayaci iliskiselOperatorSayaci = new IliskiselOperatorSayaci();

        assertEquals(beklenen, iliskiselOperatorSayaci.sayac(veri));
    }
	
	@Test
    @DisplayName("Faker ile İlişkisel operatör testi ")
    public void fakerIleIliskiselOperatorTesti()  {
        Faker faker = new Faker();
        String nesneFaker= faker.options().option("<",">","<=",">=","==","!=");
        IliskiselOperatorSayaci iliskiselOperatorSayaci = new IliskiselOperatorSayaci();
        assertEquals(1, iliskiselOperatorSayaci.sayac(nesneFaker));

    }
	
	
   	@Test
    @DisplayName("Mocklu İlişkisel operatör testi")
    public void mockIleIliskiselOperatorTesti() {
	   Kutuphane ktp= Mockito.mock(Kutuphane.class);
	   Mockito.when(ktp.iliskiselOperatorSayisi()).thenReturn(6);
        assertEquals(6, ktp.iliskiselOperatorSayisi());

    }
   	@RepeatedTest(7)
    @DisplayName("Tekrarlanan İlişkisel operatör testi")
    public void tekrarlananIliskiselOperatorTesti() {
        assertEquals(6, kutuphane.iliskiselOperatorSayisi());
    }
   	
	 
	
}
