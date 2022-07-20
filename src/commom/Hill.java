/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commom;

/**
 *
 * @author Teste
 */
public class Hill {
    private char[] frase;
    public String frase_codi;
    public Tabela_Chave tabela;
    private Matriz matriz_chave;
    
    public static String codificar(char[] frase,Tabela_Chave tabela,Matriz matriz_chave,int grau ){
        
        //define o tamanho real da frase, com -1 referente ao "0"
        int tamanho_frase=frase.length-1;
        
        //grupo com matrizes geradas a partir dos grupos de letras(grau de hill) da frase
        Matriz[] grupo_frases=new Matriz [(tamanho_frase/grau)+1];
        int indice=1;
        for(int cont=1; cont<=tamanho_frase/grau; cont++){
            int[][] matriz_local=new int[matriz_chave.getJ()+1][1+1]; //+1 para permitir ignorar o uso da posi 0
            for(int i=1; i<=tamanho_frase; i++){
                if(indice>grau*cont){
                    break;
                }
                else{
                    //buscar codigo para letra atual
                    int codigo_de_letra_atual=0;
                    try{
                        codigo_de_letra_atual=tabela.letra_para_codigo(frase[indice]);
                        
                    }
                    catch (Exception e) {
                        System.out.println("erro ao tentar buscar letra para codigo na tabela, erro:"+e);
                        System.out.println("Erro na letra: "+frase[indice]+"no loop"+i+"que parte de 1. e no indice:"+indice);
                        return "ERRO"; 
                    }
                    
                    //criar matriz com códigos das frases
                    try{
                        matriz_local[i][1]=codigo_de_letra_atual;
                        
                    }
                    catch (Exception e) {
                        System.out.println("erro ao tentar adicionar codigo da letra na matriz(vetor local) do grupo da frase, erro:"+e);
                        System.out.println("Erro no loop"+i+" que parte de 1. e no indice:"+indice+" Tentativa de adicionar:"+codigo_de_letra_atual+"na posição ["+i+"][1]");
                        return "ERRO"; 
                    }
                    indice++;
                }    
            }
            grupo_frases[cont]=new Matriz(grau,1,matriz_local);
        }
            
            
            //multiplicar matriz chave por as matrizes codificadas da frase
            for(int i=1; i<grupo_frases.length; i++){
                try{
                    grupo_frases[i]=Matriz.Produto(matriz_chave,grupo_frases[i]);
                }
                catch(Exception e){
                    System.out.println("erro ao tentar calcular produto da matriz chave por matriz grupo frase, erro:"+e);
                    System.out.println("Erro no loop "+i+" que parte de 1.Erro no grupo de matriz grupo_frase["+i+"]");
                    return "ERRO";   
                }
            }
            System.out.println("FIM multiplicações matriz chave/ matriz grupo de frases");
            
            
            //passar códigos para letras 
            String frase_codificada="";
            for(int i=1; i<grupo_frases.length; i++){
                for(int codigo=1; codigo<=grau; codigo++){
                frase_codificada+=tabela.codigo_para_letra(grupo_frases[i].matriz[codigo][1]);
                }
                
            }
            System.out.println("char já codificado: "+frase_codificada);
            //String frase_codificada_s = String.copyValueOf(frase_codificada);
            //System.out.println("Texto já codificado: "+frase_codificada_s);
            return frase_codificada;
    }       
    
            
        
    
    
    //public static String descodificar(String frase_codificada,Tabela_Chave tabela,Matriz matriz_chave,int grau ){
    //    this.frase=frase;
    //}
    
    
    
}
