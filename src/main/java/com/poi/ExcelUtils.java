package com.poi;

import javafx.scene.control.Cell;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    public static void main(String[] args) throws Exception {
        InputStream stream = new FileInputStream("C:\\Users\\User\\Desktop\\work\\case.xlsx");

        List<String> weihu = new ArrayList<>();
        List<String> wanglu = new ArrayList<>();
        List<String> biaolu = new ArrayList<>();
        List<String> xianshi = new ArrayList<>();
        List<Entity> list = new ArrayList<>();
        List<Info> infoListnfoList = new ArrayList<>();
        Map<String, Info> map = new HashMap<>();


        XSSFWorkbook wb = new XSSFWorkbook(stream);

        readInfo(wb, infoListnfoList, map);

        XSSFSheet sheet = wb.getSheetAt(1);
        if (sheet == null) {
            return;
        }
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Entity entity = new Entity();
            XSSFRow row = sheet.getRow(rowNum);
            if (row == null) {
                continue;
            }
            entity.setName(getCell(row, 1));
            entity.setSign(getCell(row, 2));
            entity.setType(getCell(row, 3));
            if (StringUtils.isBlank(entity.getType())) {
                continue;
            }
            String cell = getCell(row, 4);
            if ("是".equals(cell)) {
                entity.setMultiValue(1);
            } else {
                entity.setMultiValue(0);

            }
            String weihuA = getCell(row, 5);
            if (StringUtils.isNotBlank(weihuA)) {
                weihu.add(weihuA);
            }
            String wangluA = getCell(row, 6);
            if (StringUtils.isNotBlank(wangluA)) {
                wanglu.add(wangluA);
            }

            String biaoluA = getCell(row, 7);
            if (StringUtils.isNotBlank(biaoluA)) {
                biaolu.add(biaoluA);
            }

            String xianshiA = getCell(row, 8);
            if (StringUtils.isNotBlank(xianshiA)) {
                xianshi.add(xianshiA);
            }


            list.add(entity);
        }

        List<Entity> unList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (Entity entity : list) {
            String name = entity.getName();
            Info info = map.get(name);
            if (info != null) {
                entity.setFId(info.getId());
                entity.setFName(info.getName());
            }else{
                unList.add(entity);
            }
            if (weihu.contains(name)) {
                entity.setWeihu(1);
            }

            if (wanglu.contains(name)) {
                entity.setWanglu(1);
            }

            if (biaolu.contains(name)) {
                entity.setBiaolu(1);
            }

            if (xianshi.contains(name)) {
                entity.setShow(1);
            }

            if (info != null) {
                sb.append("(").append(entity.getFId()).append(",'").append(entity.getName()).append("',").append(entity.getSign()).append(",'").append(entity.getType()).append("',").append(entity.getMultiValue()).append(",").append(entity.getWeihu()).append(",").append(entity.getWanglu()).append(",").append(entity.getBiaolu()).append(",").append(entity.getShow()).append("),");
            }
        }
        System.out.println(sb.toString());
        for (Entity entity : unList) {
            System.out.println(entity.getName());
        }



        stream.close();

    }

    private static void readInfo(XSSFWorkbook wb, List<Info> infoList,Map<String, Info> map ) {
        XSSFSheet sheet = wb.getSheetAt(2);
        if (sheet == null) {
            return;
        }
        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
            Info info = new Info();
            XSSFRow row = sheet.getRow(rowNum);
            if (row == null) {
                continue;
            }
            info.setId(getCell(row, 0));
            info.setName(getCell(row, 1));
            info.setDesc(getCell(row, 2));
            map.put(info.getDesc(), info);
            infoList.add(info);
        }
    }

    public static String getCell(XSSFRow row, int num) {
        XSSFCell cell = row.getCell(num);
        if (cell == null) {
            return null;
        }
        return readCellSecondMethod(cell);
    }

    public static String readCellSecondMethod(XSSFCell cell) {
        if (cell == null) {
            return null;
        }
        cell.setCellType(CellType.STRING);
        try {
            return cell.getStringCellValue();
        } catch (Exception e) {
            return String.valueOf(cell.getNumericCellValue());
        }

    }

}

@Data
class Entity {

    String fId;

    String fName;

    String name;

    String sign;

    String type;

    int multiValue;

    int weihu;

    int wanglu;

    int biaolu;

    int show;

}

@Data
class Info {
    String id;
    String name;
    String desc;
}
