# 278. First Bad Version

- 링크: https://leetcode.com/problems/first-bad-version/
- 유형: 이분 탐색 (조건이 처음으로 참이 되는 위치, [노트](https://github.com/DaeunSon/algorithm-notes/tree/main/04-binary-search)의 틀 2)
- 날짜: 2026-10-29
- 상태: 혼자 풀어서 통과 (`left <= right`로 먼저 냈다가 시간 초과 → `left < right`로 고침)

## 접근

버전은 `좋음 … 좋음 나쁨 … 나쁨`처럼 한 번만 바뀐다. 처음으로 나쁜 버전을 찾는다.
- `mid`가 나쁨 → `mid`가 답일 수도 있으므로 **남긴다**: `right = mid`
- `mid`가 좋음 → `mid`는 답이 아니므로 버린다: `left = mid + 1`

`left == right`가 되면 후보가 하나 남은 것이므로 그게 답이다.

## 시간복잡도 / 공간복잡도

- 시간: O(log n)  (`isBadVersion` 호출 약 31번 이하)
- 공간: O(1)

## 막혔던 점

- `while (left <= right)`로 내니 **시간 초과**가 났다. `right = mid`와 `<=`를 같이 쓰면 무한 반복이다.
  - `n = 1`, 1이 나쁜 버전: `left = 1, right = 1` → `mid = 1` → 나쁨 → `right = 1` → 값이 그대로라 영원히 반복.
  - `left == right`인 순간 `mid`도 같은 값이 되고, `right = mid`는 범위를 줄이지 못한다.
- **`while` 조건과 갱신은 한 쌍**이다.
  - 틀 1: `left <= right` + `left = mid + 1` / `right = mid - 1` (양쪽 모두 `mid`를 버림)
  - 틀 2: `left < right` + `right = mid` / `left = mid + 1` (`mid`를 남기는 쪽이 있으므로 `left == right`에서 멈춰야 함)
- `n`이 최대 2³¹ − 1이라 `(left + right) / 2`는 넘친다 → `left + (right - left) / 2`.
