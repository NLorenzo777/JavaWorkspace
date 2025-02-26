package org.datastructures.graph;

public class Main {
    public static void main(String[] args) {
        Graph trainNetwork = new Graph(true, true);

        Vertex losAngelesStation = trainNetwork.addVertex("Los Angeles");
        Vertex sanFranciscoStation = trainNetwork.addVertex("San Francisco");
        Vertex newYorkStation = trainNetwork.addVertex("New York");
        Vertex atlantaStation = trainNetwork.addVertex("Atlanta");
        Vertex denverStation = trainNetwork.addVertex("Denver");
        Vertex calgaryStation = trainNetwork.addVertex("Calgary");

        //From San Francisco to Los Angeles (400 mi)
        trainNetwork.addEdge(sanFranciscoStation, losAngelesStation, 400);
        // From Los Angeles to San Francisco (400mi)
        trainNetwork.addEdge(losAngelesStation, sanFranciscoStation, 400);
        // From New York to Denver (1800mi)
        trainNetwork.addEdge(newYorkStation, denverStation, 1800);
        // From Denver to New York (1800mi)
        trainNetwork.addEdge(denverStation, newYorkStation, 1800);
        // From Calgary to Denver (1000mi)
        trainNetwork.addEdge(calgaryStation, denverStation, 1000);
        // From Denver to Calgary (1000mi)
        trainNetwork.addEdge(denverStation, calgaryStation, 1000);
        // From Los Angeles to Atlanta (2100mi)
        trainNetwork.addEdge(losAngelesStation, atlantaStation, 2100);
        // From Atlanta to Los Angeles (2100mi)
        trainNetwork.addEdge(atlantaStation, losAngelesStation, 2100);


        /**
         * Darn! As we were building out our routes, there was a huge snowstorm that hit Calgary and New York.
         * We were able to salvage the route from Denver to New York,
         * but all the routes to and from Calgary broke down.
         */
        trainNetwork.removeEdge(newYorkStation, denverStation);
        trainNetwork.removeEdge(calgaryStation, denverStation);
        trainNetwork.removeEdge(denverStation, calgaryStation);
        trainNetwork.removeVertex(calgaryStation);

        trainNetwork.print();
    }
}
