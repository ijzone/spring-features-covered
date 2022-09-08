package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import spring.aop.entity.Exam;

public class Program {

	public static void main(String[] args) {
		Exam examScore = new ExamScore(1, 1, 1, 1);
		
		Exam proxy = (Exam) Proxy.newProxyInstance(ExamScore.class.getClassLoader(), 
				new Class[] {Exam.class}, 
				new InvocationHandler() {
					
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						long start = System.currentTimeMillis();
						
						Object result = method.invoke(examScore, args);
						
						try {
							Thread.sleep(200);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
						long end = System.currentTimeMillis();
						
						String message = (end - start) + "ms 걸렸습니다.";
						System.out.println(message);
						
						return result;
					}
				});
		
		System.out.printf("total is %d\n", proxy.total());
		System.out.printf("avg is %f\n", proxy.avg());
	}
}
