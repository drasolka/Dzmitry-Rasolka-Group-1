cd 01-classloader
java -Xms9m -Xmx18m -Xmn3m -XX:PermSize=40m -XX:MaxPermSize=40m -XX:+UseParallelOldGC -classpath target/classes com.epam.App
