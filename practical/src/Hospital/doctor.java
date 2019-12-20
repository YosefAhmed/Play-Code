/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

import java.util.ArrayList;

/**
 *
 * @author Yousef
 */
public class doctor extends person {
    
    private String Specialization;
    private ArrayList<patient> Patients=new ArrayList<patient>();

    public  void getPatients() {
        for(patient p: Patients){
        p.Display_Info();
        }
     }

    public  void setPatients(patient Patient) {
        this.Patients.add(Patient);
    }
    
    public doctor(String Name, String Specialization) {
        super(Name);
        this.Specialization=Specialization;
    }

        @Override
    public void Display_Info(){
        super.Display_Info();
        System.out.println("Doctor Specialization is: "+Specialization);
        getPatients();
        
    }
    
}
