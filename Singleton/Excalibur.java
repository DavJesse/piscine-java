public class Excalibur {
    private String name;
    private static final Excalibur INSTANCE = new Excalibur("Sword");

    private Excalibur(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Excalibur getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
         System.out.println(Excalibur.getInstance().getName());
    }
}