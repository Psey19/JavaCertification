package lesson6.HomeWork6;

//Примечание!!! 
//1) Для проверки два экземпляра класса Notebook: notebook20 и notebook21 с идентичными параметрами
//2) Для проверки можно исключить из множества notebooks, к примеру, все экземпляры с параметром os: macOS,
//   и тогда в результате фильтрации по данном критерию желаемого экземпляра не окажется
//   (по умолчанию под все запросы имеются экземпляры).
//3) Для удобства пользователя я заменил требуемое по заданию условие ввода значения параметра критерия самостоятельно,
//   а вместо этого предоставил возможность выбора из предложенных вариантов путём введения номера желаемого значения параметра


import java.util.*;

public class MainNotebook {
    public static void main(String[] args) {
        //Создадим экземпляры класса Notebook
        Notebook notebook1 = new Notebook("notebook1", 8, 256, "Windows", "Black", "sn101");
        Notebook notebook2 = new Notebook("notebook2", 16, 256, "Windows", "Black", "sn102");
        Notebook notebook3 = new Notebook("notebook3", 32, 256, "Windows", "White", "sn103");
        Notebook notebook4 = new Notebook("notebook4", 8, 512, "Windows", "Black", "sn104");
        Notebook notebook5 = new Notebook("notebook5", 16, 512, "Windows", "White", "sn105");
        Notebook notebook6 = new Notebook("notebook6", 32, 512, "Windows", "Black", "sn106");
        Notebook notebook7 = new Notebook("notebook7", 8, 1024, "Windows", "White", "sn107");
        Notebook notebook8 = new Notebook("notebook8", 16, 1024, "Windows", "Black", "sn108");
        Notebook notebook9 = new Notebook("notebook9", 32, 1024, "Windows", "Black", "sn109");
        Notebook notebook10 = new Notebook("notebook10", 32, 1024, "Windows", "White", "sn110");
        Notebook notebook11 = new Notebook("notebook11", 8, 256, "macOS", "Black", "sn111");
        Notebook notebook12 = new Notebook("notebook12", 16, 256, "macOS", "White", "sn112");
        Notebook notebook13 = new Notebook("notebook13", 32, 256, "macOS", "White", "sn113");
        Notebook notebook14 = new Notebook("notebook14", 8, 512, "macOS", "White", "sn114");
        Notebook notebook15 = new Notebook("notebook15", 16, 512, "macOS", "Black", "sn115");
        Notebook notebook16 = new Notebook("notebook16", 32, 512, "macOS", "White", "sn116");
        Notebook notebook17 = new Notebook("notebook17", 8, 1024, "macOS", "White", "sn117");
        Notebook notebook18 = new Notebook("notebook18", 16, 1024, "macOS", "White", "sn118");
        Notebook notebook19 = new Notebook("notebook19", 32, 1024, "macOS", "Black", "sn119");
        Notebook notebook20 = new Notebook("notebook20", 32, 1024, "macOS", "White", "sn120");
        Notebook notebook21 = new Notebook("notebook20", 32, 1024, "macOS", "White", "sn120");
        Notebook notebook22 = new Notebook("notebook20", 32, 1024, "macOS", "White", "sn122");

        //Создадим множество для хранения всего ассортимента ноутбуков из экземпляров класса Notebook
        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5,
                notebook6, notebook7, notebook8, notebook9, notebook10, notebook11, notebook12, notebook13,
                notebook14, notebook15, notebook16, notebook17, notebook18, notebook19, notebook20, notebook21, notebook22));
        filterParamsNotebook(notebooks);
    }

        //Создадим метод для фильтрации ноутбуков по критериям
    public static void filterParamsNotebook(Set<Notebook> notebooks) {
        //Создадим Map`ы с критериями для фильтрации
        Map<String, String> ramMap = new HashMap<>();
        ramMap.put("1", "8");
        ramMap.put("2", "16");
        ramMap.put("3", "32");

        Map<String, String> hddMap = new HashMap<>();
        hddMap.put("1", "256");
        hddMap.put("2", "512");
        hddMap.put("3", "1024");

        Map<String, String> osMap = new HashMap<>();
        osMap.put("1", "Windows");
        osMap.put("2", "macOS");

        Map<String, String> colorMap = new HashMap<>();
        colorMap.put("1", "White");
        colorMap.put("2", "Black");

        System.out.println("\nСейчас мы вам подберём ноутбук по интересующим вас параметрам!!!\n");

        Scanner scanner = new Scanner(System.in);
        //Создадим множество для хранения отфильтрованных по критериям ноутбуков
        Set<Notebook> filteredNotebooks = new HashSet<>();

        //Критерий для фильтрации по ОЗУ, который наполняет множество отфильтрованных ноутбуков
        //Вводим бесконечный цикл while для проверки ввода

        while (true) {
            System.out.println("Выберите минимальный желаемый объем ОЗУ: ");
            System.out.println("1 - 8ГБ");
            System.out.println("2 - 16ГБ");
            System.out.println("3 - 32ГБ");
            System.out.println("4 - Для меня этот параметр не принципиально важен");
            String ramMin = scanner.nextLine();
            String ramMeaning = ramMap.get(ramMin);
            if (ramMap.containsKey(ramMin)) {
                int minRam = Integer.parseInt(ramMeaning);
                for (Notebook notebook : notebooks) {
                    if (notebook.getRam() >= minRam) {
                        filteredNotebooks.add(notebook);
                    }
                }
                break;
            } else if (ramMin.equals("4")) {
                filteredNotebooks.addAll(notebooks);
                break;
            } else {
                System.out.println("\nОшибка ввода!!!Введите только номер подходящего вам варианта\n");
            }
        }

        //Критерий для фильтрации по ЖД, который исключает из множества отфильтрованных ноутбуков
        //неподходящие этому критерию ноутбуки
        //Вводим бесконечный цикл while для проверки ввода

        while (true) {
            System.out.println("Выберите минимальный желаемый объем жёсткого диска: ");
            System.out.println("1 - 256ГБ");
            System.out.println("2 - 512ГБ");
            System.out.println("3 - 1024ГБ");
            System.out.println("4 - Для меня этот параметр не принципиально важен");
            String hddMin = scanner.nextLine();
            String hddMeaning = hddMap.get(hddMin);
            if (hddMap.containsKey(hddMin)) {
                int minHdd = Integer.parseInt(hddMeaning);
                filteredNotebooks.removeIf(notebook -> notebook.getHdd() < minHdd);
                break;
            } else if (hddMin.equals("4")){
                break;
            } else {
                System.out.println("\nОшибка ввода!!!Введите только номер подходящего вам варианта\n");
            }
        }

        //Критерий для фильтрации по ОС, который исключает из множества отфильтрованных ноутбуков
        //неподходящие этому критерию ноутбуки
        //Вводим бесконечный цикл while для проверки ввода

        while (true) {
            System.out.println("Выберите операционную систему: ");
            System.out.println("1 - Windows");
            System.out.println("2 - macOS");
            System.out.println("3 - Для меня этот параметр не принципиально важен");
            String currentOs = scanner.nextLine();
            String osMeaning = osMap.get(currentOs);
            if (osMap.containsKey(currentOs)) {
                filteredNotebooks.removeIf(notebook -> !Objects.equals(notebook.getOs(), osMeaning));
                break;
            } else if (currentOs.equals("3")){
                break;
            } else {
                System.out.println("\nОшибка ввода!!!Введите только номер подходящего вам варианта\n");
            }
        }

        //Критерий для фильтрации по Цвету, который исключает из множества отфильтрованных ноутбуков
        //неподходящие этому критерию ноутбуки
        //Вводим бесконечный цикл while для проверки ввода

        while (true) {
            System.out.println("Выберите цвет: ");
            System.out.println("1 - Белый");
            System.out.println("2 - Черный");
            System.out.println("3 - Для меня цвет не важен");
            String currentColor = scanner.nextLine();
            String colorMeaning = colorMap.get(currentColor);
            if (colorMap.containsKey(currentColor)) {
                filteredNotebooks.removeIf(notebook -> !Objects.equals(notebook.getColor(), colorMeaning));
                break;
            } else if (currentColor.equals("3")){
                break;
            } else {
                System.out.println("\nОшибка ввода!!!Введите только номер подходящего вам варианта\n");
            }
        }
        scanner.close();

        //Вывод отфильтрованного множества ноутбуков
        if (filteredNotebooks.isEmpty()) {
            System.out.println("\nТакого ноутбука, к сожалению, у нас сейчас нет");
        } else {
            System.out.println("\nВот что мы вам можем предложить:\n");
            for (Notebook notebook : filteredNotebooks) {
                System.out.println(notebook);
            }
        }
    }
}
