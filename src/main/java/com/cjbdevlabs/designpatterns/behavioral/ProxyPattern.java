package com.cjbdevlabs.designpatterns.behavioral;

/*
Proxy is a class that controls access to the functionality of another class.
 */
public class ProxyPattern {

    interface Recommendations {

        void showRecommendations(User user);
    }

    static class User {

        private final String name;
        private final boolean isPremium;

        public User(String name, boolean premium) {
            this.name = name;
            this.isPremium = premium;
        }

        public String getName() {
            return name;
        }

        public boolean isPremium() {
            return isPremium;
        }
    }

    static class RecommendationsProxy implements Recommendations {

        private Recommendations recommendations;

        @Override
        public void showRecommendations(User user) {
            if (user.isPremium()) {
                if (recommendations == null) {
                    recommendations = new SongRecommendations(user);
                }
                recommendations.showRecommendations(user);
            } else {
                System.out.println("upgrade for recommendations");
            }

        }

    }

    static class SongRecommendations implements Recommendations {

        public SongRecommendations(User user) {
            getData(user);
        }

        @Override
        public void showRecommendations(User user) {
            System.out.println("Showing song recommendations for " + user.getName()
                    + " based on their top tracks, artists and genres");
        }

        private void getData(User user) {
            System.out.println("Getting " + user.getName() + "'s top tracks from database...");
            System.out.println("Getting " + user.getName() + "'s top artists from database...");
            System.out.println("Getting " + user.getName() + "'s top genres from database...");
        }
    }

    static class MusicPlayer {

        private static final RecommendationsProxy recommendationsProxy = new RecommendationsProxy();

        public static void main(String[] args) {
            var user = new User("Jill", true);
            loadHomePage(user);
            loadDiscoverPage(user);
        }

        private static void loadHomePage(User user) {
            System.out.println("Loading home page...");
            recommendationsProxy.showRecommendations(user);
        }

        private static void loadDiscoverPage(User user) {
            System.out.println("Loading discover page...");
            recommendationsProxy.showRecommendations(user);
        }

    }
}
