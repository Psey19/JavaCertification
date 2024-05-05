package lesson6.HomeWork6;


import java.util.*;

public class MainNotebook2 {
    public static void main(String[] args) {
    //Создаём экземпляры класса Notebook, не забывая присваивать уникальный серийный номер (параметр sn:)
        Notebook notebook1 = new Notebook("notebook1", 8, 256, "Windows", "Black", "sn101");
        Notebook notebook2 = new Notebook("notebook2", 16, 256, "Dos", "Black", "sn102");
        Notebook notebook3 = new Notebook("notebook3", 32, 256, "Windows", "White", "sn103");
        Notebook notebook4 = new Notebook("notebook4", 8, 512, "Windows", "Red", "sn104");
        Notebook notebook5 = new Notebook("notebook5", 16, 512, "Windows", "White", "sn105");
        Notebook notebook6 = new Notebook("notebook6", 32, 512, "Windows", "Black", "sn106");
        Notebook notebook7 = new Notebook("notebook7", 8, 1024, "Windows", "White", "sn107");
        Notebook notebook8 = new Notebook("notebook8", 16, 1024, "Windows", "Black", "sn108");
        Notebook notebook9 = new Notebook("notebook9", 32, 1024, "Windows", "Black", "sn109");
        Notebook notebook10 = new Notebook("notebook10", 32, 1024, "Windows", "Gray", "sn110");
        Notebook notebook11 = new Notebook("notebook11", 8, 256, "macOS", "Black", "sn111");
        Notebook notebook12 = new Notebook("notebook12", 16, 256, "macOS", "White", "sn112");
        Notebook notebook13 = new Notebook("notebook13", 32, 256, "macOS", "White", "sn113");
        Notebook notebook14 = new Notebook("notebook14", 8, 512, "macOS", "White", "sn114");
        Notebook notebook15 = new Notebook("notebook15", 16, 512, "macOS", "Black", "sn115");
        Notebook notebook16 = new Notebook("notebook16", 32, 2048, "macOS", "White", "sn116");
        Notebook notebook17 = new Notebook("notebook17", 64, 1024, "macOS", "White", "sn117");
        Notebook notebook18 = new Notebook("notebook18", 16, 1024, "macOS", "White", "sn118");
        Notebook notebook19 = new Notebook("notebook19", 32, 2048, "macOS", "Black", "sn119");
        Notebook notebook20 = new Notebook("notebook20", 64, 1024, "Linux", "White", "sn120");
        Notebook notebook21 = new Notebook("notebook20", 32, 1024, "macOS", "White", "sn120");
        Notebook notebook22 = new Notebook("notebook20", 32, 1024, "macOS", "White", "sn122");

    //Создаём множество для хранения интересующих экземпляров класса
        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5,
                notebook6, notebook7, notebook8, notebook9, notebook10, notebook11, notebook12, notebook13,
                notebook14, notebook15, notebook16, notebook17,
                notebook18, notebook19, notebook20, notebook21, notebook22));

    //Запускаем в работу метод по фильтрации из множества notebooks
        filterParamsNotebook(notebooks);
    }

    //Создаём метод по фильтрации из множества класса Notebook
    public static void filterParamsNotebook(Set<Notebook> notebooks) {
        //Создаём словари LinkedHashMap для хранения параметров и их ключей
        //с функцией запоминания по порядку добавления
        LinkedHashMap<Integer, Integer> ramMap = new LinkedHashMap<>();
        LinkedHashMap<Integer, Integer> hddMap = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> osMap = new LinkedHashMap<>();
        LinkedHashMap<Integer, String> colorMap = new LinkedHashMap<>();

        //Создаём множества TreeSet для хранения упорядоченных уникальных значений параметров
        //имеющихся в множестве notebooks экземпляров класса (ноутбуков)
        TreeSet<Integer> notebookRam = new TreeSet<>();
        TreeSet<Integer> notebookHdd = new TreeSet<>();
        TreeSet<String> notebookOs = new TreeSet<>();
        TreeSet<String> notebookColor = new TreeSet<>();

        System.out.println("\nЗдравствуйте!!! Сейчас мы вам подберём ноутбук по интересующим вас параметрам!!!\n");

        //Создаём множество для хранения отфильтрованных по критериям ноутбуков
        Set<Notebook> filteredNotebooks = new HashSet<>();

        //Наполняем множество notebookRam имеющимися значениями параметра ОЗУ,
        //благодаря типу TreeSet, они отсортируются в порядке возрастания
        for (Notebook notebook : notebooks) {
            notebookRam.add(notebook.getRam());
        }

        //Теперь осуществим фильтрацию по критерию выбора ОЗУ.
        //Алгоритм следующий:
        //Бесконечный цикл и двухфакторная проверка вводимого значения позволяют
        //нам точно определить какие ноутбуки пройдут на следующий этап фильтрации по другому критерию
        //(правильным ответом будет только числовой номер позиции из предложенных).
        //Формирование в запросе количества предлагаемых позиций
        //осуществляется благодаря размеру множества уникальных значений этого параметра
        //+ дополнительный вариант, допускающий любое значение (т.е. все).
        //Одновременно с тем, как формируется запрос для пользователя, выводимый в терминал,
        //у нас наполняется словарь со значениями параметров данного критерия по ключам, соответствующим
        //номерам позиций, предлагаемых на выбор и значения также соответствуют указанным в позициях.
        //Таким образом, мы используем вводимое пользователем число как ключ элемента словаря с параметрами.
        //Теперь у нас 2 сценария:
        //1)выбрать непосредственно вариант минимально удовлетворяющего значения параметра,
        //где мы зная по ключу это значение, сравниваем его с имеющимися во всем множестве ноутбуков и
        //добавляем в отфильтрованное множество все ноутбуки с параметрами не меньше указанного и заканчиваем цикл;
        //2)выбрать вариант, допускающий любое значение, тем самым добавив в отфильтрованное множество
        //все имеющиеся ноутбуки и закончить цикл.
        //Также есть 2 дополнительных сценария, когда ноутбуков мало или вообще нет:
        //1)если у нас в запасе только одно значение параметра, то спрашивать пользователя
        //что он выберет смысла не имеет, поэтому можно сразу пропустить этот выбор критерия изначальной проверкой
        //размера множества уникальных значений параметра, если оно равно 1, то пропускаем запрос по данному критерию,
        //добавляем в множество отфильтрованных автоматически все имеющиеся, заканчиваем цикл и идём к следующему
        //запросу по другому критерию;
        //2)если же нет ни одного параметра, то значит и ноутбуки закончились, выходим из цикла и предупреждаем об этом.
        //
        //Следующий критерий по выбору минимального объема ЖД осуществлён аналогичным образом,
        //разница лишь в том, что теперь при выборе нужной позиции мы отсеиваем из множества отфильтрованных ноутбуков,
        //те, значения параметра критерия которых меньше желаемого, а если нас устраивают любые параметры этого критерия,
        //то просто выходим из цикла и идём к следующему критерию.
        //
        //Следующие 2 критерия по выбору операционной системы и цвета аналогичны предыдущему, за исключением того,
        //что значения словарей для хранения параметров являются строковыми, а не целочисленными.
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
                filteredNotebooks.addAll(notebooks);
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

        //Ниже реализован алгоритм по покупке ноутбука, с возможностью выбора из всех, подходящих по всем критериям.
        //Алгоритм идентичен вышестоящим почти во всём, дополнительно можно отметить, что при покупке выбранного
        //экземпляра мы удаляем его из множества всех имеющихся ноутбуков, для того, чтобы хранить актуальную
        //информацию по всему ассортименту
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

        //Вводим проверку на наличие имеющихся экземпляров, если они закончились, то завершаем работу метода,
        //если еще остались, то применяем рекурсию и повторно запускаем метод для продолжения
        //продажи из актуального ассортимента.
        //сюда же мы придём, если хотя бы в одном из запросов критерия не будет ни одного предлагаемого варианта.
        if (notebooks.isEmpty()) {
            System.out.println("\nМагазин закрыт!!!\nНоутбуки, к сожалению закончились\n");
        } else {
            filterParamsNotebook(notebooks);
        }
    }
}
