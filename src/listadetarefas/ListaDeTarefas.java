/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listadetarefas;

import java.util.Scanner;

public class ListaDeTarefas {

    public static void main(String[] args) {
        Cod.criarTabela(); 
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nDigite o numero correspondente:\n1. Adicionar tarefa");
            System.out.println("2. Alterar status");
            System.out.println("3. Ver todas");
            System.out.println("4. Ver pendentes");
            System.out.println("5. Ver concluidas");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite a tarefa: ");
                    String texto = sc.nextLine();
                    Cod.adicionarTarefa(texto);
                }
                case 2 -> {
                    System.out.print("ID da tarefa: ");
                    int id = sc.nextInt();
                    System.out.print("Marcar como concluída (true/false): ");
                    boolean status = sc.nextBoolean();
                    Cod.alterarStatus(id, status);
                }
                case 3 ->
                    Cod.listarTarefas("todas");
                case 4 ->
                    Cod.listarTarefas("pendentes");
                case 5 ->
                    Cod.listarTarefas("concluidas");
                case 0 -> {
                    System.out.println("Saindo...");
                    System.exit(0);
                }
                default ->
                    System.out.println("Opção nao existe"); 
            }
        }
    }
}
