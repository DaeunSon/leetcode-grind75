/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next; // ① 화살표를 돌리기 전에 다음 노드 저장
            cur.next = prev;          // ② 화살표를 뒤로 돌리기 (리스트 모양이 바뀌는 건 이 줄뿐)
            prev = cur;               // ③ prev 한 칸 앞으로
            cur = next;               // ④ cur 한 칸 앞으로 (cur.next는 이미 뒤를 가리켜서 못 씀)
        }
        return prev;                  // 끝나면 cur는 null, 마지막 노드는 prev
    }
}
