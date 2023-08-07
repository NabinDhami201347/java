public class Arrays {

    public static void main(String args[]) {
        String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };

        System.out.println(cars[0]);
        System.out.println(cars.length);

        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i]);
        }

        for (String i : cars) {
            System.out.println(i);
        }
    }
}
