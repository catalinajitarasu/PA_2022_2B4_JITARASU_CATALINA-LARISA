package lab5;

import freemarker.template.*;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class ReportCommand extends Command {
    public ReportCommand(String command, Catalog catalog) {
        super(command, catalog);
    }

    public static void report(Catalog catalog) throws IOException {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        cfg.setDirectoryForTemplateLoading(new File("E:/TEST"));
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);


        Map<String, Object> report = new HashMap<>();

        report.put("name", catalog.getName());
        report.put("items", catalog.getItems());

        Template temp = cfg.getTemplate("test.html");

        try (Writer fileWriter = new FileWriter("E:/" + catalog.getName() + " report.html")) {
            temp.process(report, fileWriter);

        } catch (IOException | TemplateException e) {
            System.out.println(e.getMessage());
        }
        Item other = new Other(catalog.getName() + " report", "E:/" + catalog.getName() + " report.html");
        File file = new File(other.getLocation());
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (Exception e1) {
            System.out.println(e1.getMessage());
        }
    }
}
