package blockChain;

import java.util.ArrayList;
import java.util.List;

public class Blockchain {
    private List<Block> chain;

    /**
     * 初始化一个简单的创世块
     */
    public Blockchain() {
        chain = new ArrayList<>();
        chain.add(new Block(0, System.currentTimeMillis(), new ArrayList<>(), "0"));
    }


    public Block getLatestBlock() {
        return chain.get(chain.size() - 1);
    }

    /**
     * 添加区块
     * @param newBlock
     */
    public void addBlock(Block newBlock) {
        newBlock.previousHash = getLatestBlock().hash;
        // 挖掘新区块，使用4作为难度。只有找到满足条件的区块才能被加入区块链
        newBlock.mineBlock(4);
        newBlock.hash = newBlock.computeHash();
        chain.add(newBlock);
    }


    /**
     * 验证整个区块链的完整性
     * @return
     */
    public boolean isChainValid() {
        for (int i = 1; i < chain.size(); i++) {
            Block currentBlock = chain.get(i);
            Block previousBlock = chain.get(i - 1);

            if (!currentBlock.hash.equals(currentBlock.computeHash())) {
                return false;
            }

            if (!currentBlock.previousHash.equals(previousBlock.hash)) {
                return false;
            }
        }
        return true;
    }

}

