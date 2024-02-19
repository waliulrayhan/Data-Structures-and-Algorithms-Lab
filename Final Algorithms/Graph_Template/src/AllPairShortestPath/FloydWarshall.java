/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AllPairShortestPath;
import Filereadwrite.ReadFromFile;
import Graph.Graph;

/**
 *
 * @author meta
 */
public class FloydWarshall {
      Graph g=new Graph(true);//true for directed.
        ReadFromFile read=new ReadFromFile();
        public void readGraph()
        {

            
    }
        public void doFloydWarshall()
        {
            
            g.doFloydWarshall();
          
        }
}
