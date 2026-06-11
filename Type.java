import java.util.ArrayList;
public class Type 
{
    private String name;
    private ArrayList<String> weakness;
    private ArrayList<String> immunity;
    
    public Type (String name)
    {
        weakness = new ArrayList<String>();
        immunity = new ArrayList<String>();
        
        this.name = name;
        
        //adds the weaknesses and immunities for each type
        if(name.equals("grass"))
        {
            weakness.add("fire");
            weakness.add("bug");
            weakness.add("flying");
            weakness.add("ice");
            weakness.add("poison");
        }
        else if(name.equals("water"))
        {
            weakness.add("grass");
            weakness.add("electric");
        }
        else if(name.equals("fire"))
        {
            weakness.add("water");
            weakness.add("rock");
            weakness.add("ground");
        }
        else if(name.equals("flying"))
        {
            weakness.add("rock");
            weakness.add("electric");
            weakness.add("ice");
            immunity.add("ground");
        }
        else if(name.equals("ice"))
        {
            weakness.add("rock");
            weakness.add("fire");
            weakness.add("steel");
            weakness.add("fighting");
        }
        else if(name.equals("bug"))
        {
            weakness.add("fire");
            weakness.add("flying");
            weakness.add("rock");
        }
        else if(name.equals("rock"))
        {
            weakness.add("water");
            weakness.add("grass");
            weakness.add("steel");
            weakness.add("ground");
            weakness.add("fighting");
        }
        else if(name.equals("ground"))
        {
            weakness.add("water");
            weakness.add("grass");
            weakness.add("ice");
            immunity.add("electric");
        }
        else if(name.equals("electric"))
        {
            weakness.add("ground");
        }
        else if(name.equals("steel"))
        {
            weakness.add("fire");
            weakness.add("ground");
            weakness.add("fighting");
        }
        else if(name.equals("dark"))
        {
            weakness.add("fighting");
            weakness.add("fairy");
            weakness.add("bug");
            immunity.add("psychic");
        }
        else if(name.equals("psychic"))
        {
            weakness.add("dark");
            weakness.add("bug");
        }
        else if(name.equals("fighting"))
        {
            weakness.add("psychic");
            weakness.add("flying");
            weakness.add("fairy");
        }
        else if(name.equals("fairy"))
        {
            weakness.add("steel");
            weakness.add("poison");
            immunity.add("dragon");
        }
        else if(name.equals("dragon"))
        {
            weakness.add("dragon");
            weakness.add("ice");
            weakness.add("fairy");
        }
        else if(name.equals("ghost"))
        {
            weakness.add("ghost");
            weakness.add("dark");
            immunity.add("normal");
            immunity.add("fighting");
        }
        else if(name.equals("normal"))
        {
            weakness.add("fighting");
            immunity.add("ghost");
        }
        else if(name.equals("poison"))
        {
            weakness.add("ground");
            weakness.add("psychic");
        }
        
    }
    
    public Type ()
    {
        name = "typeless";
    }
    
    public String getName()
    {
        return name;
    }
    
    public ArrayList<String> getWeakness()
    {
        return weakness;
    }
    
    public ArrayList<String> getImmunity()
    {
        return immunity;
    }
    
}
