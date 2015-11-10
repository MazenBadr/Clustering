/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clustering;

/**
 *
 * @author mazenbadr
 */
public class Edge {
    Node node1;
    Node node2;
    Integer distance;

    public Edge(Node node1, Node node2, Integer distance) {
        this.node1 = node1;
        this.node2 = node2;
        this.distance = distance;
    }


}
