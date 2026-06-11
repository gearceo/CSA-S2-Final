import java.util.*;
public class Runner
{
    public static int getChoice(Scanner input, ArrayList<Move> moves)
    {
        try
        {
            int selection = 0;
            while (selection < 1 || selection > 5)
            {
                System.out.println("\n------Fight Menu------");
                System.out.println("1. " + moves.get(0).getName() + " " + moves.get(0).getPP() + "/" + moves.get(0).getTotalPP());
                System.out.println("2. " + moves.get(1).getName() + " " + moves.get(1).getPP() + "/" + moves.get(1).getTotalPP());
                System.out.println("3. " + moves.get(2).getName() + " " + moves.get(2).getPP() + "/" + moves.get(2).getTotalPP());
                System.out.println("4. " + moves.get(3).getName() + " " + moves.get(3).getPP() + "/" + moves.get(3).getTotalPP());
                System.out.println("5. Go Back");
                System.out.print("\nEnter your choice ..... ");
                selection = input.nextInt();
            }
            
            return selection;
        }
        
        catch(InputMismatchException e)
        {
            input.nextLine();
            System.out.println("Letters or Special Characters are not allowed");
            return getChoice(input, moves);
        }
    }
    
    //gets the choice from the fight screen
    public static int getFightAction(Scanner input)
    {
        try
        {
            int selection = 0;
            while (selection < 1 || selection > 4)
            {
                System.out.println("\n------Choose an Action------");
                System.out.println("1. Fight");
                System.out.println("2. Switch");
                System.out.println("3. Get Your Stats");
                System.out.println("4. Quit");
                System.out.print("\nEnter your choice ..... ");
                selection = input.nextInt();
            }
            return selection;
        }
        
        catch (InputMismatchException e)
        {
            input.nextLine();
            System.out.println("Letters or Special Characters are not allowed");
            return getFightAction(input);
        }
    }
    
    //This calculates turn order and deals damage
    public static void calculateTurn(Pokemon p1, Pokemon p2, int input)
    {
        int speed1 = ((((p1.getBaseStats().getSpeed() * 2 + 31) * p1.getBaseStats().getLvl()) / 100) + 5);
        int speed2 = ((((p2.getBaseStats().getSpeed() * 2 + 31) * p2.getBaseStats().getLvl()) / 100) + 5);
        
        int p2Move = (int) (Math.random() * 4);
        System.out.println("\n" + p2.getMove().get(p2Move).getName());
        System.out.println("\n" + p1.getMove().get(input - 1).getName() + "\n");
        
        if(p1.getMove().get(input - 1).getPriority() == p2.getMove().get(p2Move).getPriority())
        {
            if(speed1 == speed2)
            {
                int tie = (int) ((Math.random() * 2) + 1);
                //There is a speed tie but the player wins the 50/50
                if(tie == 1)
                {
                    System.out.println("You tie but move first");
                    updateHealth(p2, calculateAttack(p1.getMove().get(input - 1), p1, p2));
                    p1.getMove().get(input - 1).moveUse();

                    updateHealth(p1, calculateAttack(p2.getMove().get(p2Move), p2, p1));
                    p2.getMove().get(p2Move).moveUse();
                    
                    System.out.println(p2);
                    System.out.println(p1);
                }
                //There is a speed tie but the player loses the 50/50
                else
                {
                    System.out.println("You tie but your opponent moves first");
                    updateHealth(p1, calculateAttack(p2.getMove().get(p2Move), p2, p1));
                    p2.getMove().get(p2Move).moveUse();
                    
                    updateHealth(p2, calculateAttack(p1.getMove().get(input - 1), p1, p2));
                    p1.getMove().get(input - 1).moveUse();
                    
                    System.out.println(p2);
                    System.out.println(p1);
                }
            }
            else if(speed1 > speed2)
            {
                System.out.println("You outspeed");
                updateHealth(p2, calculateAttack(p1.getMove().get(input - 1), p1, p2));
                p1.getMove().get(input - 1).moveUse();
                
                updateHealth(p1, calculateAttack(p2.getMove().get(p2Move), p2, p1));
                p2.getMove().get(p2Move).moveUse();
                
                System.out.println(p2);
                System.out.println(p1);
            }
            else
            {
                System.out.println("Opponent outspeeds");
                updateHealth(p1, calculateAttack(p2.getMove().get(p2Move), p2, p1));
                p2.getMove().get(p2Move).moveUse();
                
                updateHealth(p2, calculateAttack(p1.getMove().get(input - 1), p1, p2));
                p1.getMove().get(input - 1).moveUse();
                
                System.out.println(p2);
                System.out.println(p1);
            }
        }
        else if(p1.getMove().get(input - 1).getPriority() > p2.getMove().get(p2Move).getPriority())
        {
            System.out.println("You have priority");
            updateHealth(p2, calculateAttack(p1.getMove().get(input - 1), p1, p2));
            p1.getMove().get(input - 1).moveUse();
            
            updateHealth(p1, calculateAttack(p2.getMove().get(p2Move), p2, p1));
            p2.getMove().get(p2Move).moveUse();
            
            System.out.println(p2);
            System.out.println(p1);
            
        }
        else
        {
            System.out.println("Your opponent has priority");
            updateHealth(p1, calculateAttack(p2.getMove().get(p2Move), p2, p1));
            p2.getMove().get(p2Move).moveUse();
            
            updateHealth(p2, calculateAttack(p1.getMove().get(input - 1), p1, p2));
            p1.getMove().get(input - 1).moveUse();
            
            System.out.println(p2);
            System.out.println(p1);
        }
    }
    
    //This calculates and returns the damage done by a move
    public static int calculateAttack(Move move, Pokemon p1, Pokemon p2)
    {
        int critChance = (int) (Math.random() * 24) + 1;
        double random = ((int) (Math.random() * 16) + 85) / 100.0;
        boolean immune = false;
        boolean isWeak = false;
        int damage = 0;
        double crit = 1;
        double stab = 1;
        double effective = 1;
        
        for(int i = 0; i < p2.getType().getImmunity().size(); i++)
        {
            if(move.getType().equals(p2.getType().getImmunity().get(i)))
            {
                immune = true;
            }
        }
        
        for(int i = 0; i < p2.getType().getWeakness().size(); i++)
        {
            if(move.getType().equals(p2.getType().getWeakness().get(i)))
            {
                isWeak = true;
            }
            if(isWeak)
            {
                effective =  1.5;
                System.out.println("This move is supereffective");
            }
        }
        
        if(move.getType().equals(p1.getType().getName()))
        {
            stab = 1.5;
        }
        
        if(critChance == 1)
        {
            crit = 1.5;
            System.out.println("It was a critical hit");
        }
        
        if(immune)
        {
            System.out.println("This pokemon is immmune");
            return 0;
        }
        else
        {
            if(move.getCategory().equals("physical"))
            {
                damage += ((((((2 * p1.getBaseStats().getLvl()) / 5) + 2) * move.getBP() * (p1.getBaseStats().getAttack() / p2.getBaseStats().getDefence())) / 50) + 2) * crit * stab * effective * random;
            }
            else if(move.getCategory().equals("special"))
            {
                damage += ((((((2 * p1.getBaseStats().getLvl()) / 5) + 2) * move.getBP() * (p1.getBaseStats().getSAttack() / p2.getBaseStats().getSDefence())) / 50) + 2) * crit * stab * effective * random;
            }
        }
        
        return damage;
    }
    
    //This updates a pokemon's health after being hit
    public static void updateHealth(Pokemon mon, int damage)
    {
        mon.setHealth(mon.getHealth() - damage);
        if(mon.getHealth() <= 0)
        {
            mon.setIsFainted(true);
        }
    }
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        Pokemon arceus = new Pokemon("Arceus", "normal", 100, 120, 120, 120, 120, 120, 120);
        arceus.addMove("Judgement", "normal", "special", 100, 100, 16, 0);
        arceus.addMove("Aura Sphere", "fighting", "special", 80, 100, 32, 0);
        arceus.addMove("Earth Power", "ground", "special", 90, 100, 16, 0);
        arceus.addMove("Extreme Speed", "normal", "physical", 80, 100, 8, 2);
        Pokemon opponent = new Pokemon("Arceus", "normal", 100, 120, 120, 120, 120, 120, 120);
        opponent.addMove("Judgement", "normal", "special", 100, 100, 16, 0);
        opponent.addMove("Aura Sphere", "fighting", "special", 80, 100, 32, 0);
        opponent.addMove("Earth Power", "ground", "special", 90, 100, 16, 0);
        opponent.addMove("Extreme Speed", "normal", "physical", 80, 100, 8, 2);
        
        System.out.println("Opponent: \n" + opponent + "\n\n");
        
        System.out.println(arceus);
        
        int choice = getFightAction(input);
        while(choice != 4)
        {
            if(choice == 1)
            {
                int action = getChoice(input, arceus.getMove());
                calculateTurn(arceus, opponent, action);
                if(arceus.getIsFainted())
                {
                    System.out.println("You lose");
                    choice = 4;
                }
                else if(opponent.getIsFainted())
                {
                    System.out.println("You win");
                    choice = 4;
                }
            }
            if(choice == 2)
            {
                
            }
            choice = getFightAction(input);
        }
        
    }
}
