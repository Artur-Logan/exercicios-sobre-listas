package exemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        //como declarar lista e instanciar uma lista
        List<String> lista = new ArrayList<>();

        //como adicionar elementos na lista
        lista.add("Maria");
        lista.add("Midoriya");
        lista.add("Steve");
        lista.add("Natasha");
        lista.add("Tony");
        lista.add("Bruce");
        lista.add("Odinson");
        lista.add("Barton");

        //verificar tamanho de uma lista
        System.out.println(lista.size());

        //como testar e imprimir a lista
        for (String x : lista){
            System.out.println(x);
        }

        System.out.println("--------------------------------------------------");

        //como inserir um elemento dentro de uma lista
        lista.add(2, "Loki");

        //como remover um elemento de uma lista de duas maneiras
        lista.remove("Tony");
        lista.remove(2);

        //como remover por predicado
        lista.removeIf(x -> x.charAt(0) == 'M');

        for (String x : lista){
            System.out.println(x);
        }

        System.out.println("--------------------------------------------------");

        //encontrar a posicao de um elemento
        System.out.println("Index de Bruce é : " + lista.indexOf("ok"));

        System.out.println("--------------------------------------------------");

        //como filtrar minha lista
        List<String> resultado = lista.stream().filter(x -> x.charAt(0) == 'B').collect(Collectors.toList());
        for (String x : resultado){
            System.out.println(x);
        }

        System.out.println("--------------------------------------------------");

        //como encontrar um elemneto da lista que atenda um certo predicado
        String nome = lista.stream().filter(x -> x.charAt(0) == 'B').findFirst().orElse(null);
        System.out.println(nome);


        sc.close();
    }
}
