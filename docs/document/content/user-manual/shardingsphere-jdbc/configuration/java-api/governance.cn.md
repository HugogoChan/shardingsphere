+++
title = "分布式治理"
weight = 5
+++

## 配置项说明

### 治理

*配置入口*

类名称：org.apache.shardingsphere.governance.repository.api.config.GovernanceConfiguration

可配置属性：

| *名称*                       | *数据类型*                    | *说明*                                                 |
| --------------------------- | --------------------------- | ------------------------------------------------------ |
| name                        | String                      | 注册中心实例名称                                          |
| registryCenterConfiguration | RegistryCenterConfiguration | 注册中心实例的配置                                         |
| overwrite                   | boolean                     | 本地配置是否覆盖配置中心配置，如果可覆盖，每次启动都以本地配置为准 |

注册中心的类型可以为Zookeeper或etcd。

*治理实例配置*

类名称：org.apache.shardingsphere.governance.repository.api.config.ClusterPersistRepositoryConfiguration

可配置属性：

| *名称*         | *数据类型* | *说明*                                                                    |
| ------------- | ---------- | ----------------------------------------------------------------------- |
| type          | String     | 治理实例类型，如：Zookeeper, etcd                                          |
| serverLists   | String     | 治理服务列表，包括 IP 地址和端口号，多个地址用逗号分隔，如: host1:2181,host2:2181 |
| props         | Properties | 配置本实例需要的其他参数，例如 ZooKeeper 的连接参数等                           |

ZooKeeper 属性配置

| *名称*                            | *数据类型* | *说明*                | *默认值* |
| -------------------------------- | --------- | -------------------- | ------- |
| digest (?)                       | String    | 连接注册中心的权限令牌   | 无需验证  |
| operationTimeoutMilliseconds (?) | int       | 操作超时的毫秒数        | 500 毫秒 |
| maxRetries (?)                   | int       | 连接失败后的最大重试次数  | 3 次    |
| retryIntervalMilliseconds (?)    | int       | 重试间隔毫秒数          | 500 毫秒 |
| timeToLiveSeconds (?)            | int       | 临时节点存活秒数        | 60 秒    |

Etcd 属性配置

| *名称*                 | *数据类型* | *说明*     | *默认值* |
| --------------------- | --------- | ---------- | ------ |
| timeToLiveSeconds (?) | long      | 数据存活秒数 | 30秒    |
