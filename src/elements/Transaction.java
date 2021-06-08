package elements;

import java.sql.Date;
/** 
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class Transaction 
{
    private int id;
    private Date transactionDate;
    private Crypto currency;
    private float amount; 

    public Transaction(int id, Date transactionDate, Crypto currency, float amount) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.currency = currency;
        this.amount = amount;
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

    public Crypto getCurrency() {
        return currency;
    }

    public void setCurrency(Crypto currency) {
        this.currency = currency;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

}
