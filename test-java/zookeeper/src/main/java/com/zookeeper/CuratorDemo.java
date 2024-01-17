package com.zookeeper;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

public class CuratorDemo {


  private static String CONNECTION_STR="127.0.0.1:2181";



  public static void main(String[] args) throws Exception {

    CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder();

    CuratorFramework curatorFramework = builder.connectString(CONNECTION_STR).
            sessionTimeoutMs(5000).
            retryPolicy(new ExponentialBackoffRetry(100, 3)).build();
    curatorFramework.start();
    createNode(curatorFramework);
    updateNode(curatorFramework);
//    deleteNode(curatorFramework);
  }


  private static void createNode(CuratorFramework curatorFramework) throws Exception {
      curatorFramework.create().creatingParentContainersIfNeeded()
          .withMode(CreateMode.PERSISTENT).forPath("/watch","test".getBytes());
  }


  private static void updateNode(CuratorFramework curatorFramework) throws Exception {
    curatorFramework.setData().forPath("/watch","aaa".getBytes());
  }

  private static void deleteNode(CuratorFramework curatorFramework)  throws Exception {
    Stat stat=new Stat();
    final String s = new String(curatorFramework.getData().storingStatIn(stat).forPath("/data/program"));
    curatorFramework.delete().withVersion(stat.getVersion()).forPath("/data/program");
  }


  

}
