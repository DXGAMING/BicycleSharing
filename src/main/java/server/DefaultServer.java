package server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import server.handlers.MonoThreadClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author Komik Dzmitry
 */
public class DefaultServer
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultServer.class);

	private static ExecutorService executeIt = Executors.newFixedThreadPool(2);
	public static void main(String[] args)
	{
		try (ServerSocket server= new ServerSocket(3345))
		{



			while (!server.isClosed()) {
				Socket client = server.accept();
				executeIt.execute(new MonoThreadClientHandler(client));
				LOG.info("Connection accepted.");
			}

			executeIt.shutdown();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
