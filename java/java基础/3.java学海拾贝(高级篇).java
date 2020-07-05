1.	Java 数据结构
	1.	枚举（Enumeration）
		枚举（The Enumeration）接口定义了一种从数据结构中取回连续元素的方式。
		方法1：在类的内部创建枚举
			public void getWeekDay() {
				Enumeration<String> days;
				Vector<String> dayNames = new Vector<String>();
				dayNames.add("Sunday");
				dayNames.add("Monday");
				dayNames.add("Tuesday");
				dayNames.add("Wednesday");
				dayNames.add("Thursday");
				dayNames.add("Friday");
				dayNames.add("Saturday");
				days = dayNames.elements();	// vector.elements() 方法返回 Enumeration 类型
				while (days.hasMoreElements()) { // 遍历
					String string = (String) days.nextElement();
				}
			}
		方法2：枚举类
			public enum Role { // 枚举类
				MANAGER("张三"); // 参数必须与构造方法中的参数一一对应
				EMPLOYEE("李四");
				private String	name;
				private Role(String name) { // 一定需要有构造函数，一般为私有
					this.name = name;
				}
				public String getName() {
					return name;
				}
				public void setName(String name) {
					this.name = name;
				}
			}

			@Test
			public void test() {
				// 使用方法1：（获取单个）
				Role manager = Role.MANAGER;
				manager.getName(); // 调用枚举类 Role 中的 MANAGER，获取其 name
				// 使用方法2：（获取所有）
				Role[] values = Role.values();
				for (Role role : values) {
					role.getName(); // 获取所有枚举类枚举元素的 name
				}
			}
	2.	位集合（BitSet）
		位集合类实现了一组可以单独设置和清除的位或标志。
		该类在处理一组布尔值的时候非常有用，你只需要给每个值赋值一"位"，然后对位进行适当的设置或清除，就可以对布尔值进行操作了。

	3.	向量（Vector）
		Vector类实现了一个动态数组。和ArrayList和相似，但是两者是不同的：
		Vector是同步访问的。
		Vector包含了许多传统的方法，这些方法不属于集合框架。
		Vector主要用在事先不知道数组的大小，或者只是需要一个可以改变大小的数组的情况。
		1.	四种构造方法：
			Vector() // 默认大小为10
			Vector(int size) // 指定向量大小
			Vector(int size, int incr) // 指定向量大小，并且增量用incr指定. 增量表示向量每次增加的元素数目。
			Vector(Collection c) // 相当于：Vector v =  new Vector(); v.add(collection)

	4.	栈（Stack）
		栈是Vector的一个子类，它实现了一个标准的后进先出的栈。
		堆栈只定义了默认构造函数，用来创建一个空栈。堆栈除了包括由Vector定义的所有方法，也定义了自己的一些方法。
		Stack<Integer> st = new Stack<Integer>(); // 创建栈对象。注意，栈的下标从 1 开始
		System.out.println(st.isEmpty()); // 判断栈是否为空
		st.push(new Integer(1)); // 把项压入堆栈顶部。
		st.push(new Integer(2)); // 把项压入堆栈顶部。
		System.out.println(st); // [1, 2]
		Integer a = (Integer) st.peek(); // 复制栈中顶端的值，并赋予变量 a，a = 1
		System.out.println(st); // [1, 2]
		Integer b = (Integer) st.pop(); // 从栈的顶端中拿出值，并赋予变量 b（此时栈中该值消失）
		System.out.println(st); // [1]

	5.	字典（Dictionary）
		与Map集合类似，可以通过特定的键而不是整数索引来访问数据，已经过时了。实际开发中可以用Map集合来获取键/值的存储功能

	6.	哈希表（Hashtable）
		Hashtable类提供了一种在用户定义键结构的基础上来组织数据的手段。
		哈希表键的具体含义完全取决于哈希表的使用情景和它包含的数据。

	7.	属性（Properties）
		Properties 继承于 Hashtable.Properties 类表示了一个持久的属性集.属性列表中每个键及其对应值都是一个字符串。
		Properties 类被许多Java类使用。例如，在获取环境变量时它就作为System.getProperties()方法的返回值。
		1.	Properties类定义了两个构造方法. 第一个构造方法没有默认值。
			Properties(); // 没有默认值。
			Properties(Properties propDefault); // 使用propDefault 作为默认值。
		2.	除了从 Hashtable 继承的方法，Properties定义了一下方法：
			1.	String getProperty(String key); // 用指定的键在此属性列表中搜索属性。
			2.	String getProperty(String key, String defaultProperty); // 用指定的键在属性列表中搜索属性。
			3.	void list(PrintStream streamOut);
				void list(PrintWriter streamOut); // 将属性列表输出到指定的输出流。
			4.	void load(InputStream streamIn) throws IOException; // 从输入流中读取属性列表（键和元素对）。
			5.	Enumeration propertyNames(); // 获取属性键名。
			6.	Object setProperty(String key, String value); // 调用 Hashtable 对的 put() 方法。
			7.	void store(OutputStream streamOut, String description);
			// 以适合使用 load(InputStream) 方法加载到 Properties 表中的格式，将此 Properties 表中的属性列表（键和元素对）写入输出流。

2.	Java 集合框架
	1.	Java 集合框架主要包括两种类型的容器，一种是集合（Collection），存储一个元素集合；另一种是图（Map），存储键/值对映射。
	2.	Collection 接口又有 3 种子类型，List、Set 和 Queue，再下面是一些抽象类，最后是具体实现类。
	3.	Set 和 List 的区别
		1.	Set 接口实例存储的是无序的，不重复的数据。List 接口实例存储的是有序的，可以重复的元素。
		2.	Set 检索效率低下，删除和插入效率高，插入和删除不会引起元素位置改变。
		3.	List 和数组类似，可以动态增长，根据实际存储的数据的长度自动增长 List 的长度。
			查找元素效率高，插入删除效率低，因为会引起其他元素位置改变。
		4.	部分集合实现类（集合类）
			1.	LinkedList
				1.	LinkedList 查找效率低。
				2.	该类实现了List接口，允许有null（空）元素。
				3.	主要用于创建链表数据结构，该类没有同步方法，如果多个线程同时访问一个List，则必须自己实现访问同步。
					解决方法就是在创建List时候构造一个同步的List。例如：
					List list = Collection.synchronizedList(new LinkList(...));
			2.	ArrayList
				1.	该类也是实现了List的接口，实现了可变大小的数组，随机访问和遍历元素时，提供更好的性能，插入删除效率低。
				2.	ArrayList 增长当前长度的 50%。
				3.	该类也是非同步的，在多线程的情况下不要使用。
			3.	HashSet
				1.	该类实现 Set 接口，不允许出现重复元素，不保证集合中元素的顺序。
				2.	允许包含值为 null 的元素，但最多只能一个。
			4.	LinkedHashSet
				具有可预知迭代顺序的 Set 接口的哈希表和链接列表实现。
			5.	TreeSet
				实现了 Set 接口，可以实现排序等功能。
			6.	HashMap
				1.	HashMap 是一个散列表，它存储的内容是键值对（key - value）映射。
				2.	该类实现了 Map 接口，根据键的 HashCode 值存储数据，具有很快的访问速度。
				3.	最多允许一条记录的键为 null。
				4.	不支持线程同步。
			7.	TreeMap
				继承了 AbstractMap 类，并且使用一棵树。
			8.	LinkedHashMap 
				继承于HashMap，使用元素的自然顺序对元素进行排序.
			9.	WeakHashMap 
				继承AbstractMap类，使用弱密钥的哈希表。
	4.	任何对象加入集合类后，自动转变为 Object 类型，所以在取出的时候，需要进行强制类型转换。

3.	Java 泛型
	Java 泛型（generics）是 JDK 5 中引入的一个新特性，泛型提供了编译时类型安全检测机制，
	该机制允许程序员在编译时检测到非法的类型。泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。
	1.	定义泛型方法的规则
		1.	所有泛型方法声明都有一个类型参数声明部分（由尖括号分隔），该类型参数声明部分在方法返回类型之前，例：
			public static <E,V> void printArray(E[] inputArray); // E，V 即为泛型参数声明部分
		2.	每一个类型参数声明部分包含一个或多个类型参数，参数间用逗号隔开。如上例中的 <E,V>
			一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
		3.	类型参数能被用来声明返回值类型，并且能作为泛型方法得到的实际参数类型的占位符。例：
			public static <E> E[] printArray(E[] inputArray);
		4.	泛型方法体的声明和其他方法一样。注意类型参数只能代表引用型类型，不能是原始类型（像int，double，char的等）。
			printArray(int age);		×
			printArray(Integer age);	√
	2.	有界的类型参数：
		作用：限制那些被允许传递到一个类型参数的类型种类范围。
		例如：一个操作数字的方法可能只希望接受Number或者Number子类的实例。
		要声明一个有界的类型参数，首先列出类型参数的名称，后跟extends关键字，最后紧跟它的上界。如：
		public static <T extends Comparable<T>> T maximum(T x, T y, T z)
	3.	定义泛型类规则
		1.	泛型类的声明和非泛型类的声明类似，除了在类名后面添加了类型参数声明部分。
		2.	和泛型方法一样，泛型类的类型参数声明部分也包含一个或多个类型参数，参数间用逗号隔开。
			一个泛型参数，也被称为一个类型变量，是用于指定一个泛型类型名称的标识符。
			因为他们接受一个或多个参数，这些类被称为参数化的类或参数化的类型。
	4.	类型通配符
		1.	类型通配符一般是使用?代替具体的类型参数。
			例如 List<?> 在逻辑上是 List<String>、List<Integer> 等所有 List <具体类型实参>的父类。
		2.	类型通配符上限通过形如List来定义，如此定义就是通配符泛型值接受Number及其下层子类类型。如：
			public void test(List<? extends Number> data);
		3.	类型通配符下限通过形如 List<? super Number> 来定义，表示类型只能接受 Number 及其三层父类类型，如 Object 类型的实例。
		4.	<? extends T> 和 <? super T>的区别：
			1.	<? extends T> 表示该通配符所代表的类型是 T 类型的子类。
			2.	<? super T> 表示该通配符所代表的类型是 T 类型的父类。
	5.	需知：
		1.	对于泛型，只是允许程序员在编译时检测到非法的类型而已。但是在运行期时，其中的泛型标志会变化为 Object 类型。
		2.	可以声明泛型数组（即：public T[] t）。但不可创建泛型数组（即：new T[];）
			若需要创建泛型数组，只能通过强制类型转换实现。如：
			T[] t = (T[]) new Object[size];

4.	Java 序列化
	1.	Java 提供了一种对象序列化的机制。该机制中，一个对象可以被表示为一个字节序列，
		该字节序列包括：该对象的数据、有关对象的类型的信息 和 存储在对象中数据的类型。
	2.	请注意，一个类的对象要想序列化成功，必须满足两个条件：
		1.	该类必须实现 java.io.Serializable 对象。
		2.	该类的所有属性必须是可序列化的。如果有一个属性不是可序列化的，则该属性必须注明是短暂的。
	3.	如果被写对象的类型是String，或数组，或Enum，或Serializable，那么就可以对该对象进行序列化，否则将抛出NotSerializableException。
	4.	关于序列化，常又称为持久化，将其写入磁盘中。进而对于编码规则来说：
		任一一个实体类必须要去实现 Serializable 接口，方便以后将该类持久化，或者将其用于转为字节数组，用于网络传输。*
		对于一个实体类，不想将所有的属性都进行序列化，有专门的关键字 transient。如：
		private transient String name; // 当对该类序列化时，会自动忽略被 transient 修饰的属性。

5.	Java 网络编程
	网络编程是指编写运行在多个设备（计算机）的程序，这些设备都通过网络连接起来。
	1.	java.net 包中提供了两种常见的网络协议的支持：
		1.	TCP：传输控制协议的缩写，它保障了两个应用程序之间的可靠通信。通常用于互联网协议，被称 TCP / IP。
		2.	UDP：用户数据报协议的缩写，一个无连接的协议。提供了应用程序之间要发送的数据的数据包。
	2.	Socket 编程
		1.	套接字使用 TCP 提供了两台计算机之间的通信机制。客户端程序创建一个套接字，并尝试连接服务器的套接字。
		2.	当连接建立时，服务器会创建一个 Socket 对象。客户端和服务器现在可以通过对 Socket 对象的写入和读取来进行通信。
		3.	java.net.Socket 类代表一个套接字，并且 java.net.ServerSocket 类为服务器程序提供了一种来监听客户端，并与他们建立连接的机制。
		4.	以下步骤在两台计算机之间使用套接字建立 TCP 连接时会出现：
			1.	服务器实例化一个 ServerSocket 对象，表示通过服务器上的端口通信。
			2.	服务器调用 ServerSocket 类的 accept() 方法，该方法将一直等待，直到客户端连接到服务器上给定的端口。
			3.	服务器正在等待时，一个客户端实例化一个 Socket 对象，指定服务器名称和端口号来请求连接。
			4.	Socket 类的构造函数试图将客户端连接到指定的服务器和端口号。如果通信被建立，则在客户端创建一个 Socket 对象能够与服务器进行通信。
			5.	在服务器端，accept() 方法返回服务器上一个新的 socket 引用，该 socket 连接到客户端的 socket。
		5.	连接建立后，通过使用 I/O 流在进行通信，每一个 socket 都有一个输出流和一个输入流，客户端的输出流连接到服务器端的输入流，
			而客户端的输入流连接到服务器端的输出流。TCP 是一个双向的通信协议，因此数据可以通过两个数据流在同一时间发送。

6.	Java 多线程编程
	1.	一条线程指的是进程中一个单一顺序的控制流，一个进程中可以并发多个线程，每条线程并行执行不同的任务。
	2.	多线程是多任务的一种特别的形式，但多线程使用了更小的资源开销。
	3.	进程：一个进程包括由操作系统分配的内存空间，包含一个或多个线程。
	4.	一个线程不能独立的存在，它必须是进程的一部分。一个进程一直运行，直到所有的非守护线程都结束运行后才能结束。
	5.	线程的生命周期：
		1.	新建状态：使用 new 关键字和 Thread 类或其子类建立一个线程对象后，该线程对象就处于新建状态。
			它保持这个状态直到程序 start() 这个线程。
		2.	就绪状态：当线程对象调用了start()方法之后，该线程就进入 就绪状态。
			就绪状态的线程处于 就绪队列 中，要等待 JVM 里 线程调度器 的调度。
		3.	运行状态：如果就绪状态的线程获取 CPU 资源，就可以执行 run()，此时线程便处于运行状态。
			处于运行状态的线程最为复杂，它可以变为 阻塞状态、就绪状态 和 死亡状态。
		4.	阻塞状态：如果一个线程执行了 sleep（睡眠）、suspend（挂起）等方法，失去所占用资源之后，该线程就从运行状态进入阻塞状态。
			在睡眠时间已到 或 获得设备资源 后可以重新进入就绪状态。可以分为三种：
			1.	等待阻塞：运行状态中的线程执行 wait() 方法，使线程进入到等待阻塞状态。
			2.	同步阻塞：线程在获取 synchronized 同步锁失败(因为同步锁被其他线程占用)。
			3.	其他阻塞：通过调用线程的 sleep() 或 join() 发出了 I/O 请求时，线程就会进入到阻塞状态。
						当 sleep() 状态超时，join() 等待线程终止或超时，或者 I/O 处理完毕，线程重新转入就绪状态。
		4。	死亡状态：一个运行状态的线程完成任务或者其他终止条件发生时，该线程就切换到终止状态。
	6.	线程的优先级：
		1.	Java 线程的优先级是一个整数，其取值范围是：1（Thread.MIN_PRIORITY ）~ 10（Thread.MAX_PRIORITY ）。
			默认情况下，每一个线程都会分配一个优先级 NORM_PRIORITY（5）。
			public final void setPriority(int priority);
		2.	线程优先级不能保证线程执行的顺序，而且非常依赖于平台。
	7.	Java 的三种创建线程的方法
		1.	通过实现 Runnable 接口；
			1.	实现 Runnable 接口。
			2.	获取 Thread 类型对象（t），线程可以重命名：
				public final void setName(String name);
			3.	重写 run() 方法。该方法会在 t.start(); 后执行
			4.	t.start();
		2.	通过继承 Thread 类本身。
			1.	创建一个新的类，该类继承 Thread 类，然后创建一个该类的实例。
			2.	继承类必须重写 run() 方法，该方法是新线程的入口点，它必须用 start() 方法才能执行
			3.	其本质也是实现了 Runnable 接口的一个实例。
		3.	通过 Callable 和 Future 创建线程。？
	8.	Thread 类方法
		1.	public void start(); // 使该线程开始执行，Java虚拟机 调用该线程的 run() 方法。
		2.	public void run();
		3.	public final void setName(String name); // 改变线程名称
		4.	public final void setPriority(int prority); // 设置优先级
		5.	public final void setDaemon(boolean on); // 将该线程标记为 守护线程 或 用户线程。
		6.	public final void join(long millisec); // 等待该线程终止的时间最长为 millis 毫秒。
		7.	public void interrupt(); // 中断线程
		8.	public final boolean isAlive(); // 测试线程是否处于活动状态。
		9.	public static void yield(); // 暂停当前正在执行的线程对象，并执行其他线程。
		10.	public static void sleep(long millisec); // 线程休眠millisec，其精度受 系统计时器 和 调度程序精度和准确性的影响。
		11.	public static boolean holdsLock(Object x); // 当且仅当当前线程在指定的对象上保持监视器锁时，才返回true。（<?>监视器锁）
		12.	public static Thread currentThread(); // 返回对当前正在执行的线程对象的引用。
		13.	public static void dumpStack(); // 将当前线程的堆栈跟踪打印至标准错误流。