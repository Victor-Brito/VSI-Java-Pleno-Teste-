package org.app;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AnagramGeneratorTest {

    @Test
    public void testGenerateAnagrams_validInput() {
        // Testando com entrada válida
        String input = "abc";
        // Esperado: 6 anagramas
        String[] expected = {"abc", "acb", "bac", "bca", "cab", "cba"};
        assertArrayEquals(expected, captureOutput(() -> AnagramGenerator.generateAnagrams(input)));
    }

    @Test
    public void testGenerateAnagrams_singleLetter() {
        // Testando com uma única letra
        String input = "a";
        // Esperado: 1 anagrama
        String[] expected = {"a"};
        assertArrayEquals(expected, captureOutput(() -> AnagramGenerator.generateAnagrams(input)));
    }

    @Test
    public void testGenerateAnagrams_emptyInput() {
        // Testando com entrada vazia
        String input = "";
        String[] expected = {"Erro: A entrada não pode ser vazia."};
        assertArrayEquals(expected, captureOutput(() -> AnagramGenerator.generateAnagrams(input)));
    }

    @Test
    public void testGenerateAnagrams_invalidCharacters() {
        // Testando com caracteres inválidos (números)
        String input = "a1b";
        String[] expected = {"Erro: A entrada deve conter apenas letras."};
        assertArrayEquals(expected, captureOutput(() -> AnagramGenerator.generateAnagrams(input)));
    }

    // Método auxiliar para capturar o output no console
    private String[] captureOutput(Runnable runnable) {
        // Captura a saída do console
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        runnable.run();  // Executa a função

        return outContent.toString().split(System.lineSeparator());
    }
}
