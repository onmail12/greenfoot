import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class MyWorld extends World
{
    Player player = new Player();
    int zombieCounter;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        
        addObject(player, getWidth()/2, getHeight()/2);
    }
    
    private void prepare()
    {
        Zombie zombie = new Zombie(0);
        addObject(zombie,Greenfoot.getRandomNumber(600),Greenfoot.getRandomNumber(400));
    }
    
    public void act(){
        
        Zombie zombie = new Zombie(Greenfoot.getRandomNumber(8));
        List zombies = getObjects(Zombie.class);
        System.out.println();
        if (zombies.toArray().length < 100){
            addObject(zombie,Greenfoot.getRandomNumber(getWidth()-20),Greenfoot.getRandomNumber(getHeight()-20));
            zombieCounter++;
            
        }
        
    }
}
