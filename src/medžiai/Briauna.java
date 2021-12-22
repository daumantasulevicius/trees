/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medžiai;

/**
 *
 * @author Daumantas
 */
public class Briauna {
    
    private int prec, dest;
    private double precDest;
    
    public Briauna(int prec, int dest){
        this.precDest = Double.parseDouble(prec + "." + dest);
        this.prec = prec;
        this.dest = dest;
    }
    
    public Briauna(){

    }
    
    public int imtiPrec(){return prec;}
    
    public int imtiDest(){return dest;}
    
    public void keistiPrec(int p){this.prec = p;}
    
    public void keistiDest(int d){this.dest = d;}
    
    public double imtiPrecDest() {return precDest;}

}
