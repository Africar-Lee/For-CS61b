public class DrawTriangle {
    public static void main(String[] args) {
        int i = 1;
        while(i < 6) {
            int k = i;
            while(k > 0) {
                System.out.print("*");
                k--;
            }
            System.out.println();
            ++i;
        }
    }
}
