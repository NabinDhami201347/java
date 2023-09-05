class Example {
    public static void main(String[] args) {

        try {
            int num = Integer.parseInt("pants");
            System.out.println(num);
        } catch (Exception e) {
            System.out.println("Exception Occoured: " + e.getMessage());
        }

        System.out.println("Hello World!");
    }
}