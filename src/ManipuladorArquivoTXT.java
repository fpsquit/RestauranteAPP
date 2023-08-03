import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManipuladorArquivoTXT {
    public static List<Produto> carregarProdutosDoArquivo() {
        List<Produto> produtos = new ArrayList<>();

        try {
            File arquivoProdutos = new File("src/ArquivosTXT/produtos.txt");
            FileInputStream arquivo = new FileInputStream(arquivoProdutos);
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split("\\|");

                int codigo = Integer.parseInt(partes[0].trim());
                String nomeProduto = partes[1].trim();
                double preco = Double.parseDouble(partes[2].trim());

                Produto produto = new Produto(codigo, nomeProduto, preco);
                produtos.add(produto);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de produtos.txt não encontrado.");
        }

        return produtos;
    }

    public static void salvarArquivoVendas (Comanda comanda) {
        File arquivoVendas = new File("src/ArquivosTXT/vendas.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoVendas, true))) {
            writer.write(comanda.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar a venda no arquivo vendas.txt.");
        }
    }


}
