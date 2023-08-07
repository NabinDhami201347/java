class GrandParent {
    GrandParent() {
        System.out.println("GrandParent Class");
    }

    void displayName() {
        System.out.println("GrandParent");
    }
}

class Parent extends GrandParent {
    Parent() {
        System.out.println("Parent Class");
    }

    void displayName() {
        System.out.println("Parent Class");
    }
}

class Children extends Parent {
    Children() {
        System.out.println("Children  Class");
    }

    void displayName() {
        System.out.println("Children");
    }
}

public class Hello {
    public static void main(String[] args) {
        Children c = new Children();
        c.displayName();
    }
}