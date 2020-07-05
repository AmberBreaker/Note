[toc]

# 0、参考地址

[本文档原型](https://www.jianshu.com/p/a6a6a22e9393)、[更多详细操作](https://blog.csdn.net/qq_41261251/article/details/102817673)、[W3CSchool](https://www.w3cschool.cn/lme/)、[快捷键指南](https://www.cnblogs.com/hongdada/p/9776547.html)

# 1、基本操作

## 1.1、内容目录

* 语法

  ~~~
  [toc]
  ~~~

* 效果

  见顶部。

## 1.2、标题

* 语法

~~~markdown
# 一级标题
## 二级标题
### 三级标题
#### 四级标题
##### 五级标题
###### 六级标题
~~~

* 效果略。

## 1.3、引用

* 语法

  ~~~markdown
  > 引用内容1
  >> 引用内容2
  ~~~

* 说明

  * 键入【>】，输入内容后回车，下一行默认延续上一行的引用格式。

  * 当添加二级引用的时候，可以直接在原一级引用的基础上键入【>】。

  * 若希望取消延续引用，在当前引用空白内容处回车即可。

* 效果

  > 引用内容1
  >
  > > 引用内容2

# 2、代码

## 2.1、单行代码

* 语法

  ~~~markdown
  `String str = new String();`
  ~~~

* 说明

  【`】符号是键盘1左边的那个键，且一定要在英文输入法下输入。

* 效果

  `String str = new String();`

## 2.2、多行代码

* 语法

  ~~~
  ​~~~java
  String str = new String();
  str.split("\\|");
  ​~~~
  ~~~

* 说明

  键入【~~~】回车，typora会自动进入代码编辑模式，右下角可以选择代码语种。

* 效果

  ~~~java
  String str = new String();
  str.split("\\|");
  ~~~

# 3、列表

## 3.1、无序列表

* 语法

  ~~~markdown
  + 无序列表1
  - 无序列表2
  * 无序列表3
  ~~~

* 效果

+ 无序列表1

- 无序列表2

* 无序列表3

## 3.2、多行无序列表

* 语法

  ~~~
  * 多行无序列表1
  TAB * 多行无序列表1.1
  TAB TAB * 多行无序列表1.1.1
  ~~~

* 说明：[TAB]即功能键TAB

* 效果

* 多行无序列表1
  * 多行无序列表1.1
    * 多行无序列表1.1.1

## 3.3、有序列表

* 语法

~~~markdown
1. 有序列表1
2. 有序列表2
3. 有序列表3
~~~

* 说明：1. 后输入一个空格，输入空格后typora会自动生成有序列表模式
* 效果

1. 有序列表1
2. 有序列表2
3. 有序列表3

## 3.4、多行有序列表

* 语法

~~~markdown
1. 多行有序列表1
TAB 1. 多行有序列表1.1
TAB TAB 1. 多行有序列表1.1.1
~~~

* 效果

1. 多行有序列表1
   1. 多行有序列表1.1
      1. 多行有序列表1.1.1

## 3.5、任务列表

* 语法

  ~~~
  [2020-06-18][-] 任务未开始
  [2020-06-19][%] 任务已开始
  [2020-06-20][+] 任务已完成
  [2020-06-21][#] 任务已废弃
  ~~~

* 效果

  [2020-06-18][-] 任务未开始

  [2020-06-19][%] 任务已开始

  [2020-06-20][+] 任务已完成
  
  [2020-06-21][#] 任务已废弃
  
* 说明

  其效果多与HTML展示相关，对于md文档应用意义不大。

# 4、图表

## 4.1、表格

* 语法

  ~~~
  |姓名|性别|年龄|手机号|
  |:---|:--:|:--:|---:|
  |张三|男|18|13112345678|
  |李四|女|19|18812345678|
  |王五|男|20|15912345678|
  ~~~

* 说明

  输入`|列名1|列名2|...|列名n|`回车，即可自动进入表格编辑模式，左上角可以编辑表格模式。

* 效果

  | 姓名 | 性别 | 年龄 |      手机号 |
  | :--- | :--: | :--: | ----------: |
  | 张三 |  男  |  18  | 13112345678 |
  | 李四 |  女  |  19  | 18812345678 |
  | 王五 |  男  |  20  | 15912345678 |

## 4.2、饼图

* 语法

  ~~~
  ​~~~mermaid
  pie
      title 动物数
      "Dogs" : 386
      "Cats" : 85
      "Rats" : 150 
      "Cows" : 150
  ​~~~
  ~~~

* 说明

  此处使用了mermaid脚本，通过多行代码编辑器实现功能。键入`~~~mermaid`并回车，即可编辑mermaid代码。

* 效果

  ~~~mermaid
  pie
      title 动物数
      "Dogs" : 385
      "Cats" : 85
      "Rats" : 150 
      "Cows" : 150
  ~~~

## 4.3、时序图

* 语法

  ~~~
  ​~~~mermaid
  sequenceDiagram
      title: 时序图例子
      Alice->>Alice: 自言自语
      Alice->>John: Hello John, how are you?
      %% over 可用于单独一个角色上，也可以用于相邻两个角色间：
      Note over Alice,John: A typical interaction
      %% loop 后跟循环体说明文字
      loop Healthcheck
          John->>John: Fight against hypochondria
      end
      Note right of John: Rational thoughts!
      John-->>Alice: Great!
  
      John->>Bob: How about you?
      %% 控制焦点：用来表示时序图中对象执行某个操作的一段时间
      %% activate 角色名 表示激活控制焦点
      activate Bob 
      Bob-->>John: Jolly good!
      %% deactivate 角色名 表示控制焦点结束
      deactivate Bob
  
      Alice->>+Bob: Hello John, how are you?
  
      rect rgb(175, 255, 212)
      alt is sick
      Bob-->>Alice: Not so good :(
      else is well
      Bob-->>Alice: Feeling fresh like a daisy
      end
      opt Extra response
      Bob-->>Alice: Thanks for asking
      end
      end
      loop communicating
          Alice->>+John: asking some questions
          John-->>-Alice: answer 
      end
      par Alice to John
        Alice->>John: Bye
      and Alice to Bob
        Alice->>Bob: Bye
      end
      Alice-xJohn: 这是一个异步调用
      Alice--xBob: 这是一个异步调用
  ​~~~
  ~~~

* 说明

  此处使用了mermaid脚本，通过多行代码编辑器实现功能。键入`~~~mermaid`并回车，即可编辑mermaid代码。

* 效果

  ~~~mermaid
  sequenceDiagram
      title: 时序图例子
      Alice->>Alice: 自言自语
      Alice->>John: Hello John, how are you?
      %% over 可用于单独一个角色上，也可以用于相邻两个角色间：
      Note over Alice,John: A typical interaction
      %% loop 后跟循环体说明文字
      loop Healthcheck
          John->>John: Fight against hypochondria
      end
      Note right of John: Rational thoughts!
      John-->>Alice: Great!
  
      John->>Bob: How about you?
      %% 控制焦点：用来表示时序图中对象执行某个操作的一段时间
      %% activate 角色名 表示激活控制焦点
      activate Bob 
      Bob-->>John: Jolly good!
      %% deactivate 角色名 表示控制焦点结束
      deactivate Bob
  
      Alice->>+Bob: Hello John, how are you?
  
      rect rgb(175, 255, 212)
      alt is sick
      Bob-->>Alice: Not so good :(
      else is well
      Bob-->>Alice: Feeling fresh like a daisy
      end
      opt Extra response
      Bob-->>Alice: Thanks for asking
      end
      end
      loop communicating
          Alice->>+John: asking some questions
          John-->>-Alice: answer 
      end
      par Alice to John
        Alice->>John: Bye
      and Alice to Bob
        Alice->>Bob: Bye
      end
      Alice-xJohn: 这是一个异步调用
      Alice--xBob: 这是一个异步调用
  ~~~

## 4.4、流程图1

* 语法

  ~~~
  ​~~~mermaid
  graph LR
  %% 这是注释，流程图中用到的各种图形画法、连线
    id1((start))-->A[方角矩形]
      A -.虚线.-> B(圆角矩形)
      A --> F[\平行四边形\]--> G[/平行四边形/]-->H[/梯形\]-->I[\梯形/]
      A ---|没箭头的连线|i21(圆角矩形)
      B --文案--> C{菱形}
      C -->|One| D{{Result one}}
      C -->|Two| E>Result two]
  ​~~~
  ~~~

* 说明

  此处使用了mermaid脚本，通过多行代码编辑器实现功能。键入`~~~mermaid`并回车，即可编辑mermaid代码。

* 效果

  ~~~mermaid
  %% LR代表左右结构，TB代表上下结构
  graph LR
  %% 流程图中用到的各种图形画法、连线
    id1((start))-->A[方角矩形]
      A -.虚线.-> B(圆角矩形)
      A --> F[\平行四边形\]--> G[/平行四边形/]-->H[/梯形\]-->I[\梯形/]
      A ---|没箭头的连线|i21(圆角矩形)
      B --文案--> C{菱形}
      C -->|One| D{{Result one}}
      C -->|Two| E>Result two]
  ~~~

## 4.5、流程图2

* 语法

  ~~~
  ​~~~mermaid
  graph TB
  %% 子流程
      c1-->a2
      subgraph one
      a1-->a2
      end
      subgraph two
      b1-->b2
      end
      subgraph three
      c1-->c2
      end
  ​~~~
  ~~~

* 说明

  此处使用了mermaid脚本，通过多行代码编辑器实现功能。键入`~~~mermaid`并回车，即可编辑mermaid代码。

* 效果

  ~~~mermaid
  graph TB
  %% 子流程
      c1-->a2
      subgraph one
      a1-->a2
      end
      subgraph two
      b1-->b2
      end
      subgraph three
      c1-->c2
      end
  ~~~

  

## 4.6、流程图3

* 语法

  ~~~
  ​~~~mermaid
  graph TB
  %% 快手发布视频流程
    B(点击拍摄) --> C{是否允许皮皮拍摄视频}
    C-->|N|D[提示用户允许皮皮拍摄]
    C-->|Y|E[开始拍摄]
    E-->F[相册]-->G[自行编辑]-->H[发布]
    E-->I[选择滤镜和音乐]-->J[按住拍摄]-->H
    E-->J
    H-->|N|K[返回首页]
    H-->|Y|L[所有人可见]
  ​~~~
  ~~~

* 说明

  此处使用了mermaid脚本，通过多行代码编辑器实现功能。键入`~~~mermaid`并回车，即可编辑mermaid代码。

* 效果

  ~~~mermaid
  graph TB
  %% 皮皮发布视频流程
    B(点击拍摄) --> C{是否允许皮皮拍摄视频}
    C-->|N|D[提示用户允许皮皮拍摄]
    C-->|Y|E[开始拍摄]
    E-->F[相册]-->G[自行编辑]-->H[发布]
    E-->I[选择滤镜和音乐]-->J[按住拍摄]-->H
    E-->J
    H-->|N|K[返回首页]
    H-->|Y|L[所有人可见]
  ~~~

## 4.7、UML类图

* 语法

  ~~~
  ​~~~mermaid
  classDiagram
  class Duck{
            -String beakColor
            - double weight
            +swim()
            +quack()
            #count()
            +getPrice(count) double
            +someAbstractMethod() *
            -someStaticMethod() $
        }
  class Shape{
  %% This whole line is a comment classDiagram class Shape <<interface>>
      <<interface>>
      noOfVertices
      draw()
  }
  class Color{
      <<enumeration>>
      RED
      BLUE
      GREEN
      WHITE
      BLACK
  }
  class Relation{
      <<<<abstract>>>>
  }
  ​~~~
  ~~~

* 说明

  此处使用了mermaid脚本，通过多行代码编辑器实现功能。键入`~~~mermaid`并回车，即可编辑mermaid代码。

* 效果

  ~~~mermaid
  classDiagram
  class Duck{
            -String beakColor
            - double weight
            +swim()
            +quack()
            #count()
            +getPrice(count) double
            +someAbstractMethod() *
            -someStaticMethod() $
        }
  class Shape{
  %% This whole line is a comment classDiagram class Shape <<interface>>
      <<interface>>
      noOfVertices
      draw()
  }
  class Color{
      <<enumeration>>
      RED
      BLUE
      GREEN
      WHITE
      BLACK
  }
  class Relation{
      <<<<abstract>>>>
  }
  ~~~

# 5、链接

## 5.1、图片

### 5.1.1、本地图片

* 语法

~~~markdown
![图片说明](本地图片路径)
~~~

* 说明

  键入`![图片说明]()`后，typora会提供图片定位的功能。

* 效果

  ![图片定位功能](/Users/blairscott/Pictures/demo/typoraDemo1.jpg)

### 5.1.2、网络图片

* 语法

  ~~~markdown
  ![typora.jpg](网络图片路径)
  ~~~

* 效果

  ![typora.jpg](https://upload-images.jianshu.io/upload_images/1538862-d91e815790b81e4a.jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

## 5.2、超链接

### 5.2.1、行内式链接

* 语法

  ~~~
  [百度][https://www.baidu.com/]
  ~~~

* 效果

  [百度][https://www.baidu.com/]

### 5.2.2、参考式链接

* 语法

  ~~~
  [CSDN网址]:https://www.csdn.net/
  ~~~

* 效果

  [CSDN网址]:https://www.csdn.net/
  [-]: 

### 5.2.3、自动链接

* 语法

  ~~~
  <https://github.com/>
  ~~~

* 效果

  <https://github.com/>

# 6、其他

## 6.1、字体

### 6.1.1、斜体

+ 代码

  ~~~
  *斜体*
  _斜体_
  ~~~

+ 效果

  *斜体*

  _斜体_

### 6.1.2、加粗

* 代码

  ~~~
  **加粗**
  __加粗__
  ~~~

* 效果

  **加粗**

  __加粗__

### 6.1.3、下划线

* 代码

  ~~~
  <u>下划线</u>
  ~~~

* 效果

  <u>下划线</u>

### 6.1.4、删除线

* 代码

  ~~~
  ~~删除线~~
  ~~~

* 效果

  ~~删除线~~

## 6.2、分割线

* 代码

  ~~~
  ***
  --- 
  ___ (下划线)
  ~~~

* 效果

  ***

  ---

  ___

  

## 6.3、标注

### 6.3.1、注脚

* 代码

  ~~~
  这是一个脚注[^1]
  [^1]:这是脚注解释
  ~~~

* 效果

  这是一个脚注[^1]

  [^1]:这是脚注解释

### 6.3.2、数学表达式

* 代码

~~~
$3^2=9$
$3^{(3-1)}=9$
$H_2SO_4\\H_{2SO_4}$
~~~

* 说明

  在偏好设置中设置行内LaTeX公式有效

* 代码说明

  | 符号 | 说明                                          |
  | :--: | --------------------------------------------- |
  |  $   | LaTeX公式起止标识。                           |
  |  {}  | 块内容。                                      |
  |  ^   | 上标，^下一个字符或下一个块内容将被置为上标。 |
  |  _   | 下标，_下一个字符或下一个块内容将被置为下标。 |
  | \\\\ | 公式内换行                                    |

  

* 效果

  $3 ^ 2 = 9$

  $3^{(3-1)}=9$

  $H_2SO_4\\H_{2SO_4}$

## 6.4、符号

|   语法    |   说明   | 效果  |
| :-------: | :------: | :---: |
|   \\\\    |  反斜杠  |  \\   |
|   \\\`    |  反引号  |  \`   |
|   \\\*    |   星号   |  \*   |
|   \\\_    |   底线   |  \_   |
| \\{ \\\}  |  花括号  | \{ \} |
| \\\[ \\\] |  方括号  | \[ \] |
| \\\( \\\) |   括弧   | \( \) |
|   \\\#    |  井字号  |  \#   |
|   \\\+    |   加号   |  \+   |
|   \\\-    |   减号   |  \-   |
|   \\\.    | 英语句点 |  \.   |
|   \\\!    |  惊叹号  |  \!   |

## 6.5、常用特殊字符

* 语法结尾加 “ ; ” 生效

|  语法   |    说明    |   效果   |
| :-----: | :--------: | :------: |
|  &copy  |    版权    |  &copy;  |
|  &reg   |  注册商标  |  &reg;   |
| &trade  |    商标    | &trade;  |
|  &nbsp  |    空格    |  &nbsp;  |
|  &amp   |    与号    |  &amp;   |
|  &quot  |   双引号   |  &quot;  |
|  &apos  |   单引号   |  &apos;  |
|   &lt   |   小于号   |   &lt;   |
|   &gt   |   大于号   |   &gt;   |
|   &ne   |   不等号   |   &ne;   |
|   &le   | 小于等于号 |   &le;   |
|   &ge   | 大于等于号 |   &ge;   |
|  &cent  |     分     |  &cent;  |
| &pound  |     磅     | &pound;  |
|  &euro  |    欧元    |  &euro;  |
|  &yen   |     元     |  &yen;   |
|  &sect  |     节     |  &sect;  |
| &times  |    乘号    | &times;  |
| &divide |    除号    | &divide; |
| &plusmn |   正负号   | &plusmn; |

* [HTML特殊字符编码对照表](https://link.jianshu.com/?t=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DvUfE2amYdxd0-eyzqayeMFOVKkDRJrtkb1dV1MxyoCEke31DbXM_rb8fy1qDh1o0tqcq9u_fKQG1RRqPKTB_YK%26wd%3D%26eqid%3D8a6c88e90000a679000000035aa6444d)