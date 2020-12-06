
public class ThreadCountRemake extends Thread {
	
	int count, max;

	ThreadCountRemake(int _max) {
		this.count = 1;
		this.max = _max;
	}

	@Override
	public void run() {
		while (this.count != this.max) {
			System.out.println("Conteo de Remake en " + this.count);
			this.count++;
		}
	}
}
