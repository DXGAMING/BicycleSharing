package client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import server.DefaultServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class DefaultClient implements Runnable
{
	private static final Logger LOG = LoggerFactory.getLogger(DefaultServer.class);

	static Socket socket;

	public DefaultClient()
	{
		try
		{

			// создаём сокет общения на стороне клиента в конструкторе объекта
			socket = new Socket("localhost", 3345);
			System.out.println("Client connected to socket");
			Thread.sleep(2000);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run()
	{

		try (

				// создаём объект для записи строк в созданный скокет, для
				// чтения строк из сокета
				// в try-with-resources стиле
				DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
				DataInputStream ois = new DataInputStream(socket.getInputStream()))
		{
			System.out.println("Client oos & ois initialized");

			int i = 0;
			// создаём рабочий цикл
			while (i < 5)
			{

				oos.writeUTF("entrance");
				oos.flush();
				Thread.sleep(10);
				if(ois.readUTF().equals("enter"))
				{
					LOG.info("Entering user data");
					oos.writeUTF("Имя|Фамилия|375|MP|password");
				}
				// проталкиваем сообщение из буфера сетевых сообщений в канал
				oos.flush();
				// ждём чтобы сервер успел прочесть сообщение из сокета и
				// ответить
				Thread.sleep(10);

				System.out.println("loading...");
				String in = ois.readUTF();
				System.out.println(in);
				i++;
				Thread.sleep(5000);

			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
