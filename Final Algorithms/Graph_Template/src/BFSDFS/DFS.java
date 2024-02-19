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
public class DFS {
        Graph g=new Graph(true);
        ReadFromFile read=new ReadFromFile();
        public void readGraph()
        {
            
           
        }
        public void doDFS()
        {
            g.dfs();
        }
        
}
