[toc]

# 1、简介

## 1.1、必知历史

* [2008年1月] MySQL被Sun公司收购，MySQL进入Sun时代，Sun公司对其进行大量的推广、优化、Bug修复等工作。
* [2009年4月]Sun公司被Oracle公司收购，从此MySQL进入Oracle时代。（其第三方引擎早在2005年被收购）
* [2010年12月]MySQL5.5 发布，在该版本中，InnoDB存储引擎成为当前MySQL的默认存储引擎

## 1.2、SQL语言分类

* 数据定义语言 - [DDL]

~~~sql
create
drop
alter
~~~

* 数据操作语言 - [DML]

~~~sql
insert
delete
update
~~~

* 数据控制语言 - [DCL]

~~~sql
grant
~~~

* 数据查询语言 - [DQL]

~~~sql
select
from
where
...
~~~



# 2、MySQL在Linux下的安装

## 2.1、安装背景

* 操作系统：CentOS 7
* MySQL版本：MySQL5.6

## 2.2、查看当前系统MySQL环境

~~~sh
rpm -qa | grep mysql
yum repolist all | grep mysql
~~~

## 2.3、卸载MySQL

若当前系统存在旧的Mysql，则可以先对其进行卸载

~~~sh
# 卸载mysql
yum remove -y mysql mysql-libs mysql-common
# 删除mysql下的数据文件
rm -rf /var/lib/mysql
# 删除mysql配置文件
rm /etc/my.cnf
# 删除组件
yum remove -y mysql-community-release-el6-5.noarch
~~~

## 2.4、安装MySQL

~~~sh
# 下载rpm文件
wget http://repo.mysql.com/mysql-community-release-el6-5.noarch.rpm
# 执行rpm源文件
rpm -ivh mysql-community-release-el6-5.noarch.rpm
# 执行安装文件
yum install mysql-community-server
~~~

## 2.5、启动MySQL

~~~sh
# 启动mysql
systemctl start mysqld
# 重启mysql
systemctl restart mysqld
~~~

## 2.6、为root用户设置密码

~~~sh
# 原来没有密码，为root用户添加密码
/usr/bin/mysqladmin -u root password 'root'
# 原来存在密码，为root用户修改密码
/usr/bin/mysqladmin -u root -p '123' password 'root'
~~~

## 2.7、登陆MySQL

* 指令

~~~sh
# root没有密码时
mysql
# root存在密码时
mysql -uroot -proot
~~~

* 说明

~~~txt
-u: 指定数据库用户名
-p: 指定数据库密码，记住-u和登录密码之间没有空格
~~~

## 2.8、配置MySQL

* 指令

~~~sh
vim /etc/my.cnf
~~~

* 修改内容如下

~~~properties
[mysqld]
# MySQL设置大小写不敏感：默认：区分表名的大小写，不区分列名的大小写
# 0:大小写敏感; 1:大小写不敏感
lower_case_table_names=1
# 默认字符集
character-set-server=utf8
~~~

* 说明

~~~txt
修改配置文件需要重启mysql生效
~~~

## 2.9、远程授权

* 说明

~~~txt
可以让客户端工具，如Navicat，链接Mysql。
~~~

* 指令步骤

~~~sh
## 关闭防火墙
# 默认
systemctl stop firewalld
# 设置开启不启动
systemctl disable firewalld.service

## 登陆mysql
mysql -uroot -proot
~~~

~~~sql
-- 授权
grant 权限 on 数据库对象 to 用户
-- 刷新权限
FLUSH PRIVILEGES;
~~~

* 授权举例并说明

~~~sql
-- 举例: 授予root用户对所有数据库对象的全部操作权限
GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'root' WITH GRANT OPTION;

ALL PRIVILEGES 							: 表示授予所有的权限，此处可以指定具体的授权权限。
*.*													: 表示所有库中的所有表
'myuser'@'%' 									: myuser是数据库的用户名，%表示是任意ip地址，可以指定具体ip地址。
IDENTIFIED BY 'mypassword' 	: mypassword是数据库的密码。
~~~

* 查看是否成功授权

~~~sql
show grants for root;
~~~

![授权成功效果图](/Users/blairscott/Documents/My Notes/database/RMDB/Mysql/Mysql应用篇-md/img-grant-result.png)



# 3、MySQL基础语法

## 3.1、DDL

### 3.1.1、数据库操作

* 创建数据库

~~~mysql
create database 数据库名 character set 字符集;
-- 步骤2.8中配置MySql中若设置了默认编码集，则可以忽略为数据库设置编码集
create database 数据库名;
~~~

* 查看数据库

~~~mysql
-- 查看数据库服务器中的所有数据库
show databases;
-- 查看某个数据库定义的信息
show create database 数据库名;
~~~

* 删除数据库（慎用！）

~~~mysql
drop database 数据库名;
~~~

* 切换并查看当前数据库

~~~mysql
-- 切换数据库
use 数据库名;
-- 查看数据库
select database();
~~~

### 3.1.2、表操作

* 创建表

~~~mysql
create table 表名 (
	字段名1 类型(长度) 约束,
  字段名2 类型(长度) 约束,
  ...
  字段名n 类型(长度) 约束
);

-- 单表约束
primary key: 主键约束，其约束效果同：唯一约束 + 非空约束
unique: 唯一约束
not null: 非空约束
~~~

* 查看表

~~~mysql
-- 查看所有表
show tables;
-- 查看表结构
desc 表名;
~~~

* 删除表

~~~mysql
drop table 表名;
~~~

* 修改表

~~~mysql
-- 表添加列
alter table 表名 add 列名 类型(长度) 约束;
-- 表修改列
alter table 表名 modify 列名 类型(长度) 约束;
-- 表重命名列
alter table 表名 change 旧列名 新列名 类型(长度) 约束;
-- 表删除列
alter table 表名 drop 列名;
-- 表修改表名
alter table 旧表名 to 新表名;
-- 表修改字符集
alter table 表名 character set 字符集;
~~~



## 3.2、DML

### 3.2.1、插入语句（insert）

~~~mysql
-- 按表中指定列顺序插入指定值
insert into 表 (列名1,列名2,列名3...) values (值1,值2,值3...);
-- 按表字段顺序为表所有字段插入值
insert into 表 values (值1,值2,值3...);
-- 将数据表指定中的列记录插入到目标表，其列数量以及没列对应类型、长度或约束需符合插入要求
insert into 目标表 (列名1,列名2,列名3...) values select 列名1,列名2,列名3... from 数据表;
insert into 目标表 values select 列名1,列名2,列名3... from 数据表;
~~~

### 3.2.2、修改语句（update）

~~~mysql
update 表名 set 字段名1 = 值1, 字段名2 = 值2 ... [whereClause];
~~~

### 3.2.3、删除语句（delete/truncate）

~~~mysql
-- 一条一条删除，不清空 auto_increment 记录数
delete from 表名 [whereClause];
-- 直接将表删除，重新建表，auto_increment 置零，重新开始
truncate table 表名;
~~~



## 3.3、DQL

### 3.3.1、DQL完整语法顺序

~~~mysql
SELECT DISTINCT < select_list >
FROM < left_table > < join_type > JOIN < right_table > ON < join_condition >
WHERE< where_condition >
GROUP BY < group_by_list >
HAVING < having_condition >
ORDER BY < order_by_condition >
LIMIT < limit_number >
~~~

### 3.3.2、SQL的解析顺序

~~~mysql
-- 行过滤
FROM <left_table>
ON <join_condition>
<join_type> JOIN <right_table> 			-- 第二步和第三步会循环执行
WHERE <where_condition> 						-- 第四步会循环执行，多个条件的执行顺序是从左往右的
GROUP BY <group_by_list>
HAVING <having_condition>
-- 列过滤
SELECT 															-- 分组之后才会执行SELECT
DISTINCT <select_list>
-- 排序
ORDER BY <order_by_condition>
-- MySQL附加, 前9步都是SQL92标准语法。limit是MySQL的独有语法
LIMIT <limit_number>
~~~

### 3.3.3、多表连接

~~~mysql
-- 交叉连接
select * from product cross join category;
select * from product, category;
-- 内连接
select * from product m inner join category g where m.cid=g.id;
select * from product m inner join category g on m.cid=g.cid;
select * from product m, category g where m.cid=g.id;
-- 外连接
	-- 左外连接
	select * from product m left join category g on m.cid=g.id;
	select * from product m left outer join category g on m.cid=g.id;
	-- 右外连接
	select * from product m right join category g on m.cid=g.id;
	select * from product m right outer join category g on m.cid=g.id;
~~~





# *、MySQL重要知识点

* SQL语句条件执行顺序

~~~
MySQL: 从左往右
Oracle: 从右往左
~~~

* MySQL四大分层

~~~
客户端
SQL层（处理SQL）
可插拔式存储引擎层
文件系统
~~~

