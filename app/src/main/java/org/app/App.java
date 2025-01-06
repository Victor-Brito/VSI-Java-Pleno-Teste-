package org.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        String fileName = "inputs.txt"; // Nome do arquivo de entrada na pasta resources

        // Obtém o ClassLoader para carregar recursos
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(App.class.getClassLoader().getResourceAsStream(fileName)))) {
            String line;
            // Lê o arquivo linha por linha
            while ((line = reader.readLine()) != null) {
                // Para cada linha, gera os anagramas
                System.out.println("Anagramas para: " + line);
                AnagramGenerator.generateAnagrams(line);
                System.out.println();  // Adiciona uma linha em branco para separação
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
