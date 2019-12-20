/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

/**
 *
 * @author Yousef
 */
public abstract class person {
    private String Name;

    public person(String Name) {
     this.Name=Name;
    }
    
    public void Display_Info(){
        System.out.println("Name: "+Name);
    }
    
}
