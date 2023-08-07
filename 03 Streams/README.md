**_Java provides File Streams for reading from and writing to files. File Streams allow you to perform I/O operations on files in a sequential manner. The primary classes for working with File Streams in Java are FileInputStream, FileOutputStream, BufferedInputStream, and BufferedOutputStream. FileInputStream class is used for reading data from a file. It provides methods like read() and read(byte[]) to read data byte by byte or in chunks from the file. FileOutputStream class is used for writing data to a file. It provides methods like write(int) and write(byte[]) to write data byte by byte or in chunks to the file. BufferedInputStream and BufferedOutputStream classes provide buffering capabilities, which can improve the performance of file I/O operations. They internally use a buffer to reduce the number of actual read/write operations to the underlying file._**

```java
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileExample {
    public static void main(String[] args) {
        String fileName = "example.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```

```java
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileExample {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("output.txt")) {
            String data = "Hello, World!";
            fos.write(data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
