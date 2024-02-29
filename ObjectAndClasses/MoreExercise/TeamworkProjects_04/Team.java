package ObjectsAndClasses_MoreExercise.TeamworkProjects_04;

import java.util.List;

public class Team {
public String teamName;
public String creator;
public List<String> users;

    public Team(String teamName, String creator, List<String> users) {
        this.teamName = teamName;
        this.creator = creator;
        this.users = users;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getCreator() {
        return creator;
    }

    public List<String> getUsers() {
        return users;
    }
}
