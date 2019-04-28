
import java.util.Random;

//Danny Young
//CSC325 HW 8
public class GameRunnable implements Runnable
{
    boolean isDone = false;
    Random rand = new Random();
    int strength = 10;
    
    public void run()
    {
        combat();
    }
    public String combat()
    {
        int hit = rand.nextInt();
        if(hit != 0)
        {
            return "attacks and deals " + damageDone() + " damage!";
        }
        else
            return "misses!";
        
    }
    public int damageDone()
    {
        int dmg = rand.nextInt(strength);
        return dmg;
    }
}
