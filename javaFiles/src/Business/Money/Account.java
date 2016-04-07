/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Money;

/**
 *
 * @author rama
 */
public class Account {
    
    private int funds;

    public int getFunds() {
        return funds;
    }

    public void setFunds(int funds) {
        this.funds = funds;
    }
    
    public void addFunds(int money){
        this.funds = funds + money;
    }
    
    public void subtractFunds(int money){
        this.funds = funds - money;
    }
}
