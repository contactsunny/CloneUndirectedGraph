# Clone an Undirected Graph

This is a simple Java program to demonstrate how to clone an undirected graph.

---

## Input

The input is a graph with five vertices, and each vertex having one or more edges.
The goal is to clone the graph, clone all nodes and edges.

I've tried my best to print the graph using Java in an effort to make it easy 
to visualize. So good luck understanding this graph:

```shell script
Vertex a
Hash code: 1450495309
Edges:
a -> b
a -> c
-----------------------------
Vertex b
Hash code: 1670782018
Edges:
b -> d
b -> e
-----------------------------
Vertex c
Hash code: 1706377736
Edges:
c -> a
c -> d
-----------------------------
Vertex d
Hash code: 468121027
Edges:
d -> b
d -> e
-----------------------------
Vertex e
Hash code: 1804094807
Edges:
e -> b
e -> d
-----------------------------
```

I've included the hash codes in the output so that we can see from the cloned 
graph output that all the vertices have indeed been cloned and are not the same
vertices from the original graph.

---

## Output

```shell script
-------------------------
Printing cloned graph
-------------------------
Vertex a
Hash code: 951007336
Edges:
a -> b
a -> c
-----------------------------
Vertex b
Hash code: 2001049719
Edges:
b -> d
b -> e
-----------------------------
Vertex c
Hash code: 1528902577
Edges:
c -> a
c -> d
-----------------------------
Vertex d
Hash code: 1927950199
Edges:
d -> b
d -> e
-----------------------------
Vertex e
Hash code: 868693306
Edges:
e -> b
e -> d
-----------------------------
```