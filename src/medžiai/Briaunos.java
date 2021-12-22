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
public class Briaunos {
    
    final int CMax = 100;
    private Briauna[] Briaun;
    private int n;
    
    public Briaunos(){
        n = 0;
        Briaun = new Briauna[CMax];
    }
    public Briauna Imti(int i) {return Briaun[i];}
    public int ImtiKiek() {return n;}
    public void Dėti(Briauna br) {Briaun[n++] = br;}
//    public int KiekŠalinti(){
//        int kiekis = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                Briauna briaun1 = new Briauna(Imti(i).imtiPrec(), Imti(i).imtiDest());
//                Briauna briaun2 = new Briauna(Imti(j).imtiPrec(), Imti(j).imtiDest());
//                if (briaun1.imtiDest() == briaun2.imtiPrec() && briaun2.imtiDest() ==  briaun1.imtiPrec()){
//                    kiekis++;
//                    break;
//                }
//            }
//            
//        }
//        return kiekis;
//    }
//    public int KurįŠalinti(){
//        int nr = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i+1; j < n; j++) {
//                Briauna briaun1 = new Briauna(Imti(i).imtiPrec(), Imti(i).imtiDest());
//                Briauna briaun2 = new Briauna(Imti(j).imtiPrec(), Imti(j).imtiDest());
//                if (briaun1.imtiDest() ==  briaun2.imtiPrec() && briaun2.imtiDest() ==  briaun1.imtiPrec()){
//                    nr = j;
//                    break;
//                }
//            }
//            
//        }
//        return nr;
//    }
//    
//    public void Šalinti() {
//        int kiekis = KiekŠalinti();
//        for (int i = 0; i < kiekis; i++) {
//            int k = KurįŠalinti();
//            for (int j = k; j < n - 1; j++) {
//                Briauna briaunaKop = Briaun[j+1];
//                Briaun[i] = briaunaKop;
//            }
//            n--;
//        }
//    }
    public boolean exists(Briauna br){
        boolean ex = false;
        for (int i = 0; i < n; i++) {
            ex = Briaun[i].imtiPrecDest() == br.imtiPrecDest();
        }
        return ex;
    }
    public int max(){
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < Briaun[i].imtiPrec() || Briaun[i].imtiPrec() > Briaun[i].imtiDest()) {
                max = Briaun[i].imtiPrec();
            } else if (max < Briaun[i].imtiDest()) {
                max = Briaun[i].imtiDest();
            }
        }
        return max;
    }
}
