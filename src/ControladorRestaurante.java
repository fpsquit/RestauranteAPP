import java.util.List;

public class ControladorRestaurante {
    private Comanda comandaAtual;
    private List<Produto> produtos;

    public ControladorRestaurante() {
        this.comandaAtual = null;
        this.produtos = ManipuladorArquivoTXT.carregarProdutosDoArquivo();
    }

    public void iniciarComanda(String nomeCliente) {
        comandaAtual = new Comanda(nomeCliente);
        System.out.println("Comanda Iniciada do " + comandaAtual.getNomeCliente());
    }

    public void exibirProdutosDisponiveis() {
        if (produtos.isEmpty()) {
            System.out.println("Não há produtos disponíveis.");
        } else {
            System.out.println("Produtos disponíveis:");
            for (Produto produto : produtos) {
                System.out.println(produto.getCodigo() + " | " + produto.getNomeProduto() + " | R$ " + produto.getPreco());
            }
            System.out.println();
        }
    }

    public void exibirComandaAtual()
    {
        System.out.println("Comanda Atual de " + comandaAtual.getNomeCliente());
        for (Produto produto : comandaAtual.getItens())
        {
            System.out.println(produto.getNomeProduto() + " | R$ " + produto.getPreco());
        }
        System.out.println("Valor total: R$ " + comandaAtual.getValorTotal());
        System.out.println();

    }


    private Produto encontrarProdutoPorCodigo(int codigoProduto) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigoProduto) {
                return produto;
            }
        }
        return null;
    }

    public void adicionarItemComanda(int codigoProduto) {
        Produto produto = encontrarProdutoPorCodigo(codigoProduto);
        if (produto != null) {
            comandaAtual.adicionarItem(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void finalizarComanda() {
        if (comandaAtual != null) {
            ManipuladorArquivoTXT.salvarArquivoVendas (comandaAtual);
            System.out.println("Comanda finalizada e salva no arquivo vendas.txt.");
        } else {
            System.out.println("Nenhuma comanda em andamento.");
        }
    }


}
