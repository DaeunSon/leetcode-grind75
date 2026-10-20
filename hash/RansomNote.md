# 383. Ransom Note

- 링크: https://leetcode.com/problems/ransom-note/
- 유형: hash (글자별 개수 세기)
- 날짜: 2026-10-20
- 상태: 첫 시도에서 막힌 부분을 설명받은 뒤 다시 작성해서 통과

## 접근

`magazine`의 글자별 개수를 `HashMap`에 센다.
`ransomNote`의 글자를 하나씩 보면서 개수를 1씩 줄이고, 줄이려는 순간 0이면 그 글자가 모자란 것이므로 `false`를 반환한다.
끝까지 모자라지 않으면 `true`.

## 시간복잡도 / 공간복잡도

- 시간: O(n + m)  (n = ransomNote 길이, m = magazine 길이, 해시 조회와 갱신은 평균 O(1))
- 공간: O(k)  (서로 다른 글자 수)

## 막혔던 점

- 첫 시도에서는 `ransomNote`의 글자가 맵에 "있는지"만 확인하고 개수를 줄이지 않아서, `"aa"` / `"ab"`처럼 같은 글자가 더 필요한 경우를 놓쳤다. 글자를 쓸 때마다 개수를 소모해야 한다.
- `HashMap`에는 `getKeys()`가 없다. 키 목록은 `keySet()`이다. (최종 코드에서는 키를 훑을 필요 없이 `getOrDefault`로 바로 조회한다.)
- 없는 키를 `get`하면 `null`이라서 `getOrDefault(c, 0)`으로 0을 기본값으로 쓴다.
- 영어 소문자만 나오면 `int[26]` 배열로 세는 방법도 있다 (`count[c - 'a']`).
