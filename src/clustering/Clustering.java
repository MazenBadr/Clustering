/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustering;

import java.io.*;
import java.util.*;

/**
 *
 * @author mazenbadr
 */
public class Clustering {

    /**
     * @param args the command line arguments
     */
    static Hashtable<Integer, Node> clusters = new Hashtable<>();

    public static void main(String[] args) {

        // TODO code application logic here
        InputStream stream = ClassLoader.getSystemResourceAsStream("clustering1.txt");
        BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));

        int numOfNodes = 0;
        ArrayList<Edge> distances = new ArrayList<>();
        try {
            String line = buffer.readLine();
            numOfNodes = Integer.valueOf(line);
            for (int i = 0; i < numOfNodes; i++) {
                clusters.put(i + 1, new Node(i + 1, i + 1));
//                clusters.get(i + 1).add(new Node(i + 1, i + 1));
            }
            while ((line = buffer.readLine()) != null) {
                String[] vals = line.split("\\s+");
                Edge temp = new Edge(new Node(Integer.valueOf(vals[0]), Integer.valueOf(vals[0])),
                        new Node(Integer.valueOf(vals[1]), Integer.valueOf(vals[1])), Integer.valueOf(vals[2]));
                distances.add(temp);
            }
        } catch (Exception e) {

        }

        Collections.sort(distances, new Comparator<Edge>() {

            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.valueOf(o1.distance).compareTo(o2.distance);
            }
        });
        int index = 0;

        while (numOfNodes > 2) {
            if (getClusterID(distances.get(index).node2.nodeID) != getClusterID(distances.get(index).node1.nodeID)) {
                updateCluster(clusters.get(distances.get(index).node2.nodeID).clusterID, getClusterID(distances.get(index).node1.nodeID));
                numOfNodes--;
            }
//            if (clusters.containsKey(distances.get(index).node1)) {
//                clusters.get(distances.get(index).node1).addAll(clusters.remove(distances.get(index).node2));
//                clusters.remove(distances.get(index).node2);
//            } else {
//
//            }
            index++;
        }
        while (getClusterID(distances.get(index).node2.nodeID) == getClusterID(distances.get(index).node1.nodeID)) {
            index++;
        }
        System.out.println(distances.get(index).distance);
    }

    static int getClusterID(int ID) {
        if (clusters.get(ID).clusterID == ID) {
            return ID;
        }
        return getClusterID(clusters.get(ID).clusterID);

    }

    static void updateCluster(int oldID, int newID) {
        for (int cluster : clusters.keySet()) {
            if (getClusterID(clusters.get(cluster).nodeID) == oldID) {
                clusters.get(cluster).clusterID = newID;
            }
        }
    }

}
