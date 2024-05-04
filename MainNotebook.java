package lesson6.HomeWork6;

//Примечание!!! Для проверки: два ноутбука notebook20 и notebook21 с идентичными параметрами

import java.util.*;

public class MainNotebook {
    public static void main(String[] args) {
        Notebook notebook1 = new Notebook("notebook1", 8, 256, "Windows", "Black");
        Notebook notebook2 = new Notebook("notebook2", 16, 256, "Windows", "Black");
        Notebook notebook3 = new Notebook("notebook3", 32, 256, "Windows", "White");
        Notebook notebook4 = new Notebook("notebook4", 8, 512, "Windows", "Black");
        Notebook notebook5 = new Notebook("notebook5", 16, 512, "Windows", "White");
        Notebook notebook6 = new Notebook("notebook6", 32, 512, "Windows", "Black");
        Notebook notebook7 = new Notebook("notebook7", 8, 1024, "Windows", "White");
        Notebook notebook8 = new Notebook("notebook8", 16, 1024, "Windows", "Black");
        Notebook notebook9 = new Notebook("notebook9", 32, 1024, "Windows", "Black");
        Notebook notebook10 = new Notebook("notebook10", 32, 1024, "Windows", "White");
        Notebook notebook11 = new Notebook("notebook11", 8, 256, "macOS", "Black");
        Notebook notebook12 = new Notebook("notebook12", 16, 256, "macOS", "White");
        Notebook notebook13 = new Notebook("notebook13", 32, 256, "macOS", "White");
        Notebook notebook14 = new Notebook("notebook14", 8, 512, "macOS", "White");
        Notebook notebook15 = new Notebook("notebook15", 16, 512, "macOS", "Black");
        Notebook notebook16 = new Notebook("notebook16", 32, 512, "macOS", "White");
        Notebook notebook17 = new Notebook("notebook17", 8, 1024, "macOS", "White");
        Notebook notebook18 = new Notebook("notebook18", 16, 1024, "macOS", "White");
        Notebook notebook19 = new Notebook("notebook19", 32, 1024, "macOS", "Black");
        Notebook notebook20 = new Notebook("notebook20", 32, 1024, "macOS", "White");
        Notebook notebook21 = new Notebook("notebook20", 32, 1024, "macOS", "White");


        Set<Notebook> notebooks = new HashSet<>(Arrays.asList(notebook1, notebook2, notebook3, notebook4, notebook5,
                notebook6, notebook7, notebook8, notebook9, notebook10, notebook11, notebook12, notebook13,
                notebook14, notebook15, notebook16, notebook17, notebook18, notebook19, notebook20, notebook21));
        filterParamsNotebook(notebooks);
    }

    public static void filterParamsNotebook(Set<Notebook> notebooks) {
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

        System.out.println("Сейчас мы вам подберём ноутбук по интересующим вас параметрам!!!");
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите минимальный объем ОЗУ: ");
        System.out.println("1 - 8ГБ");
        System.out.println("2 - 16ГБ");
        System.out.println("3 - 32ГБ");
        System.out.println("4 - Для меня этот параметр не принциально важен");
        String ramMin = scanner.nextLine();
        String ramMeaning = ramMap.get(ramMin);


        System.out.println("Выберите минимальный объем жёсткого диска: ");
        System.out.println("1 - 256ГБ");
        System.out.println("2 - 512ГБ");
        System.out.println("3 - 1024ГБ");
        System.out.println("4 - Для меня этот параметр не принциально важен");
        String hddMin = scanner.nextLine();
        String hddMeaning = hddMap.get(hddMin);



        System.out.println("Выберите операционную систему: ");
        System.out.println("1 - Windows");
        System.out.println("2 - macOS");
        System.out.println("3 - Для меня этот параметр не принциально важен");
        String currentOs = scanner.nextLine();
        String osMeaning = osMap.get(currentOs);


        System.out.println("Выберите цвет: ");
        System.out.println("1 - Белый");
        System.out.println("2 - Черный");
        System.out.println("3 - Для меня этот параметр не принциально важен");
        String currentColor = scanner.nextLine();
        String colorMeaning = colorMap.get(currentColor);
        scanner.close();


        Set<Notebook> filteredNotebooks = new HashSet<>();
        if (ramMap.containsKey(ramMin)) {
            int minRam = Integer.parseInt(ramMeaning);
            for (Notebook notebook : notebooks) {
                if (notebook.getRam() >= minRam) {
                    filteredNotebooks.add(notebook);
                }
            }
        } else if (ramMin.equals("4")){
            filteredNotebooks.addAll(notebooks);
        } else {
            System.out.println("Ошибка при выборе объема ОЗУ");
        }

        if (hddMap.containsKey(hddMin)) {
            int minHdd = Integer.parseInt(hddMeaning);
            filteredNotebooks.removeIf(notebook -> notebook.getHdd() < minHdd);
        } else if (hddMin.equals("4")){
            filteredNotebooks = filteredNotebooks;
        } else {
            System.out.println("Ошибка при выборе объема жёсткого диска");
            filteredNotebooks.removeAll(filteredNotebooks);
        }

        if (osMap.containsKey(currentOs)) {
            filteredNotebooks.removeIf(notebook -> !Objects.equals(notebook.getOs(), osMeaning));
        } else if (currentOs.equals("3")){
            filteredNotebooks = filteredNotebooks;
        } else {
            System.out.println("Ошибка при выборе операционной системы");
            filteredNotebooks.removeAll(filteredNotebooks);
        }

        if (colorMap.containsKey(currentColor)) {
            filteredNotebooks.removeIf(notebook -> !Objects.equals(notebook.getColor(), colorMeaning));
        } else if (currentColor.equals("3")){
            filteredNotebooks = filteredNotebooks;
        } else {
            System.out.println("Ошибка при выборе цвета");
            filteredNotebooks.removeAll(filteredNotebooks);
        }

        if (filteredNotebooks.isEmpty()) {
            System.out.println("Попробуйте еще раз. Вводите значение только из предложенных вариантов!!!"); 
            //В нашем ассортименте имеются все модели под предложенные критерии параметров, 
            //поэтому множество отфильтрованных по критериям ноутбуков пусто только в случае ошибки ввода.
            //Программу конечно можно доработать до бесконечного цикла ввода вариантов критерия пока не будет выбран возможный,
            //но я решил, что в рамках задания эти процедуры лишние и вероятность ошибочного выбора из 2-х или 3-х цифр
            //не так высока. 
            //Кроме того данный подход оберегает неадекватного пользователя, ребёнка или случайно залезшего на клавиатуру
            //домашнего питомца от необдуманной покупки, а также сервер от перегрузки.
            
        } else {
            System.out.println();
            System.out.println("Вот что мы вам можем предложить:");
            System.out.println();
            for (Notebook notebook : filteredNotebooks) {
                System.out.println(notebook);
            }
        }
    }
}
