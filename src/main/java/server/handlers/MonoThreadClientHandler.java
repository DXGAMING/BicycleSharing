package server.handlers;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import facades.UserCreationFacade;

import facades.impl.UserCreationFacadeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class MonoThreadClientHandler implements Runnable
{
	private static Socket clientDialog;
	private static final Logger LOG = LoggerFactory.getLogger(MonoThreadClientHandler.class);

	private UserCreationFacade userCreationFacade;
	public MonoThreadClientHandler(Socket client)
	{
		MonoThreadClientHandler.clientDialog = client;
		userCreationFacade = new UserCreationFacadeImpl();
	}
	@Override
	public void run()
	{
		try
		{
			// инициируем каналы общения в сокете, для сервера

			// канал чтения из сокета
			DataInputStream in = new DataInputStream(clientDialog.getInputStream());
			LOG.info("DataInputStream created");

			// канал записи в сокет
			DataOutputStream out = new DataOutputStream(clientDialog.getOutputStream());
			LOG.info("DataOutputStream  created");

			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// основная рабочая часть //
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			// начинаем диалог с подключенным клиентом в цикле, пока сокет не
			// закрыт клиентом
			while (!clientDialog.isClosed())
			{
				LOG.info("Server reading from channel");

				// серверная нить ждёт в канале чтения (inputstream) получения
				// данных клиента после получения данных считывает их
				String entry = in.readUTF();

				// и выводит в консоль
				LOG.info("READ from clientDialog message {}", entry);

				// инициализация проверки условия продолжения работы с клиентом
				// по этому сокету по кодовому слову - quit в любом регистре
				if (entry.equalsIgnoreCase("entrance"))
				{
					Thread.sleep(10);
					out.writeUTF("enter");
					out.flush();
					Thread.sleep(10);
					String userData = in.readUTF();
					userCreationFacade.createUser(false,userData);
					out.writeUTF("userCreated");
					out.flush();
				}
				if (entry.equalsIgnoreCase("quit"))
				{

					// если кодовое слово получено то инициализируется закрытие
					// серверной нити
					LOG.info("Client initialize connections suicide ...");
					out.writeUTF("Server reply - " + entry + " - OK");
					Thread.sleep(3000);
					break;
				}

				// если условие окончания работы не верно - продолжаем работу -
				// отправляем эхо обратно клиенту

				System.out.println("Server try writing to channel");
				out.writeUTF("Server reply - " + entry + " - OK");
				System.out.println("Server Wrote message to clientDialog.");

				// освобождаем буфер сетевых сообщений
				out.flush();

				// возвращаемся в началло для считывания нового сообщения
			}

			///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			// основная рабочая часть //
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			// если условие выхода - верно выключаем соединения
			System.out.println("Client disconnected");
			System.out.println("Closing connections & channels.");

			// закрываем сначала каналы сокета !
			in.close();
			out.close();

			// потом закрываем сокет общения с клиентом в нити моносервера
			clientDialog.close();

			System.out.println("Closing connections & channels - DONE.");
		}
		catch (IOException | InterruptedException e)
		{
			LOG.error(e.getMessage());
		}
	}
}
