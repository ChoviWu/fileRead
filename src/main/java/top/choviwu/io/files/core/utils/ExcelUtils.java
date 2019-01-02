package top.choviwu.io.files.core.utils;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import top.choviwu.io.files.core.convert.Convert;
import top.choviwu.io.files.core.convert.DefaultConvert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ChoviWu
 * @date 2018/12/29
 * Description : 读取Excel
 */
public class ExcelUtils {

    public static ExcelUtils EXCEL = new ExcelUtils();

    /**
     * 使用单例
     * @return
     */
    public static ExcelUtils getInstance(){
        return EXCEL;
    }


    public  <T> List<T> readExcel(InputStream is, File file,Class<T> tClass,Convert[] converts) {
        List<T> list = new ArrayList<>();
        try {
            if (file.getPath().endsWith(".xlsx")) {
                list = readXlsx(is, tClass,converts);
            } else if (file.getPath().endsWith(".xls")) {
                list = readXls(is,tClass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public  <T> List<T> readExcel(InputStream is, String pattern,Class<T> tClass,Convert[] converts) {
        List<T> list = new ArrayList<>();
        try {
            if (".xlsx".equals(pattern)) {
                list = readXlsx(is, tClass,converts);
            } else if (".xls".equals(pattern)) {
                list = readXls(is,tClass);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 读取excel表格内容(excel2007以上)
     * @param is    IO
     * @param tClass Class
     * @param converts Convert
     * @throws IOException
     */
    public  <T> List<T> readXlsx(InputStream is,Class<T> tClass,Convert[] converts) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        List<T> list = new ArrayList<>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    T t = null;
                    int colums = xssfRow.getPhysicalNumberOfCells();
                    for (int no = 0; no < colums; no++) {
                        XSSFCell cell = xssfRow.getCell(no);
                        String cellValue = getValue(cell);
                        t = ReflectUtils.getData(tClass,cellValue,no,t,converts);
                    }
                    list.add(t);
                }
            }
        }
        return list;
    }

    /**
     * 读取excel表格内容(excel2003以下)
     * @param is
     * @param tClass
     * @throws IOException
     */
    public  <T> List<T> readXls(InputStream is,Class<T> tClass) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        List<T> list = new ArrayList<>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // Read the Row
            for (int rowNum = 0; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                T t = null;
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    //获取总列数
                    int address  = hssfRow.getPhysicalNumberOfCells();
                    for (int no = 0; no < address; no++) {
                        HSSFCell cell = hssfRow.getCell(no);
                        t = ReflectUtils.getData(tClass,getValue(cell),no,t,new Convert[]{new DefaultConvert(),new DefaultConvert()});
                    }
                    list.add(t);
                }
            }
        }
        return list;
    }

    /**
     * 获取单元格的值
     * @param hssfCell
     * @return
     */
    static String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            DecimalFormat df = new DecimalFormat("0");
            return df.format(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

    /**
     * 获取单元格的值
     * @param xssfRow
     * @return
     */
    static String getValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
            DecimalFormat df = new DecimalFormat("0");
            return df.format(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

}
