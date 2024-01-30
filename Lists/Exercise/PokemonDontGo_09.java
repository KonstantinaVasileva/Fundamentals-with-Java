package ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pokemon = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (!pokemon.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int value;
            if (index >= 0 && index < pokemon.size()) {
                value = pokemon.get(index);
                pokemon.remove(index);

            } else if (index < 0) {
                value = pokemon.get(0);
                pokemon.remove(0);
                pokemon.add(0, pokemon.get(pokemon.size() - 1));
            } else {
                value = pokemon.get(pokemon.size() - 1);
                pokemon.remove(pokemon.size() - 1);
                pokemon.add(pokemon.get(0));
            }
            for (int i = 0; i < pokemon.size(); i++) {
                if (value >= pokemon.get(i)) {
                    pokemon.add(i, pokemon.get(i) + value);
                    pokemon.remove(i + 1);
                } else {
                    pokemon.add(i, pokemon.get(i) - value);
                    pokemon.remove(i + 1);
                }
            }
            sum += value;
        }

        System.out.println(sum);

    }
}
