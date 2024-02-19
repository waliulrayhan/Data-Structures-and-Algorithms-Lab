/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topology;

import Filereadwrite.ReadFromFile;
import Graph.Graph;

/**
 *
 * @author HP
 */
public class SCC {
    Graph g=new Graph(true);
        ReadFromFile read=new ReadFromFile();
        public void readGraph()
        {
            read.OpenFile("src/topology/scc.txt");
            String nVertx;
            int nVert = Integer.parseInt(read.Read());
            System.out.println(nVert);
            for(int i=0;i<nVert;i++)
            {
                nVertx = read.Read();
                g.addVertex(nVertx);
            }
            //Reading number of Edges
            int  nEdge = Integer.parseInt(read.Read());
        
       
            for(int i=0;i<nEdge;i++){
                    //strat and end node of an Edge 
                    String split[]=(read.Read()).split("-");
                    g.addEdge(split[0], split[1]);
            }
           
        }
        public void doSCC()
        {
            //g.SCC();
        }
}
