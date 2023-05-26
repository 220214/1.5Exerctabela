package view;
import javax.swing.JOptionPane;

import Controller.TabelaEspalhamento;
import model.ContaBancaria;

public class MainView {
    public static void main(String[] args) {
        TabelaEspalhamento tabela = new TabelaEspalhamento();

        while (true) {
            String opcao = JOptionPane.showInputDialog(
                "Escolha uma opção:\n" +
                "1. Inserir conta\n" +
                "2. Consultar conta\n" +
                "3. Remover conta\n" +
                "4. Sair"
            );

            switch (opcao) {
                case "1":
                    int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta:"));
                    String nomeCliente = JOptionPane.showInputDialog("Digite o nome do cliente:");
                    double saldo = Double.parseDouble(JOptionPane.showInputDialog("Digite o saldo da conta:"));
                    ContaBancaria conta = new ContaBancaria(numeroConta, nomeCliente, saldo);
                    tabela.inserir(conta);
                    break;

                case "2":
                    int numeroConsulta = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta a ser consultada:"));
                    tabela.consultar(numeroConsulta);
                    break;

                case "3":
                    int numeroRemocao = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta a ser removida:"));
                    tabela.remover(numeroRemocao);
                    break;

                case "4":
                    System.exit(0);
            }
        }
    }
}