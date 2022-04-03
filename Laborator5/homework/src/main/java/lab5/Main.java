package lab5;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog("", "");
        String type;
        String name;
        String path;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter a name for the catalog:");
        catalog.setName(myObj.nextLine());
        while (true) {
            System.out.print("Enter command >>> ");
            String command = myObj.nextLine();
            String[] arguments = command.split(" ");
            try {
                if (arguments.length > 1)
                    throw new IncorrectNameException("Not a valid command");
                switch (arguments[0].toLowerCase()) {
                    case "add" -> {
                        System.out.println("Enter a type: (book,article,other)");
                        type = myObj.nextLine();
                        System.out.println("Enter a name:");
                        name = myObj.nextLine();
                        System.out.println("Enter a path:");
                        path = myObj.nextLine();
                        try {
                            File file = new File(path);
                            if (!file.exists())
                                throw new IncorrectPathException("Not a valid path");
                        } catch (IncorrectPathException e) {
                            System.out.println(e.getMessage());
                            break;
                        }
                        switch (type.toLowerCase()) {
                            case "book" -> {
                                Item book = new Book(name, path);
                                AddCommand.add(catalog, book);
                            }
                            case "article" -> {
                                Item article = new Article(name, path);
                                AddCommand.add(catalog, article);
                            }
                            case "other" -> {
                                Item other = new Other(name, path);
                                AddCommand.add(catalog, other);
                            }
                            default -> throw new IncorrectNameException("Not a valid type");
                        }
                        System.out.println("Successfully added!");
                    }
                    case "save" -> {
                        System.out.println("Enter a path:");
                        path = myObj.nextLine();
                        try {
                            File file = new File(path);
                            if (!file.exists())
                                throw new IncorrectPathException("Not a valid path");
                            SaveCommand.save(catalog, path);
                        } catch (IncorrectPathException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case "list" -> {
                        System.out.println("Listing...");
                        ListCommand.list(catalog);
                    }
                    case "load" -> {
                        System.out.println("Enter a path:");
                        path = myObj.nextLine();
                        try {
                            File file = new File(path);
                            if (!file.exists())
                                throw new IncorrectPathException("Not a valid path");
                            catalog = LoadCommand.load(path);
                        } catch (IncorrectPathException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    case "view" -> {
                        System.out.println("Enter an item:");
                        String key = String.valueOf(myObj.nextInt());
                        ViewCommand.view(catalog, key);
                        System.out.println("Opening");
                    }
                    case "report" -> {
                        ReportCommand.report(catalog);
                    }
                    case "quit" -> System.exit(0);
                    default -> throw new IncorrectNameException("Not a valid command");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

