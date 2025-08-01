import java.util.concurrent.CountDownLatch;
public class HRManager{
	public static void main(String... ss){
		CountDownLatch countDownLatch=new CountDownLatch(3);
		TechLead techLead1=new TechLead(countDownLatch, "salauddin");
		TechLead techLead2=new TechLead(countDownLatch,"bashir");
		TechLead techLead3=new TechLead(countDownLatch, "asrar");
		techLead1.start();
		techLead2.start();
		techLead3.start();
		
		try{
			System.out.println("Hr manager waiting go recruitment to complete..");
			countDownLatch.await();
			System.out.println("Distribute Offer Letter");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
}

class TechLead extends Thread{
	CountDownLatch countDownLatch;
	public TechLead(CountDownLatch countDownLatch, String name){
		super(name);
		this.countDownLatch=countDownLatch;
	}
	@Override
	public void run(){
		try{
			Thread.sleep(2000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+": recruited");
		countDownLatch.countDown();
		try{
			Thread.sleep(300);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+":dead");
	}
}