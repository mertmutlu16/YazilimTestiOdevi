/**
*
* @author	MERT MUTLU mert.mutlu@ogr.sakarya.edu.tr
* @since 23.04.2023
* <p>
* 	Test edileck operatorlerin çağırıldığı yer.
* </p>
*/
package pkt;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;




public class Kutuphane {

	
	DosyaOku dosyaOku = new DosyaOku();
	String okunmusDosya;
	public Kutuphane(File dosya) throws IOException {
		okunmusDosya=dosyaOku.stringOku(dosya);
	}
	
    public int iliskiselOperatorSayisi() {
    	IliskiselOperatorSayaci iliskiselOperatorSayaci = new  IliskiselOperatorSayaci();
    	return iliskiselOperatorSayaci.sayac(okunmusDosya);
    }
    public int sayisalOperatorSayisi() {
    	SayisalOperatorSayaci sayisalOperatorSayaci=new SayisalOperatorSayaci();
    	return sayisalOperatorSayaci.sayac(okunmusDosya);
    }
    public int ikiliOperatorSayisi(){
    	IkiliOperatorSayaci ikiliOperatorSayaci= new IkiliOperatorSayaci();
    	return ikiliOperatorSayaci.sayac(okunmusDosya);
    }
    public int tekliOperatorSayisi() {
    	TekliOperatorSayaci tekliOperatorSayac = new TekliOperatorSayaci();
    	return tekliOperatorSayac.sayac(okunmusDosya);
    }

    public int fonksiyonSayisi() {
    	FonksiyonSayaci fonksiyonSayaci= new FonksiyonSayaci();
    	return fonksiyonSayaci.sayac(okunmusDosya);
    }
    public int mantiksalOperatorSayisi() {    
    	MantiksalOperatorSayaci mantiksalOperatorSayaci = new MantiksalOperatorSayaci();
    	return mantiksalOperatorSayaci.sayac(okunmusDosya);
    }

    
    


}
