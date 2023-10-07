# kafka-java

这是一个用java实现的kafka中producer和consumer程序的demo，在使用前需要安装配置好kafka,并确保其kafka能正常使用

## 运行consumer程序
```bash
git clone git@github.com:xiangyouzhuan/kafka-java.git
cd kafka-java
cd my-app1/target
java -jar my-app-1.0-SNAPSHOT-jar-with-dependencies.jar
```

屏幕输出
```bash
Receiving!...
```
表示已运行consumer

打开另一个终端
## 运行producer程序
```bash
cd kafka-java
cd my-app/target
java -jar my-app-1.0-SNAPSHOT-jar-with-dependencies.jar
```
屏幕输出
```bash
send:0
send:1
send:2
send:3
send:4
send:5
send:6
send:7
send:8
send:9
send:10
send:11
send:12
send:13
send:14
...
```

回到consumer程序运行的终端，终端输出
```bash
Receiving!...
offset = 1095, key = 0, value = 0
offset = 1096, key = 1, value = 1
offset = 1097, key = 2, value = 2
offset = 1098, key = 3, value = 3
offset = 1099, key = 4, value = 4
offset = 1100, key = 5, value = 5
offset = 1101, key = 6, value = 6
offset = 1102, key = 7, value = 7
offset = 1103, key = 8, value = 8
offset = 1104, key = 9, value = 9
offset = 1105, key = 10, value = 10
offset = 1106, key = 11, value = 11
offset = 1107, key = 12, value = 12
offset = 1108, key = 13, value = 13
offset = 1109, key = 14, value = 14
offset = 1110, key = 15, value = 15
...
```




