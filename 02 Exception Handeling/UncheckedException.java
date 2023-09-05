public class UncheckedException {

    // Unchecked exception at run time -> NullPointerException
    // It compiles and explode during runtime
    private static void printLength(String myString) {
        System.out.println(myString.length());
    }

    public static void main(String[] args) {
        printLength(null);
    }
}
