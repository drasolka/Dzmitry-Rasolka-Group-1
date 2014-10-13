cd 01-classloader
java -Xms4m -Xmx16m -Xmn3m -XX:PermSize=24m -XX:MaxPermSize=32m -XX:ParallelCMSThreads=2 -XX:+UseParallelGC -classpath target/classes com.epam.App
