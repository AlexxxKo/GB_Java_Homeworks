import java.util.Objects;

public class Notebook {
    private String brand;
    private String cpu;
    private String model;
    private int price;
    private int ram;
    private int rom;
    private double screenSize;
    private String typeRam;
    private String typeRom;

    public Notebook(String brand, String cpu, String model, int price, int ram, int rom, double screenSize, String typeRam, String typeRom) {
        this.brand = brand;
        this.cpu = cpu;
        this.model = model;
        this.price = price;
        this.ram = ram;
        this.rom = rom;
        this.screenSize = screenSize;
        this.typeRam = typeRam;
        this.typeRom = typeRom;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public double getScreenSize() {
        return screenSize;
    }


    public String printInfo(){
        System.out.printf("%s %s,\nПроцессор: %s,\nДиагональ: %.1f дюймов,\nRAM: %dGb %s,\nЖесткий диск: %dGb %s,\nЦена: %d у.е.\n", brand, model, cpu, screenSize, ram, typeRam, rom, typeRom, price);
        return " ";
    }
}
