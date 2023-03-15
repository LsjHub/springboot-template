# springboot-template

这是一个集成了mybatis-plus、redis的Spring Boot框架，运行起来即可依据样例进行开发，既方便学习，也利于快速搭建项目，还可用作学习其他依赖库。

###  一、运行项目

1.安装JDK、Maven、cURL。

2.在项目目录下运行：mvn spring-boot:run

3.访问test接口验证：curl -X POST '127.0.0.1:8001/test'

###  二、使用MySQL

1.安装并运行MySQL8.0服务，设置用户名、密码：alter user 'root'@'localhost' identified by '123456';

2.创建一个数据库：create database databaseName;

3.导入test.sql：use databaseName; source [test.sql绝对路径];

4.修改application-dev.yml的配置信息与数据库相对应。

5.运行并访问test_mysql接口验证：curl -X POST '127.0.0.1:8001/test_mysql'

###  二、使用Redis

1.安装并运行Redis服务。

2.运行并访问test_redis接口验证：curl -X POST '127.0.0.1:8001/test_redis'
