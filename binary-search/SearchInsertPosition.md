# 35. Search Insert Position

- 링크: https://leetcode.com/problems/search-insert-position/
- 유형: 이분 탐색 (넣을 자리 찾기). Grind 75 밖, [노트](https://github.com/DaeunSon/algorithm-notes/tree/main/04-binary-search) 연습 문제
- 날짜: 2026-10-29
- 상태: 혼자 풀어서 통과

## 접근

틀 1(값 찾기)을 그대로 쓰고, 못 찾았을 때 `-1` 대신 `left`를 반환한다.

반복하는 동안 항상 이렇게 유지된다.
- `left`보다 왼쪽 칸은 전부 `target`보다 **작다**.
- `right`보다 오른쪽 칸은 전부 `target`보다 **크다**.

반복문이 끝나면 `left = right + 1`이다. 그래서 `left`는 "처음으로 `target`보다 큰 칸", 즉 넣을 자리다.

| 입력 `[1,3,5,6]` | left | right | mid | 판단 |
|---|---|---|---|---|
| target 2 | 0 | 3 | 1 | 2 < 3 → `right = 0` |
| | 0 | 0 | 0 | 2 > 1 → `left = 1` |
| | 1 | 0 | | 끝 → **1** 반환 |
| target 7 | 0 | 3 | 1 | 7 > 3 → `left = 2` |
| | 2 | 3 | 2 | 7 > 5 → `left = 3` |
| | 3 | 3 | 3 | 7 > 6 → `left = 4` |
| | 4 | 3 | | 끝 → **4** 반환 (배열 끝 다음) |

## 시간복잡도 / 공간복잡도

- 시간: O(log n)
- 공간: O(1)

## 막혔던 점

- 막힌 곳 없음.
- target이 모든 값보다 크면 답이 `n`(끝 다음)인데, `right = n - 1`로 시작해도 된다. `left`가 마지막에 `right + 1 = n`까지 가기 때문이다.
- 다른 풀이: 노트의 틀 2(`left < right`, `right = mid`)로 "처음으로 `nums[i] >= target`인 위치"를 찾는다. 이때는 답이 `n`일 수 있으므로 `right = n`으로 시작한다. 두 방법 모두 답이 같다.
