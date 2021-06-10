package elements;

import java.sql.Date;
/** 
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class Transaction 
{
    private int id;
    private Date transactionDate;
    private String currency;
    private float amount; 
    private User user;

    public Transaction(int id, Date transactionDate, String currency, float amount, User user) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.currency = currency;
        this.amount = amount;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    
}
