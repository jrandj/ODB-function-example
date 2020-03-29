# ODB-function-example

This is an example for calling an Oracle Database function using Java.

## Usage

1\. Create a config.properties file with the database connection parameters, e.g.

```
db.user=VALUE
db.URL=jdbc:oracle:thin:@HOST:PORT/INSTANCE_NAME
db.password=VALUE
```

2\. Download ojdbc8 drivers from Oracle (available [here](https://www.oracle.com/database/technologies/jdbc-ucp-122-downloads.html)).

3\. Add ojdbc8 .jar files to Eclipse and class path as necessary.

4\. Add Function.sql to your Oracle Database.

5\. Change path to config.properties in App.

6\. Run "mvn clean install -U".

7\. Execute in Windows Command Prompt from Target directory with (e.g.) "java -cp example-1.0-SNAPSHOT.jar;C:\Users\me\Desktop\ojdbc8-full\* function.example.App"