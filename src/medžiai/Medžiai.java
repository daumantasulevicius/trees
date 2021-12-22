/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medžiai;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Daumantas
 */
public class Medžiai {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] v = {0, 1, 5, 4, 3};
        Briaunos briaunos = new Briaunos();
        Briaunos atrinktos = new Briaunos();
        briaunos = kurtiBriaunas();
        atrinktos = atskirtiSuVirš(v, briaunos);
        for (int i = 0; i < briaunos.ImtiKiek(); i++) {
            System.out.println(briaunos.Imti(i).imtiPrec() + " " + briaunos.Imti(i).imtiDest());
        }
        if (atrinktos.ImtiKiek() > v.length - 1) {
            System.out.println(" ");
            for (int i = 0; i < atrinktos.ImtiKiek(); i++) {
                System.out.println(atrinktos.Imti(i).imtiPrec() + " " + atrinktos.Imti(i).imtiDest());
            }
            KruskalMST(atrinktos, v);
        }
        else
            System.out.println("Medis neindukuojamas !");
        
        
        
    }
    
    public static Briaunos kurtiBriaunas(){
        Briaunos brn = new Briaunos();
        Briauna briauna = new Briauna(0, 1);
        Briauna briauna1 = new Briauna(0, 2);
        Briauna briauna2 = new Briauna(0, 5);
        Briauna briauna3 = new Briauna(1, 2);
        Briauna briauna4 = new Briauna(1, 3);
        Briauna briauna5 = new Briauna(2, 3);
        Briauna briauna6 = new Briauna(2, 4);
        Briauna briauna7 = new Briauna(2, 5);
        Briauna briauna8 = new Briauna(3, 4);
        Briauna briauna9 = new Briauna(4, 5);
        
        brn.Dėti(briauna);
        brn.Dėti(briauna1);
        brn.Dėti(briauna2);
        brn.Dėti(briauna3);
        brn.Dėti(briauna4);
        brn.Dėti(briauna5);
        brn.Dėti(briauna6);
        brn.Dėti(briauna7);
        brn.Dėti(briauna8);
        brn.Dėti(briauna9);
        
        return brn;
    }

    public static Briaunos atskirtiSuVirš(int[] v, Briaunos briaun){
        Briaunos atrinktos = new Briaunos();
          for (int i = 0; i < briaun.ImtiKiek(); i++) {
              int prec = briaun.Imti(i).imtiPrec();
              int dest = briaun.Imti(i).imtiDest();
            for (int j = 0; j < v.length; j++) {
                
                
                if (prec == v[j]) {
                    for (int k = 0; k < v.length; k++) {
                        
                        if(dest == v[k]){
                            Briauna atr = new Briauna(prec, dest);
                            if(!atrinktos.exists(atr))
                                atrinktos.Dėti(atr);
                        }
                    }
                }
            }
        }
        return atrinktos;
    }
    public static int ieškoti(Pogrupis[] pogrupis, int i){
        if (pogrupis[i].parent != i) 
            pogrupis[i].parent = ieškoti(pogrupis, pogrupis[i].parent); 
  
        return pogrupis[i].parent;
    }
    public static void Union(Pogrupis[] pogrupis, int x, int y) 
    { 
        int xroot = ieškoti(pogrupis, x); 
        int yroot = ieškoti(pogrupis, y); 
  
        if (pogrupis[xroot].height < pogrupis[yroot].height) 
            pogrupis[xroot].parent = yroot; 
        else if (pogrupis[xroot].height > pogrupis[yroot].height) 
            pogrupis[yroot].parent = xroot; 

        else
        { 
            pogrupis[yroot].parent = xroot; 
            pogrupis[xroot].height++; 
        } 
    }
    public static void KruskalMST(Briaunos atrinktos, int[] V) 
    { 
        int max = Arrays.stream(V).max().getAsInt();
        //int maxx = atrinktos.max();
        
        Briauna result[] = new Briauna[V.length];
        int e = 0;
        int i = 0; 
        for (i=0; i<V.length; ++i) 
            result[i] = new Briauna(); 
  
  
        Pogrupis[] pogrupis = new Pogrupis[max+1]; 
//        for(i = 0; i < V.length; ++i) 
//            subsets[i]=new Subset(); 
//  
//         Create V subsets with single elements 
//        for (int v = 0; v < V.length; ++v) 
//        { 
//            subsets[v].parent = v; 
//            subsets[v].rank = 0; 
//        } 
        
        for (int num : V){
            pogrupis[num]=new Pogrupis();
            pogrupis[num].parent = num;
            pogrupis[num].height = 0;
        }

  
        i = 0;
  
        while (e < V.length -1) 
        { 
            Briauna next_edge = new Briauna(); 
            next_edge = atrinktos.Imti(i++); 
  
            int x = ieškoti(pogrupis, next_edge.imtiPrec()); 
            int y = ieškoti(pogrupis, next_edge.imtiDest()); 
  
            if (x != y) 
            { 
                result[e++] = next_edge; 
                Union(pogrupis, x, y); 
            } 
        } 
        
            System.out.println("Medis sukonstruotas iš briaunų: ");
            for (i = 0; i < e; ++i) {
                System.out.println(result[i].imtiPrec() + " -- "
                        + result[i].imtiDest());
            }
    }
}
