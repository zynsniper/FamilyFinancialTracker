package team14.fft;

import java.io.IOException;
import java.util.ArrayList;

public class CategoryList {
	//Contributing Authors: W Elliott

	private String filepath = "";
	private ArrayList<Category> categoryList;
	private ReadingExcel reader = new ReadingExcel();
	
	public CategoryList() throws IOException {
		String []storedCategories = reader.ReadingInput(filepath)[0]; 
		
		for (String nameIn : storedCategories) {
			categoryList.add(new Category(nameIn));
		}
	}
	
	public void store() throws IOException {
		WriterExcel excel = new WriterExcel("target/Category.xlsx");
		excel.WriteCategory(categoryList);
	}
	
	public void add(String nameIn) {
		categoryList.add(new Category(nameIn));
	}
	
	public void add(Category catIn) {
		categoryList.add(catIn);
	}
	
}
