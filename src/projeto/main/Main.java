package projeto.main;

import projeto.estruturas.Pilha;

/**
 *
 * @author guinh
 */
public class Main {
    public static void main(String[] args){
        Pilha<Integer> p = new Pilha(10);
        
        p.empilhar(1);
        p.empilhar(2);
        p.empilhar(3);
        p.limpar();
        System.out.println(""+p.exibir());
        
    }
}
