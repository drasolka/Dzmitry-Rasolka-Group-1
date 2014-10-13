cd 01-classloader
java -Xms2m -Xmx18m -Xmn1m -XX:PermSize=24m -XX:MaxPermSize=36m -XX:ParallelCMSThreads=2 -XX:+UseConcMarkSweepGC -classpath target/classes com.epam.App
