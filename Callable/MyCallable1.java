import java.util.concurrent.*;
import java.util.*;

class MyCallable1 implements Callable{
	public String call()throws Exception{
		System.out.println(Thread.currentThread().getName()+"starts");
		Thread.sleep(2000);
		System.out.println(Thread.currentThread().getName()+"ends");
		//return name of threads
		return (Thread.currentThread().getName());
	}
}

class MyCallableTest{
	public static void main(String... ss){
		ExecutorService executor=Executors.newFixedThreadPool(5);
		//collect to store results
		ArrayList<Future<String>> list=new ArrayList<Future<String>>();
		//Future list[]=new Future[10]
		for(int i=0; i<10; i++){
			Future<String> future =executor.submit(new MyCallable1());
			list.add(future);
			//list[i]=executor.submit(new MyCallable1());
		}
		//print results
		for(Future<String> future:list){
			try{
				System.out.println(future.get());
			}catch(Exception e){
				
			}
		}
		executor.shutdown();
	}
}