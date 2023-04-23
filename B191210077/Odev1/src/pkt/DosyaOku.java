/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	Test edilecek dosyaların açılıp okunmasını sağlayan sınıf.
* </p>
*/

package pkt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DosyaOku {

	// Gönderilen dosya okunuyor.
	public  String stringOku(File dosya) throws FileNotFoundException {
       StringBuilder stringBuilder = new StringBuilder();

       try (Scanner scanner = new Scanner(dosya)) {
           while (scanner.hasNextLine()) {
               String satir = scanner.nextLine();
               stringBuilder.append(satir).append("\n");
           }
       }
       
   		// Dosyada yorum satırları varsa siliniyor ve yorum satırı içindeki operator sayısıda bulunyor.
       try {
   		String regex = "//|/\\*|\\*/";
   		return  stringBuilder.toString().replaceAll(regex, "");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
       
   }
}
