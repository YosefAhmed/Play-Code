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
public class patient extends person{
    private String Disease;

    public patient(String Name, String Disease) {
        super(Name);
        this.Disease=Disease;
    }
    
    @Override
    public void Display_Info(){
        super.Display_Info();
        System.out.println("the Disease is: "+Disease);
    }
    
}
