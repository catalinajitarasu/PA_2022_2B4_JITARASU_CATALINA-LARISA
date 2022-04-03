package lab5;

import java.awt.*;
import java.io.File;

public class ViewCommand extends Command {
    public ViewCommand(String command, Catalog catalog, Item item) {
        super(command, catalog, item);
    }

    public static void view(Catalog catalog, String id) {
        Item item = catalog.findById(id);
        File file = new File(item.getLocation());
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }

}
