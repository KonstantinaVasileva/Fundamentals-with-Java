package ObjectsAndClasses_Exercises.AdvertisementMessage_01;

import java.util.Random;

public class Message {

        private String[] phrases;
        private String[] events;
        private String[] authors;
        private final String[] cities;

        {
            phrases = new String[]{"Excellent product.", "Such a great product.", "I always use that product.",
                    "Best product of its category.",
                    "Exceptional product.",
                    "I can’t live without this product."};
            events = new String[]{"Now I feel good.",
                    "I have succeeded with this product.",
                    "Makes miracles. I am happy of the results!",
                    "I cannot believe but now I feel awesome.",
                    "Try it yourself, I am very satisfied.",
                    "I feel great!"};
            authors = new String[]{"Diana",
                    "Petya",
                    "Stella",
                    "Elena",
                    "Katya",
                    "Iva",
                    "Annie",
                    "Eva"};
            cities = new String[]{"Burgas",
                    "Sofia",
                    "Plovdiv",
                    "Varna",
                    "Ruse"};
        }

        Random random = new Random();

        public String randomMessage(){
            return String.format("%s %s %s - %s", phrases[random.nextInt(phrases.length - 1)],
                    events[random.nextInt(events.length - 1)],
                    authors[random.nextInt(authors.length - 1)],
                    cities[random.nextInt(cities.length - 1)]);
        }
    }
