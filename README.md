# Anagram Generator

Este projeto é uma aplicação em Java que gera todos os anagramas possíveis para uma dada string de entrada, validando a entrada antes de processá-la. A seguir, está a explicação detalhada de como o código funciona, juntamente com instruções de como usá-lo e como contribuir.

## Funcionalidade

A principal funcionalidade do projeto é gerar todos os anagramas possíveis de uma palavra fornecida como entrada por meio de um arquivo .txt. O programa possui validações básicas, como garantir que a entrada não esteja vazia e que contenha apenas letras. Caso contrário, ele imprime uma mensagem de erro.

### Principais Características:
- **Geração de Anagramas**: Utiliza recursão para gerar as permutações de letras.
- **Validação de Entrada**: Verifica se a entrada é válida (não vazia e composta apenas por letras).
- **Exibição dos Anagramas**: Exibe os anagramas gerados no console.

## Como Funciona

O código possui duas funções principais:

### 1. `generateAnagrams(String input)`

Esta é a função principal que recebe uma string `input` e gera todos os anagramas possíveis dessa string.

#### Passos:
- **Validação da Entrada**: A função verifica se a entrada é vazia ou contém caracteres não alfabéticos.
- **Geração de Anagramas**: Chama a função recursiva `generateAnagramsHelper`.
- **Exibição**: Exibe os anagramas gerados no console.

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
```
### 2. `generateAnagramsHelper(String prefix, String remaining, List<String> anagrams)`

Esta função é chamada recursivamente para gerar todas as permutações possíveis da entrada. Ela é a responsável pela lógica de combinação dos caracteres da string para gerar os anagramas.

#### Passos:
- **Prefixo**: A função começa com um prefixo vazio e vai adicionando os caracteres da string `remaining`.
- **Remanescente**: Calcula o restante da string para continuar o processo de permutação. Isso é feito retirando o caractere atual do restante e passando-o para o prefixo.
- **Recursão**: A função continua se chamando até que não haja mais caracteres para permutar (quando `remaining` tem comprimento zero). Quando isso ocorre, o prefixo é adicionado à lista de anagramas.

```java
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

