
public class ThreadCount extends Thread {

	int count, max;

	ThreadCount(int _max) {
		this.count = 1;
		this.max = _max;
	}

	@Override
	public void run() {
		while (this.count != this.max) {
			System.out.println("Conteo en " + this.count);
			this.count++;
		}
	}
}
