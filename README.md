# OpenText_Assignment
This program sorts and seraches company name

Description about program:
This program accepts company name through 3 ways i.e mentioned below:
1.Through excel sheet
2.Through text file
3.Console

process needs to be followed to run in local:
->import the project to IDE
->Add jar file to build pah [For excel input, we have to add apache poi jars through build path.I have tried with poi api 4.1.2 version(I have added jar file in git or you can download from this link as well: https://archive.apache.org/dist/poi/release/bin/)]
->then start executing as java application

Flow of the program:

Company name through excel file :
->Add .xlsx file  to dataFiles folder of the project.(Check negative flow by adding an empty .xlsx file)
->then update the file path in the program(update of file path requred here ->CompanyNameSortandSearch class->line number 29 (code line is : filePath = ".\\DataFiles\\companyName.xlsx";)

execution process for excel part:
->While executing, Enter "E" to go with excel flow
->Then enter the search criteria.(if you want to pass empty search criteria press enter button one more time)
->Then enter sort order(for ascending order pass 'asc' and for descending you can pass "desc" or any parameter)
->Then result will be displayed as per search criteria

Company name through text file :
->Add .txt file  dataFiles folder of the project.(Check negative flow by adding an empty .txt file)
->then update the file path in the program(update of file path requred here ->CompanyNameSortandSearch class->line number 35 (code line is : filePath = ".\\DataFiles\\companyName.txt";)

execution process for text file part:
->While executing, Enter "T" to go with text file flow
->Then enter the search criteria.(if you want to pass empty search criteria press enter button one more time)
->Then enter sort order(for ascending order pass 'asc' and for descending you can pass "desc" or any parameter)
->Then result will be displayed as per search criteria

Company name through console input:

execution process for console input part:
->While executing, press Enter button to go with console input flow
->Then enter the search criteria.(if you want to pass empty search criteria press enter button one more time)
->Then enter sort order(for ascending order pass 'asc' and for descending you can pass "desc" or any parameter)
->Then result will be displayed as per search criteria

