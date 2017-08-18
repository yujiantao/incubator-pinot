package com.linkedin.thirdeye.taskexecution.dag;

import java.util.Collection;

public interface DAG<T extends Node> {

  T addNode(T node);

  void addEdge(T source, T sink);

  T getNode(NodeIdentifier nodeIdentifier);

  int size();

  Collection<T> getRootNodes();

  Collection<T> getLeafNodes();

  Collection<T> getAllNodes();
}