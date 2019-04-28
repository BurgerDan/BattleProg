import java.util.Random;

//Danny Young
//CSC 325 HW 8

public class Characters 
{
    private String charName;
    private int health;
    private int totalHealth;
    private String job;
    private String race;
    private int Strength;
    Random rand = new Random();
    
    public Characters(String name, String charJob, String charRace)
    {
        this.charName = name;
        this.job = charJob;
        this.race = charRace;
        this.health = 100;
        this.totalHealth = 100;
    }
    //Getters
    public String getName()
    {
        return this.charName;
    }
    public int getHealth()
    {
        return this.health;
    }
    public int getTotHealth()
    {
        return this.totalHealth;
    }
    public String getJob()
    {
        return this.job;
    }
    public String getRace()
    {
        return this.race;
    }
    public int getStrength()
    {
        return this.Strength;
    }
    //Setters
    public void setName(String newCharName)
    {
        this.charName = newCharName;
    }
    public void setHealth(int newHealth)
    {
        this.health = newHealth;
    }
    public void setTotalHealth(int newTotalHealth)
    {
        this.totalHealth = newTotalHealth;
    }
    public void setJob(String newJob)
    {
        this.job = newJob;
    }
    public void setRace(String newRace)
    {
        this.race = newRace;
    }
    public void setStrength(int newStrength)
    {
        this.Strength = newStrength;
    }
    //Fight method
    public void Fight(Characters foe)
    {
        
    }
}
