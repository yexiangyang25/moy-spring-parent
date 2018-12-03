## 单节点
java -jar -Xms128m -Xmx256m moy-eureka-server-1.0-SNAPSHOT.jar
## 集群
java -jar -Xms128m -Xmx256m moy-eureka-server-1.0-SNAPSHOT.jar --spring.profiles.active=peer1
java -jar -Xms128m -Xmx256m moy-eureka-server-1.0-SNAPSHOT.jar --spring.profiles.active=peer2
java -jar -Xms128m -Xmx256m moy-eureka-server-1.0-SNAPSHOT.jar --spring.profiles.active=peer3