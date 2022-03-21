package exercicio;

import exercicio.entidade.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Funcionario> funcionarioList = new ArrayList<>();

        System.out.println("Quantos funcionarios serão registrados? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++){
            System.out.println();
            System.out.println("Funcionario #" + (i+1) + ":");

            System.out.print("Id: ");
            Integer id = sc.nextInt();
            while (hasId(funcionarioList, id)){
                System.out.println("Esse Id ja existe");
                id = sc.nextInt();
            }

            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Salario: ");
            Double salario = sc.nextDouble();
            System.out.println();

            Funcionario funcionario = new Funcionario(id, nome, salario);
            funcionarioList.add(funcionario);
        }

        System.out.println();
        System.out.println("Digite o id do funcionario que terá o salario reajustado: ");
        int idProcura = sc.nextInt();
        Funcionario funcionario = funcionarioList.stream().filter(x -> x.getId() == idProcura).findFirst().orElse(null);
        if (funcionario == null){
            System.out.println("Esse id não existe");
        } else {
            System.out.println("Entre com a porcentagem: ");
            double porcentagem = sc.nextDouble();
            funcionario.aumento(porcentagem);
        }

        System.out.println();
        System.out.print("Lista de funcionarios");
        System.out.println();
        for (Funcionario obj : funcionarioList){
            System.out.println(obj);
        }
    }

    public static boolean hasId(List<Funcionario> funcionarioList, int id){
        Funcionario funcionario = funcionarioList.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return funcionario != null;
    }

}
