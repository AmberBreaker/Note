1.	replace anonymous inner class:
	/**the anonymous inner class instance:*/
	@Test
	public void oldRunnable() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("The old runnable now is using");
			}
		}).start();
	}
	/**the Lambda expression:*/
	@Test
	public void runnable() {
		new Thread(() -> System.out.println("It's a lambda function!")).start();
	}

2.	iterate the set
	@Test
	public void iterTest() {
		List<String> languages = Array.asList("java", "scala", "python");
		// before java 8
		for (String language : languages) {
			System.out.println(language);
		}
		// after java 8
		languages.forEach(x -> System.out.println(x));
		languages.forEach(System.out::println);
	}

3.	realize the Map
	@Test
	public void mapTest() {
		List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
		cost.stream().map(x -> x + x * 0.05).forEach(x -> System.out.println(x));
		// 10.5
		// 21.0
		// 31.5
	}

4.	realize map and reduce
	// foreach
	@Test
	public void sumTest() {
		List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
		double sum = 0;
		for (double each : cost) {
			each += each * 0.05;
			sum += each;
		}
		// 63.0
	}
	// map¡¢reduce by lambda
	@Test
	public void mapReduceTest() {
		List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
		double allCost = cost.stream().map(x -> x + x * 0.05).reduce((sum, x) -> sum + x).get();
		// 63.0
	}

5.	filter operation
	@Test
	public void filterTest() {
		List<Double> cost = Arrays.asList(10.0, 20.0, 30.0, 40.0)
		List<Double> filteredCost = cost.stream().filter(x -> x > 25.0).collect(Collectors.toList())
		filteredCost.forEach(x -> System.out.println(x));
		// 30
		// 40
	}

6.	combine with predicate
	/**
	 * Using java.util.function.Predicate functional interface and lambda expression can add
	 * logic in the api function, it appears to use less code to support more dynamic behaviors
	 * Predicate suit for filtering.
	 */
	public static void filterTest(List<String> languages, Predicate<String> condition) {
		languages.stream().filter(x -> condition.test(x)).forEach(x -> System.out.println(x + " "));
	}

	public static void main(String[] args) {
		List<String> languages = Arrays.asList("Java", "Python", "Scala", "Shell", "R");
		// Language.starts with J:
		filterTest(languages, x -> x.startsWith("J"));
		// All languages：
		filterTest(languages, x -> true)
		// No languages£：
		filterTest(languages, x -> false)
		// Language length longer than 4:
		filterTest(languages, x -> x.length() > 4);
	}
	