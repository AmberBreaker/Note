========================================一轮扫描笔记========================================
1.	Java 变量类型
	1	Java 局部变量
		1.	局部变量是在栈上分配的。
		2.	局部变量没有默认值，所以局部变量被声明后，必须经过初始化，才可以使用。
	
	2	Java 实例变量
		1.	实例变量具有默认值。数值型变量的默认值是0，布尔型变量的默认值是false，引用类型变量的默认值是null。
			变量的值可以在声明时指定，也可以在构造方法中指定；
		2.	实例变量可以直接通过变量名访问。但在静态方法以及其他类中，就应该使用完全限定名：ObejectReference.VariableName。
	3	Java 类变量（静态变量）
		1.	无论一个类创建了多少个对象，类只拥有类变量的一份拷贝。
		2.	静态变量除了被声明为常量外很少使用。常量是指声明为public/private，final和static类型的变量。常量初始化后不可改变。
			public class Demo {
				public static final double PI = 3.1415926;
			}
		3.	静态变量可以通过：ClassName.VariableName的方式访问。

2.	Java 修饰符
	1	访问修饰符
		1.	使用默认访问修饰符声明的变量和方法，对同一个包内的类是可见的。接口里的变量都隐式声明为 public static final，
			而接口里的方法默认情况下访问权限为 public。
		2.	protected
	2	抽象类
		1.	抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充。
		2.	一个类不能同时被 abstract 和 final 修饰。
		3.	如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误。
		4.	抽象类可以包含抽象方法和非抽象方法。
	3	抽象方法
		1.	抽象方法不能被声明成 final 和 static。
		2.	任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类。
	4	transient 修饰符
		1.	序列化的对象包含被 transient 修饰的实例变量时，java 虚拟机(JVM)跳过该特定的变量。
		2.	该修饰符包含在定义变量的语句中，用来预处理类和变量的数据类型。
		eg：
			public transient int limit = 55;	// 不会持久化
			public int b;						// 持久化
	5	volatile 修饰符
		volatile 修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。
		而且，当成员变量发生变化时，会强制线程将变化值回写到共享内存。
		这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。一个 volatile 对象引用可能是 null。

3.	Java 运算符
	1	instanceof 运算符
		该运算符用于操作对象实例，检查该对象是否是一个特定类型（类类型或接口类型）。
		如果运算符左侧变量所指的对象，是操作符右侧类或接口(class/interface)的一个对象，那么结果为真。
		eg：
			String name = "James";
			boolean result = name instanceof String; // 由于 name 是 String 类型，所以返回真。
		在判断一个实例引用的类型时，使用的是实际类型，而不是声明的类型。
		class Vehicle {}

		public class Car extends Vehicle {
			public static void main(String args[]) {
				Car 	c1 = new Car();
				Vehicle v2 = new Car();							// v2 是 Car 类型
				Vehicle v3 = new Vehicle();

				//Car 是 Vehicle类型, Vehicle 不是 Car 类型
				boolean result1 = c1 instanceof Vehicle;		// true
				boolean result2 = v2 instanceof Car;			// true
				boolean result3 = v2 instanceof Vehicle;		// true
				boolean result4 = v3 instanceof Car;			// false
		   }
		}
	
	2	num % (2 ^ n) = num & (2 ^ n - 1)

4.	Java Number & Math 类
	1	Java 的 Math 包含了用于执行基本数学运算的属性和方法，如初等指数、对数、平方根和三角函数。
	2	Math 的方法都被定义为 static 形式，通过 Math 类可以在主函数中直接调用。

5.	Java String 类
	1	String 类有 11 种构造方法，这些方法提供不同的参数来初始化字符串。
		public class StringDemo {
			public static void main (String[] args) {
				char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
				String helloString = new String(helloArray);  
				System.out.println ( helloString );		// 输出：runoob
			}
		}
	2	String 部分不常见方法
		1.	boolean contentEquals(StringBuffer sb)
			StringBuffer 的值与该字符串相同的时候返回 true
		2.	public static String copyValueOf(char[] data)
			public static String copyValueOf(char[] data, int offset, int count)
			将字符数组转化为字符串（可指定长度）
		3.	byte[] getBytes()
			byte[] getBytes(String charsetName)
			将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
			参数为编码级，无参则使用平台的默认字符集，如：
			Str2 = Str1.getBytes( "UTF-8" );

6.	Java StringBuffer 和 StringBuilder 类
	1	StringBuffer 部分不常见方法
		1.	public StringBuffer replace(int start, int end, String str)
			使用给定 String 中的字符替换此序列的子字符串中的字符。
			start	：起始位置，从0开始，>= 
			end		：结束位置，		 <
			str		：需要替换的字符串

7.	Java 数组
	1	Java 语言中提供的数组是用来存储固定大小的同类型元素。
	2	数组支持 foreach 增强循环
	3	一维数组必须初始化数组长度。
		二维数组相当于一个一维数组（设为A），该一维数组存放着一个个一维数组（设为B0，B1，...）
		A 和 B 之间没有绝对关系，所以 A 和 B 的长度之间也不存在关系
		此时初始化二维数组的时候，必须初始化 A 的长度 2，如下：
		String[][] s = new String[2][]	// A 的长度初始化时必须给出
		s[0] = new String[2];			// 给 B1 初始化长度 2
		s[1] = new String[3]			// 给 B2 初始化长度 3
		当然，也可以一次性创建一个固定的二维数组，如：
		String[][] s = new String[2][3]
	4	Arrays 类部分不常见方法
		1.	public static boolean equals(int[] a, int[] a2)
			a 和 a2 两个数组若其中元素一模一样，且长度相同，则返回true
			注意1：二维数组无效
			注意2：a1.equals(a2) 会返回 false
		2.	public static void fill(Object[] a, Object val)
			public static void fill(Object[] a, int fromIndex, int toIndex, Object val)
			将 arr 数组中指定位置的元素值填为 val
			注意1：同样适用于八大基础类型组成的数组
			注意2：数组 a 和值 val 的类型一致
		3.	public static void sort(Object[] a)
			按照自然顺序排序数组 a

8.	Java 集合
	1.	Vector 方法：
		Vector<E> vector = new Vector<E>();
		1.	public Enumeration<E> elements();
			该方法实现一个静态内部类，将指定的 Vector 集合拆分并返回为 Enumeration 枚举类型
	*.	Vector 与 ArrayList 的区别：
		1.	Vector 的方法都是同步的（Synchronized），是线程安全的（thread-safe），而 ArrayList 的方法不是。
			由于线程的同步必然要影响性能，因此，ArrayList 的性能比 Vector 好。
		2.	当 Vector 或 ArrayList 中的元素超过它的初始大小时，Vector 会将它的容量翻倍，而 ArrayList 只增加50%的大小。
			这样，ArrayList 就有利于节约内存空间。
	
9.	Java 日期时间
	1	java 构造方法
		Date()					// 获取当前日期
		Date(long millisec)		// 第二个构造函数接收一个参数，该参数是从1970年1月1日起的毫秒数。
	2	部分不常见方法
		1.	// 若当调用此方法的Date对象在指定日期之后返回true,否则返回false。
			boolean before(Date date)
		2.	// 若当调用此方法的Date对象在指定日期之前返回true,否则返回false。 
			boolean after(Date date)
		3.	// 比较当调用此方法的Date对象和指定日期。两者相等时候返回0。
			// 调用对象在指定日期之前则返回负数。调用对象在指定日期之后则返回正数。
			int compareTo(Date date)
		4.	long getTime()	// 返回自1970年1月1日00:00:00到现在的毫秒数。
	3	使用 SimpleDateFormat 格式化日期
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");	// 日期格式
		ft.format(dNow);	// 将时间格式的 dNow 格式化为 ft。
		例：（日期和时间的格式化编码 自行百度，如 yyyy，MM 等代表）
			public class DateDemo {
				public static void main(String args[]) {
					Date dNow = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					System.out.println("Current Date: " + ft.format(dNow));
				}
			}
	4	DateFormat 方法
		1.	public Date parse(String source) // 将字符串按照指定格式转化为日期类型
			例：SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
				String input = "1818-11-11";
				Date t = ft.parse(input);
	5	Java 休眠(sleep)
		Thread.sleep(1000*3);	// 休眠 3s
	6	测量时间
		long start = System.currentTimeMillis();	// 截取当前时间
		System.out.println(new Date() + "\n");
		Thread.sleep(5*60*10);
		System.out.println(new Date() + "\n");
		long end = System.currentTimeMillis();		// 截取当前时间
		long diff = end - start;					// 时间差
	7	Calendar类
		1.	功能：设置和获取日期数据的特定部分，比如说小时，日，或者分钟。
				  在日期的特定部分加上或者减去值。
		2.	创建一个代表系统当前日期的 Calendar 对象
			Calendar c = Calendar.getInstance(); // 默认是当前日期
			c.set(2009, 5, 12); // 创建一个代表2009年6月12日的 Calendar 对象，（月份以 0 开始）
			c.set(Calendar.YEAR, 2018); // 将时间设置为 2018 年，其他的所有数值会被重新计算。
			c.get(Calendar.MONTH); // 获得 c 的月份
			其中 Calendar.YEAR 为 Calendar 类对象字段类型。具体查看 Calender 类中的方法

10.	Java 方法
	1	可变参数：
		1.	在方法声明中，在指定参数类型后加一个省略号(...) 。
		2.	一个方法中只能指定一个可变参数，它必须是方法的最后一个参数。任何普通的参数必须在它之前声明。
		例：
		public static void printMax(Object... numbers) {
			// 方法内容
		}
	
	2	finalize() 方法
		1.	在对象被垃圾收集器析构(回收)之前调用，它用来清除回收对象。
		2.	当然，Java 的内存回收可以由 JVM 来自动完成。

11.	Java 流（Stream）、文件（File）和 IO
	1	FileInputStream、FileOutputStream
		1.	public void close() throws IOException{}
			关闭此文件输入流并释放与此流有关的所有系统资源。抛出IOException异常。
		2.	public int read(int r)throws IOException{}	-- write
			这个方法从 InputStream 对象读取指定字节的数据。返回为整数值。返回下一字节数据，如果已经到结尾则返回-1。
		3.	public int read(byte[] r) throws IOException{}	-- write
			这个方法从输入流读取 r.length 长度的字节。返回读取的字节数。如果是文件结尾则返回-1。
		4.	public native long skip(long n) throws IOException;
			跳过 n 长度的内容
	2.	文件和 I/O
		1.	一些关于文件和 I/O 的类：
			File Class(类)
			FileReader Class(类)
			FileWriter Class(类)
		2.	创建目录：（File类）
			1.	public boolean mkdir(){}
				方法创建一个文件夹，成功则返回true，失败则返回false。
				失败表明File对象指定的路径已经存在，或者由于整个路径还不存在，该文件夹不能被创建。
			2.	public boolean mkdirs(){}
				方法创建一个文件夹和它的所有父文件夹。
			3.	public boolean isDirectory(){}
				若 File 对象是一个目录，则返回 true，否则为 false，例：
				File f1 = new File("E:/blairscott/test/");			-- 返回 true
				File f2 = new File("E:/blairscott/test/Test.java");	-- 返回 false
		3.	删除目录或文件：（File类）
			1.	public File[] listFiles(){}
				获得当前文件夹下所有子文件或子文件夹。
			2.	public boolean delete(){}
				删除指定 File
				File 为文件：删除
				File 为文件夹（目录）：必须保证该目录下没有其他文件才能正确删除，否则将删除失败。
			3.	综合例子：
				public void deleteFolder(File folder) {
					File[] files = folder.listFiles(); // 获得当前文件夹下所有子文件或子文件夹。
					if (files != null) {
						for (File f : files) {
							if (f.isDirectory()) {	// 判断是否为文件夹
								deleteFolder(f);	// 是，进入当前文件夹，进去删除里面的文件
							}
							f.delete();				// 删除 文件 或 文件夹
						}
					}
				}

12.	Java 异常处理
	1.	需要掌握以下三种类型的异常：
		1.	检查性异常：
			最具代表的检查性异常是用户错误或问题引起的异常，这是程序员无法预见的。
			例如要打开一个不存在文件时，一个异常就发生了，这些异常在编译时不能被简单地忽略。
		2.	运行时异常：
			运行时异常是可能被程序员避免的异常。
			与检查性异常相反，运行时异常可以在编译时被忽略。
		3.	错误：
			错误不是异常，而是脱离程序员控制的问题。错误在代码中通常被忽略。
			例如，当栈溢出时，一个错误就发生了，它们在编译也检查不到的。
	2.	注意事项：
		1.	catch 不能独立于 try 存在。
		2.	在 try/catch 后面添加 finally 块并非强制性要求的。
		3.	try 代码后不能既没 catch 块也没 finally 块。
		4.	try, catch, finally 块之间不能添加任何代码。
	3.	throws/throw 关键字：
		1.	throws：用于方法无捕获异常时，一般位于方法签名的最后
		2.	throw：方法内抛出异常，有以下实例：
			public void deposit(double amount) throws RemoteException {	-- throws
				// Method implementation
				throw new RemoteException();	-- throw，此处抛出throw，throws一定不能少
			}
									Throwable
						————————————————|————————————————
						|								|
					  Error							Exception
											————————————|————————————
											|						|
										IOException				RuntimeException
	4.	声明自定义异常
		1.	编写自定义异常需要记住的几点。
			1.	所有异常都必须是 Throwable 的子类。
			2.	如果希望写一个检查性异常类，则需要继承 Exception 类。
			3.	如果你想写一个运行时异常类，那么需要继承 RuntimeException 类。
	5.	通用异常（Java中定义了两种类型的异常和错误）：
		1.	JVM(Java虚拟机) 异常：
			由 JVM 抛出的异常或错误。
			例如：NullPointerException 类，ArrayIndexOutOfBoundsException 类，ClassCastException 类。
		2.	程序级异常：
			由程序或者API程序抛出的异常。
			例如 IllegalArgumentException 类，IllegalStateException 类。

13.	匿名内部类
	/**
	 * 
	 */
	class InnerClassDemo0 {
		+（static）class Inner {
			void show() {}
		}

		public void method() {
			// 可以
			this.new Inner().show();
		}

		/* static 不允许 this */
		public static void main(String[] args) {
			// 错误，Inner 类需要定义成 static
			This.new Inner().show();
		}
	}

	/**
	 * 
	 */
	interface Inter {
		void show();
	}

	/*通过匿名内部类补足 Outer 类中的代码*/
	class Outer {
		public static Inter method() {
			return new Inter() {
				public void show() {}
			};
		}
	}

	class InnerClassDemo1 {
		public static void main(String[] args) {
			Outer.method().show();
			/*
			 * Outer.method()：意思是: Outer 中有一个名称为 method 的方法，而且这个方法是静态的。
			 * Outer.method().show()：当 Outer 类调用静态的method方法运算结束后的结果又调用了 show 方法，
			 *		意味着：method() 方法运算完一个是对象，而且这个对象是 Inter 类型的。
			 */
			function (new Inter() {
				// 匿名内部类作为方法的参数进行传递
				public void show() {}
			});
		}

		public static void function(Inter in) {
			in.show();
		}
	}