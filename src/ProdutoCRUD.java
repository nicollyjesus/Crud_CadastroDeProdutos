// Importa as classes necessárias para usar listas e entrada de dados pelo teclado
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Declaração da classe principal do programa
public class ProdutoCRUD {

    // Classe interna para representar um produto
    static class Produto {
        // Atributos (variáveis) que cada produto terá
        int id;
        String nome;
        double preco;

        // Construtor da classe Produto, que cria um novo produto com id, nome e preco
        Produto(int id, String nome, double preco) {
            this.id = id;
            this.nome = nome;
            this.preco = preco;
        }

        // Método para retornar uma representação em texto do produto
        @Override
        public String toString() {
            return id + ": " + nome + " - " + preco;
        }
    }

    // Método principal que executa o programa
    public static void main(String[] args) {
        // Cria uma lista para armazenar produtos
        List<Produto> produtos = new ArrayList<>();
        // Cria um objeto Scanner para ler a entrada do usuário
        Scanner scanner = new Scanner(System.in);
        // Variável para contar os IDs dos produtos automaticamente
        int contadorId = 1;

        // Loop infinito para exibir o menu e executar as operações
        while (true) {
            // Exibe as opções do menu para o usuário
            System.out.println("1. Criar\n2. Listar\n3. Atualizar\n4. Deletar\n5. Sair");
            // Lê a opção escolhida pelo usuário
            int opcao = scanner.nextInt();

            // Se a opção for 1, cria um novo produto
            if (opcao == 1) {
                System.out.print("Nome: ");
                // Lê o nome do produto
                String nome = scanner.next();
                System.out.print("Preço: ");
                // Lê o preço do produto
                double preco = scanner.nextDouble();
                // Adiciona o novo produto à lista, incrementando o contador de ID
                produtos.add(new Produto(contadorId++, nome, preco));

                // Se a opção for 2, lista todos os produtos
            } else if (opcao == 2) {
                for (Produto p : produtos) {
                    // Exibe cada produto
                    System.out.println(p);
                }

                // Se a opção for 3, atualiza um produto existente
            } else if (opcao == 3) {
                System.out.print("ID: ");
                // Lê o ID do produto a ser atualizado
                int id = scanner.nextInt();
                for (Produto p : produtos) {
                    // Encontra o produto pelo ID
                    if (p.id == id) {
                        System.out.print("Novo nome: ");
                        // Lê o novo nome do produto
                        p.nome = scanner.next();
                        System.out.print("Novo preço: ");
                        // Lê o novo preço do produto
                        p.preco = scanner.nextDouble();
                    }
                }

                // Se a opção for 4, deleta um produto existente
            } else if (opcao == 4) {
                System.out.print("ID: ");
                // Lê o ID do produto a ser deletado
                int id = scanner.nextInt();
                // Remove o produto da lista, se encontrar o ID correspondente
                produtos.removeIf(p -> p.id == id);

                // Se a opção for 5, sai do programa
            } else if (opcao == 5) {
                break;
            }
        }
        // Fecha o scanner
        scanner.close();
    }
}