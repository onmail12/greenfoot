import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Actor
{
    GreenfootImage bullet = new GreenfootImage("SpongeBullet.png");
    public int x;
    public int damage;
    public Bullet(int speed){
        x = speed;
    }
    
    public void act()
    {
        bullet.scale(30, 8);
        setImage(bullet);
        move(x);
        
        
        if(isAtEdge()){
            getWorld().removeObject(this);
        }
        chaseZombie();
        destroy();
    }
    
    private void chaseZombie(){
        if (this != null && getWorld().getObjects(Zombie.class) != null){
            for(Zombie zombie : getWorld().getObjects(Zombie.class)){
                try{
                    turnTowards(zombie.getX(), zombie.getY());
                }
                catch(Exception e){
                    return;
                }
            }
        }
    }
    
    private void destroy(){
        if(getOneIntersectingObject(Zombie.class) != null){
            removeTouching(Zombie.class);
            getWorld().removeObject(this);
        }
    }
        
        
        
}

