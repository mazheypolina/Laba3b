package com.c;

public class Circle {
   int x,y;
   int R;
   double S;
   double P;

   public Circle(){
        super();
    }

   public void setX(int x){
        this.x =x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setR(int R){
        this.R = R;
    }

    public void setS(double S){
        this.S = S;
    }

    public int getX(){
        return x;
    }

   public int getY(){
        return y;
    }

    public int getR(){
        return R;
    }

    public double getP(){
        return P;
    }

   @Override
    public String toString(){
        return "Circle{ " +
                "(x-" + x +
                ")^2 + (y-" + y +
                ")^2 = " + R +
                "^2 }";
    }


}