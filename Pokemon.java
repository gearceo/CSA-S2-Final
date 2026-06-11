import java.util.ArrayList;
public class Pokemon 
{
    private String name;
    private Type type;
    private Stats baseStats;
    private int health;
    private int totalHealth;
    private boolean isFainted;
    private ArrayList<Move> moves = new ArrayList<Move>();
    
    public Pokemon(String name, String type, int lvl, int health, int attack, int defence, int sAttack, int sDefence, int speed)
    {
        this.name = name;
        this.type = new Type(type);
        baseStats = new Stats(lvl, health, attack, defence, sAttack, sDefence, speed);
        totalHealth = (((2 * health + 31) * lvl) / 100) + lvl + 10;
        this.health = (((2 * health + 31) * lvl) / 100) + lvl + 10;
        isFainted = false;
    }
    
    public void addMove(String name, String type, String category, int bp, int acc, int pp, int priority)
    {
        if(moves.size() != 4)
        {
            moves.add(new Move(name, type, category, bp, acc, pp, priority));
        }
    }
    
    public String getName()
    {
        return name;
    }
    
    public Type getType()
    {
        return type;
    }
    
    public int getHealth()
    {
        return health;
    }
    
    public int getTotalHealth()
    {
        return totalHealth;
    }
    
    public boolean getIsFainted()
    {
        return isFainted;
    }
    
    public Stats getBaseStats()
    {
        return baseStats;
    }
    
    public ArrayList<Move> getMove()
    {
        return moves;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setType(String type)
    {
        this.type = new Type(type);
    }
    
    public void setHealth(int health)
    {
        this.health = health;
    }
    
    public void setTotalHealth(int totalHealth)
    {
        this.totalHealth = totalHealth;
    }
    
    public void setIsFainted(boolean isFainted)
    {
        this.isFainted = isFainted;
    }
    
    public String toString()
    {
        return name + ": Lvl " + baseStats.getLvl() + "\n" + "HP: " + health + "/" + totalHealth;
    }
    
    public class Stats
    {
        private int lvl;
        private int hp;
        private int attack;
        private int defence;
        private int sAttack;
        private int sDefence;
        private int speed;
        
        
        public Stats (int lvl, int hp, int attack, int defence, int sAttack, int sDefence, int speed)
        {
            this.lvl = lvl;
            this.hp = hp;
            this.attack = attack;
            this.defence = defence;
            this.sAttack = sAttack;
            this.sDefence = sDefence;
            this.speed = speed;
        }
        
        public int getLvl()
        {
            return lvl;
        }
        
        public int getHP()
        {
            return hp;
        }
        
        public int getAttack()
        {
            return attack;
        }
        
        public int getDefence()
        {
            return defence;
        }
        
        public int getSAttack()
        {
            return sAttack;
        }
        
        public int getSDefence()
        {
            return sDefence;
        }
        
        public int getSpeed()
        {
            return speed;
        }
        
        public void setLvl(int lvl)
        {
            this.lvl = lvl;
        }
        
        public void setHP(int hp)
        {
            this.hp = hp;
        }
        
        public void setAttack(int attack)
        {
            this.attack = attack;
        }
        
        public void setDefence(int defence)
        {
            this.defence = defence;
        }
        
        public void setSAttack(int sAttack)
        {
            this.sAttack = sAttack;
        }
        
        public void setSDefence(int sDefence)
        {
            this.sDefence = sDefence;
        }
        
        public void setSpeed(int speed)
        {
            this.speed = speed;
        }
        
    }
}
