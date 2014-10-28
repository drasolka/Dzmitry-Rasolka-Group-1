package com.epam.mentoring.concurrency;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

import org.apache.log4j.Logger;

import com.epam.mentoring.concurrency.model.bank.Bank;
import com.epam.mentoring.concurrency.model.person.Person;
import com.epam.mentoring.concurrency.task.FileReadTask;
import com.epam.mentoring.concurrency.task.FileWriteTask;

public class App {

	private static final Logger logger = Logger.getLogger(App.class);

	private static final String USER_DIR = "user.dir";
	private static final String WORK_DIR = System.getProperty(USER_DIR);

	private static final String POINT1_MENU = "Push '1' to create new Person";
	private static final String POINT1_MENU_MESSAGE = "Please enter Email user";

	private static final String POINT2_MENU = "Push '2' to open account";
	private static final String POINT2_MENU_MESSAGE1 = "Please enter Email existing user";
	private static final String POINT2_MENU_MESSAGE2 = "Please enter currency ('usd','eur')";
	private static final String POINT2_MENU_MESSAGE3 = "Please enter amount";
	private static final String POINT2_MENU_MESSAGE_ERROR1 = "ERROR: user with this email isn't found";

	private static final String POINT3_MENU = "Push '3' to exchange currency";
	private static final String POINT3_MENU_MESSAGE1 = "Please enter user's email in Account";
	private static final String POINT3_MENU_MESSAGE2 = "Please enter desired currency";
	private static final String POINT3_MENU_MESSAGE2_ERROR1 = "ERROR: account with this email isn't found";
	private static final String POINT3_MENU_MESSAGE2_ERROR2 = "ERROR: you entered the same currency";

	private static final String POINT4_MENU = "Push '4' to save and exit";

	private static final String ERROR_MESSAGE = "Please enter a correct value:";

	private static final String BANK_MODEL = "bank";
	private static final String CURRENCY_MODEL = "currency";
	private static final String ACCOUNT_MODEL = "account";
	private static final String PERSON_MODEL = "person";

	private static final String EXTENSION = ".txt";

	public static void main(final String[] args) throws InterruptedException,
			ExecutionException {

		final int threadCount = 17;

		// for read
		final BlockingQueue<String> currencyQueue = new ArrayBlockingQueue<>(2);
		final BlockingQueue<String> personQueue = new ArrayBlockingQueue<>(2);
		final BlockingQueue<String> accountQueue = new ArrayBlockingQueue<>(1);
		final BlockingQueue<String> bankQueue = new ArrayBlockingQueue<>(1);

		// for save

		final BlockingQueue<String> writeCurrencyQueue = new ArrayBlockingQueue<>(
				2);
		final BlockingQueue<String> writePersonQueue = new ArrayBlockingQueue<>(
				1);
		final BlockingQueue<String> writeAccountQueue = new ArrayBlockingQueue<>(
				1);
		final BlockingQueue<String> writeBankQueue = new ArrayBlockingQueue<>(1);

		/*
		 * final ExecutorService service = Executors
		 * .newFixedThreadPool(threadCount);
		 */

		final Bank bank = new Bank();
		final List<Person> persons = new CopyOnWriteArrayList<>();

		/*
		 * service.submit(new PopulatePersonModelTask(personQueue, persons));
		 * service.submit( new FileReadTask(personQueue, WORK_DIR + "/" +
		 * PERSON_MODEL + EXTENSION)).get();
		 * 
		 * service.submit(new PopulateBankModelTask(bankQueue, bank, persons,
		 * BANK_MODEL)); service.submit( new FileReadTask(bankQueue, WORK_DIR +
		 * "/" + BANK_MODEL + EXTENSION)).get();
		 * 
		 * service.submit(new PopulateBankModelTask(currencyQueue, bank,
		 * persons, CURRENCY_MODEL)); service.submit( new
		 * FileReadTask(currencyQueue, WORK_DIR + "/" + CURRENCY_MODEL +
		 * EXTENSION)).get();
		 * 
		 * service.submit(new PopulateBankModelTask(accountQueue, bank, persons,
		 * ACCOUNT_MODEL)); service.submit( new FileReadTask(accountQueue,
		 * WORK_DIR + "/" + ACCOUNT_MODEL + EXTENSION)).get();
		 */

		/*
		 * final Thread th1 = new Thread(new
		 * PopulatePersonModelTask(personQueue, persons), "PopultaModel");
		 */

		final Thread th2 = new Thread(new FileReadTask(personQueue, WORK_DIR
				+ "/" + PERSON_MODEL + EXTENSION), "FileReadTask");

		final Thread th3 = new Thread(new FileWriteTask(writePersonQueue,
				WORK_DIR + "/" + PERSON_MODEL + EXTENSION), "FileWriteTask");

		/*
		 * final Thread th4 = new Thread(new SaveModelTask(writePersonQueue,
		 * bank, persons, PERSON_MODEL), "SaveModel");
		 */

		// th1.start();
		th2.start();
		th3.start();
		// th4.start();

		System.out.println("-------------------------------------------");

		final Scanner scanner = new Scanner(System.in);

		for (;;) {
			System.out.println("\n" + POINT1_MENU);
			System.out.println("\n" + POINT2_MENU);
			System.out.println("\n" + POINT3_MENU);
			System.out.println("\n" + POINT4_MENU);

			final int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				// persons = new CopyOnWriteArrayList<>();
				/*
				 * new Thread(new FileReadTask(personQueue, WORK_DIR + "/" +
				 * PERSON_MODEL + EXTENSION), "FileReadTask").start();
				 */
				/*
				 * new Thread(new FileReadTask(personQueue, WORK_DIR + "/" +
				 * PERSON_MODEL + EXTENSION), "FileReadTask1").start();
				 */

				logger.info(POINT1_MENU_MESSAGE);
				final String line = scanner.next();

				writePersonQueue.put(line);

				// new Thread(new SaveModelTask(writePersonQueue, bank, persons,
				// PERSON_MODEL), "SaveModel").start();

				break;
			case 2:
				/*
				 * logger.info(POINT2_MENU_MESSAGE1); final String email =
				 * scanner.next(); logger.info(POINT2_MENU_MESSAGE2); final
				 * String currencyCode = scanner.next();
				 * logger.info(POINT2_MENU_MESSAGE3); final String amount =
				 * scanner.next();
				 * 
				 * final Person person = BankUtil.hasPerson(persons, email);
				 * final Currency curr = BankUtil.getCurrency(bank,
				 * currencyCode); if (person != null) { bank.getAccounts().add(
				 * new Account(person, curr, Double.valueOf(amount)));
				 * 
				 * } else { logger.info(POINT2_MENU_MESSAGE_ERROR1); } break;
				 */
			case 3:
				/*
				 * logger.info(POINT3_MENU_MESSAGE1); final String emailAccount
				 * = scanner.next(); logger.info(POINT3_MENU_MESSAGE2); final
				 * String desiredCurrencyCode = scanner.next();
				 * 
				 * final Account account = BankUtil.hasAccount(emailAccount,
				 * bank); final Currency desiredCurrency =
				 * BankUtil.getCurrency(bank, desiredCurrencyCode); if (account
				 * != null) { if (account.getCurrency().getIsoCode()
				 * .equals(desiredCurrencyCode)) {
				 * logger.info(POINT3_MENU_MESSAGE2_ERROR2); } else { final
				 * Double newAmount = BankUtil.convertCurrency(
				 * account.getAmount(), bank, desiredCurrencyCode);
				 * account.setCurrency(desiredCurrency);
				 * account.setAmount(newAmount); } } else {
				 * logger.info(POINT3_MENU_MESSAGE2_ERROR1); } break;
				 */
			case 4:
				// WRITE IN FILE
				/*
				 * service.submit(new FileWriteTask(currencyQueue, WORK_DIR +
				 * "/" + CURRENCY_MODEL + EXTENSION)); service.submit( new
				 * SaveModelTask(currencyQueue, bank, persons,
				 * CURRENCY_MODEL)).get();
				 * 
				 * service.submit(new FileWriteTask(bankQueue, WORK_DIR + "/" +
				 * BANK_MODEL + EXTENSION)); service.submit( new
				 * SaveModelTask(bankQueue, bank, persons, BANK_MODEL)) .get();
				 * 
				 * service.submit(new FileWriteTask(accountQueue, WORK_DIR + "/"
				 * + ACCOUNT_MODEL + EXTENSION)); service.submit( new
				 * SaveModelTask(accountQueue, bank, persons,
				 * ACCOUNT_MODEL)).get();
				 * 
				 * service.submit(new FileWriteTask(personQueue, WORK_DIR + "/"
				 * + PERSON_MODEL + EXTENSION)); service.submit( new
				 * SaveModelTask(personQueue, bank, persons,
				 * PERSON_MODEL)).get(); service.shutdownNow();
				 * service.awaitTermination(365, TimeUnit.DAYS);
				 * 
				 * service.shutdownNow(); service.awaitTermination(365,
				 * TimeUnit.DAYS);
				 */
				System.exit(0);
				break;
			default:
				logger.info(ERROR_MESSAGE);

			}
		}

	}
}
