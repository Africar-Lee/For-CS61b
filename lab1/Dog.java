public class Dog {
    public int weightInPounts;

    public Dog(int w) {
        weightInPounts = w;
    }
    public void makeNoise() {
        if(weightInPounts < 10) {
            System.out.println("yipyipyip!");
        } else if( weightInPounts < 30) {
            System.out.println("bark! bark!");
        } else {
            System.out.println("woooof!");
        }
    }
    public static Dog maxDog(Dog d1, Dog d2) {
        if(d1.weightInPounts > d2.weightInPounts)
            return d1;
        return d2;
    }
}
