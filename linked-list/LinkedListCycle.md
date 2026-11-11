# 141. Linked List Cycle

- 링크: https://leetcode.com/problems/linked-list-cycle/
- 유형: linked list / two pointers (Floyd, 빠른·느린 포인터)
- 날짜: 2026-11-11
- 상태: 개념 설명 + 빈칸 뼈대 → 직접 썼지만 손가락이 안 움직이는 코드 → 고친 코드 설명 듣고 Google Docs에 다시 써서 통과

## 접근

- 무식한 방법: 지나간 노드를 `HashSet`에 넣고, 이미 있는 노드를 또 만나면 사이클. 시간 O(n), 공간 O(n)
- 개선(Floyd): `slow`는 한 칸, `fast`는 두 칸. 사이클이 없으면 `fast`가 먼저 `null`에 닿고, 있으면 사이클 안에서 매 바퀴 간격이 1씩 줄어 반드시 같은 노드에서 만난다 (운동장 트랙)

## 시간복잡도 / 공간복잡도

- 시간: O(n)
- 공간: O(1)

## 막혔던 점

- `slow = head.next; fast = head.next.next;`로 씀 → `head`는 안 바뀌니까 매 바퀴 같은 값, **손가락이 제자리**. 사이클이 없어도 반복이 안 끝남 (시간 초과)
  - 손가락 옮기기는 `x = x.next`. 오른쪽에 **자기 이름**이 와야 앞으로 간다 (206의 `cur = cur.next`와 같음)
- 조건을 `head.next.next != null`로 씀 → 역시 `head` 기준이라 매번 같음 + `[1]`이면 `head.next`가 `null`이라 NPE
  - `.next.next` 전에는 `fast != null && fast.next != null` (범위 확인 맨 앞, 실수 노트 5번)
  - 둘 다 보는 이유: 짝수 개면 `fast`가 `null`, 홀수 개면 `fast`가 마지막 노드(`fast.next == null`)에서 멈춤
- 만남 확인은 `slow == fast`: 값(`val`)이 아니라 **같은 노드**인지
