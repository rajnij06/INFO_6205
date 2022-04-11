package Graph;

import java.util.ArrayList;

public class Node {
    public String name;
    public boolean isVisised = false;
    public ArrayList<Edge> neighbours;

    public Node(String name) {
        this.name = name;
        this.isVisised = false;
        this.neighbours = new ArrayList<>();
    }
}
