/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleSourceShortestPath;

import Filereadwrite.ReadFromFile;
import Graph.Graph;

/**
 *
 * @author meta
 */
public class BellmanFord 
{
        Graph g=new Graph(true);
        ReadFromFile read=new ReadFromFile();
        public void readGraph()
        {
           
        }
        public void doBellmanFord()
        {
            if(g.bellManFord()){
                g.displayBellmanFordGraphInfo();
            }
        }
}