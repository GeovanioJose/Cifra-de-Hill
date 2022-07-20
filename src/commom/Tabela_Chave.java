/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commom;

import java.util.Arrays;

/**
 *
 * @author Teste
 */
public class Tabela_Chave {
    char tabela[]={'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'};
    char tabela2[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
                        'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    char tabela_perso[];
    
    public Tabela_Chave(int tipo,char tabela_perso[]){
        if(tipo==1 | tipo==2){
            if(tipo==2){
                this.tabela_perso=this.tabela;
            }
            else{
                this.tabela_perso=this.tabela2; 
            }
        }
        else{
            this.tabela_perso=tabela_perso;
        }
        
    }   
    public boolean letra_na_tabela(char a){
        for(int i=0; i<=tabela_perso.length; i++){
            String letra_comp=""+a;
            String letra_atual_tabela=""+tabela[i];
            if(letra_comp.equals(letra_atual_tabela)){
                return true;
            } 
        }
        return false;
    }
    
    int letra_para_codigo(char c) {
        System.out.println("====LETRA PARA CODIGO====");
        System.out.println("Letra recebida:"+c);
        int codigo=0;
        for(int i=0; i<=tabela_perso.length; i++){
            if(tabela_perso[i]==c){
                codigo=i;
                System.out.println("Correspondencia encontrada!:");
                break;
            }
        }
        System.out.println("Código correspondente:"+codigo);
        return codigo;
    }
    
    char codigo_para_letra(int codigo) {
        System.out.println("Tamanho da tabela é:"+tabela_perso.length);
        System.out.println("Código da letra atual:"+codigo);
        int modulo_tabela = tabela_perso.length-1;
        
        if(codigo>tabela_perso.length-1){
            codigo=codigo%tabela_perso.length;
            System.out.println("NOVO CODIGO"+codigo);
        }
        
        char letra=0;
        letra=tabela_perso[codigo];
        System.out.println("Letra do código "+codigo+" é: "+letra);
        return letra;
    }
    public void alterar_tabela(char nova_tabela[]){
        this.tabela_perso=nova_tabela;
    }

    public boolean verificar_frase(char[] letras) {
        for(int i=1; i<=letras.length; i++){
            if(this.letra_na_tabela(letras[i])){
                return true;
                }
            else{
                return false;
            }
        }
        return true;
    }
}
