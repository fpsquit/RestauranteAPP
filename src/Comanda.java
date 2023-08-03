import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private static int proximoCodigoVenda = 1;
    private int codigoVenda;
    private String nomeCliente;
    private List<Produto> itens;
    private double valorTotal;

    public Comanda(String nomeCliente) {
        this.codigoVenda = proximoCodigoVenda++;
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
        return codigoVenda + " | " + nomeCliente + " | " + " R$ " + valorTotal;
    }


}
