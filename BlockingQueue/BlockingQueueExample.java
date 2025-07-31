package BlockingQueue;

/* the eample uses the ArrayblockingQueue implemention of the BlockingQueue interface.
The BlockingQueueExample class starts a Producer and a Consumer in separate threads
The Producer inserts string into a shared BlockingQueue while ithe Consumer takes them out. 

*/

import java.util.concurrent.*;
public class BlockingQueueExample{
	public static void main(String... sss)throws Exception {
		BlockingQueue queue=new ArrayBlockingQueue(5);
		Producer producer=new Producer(queue);
		Consumer consumer =new Consumer(queue);
		System.out.println("starting producer");
		new Thread(producer).start();
		System.out.println("Starting consumer");
		new Thread(consumer).start();
	}
}

//producer class. It sleeeps 3 seconds between each put() call.
//this will cuase the consumer to block, while waiting for object in the queue
class Producer implements Runnable{
	protected BlockingQueue queue=null;
	public Producer(BlockingQueue queue){
		this.queue=queue;
	}
	
	public void run(){
		try{
			queue.put("String one");
			Thread.sleep(3000);
			queue.put("String two");
			Thread.sleep(3000);
			queue.put("string three");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

//consumer class. It takes out the object from the queue
// and prints them to System.out
class Consumer implements Runnable{
	protected BlockingQueue queue=null;
	public Consumer(BlockingQueue queue){
		this.queue=queue;
	}
	
	public void run(){
		try{
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}
