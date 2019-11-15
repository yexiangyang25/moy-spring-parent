##### 安装MQ环境
``` bash 
# 启动镜像
docker run --name rabbitmq  -p 15672:15672 -p 5672:5672 -d rabbitmq:latest
# 进去镜像实例中安装管理界面
docker exec -it rabbitmq bash
# 镜像实例中输入命令安装管理台
rabbitmq-plugins enable rabbitmq_management
```
##### 管理界面
* [rabbitmq management](http://localhost:15672)

* 用户名/密码: guest/guest
