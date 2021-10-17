package CompanyNameSearch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


  
 

public class listOfMethodUsed {
	static Scanner input =  new Scanner(System.in);
	static String sortOrder;
	public static ArrayList<String> inputOfCompanyName(){
		System.out.println("Enter list of companies");
		ArrayList<String> CompanyNameInputList = new ArrayList<String>();
		//String[] CompanyNameList = new String[100];
		
		while(input.hasNextLine()) {
		String companyNameInput = input.nextLine();
			if(companyNameInput.length()!= 0) {
				CompanyNameInputList.add(companyNameInput);
				
			}
			else {
				break;
			}
			
		}
		
		
		return CompanyNameInputList;
		
	}
	
	public static ArrayList<String> inputFromTextFile(String filePath) {
		ArrayList<String> CompanyNameFromTextFile = new ArrayList<String>();
		try {
			Scanner fileInput = new Scanner(new File(filePath));
			while(fileInput.hasNext()) {
				CompanyNameFromTextFile.add(fileInput.nextLine());
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CompanyNameFromTextFile;
		
	}
	public static ArrayList<String> inputFromExcelFile(String filePath){
		ArrayList<String> CompanyNameFromExcelFile = new ArrayList<String>();
		try {
			File file = new File(filePath);
			System.out.println(filePath);
			FileInputStream fis = new FileInputStream(file);
			XSSFWorkbook workBook =  new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheet("Sheet1");
			XSSFRow row = sheet.getRow(0);
			//XSSFWorkbook workBook = new XSSFWorkbook(); 
			//XSSFWorkbook workBook = new XSSFWorkbook(fis);
			//XSSFSheet sheet = workBook.getSheetAt(0);
			//XSSFRow row = sheet.getRow(0);
			int totalRowCount = sheet.getLastRowNum();
			System.out.println(totalRowCount);
			int totalColCount = row.getLastCellNum();
			System.out.println(totalColCount);
			for(int i=0;i<=totalRowCount;i++) {
				for(int j=0;j<totalColCount;j++) {
					String companyName = sheet.getRow(i).getCell(j).getStringCellValue();
					CompanyNameFromExcelFile.add(companyName);
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
		}
		return CompanyNameFromExcelFile;
		
	}
	
	public static String inputSearchCriteria() {
		System.out.println("ENter search criteria ");
		String search = input.nextLine();
		System.out.println("ENter search Order (Note: you have to enter asc for ascending order, desc for descending order) ");
		sortOrder = input.nextLine();
		return search;
	}
	
	public static List<String> sortedMatchingStringList(ArrayList<String> inputCompanyName, String searchCriteria) {
		//ArrayList<String> matchingCompanyName = (ArrayList<String>) inputCompanyName.stream().filter(it -> it.containsIgnoreCase(searchCriteria)).collect(Collectors.toList());
		ArrayList<String> matchingCompanyName = new ArrayList<String>();
		for(String companyName:inputCompanyName) {
			int pos = inputCompanyName.indexOf(companyName);
			String NameinLowesCase = companyName.toLowerCase();
			searchCriteria = searchCriteria.toLowerCase();
			if(NameinLowesCase.replaceAll(" ", "").contains(searchCriteria.replaceAll(" ", ""))) {
				matchingCompanyName.add(inputCompanyName.get(pos));
			}
		}
		if(sortOrder.equalsIgnoreCase("asc")) {
			Collections.sort(matchingCompanyName);
		}else {
			Collections.sort(matchingCompanyName,Collections.reverseOrder());
		}
		
		return matchingCompanyName;
		
	}

}
