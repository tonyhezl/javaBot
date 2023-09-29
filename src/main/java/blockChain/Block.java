package blockChain;

import blockChain.Transaction;

import java.util.List;
import java.security.MessageDigest;

public class Block {

    //索引
    public int index;
    //时间戳
    public long timestamp;
    //事务结构（交易）
    public List<Transaction> transactions;
    //前一个区块的哈希值
    public String previousHash;
    //当前区块的哈希值
    public String hash;
    //一次性随机数字：用来计算满足小于特定目标值的哈希
    public int nonce = 0;

    /**
     * 生成一个区块
     * @param index
     * @param timestamp
     * @param transactions
     * @param previousHash
     */
    public Block(int index, long timestamp, List<Transaction> transactions, String previousHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.hash = computeHash();
    }

    /**
     * 计算当前哈希
     * @return
     */
    public String computeHash() {
        String dataToHash = Integer.toString(index) + Long.toString(timestamp) + transactions.toString() + previousHash + Integer.toString(nonce);
        MessageDigest digest;
        byte[] bytes;

        try {
            digest = MessageDigest.getInstance("SHA-256");
            bytes = digest.digest(dataToHash.getBytes("UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        StringBuilder buffer = new StringBuilder();
        for (byte b : bytes) {
            buffer.append(String.format("%02x", b));
        }

        return buffer.toString();
    }

    /**
     * 计算哈希（工作量证明pow）
     * difficulty是一个表示目标哈希前导零数量的整数。例如，如果difficulty为4，则目标哈希可能看起来像“0000xxxxxxxxxxxx...”。
     * @param difficulty
     */
    public void mineBlock(int difficulty) {
        String target = new String(new char[difficulty]).replace('\0', '0');
        while (!hash.substring(0, difficulty).equals(target)) {
            nonce++;
            hash = computeHash();
        }
        System.out.println("Block Mined! : " + hash);
    }


}
