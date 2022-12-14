package M04_JavaOOP.L12_DesignPatterns.Exercises.T01FactoryDesignPattern;

public class ItalianPizza extends Pizza {

    public ItalianPizza(double diameter) {
        super(diameter);
    }

    @Override
    public void prepare() {
        System.out.println("Preparing Italian Pizza");
    }

    @Override
    public void bake() {
        System.out.println("Baking Italian Pizza");
    }

    @Override
    public void box() {
        System.out.println("Boxing Italian Pizza");
    }
}