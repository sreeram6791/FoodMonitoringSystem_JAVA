package Business;

import Business.Employee.Employee;
import Business.Food.Food;
import Business.Food.FoodDirectory;
import Business.Patient.Patient;
import Business.Patient.PatientDirectory;
import Business.Role.AdminRole;
import Business.Role.CatererRole;
import Business.Role.DonorRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author rrheg
 */
public class ConfigureASystem {
    
    public static EcoSystem configure(){
        
        EcoSystem system = EcoSystem.getInstance();
        
        //Create a network
        //create an enterprise
        //initialize some organizations
        //have some employees 
        //create user account
        
        
        Employee employee = system.getEmployeeDirectory().createEmployee("Admin1");
        UserAccount ua = system.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SystemAdminRole());
        
//        Employee employee3 = system.getEmployeeDirectory().createEmployee("Organization Admin");
//        UserAccount ua3 = system.getUserAccountDirectory().createUserAccount("admin", "admin", employee, new AdminRole());
        
        Employee employee1 = system.getEmployeeDirectory().createEmployee("Caterer1");
        UserAccount ua1 = system.getUserAccountDirectory().createUserAccount("caterer", "caterer", employee, new CatererRole());

        Employee employee2 = system.getEmployeeDirectory().createEmployee("Donor1");
        UserAccount ua2 = system.getUserAccountDirectory().createUserAccount("donor", "donor", employee, new DonorRole());        
        
//        Food food1 = new Food(); Food food2 = new Food(); Food food3 = new Food(); Food food4 = new Food(); Food food5 = new Food();
//        food1.setName("foodItem1");food2.setName("foodItem2");food3.setName("foodItem3");food4.setName("foodItem4");food5.setName("foodItem5");
//        food1.setCost(10);food2.setCost(10);food3.setCost(15);food4.setCost(20);food5.setCost(25);
//        
//        FoodDirectory foodDirectory = system.getFoodDirectory();
//        foodDirectory.setFoodDirectory(food1); foodDirectory.setFoodDirectory(food2); foodDirectory.setFoodDirectory(food3);
//        foodDirectory.setFoodDirectory(food4); foodDirectory.setFoodDirectory(food5);
        
        
        
        Patient patient1 = new Patient(); Patient patient2 = new Patient(); Patient patient3 = new Patient();
        Patient patient4 = new Patient(); Patient patient5 = new Patient();
        patient1.setName("Patient1");patient2.setName("Patient2");patient3.setName("Patient3");
        patient4.setName("Patient4");patient5.setName("Patient5");
        
        PatientDirectory patientDirectory = system.getPatientDirectory();
        patientDirectory.setPatientDirectory(patient1); patientDirectory.setPatientDirectory(patient2); patientDirectory.setPatientDirectory(patient3);
        patientDirectory.setPatientDirectory(patient4); patientDirectory.setPatientDirectory(patient5);
        
        return system;
    }
    
}
