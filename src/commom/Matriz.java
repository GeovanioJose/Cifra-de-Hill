/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commom;

/**Classe que define o objeto matriz, seus atributos e métodos.
 *
 * @author Carlos
 */
public class Matriz {

    public int i;
    public int j;
    public int matriz[][];

    public Matriz(int i, int j,int matriz[][]){
        this.i=i;
        this.j=j;
        this.matriz=matriz;
    }
    
    /** Método para retornar número de linhas da matriz
    *   @return int  - i */
    public int getI() {
        return i;
    }

    /** Método para retornar número de colunas da matriz
    *   @return int  - j */
    public int getJ() {
        return j;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }
    
    public static void matriz_por_escalar(int n, Matriz a){
        for(int i=1; i<=a.i; i++){
            for(int j=1; j<=a.j; j++){
                a.matriz[i][j]=a.matriz[i][j]*n;   
            }
        }
    }
    
    /** Método para retornar número de colunas da matriz
    *   @return int  - j */
    public static Matriz Produto(Matriz a, Matriz b){
        System.out.println("EnTROU");
        int matriz_resu[][]=new int[a.getI()+1][b.getJ()+1];
        if(a.getJ()==b.getI()){
            int posi_i=1;
            int posi_j=1;
            int linha_atual_a=1;
            int coluna_atual_b=1;
            int loops=0;
            
            for (int cont=1; cont <= a.getI()*b.getJ();cont++){
                System.out.println("Linha e Coluna do Elemento da Matriz resultado:"+posi_i+" "+posi_j);
                
                
                
                int soma_posi_atual=0;
                for(int cont2=1; cont2<=a.getJ(); cont2++){
                    soma_posi_atual+=a.matriz[linha_atual_a][cont2]*b.matriz[cont2][coluna_atual_b];
                    System.out.println("");
                    System.out.println("elemento de a:"+linha_atual_a+" "+cont2+"multiplica por elento de b:"+cont2+" "+coluna_atual_b);
                }
                matriz_resu[posi_i][posi_j]=soma_posi_atual;
                loops++;
                if(loops>=b.getJ()){
                    linha_atual_a++;
                    posi_i++;
                    posi_j=1;
                    coluna_atual_b=1;
                    loops=0;
                    
                }
                else{
                    coluna_atual_b++;
                    posi_j++;
                    
                }
                
                
                
            } 
            
        }
        else{
            System.out.println("PRODUTO DE MATRIZ NÃO PODE SER REALIZADO!!! MOTIVO:");
            System.out.println("O NÚMERO DE COLUNAS DA MATRIZ A É:"+a.getJ()+"O NÚMERO DE LINHAS DA MATRIZ B É:"+b.getI());
        }
        return new Matriz(a.getI(),b.getJ(),matriz_resu);
    }
    
    
    public static int determinante(Matriz a){
        if(a.getI()==2 & a.getI()==2){
            int det=a.matriz[1][1]*a.matriz[2][2]-a.matriz[1][2]*a.matriz[2][1];
            System.out.println("O DETERMINATE É IGUAL A: "+det);
            return det;
        }
        if(a.getI()==3 & a.getI()==3){
            int det=a.matriz[1][1]*a.matriz[2][2]*a.matriz[3][3]+a.matriz[1][2]*a.matriz[2][3]*a.matriz[3][1]+a.matriz[1][3]*a.matriz[2][1]*a.matriz[3][2]-a.matriz[1][3]*a.matriz[2][2]*a.matriz[3][1]-a.matriz[1][1]*a.matriz[2][3]*a.matriz[3][2]-a.matriz[1][2]*a.matriz[2][1]*a.matriz[3][3];
            System.out.println("O DETERMINATE É IGUAL A: "+det);
            return det;
        }
        return -1;
    }
    
    public static Matriz inverter_matriz(Matriz a){
        if(a.getI()==2 & a.getI()==2){
            int det= Matriz.determinante(a);
            
            int temp11=  a.matriz[1][1];
            a.matriz[1][1]=a.matriz[2][2];
            a.matriz[2][2]=temp11;
            
            a.matriz[2][1]=a.matriz[2][1]*-1;
            a.matriz[1][2]=a.matriz[1][2]*-1;
            
            
            System.out.println("MATRIZ INVERSA:");
            System.out.println(a.matriz[1][1]+" "+a.matriz[1][2]);
            System.out.println(a.matriz[2][1]+" "+a.matriz[2][2]);
            
            
        }
        return a;    
    }
    
    public static void modulo_de_n(int modulo_tabela_tamanho, Matriz a) {
        for(int i=1; i<=a.i; i++){
            for(int j=1; j<=a.j; j++){
                if(a.matriz[i][j]<0 & (a.matriz[i][j]*-1)%modulo_tabela_tamanho==0){
                    a.matriz[i][j]=0;
                }
                if(a.matriz[i][j]<0 & (a.matriz[i][j]*-1)%modulo_tabela_tamanho!=0){
                    
                    a.matriz[i][j]=modulo_tabela_tamanho-((a.matriz[i][j]*-1)%modulo_tabela_tamanho);
                }
                else{
                    a.matriz[i][j]=a.matriz[i][j]%modulo_tabela_tamanho;
                }
                   
            }
        }
        
    }
    
    public static void imprimirMatriz(Matriz c){
        for(int i=1; i<= c.i; i++){
            for(int j=1; j<= c.j; j++){
                System.out.println("posi"+i+"x"+j+" elemento: "+c.matriz[i][j]);
            }
        
        }
    }
    
}
