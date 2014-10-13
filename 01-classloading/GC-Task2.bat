cd 01-classloader
java -Xms3m -Xmx12m -Xmn1m -XX:PermSize=20m -XX:MaxPermSize=20m -XX:+UseParallelGC -classpath target/classes com.epam.App
