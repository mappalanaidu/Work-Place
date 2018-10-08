package KeyworDrivenWithTestNG;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.Test;


import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class KeywordDrivenWithTestNGMainClass 
{
  @Test
  public void mainMethod() throws Exception
  {
		//connect to excel file
		File f=new File("way2smsresults.xls");
		//open excel file for reading
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh1=rwb.getSheet(0);// 0 for sheet1(tests)
		int nour1=rsh1.getRows();
		int nouc1=rsh1.getColumns();
		Sheet rsh2=rwb.getSheet(1);// 1 for sheet2(steps)
		int nour2=rsh2.getRows();
		int nouc2=rsh2.getColumns();
		//open same excel file for writing 
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh1=wwb.getSheet(0);//0 for sheet1
		WritableSheet wsh2=wwb.getSheet(1);//1 for sheet1
		
		WritableCellFormat cf=new WritableCellFormat();
		cf.setAlignment(Alignment.JUSTIFY);
		cf.setWrap(true);
		cf.setBackground(Colour.BLUE);
		//set name to result column in Sheet1 and Sheet2
		Date dt=new Date();
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String cname=df.format(dt);
		//set name to result column in Sheet1 
		Label l1=new Label(nouc1,0,cname,cf);
		wsh1.addCell(l1);
		//set name to result column in Sheet2
		Label l2=new Label(nouc2,0,cname,cf);
		wsh2.addCell(l2);
		
		//create object to Mymethods class
		Mymethods mm=new Mymethods();
		
		//collect methods info using Method Class(in Java) object
		Method m[]=mm.getClass().getMethods();	
		
		//Keyword driven 
		try
		{
			//Calling methods one after other
			
			//1st row(index is 0) have names fo cols in sheet1
			for(int i=1;i<nour1;i++)
			{
				int flag=0;
				//get tid and mode from  sheet1
				String tid=rsh1.getCell(0,i).getContents();
				String mode=rsh1.getCell(2,i).getContents();
				if(mode.equalsIgnoreCase("Yes"))
				{
					//1st row (index 0) have names fo cols in sheet2
					for(int j=1;j<nour2;j++)
					{
						String sid=rsh2.getCell(0,j).getContents();
						if(tid.equalsIgnoreCase(sid))
						{
							//take step details from sheet2
							String mn=rsh2.getCell(2,j).getContents();
							String e=rsh2.getCell(3,j).getContents();
							String d=rsh2.getCell(4,j).getContents();
							String c=rsh2.getCell(5,j).getContents();
						System.out.println(mn+"  "+e+"  "+d+"  "+c);
						for(int k=0;k<m.length;k++)
						{
							if(m[k].getName().equals(mn))
							{
								String r=(String)m[k].invoke(mm,e,d,c);
								Label lb=new Label(nouc2,j,r,cf);
								wsh2.addCell(lb);
								if(r.equals("Unknown Browser"))
								{
									wwb.write();
									wwb.close();
									rwb.close();
									System.exit(0);//0 for stop execution
									
								}
								if(r.contains("Failed")||r.contains("Interrupted"))
								{
									flag=1;
								}
							}
						}//for k closing
						}
					}//for j closing
					if(flag==0)
					{
						Label l=new Label(nouc1,i,"Passed",cf);
						wsh1.addCell(l);
					}else
					{
						Label l=new Label(nouc1,i,"Failed",cf);
						wsh1.addCell(l);
			
					}
				}
				
				
			}//for i closing
			
		}//try block closing
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		//Save and close excel
		wwb.write();
		wwb.close();
		rwb.close();		
		
	}

}
