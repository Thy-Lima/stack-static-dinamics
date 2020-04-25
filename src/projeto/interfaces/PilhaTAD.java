package projeto.interfaces;

/**
 * @param<T>
 * @author guinh
 */
public interface PilhaTAD<T> {
    public int tamanho();
    public boolean estaVazia();
    public boolean estaCheia();
    public boolean empilhar(T item);
    public boolean remover();
    public boolean buscar(T item);
    public int indice(T item);
    public String exibirTopo();
    public String exibir(int indice);
    public String exibir();
    public boolean limpar();
}
