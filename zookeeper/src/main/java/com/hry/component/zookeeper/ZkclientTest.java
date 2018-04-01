package com.hry.component.zookeeper;

import java.util.concurrent.TimeUnit;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

public class ZkclientTest {
	private static final String nodeName = "/test";

	public static void main(String[] args) throws InterruptedException {
		ZkClient zk = new ZkClient(ZookeeperConstant.IP + ":" + ZookeeperConstant.PORT);
		
		// 封装原生api，此接口可以重复订阅指定节点的变化，不监控字节变化
		zk.subscribeDataChanges(nodeName, new IZkDataListener() {
			public void handleDataChange(String s, Object o) throws Exception {
				System.out.println("node data changed!");
				System.out.println("node=>" + s);
				System.out.println("data=>" + o);
				System.out.println("--------------");
			}

			public void handleDataDeleted(String s) throws Exception {
				System.out.println("node data deleted!");
				System.out.println("s=>" + s);
				System.out.println("--------------");

			}
		});

		System.out.println("ready!");
		testUpdateConfig(zk);
		// junit测试时，防止线程退出
		while (true) {
			TimeUnit.SECONDS.sleep(5);
		}
	}

	public static void testUpdateConfig(ZkClient zk) throws InterruptedException {
		String nodeNameBa= nodeName + "/ba";
		if (!zk.exists(nodeName)) {
			zk.createPersistent(nodeName);
		}
		if (!zk.exists(nodeNameBa)) {
			zk.createPersistent(nodeNameBa);
		}
		
		zk.writeData(nodeName, "1");
		zk.writeData(nodeName, "2");
		zk.writeData(nodeNameBa, "bbb");
		
		zk.delete(nodeNameBa);
		zk.deleteRecursive(nodeName);
//		zk.delete(nodeName);
//		zk.delete(nodeName);
		
	}
}
