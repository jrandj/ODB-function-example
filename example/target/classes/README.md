# ODB-function-example

This is an example for calling an Oracle Database function using Java.

## Usage

1\. Create a config.properties with the database connection parameters, e.g.

```
db.user=VALUE
db.URL=jdbc:oracle:thin:@HOST:PORT/INSTANCE_NAME
db.password=VALUE
```

2\. Add Function.sql to your Oracle Database.

3\. Change location of config.properties in App and run.