int i = 0;

void setup() {
  //fullScreen(2);
  size(500, 500);
}

void draw(){  
  background(0, 0, 255);
  fill(0, 255, 0);
  ellipse(i, height/2, 75, 75);  
  i = i+1;  
  //ellipse(mouseX, mouseY, 75, 75);
}
