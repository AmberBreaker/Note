1.	前提：
		栈：存储的都是局部变量（函数中定义的变量，函数上的参数，语句中的变量）；只要数据运算完成所在的区域结束，该数据就会被释放。
		堆：用于存储数组、成员变量和对象，也就是实体。啥是实体啊？就是用于封装多个数据的。
	问：
		public class Test {
			private int i = 0; // 存在堆中还是栈中
			public static void main(String[] args) {
				int j = 0; // 存在堆中还是栈中
			}
		}

	答：成员变量 i 存储在栈中

2.	1和2的写法正确吗？有区别吗？说出原因。
	// 1
	new Object() {
		void show() {
			System.out.println("show run");
		}
	}.show();

	//2
	Object obj = new Object() {
		void show() {
			System.out.println("show run");
		}
	};
	obj.show();

 	答：
 		写法是正确，1 和 2 都是在通过匿名内部类建立一个 Object 类的子类对象。
 	区别：
		第一个可是编译通过，并运行。
		第二个编译失败，因为匿名内部类是一个子类对象，当用 Object 的 obj 引用指向时，就被提升为了 Object 类型，
		而编译时检查 Object 类中是否有 show 方法，所以编译失败。

