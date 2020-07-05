1.	����ģʽ
	/**
	 * ����ʽ
	 */
	class Single {
		/*˽�л����캯��*/
		private Single() {}
		/*����˽�в���̬�ı������*/
		private static Single s = new Single();
		/*���幫�в���̬�ķ��������ظö���*/
		public static Single getInstance() {
			return s;
		}
	}

	/**
	 * ����ʽ
	 */
	class Single2{
		/*˽�л����캯��*/
		private Single2() {}
		private static Single2 s = null;
		public static Single2 getInstance() {
			if(s==null) {
				s = new Single2();
			}
			return s;
		}
	}

2.	ģ�巽�����ģʽ
	��������⣺�������ڲ�һ����ʵ��ʱȷ����һ����ʵ���ǲ�ȷ���ġ���ʱ���԰Ѳ�ȷ���Ĳ��ֱ�¶��ȥ��������ȥʵ�֡�
	abstract class GetTime{
		/*�˹����������Ҫ��д���ɼ�final�޶�*/
		public final void getTime() {
			long start = System.currentTimeMillis();
			/*��ȷ���Ĺ��ܲ��֣���ȡ������ͨ�����󷽷�ʵ��*/
			code();
			long end = System.currentTimeMillis();
			System.out.println("�����ǣ�" + (end - start));
		}
		/*����ȷ���Ĺ��ܣ������ิдʵ��*/
		public abstract void code();
	}

	class SubDemo extends GetTime {
		/*���ิд���ܷ���*/
		public void code() {
			for (int y = 0; y < 1000; y++) {
				System.out.println("y");
			}
		}
	}