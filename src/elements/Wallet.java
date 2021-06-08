package elements;
/** 
 * @author Alex Guirao Lopez <aguiraol2021@cepnet.net>
 */
public class Wallet 
{
    private int id;
    private User user;
    private float totalEur;

    public Wallet(int id, User user, float totalEur) 
    {
        this.id = id;
        this.user = user;
        this.totalEur = totalEur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getTotalEur() {
        return totalEur;
    }

    public void setTotalEur(float totalEur) {
        this.totalEur = totalEur;
    }
    
}
