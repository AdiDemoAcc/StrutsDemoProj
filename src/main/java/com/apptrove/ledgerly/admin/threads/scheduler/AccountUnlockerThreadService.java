package com.apptrove.ledgerly.admin.threads.scheduler;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.apptrove.ledgerly.admin.models.User;
import com.apptrove.ledgerly.login.dao.LoginDaoImpl;

public class AccountUnlockerThreadService implements Runnable {

	private final LoginDaoImpl loginDaoImpl;

	private static final Logger logger = LogManager.getLogger(AccountUnlockerThreadService.class);

	public AccountUnlockerThreadService(LoginDaoImpl loginDaoImpl) {
		super();
		this.loginDaoImpl = loginDaoImpl;
	}

	private ScheduledExecutorService accountUnlockerThread;

	public void startScheduler() {
		if (accountUnlockerThread == null || accountUnlockerThread.isShutdown()) {
			accountUnlockerThread = Executors.newScheduledThreadPool(1);
			accountUnlockerThread.scheduleAtFixedRate(this, 0, 1, TimeUnit.HOURS);
			logger.info("AccountUnlockerThread service started....");
		}
	}

	public void stopScheduler() {
		if (accountUnlockerThread != null) {
			accountUnlockerThread.shutdown();
			try {
				if (!accountUnlockerThread.awaitTermination(60, TimeUnit.SECONDS)) {
					logger.warn("Scheduler did not terminate in time, forcing shutdown...");
					accountUnlockerThread.shutdownNow();
															
				}
			} catch (InterruptedException e) {
				logger.error("Scheduler shutdown interrupted, forcing shutdown...", e);
				accountUnlockerThread.shutdownNow();
				Thread.currentThread().interrupt();
			}
			logger.info("AccountUnlockerThreadService stopped.");
		}
	}

	@Override
	public void run() {
		logger.info("Starting AccountUnlockerThread to check locked accounts...");
		List<User> userList;
		try {
			userList = loginDaoImpl.getLockedAccounts();
			logger.info("Found {} locked account(s).", userList.size());

			for (User user : userList) {
				Date now = new Date();
				long timeDiff = now.getTime() - user.getLastLoginDate().getTime();
				long oneHourDiff = 60 * 60 * 1000;

				if (timeDiff > oneHourDiff) {
					logger.info("Attempting to unlock account with username: " + user.getUsername()+ " :::::::::::::::::::::::::::::::::::::::::::::::");
					boolean flag = loginDaoImpl.unlockUserAccount(user.getUsername());
					if (flag) {
						logger.info("Account with username: "+user.getUsername()+" successfully unlocked!");
					} else {
						logger.error("Something went wrong. Try Again later.");
					}
				} else {
					logger.info("Account {} will be unlocked in {} minutes.", user.getUsername(), (oneHourDiff - timeDiff) / (1000 * 60));
				}
			}
		} catch (Exception e) {
			 logger.error("An error occurred while unlocking accounts: ", e);
			e.printStackTrace();
		}

	}

}
