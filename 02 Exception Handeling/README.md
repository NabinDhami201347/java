# [Java Exception Handling]()

**_Exception is an unwanted or unexpected event, which occurs during the execution of a program, i.e. at run time, that disrupts the normal flow of the program’s instructions. When an exception occurs within a method, it creates an object. This object is called the exception object. It contains information about the exception, such as the name and description of the exception and the state of the program when the exception occurred._**

![Image](https://cdn.programiz.com/sites/tutorial2program/files/ExceptionHierarchy.png)

RuntimeException happens due to a programming error. They are also known as unchecked exceptions. These exceptions are not checked at compile-time but run-time. They are also known as unchecked exceptions. i.e dividing a number by 0 `ArithmeticException`, Out-of-bounds array access `ArrayIndexOutOfBoundsException`.

An IOException is also known as a checked exception. They are checked by the compiler at the compile-time and the programmer is prompted to handle these exceptions. i.e trying to open a file that doesn’t exist results `FileNotFoundException`.

---

**Exception handling in Java allows you to handle and recover from unexpected or exceptional situations that may occur during the execution of a program. It helps you control the flow of the program and provides a way to handle errors gracefully without crashing the program. Java provides a built-in mechanism for handling exceptions using the try-catch-finally blocks. In Java exceptions are classified into two main categories: `Checked exceptions` and `Unchecked exceptions`. Both checked and unchecked exceptions are subclasses of the `Exception class`. The `RuntimeException class` and its subclasses represent unchecked exceptions, while all other exceptions are checked exceptions. It's important to note that errors, such as Error and its subclasses (OutOfMemoryError, StackOverflowError, etc.), are distinct from exceptions. Errors typically indicate serious problems that are beyond the control of the program, and they are not meant to be caught or handled by normal application code.**

```java
try {
    // Code that may throw an exception
} catch (ExceptionType1 exception1) {
    // Code to handle exception1
} catch (ExceptionType2 exception2) {
    // Code to handle exception2
} finally {
    // Optional block of code that always executes, regardless of whether an exception occurred or not
}
```

> **_`Try block` is the code that may throw an exception is enclosed within a try block. If an exception occurs within the try block, it's thrown and the program flow jumps to the appropriate catch block. A `Catch Block` follows the try block and specifies the type of exception it can handle. If the type of exception thrown matches the type specified in the catch block, the code within that catch block is executed. You can have multiple catch blocks to handle different types of exceptions. The `Finally Block` is optional and follows the catch block(s). It is executed whether an exception occurred or not. This block is typically used to release any resources held in the try block._**

```ts
try {
    int result = divide(10, 0); // Division by zero will throw an ArithmeticException
    System.out.println("Result: " + result);
} catch (ArithmeticException e) {
    System.out.println("An arithmetic exception occurred: " + e.getMessage());
}
```

```java
import java.io.*;
class Main {
  public static void findFile() throws IOException {
    File newFile=new File("test.txt");
    FileInputStream stream=new FileInputStream(newFile);
  }

  public static void main(String[] args) {
    try {
      findFile();
    } catch(IOException e1){
      System.out.println(e1.getMessage());
    } catch(InvalidClassException e2){
      System.out.println(e2.getMessage());
    }
  }
}
```

> **_The throws keyword is used to declare the type of exceptions that might occur within the method. It is used in the method declaration._**
