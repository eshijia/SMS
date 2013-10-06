1、以管理员身份登录mysql
mysql -u root -p

2、选择mysql数据库
use mysql

3、创建用户并设定密码
create user 'xxx'@'localhost' identified by 'yyy'

4、使操作生效
flush privileges

5、为用户创建数据库
create database sms default character set utf8 collate utf8_general_ci;

6、
为用户赋予操作数据库testdb的所有权限
grant all privileges on sms.* to xxx@localhost identified  by 'yyy'

允许任何地址远程连接
GRANT ALL PRIVILEGES ON *.* TO 'xxx'@'%' IDENTIFIED BY 'yyy' WITH GRANT OPTION;

7、使操作生效
flush privileges

8、用新用户登录
mysql -u test -p

9. 默认字符集导出数据库
mysqldump -u xxq -p --default-character-set=utf8 sms > sms.sql
mysqldump -t dbname -u root -p > dataonly.sql

10. 转换字符集导出数据库
mysqldump -u xxq -p --default-character-set=utf8 --set-charset=latin1 --skip-opt sms>sms.sql

11. 导入数据库
mysql -u xxq -p --default-character-set=utf8  sms < sms.sql

12. mysql重启 
$mysql_dir/bin/mysqladmin -u root -p shutdown
$mysql_dir/bin/safe_mysqld & 

13. 如何查看mysql占用端口，验证mysql是否启动
netstat -aon | findstr "3306"
telnet mysql 3306

14. 
mysql的字符集和校对规则有4个级别的默认设置：服务器级、数据库级、表级和字段级。
show variables like 'character_set_%';
show create table tb_name;
show full columns from tb_name;

如何change服务器级字符集、数据库级、表级和字段级
修改my.ini  
default-character-set = utf8
character_set_server =  utf8

alter database dbname character set utf8 collate utf8_general_ci;
alter table tb_name convert to character set charset_name;
alter table tb_name modify latin1_text_col text character set utf8;
alter table tb_name change old_col_name new_column varchar(10) character set utf8 collate utf8_general_ci; 