1.	单例模式
	/**
	 * 饿汉式
	 */
	class Single {
		/*私有化构造函数*/
		private Single() {}
		/*创建私有并静态的本类对象*/
		private static Single s = new Single();
		/*定义公有并静态的方法，返回该对象*/
		public static Single getInstance() {
			return s;
		}
	}

	/**
	 * 懒汉式
	 */
	class Single2{
		/*私有化构造函数*/
		private Single2() {}
		private static Single2 s = null;
		public static Single2 getInstance() {
			if(s==null) {
				s = new Single2();
			}
			return s;
		}
	}

2.	模板方法设计模式
	解决的问题：当功能内部一部分实现时确定，一部分实现是不确定的。这时可以把不确定的部分暴露出去，让子类去实现。
	abstract class GetTime{
		/*此功能如果不需要复写，可加final限定*/
		public final void getTime() {
			long start = System.currentTimeMillis();
			/*不确定的功能部分，提取出来，通过抽象方法实现*/
			code();
			long end = System.currentTimeMillis();
			System.out.println("毫秒是：" + (end - start));
		}
		/*抽象不确定的功能，让子类复写实现*/
		public abstract void code();
	}

	class SubDemo extends GetTime {
		/*子类复写功能方法*/
		public void code() {
			for (int y = 0; y < 1000; y++) {
				System.out.println("y");
			}
		}
	}