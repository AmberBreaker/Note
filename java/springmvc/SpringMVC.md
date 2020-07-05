[toc]

# 1、B/S简介

## 1.1、什么是B/S

> B/S	浏览器/服务器。

## 1.2、B/S的通信方式

* Socket
* Web容器（如Tomcat）

>Web容器封装了Socket，实现了浏览器和服务器之间的通信。程序员可以不用自己编写Socket。

## 1.3、Tomcat

* 性质

> 1、Tomcat是一个web容器，也是Servlet容器。
>
> 2、Tomcat只会调用Servlet接口的实现类代码。

* Servlet

> Servlet接口是JavaEE推出的web编程服务器程序的标准接口。
>
> Servlet的实例，是由Tomcat创建的，由程序员来编写的代码。

* Servlet对象的创建

> Tomcat中有一个部署描述符【web.xml】。web.xml描述了Servlet的实现类是哪一个，对于Servlet可以指定创建实例的时机。
>
> 默认Servlet实例是第一次被访问的时候创建的，只会存在一个实例。可以通过设置完成Tomcat启动的时候就创建一个Servlet实例。

* Servlet接口的生命周期方法

  * init
  * service（处理B/S架构的请求）
  * destory

* http请求解析

  ~~~http
  http://195.203.10.190:8080/springmvc/queryUser
  ~~~

  | 参数           | 数名                                               |
  | -------------- | -------------------------------------------------- |
  | http           | 协议                                               |
  | 195.203.10.190 | ip地址，用于定位服务器中的某台机器                 |
  | 8080           | port，用于定位远程机器中的某个应用，如Tomcat应用。 |
  | springmvc      | 定位Tomcat中的webapp                               |
  | queryUser      | 定位webapp中的某个程序代码                         |

#5-C4-P2 0000