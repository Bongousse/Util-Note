package test;

public class note {
	/**
	 * 실시간 모임 거래내역 업데이트.
	 */
	/*
	 * @Override
	 * 
	 * @Transactional public void realTimeUpdateCircleBankTransaction(Circle
	 * circle, User user, BankAccount bankAccount) {
	 * 
	 * CircleBankAccount circleBankAccount =
	 * getCircleBankAccount(circle.getId());
	 * 
	 * BankAccount currentBankAccount = bankAccount; if (currentBankAccount ==
	 * null) { currentBankAccount =
	 * getBankAccount(circleBankAccount.getBankAccountId()); }
	 * 
	 * User accountOwner = user; if (accountOwner == null) { accountOwner =
	 * getAccountOwner(circle.getId()); }
	 * 
	 * // 모임의 마지막 거래내역 조회. CircleTransaction latest =
	 * createLatestCircleTransaction(circle, user, currentBankAccount);
	 * 
	 * String fintechUseNum = currentBankAccount.getFintechUseNum();
	 * 
	 * // 거래내역 조회에 대한 로그를 조회. // 거래내역 조회에 대한 로그가 없는 경우 (fromDate: 마지막 거래내역 발생시간,
	 * toDate: 현재시간) 생성. // 거래내역 조회에 대한 로그가 있는 경우 (fromDate: 로그의 toDate, toDate:
	 * 현재시간) 수정. BankTransactionRequestLog requestLog =
	 * requestLogRepository.findOne(fintechUseNum); Instant fromDate =
	 * latest.getCreatedAt(); Instant toDate = TimeUtils.kstNow().toInstant();
	 * 
	 * if (requestLog == null) { requestLog = new
	 * BankTransactionRequestLog(fintechUseNum); } else { fromDate =
	 * requestLog.getToDate(); }
	 * 
	 * requestLog.setFromDate(fromDate); requestLog.setToDate(toDate);
	 * requestLogRepository.save(requestLog);
	 * 
	 * // 거래내역 실시간 조회. List<BankTransaction> bankTransactions =
	 * pullBankTransactions(accountOwner, currentBankAccount, circle,
	 * requestLog);
	 * 
	 * if (CollectionUtils.isEmpty(bankTransactions)) { Long amount =
	 * latest.getBankTransaction().getAfterBalanceAmount(); BankTransaction
	 * daily = createDailyTypedTransaction(currentBankAccount,
	 * TimeUtils.kstTime(toDate), amount); bankTransactions.add(daily); }
	 * 
	 * create(circle, bankTransactions); }
	 * 
	 *//**
		 * 일일 모임 거래내역 업데이트.
		 */
	/*
	 * @Override
	 * 
	 * @Transactional public void dailyUpdateCircleBankTransaction(Circle
	 * circle, User user, BankAccount bankAccount) {
	 * 
	 * CircleBankAccount circleBankAccount =
	 * getCircleBankAccount(circle.getId());
	 * 
	 * BankAccount currentBankAccount = bankAccount; if (currentBankAccount ==
	 * null) { currentBankAccount =
	 * getBankAccount(circleBankAccount.getBankAccountId()); }
	 * 
	 * User accountOwner = user; if (accountOwner == null) { accountOwner =
	 * getAccountOwner(circle.getId()); }
	 * 
	 * // 마지막 거래내역 조회. CircleTransaction latest =
	 * createLatestCircleTransaction(circle, user, currentBankAccount);
	 * 
	 * String fintechUseNum = currentBankAccount.getFintechUseNum();
	 * 
	 * // 거래내역 조회에 대한 로그를 조회. // 거래내역 조회에 대한 로그가 없는 경우 (fromDate: 마지막 거래내역 발생시간,
	 * toDate: 현재시간) 생성. // 거래내역 조회에 대한 로그가 있는 경우 (fromDate: 로그의 toDate, toDate:
	 * 현재시간) 수정. BankTransactionRequestLog requestLog =
	 * requestLogRepository.findOne(fintechUseNum); Instant fromDate =
	 * latest.getCreatedAt(); Instant toDate = ZonedDateTime
	 * .of(TimeUtils.kstDate(Instant.now()).minusDays(1), LocalTime.of(0, 0, 0),
	 * TimeUtils.ZONE_KR) .toInstant();
	 * 
	 * if (requestLog == null) { requestLog = new
	 * BankTransactionRequestLog(fintechUseNum); } else { fromDate =
	 * requestLog.getToDate(); }
	 * 
	 * if (TimeUtils.kstDate(fromDate).isAfter(TimeUtils.kstDate(toDate))) {
	 * return; }
	 * 
	 * requestLog.setFromDate(fromDate); requestLog.setToDate(toDate);
	 * requestLogRepository.save(requestLog);
	 * 
	 * BankTransaction latestBankTransaction = latest.getBankTransaction();
	 * List<BankTransaction> bankTransactions =
	 * pullBankTransactions(accountOwner, currentBankAccount, circle,
	 * requestLog);
	 * 
	 * if (CollectionUtils.isEmpty(bankTransactions)) { Long amount =
	 * latestBankTransaction.getAfterBalanceAmount(); BankTransaction daily =
	 * createDailyTypedTransaction(currentBankAccount,
	 * TimeUtils.kstTime(toDate), amount); bankTransactions.add(daily); }
	 * 
	 * create(circle, bankTransactions); }
	 * 
	 *//**
		 * 모임 계좌 등록 해지 거래내역 업데이트.
		 *//*
		 * @Override
		 * 
		 * @Transactional public void canceledUpdateCircleBankTransaction(Circle
		 * circle, User user, BankAccount bankAccount) {
		 * 
		 * CircleBankAccount circleBankAccount =
		 * getCircleBankAccount(circle.getId());
		 * 
		 * BankAccount currentBankAccount = bankAccount; if (currentBankAccount
		 * == null) { currentBankAccount =
		 * getBankAccount(circleBankAccount.getBankAccountId()); }
		 * 
		 * User accountOwner = user; if (accountOwner == null) { accountOwner =
		 * getAccountOwner(circle.getId()); }
		 * 
		 * // 마지막 거래내역 조회. CircleTransaction latest =
		 * createLatestCircleTransaction(circle, user, currentBankAccount);
		 * 
		 * String fintechUseNum = currentBankAccount.getFintechUseNum();
		 * 
		 * // 거래내역 조회에 대한 로그를 조회. // 거래내역 조회에 대한 로그가 없는 경우 (fromDate: 마지막 거래내역
		 * 발생시간, toDate: 현재시간) 생성. // 거래내역 조회에 대한 로그가 있는 경우 (fromDate: 로그의
		 * toDate, toDate: 현재시간) 수정. BankTransactionRequestLog requestLog =
		 * requestLogRepository.findOne(fintechUseNum); Instant fromDate =
		 * latest.getCreatedAt(); Instant toDate =
		 * TimeUtils.kstNow().toInstant();
		 * 
		 * if (requestLog == null) { requestLog = new
		 * BankTransactionRequestLog(fintechUseNum); } else { fromDate =
		 * requestLog.getToDate(); }
		 * 
		 * if (fromDate.isAfter(toDate)) { return; }
		 * requestLogRepository.save(requestLog);
		 * 
		 * List<BankTransaction> bankTransactions =
		 * pullBankTransactions(accountOwner, currentBankAccount, circle,
		 * requestLog);
		 * 
		 * if (!ObjectUtils.isEmpty(bankTransactions)) { create(circle,
		 * bankTransactions); }
		 * 
		 * createCancelTypedTansaction(user, circle, currentBankAccount); }
		 */
}
