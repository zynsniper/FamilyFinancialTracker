package team14.fft;

import java.util.ArrayList;

import javafx.collections.ObservableList;

public class ExportModel {
    private ArrayList<TransactionModel> model;
    private ArrayList<Transaction> transactions;
    private ArrayList<Category> categories;
    private String filepath;

    public ExportModel(ObservableList<TransactionModel> observableList, ObservableList<Category> list) throws Exception {
        model = new ArrayList<TransactionModel>();
        model.addAll(observableList);
        categories = new ArrayList<Category>();
        categories.addAll(list);
        filepath = "target/out.xlsx";
        transactions = new ArrayList<Transaction>();
        writeTransactions();
        export();
    }

    // Contributing authors: R Legere
    public void writeTransactions() {
        for (int i = 0; i < model.size(); i++) {
            TransactionModel nextTransaction = model.get(i);
            Transaction t = new Transaction(nextTransaction.getDate(), 
                                             Vendor.addVendor(nextTransaction.getVendor()), 
                                             Buyer.addBuyer(nextTransaction.getBuyer()), 
                                             nextTransaction.getTotal());
            transactions.add(t);
        }
    }

    // Contributing authors: R Legere
    public void export() throws Exception {
        WriterExcel writer = new WriterExcel(filepath);
        writer.WriteTransactions(transactions);
        writer.WriteCatTotals(transactions, categories);
        writer.writeTotal(transactions);
    }
}

