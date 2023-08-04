import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControladorRestaurante controlador = new ControladorRestaurante();
        Scanner input = new Scanner(System.in);

        int opcaoMenuPrincipal;

        while (true) {

            MenuHelpers.exibirMenuPrincipal();
            opcaoMenuPrincipal = input.nextInt();


            switch (opcaoMenuPrincipal) {
                case 1:

                    System.out.println("Digite o nome do cliente:");
                    String nomeCliente = input.next();
                    controlador.iniciarComanda(nomeCliente);

                    boolean sairComanda = false;
                    while (!sairComanda) {

                        MenuHelpers.exibirMenuComanda();
                        int opcaoMenuComanda;
                        opcaoMenuComanda = input.nextInt();
                        System.out.println();

                        switch (opcaoMenuComanda) {
                            case 1:
                                boolean produtosSelecionados = false;
                                while (!produtosSelecionados) {
                                    System.out.println("Digite o código do produto que deseja adicionar à comanda: (0 para voltar ao menu)");
                                    int codigoProduto = input.nextInt();
                                    if (codigoProduto != 0) {
                                        System.out.println();
                                        controlador.adicionarItemComanda(codigoProduto);
                                        controlador.exibirComandaAtual();
                                    } else {
                                        produtosSelecionados = true;
                                    }
                                }
                                break;
                            case 2:
                                controlador.exibirProdutosDisponiveis();
                                break;
                            case 0:
                                controlador.finalizarComanda();
                                sairComanda = true;
                                break;
                            default:
                                System.out.println("Opção do Menu inválida. Por favor, tente novamente.");
                                break;
                        }
                    }

                    break;
                case 2:
                    System.out.println("Programa encerrado. Até breve!!!");
                    return;
                default:
                    System.out.println("Opção do Menu inválida. Por favor, tente novamente.");
                    break;
            }
        }
    }
}
