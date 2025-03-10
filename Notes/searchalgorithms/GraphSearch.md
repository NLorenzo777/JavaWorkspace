# Graph Search Algorithms
Algorithms used to traverse the Graph data structure.

Two common approaches:
- `Depth-First Search (DFS)`: Follows a path in a deeper manner before moving through the other path.
- `Breadth-First Search (BFS)`: Broad searching algorithm where follows each path first before going deeper.

### Algorithm of the search:
- Once a vertex is visited, it is added to a list called *visited*.
This keeps the search from visiting the same vertex multiple times.

### Runtime
The runtime of this algorithm is `O(Vertices + Edges)`.

## Depth-First Search Algorithm
- Uses a `Stack` where the adjacent vertices will be placed.
- To visit a vertex, it should be popped from the stack and should be list to the visited.

## Breadth-First Search Algorithm
- There is a usage of `Queue` and `List`.
- The Queue will serve as the pointer of the vertex to be looked at.
- The vertex will be removed from the Queue when the vertex has been picked.
- Once a vertex is picked, it should be added to the list, 
and it's connected vertices (unvisited) will be added to the Queue.

# Graph Search Traversal Orders
There are three (3) main traversal orders that are known in Graph Traversal.
1. `Preorder`: 
    - each vertex is added to the **visited** list and added to the output list BEFORE getting added to the stack.
2. `Postorder`:
    - each vertex is added to the **visited** list and added to the output list AFTER it is popped off the stack.
3. `Reverse Post-Order`: 
    - Also known as *Topological Sort*.
    - Returns an output list that is exactly the reverse of the post-order list.