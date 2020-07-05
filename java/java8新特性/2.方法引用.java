1.	Method reference is using to visit the functions or constructors in the class or instance
2.	the examples of method reference
	/**Define a class named Person*/
	public class Person {

		String name;
		LocalDate birthday;

		public Person(String name, LocalDate birthday) {
			this.name = name;
			this.birthday = birthday;
		}

		public LocalDate getBirthday() {
			return this.birthday;
		}

		public static int compareByAge(Person a, Person b) {
			return a.birthday.compareTo(b.birthday);
		}

		@Override
		public String toString() {
			return this.name;
		}
	}
	/**Use anonymous inner class to sort the array*/
	public class TestMethodReference {
		@Test
		public void test() {
			Person[] pArr = new Person[] {
				new Person("003", LocalDate.of(2016,9,1)),
				new Person("001", LocalDate.of(2016,2,1)),
				new Person("002", LocalDate.of(2016,3,1)),
				new Person("004", LocalDate.of(2016,12,1))
			};
			/**Use anonymous inner class*/
			Arrays.sort(pArr, new Comparator<Person>() {
				@Override
				public int compare(Person a, Person b) {
					return a.getBirthday().compareTo(b.getBirthday());
				}
			});
			/**Use lambda expression, avoiding to invoke the function existed*/
			Arrays.sort(pArr, (Person a, Person b) -> {
				return a.getBirthday().compareTo(b.getBirthday());
			});
			/**Use lambda expression, invoking the function existed*/
			Arrays.sort(pArr, (a, b) -> Person.compareMyAge(a, b));
			/**Use method reference, refering the class's static method*/
			Arrays.sort(pArr, Person::compareByAge);
		}
		// results: 0001, 0002, 0003, 0004
	}

3.	There are four method reference definitions
	1	static method reference
		format: ClassName::staticMethodName
		examples:
			String::valueOf		<==>	(s) -> String.valueOf(s)
			Math::pow			<==>	(x, y) -> Math.pow(x, y)
		eg1: reverse the String
			public interface StringFunc {
				String func(String n);
			}

			public class MyStringOps {
				// static method: reverse the String
				public static String strReverse(String str) {
					String result = "";
					for (int i = str.length() - 1; i >= 0; i--) {
						result += str.charAt(i);
					}
					return result;
				}
			}

			public class MethodRefDemo {

				public static String stringOp(StringFunc sf, String s) {
					return sf.func(s);
				}

				public static void main(String[] args) {
					String inStr = "lambda add power to Java";
					/*
					 * <p>MyStringOps::strReverse</p>
					 * Implement the interface method: func()
					 * and do MyStringOps.strReverse() in func().
					 */
					String outStr = stringOp(MyStringOps::strReverse, inStr);
				}
			}
		eg2: 
			public class MyClass {

				private int val;

				MyClass(int v) {
					val = v;
				}

				public int getValue() {
					return val;
				}
			}

			public class UseMethodRef {

				public static int compareMC(MyClass a, MyClass b) {
					return a.getValue() - b.getValue();
				}

				public static void main(String[] args) {
					ArrayList<MyClass> a1 = new ArrayList<MyClass>();
					a1.add(new MyClass(1));
					a1.add(new MyClass(4));
					a1.add(new MyClass(2));
					a1.add(new MyClass(9));
					a1.add(new MyClass(3));
					a1.add(new MyClass(7));
					/*
					 * <p>UseMethodRef::compareMC</p>
					 * Implement the interface named Comparator and create a new instance.
					 * The interface contains a abstract function named compared(). We need
					 * to override the function to meet our needs.
					 */
					MyClass maxValObj = Collections.max(a1, UseMethodRef::compareMC);
					System.out.println("Maximum value is: " + maxValObj.getValue());
				}
			}
	
	2	specific object method reference
		format 1:	instanceReference::methodName
		examples:
			public class ComparisonProvider {

				public int compareByName(Person a, Person b) {
					return a.getName().compareTo(b.getName());
				}

				public int compareByAge(Person a, Person b) {
					return a.getBirthday().compareTo(b.getBirthday());
				}
			}

			public class test {
				@Test
				public void test() {
					// ... Create Person array named rosterAsArray
					ComparisonProvider provider = new ComparisonProvider();
					Arrays.sort(rosterAsArray, provider::compareByName);
				}
			}