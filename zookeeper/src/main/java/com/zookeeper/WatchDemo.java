package com.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class WatchDemo {

  private static String CONNECTION_STR="127.0.0.1:2181";

  public static void main(String[] args) throws Exception {
    CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder();
    CuratorFramework curatorFramework = builder.connectString(CONNECTION_STR)
                                            .sessionTimeoutMs(5000).retryPolicy(new ExponentialBackoffRetry(100, 3)).build();
    curatorFramework.start();
    addListenerWithNode(curatorFramework);
//    addListenerWithChild(curatorFramework);
    System.in.read();
  }

  private static void addListenerWithNode(CuratorFramework curatorFramework) throws Exception {
    NodeCache nodeCache =new NodeCache(curatorFramework,"/watch",false);
    NodeCacheListener nodeCacheListener= () ->{
      System.out.println("receive Node Changed");
      System.out.println(nodeCache.getCurrentData().getPath()+"---"+new String(nodeCache.getCurrentData().getData()));
    };
    nodeCache.getListenable().addListener(nodeCacheListener);
    nodeCache.start();
  }


  private static void addListenerWithChild(CuratorFramework curatorFramework) throws Exception {
    PathChildrenCache nodeCache=new PathChildrenCache(curatorFramework,"/watch",true);
    PathChildrenCacheListener nodeCacheListener= (curatorFramework1, pathChildrenCacheEvent) -> {
      System.out.println(pathChildrenCacheEvent.getType()+"->"+new String(pathChildrenCacheEvent.getData().getData()));
    };
    nodeCache.getListenable().addListener(nodeCacheListener);
    nodeCache.start(PathChildrenCache.StartMode.NORMAL);
  }



}
