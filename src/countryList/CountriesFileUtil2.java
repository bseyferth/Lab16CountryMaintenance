package countryList;


public class CountriesFileUtil2 extends AbstractFileUtil<Country>{

	public CountriesFileUtil2(String fileName) {
		super("Countries.txt");
		// TODO Auto-generated constructor stub
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
