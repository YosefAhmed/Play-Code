/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package launcher;

/**
 *
 * @author Yousef
 */
class device{
    public void start(){
        System.out.println("device started! ");
    }
}
class camera extends device{
    @Override
    public void start(){
        System.out.println("camera is ready! ");        
    }
    public void shot(){
        System.out.println("Tick !!!! ");        
    }
}

class recorder extends device{
    @Override
    public void start(){
        System.out.println("Recorder is ready! ");        
    }
    
    public void record(){
        System.out.println("Recording !!!! ");
    }
}

public class casting {
    public static void main(String[] args) {
    
        device d1=new device() ;
        camera c1 =new camera();
        recorder r1 =new recorder();
        System.out.println("d1 -----> "+d1);
        System.out.println("c1 -----> "+c1);
        System.out.println("r1 -----> "+r1);
        
        //=============Up Casting ===============================       
        d1=new camera();
        System.out.println("\nd1 -----> "+d1);
        d1.start();
        
        //============= Down Casting ============================
        c1=(camera)d1;
        System.out.println("\nc1 -----> "+c1);
        c1.start();
        
        
    }
}
