/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.DB4OUtil.DB4OUtil;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.NurseOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.NurseRole.NurseWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class NurseRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business, DB4OUtil dB4OUtil) {
        return new NurseWorkAreaJPanel(userProcessContainer, account, (NurseOrganization)organization, enterprise,business, dB4OUtil);
    }
    
}
