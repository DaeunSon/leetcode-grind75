# 704. Binary Search

- 링크: https://leetcode.com/problems/binary-search/
- 유형: 이분 탐색 (값 찾기, [노트](https://github.com/DaeunSon/algorithm-notes/tree/main/04-binary-search)의 틀 1)
- 날짜: 2026-10-29
- 상태: 이분 탐색 노트를 공부한 뒤 작성, 통과

## 접근

정렬된 배열의 가운데(`mid`)를 확인한다.
- 찾는 값이면 `mid`를 반환한다.
- 가운데 값이 더 작으면 답은 오른쪽에만 있을 수 있다 → `left = mid + 1`
- 가운데 값이 더 크면 답은 왼쪽에만 있을 수 있다 → `right = mid - 1`

`left > right`가 되면 범위가 비었으므로 없는 값이다 → `-1`.

## 시간복잡도 / 공간복잡도

- 시간: O(log n)
- 공간: O(1)

## 막혔던 점

- 막힌 곳 없음.
- `while (left <= right)`와 `mid ± 1`이 한 쌍이다. `<=`인 이유: `left == right`일 때도 남은 칸이 하나 있어서 확인해야 한다(원소 1개짜리 배열 `[5]`에서 5 찾기).
- `mid = left + (right - left) / 2`로 써서 `left + right`가 `int`를 넘는 경우를 피했다.

## 재풀이 기록 (2026-11-11)

- 결과: ○ (힌트 없이 혼자 통과, 면접 전 가볍게 다시 풀기)
- 주석에 "정렬됨 + O(log n) → 투 포인터는 O(n)이라 이분 탐색"이라고 **고른 이유**를 먼저 적음. 실수 노트 1번(이분 탐색 vs 투 포인터)을 바로 적용
- `while (left <= right)`, `mid = left + (right - left) / 2`, `mid ± 1` 모두 처음부터 맞게 씀
- 이 문제는 "정확히 같은 값"을 찾아서 같으면 바로 `return mid`. "처음으로 T가 되는 곳"(First Bad Version 등)은 틀 1 + `answer`로 쓴다
