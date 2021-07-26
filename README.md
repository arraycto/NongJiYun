## 农技耘微服务API开发
* 采用SpringCloud、SpringCloudAlibaba全家桶
* 集成Sentinel从流量控制、熔断降级、系统负载等多个维度保护服务的稳定性。
* 注册中心、配置中心选型Nacos，为工程瘦身的同时加强各模块之间的联动。
* 采用OAuth2，实现了多终端认证系统，可控制子系统的token权限互相隔离。
* 借鉴Security，封装了Secure模块，采用JWT做Token认证，可拓展集成Redis等细颗粒度控制方案。
* 项目分包明确，规范微服务的开发模式，使包与包之间的分工清晰。

## 工程结构
``` 
NongJiYun
├── njy-auth -- 授权服务提供
├── njy-common -- 常用工具封装包
├── njy-gateway -- Spring Cloud 网关
├── njy-ops -- 运维中心
├    ├── njy-admin -- spring-cloud后台管理
├    ├── njy-resource -- 资源管理
├── njy-service -- 业务模块
├    ├── njy-log -- 日志模块 
├    ├── njy-system -- 系统模块 
├    └── njy-user -- 用户模块 
├    ├── njy-community -- 交流模块 
├── njy-service-api -- 业务模块api封装
├    ├── njy-log-api -- 日志api 
├    ├── njy-system-api -- 系统api 
├    ├── njy-user-api -- 用户api 
└──  └── njy-community-api -- 交流api 
```
