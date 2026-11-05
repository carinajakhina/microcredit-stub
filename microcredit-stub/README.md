# Запуск без профиля
java -Xms2048m -Xmx4096m -jar target/microcredit-stub-0.0.1-SNAPSHOT.jar

# Запуск с профилем test1
java -Xms2048m -Xmx4096m -jar target/microcredit-stub-0.0.1-SNAPSHOT.jar --spring.profiles.active=test1

# Запуск с профилем test2
java -Xms2048m -Xmx4096m -jar target/microcredit-stub-0.0.1-SNAPSHOT.jar --spring.profiles.active=test2