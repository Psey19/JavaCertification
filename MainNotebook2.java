package lesson6.HomeWork6;

// Этот вариант решения я реализовал увлёкшись процессом, здесь я попытался сделать из метода фильтрации интернет-магазин,
//   работающий в реальном времени, т.е. после выбора ноутбука по критериям, появляется возможность купить выбранный ноутбук,
//   затем как-будто приходит следующий покупатель и выбирает уже из меньшего ассортимента и так до последнего ноутбука.
//   Также здесь я реализовал обновление вариантов выбора по критериям согласно имеющимся (к примеру, если закончатся все ноутбуки
//     с ОЗУ 32ГБ, то такого варианта для выбора больше не будет). Если же в критерии только 1 вариант, то вопрос пропускается.
//   Также модернизировал метод под возможность вносить изменения непосредственно в параметры экземпляров класса (без магических чисел и значений),
//   и они также будут автоматически появляться в вариантах выбора по критериям.
//   Знаю, что проделано много лишней работы и наверняка в каких-то моментах действовал, нерационально используя ресурсы системы,
//   но я просто набивал руку.
//   Из явных недочетов пока - это отсутствие проверки на ввод букв вместо цифр, если успею, то попытаюсь исправить и это.
//   (Ввёл дополнительную проверку на ввод только чисел, как и обещал, но как я только не пытался, не получается закрыть сканер грамотно, но и так работает)

import java.util.*;

public class MainNotebook2 {
    public static void main(String[] args) {

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

        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5,
                notebook6, notebook7, notebook8, notebook9, notebook10, notebook11, notebook12, notebook13,
                notebook14, notebook15, notebook16, notebook17,
                notebook18, notebook19, notebook20, notebook21, notebook22));

        filterParamsNotebook(notebooks);
    }

    public static void filterParamsNotebook(Set<Notebook> notebooks) {

        LinkedHashMap<Integer, Integer> ramMap = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> hddMap = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> osMap = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> colorMap = new LinkedHashMap<>();

        TreeSet<Integer> notebookRam = new TreeSet<>();
        TreeSet<Integer> notebookHdd = new TreeSet<>();
        TreeSet<String> notebookOs = new TreeSet<>();
        TreeSet<String> notebookColor = new TreeSet<>();

        for (Notebook notebook : notebooks) {
            notebookRam.add(notebook.getRam());
        }
        System.out.println("\nЗдравствуйте!!! Сейчас мы вам подберём ноутбук по интересующим вас параметрам!!!\n");



        Set<Notebook> filteredNotebooks = new HashSet<>();

        while (true) {
            if (notebookRam.size() > 1) {
                System.out.println("Выберите минимальный желаемый объем ОЗУ: ");
                int num = 1;
                for (Integer ram : notebookRam) {
                    ramMap.put(num, ram);
                    System.out.printf("%d - %d%s\n", num, ram, "ГБ");
                    num++;
                }
                System.out.printf("%d - %s\n", notebookRam.size() + 1, "Для меня этот параметр не принципиально важен");
                Scanner sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
                    int ramChoice = sc.nextInt();
                    if (ramMap.containsKey(ramChoice)) {
                        for (Notebook notebook : notebooks) {
                            if (notebook.getRam() >= ramMap.get(ramChoice)) {
                                filteredNotebooks.add(notebook);
                            }
                        }
                        break;
                    } else if (ramChoice == notebookRam.size() + 1) {
                        filteredNotebooks.addAll(notebooks);
                        break;
                    } else {
                        System.out.println("\nОшибка ввода!!!Введите число соответствующего варианта\n");
                    }
                } else {
                    System.out.println("\nОшибка ввода!!!Вы ввели не число\n");
                }
            } else if (notebookRam.size() == 1) {
                for (Notebook notebook : notebooks) {
                    filteredNotebooks.add(notebook);
                }
                break;
            } else {
                break;
            }

        }

        for (Notebook notebook : filteredNotebooks) {
            notebookHdd.add(notebook.getHdd());
        }
        while (true) {
            if (notebookHdd.size() > 1) {
                System.out.println("Выберите минимальный желаемый объем жёсткого диска: ");
                int num = 1;
                for (Integer hdd : notebookHdd) {
                    hddMap.put(num, hdd);
                    System.out.printf("%d - %d%s\n", num, hdd, "ГБ");
                    num++;
                }
                System.out.printf("%d - %s\n", notebookHdd.size() + 1, "Для меня этот параметр не принципиально важен");
                Scanner sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
                    int hddChoice = sc.nextInt();
                    if (hddMap.containsKey(hddChoice)) {
                        filteredNotebooks.removeIf(notebook -> notebook.getHdd() < hddMap.get(hddChoice));
                        break;
                    } else if (hddChoice == notebookHdd.size() + 1) {
                        break;
                    } else {
                        System.out.println("\nОшибка ввода!!!Введите только номер подходящего вам варианта\n");
                    }
                } else {
                    System.out.println("\nОшибка ввода!!!Вы ввели не число\n");
                }
            } else {
                break;
            }
        }

        for (Notebook notebook : filteredNotebooks) {
            notebookOs.add(notebook.getOs());
        }
        while (true) {
            if (notebookOs.size() > 1) {
                System.out.println("Выберите операционную систему: ");
                int num = 1;
                for (String os : notebookOs) {
                    osMap.put(num, os);
                    System.out.printf("%d - %s\n", num, os);
                    num++;
                }
                System.out.printf("%d - %s\n", notebookOs.size() + 1, "Для меня этот параметр не принципиально важен");
                Scanner sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
                    int currentOs = sc.nextInt();
                    String osMeaning = osMap.get(currentOs);
                    if (osMap.containsKey(currentOs)) {
                        filteredNotebooks.removeIf(notebook -> !Objects.equals(notebook.getOs(), osMeaning));
                        break;
                    } else if (currentOs == notebookOs.size() + 1) {
                        break;
                    } else {
                        System.out.println("\nОшибка ввода!!!Введите только номер подходящего вам варианта\n");
                    }
                } else {
                    System.out.println("\nОшибка ввода!!!Вы ввели не число\n");
                }
            } else {
                break;
            }
        }


        for (Notebook notebook : filteredNotebooks) {
            notebookColor.add(notebook.getColor());
        }
        while (true) {
            if (notebookColor.size() > 1) {
                System.out.println("Выберите цвет: ");
                int num = 1;
                for (String color : notebookColor) {
                    colorMap.put(num, color);
                    System.out.printf("%d - %s\n", num, color);
                    num++;
                }
                System.out.printf("%d - %s\n", notebookColor.size() + 1, "Для меня цвет не важен");
                Scanner sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
                    int currentColor = sc.nextInt();
                    String colorMeaning = colorMap.get(currentColor);
                    if (colorMap.containsKey(currentColor)) {
                        filteredNotebooks.removeIf(notebook -> !Objects.equals(notebook.getColor(), colorMeaning));
                        break;
                    } else if (currentColor == notebookColor.size() + 1) {
                        break;
                    } else {
                        System.out.println("\nОшибка ввода!!!Введите только номер подходящего вам варианта\n");
                    }
                } else {
                    System.out.println("\nОшибка ввода!!!Вы ввели не число\n");
                }
            } else {
                break;
            }
        }

        if (filteredNotebooks.isEmpty()) {
            System.out.println("\nНоутбуки, к сожалению закончились\n");
        } else {
            while (true) {
                System.out.println("\nВыберите модель, которую хотите купить:");
                Map<Integer, Notebook> filterMap = new HashMap<>();
                int num = 1;
                for (Notebook notebook : filteredNotebooks) {
                    filterMap.put(num, notebook);
                    System.out.printf("%d - %s\n", num, notebook);
                    num++;
                }
                System.out.printf("%d - %s\n", num, "Я передумал покупать");
                Scanner sc = new Scanner(System.in);
                if (sc.hasNextInt()) {
                    int currentNotebook = sc.nextInt();
                    Notebook notebookCurrent = filterMap.get(currentNotebook);
                    if (filterMap.containsKey(currentNotebook)) {
                        System.out.printf("\n%s\n%s\n", "Поздравляем вас с покупкой:", notebookCurrent);
                        notebooks.remove(notebookCurrent);
                        break;
                    } else if (currentNotebook == num) {
                        System.out.println("Возвращайтесь скорее");
                        break;
                    } else {
                        System.out.println("\nОшибка ввода!!!Введите только номер подходящего вам варианта");
                    }
                } else {
                    System.out.println("\nОшибка ввода!!!Вы ввели не число\n");
                }
            }
        }
        if (notebooks.isEmpty()) {
            System.out.println("\nМагазин закрыт!!!\n");
        } else {
            filterParamsNotebook(notebooks);
        }
    }
}
