package com.example.leetcodetest;

/**
 * Description:链表
 * 2095. 删除链表的中间节点
 * 328. 奇偶链表
 * 206. 反转链表
 * 2130. 链表最大孪生和
 *
 * @author <a href="https://github.com/LCL-Developer">lcl</a>
 * @since 2024/1/20
 */
public class Day15 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /*    public ListNode deleteMiddle(ListNode head) {
            ListNode tempPre = head;
            ListNode node = head;
            int i = 0;
            if(head.next==null){
                return null;
            }
            while (node.next != null) {
                if (i != 0 && i % 2 == 0) {
                    tempPre = tempPre.next;
                }
                node = node.next;
                i++;
            }
            tempPre.next = tempPre.next.next;
            return head;
        }*/

    /**
     * 给你一个链表的头节点 head 。删除 链表的 中间节点 ，并返回修改后的链表的头节点 head 。
     * <p>
     * 长度为 n 链表的中间节点是从头数起第 ⌊n / 2⌋ 个节点（下标从 0 开始），其中 ⌊x⌋ 表示小于或等于 x 的最大整数。
     * <p>
     * 对于 n = 1、2、3、4 和 5 的情况，中间节点的下标分别是 0、1、1、2 和 2 。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：head = [1,3,4,7,1,2,6]
     * 输出：[1,3,4,1,2,6]
     * 解释：
     * 上图表示给出的链表。节点的下标分别标注在每个节点的下方。
     * 由于 n = 7 ，值为 7 的节点 3 是中间节点，用红色标注。
     * 返回结果为移除节点后的新链表。
     */
    public static ListNode deleteMiddle(ListNode head) {
        //快慢指针  （上面也是一样但效率太差）
        if (head.next == null) return null;
        ListNode left = head;
        ListNode right = head.next.next;
        //这段是精髓，求中间节点 下面有一题还会再用到
        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        left.next = left.next.next;
        return head;
    }

    /**
     * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
     * <p>
     * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
     * <p>
     * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
     * <p>
     * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: head = [1,2,3,4,5]
     * 输出: [1,3,5,2,4]
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while (even != null && even.next != null) {
            odd = odd.next = even.next;
            even = even.next = odd.next;
        }
        odd.next = evenHead;
        return head;
    }

    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     */
    public static ListNode reverseList(ListNode head) {
        //链表的操作需要记住三个东西，上一个是谁，我是谁，下一个是谁。
        ListNode first = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = first;
            first = head;
            head = temp;
        }
        return first;
    }

    /**
     * 在一个大小为 n 且 n 为 偶数 的链表中，对于 0 <= i <= (n / 2) - 1 的 i ，第 i 个节点（下标从 0 开始）的孪生节点为第 (n-1-i) 个节点 。
     * <p>
     * 比方说，n = 4 那么节点 0 是节点 3 的孪生节点，节点 1 是节点 2 的孪生节点。这是长度为 n = 4 的链表中所有的孪生节点。
     * 孪生和 定义为一个节点和它孪生节点两者值之和。
     * <p>
     * 给你一个长度为偶数的链表的头节点 head ，请你返回链表的 最大孪生和 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：head = [5,4,2,1]
     * 输出：6
     * 解释：
     * 节点 0 和节点 1 分别是节点 3 和 2 的孪生节点。孪生和都为 6 。
     * 链表中没有其他孪生节点。
     * 所以，链表的最大孪生和是 6 。
     */
    public static int pairSum(ListNode head) {
        // 快慢指针找中间值
        ListNode slow = head;
        ListNode quick = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        // 反向指针
        ListNode centreHead = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = centreHead;
            centreHead = slow;
            slow = temp;
        }
        // 计算求和
        int max = 0;
        while (head != null && centreHead != null) {
            max = Math.max(max, head.val + centreHead.val);
            head = head.next;
            centreHead = centreHead.next;
        }
        return max;
    }

}

