package client;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {


	public static void main(String[] args) throws IOException, InterruptedException {


		ExecutorService exec = Executors.newFixedThreadPool(1);
		//int j = 0;

		//while (j < 2) {
		//	j++;
			exec.execute(new DefaultClient());
			Thread.sleep(10);
		//}

		exec.shutdown();
	}
}
