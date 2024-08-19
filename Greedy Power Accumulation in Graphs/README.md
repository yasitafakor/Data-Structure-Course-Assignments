# Graph Traversal and Minimum Accumulation Path Calculation

This Java program solves a problem related to graph traversal and path accumulation using Breadth-First Search (BFS) and a greedy algorithm. The goal is to calculate the minimum cost required to traverse a graph starting from each vertex, where each vertex has an associated value that contributes to the total cost.

## Problem Description

Given a graph with `n` vertices and `m` edges, each vertex has an integer value. The task is to compute the minimum accumulated value required to traverse the graph starting from each vertex. The traversal ensures that the accumulated value always meets or exceeds the value of the next vertex in the path. If the current accumulated value is insufficient to traverse to the next vertex, the difference must be added to the total cost.

## Approach

- **Graph Representation:** The graph is represented using an adjacency list.
- **Breadth-First Search (BFS):** BFS is used to explore the graph starting from each vertex, ensuring all reachable vertices are visited.
- **Greedy Algorithm:** A priority queue (min-heap) is used to ensure the next vertex with the smallest value is processed first, minimizing the additional cost required to traverse the graph.

### Example Input

```
5 4
3 2 5 4 6
1 2
2 3
3 4
4 5
```

### Example Output

```
0 1 3 6 10
```


