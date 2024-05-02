package lesson6.HomeWork6;



import java.util.*;

public class MainNotebook {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook(8, 256, "Windows", "Black");
        Notebook notebook2 = new Notebook(16, 256, "Windows", "Black");
        Notebook notebook3 = new Notebook(32, 256, "Windows", "White");
        Notebook notebook4 = new Notebook(8, 512, "Windows", "Black");
        Notebook notebook5 = new Notebook(16, 512, "Windows", "White");
        Notebook notebook6 = new Notebook(32, 512, "Windows", "Black");
        Notebook notebook7 = new Notebook(8, 1024, "Windows", "White");
        Notebook notebook8 = new Notebook(16, 1024, "Windows", "Black");
        Notebook notebook9 = new Notebook(32, 1024, "Windows", "Black");
        Notebook notebook10 = new Notebook(32, 1024, "Windows", "White");
        Notebook notebook11 = new Notebook(8, 256, "macOS", "Black");
        Notebook notebook12 = new Notebook(16, 256, "macOS", "White");
        Notebook notebook13 = new Notebook(32, 256, "macOS", "White");
        Notebook notebook14 = new Notebook(8, 512, "macOS", "White");
        Notebook notebook15 = new Notebook(16, 512, "macOS", "Black");
        Notebook notebook16 = new Notebook(32, 512, "macOS", "White");
        Notebook notebook17 = new Notebook(8, 1024, "macOS", "White");
        Notebook notebook18 = new Notebook(16, 1024, "macOS", "White");
        Notebook notebook19 = new Notebook(32, 1024, "macOS", "Black");
        Notebook notebook20 = new Notebook(32, 1024, "macOS", "White");


        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5,
                notebook6, notebook7, notebook8, notebook9, notebook10, notebook11, notebook12, notebook13,
                notebook14, notebook15, notebook16, notebook17, notebook18, notebook19, notebook20));
        filterParamsNotebook(notebooks);
    }

    public static void filterParamsNotebook(Set<Notebook> notebooks) {
        Map<String, String> filter = new HashMap<>();
        filter.put("1", "ОЗУ");
        filter.put("2", "Объем ЖД");
        filter.put("3", "Операционная система");
        filter.put("4", "Цвет");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите цифру для выбора интересующего параметра ноутбука: ");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");
        String input = scanner.nextLine();


        if (filter.containsKey(input)) {
            if (input.equals("1")) {
                System.out.println("Выберите минимальный объем ОЗУ (8, 16, 32) ГБ: ");
            }
            if (input.equals("2")) {
                System.out.println("Выберите минимальный объем жесткого диска (256, 512, 1024) ГБ: ");
            }
            if (input.equals("3")) {
                System.out.println("Выберите операционную систему (Windows, macOS): ");
            }
            if (input.equals("4")) {
                System.out.println("Выберите цвет (Black, White): ");
            }
            String minParam = scanner.nextLine();

            Set<Notebook> filteredNotebooks = new HashSet<>();
            if (input.equals("1")) {
                int minRam = Integer.parseInt(minParam);
                for (Notebook notebook : notebooks) {
                    if (notebook.getRam() >= minRam) {
                        filteredNotebooks.add(notebook);
                    }
                }
            }
            if (input.equals("2")) {
                int minHdd = Integer.parseInt(minParam);
                for (Notebook notebook : notebooks) {
                    if (notebook.getHdd() >= minHdd) {
                        filteredNotebooks.add(notebook);
                    }
                }
            }
            if (input.equals("3")) {
                for (Notebook notebook : notebooks) {
                    if (notebook.getOs().equals(minParam)) {
                        filteredNotebooks.add(notebook);
                    }
                }
            }
            if (input.equals("4")) {
                for (Notebook notebook : notebooks) {
                    if (notebook.getColor().equals(minParam)) {
                        filteredNotebooks.add(notebook);
                    }
                }
            }

            if (filteredNotebooks.isEmpty()) {
                System.out.println("Такого ноутбука, к сожалению, у нас сейчас нет");
            } else {
                for (Notebook notebook : filteredNotebooks) {
                    System.out.println(notebook);
                }
            }

        } else {
            System.out.println("Выбран неверный критерий!");
        }
    }
}
