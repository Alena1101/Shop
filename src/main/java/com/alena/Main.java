package com.alena;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Map<Integer, String> menuMap = new HashMap<>();
        menuMap.put(1, "добавить игрушку");
        menuMap.put(2, "список игрушек");
        menuMap.put(3, "изменить вес игрушки");
        menuMap.put(4, "розыгрыш");
        menuMap.put(5, "выход");
        Scanner scanner = new Scanner(System.in);
        List<Toy> toyList = new ArrayList<>();
        while (true) {
            System.out.println();
            System.out.println("Выберите действие : ");
            for (Map.Entry<Integer, String> entry : menuMap.entrySet()) {
                System.out.println(entry.getKey() + ":   " + entry.getValue());
            }
            int menuItem = scanner.nextInt();
            switch (menuItem) {
                case 1 -> {
                    Toy toy = createToy(scanner);
                    toyList.add(toy);
                    break;
                }
                case 2 -> {
                    showToyList(toyList);
                    break;
                }
                case 3 -> {
                    changeToy(scanner, toyList);
                    break;
                }
                case 4 -> {
                    prizeDraw(toyList);
                    break;
                }
                case 5 -> {
                    scanner.close();
                    return;
                }
                default -> {
                    System.out.println("Неверное значение, попробуйте еще раз");
                }
            }
        }
    }

    private static void prizeDraw(List<Toy> toyList) {
        int size = toyList.size();
        if (size == 0) {
            System.out.println("Извините, игрушки закончились :(  : ");
            return;
        }
        int sum = 0;
        for (Toy toy : toyList) {
            sum = sum + toy.getCount() * toy.getFrequency();
        }
        int random = (new Random()).nextInt(sum);

        int index = (int) Math.ceil(random * (size - 1) * 1.0 / sum);
        Toy toy = toyList.get(index);
        System.out.println();
        System.out.println("Вам выпала игрушка : " + toy.getName());

        System.out.println("       /\\_/\\");
        System.out.println("      / 0 0 \\  ");
        System.out.println("     (   \"   )");
        System.out.println("      \\~(*)~/  ");
        System.out.println("       // \\\\");

        int count = toy.getCount();
        if (count > 1) {
            toy.setCount(count - 1);
        } else {
            toyList.remove(index);
        }
    }

    private static void changeToy(Scanner scanner, List<Toy> toyList) {
        System.out.println();
        System.out.println("Выберите игрушку: ");
        for (int i = 0; i < toyList.size(); i++) {
            Toy toy = toyList.get(i);
            System.out.println(i + ". " + toy);
        }
        int number = scanner.nextInt();
        if (number >= toyList.size()) {
            System.out.println("Такой игрушки нет");
            return;
        }
        System.out.println("Введите новый вес выбранной игрушки: ");
        int frequency = scanner.nextInt();
        Toy toy = toyList.get(number);
        toy.setFrequency(frequency);
    }

    private static void showToyList(List<Toy> toyList) {
        System.out.println();
        System.out.println("Список игрушек: ");
        for (Toy toy : toyList) {
            System.out.println(toy);
        }
    }

    private static Toy createToy(Scanner scanner) {
        System.out.println();
        System.out.print("Введите id: ");
        int id = scanner.nextInt();
        System.out.print("Введите имя: ");
        String name = scanner.next();
        System.out.print("Введите количество: ");
        int count = scanner.nextInt();
        System.out.print("Введите вес: ");
        int frequency = scanner.nextInt();
        return new Toy(id, name, count, frequency);
    }

}