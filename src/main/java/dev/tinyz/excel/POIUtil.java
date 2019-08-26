package dev.tinyz.excel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TinyZ on 2014/9/23.
 */
public class POIUtil {

    public static void ExcelOperate(String filePath) throws Exception {
        Workbook workbook = WorkbookFactory.create(new FileInputStream(new File(filePath)));
        Sheet first = workbook.getSheetAt(0);
        for (int i = 0; i < 100000; i++) {
            Row row = first.createRow(i);
            for (int j = 0; j < 11; j++) {
                if (i == 0) {
                    row.createCell(j).setCellValue("column" + j);
                } else {
                    if (j == 0) {
                        row.createCell(j).setCellValue(i);
                    } else
                        row.createCell(j).setCellValue(Math.random());
                }
            }
        }
        FileOutputStream out = new FileOutputStream("workbook.xlsx");
        workbook.write(out);
        out.close();
    }


    /**
     * 测试写入百万条数据
     * <br/>Cast time : 87782
     *
     * @param fileName 文件名称
     * @throws IOException
     */

    public static void Excel2007AboveOperate(String fileName, List<BleData> list) throws IOException {
        File file = new File(fileName);
        if (!file.exists()){
            //book = SXSSFWorkbook.createWorkbook(file);  //创建xls文件
            file.createNewFile();

        }
        XSSFWorkbook workbook1 = new XSSFWorkbook(new FileInputStream(file));
        SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(workbook1, 100);
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd hh:mm:ss");
        FileOutputStream out = new FileOutputStream(fileName);
        Sheet first = sxssfWorkbook.getSheetAt(0);
        first.getLastRowNum();
        //r: 行c：列
        for (int i = 0; i < list.size(); i++) {
            BleData bd = list.get(i);
            Row row = first.createRow(i);
            if (i == 0) {
                row.createCell(0).setCellValue("序号");
                row.createCell(1).setCellValue("产品名称");
                row.createCell(2).setCellValue("尺寸名称");
                row.createCell(3).setCellValue("尺寸标准");
                row.createCell(4).setCellValue("尺寸公差");
                row.createCell(5).setCellValue("测量尺寸");
                row.createCell(6).setCellValue("是否合格");
                row.createCell(7).setCellValue("检测人");
                row.createCell(8).setCellValue("日期");
            } else {
                row.createCell(0).setCellValue(Integer.toString(i));
                row.createCell(1).setCellValue(bd.getTestName());
                row.createCell(2).setCellValue(bd.getCCName());
                row.createCell(3).setCellValue(Float.toString(bd.getCCStandard()));
                row.createCell(4).setCellValue(Float.toString(bd.getCCTolerance()));
                row.createCell(5).setCellValue(Float.toString(bd.getCCSize()));
                if (bd.isCCQualified()) {
                    row.createCell(6).setCellValue("合格");
                } else
                    row.createCell(6).setCellValue("不合格");
                row.createCell(7).setCellValue(bd.getTesterName());
                row.createCell(8).setCellValue(sdf.format(bd.getDate()));
            }
        }
        sxssfWorkbook.write(out);
        out.close();
    }
}
