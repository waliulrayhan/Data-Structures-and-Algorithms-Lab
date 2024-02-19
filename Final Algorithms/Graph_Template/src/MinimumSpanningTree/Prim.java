/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MinimumSpanningTree;
import Filereadwrite.ReadFromFile;
import Graph.Graph;
/**
/**
 *
 * @author meta
 */
public class Prim {
     Graph g=new Graph(false);//true for directed.
        ReadFromFile read=new ReadFromFile();
        public void readGraph()
        {

            
    }

        public void doMSTPrim()
        {
            g.prim();

        }
}
