package Module1;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.util.LoadLibs;

public class OCRTest 
{

	public static void main(String[] args) throws Exception 
	{
			try
			{
				//Load "tessdata" folder, which is having characters
				File fo=LoadLibs.extractTessResources("tessdata");
				//create obj to apply OCR on Image
				Tesseract obj=new Tesseract();
				obj.setDatapath(fo.getAbsolutePath());
				//obj.setLanguage("eng");//eng means alpha numarics
				//take screenshot file, which have  text in context
				File f=new File("skipadd.PNG");
				String result=obj.doOCR(f);
				Thread.sleep(20000);
				System.out.println(result);
			}catch(Exception ex)
			{
				System.out.println(ex.getMessage());
				
			}
	}

}
