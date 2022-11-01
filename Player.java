import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Player extends Actor
{
    // IMAGES
    GifImage idleRight = new GifImage("idle_r.gif");
    GifImage idleLeft = new GifImage("idle_l.gif");
    //GifImage runningLeft = new GifImage("running_left.gif");
    //GifImage runningRight = new GifImage("running_right.gif");
    
    
    int wasFacing; // 0 - right   1 - left
    
    private int timer; // bullet creation delay timer
    
    //mouses
    public int mx;
    public int my;
    
    //enums
    enum state {
      SHOOTING,
      RUNNING_RIGHT,
      RUNNING_LEFT,
      IDLING,
    }
    state currentState = state.RUNNING_RIGHT;
    
    public int speed = 3;
    public int health = 100;
    public int jumpForce = 17;
    
    private int vSpeed=0;
    private int acceleration=1;
    
    public void act()
    {
        movement();
        if(!Greenfoot.isKeyDown("w") && !Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("s") && !Greenfoot.isKeyDown("d")){
            shoot();
        }
        
        //dead();

        // MouseInfo mouse = Greenfoot.getMouseInfo();
        // if(Greenfoot.mouseMoved(null) || Greenfoot.mouseDragged(null)){  
           // mx = mouse.getX();  
           // my = mouse.getY();  
        // }
        
        
        
        switch(currentState) {
          case RUNNING_RIGHT:
            setImage(idleRight.getCurrentImage());
            break;
          case RUNNING_LEFT:
            setImage(idleLeft.getCurrentImage());
            break;
        }
        
    }
    
    private void movement(){
        if(Greenfoot.isKeyDown("W") || Greenfoot.isKeyDown("up")){
            setLocation(getX(), getY() - speed);
        }
        if(Greenfoot.isKeyDown("A") || Greenfoot.isKeyDown("left")){
            setLocation(getX() - speed, getY());
            currentState = state.RUNNING_LEFT;
        }
        if(Greenfoot.isKeyDown("S") || Greenfoot.isKeyDown("down")){
            setLocation(getX(), getY() + speed);
        }
        if(Greenfoot.isKeyDown("D") || Greenfoot.isKeyDown("right")){
            setLocation(getX() + speed, getY());
            currentState = state.RUNNING_RIGHT;
        }
    }
    
    private void shoot(){
        if (timer > 0)timer--;
        // at mouse click (bullet)
        if (timer == 0){
            Bullet arrow = new Bullet(5);
            
            getWorld().addObject(arrow, getX(), getY()-3); //spawn bullet at muzzle
            
            timer = 70; // start timer (adjust value as needed)
            currentState = state.SHOOTING;
                
        }
    }

    private void dead(){
        if(isTouching(Zombie.class)){
            health--;
        }
        if (health <= 0){
            getWorld().removeObject(this);
        }
        
    }
}
