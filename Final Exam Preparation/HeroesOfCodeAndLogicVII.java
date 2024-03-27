package FinalExam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> heroesHP = new LinkedHashMap<>();
        Map<String, Integer> heroesMP = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] heroes = scanner.nextLine().split(" ");
            heroesHP.put(heroes[0], Integer.parseInt(heroes[1]));
            heroesMP.put(heroes[0], Integer.parseInt(heroes[2]));
        }
        while (true){
            String[] command = scanner.nextLine().split(" - ");
            if (command[0].equals("End")){
                break;
            }
            String name = command[1];
            switch (command[0]){
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(command[2]);
                    if (heroesMP.get(name) >= mpNeeded){
                        heroesMP.put(name, heroesMP.get(name) - mpNeeded);
                        System.out.printf("%s has successfully cast %s and now has %s MP!\n",
                                name, command[3], heroesMP.get(name));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!\n",
                                name, command[3]);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(command[2]);
                    heroesHP.put(name, heroesHP.get(name) - damage);
                    if (heroesHP.get(name) > 0){
                        System.out.printf("%s was hit for %s HP by %s and now has %s HP left!\n",
                                name, damage, command[3], heroesHP.get(name));
                    } else {
                        System.out.printf("%s has been killed by %s!\n",  name, command[3]);
                        heroesHP.remove(name);
                        heroesMP.remove(name);
                    }
                    break;
                case "Recharge":
                    int currentMP = heroesMP.get(name);
                    heroesMP.put(name, heroesMP.get(name) + Integer.parseInt(command[2]));
                    if (heroesMP.get(name)> 200){
                        heroesMP.put(name, 200);
                    }
                    System.out.printf("%s recharged for %s MP!\n", name, heroesMP.get(name) - currentMP);
                    break;
                case "Heal":
                    int currentHP = heroesHP.get(name);
                    heroesHP.put(name, heroesHP.get(name) + Integer.parseInt(command[2]));
                    if (heroesHP.get(name)> 100){
                        heroesHP.put(name, 100);
                    }
                    System.out.printf("%s healed for %s HP!\n", name, heroesHP.get(name) - currentHP);
                    break;
            }
        }
        heroesHP.entrySet().forEach(e-> System.out.printf("%s\n  HP: %s\n  MP: %s\n", e.getKey(), e.getValue(), heroesMP.get(e.getKey())));
    }
}
