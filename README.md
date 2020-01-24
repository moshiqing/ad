
1.框架的搭建 包括注册中心的单机版还有集群版   后期替换成consoul作为注册中心来使用 2019-12-15

2.微服务的调用 使用步骤
启动eurake
启动seata的seata-server.bat 注册成功 
启动server中的orders与users
启动users为事务的主要发起方
还需要导入sql文件
访问http://localhost:9100/user/saveUserAndOrder?flag=1
flag说明：flag==0 是orders异常回滚
flag==1是users回滚
其他的数值是正常执行
