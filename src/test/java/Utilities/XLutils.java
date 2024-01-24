package Utilities;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.awt.desktop.ScreenSleepEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XLutils {
    public static FileInputStream filein;
    public static FileOutputStream fileout;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;

    public static int rowCount(String Xfile, String Xsheet) throws IOException {
        filein=new FileInputStream(Xfile);
        wb=new XSSFWorkbook(filein);
        ws=wb.getSheet(Xsheet);
        int rowcount=ws.getLastRowNum();
        wb.close();
        filein.close();
        return rowcount;

    }
    public static int cellCount(String xlfile, String xlsheet, int rowNum) throws IOException
    {
        filein=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(filein);
        ws=wb.getSheet(xlsheet);
        row=ws.getRow(rowNum);
        int cellCount=row.getLastCellNum();
        wb.close();
        filein.close();

        return cellCount;
    }
    public static String getCelData(String xlfile, String xlsheet, int rowNum, int cellNum)throws IOException{
        filein=new FileInputStream(xlfile);
        wb=new XSSFWorkbook(filein);
        ws=wb.getSheet(xlsheet);
        row=ws.getRow(rowNum);
        cell=row.getCell(cellNum);

        String Data;
        try {
            DataFormatter dataFormatter=new DataFormatter();
            String cellData=dataFormatter.formatCellValue(cell);
            return cellData;
        } catch (Exception e) {
            Data="";
        }

        wb.close();
        filein.close();
        return Data;
    }
}
