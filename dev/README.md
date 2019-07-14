##### 1.后台启动
``` bash 
docker-compose up -d 
```
##### 2.重新构建并重启单个服务
``` bash 
docker-compose up -d --build nexus3
```
##### 3.启动实例
``` bash 
docker-compose start
```
##### 4.停止实例
``` bash 
docker-compose stop
```
##### 5.删除实例、虚拟网络等 但数据卷不会删除
``` bash 
docker-compose down
```
##### 备份
``` bash 
# 备份脚本
echo "cd /var/lib/docker/volumes && cp mysql-data -r bak_mysql-data_$(date +%Y-%m-%d)" > /opt/mysqlbak.sh
# 递归删除/var/lib/docker/volumes下，文件名是bak_开头，修改时间为15天之前
echo 'find /var/lib/docker/volumes -type f -ctime +15 -name "bak_*" | xargs rm -rf' > /opt/cleanMysqlbak.sh
# 执行权限
chmod a+x /opt/*.sh
# 配置到crontab
crontab -e

0 0 * * *  /opt/mysqlbak.sh
0 0 * * *  /opt/cleanMysqlbak.sh
```