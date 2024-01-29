# ql-boot-simple

> 失手扑空蓝色的蜻蛉
> 
> Author: [chocohQL](https://github.com/chocohQL)
> 
> GitHub: [https://github.com/chocohQL/ql-boot-simple](https://github.com/chocohQL/ql-boot-simple)

## 项目介绍

ql-boot-simple 是一个极简的 SpringBoot 模板项目，已配置好基本框架和通用代码，用于快速搭建一个小型的后端项目。

## 相关项目

+ 前端配套测试项目：[ql-vue-template](https://github.com/chocohQL/ql-vue-template)
+ SpringBoot多模块模板项目：[ql-boot-template](https://github.com/chocohQL/ql-boot-template)

## 技术选型

+ JDK 8
+ SpringBoot
+ Sa-Token
+ MyBatisPlus
+ MySQL
+ Redis

## 项目结构

```
ql-boot-simple  
├── com.chocoh.ql
│       └── config                          // 配置
│       └── constant                        // 常量
│       └── controller                      // 控制层
│       └── domain                          // 实体类
│       └── exception                       // 异常处理
│       └── mapper                          // 持久层
│       └── service                         // 业务层
│       └── utils                           // 工具类
```

## 快速开始

### 创建数据库表

`sql/ql_boot_simple.sql` 

创建数据库执行sql文件，仅生成一个 user 表，对应 User 类，可按需扩充字段。

### 修改application.yml文件

`ql-framework/src/main/resources/application.yml`

修改 MySQL 和 Redis 连接配置

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/ql_boot_simple?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false
    username: root
    password: yourPassword
    type: com.zaxxer.hikari.HikariDataSource
    driver-class-name: com.mysql.cj.jdbc.Driver

  redis:
    host: localhost
    port: 6379
    password: yourPassword
```

### 测试启动

启动项目，默认实现了登录和退出登录接口。

sql中生成的测试用户 -> 用户名:chocoh，密码:123123。

## 了解更多

### 客户端

### 修改客户端配置

项目提供了多种现成客户端工具：
+ EmailClient：用于邮箱发送
+ OssClient：用于阿里云OSS存储

配置使用客户端：

1. 修改配置文件

```yaml
email:
  host: smtp.qq.com
  from: change@qq.com
  password: change
  username: change@qq.com

oss:
  endpoint: change
  url: change
  bucket-name: chocoh
  access-key-id: change
  access-key-secret: change
  file-dir: ql/avatar/
```

2. 注册客户端为bean

`com.chocoh.ql.config.ClientConfig`

```java
@Configuration
public class ClientConfig {
    @Bean
    public EmailClient emailClient() {
        return new EmailClient();
    }

    @Bean
    public OssClient ossClient() {
        return new OssClient();
    }
}
```

### 超级响应类

`com.chocoh.ql.domain.model.Response`

+ 类名调用直接响应基本的 {msg, code, data} 结构。
+ 继承 HashMap ，内置了 DataMap 内部类，方便链式调用生成各种复杂的响应结构。

#### 常用结构

```java
return Response.success(new ArrayList<>());
```
```json
{
        "msg":"操作成功",
        "code":200,
        "data":[]
}
```
#### 通过链式调用实现各种复杂结构

```java
Response response = Response.dataMap()
        .put("1", "参数一")
        .put("2", "参数二")
        .getMap("3")
        .put("3.1", System.currentTimeMillis())
        .put("3.2", new Random().nextInt(8))
        .getMap("3.3")
        .put("4.1", Constants.HEADER_TOKEN)
        .put("4.2", new User(1L, "chocoh", "123123", "admin"))
        .put("4.3", new Response.DataMap().put("5.1", true).put("5.2", ""))
        .ok()
        .put("其他外层参数", "...");
QlApplicationTest.printJson(response);
```

```json
{
  "msg":"操作成功",
  "其他外层参数":"...",
  "code":200,
  "data":{
    "1":"参数一",
    "2":"参数二",
    "3":{
      "3.1":1703938143220,
      "3.2":5,
      "3.3":{
        "4.1":"Authorization",
        "4.2":{
          "password":"123123",
          "role":"admin",
          "id":1,
          "username":"chocoh"
        },
        "4.3":{
          "5.1":true,
          "5.2":""
        }
      }
    }
  }
}
```

#### 其他结构

如果不想使用 {msg, code, data} 结构，可以直接使用无参构造创建一个空 Response 对象，通过链式调用定制内容。

