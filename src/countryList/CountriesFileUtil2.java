package countryList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CountriesFileUtil2 extends AbstractFileUtil<Country>{

	public CountriesFileUtil2(String fileName) {
		super("Countries.txt");
		// TODO Auto-generated constructor stub
	}
	
	
	public static void createBlankFile(String pathName) {
		Path path = Paths.get(pathName);
		if (Files.notExists(path)) {
			try {
				Files.createFile(path);
				System.out.println("File created at " + path.toAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected Country convertLineToItem(String line) {
		//String[] parts = line.split("\t");
		Country count1 = new Country(line);
		//count1.setName(line);
		return count1;
	}

	@Override
	protected String convertItemToLine(Country item) {
		return String.format("%s", item.getName());
	}


}
