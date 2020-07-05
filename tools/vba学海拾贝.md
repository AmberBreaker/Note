[toc]

# 1、方法

## 1.1、主方法

* 代码

  ~~~vb
  Sub test()
    Msgbox("Hello World")
  End Sub
  ~~~

* 说明

  | 行数 | 代码                  | 说明                                       |
  | :--: | --------------------- | ------------------------------------------ |
  |  1   | Sub test()            | 主方法开始标识，定义了一个名为test的方法。 |
  |  2   | Msgbox("Hello world") | 主方法体，位于方法开始与结束之间的内容。   |
  |  3   | End Sub               | 主方法结束标识。                           |

## 1.2、普通方法

* 代码

  ~~~vb
  Public Function ArrayLength(ByVal ary) As Integer
  		ArrayLength = UBound(arr) - LBound(arr) + 1
  End Function
  ~~~

* 说明

  | 行数 | 代码                                                     | 说明                                  |
  | :--: | -------------------------------------------------------- | ------------------------------------- |
  |  1   | <font color="#6C1A83">Public Function</font> ArrayLength | 定义了一个名为ArrayLength的普通方法。 |
  |  1   | (<font color="#6C1A83">ByVal</font> ary)                 | 方法指定参数，参数类型为弱类型。      |
  |  1   | <font color="#6C1A83">As Integer</font>                  | 定义方法返回值类型                    |
  |  2   | ArrayLength = UBound(arr) - LBound(arr) + 1              | 方法体                                |
  |  3   | <font color="#6C1A83">End Function</font>                | 方法结束标识                          |

# 2、变量

## 2.1、变量的定义

* 代码

  ~~~vb
  Dim sql As String
  ~~~

* 说明

  | 行数 | 代码                                   | 说明                    |
  | :--: | -------------------------------------- | ----------------------- |
  |  1   | <font color="#6C1A83">Dim</font> sql   | 定义了一个名为sql的变量 |
  |  1   | <font color="#6C1A83">As String</font> | 定义的变量类型为String  |

# 3、流程

## 3.1、判断

~~~vb
if score >= 90 then
  MsgBox("优秀")
elseif score >= 70  then
  MsgBox("良好")
elseif score >= 60 then
  MsgBox("及格")
else
  MsgBox("不及格")
end if
~~~

## 3.2、循环

* for循环

  ~~~vb
  For i = 1 To 100
  	MsgBox(i)
  Next
  ~~~


# 4、容器

## 4.1、数组

### 4.1.1、获取数组上下界

* 代码

  ~~~vb
  LBound(arr) '数组上界，从0开始
  UBound(arr) '数组下界，为长度-1
  UBound(arr) - LBound(arr) + 1 '计算数组长度方式
  ~~~

# 5、字符&字符串

## 5.1、获取字符ASCII码

* 代码

  ~~~vb
  Asc(ch)
  ~~~

## 5.2、字符转译

| 代码    | 符号 |
| ------- | ---- |
| Chr(34) | "    |

## 5.3、切换字符/字符串大小写

* 代码

  ~~~vb
  UCase(str) '将字符串切换至大写
  LCase(str) '将字符串切换至小写
  ~~~

## 5.4、字符串拼接

* 代码

  ~~~vb
  sql = sql & "test"
  ~~~

## 5.5、分割字符串（split）

* 功能：按照字符将字符串分割成数组

* 代码

  ~~~vb
  a = Split(str, ",") '将字符串str按照符号“,”分割为数组，并赋值a
  ~~~

## 5.6、截取指定长度字符串（Substring）

* 代码

  ~~~vb
  ch = Mid(str, index, size)
  ~~~

* 说明

  | 参数  | 说明                |
  | ----- | ------------------- |
  | str   | 指定字符串          |
  | index | 字符串下标，从1开始 |
  | size  | 截取长度            |

# 6、Excel

## 6.1、单元格

### 6.1.1、单元格表示

* Cells

  * 代码

    ~~~vb
    Cells(rowIndex, colIndex)
    ~~~

  * 参数说明

    | 参数     | 说明 |
    | -------- | ---- |
    | rowIndex | 行号 |
    | colIndex | 列号 |

### 6.1.2、单元格赋值

* Cells赋值

  ~~~vb
  Cells(1, 1) = "Hello World" '为第一行第一列的单元格赋值Hello World
  ~~~


## 6.2、工作表

### 6.2.1、获取表格最大使用行数

* 代码

  ~~~vb
  i = UsedRange.Rows.Count
  ~~~

* 说明

  | 代码      | 说明                               |
  | --------- | ---------------------------------- |
  | UsedRange | 返回工作表中已经使用了的单元格区域 |
  | Rows      | 返回指定单元格区域行属性           |
  | Count     | 返回指定单元格区域行数             |

## 6.5、弹窗

### 6.5.1、提示型弹窗

~~~vb
MsgBox ("消息内容")
~~~

### 6.5.2、输入型弹窗

* 代码

  ~~~vb
  alias = InputBox(msgInfo, default)
  ~~~

* 参数

  | 参数    | 说明                     |
  | ------- | ------------------------ |
  | msgInfo | 弹出框提示信息           |
  | default | 输入内容为空时默认返回值 |