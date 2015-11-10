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
public class Node {
    Integer nodeID;
    Integer clusterID;

    public Node(Integer nodeID, Integer clusterID) {
        this.nodeID = nodeID;
        this.clusterID = clusterID;
    }
}
