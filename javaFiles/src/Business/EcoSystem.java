package Business;

import Business.Food.Food;
import Business.Food.FoodDirectory;
import Business.Money.Account;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Patient.Patient;
import Business.Patient.PatientDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }
    private final FoodDirectory foodDirectory;
    private final PatientDirectory patientDirectory;
    private final Account account;
    private WorkQueue workQueue;

    private EcoSystem() {
        super(null);
        networkList = new ArrayList<>();
        this.foodDirectory = new FoodDirectory();
        this.patientDirectory = new PatientDirectory();
        this.account = new Account();
        this.workQueue = new WorkQueue();
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
    
    public FoodDirectory getFoodDirectory() {
        
       return foodDirectory;
        
    }
    
    public WorkQueue getWorkQueue() {
        
       return workQueue;
        
    }
    
    public PatientDirectory getPatientDirectory() {
        
       return patientDirectory;
        
    }   
    
    public Account getAccount(){
        
        return account;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }

        for (Network network : networkList) {
        }

        return true;
    }
}