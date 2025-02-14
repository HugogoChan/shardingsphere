+++
title = "Governance"
weight = 5
+++

## Configuration Item Explanation

### Management

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
       xmlns:governance="http://shardingsphere.apache.org/schema/shardingsphere/governance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://shardingsphere.apache.org/schema/shardingsphere/governance
                           http://shardingsphere.apache.org/schema/shardingsphere/governance/governance.xsd
">
    <governance:reg-center id="regCenter" type="ZooKeeper" namespace="regCenter" server-lists="localhost:2181" />
    <governance:data-source id="shardingDatabasesTablesDataSource" data-source-names="demo_ds_0, demo_ds_1" reg-center-ref="regCenter" config-center-ref="distMetaDataPersistService" rule-refs="shardingRule" overwrite="true" schema-name="sharding_db" />
</beans>
```

Namespace: [http://shardingsphere.apache.org/schema/shardingsphere/governance/governance-5.0.0.xsd](http://shardingsphere.apache.org/schema/shardingsphere/governance/governance-5.0.0.xsd)

<governance:reg-center />

| *Name*        | *Type*     | *Description*                                                                                             |
| ------------- | ---------- | --------------------------------------------------------------------------------------------------------- |
| id            | Attribute  | Registry center name                                                                                      |
| schema-name   | Attribute  | JDBC data source alias, this parameter can help the configuration shared between JDBC driver and Proxy    |
| type          | Attribute  | Registry center type. Example: ZooKeeper, etcd                                                            |
| namespace     | Attribute  | Registry center namespace                                                                                 |
| server-lists  | Attribute  | The list of servers that connect to registry center, including IP and port number; use commas to separate |
| props (?)     | Attribute  | Properties for center instance config, such as options of zookeeper                                       |
