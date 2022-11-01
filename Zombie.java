import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.Random;

public class Zombie extends Actor
{
    
    // GreenfootImage rz1 = new GreenfootImage("rz1.png");
    // GreenfootImage lz1 = new GreenfootImage("lz1.png");
    // GreenfootImage rz2 = new GreenfootImage("rz2.png");
    // GreenfootImage lz2 = new GreenfootImage("lz2.png");
    // GreenfootImage rz3 = new GreenfootImage("rz3.png");
    // GreenfootImage lz3 = new GreenfootImage("lz3.png");
    // GreenfootImage rz4 = new GreenfootImage("rz4.png");
    // GreenfootImage lz4 = new GreenfootImage("lz4.png");
    // GreenfootImage rz5 = new GreenfootImage("rz5.png");
    // GreenfootImage lz5 = new GreenfootImage("lz5.png");
    // GreenfootImage rz6 = new GreenfootImage("rz6.png");
    // GreenfootImage lz6 = new GreenfootImage("lz6.png");
    // GreenfootImage rz7 = new GreenfootImage("rz7.png");
    // GreenfootImage lz7 = new GreenfootImage("lz7.png");
    
    public int speed = 1;
    public int health = 100;

    
    public GreenfootImage imageRight;
    public GreenfootImage imageLeft;
    
    public Zombie (int imageIndex){
        imageRight = new GreenfootImage("rz" + imageIndex + ".png");
        imageLeft = new GreenfootImage("lz" + imageIndex + ".png");
    }
        
    
    
        public void act()
        {
            setImage(imageRight);

            imageRight.scale(45, 61); // scale image
            imageLeft.scale(45, 61); 
            
            
            chasePlayer();
            //jump();

            // MUST BE PLACED UNDER EVERYTHING
            //destroy();
        }

        private void chasePlayer(){
            if (this != null && getWorld().getObjects(Player.class) != null){
                List players = getWorld().getObjects(Player.class);
                try{
                    Actor player = (Actor)players.get(0);
                    int deltaX = getX() - player.getX();
                    int deltaY = getY() - player.getY();
                    System.out.println("dx " + deltaX +"\n" + "dy " + deltaY);
                    //abs = absolute value - negative to positive | -150 -> 150
        
                    if (Math.abs(deltaX) > Math.abs(deltaY)) {
                        if (deltaX > 0) {   
                            System.out.println("left");
                            setImage(imageLeft);
                            setLocation(getX() - speed, getY());
                        }
                        
                        else if (deltaX < 0) {
                            System.out.println("right");
                            setImage(imageRight);
                            setLocation(getX() + speed, getY());
                        }
                    }
                    else{
                        if (deltaY > 0) {
                            System.out.println("up");
                            setLocation(getX(), getY() - speed);
                        }
                        else if (deltaY < 0) {
                            System.out.println("down");
                            setLocation(getX(), getY() + speed);
                        }
                    }
                    
                }
                catch(Exception e){
                    return;
                }
            }
        }

        private void destroy(){
            // if(getOneIntersectingObject(Bullet.class) != null){
                // getWorld().removeObject(this);
            // }
            removeTouching(Bullet.class);
        }

    }
