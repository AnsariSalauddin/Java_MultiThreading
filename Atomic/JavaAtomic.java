import java.util.concurrent.atomic.AtomicInteger;
public class JavaAtomic{
	public static void main(String... ss)throws InterruptedException{
		ProcessingThread pt=new ProcessingThread();
		Thread t1=new Thread(pt,"t1");
		t1.start();
		Thread t2=new  Thread(pt,"t2");
		t2.start();
		t1.join();
		t2.join();
		System.out.print("Processing count="+pt.getCount());
	}
}

class ProcessingThread implements Runnable{
	private AtomicInteger count=new AtomicInteger();
	// int count;
	@Override
	public void run(){
		for(int i=1; i<5; i++){
			System.out.println("hello");
			processSomething(i);
			count.incrementAndGet();
		}
	}
	public int getCount(){
		return this.count.get();
	}
	
	private void processSomething(int i){
		//processing some job
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			
		}
	}
}