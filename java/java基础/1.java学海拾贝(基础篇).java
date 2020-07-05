========================================һ��ɨ��ʼ�========================================
1.	Java ��������
	1	Java �ֲ�����
		1.	�ֲ���������ջ�Ϸ���ġ�
		2.	�ֲ�����û��Ĭ��ֵ�����Ծֲ������������󣬱��뾭����ʼ�����ſ���ʹ�á�
	
	2	Java ʵ������
		1.	ʵ����������Ĭ��ֵ����ֵ�ͱ�����Ĭ��ֵ��0�������ͱ�����Ĭ��ֵ��false���������ͱ�����Ĭ��ֵ��null��
			������ֵ����������ʱָ����Ҳ�����ڹ��췽����ָ����
		2.	ʵ����������ֱ��ͨ�����������ʡ����ھ�̬�����Լ��������У���Ӧ��ʹ����ȫ�޶�����ObejectReference.VariableName��
	3	Java ���������̬������
		1.	����һ���ഴ���˶��ٸ�������ֻӵ���������һ�ݿ�����
		2.	��̬�������˱�����Ϊ���������ʹ�á�������ָ����Ϊpublic/private��final��static���͵ı�����������ʼ���󲻿ɸı䡣
			public class Demo {
				public static final double PI = 3.1415926;
			}
		3.	��̬��������ͨ����ClassName.VariableName�ķ�ʽ���ʡ�

2.	Java ���η�
	1	�������η�
		1.	ʹ��Ĭ�Ϸ������η������ı����ͷ�������ͬһ�����ڵ����ǿɼ��ġ��ӿ���ı�������ʽ����Ϊ public static final��
			���ӿ���ķ���Ĭ������·���Ȩ��Ϊ public��
		2.	protected
	2	������
		1.	�����಻������ʵ�������������������ΨһĿ����Ϊ�˽����Ը���������䡣
		2.	һ���಻��ͬʱ�� abstract �� final ���Ρ�
		3.	���һ����������󷽷�����ô����һ��Ҫ����Ϊ�����࣬���򽫳��ֱ������
		4.	��������԰������󷽷��ͷǳ��󷽷���
	3	���󷽷�
		1.	���󷽷����ܱ������� final �� static��
		2.	�κμ̳г�������������ʵ�ָ�������г��󷽷������Ǹ�����Ҳ�ǳ����ࡣ
	4	transient ���η�
		1.	���л��Ķ�������� transient ���ε�ʵ������ʱ��java �����(JVM)�������ض��ı�����
		2.	�����η������ڶ������������У�����Ԥ������ͱ������������͡�
		eg��
			public transient int limit = 55;	// ����־û�
			public int b;						// �־û�
	5	volatile ���η�
		volatile ���εĳ�Ա������ÿ�α��̷߳���ʱ����ǿ�ƴӹ����ڴ������¶�ȡ�ó�Ա������ֵ��
		���ң�����Ա���������仯ʱ����ǿ���߳̽��仯ֵ��д�������ڴ档
		�������κ�ʱ�̣�������ͬ���߳����ǿ���ĳ����Ա������ͬһ��ֵ��һ�� volatile �������ÿ����� null��

3.	Java �����
	1	instanceof �����
		����������ڲ�������ʵ�������ö����Ƿ���һ���ض����ͣ������ͻ�ӿ����ͣ���
		����������������ָ�Ķ����ǲ������Ҳ����ӿ�(class/interface)��һ��������ô���Ϊ�档
		eg��
			String name = "James";
			boolean result = name instanceof String; // ���� name �� String ���ͣ����Է����档
		���ж�һ��ʵ�����õ�����ʱ��ʹ�õ���ʵ�����ͣ����������������͡�
		class Vehicle {}

		public class Car extends Vehicle {
			public static void main(String args[]) {
				Car 	c1 = new Car();
				Vehicle v2 = new Car();							// v2 �� Car ����
				Vehicle v3 = new Vehicle();

				//Car �� Vehicle����, Vehicle ���� Car ����
				boolean result1 = c1 instanceof Vehicle;		// true
				boolean result2 = v2 instanceof Car;			// true
				boolean result3 = v2 instanceof Vehicle;		// true
				boolean result4 = v3 instanceof Car;			// false
		   }
		}
	
	2	num % (2 ^ n) = num & (2 ^ n - 1)

4.	Java Number & Math ��
	1	Java �� Math ����������ִ�л�����ѧ��������Ժͷ����������ָ����������ƽ���������Ǻ�����
	2	Math �ķ�����������Ϊ static ��ʽ��ͨ�� Math ���������������ֱ�ӵ��á�

5.	Java String ��
	1	String ���� 11 �ֹ��췽������Щ�����ṩ��ͬ�Ĳ�������ʼ���ַ�����
		public class StringDemo {
			public static void main (String[] args) {
				char[] helloArray = { 'r', 'u', 'n', 'o', 'o', 'b'};
				String helloString = new String(helloArray);  
				System.out.println ( helloString );		// �����runoob
			}
		}
	2	String ���ֲ���������
		1.	boolean contentEquals(StringBuffer sb)
			StringBuffer ��ֵ����ַ�����ͬ��ʱ�򷵻� true
		2.	public static String copyValueOf(char[] data)
			public static String copyValueOf(char[] data, int offset, int count)
			���ַ�����ת��Ϊ�ַ�������ָ�����ȣ�
		3.	byte[] getBytes()
			byte[] getBytes(String charsetName)
			���� String ����Ϊ byte ���У���������洢��һ���µ� byte �����С�
			����Ϊ���뼶���޲���ʹ��ƽ̨��Ĭ���ַ������磺
			Str2 = Str1.getBytes( "UTF-8" );

6.	Java StringBuffer �� StringBuilder ��
	1	StringBuffer ���ֲ���������
		1.	public StringBuffer replace(int start, int end, String str)
			ʹ�ø��� String �е��ַ��滻�����е����ַ����е��ַ���
			start	����ʼλ�ã���0��ʼ��>= 
			end		������λ�ã�		 <
			str		����Ҫ�滻���ַ���

7.	Java ����
	1	Java �������ṩ�������������洢�̶���С��ͬ����Ԫ�ء�
	2	����֧�� foreach ��ǿѭ��
	3	һά��������ʼ�����鳤�ȡ�
		��ά�����൱��һ��һά���飨��ΪA������һά��������һ����һά���飨��ΪB0��B1��...��
		A �� B ֮��û�о��Թ�ϵ������ A �� B �ĳ���֮��Ҳ�����ڹ�ϵ
		��ʱ��ʼ����ά�����ʱ�򣬱����ʼ�� A �ĳ��� 2�����£�
		String[][] s = new String[2][]	// A �ĳ��ȳ�ʼ��ʱ�������
		s[0] = new String[2];			// �� B1 ��ʼ������ 2
		s[1] = new String[3]			// �� B2 ��ʼ������ 3
		��Ȼ��Ҳ����һ���Դ���һ���̶��Ķ�ά���飬�磺
		String[][] s = new String[2][3]
	4	Arrays �ಿ�ֲ���������
		1.	public static boolean equals(int[] a, int[] a2)
			a �� a2 ��������������Ԫ��һģһ�����ҳ�����ͬ���򷵻�true
			ע��1����ά������Ч
			ע��2��a1.equals(a2) �᷵�� false
		2.	public static void fill(Object[] a, Object val)
			public static void fill(Object[] a, int fromIndex, int toIndex, Object val)
			�� arr ������ָ��λ�õ�Ԫ��ֵ��Ϊ val
			ע��1��ͬ�������ڰ˴����������ɵ�����
			ע��2������ a ��ֵ val ������һ��
		3.	public static void sort(Object[] a)
			������Ȼ˳���������� a

8.	Java ����
	1.	Vector ������
		Vector<E> vector = new Vector<E>();
		1.	public Enumeration<E> elements();
			�÷���ʵ��һ����̬�ڲ��࣬��ָ���� Vector ���ϲ�ֲ�����Ϊ Enumeration ö������
	*.	Vector �� ArrayList ������
		1.	Vector �ķ�������ͬ���ģ�Synchronized�������̰߳�ȫ�ģ�thread-safe������ ArrayList �ķ������ǡ�
			�����̵߳�ͬ����ȻҪӰ�����ܣ���ˣ�ArrayList �����ܱ� Vector �á�
		2.	�� Vector �� ArrayList �е�Ԫ�س������ĳ�ʼ��Сʱ��Vector �Ὣ���������������� ArrayList ֻ����50%�Ĵ�С��
			������ArrayList �������ڽ�Լ�ڴ�ռ䡣
	
9.	Java ����ʱ��
	1	java ���췽��
		Date()					// ��ȡ��ǰ����
		Date(long millisec)		// �ڶ������캯������һ���������ò����Ǵ�1970��1��1����ĺ�������
	2	���ֲ���������
		1.	// �������ô˷�����Date������ָ������֮�󷵻�true,���򷵻�false��
			boolean before(Date date)
		2.	// �������ô˷�����Date������ָ������֮ǰ����true,���򷵻�false�� 
			boolean after(Date date)
		3.	// �Ƚϵ����ô˷�����Date�����ָ�����ڡ��������ʱ�򷵻�0��
			// ���ö�����ָ������֮ǰ�򷵻ظ��������ö�����ָ������֮���򷵻�������
			int compareTo(Date date)
		4.	long getTime()	// ������1970��1��1��00:00:00�����ڵĺ�������
	3	ʹ�� SimpleDateFormat ��ʽ������
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");	// ���ڸ�ʽ
		ft.format(dNow);	// ��ʱ���ʽ�� dNow ��ʽ��Ϊ ft��
		���������ں�ʱ��ĸ�ʽ������ ���аٶȣ��� yyyy��MM �ȴ���
			public class DateDemo {
				public static void main(String args[]) {
					Date dNow = new Date();
					SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					System.out.println("Current Date: " + ft.format(dNow));
				}
			}
	4	DateFormat ����
		1.	public Date parse(String source) // ���ַ�������ָ����ʽת��Ϊ��������
			����SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
				String input = "1818-11-11";
				Date t = ft.parse(input);
	5	Java ����(sleep)
		Thread.sleep(1000*3);	// ���� 3s
	6	����ʱ��
		long start = System.currentTimeMillis();	// ��ȡ��ǰʱ��
		System.out.println(new Date() + "\n");
		Thread.sleep(5*60*10);
		System.out.println(new Date() + "\n");
		long end = System.currentTimeMillis();		// ��ȡ��ǰʱ��
		long diff = end - start;					// ʱ���
	7	Calendar��
		1.	���ܣ����úͻ�ȡ�������ݵ��ض����֣�����˵Сʱ���գ����߷��ӡ�
				  �����ڵ��ض����ּ��ϻ��߼�ȥֵ��
		2.	����һ������ϵͳ��ǰ���ڵ� Calendar ����
			Calendar c = Calendar.getInstance(); // Ĭ���ǵ�ǰ����
			c.set(2009, 5, 12); // ����һ������2009��6��12�յ� Calendar ���󣬣��·��� 0 ��ʼ��
			c.set(Calendar.YEAR, 2018); // ��ʱ������Ϊ 2018 �꣬������������ֵ�ᱻ���¼��㡣
			c.get(Calendar.MONTH); // ��� c ���·�
			���� Calendar.YEAR Ϊ Calendar ������ֶ����͡�����鿴 Calender ���еķ���

10.	Java ����
	1	�ɱ������
		1.	�ڷ��������У���ָ���������ͺ��һ��ʡ�Ժ�(...) ��
		2.	һ��������ֻ��ָ��һ���ɱ�������������Ƿ��������һ���������κ���ͨ�Ĳ�����������֮ǰ������
		����
		public static void printMax(Object... numbers) {
			// ��������
		}
	
	2	finalize() ����
		1.	�ڶ��������ռ�������(����)֮ǰ���ã�������������ն���
		2.	��Ȼ��Java ���ڴ���տ����� JVM ���Զ���ɡ�

11.	Java ����Stream�����ļ���File���� IO
	1	FileInputStream��FileOutputStream
		1.	public void close() throws IOException{}
			�رմ��ļ����������ͷ�������йص�����ϵͳ��Դ���׳�IOException�쳣��
		2.	public int read(int r)throws IOException{}	-- write
			��������� InputStream �����ȡָ���ֽڵ����ݡ�����Ϊ����ֵ��������һ�ֽ����ݣ�����Ѿ�����β�򷵻�-1��
		3.	public int read(byte[] r) throws IOException{}	-- write
			�����������������ȡ r.length ���ȵ��ֽڡ����ض�ȡ���ֽ�����������ļ���β�򷵻�-1��
		4.	public native long skip(long n) throws IOException;
			���� n ���ȵ�����
	2.	�ļ��� I/O
		1.	һЩ�����ļ��� I/O ���ࣺ
			File Class(��)
			FileReader Class(��)
			FileWriter Class(��)
		2.	����Ŀ¼����File�ࣩ
			1.	public boolean mkdir(){}
				��������һ���ļ��У��ɹ��򷵻�true��ʧ���򷵻�false��
				ʧ�ܱ���File����ָ����·���Ѿ����ڣ�������������·���������ڣ����ļ��в��ܱ�������
			2.	public boolean mkdirs(){}
				��������һ���ļ��к��������и��ļ��С�
			3.	public boolean isDirectory(){}
				�� File ������һ��Ŀ¼���򷵻� true������Ϊ false������
				File f1 = new File("E:/blairscott/test/");			-- ���� true
				File f2 = new File("E:/blairscott/test/Test.java");	-- ���� false
		3.	ɾ��Ŀ¼���ļ�����File�ࣩ
			1.	public File[] listFiles(){}
				��õ�ǰ�ļ������������ļ������ļ��С�
			2.	public boolean delete(){}
				ɾ��ָ�� File
				File Ϊ�ļ���ɾ��
				File Ϊ�ļ��У�Ŀ¼�������뱣֤��Ŀ¼��û�������ļ�������ȷɾ��������ɾ��ʧ�ܡ�
			3.	�ۺ����ӣ�
				public void deleteFolder(File folder) {
					File[] files = folder.listFiles(); // ��õ�ǰ�ļ������������ļ������ļ��С�
					if (files != null) {
						for (File f : files) {
							if (f.isDirectory()) {	// �ж��Ƿ�Ϊ�ļ���
								deleteFolder(f);	// �ǣ����뵱ǰ�ļ��У���ȥɾ��������ļ�
							}
							f.delete();				// ɾ�� �ļ� �� �ļ���
						}
					}
				}

12.	Java �쳣����
	1.	��Ҫ���������������͵��쳣��
		1.	������쳣��
			��ߴ���ļ�����쳣���û����������������쳣�����ǳ���Ա�޷�Ԥ���ġ�
			����Ҫ��һ���������ļ�ʱ��һ���쳣�ͷ����ˣ���Щ�쳣�ڱ���ʱ���ܱ��򵥵غ��ԡ�
		2.	����ʱ�쳣��
			����ʱ�쳣�ǿ��ܱ�����Ա������쳣��
			�������쳣�෴������ʱ�쳣�����ڱ���ʱ�����ԡ�
		3.	����
			�������쳣�������������Ա���Ƶ����⡣�����ڴ�����ͨ�������ԡ�
			���磬��ջ���ʱ��һ������ͷ����ˣ������ڱ���Ҳ��鲻���ġ�
	2.	ע�����
		1.	catch ���ܶ����� try ���ڡ�
		2.	�� try/catch ������� finally �鲢��ǿ����Ҫ��ġ�
		3.	try ������ܼ�û catch ��Ҳû finally �顣
		4.	try, catch, finally ��֮�䲻������κδ��롣
	3.	throws/throw �ؼ��֣�
		1.	throws�����ڷ����޲����쳣ʱ��һ��λ�ڷ���ǩ�������
		2.	throw���������׳��쳣��������ʵ����
			public void deposit(double amount) throws RemoteException {	-- throws
				// Method implementation
				throw new RemoteException();	-- throw���˴��׳�throw��throwsһ��������
			}
									Throwable
						��������������������������������|��������������������������������
						|								|
					  Error							Exception
											������������������������|������������������������
											|						|
										IOException				RuntimeException
	4.	�����Զ����쳣
		1.	��д�Զ����쳣��Ҫ��ס�ļ��㡣
			1.	�����쳣�������� Throwable �����ࡣ
			2.	���ϣ��дһ��������쳣�࣬����Ҫ�̳� Exception �ࡣ
			3.	�������дһ������ʱ�쳣�࣬��ô��Ҫ�̳� RuntimeException �ࡣ
	5.	ͨ���쳣��Java�ж������������͵��쳣�ʹ��󣩣�
		1.	JVM(Java�����) �쳣��
			�� JVM �׳����쳣�����
			���磺NullPointerException �࣬ArrayIndexOutOfBoundsException �࣬ClassCastException �ࡣ
		2.	�����쳣��
			�ɳ������API�����׳����쳣��
			���� IllegalArgumentException �࣬IllegalStateException �ࡣ

13.	�����ڲ���
	/**
	 * 
	 */
	class InnerClassDemo0 {
		+��static��class Inner {
			void show() {}
		}

		public void method() {
			// ����
			this.new Inner().show();
		}

		/* static ������ this */
		public static void main(String[] args) {
			// ����Inner ����Ҫ����� static
			This.new Inner().show();
		}
	}

	/**
	 * 
	 */
	interface Inter {
		void show();
	}

	/*ͨ�������ڲ��ಹ�� Outer ���еĴ���*/
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
			 * Outer.method()����˼��: Outer ����һ������Ϊ method �ķ�����������������Ǿ�̬�ġ�
			 * Outer.method().show()���� Outer ����þ�̬��method�������������Ľ���ֵ����� show ������
			 *		��ζ�ţ�method() ����������һ���Ƕ��󣬶������������ Inter ���͵ġ�
			 */
			function (new Inter() {
				// �����ڲ�����Ϊ�����Ĳ������д���
				public void show() {}
			});
		}

		public static void function(Inter in) {
			in.show();
		}
	}