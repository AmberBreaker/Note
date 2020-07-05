[toc]

# 1、Spring核心理解

## 1.1、常用Spring家族成员[^1]

### 1.1.1、Spring基础

* Spring FrameWork
  * 分成很多组件。
* Spring Boot
  * 比Spring FrameWork更加简单。
  * 自动配置。
  * 起步依赖（maven依赖更加简洁）。
  * 零配置文件（Spring配置文件）。

### 1.1.2、Spring企业应用组件

* Spring Cloud
* Spring Data
* Spring Security

## 1.2、Spring核心概念

* IoC
  * 控制反转。
  * new对象的权利由使用者创建改为由Spring创建。
  
* DI
  * 依赖注入。
  * 给new出来的对象设置成员变量。
  * Spring若想使用IoC创建对象，必须使用到DI。
  
* AOP
  * 面向切面编程。
  * 将项目中的【业务代码】与【系统代码】进行解耦。
  * 对业务代码进行增强。
  * AOP与OOP(面向对象编程)一样，都是编程思想。
  
* BOP
  * 面向Bean编程。
  * Bean其实就是对应bean标签@Bean注解的类。
  * Bean被Spring通过IoC和DI进行创建和管理。
  * Bean被Spring通过AOP进行功能增强。
  
* 基础容器
  * IoC容器。
  * BeanFactory接口（DefaultListableBeanFactory）。
  
* 高级容器
  * ApplicationContext接口。
  * 实现了BeanFactory接口，只是在接口之外新加了一些高级功能，本质还是BeanFactory。

* 高级容器&基础容器的区别

  * 高级容器对于Bean实例的加载时机是项目启动时。（类似于饿汉式加载，但其本质还是通过懒汉式加载的）
  * 基础容器对于Bean实例的加载时机是第一次被调用时。（懒汉式加载）


# 2、Spring与设计模式

### 2.1、工厂模式

* 使用简单工厂模式去管理bean。

  * 配置Spring配置文件。

  ~~~xml
  <beans>
  		<bean id="student" class="com.blairscott.pojo.Student">
    			<property name="name" value="Jany"></property>
        	<property name="age" value="18"></property>
    	</bean>
  </beans>
  ~~~

  * 创建Bean工厂。

  ~~~java
  public class BeanFactory {
    	private Map<String, Object> map;
    	public void init() {
        	// 读取配置文件，获取bean的信息
      }
    	public Object getBean(String name) {
        	return map.get(name);
      }
  }
  ~~~

# 3、Spring-ioc

## 3.1、从配置文件中获取Bean

* 配置文件

~~~xml
<beans>
		<bean id="student" class="com.blairscott.bean.Student">
  			<property name="name" value="James"></property>
      	<property name="course" ref="course"></property>
  	</bean>
  	<bean id="course" class="com.blairscott.bean.Course">
  			<property name="name" value="spring"></property>
      	<property name="cost" value="5800"></property>
  	</bean>
</beans>
~~~

* 接口：BeanDefinition。

~~~java
public interface BeanDefinition {
  	private List<PropertyValue> list;
}
~~~

* bean标签信息（id、class、init-method、scope）。
* PropertyValue
  * 存储property标签信息。
  * PropertyValue对象中是通过Object类型来存储值，若想具体处理不同类型的值，去判断TypeStringValue和RuntimeBeanReference类型。
  * 属性及对应处理类。
    * name属性。
    * value属性：<font color="blue">TypeStringValue</font>：存储的是property标签的value值（带有类型含义）
    * ref属性：<font color="blue">RuntimeBeanReference</font>：存储的是property标签的ref值（指向另外一个对象）。

~~~java
public class PropertyValue {
		private String name;
		private Object value;
  	// TypedStringValue
  	// RuntimeBeanReference
}
~~~

## 3.2、加载/注册BeanDefinition

* 接口：BeanDefinitionRegistry。

~~~java
public interface BeanDefinitionRegistry {
		private Map<String, Object> map;
  	// 针对BeanDefinition的一系列操作。
}
~~~

* 封装了BeanDefinition的Map集合。
* 提供了对于BeanDefinition的操作接口。

## 3.3、针对BeanDefinition对象进行处理

* 接口：BeanFactoryPostProcessor。
* 标签：`<context:property-placeholder />`

* 处理步骤
  1. 读取properties文件。
  2. 替换BeanDefinition中的`${}`占位符的内容。
  3. 用类PropertyPlaceHolderConfigurer实现接口BeanFactoryPostProcessor。

## 3.4、创建Bean

* 接口：SingletonBeanRegistry。

~~~java
public interface SingletonBeanRegistry {
  	// key：bean的名称
  	// value：bean的实例
  	private Map<String, Object> map;
}
~~~

* 前提：需要读取BeanDefinition信息。
* 创建步骤
  1. Bean的实例化。【new】
  2. Bean的属性填充。【依赖注入】
  3. Bean的初始化。【调用初始化方法】
     * AOP的实现是在Bean初始化之后去实现的。
     * AOP使用的其实是动态代理技术。
     * AOP之后存储到Bean集合的对象是代理对象，而不是原先的对象。

## 3.5、针对Bean实例对象进行处理

* 接口：BeanPostProcessor。

* 使用时机：Bean创建之前、Bean创建之后。
* 使用场景：AOP就是使用BeanPostProcessor实现的。

## 3.6、Spring中Bean实例的完整创建流程

1. Bean的实例化（new）
   * 此处会通过反射去调用构造器去new对象，所以此处可能会发生【构造器循环依赖】。
   * 从java角度来说，该对象已经被new出来了，但是从Spring的角度出发，必须完成三个步骤，该Bean对象才可以被使用。
2. Bean的属性填充（setter）
   * 此处会对成员变量通过setter方法去进行依赖注入，所以此处可能会发生【setter方法循环依赖】。
   * 此处Bean已经被实例化出来，只是没有“暴露”出来被使用而已。
3. Bean的初始化（init）

<font color="red">Spring的单例Bean被创建出来之后，会放入SingleObjects的Map集合中，对外暴露使用。</font>

## 3.7、Spring循环依赖问题

### 3.7.1、构造器循环依赖

~~~java
public class OrderService {
		private UserService userSerivce;
		public OrderService(UserService userSerivce) {
				this.userSerivce = userService;
		}
  	...
}
~~~

~~~java
public class UserSerivce {
		private OrderService orderService;
		public UserService(OrderService orderService) {
				this.orderService = orderService;
		}
  	...
}
~~~

构造器循环依赖无法解决，只能修改依赖关系或者改为set方法去依赖。

### 3.7.2、setter方法循环依赖

~~~java
public class OrderService {
		private UserService userService;
		public void setUserService(UserService userService) {
				this.userService = userService;
		}
  	...
}
~~~

~~~java
public class UserService {
		private OrderService orderService;
		public void setOrderService(OrderService orderService) {
				this.orderService = orderService;
		}
  	...
}
~~~

Spring通过<font color="red">三级缓存</font>[^2]来解决setter方法产生的循环依赖问题。

### 3.7.3、Spring三级缓存

* 第一级缓存：singletonObjects
  * key：veanName
  * value：成品的实例对象，对外暴露使用。

~~~
完全初始化完毕的Bean实例。
第一级缓存存储的是最终的单例Bean，暴露给Spring容器之外的客户端调用的。
~~~

* 第二级缓存：earlySingletonObjects
  * key：beanName
  * value：半成品的实例对象

~~~
只完成Bean实例化的Bean的实例。
二级缓存只需要存储BeanName和提前暴露的Bean的实例的映射关系即可。
第二级缓存存储的是正在创建中的单例Bean，暴露给Spring框架内使用的。
~~~

* 第三级缓存：singletonFactories
  * key：beanName
  * value：提早产生bean实例的对象工（ObjectFactory）

~~~
三级缓存的作用：通过该缓存将只完成Bean实例化的Bean的实例提前暴露，不只是将bean的引用放入缓存中，还需要对该未初始化完成的bean进行一些后置处理(BeanPostProcessor)。三级缓存将暴露的bean处理完成之后，将bean转移到二级缓存中，同时删除三级缓存中的该数据。三级缓存才是解决循环依赖的根本。
三级缓存与二级缓存是互斥的。
第三级缓存存储的是ObjectFactory（工厂对象）。该ObjectFactory是提前保存了正在创建中的Bean实例。
~~~

* ObjectFactory的作用
  * 保存提早暴露的单例Bean的引用。
  * 针对保存的Bean实例，通过BeanPostProcessor进行判断，看一看该Bean是否需要被功能增强，如果需要，则在此时针对该Bean产生代理对象。
  * 将产生的代理对象放入二级缓存，同时删除该beanName对应的三级缓存数据。

~~~
三级缓存中一个beanName在同一时间内只会存在于其中一个缓存中，如果在非循环依赖的场景下，二级缓存和三级缓存是使用不到的。
~~~

### 3.7.4、三级缓存添加/获取对象的顺序

* 添加
  * 第三级缓存：Bean实例化，属性填充之前，经过判断，将Bean实例先封装到ObjectFactory，然后将ObjectFactory放入三级缓存中。
  * 第二级缓存：第一次从第三级缓存中的ObjectFactory中获取保存的Bean实例，获取之后存入第二级缓存，同时删除第三级缓存中的该Bean实例。
  * 第一级缓存：当第一次完整的创建完Bean实例之后，才会放入一级缓存，同时清除二级缓存。
* 获取
  * 先从一级缓存中获取对象
  * 若一级缓存中没有获取到，则再从二级缓存中获取。
  * 若二级缓存中没有获取到，则再从三级缓存中获取。
  * 若三级缓存中没有获取到，则创建对象并添加缓存。

### 3.7.5、举例：创建OrderService类流程

1. <font color="blue">OrderService</font>实例化

   * 如果是单例bean，并且允许引用、允许该beanName存储到singletonCurrentlyInCreation（set集合），那么OrderService对象会提前被暴露给三级缓存保存。

   ~~~
   在1和2之间需要做一个处理：会将刚创建的bean通过ObjectFactory进行暴露，并且将ObjectFactory放入三级缓存。
   ~~~

2. <font color="blue">OrderService</font>属性填充（给变量userService赋值，即调用getBean()）

   1. <font color="green">UserService</font>实例化

   2. <font color="green">UserService</font>属性填充（给变量orderService赋值，即调用getBean()）
* 如果此时找不到OrderService，那么显然会产生死循环，为了解决这个问题，我们需要此时OrderService的实例被找到。
  
* singletonObjects不存放半成品，所以需要一个新的Map集合去存储半成品。为了保证提前暴露的对象和最终的对象是一个，我们需要在获取这个提前暴露的对象的时候，也判断是否进行提前代理。那么这个时候，我们就需要一个第三级缓存。
  
* 此时去三级缓存中，可以找到OrderService对应的ObjectFactory，通过该ObjectFactory获取代理对象获取原对象。换言之，此处已经获取到bean了，只是这个bean还没有完全完成创建。
3. <font color="green">UserService</font>初始化
   
4. <font color="green">UserService</font>实例放入SingletonObjects集合中，对外暴露使用。
   
3. <font color="blue">OrderService</font>初始化

4. <font color="blue">OrderService</font>实例放入SingletonObjects集合中，对外暴露使用。

# 4、Spring-AOP

## 4.1、AOP与OOP

* 定义
  * AOP：面向切面编程。

  * OOP：面向对象编程。

    结论：AOP可以更好的补充OOP的缺点。

* 作用：可以针对目标对象进行无感知[^3]的功能增强。功能一般分为两种：

  * 业务功能：业务操作。

  * 系统功能：如事物、日志等功能。

    结论：AOP是一种编程思路，它可以将业务功能和系统功能进行拆分，以达到“专人干专事”的目标。它的实现产品有多种，如：AspectJ、Spring-AOP、Spring整合AspectJ。

## 4.2、AOP的实现方式

* 静态织入：使用字节码拼接技术，在编译期间，针对目标类对应的class文件进行静态编码（asm）。
* 动态织入：使用动态代理技术，在运行期间，针对目标对象进行动态代理。

## 4.3、AOP的核心概念

* 目标对象

  ~~~java
  // 目标类（目标对象）
  public class UserDao {
  		public void updateUser(User user) {
        	// 用户更新功能
      }
  		public User queryUserById(String userId) {
  				// 用户查找功能
      }
  }
  ~~~

* 增强类

  即前文提到的系统功能，如日志、事物等功能。

* 连接点（JoinPoint）

  ~~~java
  public void updateUser(...) {...}
  public User queryUser(...) {...}
  ~~~

* 切入点（PointCut）

  确定切入点表达式：`execution(* *..*.*(..))`

* 通知

  * 将【指定增强代码】，在切入点目标方法的【指定位置】进行【增强】。通知分为五种：
    * 前置通知
    * 后置通知
    * 环绕通知
    * 最终通知
    * 异常通知

* 代理对象（以前置通知为例）

  ~~~java
  // 代理对象
  public class UserDaoProxy {
    	InvokeHandler invokeHandler;
  		public void updateUser(User user) {
  				this.invokeHandler.invoke(...);
      }
  		public User queryUser(User user) {
  				// ...
      }
  }
  ~~~

  ~~~java
  public class InvokeHandler {
  		public Object invoke(Object proxy, Method method, String[] args) {
        	// 日志功能
        	// UserDao的updateUser或queryUser等方法。
      }
  }
  ~~~

* 切面（Aspect）/通知器（Advisor）

  * 【切入点】与【通知】组成了【切面】

## 4.4、动态代理模式

### 4.4.1、概念说明

* 静态代理与动态代理
  * 静态代理：在编译期间，为目标类编写一个代理类，缺点是会编写很多的代理类。
  * 动态代理：在运行期间，为目标类用动态代理技术，产生一个代理对象。
* 动态代理模式分类
  * JDK动态代理：代理对象和目标对象是实现了同一个接口，故使用JDK动态代理的前提是【目标对象】必须实现某个业务接口。JDK动态代理是Spring默认使用的动态代理模式。
  * CGLib动态代理：代理对象是目标对象的子类，它是通过对目标对象实现即成的方式实现功能增强，不需要【目标对象】实现任何业务接口。

### 4.4.2、JDK动态代理[^4]

* 产生代理对象代码
  
  ~~~java
  // 被代理接口
  public interface PersonService {
    	public void setPerson();
  }
  ~~~
  
  ~~~java
  // 被代理接口实现
  public class PersonServiceImpl implements PersonService {
    	@Override
      public void setPerson() {
          System.out.println("PersonService:setPerson");
      }
  }
  ~~~
  
  ~~~java
  // 增强代码
  public class JDKDynamicProxy implements InvocationHandler {
      private Object target;
      public JDKDynamicProxy(Object target) {
          this.target = target;
      }
  
      // 获取被代理接口实例对象
      public <T> T getProxy() {
          return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(),
                                            target.getClass().getInterfaces(), 
                                            this);
      }
  
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable 
      {
          System.out.println("Do something before");
          Object result = method.invoke(target, args);
          System.out.println("Do something after");
          return result;
      }
  }
  ~~~
  
* 产生代理对象流程`Proxy.newProxyInstance(classloader, interfaces, InvocationHandler);`
  
  1. 通过【反射】获取接口的信息，然后由Java来编写代理实现类的源代码。（.java）
  2. Java通过【API】对其自己写的源代码进行编译。（.class）
  3. 通过【classLoader】，将产生的class文件加载到JVM内存中去。
  4. 在JVM中产生代理对象。
  
* 代理对象调用流程：
  1. 根据通知位置编写增强代码。
  2. 调用目标对象的方法。
  
  ~~~java
  // 调用代理对象
  public class Client {
      public static void main(String[] args) {
          // 保存生成的代理类的字节码文件
          System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
          // jdk动态代理测试
          PersonService service = new PersonServiceImpl(new RealSubject()).getProxy();
          service.doSomething();
      }
  }
  ~~~

### 4.4.3、CGLib动态代理模式[^5]

* CGLib动态代理模式适用于没有接口和非final的目标对象。

* 产生代理对象代码

  ~~~java
  // 被代理对象
  public class PersonService {
      public PersonService() {
          System.out.println("PersonService构造");
      }
      //该方法不能被子类覆盖
      final public Person getPerson(String code) {
          System.out.println("PersonService:getPerson>>"+code);
          return null;
      }
      public void setPerson() {
          System.out.println("PersonService:setPerson");
      }
  }
  ~~~

  ~~~java
  // 自定义MethodInterceptor。(实现MethodInterceptor接口)
  public class CglibProxyIntercepter implements MethodInterceptor {
      @Override
      public Object intercept(Object sub, Method method, 
                              Object[] objects, MethodProxy methodProxy
                             ) throws Throwable {
          System.out.println("执行前...");
          Object object = methodProxy.invokeSuper(sub, objects);
          System.out.println("执行后...");
          return object;
      }
  }
  ~~~

* 产生代理对象流程

  1. 使用ASM工具包去针对目标类的class文件进行修改，产生新的class文件。
  2. 根据新的class文件创建对象。

* 执行代理对象代码

  ~~~java
  // 执行代理对象
  public class Test {
      public static void main(String[] args) {
          //代理类class文件存入本地磁盘
          System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\code");
          Enhancer enhancer = new Enhancer();
          enhancer.setSuperclass(PersonService.class);
          enhancer.setCallback(new CglibProxyIntercepter());
          PersonService proxy= (PersonService) enhancer.create();
          proxy.setPerson();
          proxy.getPerson("1"); 
      } }
  ~~~

### 4.4.4、JDK动态代理与CGLib动态代理模式的区别

* JDK动态代理是【实现】了被代理对象的接口，Cglib是【继承】了被代理对象。
* JDK和Cglib都是在运行期生成字节码，JDK是<u>直接写Class字节码</u>，Cglib使用<u>ASM框架写Class字节码</u>，故Cglib代理实现更复杂，生成代理类比JDK效率低。
* JDK调用代理方法，是通过反射机制调用，Cglib是通过FastClass机制直接调用方法，Cglib执行效率更高。

## 4.5、Spring-Aop的两种用法

~~~xml
<bean id="myAdvice" class="com.bliarscott.advice.MyAdvice"></bean>
~~~

* Spring-Aop

  ~~~xml
  <aop:config>
  	<aop:advisor advice-ref="myAdvice">
    	<aop:before method="before" pointcut="execution(* *..*.*ServiceImpl.*(..))" />
      <aop:after method="after" pointcut="execution(* *..*.*ServiceImpl.*(..))" />
    </aop:advisor>
  </aop:config>
  ~~~

* Spring整合AspectJ

  ~~~xml
  <aop:config>
  	<aop:aspect ref="myAdvice">
    	<aop:before method="before" pointcut="execution(* *..*.*ServiceImpl.*(..))" />
      <aop:after method="after" pointcut="execution(* *..*.*ServiceImpl.*(..))" />
    </aop:aspect>
  </aop:config>
  ~~~

* 解析入口类与入口方法

  * BeanDefinition解析入口

    ~~~java
    class BeanDefinitionParseDelegate {
      	parseCustomElement();
    }
    ~~~

  * AOP代理对象的入口类

    ~~~java
    class AspectJAwareAdvisorAutoProxyCreator implements BeanPostProcessor {}
    ~~~

  * 使用AspectJ表达式完成的切入点对象

    ~~~java
    class AspectJExpressionPointcut {}
    
    // aop:pointcut, aop:after pointcut 等
    ~~~

  * 生成增强类等方法对应的Method对象（如MyAdvice对象的log方法）

    ~~~java
    class MethodLocatingFactoryBean {}
    ~~~

  * 使用实例工厂方式生成增强类的实例（MyAdvice对象）

    ~~~java
    class SimpleBeanFactoryAwareAspectInstanceFactory {}
    ~~~

  * 通知器

    ~~~java
    class AspectJPointcutAdvisor {}
    ~~~

  
  * 创建代理对象的入口
  
    ~~~java
    class AbstractAutoProxyCreator {
      	postProcessAfterInitialization();
    }
    ~~~
  
  * 其他
  
    ~~~java
    class AbstractAdvisorAutoProxyCreator {}
    ~~~

## 4.6、产生AOP代理对象的逻辑

1. 先产生代理对象（Bean的三部曲）

2. 找到容器中所有的advisor集合。

3. 从所有的advisor中找到可以针对该目标对象进行增强的advisor候选集合。（使用classFilter和MethodMatcher）

4. 将这些advisor中获取advice，然后将advice封装成MethodInterceptor。

5. 将MethodInterceptor集合封装到MethodInvocation对象中

   * 【MethodInterceptor】负责拦截逻辑的处理。
   * 【MethodInvocation】负责Advice的调用。
   * 【MethodInterceptor】和【MethodInvocation】控制多个Advice的顺序执行。




# 5、源码入口

* spring-ioc

~~~java
class AbstractAutowireCapableBeanFactory{ doCreateBean(); }
~~~

* spring aop

  * 执行时机：发生在ioc三步创建流程中的第三步初始化之后去触发aop流程

  * 产生代理对象的流程的入口

    * spectJAwareAdvisorAutoProxyCreator接口继承体系

    ~~~java
    class BeanPostProcessor{
    		postProcessBeforeInitialization(); // 初始化之前调用
    		postProcessAfterInitialization(); // 初始化之后调用
    }
    
    class InstantiationAwareBeanPostProcessor{
      	postProcessBeforeInstantiation(); // 实例化之前调用
    		postProcessAfterInstantiation(); //实例化之后调用
    		postProcessPropertyValues(); // 后置处理属性值
    }
    
    class SmartInstantiationAwareBeanPostProcessor{
      	predictBeanType();
      	determineCandidateConstructors();
      	getEarlyBeanReference();
    }
    
    class AbstractAutoProxyCreator {
      	postProcessBeforeInitialization();
      	postProcessAfterInitialization(); // AOP功能入口
      	postProcessBeforeInstantiation();
      	postProcessAfterInstantiation();
      	postProcessPropertyValues();
      	...
    }
    
    class AbstractAdvisorAutoProxyCreator {
        getAdvicesAndAdvisorsForBean();
        findEligibleAdvisors();
        findCandidateAdvisors();
        findAdvisorsThatCanApply();
    }
    
    class AspectJAwareAdvisorAutoProxyCreator {
      	extendAdvisors();
      	sortAdvisors();
    }
    ~~~

    * aop流程入口

    ~~~java
    class AbstractAutoProxyCreator {
      	postProcessAfterInitialization();
    }
    // 核心类
    * AbstractAutoProxyCreator // 负责创建代理对象的创建器
    	* ProxyFactory // 代理对象工厂
    		* ProxyCreatorSupport // 产生AopProxy的工厂类
    			* AopProxy // 真正的代理对象产生的工厂，它本身还是InvocationHandler接口的实现类。
    				* JdkDynamicAopProxy // 产生jdk代理对象的: Object proxy;
    				* ObjenesisCglibAopProxy // 产生cglib代理对象的: Object proxy
    ~~~

* 事务源码阅读

  ~~~java
  TxAdviceBeanDefinitionParser#doParse();
  PlatformTransactionManager
  ~~~

  

# #、思考题

* 如果一个目标对象被AOP动态添加代理对象（如事物增强功能），那么Spring容器中存储的是（B）

  A、目标对象

  B、增强之后的对象

  C、都存储

* AOP针对目标对象产生代理对象，是发生在Bean创建的哪个流程呢？

  <table><tr><td bgcolor="#F8F8F8">答：是发生在Bean的初始化的过程中，具体说，是发生在Bean调用初始化方法之后，去进行AOP流程。</td></tr></table>

* 如果invoke方法和intercept方法是我们程序员写好的，那么如何保证功能的扩展性？

  <table><tr><td bgcolor="#F8F8F8">1、通过配置去确定哪些通知（前置、后置、环绕等）。</td></tr><tr><td bgcolor="#F8F8F8">2、通过一定的逻辑（执行链条：MethodInvocation和MethodInterceptor）去控制多个通知的执行顺序。</td></tr></table>

* 【多个前置通知】的执行顺序如何保证？

* 一个【前置通知】和一个【后置通知】的执行顺序如何保证。

* 为什么要用classloader

  <table><tr><td bgcolor="#F8F8F8">答：编译源文件为class文件，ClassLoader将class文件加载到jvm中 。</td></tr></table>

* 如何保存生成的代理类

  <table><tr><td bgcolor="#F8F8F8">改参数 sun.misc.ProxyGenerator.saveGeneratedFiles。</td></tr></table>

* 抽象类能被代理吗

  <table><tr><td bgcolor="#F8F8F8">不能</td></tr></table>

* BeanFactory与FactoryBean的区别

  ~~~
  BeanFactory：工厂，是ioc容器的基础。可以管理和创建任意类型的对象。
  FactoryBean：特殊的Bean，存在于ioc容器中，也就是存在于BeanFactory。FactoryBean只能针对某一类bean进行创建。
  通过BeanFactory去管理的bean实例，都需要在xml中或者注解方式进行配置。如果一个bean装配过程特别复杂，那么xml配置可能很复杂，对于这种情况，spring就提供了一个专门针对复杂的bean进行生产的对象，就是FactoryBean，FactoryBean只能针对某一类bean进行创建。而BeanFactory可以创建任意对象。
  ~~~

* BeanFactoryPostProcessor和BeanPostProcessor的区别

  * BeanFactoryPostProcessor

    * 执行时机

      在BeanDefinition未被用来创建对象之前，可以针对BeanDefinition进行修改，比如

      ~~~java
      PropertyPlaceholderConfigurer // <context:property-placeholder />
      ~~~

      就是实现了BeanFactoryPostProcessor，那么该类就对BeanDefinition进行了修改。

    * 具体的修改

      判断BeanDefinition中的属性值是否带有${},如果带有，则根据其他的key去获取properties配置文件中的value值，进行替换。

  * BeanPostProcessor

    * 执行时机

      在Bean已经被创建完成属性填充，在bean初始化的时候被调用。初始化之前和初始化之后。比如AbstractAspectJAutoProxyCreator就实现了BeanPostProcessor，它的作用就是对已经创建的bean进行aop切面操作。
  
* Spring-aop

  * 什么时候产生代理对象？

    IOC容器创建Bean的时候，会触发AOP，产生代理对象，放入IOC容器。

  * 什么时候调用代理对象？

    当第一次调用目标类接口的实例的时候，才第一次去调用代理对象。

  * 有没有可能产生了代理对象，却从来没使用过？

    完全可能。

  * 目标对象处理逻辑在哪？换言之，在哪个类组织增强代码和目标代码的结合呢？

    InvocationHandler#invoke方法。（JDK动态代理：JdkDynamicAopProxy#invoke）

---

[^1]:更多可见：https://spring.io/

[^2]:参考Spring类DefaultSingletonBeanRegistry
[^3]:即不修改目标对象的代码的情况下。
[^4]:详情见：https://www.cnblogs.com/zuidongfeng/p/8735241.html
[^5]:详情见：https://www.cnblogs.com/monkey0307/p/8328821.html

第五章第二节片段一34:00