package Module1;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Test35
{

	public static void main(String[] args)throws Exception
	{
		//get count of different colors in given image
				File f=new File("pause.png");
				BufferedImage fullimg=ImageIO.read(f);
				ArrayList<String> colors=new ArrayList<String>();
				//chack image color pixel by pixel
				int w=fullimg.getWidth();
				int h=fullimg.getHeight();
				for(int i=0;i<w;i++)
				{
					for(int j=0;j<h;j++)
					{
						int flag=0;
						Color ac=new Color(fullimg.getRGB(i,j));
						String temp=ac.getRed()+" "+ac.getGreen()+" "+ ac.getBlue();
						for(int k=0;k<colors.size();k++)
						{
						if(temp.equals(colors.get(k)))
						{
							flag=1;
						}
						}
						if(flag==0)
							{
							colors.add(temp);
							}
						}
					}
				
					//exising colors are
				System.out.println("Unique colors count is :"+colors.size());
				//check existing color percentage
				for(int k=0;k<colors.size();k++)
				{
				 int count=0;
				 for(int i=0;i<w;i++)
				 	{
					for(int j=0;j<h;j++)
					{
				Color ac=new Color(fullimg.getRGB(i,j));
				String temp=ac.getRed()+" "+ac.getGreen()+" "+ ac.getBlue();
				if(temp.equals(colors.get(k)))
						{
						count=count+1;
						}
					}
				 }
				
				System.out.println(colors.get(k)+" for "+count);
				float percentage=(count*100)/(w*h);
				System.out.println("Expected color percentage is:"+percentage);
				}
	}

}
