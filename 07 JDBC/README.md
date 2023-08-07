# Java Database Connectivity (JDBC)

*JDBC stands for Java Database Connectivity, and it is a Java API (Application Programming Interface) that provides a set of classes and methods to interact with relational databases. It allows Java programs to connect to and interact with various database systems, such as MySQL, PostgreSQL, Oracle, Microsoft SQL Server, and others. JDBC enables developers to perform database operations like querying data, inserting, updating, and deleting records, as well as managing transactions and executing stored procedures.*


![jdbc](https://media.geeksforgeeks.org/wp-content/uploads/20200229213833/Architecture-of-JDBC2.jpg)


```java
import java.sql.*;
```

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```
> ***The first step in using JDBC is to load the appropriate JDBC driver into the Java application. The driver is responsible for providing the implementation for the JDBC API, which allows the application to connect and interact with the database. In modern JDBC implementations, the driver class is automatically loaded using the `Class.forName()` method or through the service provider mechanism.***

```java
String url = "jdbc:mysql://hostname:port/database_name";
String username = "your_username";
String password = "your_password";
Connection connection = DriverManager.getConnection(url, username, password);
```
> ***Once the driver is loaded, the application can establish a connection to the database using the `DriverManager.getConnection()` method. The connection string contains the necessary information to connect to the database, such as the database URL, username, and password.***

```java
Statement statement = connection.createStatement();
PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO table_name (column1, column2) VALUES (?, ?)");
```

> ***After the connection is established, the application can create Statement or PreparedStatement objects to execute SQL queries and updates on the database. A Statement allows you to execute SQL queries, while a PreparedStatement allows you to execute precompiled SQL statements with placeholders for parameters.***

```java
ResultSet resultSet = statement.executeQuery("SELECT * FROM table_name");

int rowsAffected = statement.executeUpdate("UPDATE table_name SET column1 = value1 WHERE condition");
```
> ***With the Statement or PreparedStatement objects, you can execute SQL queries using the` executeQuery()` method. This method is used for SELECT statements and returns a `ResultSet` that contains the query results. <br /> For INSERT, UPDATE, DELETE, and other SQL update statements, use the `executeUpdate()` method of the Statement or PreparedStatement. It returns the number of affected rows.***

```java
while (resultSet.next()) {
    // Access the data from the current row
    String columnValue = resultSet.getString("column_name");
    // Process the data as needed
}
```
>  ***After executing a SELECT query, you can process the ResultSet to retrieve the data returned by the database. Use the appropriate methods like `getString()`, `getInt()`, etc., to access the values from the ResultSet.***

```java
resultSet.close();
statement.close();
connection.close();
```
>  ***After using the database connection, Statement, and ResultSet, remember to close them to release resources and avoid resource leaks. Closing the resources should be done in the reverse order of their creation.***

```java
try {
    // JDBC code here
} catch (SQLException e) {
    e.printStackTrace();
}
```
>  ***Throughout the JDBC life cycle, it's crucial to handle exceptions properly. `SQLExceptions` can occur during database operations, and you should handle them gracefully to avoid application crashes.***

-----

```java
import java.sql.*;

public class JDBCDemo {

	public static void main(String args[])
		throws SQLException, ClassNotFoundException
	{
		String driverClassName
			= "sun.jdbc.odbc.JdbcOdbcDriver";
		String url = "jdbc:odbc:XE";
		String username = "scott";
		String password = "tiger";
		String query
			= "insert into students values(109, 'bhatt')";

		// Load driver class
		Class.forName(driverClassName);

		// Obtain a connection
		Connection con = DriverManager.getConnection(
			url, username, password);

		// Obtain a statement
		Statement st = con.createStatement();

		// Execute the query
		int count = st.executeUpdate(query);
		System.out.println(
			"number of rows affected by this query= "
			+ count);

		// Closing the connection as per the
		// requirement with connection is completed
		con.close();
	}
} 
```