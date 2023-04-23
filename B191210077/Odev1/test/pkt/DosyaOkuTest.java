/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	DosyaOku sınıfının açılıp açılmadığını test ediliyor.
* </p>
*/
package pkt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DosyaOkuTest {

	
    @Test
    @DisplayName("Dosya Oku açılma testi")
    public void dosyaOkuAc() throws IOException {
        File dosya = new File("dosya.java");
        try (FileInputStream fileInputStream = new FileInputStream(dosya)) {
            assertTrue(true);
        } catch (FileNotFoundException e) {
            fail("Dosya açılamadı");
        }
    }
    
}
