package Module1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Test34 
{
	public static void main(String[] args) throws Exception
	{
		// Taks expected color
		Scanner sc=new Scanner(System.in);
		System.out.println("enter experted color in RGB");
		int r=sc.nextInt();
		int g=sc.nextInt();
		int b=sc.nextInt();
		Color ec=new Color(r,g,b);
		int count=0;
		float percentage;
		File f=new File("pause.png");
		BufferedImage fullimg=ImageIO.read(f);
		//chack image color pixel by pixel
		int w=fullimg.getWidth();
		int h=fullimg.getHeight();
		for(int i=0;i<w;i++)
		{
			for(int j=0;j<w;j++)
			{
				Color ac=new Color(fullimg.getRGB(i, j));
				if(ac.getRed()==ec.getRed() && ac.getGreen()==ec.getGreen() && ac.getBlue()==ec.getBlue())
				{
					count=count+1;
				}
			}
		}
		System.out.println("Total pixels is :"+(w*h));
		System.out.println("Expected color pixels count is:"+count);
		percentage=(count*100)/(w*h);
		System.out.println("Expected color percentage is:"+percentage);
	}

}
