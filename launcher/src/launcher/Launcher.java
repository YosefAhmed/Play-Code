/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Yousef
 */
interface myIngterface {
    int x=0,y=0;
    
    void sum1(int x,int y)throws Exception;
    default void sum1(){
        System.out.println(x+y);
    }
}


abstract class parent implements myIngterface{
    
    public void sum(int x,int y){
         System.out.print("i am in the parent");
    }
}


//overrid
class child extends parent implements Comparable<child>{
     int num=0;
    protected child(int num){
        this.num=num;
    }
    @Override
    public void sum(int x, int y){
          
    }
    
    public void sum(float x, float y){
                        System.out.println(x+y);

    }

    @Override
    public void sum1(int x, int y)throws Exception{
        
            if(x==2)
                throw new Exception("Error!!!");
        System.out.println(x+y+"  "+num);
        
        
     }

    @Override
    public int compareTo(child o) {
        if(o.num < num)
            return 1;
        else if(o.num > num)
            return -1;
        else
            return 0;
    }

}

public class Launcher {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){
        
        String x="ja";
        String y="aj";
        System.out.println(x.compareTo(y));
        
        
     child c=new child(0);
     myIngterface m = new child(2);
     m=c;
     try{
     m.sum1(2,5);
     }catch(Exception e){
         System.out.println(e.getMessage());
     }
/*     ArrayList<child>arr=new ArrayList<child>();
     arr.add(new child(2));
     arr.add(new child(-1));
     arr.add(new child(5));
     
     Collections.sort(arr);
     for(child c:arr){
         System.out.println(c.num);
         c.sum1();
     }
    }
  */  
    }
}
