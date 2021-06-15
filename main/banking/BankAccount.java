package main.banking;

public abstract class BankAccount {
	private String userName;
	private String userSsn;
	private String userAddress;
	private String bankName;
	private String bankAddress;
	private long routingNumber;
	private long acntNumber;
	private double balance;
	private double annualInterestRate;
	private double tax;
	private String dateCreated;
	
	
	
	public BankAccount(String userName, String userSsn, String userAddress, String bankName, String bankAddress,
			long routingNumber, long acntNumber, String dateCreated) {
		setUserName(userName);
		setUserSsn(userSsn);
		setUserAddress(userAddress);
		setBankName(bankName);
		setBankAddress(bankAddress);
		setRoutingNumber(routingNumber);
		setAcntNumber(acntNumber);
		setDateCreated(dateCreated);
		setBalance(0);
		setAnnualInterestRate(0.05);
		setTax(0.01);
	}

	public void deposit(double amount) {
		balance += amount;
	}
	
	public double withdraw(double amount) {
		if (balance > amount) {
			balance -= amount;
			return amount;
		}
		System.out.println("Sorry, not enough balance!");
		return -1.0;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSsn() {
		return userSsn;
	}

	public void setUserSsn(String userSsn) {
		this.userSsn = userSsn;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public long getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(long routingNumber) {
		this.routingNumber = routingNumber;
	}

	public long getAcntNumber() {
		return acntNumber;
	}

	public void setAcntNumber(long acntNumber) {
		this.acntNumber = acntNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
}
