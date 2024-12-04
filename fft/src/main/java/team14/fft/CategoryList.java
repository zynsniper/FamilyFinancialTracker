package team14.fft;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CategoryList {
	//Contributing Authors: W Elliott

	private String filepath = "target/categories.xlsx";
	private ArrayList<Category> categoryList;
	private ReadingExcel reader = new ReadingExcel();
	
	/*public CategoryList() throws IOException {
		categoryList = new ArrayList<Category>();
		try {
			String []storedCategories = reader.ReadingInput(filepath)[0]; 
		for (String nameIn : storedCategories) {
			categoryList.add(new Category(nameIn));
		}
		}catch(FileNotFoundException e) {}
	}*/
	
	//Contributing authors: R Legere
	public CategoryList() {
		categoryList = new ArrayList<Category>();
		categoryList.add(new Category("Grocery", 3));
		categoryList.add(new Category("Gas", 2));
		categoryList.add(new Category("Dining", 5));
		categoryList.add(new Category("Recurring", 4));
		categoryList.add(new Category("Other"));
	}
	
	public void store() throws IOException {
		WriterExcel excel = new WriterExcel(filepath);
		excel.WriteCategory(categoryList);
	}
	
	public void add(String nameIn) {
		categoryList.add(new Category(nameIn));
	}
	
	public void add(Category catIn) {
		categoryList.add(catIn);
	}
	
	public ArrayList<Category> getList(){
		return categoryList;
	}
	
}
