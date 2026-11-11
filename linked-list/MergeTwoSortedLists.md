# 21. Merge Two Sorted Lists

- 링크: https://leetcode.com/problems/merge-two-sorted-lists/
- 유형: linked list (dummy 노드)
- 날짜: 2026-11-11
- 상태: 1차 코드 지적(문제점 5개) + 빈칸 뼈대를 본 뒤 직접 채워서 통과

## 접근

두 리스트의 맨 앞을 비교해서 작은 노드를 결과 끝에 **이어 붙이고**(값 복사 ✗, `cur.next = list1`) 그쪽을 한 칸 옮긴다.
손가락 두 개: `dummy`(가짜 첫 노드, 안 움직임, 시작 위치 기억), `cur`(결과의 끝을 따라감).
한쪽이 끝나면 남은 쪽은 이미 정렬·연결돼 있으니 통째로 붙인다: `cur.next = list1 == null ? list2 : list1;`
답은 `dummy.next` (dummy는 `val = 0`인 가짜 노드).

## 시간복잡도 / 공간복잡도

- 시간: O(n + m) (노드마다 한 번)
- 공간: O(1) (새 노드는 dummy 하나, 기존 노드를 다시 연결만 함)

## 막혔던 점

- 1차: `ans.val = list1.val`로 **값을 복사**하고 `ans = ans.next` → `new ListNode()`의 `next`는 `null`이라 2바퀴째 `ans.val`에서 NullPointerException. 노드를 새로 만들지 말고 **화살표를 연결**한다
- 1차: 같을 때 둘 다 옮김 → `[1]` + `[1]`이 `[1,1]`이 아니라 `[1]`. 같으면 한쪽만 넣는다 → 조건이 `if / else` 두 개로 줄어듦
- 1차: `while (list1.next != null && ...)` → 마지막 노드를 못 보고, 빈 리스트면 바로 에러. **지금 노드**를 보려면 `list1 != null` (141 Floyd와 같은 실수)
- 1차: 반복문 뒤 남은 노드를 안 붙임, `return ans`는 맨 끝 노드
- `cur = dummy`는 `dummy.next`가 아니라 **같은 노드를 가리키는 손가락 두 개**. 그래서 `cur.next = ...`가 `dummy.next`도 바꾸고, `cur = cur.next`는 cur만 옮김
- `new ListNode()`에 `<>`가 없는 이유: `ListNode`는 제네릭 클래스가 아님 (`val`이 항상 `int`). `ArrayList<>`, `HashMap<>`처럼 담을 타입을 고르는 클래스만 `<>`
