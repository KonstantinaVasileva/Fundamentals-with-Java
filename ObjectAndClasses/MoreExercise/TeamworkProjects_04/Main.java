package ObjectsAndClasses_MoreExercise.TeamworkProjects_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfTeam = Integer.parseInt(scanner.nextLine());
        List<Team> teams = new ArrayList<>();

        for (int i = 0; i < countOfTeam; i++) {
            String[] teamInfo = scanner.nextLine().split("-".trim());
            String creator = teamInfo[0].trim();
            String teamName = teamInfo[1].trim();
            Team team = new Team(teamName, creator, new ArrayList<>());

            if (isTeamCreated(teamName, teams)) {
                System.out.printf("Team %s was already created!\n", teamName);
            } else if (isAlreadyCreator(creator, teams)) {
                System.out.printf("%s cannot create another team!\n", creator);
            } else {
                teams.add(team);
                System.out.printf("Team %s has been created by %s!\n", teamName, creator);
            }
        }
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("end of assignment")) {
                break;
            }
            String[] member = command.split("->".trim());
            String user = member[0].trim();
            String teamName = member[1].trim();

            if (!isTeamCreated(teamName, teams)) {
                System.out.printf("Team %s does not exist!\n", teamName);
            } else if (isAlreadyUser(user, teams)) {
                System.out.printf("Member %s cannot join team %s!\n", user, teamName);
            } else {
                for (int i = 0; i < teams.size(); i++) {
                    if (teamName.equals(teams.get(i).getTeamName()) && !teams.get(i).getUsers().contains(user)) {
                        teams.get(i).getUsers().add(user);
                        break;
                    }
                }
            }
        }
        teams.sort(Comparator.comparing(Team::getTeamName));
        teams.sort(Comparator.<Team>comparingInt(o -> o.getUsers().size()).reversed());

        for (Team team : teams) {
            if (!team.getUsers().isEmpty()) {
                team.getUsers().sort(String::compareTo);
                System.out.println(team.getTeamName());
                System.out.println("- " + team.getCreator());
                for (int i = 0; i < team.getUsers().size(); i++) {
                    System.out.println("-- " + team.getUsers().get(i));
                }
            }
        }
        System.out.println("Teams to disband:");
        for (Team team:teams){
            if (team.getUsers().isEmpty()){
                System.out.println(team.getTeamName());
            }
        }
    }

    public static boolean isTeamCreated(String teamName, List<Team> teams) {
        for (Team team : teams) {
            if (teamName.equals(team.getTeamName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAlreadyCreator(String creator, List<Team> teams) {
        for (Team team : teams) {
            if (creator.equals(team.getCreator())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAlreadyUser(String user, List<Team> teams) {
        for (Team team : teams) {
            if (team.getUsers().contains(user) || team.getCreator().equals(user)) {
                return true;
            }
        }
        return false;
    }

}
