package ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs_04 {
    public static class Song {
        String typeList;
        String name;
        String time;

        public String getName() {
            return name;
        }

        public String getTypeList() {
            return typeList;
        }


        public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSongs = Integer.parseInt(scanner.nextLine());
        List<Song> songs = new ArrayList<>();

        for (int i = 1; i <= numberOfSongs; i++) {
            String[] data = scanner.nextLine().split("_");

            String typeList = data[0];
            String name = data[1];
            String time = data[2];

            Song song = new Song(typeList, name, time);

            songs.add(song);
        }

        String command = scanner.nextLine();
        if (command.equals("all")) {
            for (Song s : songs) {
                System.out.println(s.getName());
            }
        } else for (Song s : songs) {
            if (command.equals(s.getTypeList())) {
                System.out.println(s.getName());
            }
        }
    }
}
