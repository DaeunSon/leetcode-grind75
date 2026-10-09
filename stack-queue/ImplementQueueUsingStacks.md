# 232. Implement Queue using Stacks

- 링크: https://leetcode.com/problems/implement-queue-using-stacks/
- 유형: stack-queue (스택 두 개로 큐 구현)
- 날짜: 2026-10-09
- 상태: 처음에는 감이 안 와서 접근 설명을 듣고 작성, 통과 (재풀이 필요)

## 접근

스택은 순서를 뒤집는다. 스택을 두 번 거치면 순서가 다시 원래대로 돌아와서 큐처럼 동작한다.
`stack1`은 넣는 곳(`push`는 항상 여기), `stack2`는 꺼내는 곳(`pop`, `peek`)이다.
꺼내야 할 때 `stack2`가 비어 있으면 `stack1`을 전부 `stack2`로 옮긴다. 옮기면 가장 먼저 넣은 원소가 `stack2`의 맨 위에 온다.

## 시간복잡도 / 공간복잡도

- 시간: 연산당 분할 상환(amortized) O(1). 한 번 옮기면 O(n)이지만 각 원소는 `stack1`에서 `stack2`로 딱 한 번만 옮겨진다.
- 공간: O(n)

## 막혔던 점

- 스택 두 개로 큐를 어떻게 만드는지 감이 안 왔다. 스택을 한 번 더 거치면 순서가 뒤집힌다는 발상이 핵심이었다.
- `stack1`을 `stack2`로 옮기는 조건은 `stack2`가 비어 있을 때만이다. `stack2`에 원소가 남아 있는데 또 옮기면 더 오래된 원소보다 새 원소가 먼저 나온다.
- `empty()`는 두 스택이 모두 비어야 true다. `stack1`만 확인하면 `stack2`에 남은 원소를 놓친다. (제출한 코드는 `move()` 후 `stack2.isEmpty()`로 확인해서 같은 결과를 낸다.)
