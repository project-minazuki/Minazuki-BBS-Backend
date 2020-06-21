# Minazuki-BBS-Backend
软件学院 2020 工程实训：BBS 系统后端部分

# 后台开发文档

## 拉取项目

### 从远端clone项目到本地

```bash
git clone git@github.com:project-minazuki/Minazuki-BBS-Backend.git
```

### 修改application.yml

这里因为协作开发，每个人的本地数据库配置等都可能不同，所以application.yml无法通用

```yaml
#################################### common config : ####################################
spring:
  application:
    name: bbs-backend
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/dev_bbs
    username: #your username#
    password: #your password#

# 应用服务web访问端口
server:
  port: 8080

```

所以此处应修改为你自己的数据库用户名和密码