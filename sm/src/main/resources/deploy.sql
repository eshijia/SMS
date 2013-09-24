1、以管理员身份登录mysql
mysql -u root -p

2、选择mysql数据库
use mysql

3、创建用户并设定密码
create user 'xxq'@'localhost' identified by 'xxq'

4、使操作生效
flush privileges

5、为用户创建数据库
create database sms default character set utf8 collate utf8_general_ci;

6、为用户赋予操作数据库testdb的所有权限
grant all privileges on sms.* to xxq@localhost identified  by 'xxq'

7、使操作生效
flush privileges

8、用新用户登录
mysql -u test -p

9. 导出数据库
mysqldump -u xxq -p --default-character-set=utf8 sms > sms.sql

-- 转换字符集
mysqldump -u xxq -p --default-character-set=utf8 --set-charset=latin1 --skip-opt sms>sms.sql

10.  
show variables like 'character_set_%';
set character_set_server=utf8;
GRANT ALL PRIVILEGES ON *.* TO 'xxq'@'*' IDENTIFIED BY 'xxq' WITH GRANT OPTION;
GRANT ALL PRIVILEGES ON *.* TO 'xxq'@'%' IDENTIFIED BY 'xxq' WITH GRANT OPTION;
FLUSH   PRIVILEGES;

10. 导入数据库
mysql -u xxq -p --default-character-set=utf8  sms < sms.sql

11. mysql重启 
$mysql_dir/bin/mysqladmin -u root -p shutdown
$mysql_dir/bin/safe_mysqld & 

12. 如何查看mysql占用端口
netstat -aon | findstr "3306"
telnet mysql 3306


13. 修改表字段的字符集
ALTER TABLE tb_assistant CHANGE ast_name ast_name VARCHAR(10) CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE tb_info CHANGE if_info if_info VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE tb_score_record CHANGE sr_comment sr_comment VARCHAR(200) CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE tb_score_type CHANGE st_name st_name VARCHAR(40) CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE tb_student CHANGE stu_name stu_name VARCHAR(10) CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE tb_student CHANGE stu_sex stu_sex VARCHAR(4) CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE tb_student CHANGE stu_major stu_major VARCHAR(20) CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE tb_user CHANGE u_username u_username VARCHAR(20) CHARACTER SET utf8 COLLATE utf8_general_ci;
ALTER TABLE tb_user CHANGE u_password u_password VARCHAR(20) CHARACTER SET utf8 COLLATE utf8_general_ci;


mysqldump -t sms -u root -p > dataonly.sql

