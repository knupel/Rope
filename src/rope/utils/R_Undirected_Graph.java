package rope.utils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Straightforward undirected graph implementation. Nodes are generic type N.
 * 
 * @author Paul Chew Created November, December 2007. For use in
 *         Delaunay/Voronoi code.
 * @author toxi Updated July 2010, minor API changes to be better suited for
 *         toxiclibs
 */
public class R_Undirected_Graph<N> {

    protected Map<N, Set<N>> nodeLinks = new HashMap<N, Set<N>>();
    protected Set<N> nodeIDs = Collections.unmodifiableSet(nodeLinks.keySet());

    /**
     * Add a node. If node is already in graph then no change.
     * 
     * @param node
     *            the node to add
     */
    public void add(N node) {
        if (nodeLinks.containsKey(node)) {
            return;
        }
        nodeLinks.put(node, new R_ArraySet<N>());
    }

    /**
     * Add a link. If the link is already in graph then no change.
     * 
     * @param nodeA
     *            one end of the link
     * @param nodeB
     *            the other end of the link
     * @throws NullPointerException
     *             if either endpoint is not in graph
     */
    public void connect(N nodeA, N nodeB) throws NullPointerException {
        nodeLinks.get(nodeA).add(nodeB);
        nodeLinks.get(nodeB).add(nodeA);
    }

    /**
     * Remove the specified link. If link not in graph, nothing happens.
     * 
     * @param nodeA
     *            one end of the link
     * @param nodeB
     *            the other end of the link
     * @throws NullPointerException
     *             if either endpoint is not in graph
     */
    public void disconnect(N nodeA, N nodeB) throws NullPointerException {
        nodeLinks.get(nodeA).remove(nodeB);
        nodeLinks.get(nodeB).remove(nodeA);
    }

    /**
     * Report all the neighbors of node.
     * 
     * @param node
     *            the node
     * @return the neighbors of node
     * @throws NullPointerException
     *             if node does not appear in graph
     */
    public Set<N> getConnectedNodesFor(N node) throws NullPointerException {
        return Collections.unmodifiableSet(nodeLinks.get(node));
    }

    /**
     * Returns an unmodifiable Set view of the nodes contained in this graph.
     * The set is backed by the graph, so changes to the graph are reflected in
     * the set.
     * 
     * @return a Set view of the graph's node set
     */
    public Set<N> getNodes() {
        return nodeIDs;
    }

    /**
     * Remove node and any links that use node. If node not in graph, nothing
     * happens.
     * 
     * @param node
     *            the node to remove.
     */
    public void remove(N node) {
        if (!nodeLinks.containsKey(node)) {
            return;
        }
        for (N neighbor : nodeLinks.get(node)) {
            nodeLinks.get(neighbor).remove(node);
        }
        nodeLinks.get(node).clear();
        nodeLinks.remove(node);
    }

}
