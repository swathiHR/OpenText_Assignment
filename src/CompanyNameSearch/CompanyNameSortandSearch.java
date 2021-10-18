package CompanyNameSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import CompanyNameSearch.listOfMethodUsed;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CompanyNameSortandSearch {

	public static void main(String[] args) {
		//This part requires user input to choose data source i.e company names, T for text file, E for excel and ENter or any button for console input
		Scanner input =  new Scanner(System.in);
		//Array List->listOfSearchResults, holds the data source, i.e company name.
		ArrayList<String> listOfSearchResults;
		List<String> sortedResult;
		System.out.println("If you want to consider company name from a Excel file, then enter as \'E\' \n"
				+ "If you want to consider company name from a Text file, then enter as \'T\' \n"
				+ "If you want to consider company name from a Console, then just press \'ENTER or anyother button\' button");
		String userInput = input.nextLine();
		String filePath;
		
		//Fetching company names from excel
		
		if(userInput.equalsIgnoreCase("E")) {
			filePath = ".\\DataFiles\\companyName.xlsx";
			listOfSearchResults = new ArrayList<String>(listOfMethodUsed.inputFromExcelFile(filePath));	
			
			//fetching company names from text file
			
		} else if(userInput.equalsIgnoreCase("T")) {
			filePath = ".\\DataFiles\\companyName.txt";
			listOfSearchResults = new ArrayList<String>(listOfMethodUsed.inputFromTextFile(filePath));
			
			//fetching company names from console input
			
		} else {
			listOfSearchResults = new ArrayList<String>(listOfMethodUsed.inputOfCompanyName());
		}
		
		//fetching search criteria
		String Search = listOfMethodUsed.inputSearchCriteria();
		
		//fetching sorted search result
		sortedResult = listOfMethodUsed.sortedMatchingStringList(listOfSearchResults, Search);
		if(sortedResult.isEmpty()) {
			System.out.println("matching company name is not available in the list !!!!"+sortedResult);
		}else {
			System.out.println("Here is SORTED COMPANY NAME list which satisfyies search criteria...!!!!!");
			for (String companyName:sortedResult ) {
				System.out.println(companyName);
				
			}
		}
		
		
		}
	
}


