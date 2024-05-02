package lesson6.HomeWork6;
//Задание
//
//        -Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
//        методы. Реализовать в java.
//        -Создать множество ноутбуков.
//        -Написать метод, который будет запрашивать у пользователя критерий (или критерии)
//        фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
//        хранить в Map. Например:
//        “Введите цифру, соответствующую необходимому критерию:
//        1 - ОЗУ
//        2 - Объем ЖД
//        3 - Операционная система
//        4 - Цвет …
//        -Далее нужно запросить минимальные значения для указанных критериев - сохранить
//        параметры фильтрации можно также в Map.
//        -Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
//        условиям.


import java.util.Objects;

public class Notebook {
    private String model;   //  Название модели
    private int ram;      // Объем ОЗУ (в ГБ)
    private int hdd;        // Объем жесткого диска (в ГБ)
    private String os;   //  Операционная система
    private String color;   //  Цвет

    public Notebook(String model,int ram, int hdd, String os, String color) {
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
    }

    // Геттеры
    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }
    public String getColor() {
        return color;
    }

    // Сеттеры
    public void setModel(String model) {
        this.model = model;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Модель: " + model + ", Объем ОЗУ (в ГБ): " + ram + ", Объем жесткого диска (в ГБ): "
                + hdd + ", Операционная система: " + os + ", Цвет: " + color;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Notebook notebook = (Notebook) obj;
        return (model.equals(notebook.model)) && (ram == notebook.ram) && (hdd == notebook.hdd) && (os.equals(notebook.os)) && (color.equals(notebook.color));
    }

    @Override
    public int hashCode() {

        return Objects.hash(model, ram, hdd, os, color);
    }
}

