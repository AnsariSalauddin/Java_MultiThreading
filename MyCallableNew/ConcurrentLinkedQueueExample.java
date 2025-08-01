import java.util.concurrent.*;

public class ConcurrentLinkedQueueExample{
	public static void main(String... args){
		ConcurrentLinkedQueue<String> queue=new ConcurrentLinkedQueue<String>();
		Thread producer=new Thread(new Producer(queue));
		Thread consumer=new Thread(new Consumer(queue));
		producer.start();
		consumer.start();
	}
}

class Producer implements Runnable{
	ConcurrentLinkedQueue<String> queue;
	Producer(ConcurrentLinkedQueue<String> queue){
		this.queue=queue;
	}
	
	public void run(){
		System.out.println("Producer Started");
		try{
			for(int i=0; i<10; i++){
				System.out.println("Added:String"+i);
				Thread.currentThread().sleep(1000);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

//the consumer remove string from the queue
class Consumer implements Runnable{
	ConcurrentLinkedQueue<String> queue;
	Consumer(ConcurrentLinkedQueue<String> queue){
		this.queue=queue;
	}
	public void run(){
		String str;
		System.out.println("Consumer started");
		for(int x=0; x<10; x++){
			while((str=queue.poll())!=null){
				System.out.println("Removed:"+str);
			}
			try{
				Thread.currentThread().sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}