# Trantor Demo

此demo主要通过员工管理系统中简单的业务逻辑带领读者快速熟悉和上手trantor应用。</br>
通过建立公司与部门、公司与员工、员工与部门、员工和设备间的对应关系，使读者了解如何通过trantor建立模型间对应关系.</br>
通过逻辑流和可编排服务实现员工等模块的增删改逻辑，使读者了解如何定义及实现一个逻辑流、一个可编排服务。</br>

## 1. Trantor 应用结构

通常，工程包含三个模块 `module-api`、`module-impl`、`module-runtime` module-api` 用于申明模型、定义逻辑流、可编排服务等信息，可供其他工程引用，`module-impl` 包含视图、菜单项、逻辑流和可编排服务的实现等信息，
可作为服务提供服务。以下是 demo 的代码组织结构：

- trantor-demo-api依赖trantor-api模块
- trantor-demo-impl依赖trantor-demo-api模块和trantor-sdk模块
- trantor-demo-runtime依赖trantor-runtime模块

```concept
.
├── README.md
├── pom.xml
├── settings.xml
├── trantor-demo-api
│   ├── pom.xml
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── io
│   │   │   │       └── terminus
│   │   │   │           └── trantor
│   │   │   │               └── demo
│   │   │   │                   ├── dict
│   │   │   │                   │   ├── EquipmentType.java
│   │   │   │                   ├── ext
│   │   │   │                   │   └── StaffNumberRuleExt.java
│   │   │   │                   ├── flow
│   │   │   │                   │   ├── CreateStaffFlow.java
│   │   │   │                   ├── func
│   │   │   │                   │   ├── CreateStaffFunc.java
│   │   │   │                   └── model
│   │   │   │                       ├── Staff.java
│   │   │   └── resources
│   │   │       └── trantor.yml
│   └── trantor-demo-api.iml
├── trantor-demo-impl
│   ├── pom.xml
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── io
│   │   │   │       └── terminus
│   │   │   │           └── trantor
│   │   │   │               └── demo
│   │   │   │                   ├── ext
│   │   │   │                   │   └── impl
│   │   │   │                   │       └── StaffNumberRuleExtImpl.java
│   │   │   │                   ├── flow
│   │   │   │                   │   └── impl
│   │   │   │                   │       ├── CreateStaffFlowImpl.java
│   │   │   │                   └── func
│   │   │   │                       └── impl
│   │   │   │                           ├── CreateStaffFuncImpl.java
│   │   │   └── resources
│   │   │       └── trantor
│   │   │           └── resources
│   │   │               └── demo
│   │   │                   ├── demo-menu-item.json
│   │   │                   └── view
│   │   │                       ├── Company
│   │   │                       │   └── CompanyList.view.xml
│   │   │                       ├── Department
│   │   │                       │   └── DepartmentList.view.xml
│   │   │                       ├── Equipment
│   │   │                       │   └── EquipmentList.view.xml
│   │   │                       ├── Position
│   │   │                       │   └── PositionList.view.xml
│   │   │                       └── Staff
│   │   │                           └── StaffList.view.xml
│   └── trantor-demo-impl.iml
├── trantor-demo-runtime
│   ├── pom.xml
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── io
│   │   │   │       └── terminus
│   │   │   │           └── trantor
│   │   │   │               └── demo
│   │   │   │                   └── Application.java
│   │   │   └── resources
│   │   │       └── application.yml
│   └── trantor-demo-runtime.iml
└── trantor-demo.iml

```

重点关注内容:

- 模块、逻辑流、可编排逻辑等元信息如何定义，见trantor-demo-api模块下: Staff.java、Equipment.java、StaffAndEquipment.java等
- 逻辑流、可编排逻辑等如何实现, 见trantor-demo-impl模块下内容
- 视图、菜单项等如何定义, 见trantor-demo-impl模块下 src/main/resources/trantor/resources 下内容
- 项目、模块配置信息,见 trantoe.yml
- 元信息发布地址配置,见trantor-demo-impl模块下的pom文件，有上报metastore地址和模块key配置
