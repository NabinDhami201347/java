# 01 Introduction | JAVA

**_Java is one of the most popular and widely used programming language and platform. A platform is an environment that helps to develop and run programs written in any programming language. Java is fast, reliable and secure. From desktop to web applications, scientific supercomputers to gaming consoles, cell phones to the Internet, Java is used in every nook and corner._**

**Java Runtime Environment is a software package that provides Java class libraries, Java Virtual Machine (JVM), and other components that are required to run Java applications.**
**Java Development Kit is intended for software developers and includes development tools such as the Java compiler, Javadoc, Jar, and a debugger.**
**Java Virtual Machine is an abstract machine. It is a specification that provides a runtime environment in which java bytecode can be executed.**

```java
public class HelloWorld {
    public static void main(String args[]) {
        System.out.println("Hello World!!");
    }
}
```

```sh
jshell

javac HelloWorld.java
java HelloWorld
rm -f ./01\ Basics/*.class
```

![JAVA](https://www.altexsoft.com/media/2018/08/bytecode.png)

> **_Every valid Java Application must have a `class definition` that matches the `filename` (class name and file name should be same). The `main` method must be inside the class definition. The compiler executes the codes starting from the main function._**
