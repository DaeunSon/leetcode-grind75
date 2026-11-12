# 102. Binary Tree Level Order Traversal

- 링크: https://leetcode.com/problems/binary-tree-level-order-traversal/
- 유형: tree, BFS (큐)
- 날짜: 2026-11-12
- 상태: BFS 첫 문제. 개념 설명 + 빈칸 뼈대(①④ 틀림) + 단계별 그림(대기줄·바구니 비유)을 본 뒤, Google Docs에 문제를 적어 두고 처음부터 직접 작성해서 통과

## 접근

층별로 보려면 가까운 노드부터 차례로 꺼내야 한다 → **큐(먼저 넣은 것이 먼저 나옴)**.
- `queue` = 대기줄 (앞으로 처리할 노드), `node` = 지금 꺼낸 노드, `level` = 이번 층 값 바구니, `answer` = 바구니를 쌓는 선반
- 층을 시작할 때 **큐에 든 개수 = 그 층의 노드 수** → `size`에 먼저 저장하고 그만큼만 꺼낸다
- 꺼낼 때마다: 값 기록 → 자식이 있으면 큐 뒤에 넣기 (`ArrayDeque`는 `null`을 못 넣어서 확인 후 넣음)

## 시간복잡도 / 공간복잡도

- 시간: O(n) (노드마다 한 번 넣고 한 번 꺼냄)
- 공간: O(n) (큐에 한 층이 통째로 들어감, 가장 넓은 층은 최대 약 n/2)

## 막혔던 점

- 빈칸 ①을 `null`로 씀 → 반환 타입이 `List<List<Integer>>`라 빈 트리의 답은 빈 리스트 `[]`. 만들어 둔 `answer`(result)를 반환
- 빈칸 ④를 `queue` → `queue.pop()`으로 씀 → `Queue`로 선언하면 `pop()`이 없어서 컴파일 에러. 큐는 `offer`/`poll`, 스택은 `Deque`로 선언하고 `push`/`pop`
- `for (i < queue.size())`로 쓰면? → 무한 루프는 아니지만(poll로 줄어들기도 함) 안에서 offer한 **다음 층 노드까지 이번 층에서 꺼내서 층이 섞임** (`[[3,9],[20,15],[7]]`). 바뀔 값은 바뀌기 전에 저장 (206 `next`, 226 `left`/`right`와 같은 규칙)
- 104번 재귀는 한쪽으로 끝까지 내려가는 DFS, 이 문제는 층별로 퍼지는 BFS
