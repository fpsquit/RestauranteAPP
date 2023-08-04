import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private int codigoVenda;
    private String nomeCliente;
    private List<Produto> itens;
    private double valorTotal;

    public Comanda(String nomeCliente) {
        this.codigoVenda = ManipuladorArquivoTXT.obterProximoCodigoVenda();
        this.nomeCliente = nomeCliente;
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public int getCodigoVenda()
    {
        return codigoVenda;
    }
    public String getNomeCliente()
    {
        return nomeCliente;
    }

    public double getValorTotal()
    {
        return valorTotal;
    }

    public List<Produto> getItens() {
        return new ArrayList<>(itens);
    }

    public void adicionarItem(Produto produto)
    {
        itens.add(produto);
        valorTotal += produto.getPreco();
    }

    @Override
    public String toString()
    {
        return getCodigoVenda() + " | " + getNomeCliente() + " | " + " R$ " + getValorTotal();
    }


}
