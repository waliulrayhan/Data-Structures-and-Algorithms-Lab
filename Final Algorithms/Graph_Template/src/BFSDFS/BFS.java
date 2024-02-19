/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BFSDFS;

import Filereadwrite.ReadFromFile;
import Graph.Graph;

/**
 *
 * @author meta
 */
public class BFS {
        Graph g=new Graph(false);
        ReadFromFile read=new ReadFromFile();
        public void readGraph()
        {
            
           
        }
        public void doBFS()
        {
            g.bfs();
            System.out.println("Path from S to W:");
            g.printPath("T","Y" );
            System.out.println("Path from U to Y:");
            g.printPath("U","Y");
        }
    
}
