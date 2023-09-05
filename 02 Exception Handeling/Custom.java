
public class Custom {

    private static void validateAge(int age) throws LessAgeException {
        if (age < 10) {
            throw new LessAgeException("Age cannot be less than 10");
        }
    }

    public static void main(String[] args) {

        try {
            validateAge(10);

        } catch (LessAgeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static class LessAgeException extends Exception {
        public LessAgeException(String message) {
            super(message);
        }
    }
}
