# 206. Reverse Linked List

- 링크: https://leetcode.com/problems/reverse-linked-list/
- 유형: linked list
- 날짜: 2026-11-11
- 상태: 연결 리스트 첫 문제. 개념 설명 + 빈칸 뼈대(③④⑤ 틀림) + 단계별 그림을 본 뒤, Google Docs에 처음부터 다시 써서 통과

## 접근

화살표(`next`)를 하나씩 반대로 돌린다. 돌리면 다음 노드로 가는 길을 잃으니까 **먼저 `next`에 저장**한다.
손가락 세 개: `prev`(이미 뒤집은 쪽 맨 앞, 처음엔 `null`), `cur`(지금 돌릴 노드), `next`(저장해 둔 다음 노드).
한 바퀴: ① `next = cur.next` → ② `cur.next = prev` → ③ `prev = cur` → ④ `cur = next`. 끝나면 `return prev`.

## 시간복잡도 / 공간복잡도

- 시간: O(n) (노드마다 한 번)
- 공간: O(1) (변수 세 개)

## 막혔던 점

- 빈칸에서 ③을 `cur.prev`로 씀 → 단일 연결 리스트 노드에는 `val`과 `next`만 있다. `prev`는 내가 만든 변수일 뿐
- ④를 `cur = prev`로 씀 → ③에서 이미 `prev == cur`라 제자리, 무한 반복. `cur.next`는 ②에서 뒤를 가리키게 됐으니 **저장해 둔 `next`**로 간다
- ⑤를 `return cur`로 씀 → 반복문이 끝났다는 건 `cur == null`. 마지막 노드는 `prev`가 들고 있다
- `=` 두 종류: `cur = cur.next`는 **손가락**을 옮김, `cur.next = prev`는 **화살표**를 바꿈 (왼쪽에 `.next`가 붙으면 리스트 모양이 바뀐다)
- ③과 ④는 순서가 중요하다: ④를 먼저 하면 `prev`도 다음 노드가 돼서 뒤집어 둔 쪽을 잃는다. "첫 줄이 바꾼 값을 둘째 줄이 쓰나?"로 판단
- 빈 리스트(`head = null`)는 반복문이 안 돌고 `prev = null`을 반환해서 따로 처리 안 해도 된다
