package lab5;

import java.io.IOException;

public class Main {
    public static void main(String args[]) throws InvalidCatalogException, IOException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() {
        Catalog catalog = new Catalog();
        var example1 = new Item("The Art of Computer Programming","knuth67","d:/books/programming/tacp.ps");
        var example2 = new Item("The Java Language Specification","java17","https://docs.oracle.com/javase/specs/jls/se17/html/index.html");
        catalog.add(example1);
        catalog.add(example2);
        try{
            CatalogUtil.save(catalog, "E://Laborator5/catalog.json");
        }
        catch (IOException ioe){
            System.out.println(catalog.getItems());
        }
    }
    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalog = CatalogUtil.load("E://Laborator5/catalog.json");
    }

}
