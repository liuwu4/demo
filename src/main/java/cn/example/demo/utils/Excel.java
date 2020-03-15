package cn.example.demo.utils;

import cn.example.demo.dao.Type;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class Excel {
    private Workbook workbook;
    private static final Logger log = LoggerFactory.getLogger(Excel.class);

    /**
     * 读取表格内容
     * @param file 路径
     * @return list
     */

    public List readExcel(String file, int index) {
        List  list = new ArrayList();
        try {
            FileInputStream excel = new FileInputStream(file);
            boolean flag = isFormat(file);
            if (flag) {
                workbook = new HSSFWorkbook(excel);
            } else {
                workbook = new XSSFWorkbook(excel);
            }
           list = readSheet(workbook);
        } catch (FileNotFoundException e) {
            log.info("io读取excel文件异常");
            e.printStackTrace();
        } catch (IOException e) {
            log.info("读取文件workbook异常");
            e.printStackTrace();
        }
        return list;
    }


    public List readExcel(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        FileInputStream fileInputStream = null;
        List list = new ArrayList();
        try {
            fileInputStream = (FileInputStream) file.getInputStream();
            boolean flag = isFormat(fileName);
            if (flag) {
                workbook = new HSSFWorkbook(fileInputStream);
            } else {
                workbook = new XSSFWorkbook(fileInputStream);
            }
            list = readSheet(workbook);
        } catch (IOException e) {
            log.info("读取输入流异常");
            e.printStackTrace();
        }
        return list;
    }
    /**
     * 读取sheet
     *
     * @param workbook 表格
     */
    private List<List> readSheet(Workbook workbook) {
        int number = workbook.getNumberOfSheets();
        List<List> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Sheet sheet = workbook.getSheetAt(i);
            list.add(readRowCell(sheet));
        }
        return list;
    }

    /**
     * 读取行列数据
     *
     * @param sheet 工作簿
     */
    private List<Type> readRowCell(Sheet sheet) {
        List<Type> typeList = new ArrayList<Type>();
        // 行数
        int rowNum = sheet.getLastRowNum();
        for (int i = 1; i < rowNum; i++) {
            Type type = new Type();
            // 列数
            type.setTypeNum(sheet.getRow(i).getCell(0).getStringCellValue());
            type.setTypeName(sheet.getRow(i).getCell(1).getStringCellValue());
            typeList.add(type);
        }
        return typeList;
    }

    /**
     * 判断文件后缀
     *
     * @param fileName 文件名
     * @return true [xls], flase [xlsx]
     */
    private boolean isFormat(String fileName) {
        if (fileName.substring(fileName.lastIndexOf('.')).equals(".xls")) {
            return true;
        }
        return false;
    }

}
