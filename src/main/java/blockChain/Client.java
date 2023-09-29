package blockChain;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        // 创建两个节点
        Node nodeA = new Node();
        Node nodeB = new Node();

        // 以下是节点A挖掘第一个块的过程

        // 1. 创建一些交易数据
        List<Transaction> transactionsA = new ArrayList<>();
        transactionsA.add(new Transaction("Alice", "Bob", 50));
        transactionsA.add(new Transaction("Bob", "Charlie", 30));

        // 2. 节点A挖掘新块（打包交易记录到区块，比特币里一个块5m，一笔交易大概是500字节，一个区块最多可以包含2000多笔交易）
        System.out.println("Node A is mining...");
        nodeA.mineNewBlock(transactionsA);
        System.out.println("Node A mined a new block with hash: " + nodeA.getBlockchain().getLatestBlock().hash);

        // 模拟网络中的节点同步，这在真实的区块链网络中是通过P2P通信实现的
        // 但为简化起见，我们只是直接将NodeA的链复制到NodeB
        nodeB.getBlockchain().addBlock(nodeA.getBlockchain().getLatestBlock());

        // 接下来，节点B挖掘另一个块

        // 1. 创建一些交易数据
        List<Transaction> transactionsB = new ArrayList<>();
        transactionsB.add(new Transaction("Charlie", "Dave", 20));

        // 2. 节点B挖掘新块
        System.out.println("Node B is mining...");
        nodeB.mineNewBlock(transactionsB);
        System.out.println("Node B mined a new block with hash: " + nodeB.getBlockchain().getLatestBlock().hash);
    }

}
