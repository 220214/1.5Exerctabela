package Controller;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import model.ContaBancaria;

public class TabelaEspalhamento {
    private List<LinkedList<ContaBancaria>> tabela;

    public TabelaEspalhamento() {
        tabela = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            tabela.add(new LinkedList<>());
        }
    }

    public void inserir(ContaBancaria conta) {
        int indice = calcularIndice(conta.getNumeroConta());
        tabela.get(indice).add(conta);
    }

    public void consultar(int numeroConta) {
        int indice = calcularIndice(numeroConta);
        LinkedList<ContaBancaria> lista = tabela.get(indice);
        for (ContaBancaria conta : lista) {
            if (conta.getNumeroConta() == numeroConta) {
                System.out.println("Número da conta: " + conta.getNumeroConta());
                System.out.println("Nome do cliente: " + conta.getNomeCliente());
                System.out.println("Saldo: R$" + conta.getSaldo());
                return;
            }
        }
        System.out.println("Conta não encontrada!");
    }

    public void remover(int numeroConta) {
        int indice = calcularIndice(numeroConta);
        LinkedList<ContaBancaria> lista = tabela.get(indice);
        for (ContaBancaria conta : lista) {
            if (conta.getNumeroConta() == numeroConta) {
                lista.remove(conta);
                System.out.println("Conta removida com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada!");
    }

    private int calcularIndice(int numeroConta) {
        return numeroConta % 10000;
    }
}