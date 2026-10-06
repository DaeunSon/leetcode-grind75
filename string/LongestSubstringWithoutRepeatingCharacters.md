# 3. Longest Substring Without Repeating Characters

- 링크: https://leetcode.com/problems/longest-substring-without-repeating-characters/
- 유형: string / sliding window (hash set + two pointers)
- 날짜: 2026-10-06
- 상태: 이중 for문 브루트포스로 먼저 시도했으나 구현이 어긋남 → 슬라이딩 윈도우는 설명을 듣고 작성, 오류 수정 후 통과 (재풀이 필요)

## 접근

`right`를 한 칸씩 오른쪽으로 옮기며 `s[right]`가 창(`Set`) 안에 있는지 확인한다.
중복이면 `while`로 `left`를 한 칸씩 밀면서 `s[left]`를 창에서 빼서 중복이 사라질 때까지 반복한다.
중복이 없어지면 `s[right]`를 창에 넣고 `max = Math.max(max, right - left + 1)`로 최대 길이를 갱신한다.

## 시간복잡도 / 공간복잡도

- 시간: O(n)  (`left`, `right`가 각각 뒤로 가지 않고 최대 n번씩만 이동)
- 공간: O(k)  (창 안의 서로 다른 글자 수, 문자 종류가 제한적)

## 막혔던 점

- 처음에는 시작점 i를 고정하고 오른쪽으로 늘려가는 브루트포스를 시도했는데, 맵을 시작점마다 초기화하지 않았고 시작 글자(`charAt(i)`)만 세는 등 구현이 어긋났다.
- `window.remove(left)`: `left`는 `int`라서 `Set<Character>`에서 아무것도 지워지지 않고, `while`이 끝나지 않아 시간 초과가 났다. `window.remove(s.charAt(left))`로 고쳤다. (`Object`를 받는 메서드는 타입이 틀려도 컴파일 에러가 나지 않는다.)
- `max = Math.max(left, ...)`: `max`와 비교해야 하는데 `left`와 비교했다.
