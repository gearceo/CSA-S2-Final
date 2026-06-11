public class Move
{
    private String name;
    private int bp;
    private int acc;
    private int pp;
    private int totalPP;
    private String type;
    private String category;
    private int priority;
    
    public Move(String name, String type, String category, int bp, int acc, int pp, int priority)
    {
        this.name = name;
        this.bp = bp;
        this.acc = acc;
        this.type = type;
        this.category = category;
        this.pp = pp;
        totalPP = pp;
        this.priority = priority;
    }
    
    public Move()
    {
        this.name = "Struggle";
        this.bp = 50;
        this.acc = 100;
        this.type = "normal";
        this.category = "physical";
        this.pp = 100;
        totalPP = 100;
        this.priority = 0;
    }
    
    public void moveUse()
    {
        pp--;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getBP()
    {
        return bp;
    }
    
    public int getAcc()
    {
        return acc;
    }
    
    public String getType()
    {
        return type;
    }
    
    public String getCategory()
    {
        return category;
    }
    
    public int getPP()
    {
        return pp;
    }
    
    public int getTotalPP()
    {
        return totalPP;
    }
    
    public int getPriority()
    {
        return priority;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setBP(int bp)
    {
        this.bp = bp;
    }
    
    public void setAcc(int acc)
    {
        this.acc = acc;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public void setCategory(String category)
    {
       this.category = category;
    }
    
    public void setPP(int pp)
    {
        this.pp = pp;
    }
    
    public void setTotalPP(int pp)
    {
        totalPP = pp;
    }
    
    public void setPriority(int priority)
    {
        this.priority = priority;
    }
}
