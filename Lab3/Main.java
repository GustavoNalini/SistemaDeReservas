import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Propriedade> propriedadesCadastradas = new ArrayList<>();

        // Adicionando propriedades pré-cadastradas
        propriedadesCadastradas.add(new Casa("Casa na Praia", "Uma bela casa com vista para o mar.", "Praia Grande", 300.00, true, 3, 50.00));
        propriedadesCadastradas.add(new Apartamento("Apartamento no Centro", "Apto confortável no coração da cidade.", "Centro", 150.00, true, 5));
        propriedadesCadastradas.add(new Casa("Chalé na Montanha", "Chalé aconchegante nas montanhas.", "Serra Negra", 200.00, true, 2, 30.00));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de usuário:");
        System.out.println("1. Proprietário");
        System.out.println("2. Cliente");
        int escolha = scanner.nextInt();
        scanner.nextLine();  // Consumir a nova linha

        if (escolha == 1) {
            // Proprietário
            System.out.print("Digite o nome do proprietário: ");
            String nomeProprietario = scanner.nextLine();
            System.out.print("Digite a senha do proprietário: ");
            String senhaProprietario = scanner.nextLine();
            Proprietario proprietario = new Proprietario(nomeProprietario, senhaProprietario);

            System.out.println("Proprietário registrado com sucesso!");

            while (true) {
                System.out.println("Menu do Proprietário:");
                System.out.println("1. Cadastrar Propriedade");
                System.out.println("2. Mostrar Propriedades Cadastradas");
                System.out.println("3. Sair");
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a nova linha

                if (opcao == 1) {
                    System.out.print("Digite o título da propriedade: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite a descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Digite a localidade: ");
                    String localidade = scanner.nextLine();
                    System.out.print("Digite o preço por noite: ");
                    double precoNoite = scanner.nextDouble();
                    scanner.nextLine();  // Consumir a nova linha

                    System.out.println("Tipo de Propriedade:");
                    System.out.println("1. Casa");
                    System.out.println("2. Apartamento");
                    int tipoPropriedade = scanner.nextInt();
                    scanner.nextLine();  // Consumir a nova linha

                    Propriedade novaPropriedade;
                    if (tipoPropriedade == 1) {
                        System.out.print("Digite o número de quartos: ");
                        int numeroQuartos = scanner.nextInt();
                        scanner.nextLine();  // Consumir a nova linha
                        System.out.print("Digite a taxa de limpeza: ");
                        double taxaLimpeza = scanner.nextDouble();
                        scanner.nextLine();  // Consumir a nova linha

                        novaPropriedade = new Casa(titulo, descricao, localidade, precoNoite, true, numeroQuartos, taxaLimpeza);
                    } else {
                        System.out.print("Digite o andar: ");
                        int andar = scanner.nextInt();
                        scanner.nextLine();  // Consumir a nova linha
                        novaPropriedade = new Apartamento(titulo, descricao, localidade, precoNoite, true, andar);
                    }

                    proprietario.addPropriedade(novaPropriedade);
                    propriedadesCadastradas.add(novaPropriedade);
                    System.out.println("Propriedade cadastrada com sucesso!");

                } else if (opcao == 2) {
                    proprietario.mostrarPropriedade();
                } else if (opcao == 3) {
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }
            }
        } else if (escolha == 2) {
            // Cliente
            System.out.print("Digite o nome do cliente: ");
            String nomeCliente = scanner.nextLine();
            System.out.print("Digite a senha do cliente: ");
            String senhaCliente = scanner.nextLine();
            Cliente cliente = new Cliente(nomeCliente, senhaCliente);

            System.out.println("Cliente registrado com sucesso!");

            while (true) {
                System.out.println("Menu do Cliente:");
                System.out.println("1. Fazer Reserva");
                System.out.println("2. Listar Reservas");
                System.out.println("3. Ver Propriedades Cadastradas");
                System.out.println("4. Sair");
                int opcao = scanner.nextInt();
                scanner.nextLine();  // Consumir a nova linha

                if (opcao == 1) {
                    if (propriedadesCadastradas.isEmpty()) {
                        System.out.println("Nenhuma propriedade cadastrada disponível para reserva.");
                    } else {
                        System.out.println("Escolha uma propriedade para reservar:");
                        for (int i = 0; i < propriedadesCadastradas.size(); i++) {
                            System.out.println((i + 1) + ". " + propriedadesCadastradas.get(i).getTitulo());
                        }
                        int escolhaPropriedade = scanner.nextInt();
                        scanner.nextLine();  // Consumir a nova linha

                        if (escolhaPropriedade > 0 && escolhaPropriedade <= propriedadesCadastradas.size()) {
                            Propriedade propriedadeEscolhida = propriedadesCadastradas.get(escolhaPropriedade - 1);

                            System.out.print("Digite a data de início (yyyy-mm-dd): ");
                            LocalDate dataInicial = LocalDate.parse(scanner.nextLine());

                            System.out.print("Digite a data final (yyyy-mm-dd): ");
                            LocalDate dataFinal = LocalDate.parse(scanner.nextLine());

                            Reserva novaReserva = new Reserva(propriedadeEscolhida, cliente, dataInicial, dataFinal);
                            cliente.fazerReserva(novaReserva);
                            System.out.println("Reserva feita com sucesso!");
                        } else {
                            System.out.println("Escolha inválida.");
                        }
                    }

                } else if (opcao == 2) {
                    List<Reserva> reservas = cliente.listarReservas();
                    if (reservas.isEmpty()) {
                        System.out.println("Nenhuma reserva feita.");
                    } else {
                        System.out.println("Reservas feitas:");
                        for (Reserva reserva : reservas) {
                            System.out.println("- Propriedade: " + reserva.getPropriedade().getTitulo());
                            System.out.println("  Data de Início: " + reserva.getDataInicial());
                            System.out.println("  Data Final: " + reserva.getDataFinal());
                            System.out.println("  Custo Total: " + reserva.getCustoTotal());
                        }
                    }

                } else if (opcao == 3) {
                    if (propriedadesCadastradas.isEmpty()) {
                        System.out.println("Nenhuma propriedade cadastrada.");
                    } else {
                        System.out.println("Propriedades cadastradas:");
                        for (Propriedade propriedade : propriedadesCadastradas) {
                            propriedade.mostrarDetalhes();
                        }
                    }

                } else if (opcao == 4) {
                    break;
                } else {
                    System.out.println("Opção inválida.");
                }
            }
        } else {
            System.out.println("Escolha inválida.");
        }

        scanner.close();
    }
}
