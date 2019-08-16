package swordoffer;

public class RamdomListDuplicate {
    public static class RandomListNode{
        int val;
        RandomListNode next;
        RandomListNode random;
        RandomListNode(int val){
            this.val = val;
        }
    }

    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return null;

        RandomListNode cur = pHead;
        //复制节点
        while(cur != null){
            RandomListNode clone = new RandomListNode(cur.val);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }
        //复制random link
        cur = pHead;
        while(cur != null){
            RandomListNode clone = cur.next;
            if(cur.random != null){
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }

        //拆分
        cur = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(cur != null){
            RandomListNode clone = cur.next;
            cur.next = clone.next;
            if(cur.next != null) clone.next = cur.next.next;
            cur = cur.next;
        }

//        while (cur.next != null) {
//            RandomListNode next = cur.next;
//            cur.next = next.next;
//            cur = next;
//        }
        return pCloneHead;
    }
}
