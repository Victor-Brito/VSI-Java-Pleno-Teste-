# Anagram Generator

Este projeto é uma implementação simples de um gerador de anagramas em Java. Ele recebe uma string como entrada e gera todas as permutações possíveis dessa string. O programa também realiza validações para garantir que a entrada seja válida (não vazia e composta apenas por letras).

## Funcionalidade

A classe `AnagramGenerator` contém dois métodos principais:

1. **`generateAnagrams(String input)`**: Método principal para gerar anagramas.
2. **`generateAnagramsHelper(String prefix, String remaining, List<String> anagrams)`**: Método recursivo que gera as permutações.

## Como Funciona

### 1. **Método `generateAnagrams(String input)`**

Este é o método principal da classe. Ele valida a entrada e, caso seja válida, gera os anagramas da string fornecida.

#### Entrada
- `input`: Uma string que representa a entrada do usuário, usada para gerar os anagramas.

#### Processo
- **Validação da entrada**:
    - Se a entrada for `null` ou vazia, imprime uma mensagem de erro: `"Erro: A entrada não pode ser vazia."` e retorna.
    - Se a entrada contiver caracteres não alfabéticos (utilizando a expressão regular `[a-zA-Z]+`), imprime: `"Erro: A entrada deve conter apenas letras."` e retorna.
- Se a entrada for válida, o método chama `generateAnagramsHelper` para gerar os anagramas e os imprime no console.

#### Saída
- O método imprime cada anagrama gerado no console, um por linha.

```java
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
