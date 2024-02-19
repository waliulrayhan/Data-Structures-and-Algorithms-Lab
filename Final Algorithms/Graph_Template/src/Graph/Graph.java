//GraphAlgorithms
package Graph;

import Core.*;
import java.util.HashMap;

public class Graph {
   private final int MAX_VERTS = 20;
   public final int MAX_EDGE=30;//
   private Vertex vertexList[], sccList[];  ;  
   private Edge edgeList[];//
   private Edge spanEdgeList[];//
   private int adjMat[][];
   private int floydWMat[][];
   private int floydPMat[][];
   private int nVerts;
   private int nEdge;//
   private Heap myHeap;//
   private Queue queue;
   private Stack[] list;
   private boolean isDirected;
   private int time;
   HashMap < String,Integer > mymap=new HashMap < String, Integer >();


   public Graph(boolean isDir)
   {
      
      vertexList = new Vertex[MAX_VERTS];
      sccList=new Vertex[MAX_VERTS];
      edgeList=new Edge[MAX_EDGE];
      adjMat = new int[MAX_VERTS][MAX_VERTS];
      floydWMat = new int[MAX_VERTS][MAX_VERTS];
      floydPMat = new int [MAX_VERTS][MAX_VERTS];
      nVerts = 0;
      nEdge=0;//
      list=new Stack[MAX_VERTS];
      
      for(int j=0; j<MAX_VERTS; j++) {
         for(int k=0; k<MAX_VERTS; k++){
            adjMat[j][k] = 0;
            //floydWMat[j][k]=0;
            //floydPMat[j][k]=0;


         }
         list[j]=new Stack();

      }

      queue=new Queue();

      isDirected=isDir;
   }
   public void addVertex(String lab)
   {

        vertexList[nVerts] = new Vertex(lab);
        if(mymap.put(lab, nVerts++)==null) ;
       
      
   }


   public void addEdge(String start, String end, int w)//
   {
       edgeList[nEdge]=new Edge(start, end, w);
       nEdge++;
       if(isDirected)
       {
           adjMat[mymap.get(start)][mymap.get(end)]=w;
           list[mymap.get(start)].push(mymap.get(end));
       }

       else
       {
           adjMat[mymap.get(start)][mymap.get(end)]=w;
           adjMat[mymap.get(end)][mymap.get(start)]=w;
           list[mymap.get(start)].push(mymap.get(end));
           list[mymap.get(end)].push(mymap.get(start));
       }

   }
   public void addEdge(String start, String end)
   {
      int startx=mymap.get(start);
      int endx=mymap.get(end);
      adjMat[startx][endx] = 1;
      if(isDirected==false)
            adjMat[endx][startx] = 1;
      list[startx].push(endx);
      if(isDirected==false) list[endx].push(startx);
   }
    public void addWeightedEdge(String start, String end, int w)
    {

       int startx=mymap.get(start);
       int endx=mymap.get(end);
      //weightedMat[startx][endx] = w;
      floydWMat[startx][endx]=w;
      adjMat[startx][endx]=w;
      if(w==0 && w==9999)
          floydPMat[startx][endx]=0;
      else
        floydPMat[startx][endx]=startx+1;

    }
   public String isInfinite(int v)
   {
       if(v>=999) return "INF";
       else return String.valueOf(v);
   }
   public String isNull(int v)
     {
         if(v==0) return "NIL";
         else return String.valueOf(v);
     }
   public void displayVertex()
   {
       for(int i=0;i<nVerts;i++)
       {
            System.out.println("Node name :"+ vertexList[i].label+" |  Color:"+vertexList[i].color+" |  Dist: "+isInfinite(vertexList[i].dist)+" |  Parent->"+vertexList[i].parent);
       }
   }
   public void displayAdjMat()
   {
       System.out.println("Adjacent Matrix:");
       for(int j=0;j<nVerts;j++)
       {
           for(int k=0;k<nVerts;k++)
           {
               System.out.print(adjMat[j][k]+" ");
           }
           System.out.println();
       }
   }
   public void displayAdjList()
   {
        for(int j=0;j<nVerts;j++)
       {
           System.out.print(j);
            for(int k=0;k<=list[j].gettop();k++)
           {
               System.out.print(" -> "+list[j].get(k));
           }
           System.out.println();
       }
   }
   public void bfs()
   {
       
       
    
      
   }
   public void printPath(String s,String v)
   {
       if(v.equals(s))
       {
           System.out.println(vertexList[mymap.get(s)].label);
       }
       else if(vertexList[mymap.get(v)].parent==null)
       {
           System.out.println("No path exists");
       }
       else
       {
            printPath(s,vertexList[mymap.get(v)].parent);
            System.out.println(vertexList[mymap.get(v)].label);
       }


  } 
   public void dfs()
   {
   
   }
   public void dfsVisit(int verts)
   {
    
   }
   
   
public void tranposeGraph()
{
    // initialize adjacency list
    for(int j=0; j<MAX_VERTS; j++) {
     
         list[j]=new Stack();

      }
// add edge from edge list into stack/adjacency list after transposition
    for(int i=0;i<nEdge;i++)
    {
        String start=edgeList[i].stNode; // get start node of edge
        String end=edgeList[i].endNode;// get end node of edge
        // just reverse edge and add into stack/list
        //System.out.println(end+"-"+start);
        list[mymap.get(end)].push(mymap.get(start)); 
    }
         
}

private void initVertex()
{
    for(int i=0;i<nVerts;i++)
    {
        vertexList[i].color="WHITE";
        vertexList[i].inTime=0;
        vertexList[i].fTime=0;
        vertexList[i].parent=null;
    }
}

// this method returns the index of largest finishing time 
private int findLargest()
{
    int largest=0, index=0;
  
    return index;
}
public void scc_Dfs()
   {
       
   }

private void scc_dfsVisit(int u)
  {
      
  }
   
public void SCC()
{
    
}

   
   public void displayDFSTime()
   {
   }
   public void sortEdges()//
   {
       
   }
   
   public void kruskal()
   {
   
   }
   public void printKruskalEdge(int count)
   {
      
   }
   public void Relax(int u,int v,int w)
   {
   
   
   }
   
   
   public boolean bellManFord()
   {
    
       return true;
   }
   
   public void displayBellmanFordGraphInfo()
   {
    
       
   }

  public void dijKstra()
  {
    
  }
   
  private void printDijkstra()
  {
     
  }
  
    public void prim()
       {
         
       }

       public void displayPrim()
       {
           
       }
     public void doFloydWarshall(){

         

      }

       public int minimum(int i,int j)
       {
            if(i>=j)
                return j;
            else return i;
       }

       public void printFloydWarshall(int q[][]){
           
        }
       public void printParentFloyd(int q[][])
       {
           
       }


}
