import java.util.*;

/**
 * Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
 * Создать множество ноутбуков.
 * Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
 * и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
 * Например:
 * “Введите цифру, соответствующую необходимому критерию:
 * 1 - ОЗУ
 * 2 - Объем ЖД
 * 3 - Операционная система
 * 4 - Цвет …"
 *
 * Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map.
 * Отфильтровать ноутбуки в их первоначальном множестве и вывести проходящие по условиям.
 */
public class Main {
    public static void main(String[] args) {
        List<Notebook> notebooks = createNotebooksList();
        String criteria = getCriteria();
        Map<Integer, String> listCriteria = getListCriteria(notebooks, criteria);
        String selectCriteria = select2Criteria(listCriteria);

        switch (criteria) {
            case "Бренд":
                for (Notebook brand : notebooks) {
                    if (brand.getBrand().equalsIgnoreCase(selectCriteria)) {
                        System.out.println(brand.printInfo());
                    }
                }
                break;
            case "Диагональ":
                for (Notebook size : notebooks) {
                    String str = String.format("%.1f", size.getScreenSize());
                    if (str.equalsIgnoreCase(selectCriteria)) {
                        System.out.println(size.printInfo());
                    }
                }
                break;
        }


//        Set<String> unique = new TreeSet<>();
//        for (Notebook i: notebooks) {
//            unique.add(i.getBrand());
//        }
//
//
//        System.out.println(unique);
//
//        List<Notebook> notebookList = List.of(ChuwiAH401, SamsungS101, SamsungS150, AsusTUF504, AsusTUF555);
//
//        Scanner scannerUser = new Scanner(System.in);
//        System.out.println("Выберите параметр для поиска, где:\n1 - по цвету\n2 - по бренду");
//        int choiceUserSearch = scannerUser.nextInt();
//        Scanner scannerRequestUserForSearch = new Scanner(System.in);
//        System.out.println("Напишите интересующий цвет или бренд: ");
//        String requestUserForSearch = scannerRequestUserForSearch.nextLine();
//
//        if (choiceUserSearch == 1) {
//            for (Notebook color : notebookList) {
//                if (color.getColor().equalsIgnoreCase(requestUserForSearch)) {
//                    System.out.println(color.printInfo());
//                }
//            }
//
//        } else if (choiceUserSearch == 2){
//            for (Notebook brand : notebookList) {
//                if (brand.getBrand().equalsIgnoreCase(requestUserForSearch)) {
//                    System.out.println(brand.printInfo());
//                }
//            }
//        } else {
//            System.out.println("Ошибка.\nВыберите параметр для поиска, где:\n1 - по цвету\n2 - по бренду");
//        }
//
//        scannerUser.close();
    }

    private static List createNotebooksList() {
        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook("Lenovo", "Intel Pentium Gold 7505", "IdeaPad 3 14ITL6 Sand Gold", 8, 8, 512, 14, "DDR4", "SSD"));
        notebooks.add(new Notebook("Huawei", "Intel Core i5-12450H", "MateBook D16 53013DLC Space Gray", 15, 8, 512, 16, "DDR4", "SSD"));
        notebooks.add(new Notebook("Dell", "Intel Core i5-1235U", "Latitude 5430 Grey", 22, 16, 512, 14, "DDR4", "SSD"));
        notebooks.add(new Notebook("Dell", "Intel Core i7-12700H", "XPS 15 (9520) Platinum Silver", 58, 16, 1024, 15.6, "DDR5", "NVMe SSD"));
        notebooks.add(new Notebook("HP", "AMD Athlon 3050U", "255 G8 Dark Ash Silver", 5, 4, 128, 15.6, "DDR4", "SSD"));
        notebooks.add(new Notebook("Lenovo", "Intel Celeron N4020", "IdeaPad 3 15IGL05 Platinum Grey", 6, 4, 256, 15.6, "DDR4", "SSD"));
        notebooks.add(new Notebook("Asus", "Intel Celeron N4020", "VivoBook E410MA Blue", 6, 4, 256, 14, "DDR4", "SSD"));
        notebooks.add(new Notebook("Acer", "AMD Athlon 3050U", "Extensa EX215-22-R5ZW Charcoal Black", 7, 8, 256, 15.6, "DDR4", "SSD"));

        return notebooks;
    }

    private static String getCriteria() {
        Scanner sc = new Scanner(System.in);

        Map<Integer, String> criterias = new HashMap<>();
        criterias.put(1, "Бренд");
        criterias.put(2, "Диагональ");
//        criterias.put(3, "Цена");
//        criterias.put(4, "RAM");

        System.out.println("Введите цифру, соответствующую нужному критерию:");
        for (Integer key : criterias.keySet()) {
            System.out.printf("%d => %s\n", key, criterias.get(key));
        }
        int select = sc.nextInt();
        return criterias.get(select);
    }

    private static Map<Integer, String> getListCriteria(List<Notebook> list, String str) {
        switch (str) {
            case "Бренд":
                Set<String> brandList = new TreeSet<>();
                for (Notebook brand: list) {
                    brandList.add(brand.getBrand());
                }
                Map<Integer, String> brandMap = new HashMap<>();
                int j = 1;
                for (String brand: brandList) {
                    brandMap.put(j, brand);
                    j++;
                }
                return brandMap;
            case "Диагональ":
                Set<Double> sizeList = new TreeSet<>();
                for (Notebook size: list) {
                    sizeList.add(size.getScreenSize());
                }
                Map<Integer, String> sizeMap = new HashMap<>();
                int k = 1;
                for (double size: sizeList) {
                    sizeMap.put(k, String.format("%.1f", size));
                    k++;
                }
                return sizeMap;
        }
        return null;
    }

    private static String select2Criteria(Map<Integer, String> list) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Введите подходящую цифру:");
        for (int key: list.keySet()) {
            System.out.printf("%d => %s\n", key, list.get(key));
        }
        int select = sc1.nextInt();
        sc1.close();
        return list.get(select);
    }

}