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
public class Launcher {
    public static void main(String[] args) {
        ArrayList<person> persons=new ArrayList<person>();
        
        persons.add(new patient("paient1","cold"));
        persons.add(new patient("paient2","cancer"));
        persons.add(new doctor("Doctor1","Heart"));
        persons.add(new patient("paient3","stomich"));
        persons.add(new patient("paient4","chest"));
        
            doctor d =  (doctor) persons.get(2);
        for(int i=0; i<5; i++){
            if(persons.get(i) instanceof patient){
                d.setPatients((patient) persons.get(i));
            }
        }
        
        persons.get(2).Display_Info();

        
    
    
    }
}
