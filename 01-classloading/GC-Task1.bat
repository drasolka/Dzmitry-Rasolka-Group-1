cd 01-classloader
java -Xms6m -Xmx18m -Xmn2m -XX:PermSize=20m -XX:MaxPermSize=30m -XX:+UseSerialGC -classpath target/classes com.epam.App
