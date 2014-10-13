cd 01-classloader
java -Xms4m -Xmx16m -Xmn2m -XX:PermSize=12m -XX:MaxPermSize=18m -XX:+UseG1GC -classpath target/classes com.epam.App
