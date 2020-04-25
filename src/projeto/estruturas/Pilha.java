package projeto.estruturas;

import projeto.interfaces.PilhaTAD;

/**
 * @param<T>
 * @author guinh
 */
public class Pilha<T> implements PilhaTAD<T> {
    private T[] elementos;
    private int tamanhoAtual;
    
    public Pilha(int cap){
        this.elementos = (T[]) new Object[cap];
        this.tamanhoAtual = 0;
    }
    
    public Pilha(){
        this.elementos = (T[]) new Object[10];
        this.tamanhoAtual = 0;
    }

    @Override
    public int tamanho() {
        return this.tamanhoAtual;
    }

    @Override
    public boolean estaVazia() {
        return this.tamanho() == 0;
    }

    @Override
    public boolean estaCheia() {
        return this.tamanho() == this.elementos.length;
    }

    @Override
    public boolean empilhar(T item) {
        if(this.estruturaNula() || this.estaCheia() || this.itemNulo(item)){
            return false;
        }
        
        this.elementos[this.tamanho()] = item;
        this.tamanhoAtual++;
        return true;
    }

    @Override
    public boolean remover() {
        if(this.estruturaNula() || this.estaVazia()){
            return false;
        }
        
        this.elementos[this.tamanho()-1] = null;
        this.tamanhoAtual--;
        return true;
    }

    @Override
    public boolean buscar(T item) {
        if(this.estruturaNula() || this.estaVazia() || this.itemNulo(item)){
            return false;
        }
        
        for(int i=this.tamanho()-1; i>=0; i--){
            if(this.elementos[i].equals(item)){
                return true;
            }
        }
        
        return false;
    }

    @Override
    public int indice(T item) {
        if(this.estruturaNula() || this.estaVazia() || this.itemNulo(item)){
            return -1;
        }
        
        for(int i=this.tamanho()-1; i>=0; i--){
            if(this.elementos[i].equals(item)){
                return i;
            }
        }
        
        return -1;
    }

    @Override
    public String exibirTopo() {
        StringBuilder conteudo = new StringBuilder();
        conteudo.append("[");
        
        if(!this.estaVazia()){
            conteudo.append(this.elementos[this.tamanho()-1].toString());
        }
                
        conteudo.append("]");
        
        return conteudo.toString();
    }

    @Override
    public String exibir(int indice) {
        if(this.indiceInvalido(indice)){
            return "";
        }
        
        StringBuilder conteudo = new StringBuilder();
        conteudo.append("[").append(this.elementos[indice].toString()).append("]");
        return conteudo.toString();
    }

    @Override
    public String exibir() {
        StringBuilder conteudo = new StringBuilder();
        conteudo.append("[");
        
        if(this.tamanho()>1){
            for(int i=this.tamanho()-1; i>0; i--){
                conteudo.append(this.elementos[i].toString());
                conteudo.append(",");
            }
        }
        if(this.tamanho()>0){
            conteudo.append(this.elementos[0].toString());
        }
        
        conteudo.append("]");
        return conteudo.toString();
        
    }

    @Override
    public boolean limpar() {
        if(this.estruturaNula() || this.estaVazia()){
            return false;
        }
        
        while(this.remover());
        return true;
    }
    
    private boolean estruturaNula(){
        if(this.elementos == null){
            return true;
        }
        
        return false;
    }
    
    private boolean indiceInvalido(int indice){
        if(indice < 0 || indice > this.tamanho()){
            return true;
        }
        
        return false;
    }
    
    private boolean itemNulo(T item){
        boolean retorno = true;
        
        if(item != null){
            retorno = false;
        }
        
        return retorno;
    }
}
