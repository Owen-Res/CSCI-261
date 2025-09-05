public class Animal {
    private String name;
    private String quote;

    public Animal(String name, String utterance) {
        this.name = name;
        quote = utterance;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.printf("Name: %s\n", name);
        System.out.printf("Quote: \"%s\"\n", quote);
    }

    public void speak() {
        System.out.printf("%s: \"%s\"\n", name, quote);
    }
}
