package threadpkg;

//public class ThreadSample extends Thread {
	
public class ThreadSample implements Runnable {

//	@Override
//	public synchronized void run() {
//		for (int i=0;i<3;i++)
//		{
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			System.out.println("Thread "+Thread.currentThread().getName() +" value is "+i);
//		}
//		
//	}
	
	
	@Override
	public void run() {
		synchronized(this)
		{
			try 
			{
				System.out.println("Thread going to sleep"+Thread.currentThread().getName());
				Thread.sleep(3000);
				synchronized(this)
				{
					this.notifyAll();;
			
				}	
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void letsWait() {
		System.out.println("Thread entered in wait : "+Thread.currentThread().getName());
		synchronized(this)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Thread wake up : "+Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		
		
		ThreadSample obj= new ThreadSample();
		
		Thread t1= new Thread(obj);
		t1.setName("A"); 
//		Thread t2= new Thread(obj);
//		t2.setName("B");
//		Thread t3= new Thread(obj);
//		t3.setName("C");
		t1.start();
		obj.letsWait();
//		t2.start();
//		t3.start();
	}
	

}
