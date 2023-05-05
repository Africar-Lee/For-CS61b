public class Doglauncher {
    public static void main(String[] args) {
        Dog d;
        int w = Integer.parseInt(args[0]);
        int w2 = Integer.parseInt(args[1]);
        d = new Dog(w);
        d.makeNoise();
        Dog d2 = new Dog(w2);
        Dog bigger = Dog.maxDog(d, d2);
        bigger.makeNoise();
    }
}
