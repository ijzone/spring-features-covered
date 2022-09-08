package spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Exam;

public class Program {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("spring/aop/setting.xml");
//				new AnnotationConfigApplicationContext();
		
		Exam proxy = (Exam) context.getBean("proxy");
		System.out.printf("total is %d\n", proxy.total());
		System.out.printf("avg is %f\n", proxy.avg());
		
		/*
		 * Exam examScore = new ExamScore(1, 1, 1, 1);
		 * 
		 * Exam proxy = (Exam) Proxy.newProxyInstance(ExamScore.class.getClassLoader(),
		 * new Class[] {Exam.class}, new InvocationHandler() {
		 * 
		 * @Override public Object invoke(Object proxy, Method method, Object[] args)
		 * throws Throwable { long start = System.currentTimeMillis();
		 * 
		 * Object result = method.invoke(examScore, args);
		 * 
		 * long end = System.currentTimeMillis();
		 * 
		 * String message = (end - start) + "ms 걸렸습니다."; System.out.println(message);
		 * 
		 * return result; } });
		 */
		
//		System.out.printf("total is %d\n", examScore.total());
//		System.out.printf("avg is %f\n", examScore.avg());
	}
}
