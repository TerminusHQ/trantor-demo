# Trantor Demo

此demo主要通过员工管理系统中简单的业务逻辑带领读者快速熟悉和上手trantor应用。
通过建立公司与部门、公司与员工、员工与部门、员工和设备间的对应关系，使读者了解如何通过trantor建立模型间对应关系，
通过逻辑流和可编排服务实现员工等模块的增删改逻辑，使读者了解如何定义及实现一个逻辑流、一个可编排服务。

## 1. Trantor 应用结构

通常，工程包含三个模块 `module-api`、`module-impl`、`module-runtime` module-api` 用于申明模型、定义逻辑流、可编排服务等信息，可供其他工程引用，`module-impl` 包含视图、菜单项、逻辑流和可编排服务的实现等信息，
可作为服务提供服务。以下是 demo 的代码组织结构：

trantor-demo-api依赖trantor-api模块
trantor-demo-impl依赖trantor-demo-api模块和trantor-sdk模块
trantor-demo-runtime依赖trantor-runtime模块

```concept
.
├── README.md
├── trantor-demo-api
│   ├── trantor-demo-api.iml
│   ├── pom.xml
│   └── src
│       └── main
│           └── java
│           │    └── io
│           │        └── terminus
│           │            └── trantor
│           │                └── demo
│           │                   ├── dict
│           │                   ├── ext
│           │                   ├── flow
│           │                   │   └── CreateStaffFlow.java
│           │                   ├── func
│           │                   │   └── CreateStaffFunc.java
│           │                   └── model
│           │                        └── Staff.java
│           └── resources
│               ├── trantor.yml
├── trantor-demo-impl
│   ├── trantor-demo-impl.iml
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   └── io
│           │       └── terminus
│           │           └── trantor
│           │               └── demo
│           │                   ├── ext
│           │               	│ 	└── impl
│           │                   ├── flow
│           │               	│  	└── impl
│           │                   │  		 └── CreateStaffFlowImpl.java
│           │                   ├── func
│           │               	│  	└── impl
│           │                   │  		 └── CreateStaffFuncImpl.java
│           └── resources
│               └── trantor
│                   └── resources
│                       └── demo
│                    	       └── view
│                          	 │		  └── Company
│                            │		  └── Department
│                        	 │        └── Euqipment
│                        	 │	      └── Position
│                        	 │	      └── Staff
│                            │  └── demo-menu-item.json
├── trantor-demo-runtime
│   ├── trantor-demo-runtime.iml
│   ├── pom.xml
│   └── src
│       └── main
│           └── java
│           │    └── io
│           │        └── terminus
│           │            └── trantor
│           │                └── demo
│           │                   │  └── Application.java
│           └── resources
│               ├── application.yml
├── demo-parent.iml
└── pom.xml

```

重点关注内容:

- 模块、逻辑流、可编排逻辑等元信息如何定义，见trantor-demo-api模块下: Staff.java、Equipment.java、StaffAndEquipment.java等
- 逻辑流、可编排逻辑等如何实现, 见trantor-demo-impl模块下内容
- 视图、菜单项等如何定义, 见trantor-demo-impl模块下 src/main/resources/trantor/resources 下内容
- 项目、模块配置信息,见 trantoe.yml
- 元信息发布地址配置,见trantor-demo-impl模块下的pom文件，有上报metastore地址和模块key配置

## 2. 如何运行?

### 2.1 安装 Docker

### 2.2 安装 trantor-cli

MacOS 下(确保已安装 HomeBrew)：

```concept
brew tap TerminusHQ/trantor
brew install trantor
```

安装完成后，配置 host:

```concept
127.0.0.1 trantor.terminus.io
```


更详细的安装文档见: [https://yuque.antfin-inc.com/terminus-trantor/cookbook/cli](https://yuque.antfin-inc.com/terminus-trantor/cookbook/cli)

### 2.3 启动 trantor 环境

```concept
$trantor run
```

或指定版本

```concept
$trantor run 0.16
```

### 2.4 上报信息至 metastore

通过 trantor 提供的 maven plugin(见: demo-impl pom.xml), 执行:

```
$mvn compile -Dtrantor.deploy=true
```

上报元信息(@TModel, @TAction 等注解类 & resources 下定义的视图文件)至指定 metastore(pom.xml 配置), 这时也会在 metastore 中创建好对应的
数据库表(即 @TModel 注解的类)

### 2.5 配置应用启动依赖的 trantor 环境

执行: 

```concept
$trantor env
```

拷贝环境变量至应用启动配置中

### 2.6 启动应用程序

### 2.7 创建应用 & 配置菜单

打开之前通过 trantor cli 运行的 `交付控制台`(http://trantor.terminus.io:8099)，进入 `运行态模式->local 环境详情`，添加应用，并为应用
配置菜单, 如图:

![](http://terminus-paas.oss-cn-hangzhou.aliyuncs.com/paas-doc/2020/07/09/86c384be-2b06-4c55-b4e9-cf3aa6af099d.png)

菜单配置如下图: 

![](http://terminus-paas.oss-cn-hangzhou.aliyuncs.com/paas-doc/2020/07/09/a629fa11-29e9-4862-a5b0-f16eb0317227.png)

配置完成后，打开 trantor cli 运行的 `统一工作台`(http://trantor.terminus.io:8098), 可看到之前添加的视图，最终效果如下图:

![](http://terminus-paas.oss-cn-hangzhou.aliyuncs.com/paas-doc/2020/07/09/7ba393b4-9733-4307-818d-939aba688e96.png)

## 3. 其他
1、dice.yml和pipeline.yml是部署在Dice平台必备的配置文件。若不使用Dice部署，则可以忽略。
2、如果有其他使用上的疑问，请查阅 [Trantor 官方文档](https://trantor-interactive-doc.app.terminus.io/doc/marked/introduce)