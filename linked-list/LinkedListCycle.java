/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) { // fast가 두 칸 갈 수 있나? (순서도 이대로)
            slow = slow.next;                       // 내 위치에서 한 칸
            fast = fast.next.next;                  // 내 위치에서 두 칸
            if (slow == fast) return true;          // 같은 "노드"인지 비교라 ==
        }
        return false;                               // fast가 끝에 닿음 → 사이클 없음
    }
}
