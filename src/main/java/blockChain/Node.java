package blockChain;

import java.util.List;

public class Node {
    private Blockchain blockchain;

    public Node() {
        this.blockchain = new Blockchain();
    }

    public Blockchain getBlockchain() {
        return blockchain;
    }

    /**
     * 挖矿
     * @param transactions
     */
    public void mineNewBlock(List<Transaction> transactions) {
        Block latestBlock = blockchain.getLatestBlock();
        Block newBlock = new Block(latestBlock.index + 1, System.currentTimeMillis(), transactions, latestBlock.hash);
        blockchain.addBlock(newBlock);
    }
}

