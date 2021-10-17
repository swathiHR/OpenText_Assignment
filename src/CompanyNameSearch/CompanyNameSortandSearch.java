package CompanyNameSearch;

import java.util.ArrayList;
import java.util.Scanner;
import CompanyNameSearch.listOfMethodUsed;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CompanyNameSortandSearch {

	public static void main(String[] args) {
		Scanner input =  new Scanner(System.in);
		ArrayList<String> listOfSearchResults;
		System.out.println("If you want to consider company name from a Excel file, then enter as \'E\' \n"
				+ "If you want to consider company name from a Text file, then enter as \'T\' \n"
				+ "If you want to consider company name from a Console, then just press \'ENTER\' button");
		String userInput = input.nextLine();
		String filePath;
		if(userInput.equalsIgnoreCase("E")) {
			filePath = ".\\DataFiles\\companyName.xlsx";
			listOfSearchResults = new ArrayList<String>(listOfMethodUsed.inputFromExcelFile(filePath));	
		} else if(userInput.equalsIgnoreCase("T")) {
			filePath = ".\\DataFiles\\companyName.txt";
			listOfSearchResults = new ArrayList<String>(listOfMethodUsed.inputFromTextFile(filePath));	
		} else {
			listOfSearchResults = new ArrayList<String>(listOfMethodUsed.inputOfCompanyName());
		}
		
		String Search = listOfMethodUsed.inputSearchCriteria();
		System.out.println(listOfMethodUsed.sortedMatchingStringList(listOfSearchResults, Search));
		
		}
	
}


