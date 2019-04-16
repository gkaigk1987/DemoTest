package com.gk.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static List<Map<String, Object>> readExcel(String filePath,int fromCol,int toCol) {
		try {
			InputStream is = new FileInputStream(new File(filePath));
			HSSFWorkbook wb = new HSSFWorkbook(is);
			HSSFSheet sheet = wb.getSheetAt(0);
			int totalRows = sheet.getLastRowNum();
			List<Map<String, Object>> dataList = new ArrayList<>();
			for(int i = 1; i <= totalRows; i++) {
				HSSFRow row = sheet.getRow(i);
				Map<String, Object> dataMap = new HashMap<>();
				for(int j = fromCol; j <= toCol; j++) {
					HSSFCell cell = row.getCell(j);
					if(null != cell) {
						//格式设置成String
						cell.setCellType(CellType.STRING);
					}
					dataMap.put("col"+j, cell.getStringCellValue());
				}
				dataList.add(dataMap);
			}
			wb.close();
			is.close();
			return dataList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<Map<String, Object>> readXmlExcel(String excelPath) {
		List<Map<String, Object>> dataList = new ArrayList<>();
		InputStream is = null;
		Workbook wb = null;
		try {
			is = new FileInputStream(new File(excelPath));
			wb = new XSSFWorkbook(is);
			Sheet sheet = wb.getSheetAt(0);
			int totalRows = sheet.getPhysicalNumberOfRows();//Excel行数
			int totalCells = 0;
			if(totalRows > 0 && sheet.getRow(0) != null) {
				//以第一行列数未基准
				totalCells = sheet.getRow(0).getPhysicalNumberOfCells();
			}else {
				return null;
			}
			//从第一行开始读取
			for(int i = 1; i < totalRows; i++) {
				Row row = sheet.getRow(i);
				if(row == null) {
					continue;
				}
				Map<String, Object> dataMap = new HashMap<>();
				for(int j = 0; j < totalCells; j++) {
					Cell cell = row.getCell(j);
					if(null != cell) {
						//格式设置成String
						cell.setCellType(CellType.STRING);
						dataMap.put("col"+j, cell.getStringCellValue());
					}else {
						dataMap.put("col"+j, "");
					}
				}
				dataList.add(dataMap);
			}
			return dataList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != wb) {
				try {
					wb.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * 生成地址及地址对应坐标的excel文档
	 * @param head
	 * @param dataList
	 * @throws IOException 
	 */
	public static void genLocationExcel(List<String> headList,List<Map<String, Object>> dataList,String filePath) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("sheet1");
		
		XSSFRow headRow = sheet.createRow(0);
		
		int i = 0;
		for(String head : headList) {
			XSSFCell cell = headRow.createCell(i,CellType.STRING);
			cell.setCellValue(head);
			i++;
		}
		
		for(int j = 0; j < dataList.size(); j++) {
			Map<String, Object> map = dataList.get(j);
			String addr = (String) map.get("address");
			String location = (String) map.get("location");
			
			XSSFRow dataRow = sheet.createRow(j + 1);
			
			XSSFCell cell_0 = dataRow.createCell(0,CellType.STRING);
			cell_0.setCellValue(addr);
			
			XSSFCell cell_1 = dataRow.createCell(1,CellType.STRING);
			cell_1.setCellValue(location);
		}
		FileOutputStream fos = new FileOutputStream(filePath);
		wb.write(fos);
		wb.close();
		fos.close();
	}
	
	public static void main(String[] args) {
		List<Map<String,Object>> list = readExcel("E:/T3/交接事宜/data/t_vehicle_position.xls",4,6);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int i = 0;
		Set<String> set = new HashSet<>();
		for (Map<String, Object> map : list) {
			String carNo = (String) map.get("col4");
			set.add(carNo);
			if(carNo.equals("苏AD00107")) {
				String object = (String)map.get("col6");
				Long time = Long.parseLong(object);
				String dateTime = simpleDateFormat.format(new Date(time * 1000));
				System.out.println(i + ":" + object + ":" + dateTime);
				i++;
			}
		}
		System.out.println(set.size());
	}

}