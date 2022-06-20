import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {
	
  // Declare variables
  public PImage carrot;
  public PImage watermelon;
  public PImage pumpkin;

  float x = 0;
  float y = 0;
  float xSpeed = 5;
  float ySpeed = 4;
  float speed = 5;
  double xPumpkin = 1;
  double yPumpkin = 50;
  
  // Set size
  public void settings() {

    size(500, 500);

  }

  public void setup() {
    
   // load images
   carrot = loadImage("../carrot.jpg");
   watermelon = loadImage("../watermelon.png");
   pumpkin = loadImage("../pumpkin.png");

   // resize images
   watermelon.resize(100,100);
   pumpkin.resize(100,100);

  }

  public void draw() {

    // draw images
    image(carrot, 0, 0);
    image(watermelon, x, y);

    // speed of watermelon
    x += xSpeed;
    y += ySpeed;

    // collisison detection for watermelon
    if (x < 0 || (x + 100) > width) {
      xSpeed *= -1;
    }

    if (y < 0  || (y + 100) > height) {
      ySpeed *= -1;
    }

    // non-linear path for pumpkin
    xPumpkin += speed;
    yPumpkin = (0.0013 * (Math.pow(xPumpkin - width/2, 2))) + 100;

    if ((xPumpkin + 100) > width) {

      xPumpkin = 0;

    }

    // draw pumpkin
    image(pumpkin, (float)(xPumpkin), (float)(yPumpkin));

  }
  
}