
import commom.Matriz;
import gui.Tela_Principal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Carlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //new Tela_Principal().setVisible(true);
        int[][] mama = new int[3][4];
        mama[1][1]=4;
        mama[1][2]=10;
        mama[1][3]=2;
        mama[2][1]=2;
        mama[2][2]=3;
        mama[2][3]=4;
        
        int[][] mama2 = new int[4][3];
        mama2[1][1]=2;
        mama2[1][2]=3;
        mama2[2][1]=3;
        mama2[2][2]=4;
        mama2[3][1]=1;
        mama2[3][2]=0;
        
        Matriz ma=new Matriz(2,3,mama);
        Matriz mb=new Matriz(3,2,mama2);
        Matriz mr=Matriz.Produto(ma,mb);
        System.out.println("A Matriz R tem:"+mr.getI()+"linhas e "+mr.getJ()+"colunas");
        
        for(int cont2=1; cont2<=2; cont2++){
            for(int cont=1; cont<=2; cont++){
                System.out.println(mr.matriz[cont2][cont]);
                
            }
            
                }
    }
    
}
