package org.app;

import java.util.List;
import java.util.ArrayList;

public class AnagramGenerator {

    // Função principal para gerar e imprimir os anagramas
    public static void generateAnagrams(String input) {
        // Validação da entrada
        if (input == null || input.isEmpty()) {
            System.out.println("Erro: A entrada não pode ser vazia.");
            return;
        }

        if (!input.matches("[a-zA-Z]+")) {
            System.out.println("Erro: A entrada deve conter apenas letras.");
            return;
        }

        List<String> anagrams = new ArrayList<>();
        generateAnagramsHelper("", input, anagrams);

        // Exibindo os anagramas
        for (String anagram : anagrams) {
            System.out.println(anagram);
        }
    }

    // Função recursiva para gerar permutações
    private static void generateAnagramsHelper(String prefix, String remaining, List<String> anagrams) {
        if (remaining.length() == 0) {
            anagrams.add(prefix);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                String newPrefix = prefix + remaining.charAt(i);
                String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
                generateAnagramsHelper(newPrefix, newRemaining, anagrams);
            }
        }
    }
}
