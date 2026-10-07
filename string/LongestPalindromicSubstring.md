# 5. Longest Palindromic Substring

- 링크: https://leetcode.com/problems/longest-palindromic-substring/
- 유형: string / expand around center
- 날짜: 2026-10-07
- 상태: 풀이 방향을 설명받은 뒤 작성, 디버깅 후 통과 (재풀이 필요)

## 접근

팰린드롬은 가운데를 기준으로 좌우가 대칭이다. 모든 위치를 가운데 후보로 잡고 바깥으로 넓힌다.
가운데가 글자 하나인 홀수 길이(`expand(s, c, c)`)와 글자 두 개 사이인 짝수 길이(`expand(s, c, c+1)`)를 모두 확장해서 더 긴 쪽을 최고 기록과 비교한다.
`expand`는 양쪽 글자가 같은 동안 넓히고, 멈춘 뒤 `right - left - 1`을 길이로 반환한다.
시작 위치는 `start = center - (len - 1) / 2`로 구한다 (홀수/짝수 모두 맞음).

## 시간복잡도 / 공간복잡도

- 시간: O(n²)  (가운데 n개 × 최대 n칸 확장)
- 공간: O(1)

## 막혔던 점

- 처음에는 양 끝 글자가 같으면 팰린드롬이라고 보는 방식을 시도했다. 가운데를 확인하지 않아서 틀린다 (예: `abca`).
- 뒤집어서 비교하는 방식도 시도했는데, `substring`의 끝 인덱스(미포함), 모든 (시작, 끝) 쌍 미확인, 엉뚱한 변수 반환 등 구현 오류가 있었다.
- 홀수/짝수 확장을 둘 다 해야 하는 이유: 홀수 확장은 홀수 길이만, 짝수 확장은 이웃한 두 글자가 같은 짝수 길이만 만든다.
- `expand`의 반환 식을 `right - left + 1`로 써서 `StringIndexOutOfBoundsException: Range [-1, 4)`가 났다. 반복이 멈출 때 `left`, `right`는 팰린드롬 범위를 한 칸씩 지나쳐 있으므로 `right - left - 1`이다.
