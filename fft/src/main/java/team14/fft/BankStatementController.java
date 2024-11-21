package team14.fft;

import java.io.File;

import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.util.Builder;

//Contributing Authors: W Elliott, D MacIssac
public class BankStatementController {
	private Builder<Region> builder;
	private TransactionsModel model;
	
	//Contributing Authors: O Darrah, W Elliott, D MacIssac
	public BankStatementController(TransactionsModel model) {
		this.model = model;
		this.builder = new BankStatementViewBuilder(model.bankStatementProperty(), this::browseFileExplorer, this::nextPage);
	}
	
	//Contributing Authors: W Elliott, D MacIssac
	public Region getView() {
		return builder.build();
	}
	
	//Contributing Authors: W Elliott, D MacIssac
	private void browseFileExplorer() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select Bank Statement");
		
		File file = fileChooser.showOpenDialog(null);
		if(file != null) {
			model.setBankStatement(file.getName());
		}
	}
	
	//Contributing Authors: O Darrah
	private void nextPage() {
		Main.getMainLayout().setCenter(new TransactionListController().getView());
	}
}