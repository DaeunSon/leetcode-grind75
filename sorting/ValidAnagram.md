# 242. Valid Anagram

- 링크: https://leetcode.com/problems/valid-anagram/
- 유형: sorting (두 문자열을 정렬해서 비교). 해시로도 풀 수 있다
- 날짜: 2026-10-27
- 상태: 혼자 풀어서 통과

## 접근

애너그램은 글자의 **순서만** 다르고, 글자 종류와 개수가 같다.
두 문자열을 `char[]`로 바꿔 정렬하면, 애너그램일 때 두 배열이 완전히 같아진다.
길이가 다르면 바로 `false`, 같으면 정렬한 뒤 한 칸씩 비교한다.

## 시간복잡도 / 공간복잡도

- 시간: O(n log n)  (정렬)
- 공간: O(n)  (`toCharArray`로 만든 배열)

## 막혔던 점

- 막힌 곳 없음.
- `new char[s.length()]`로 만든 배열은 바로 다음 줄의 `s.toCharArray()`가 **새 배열**로 덮어써서 쓰이지 않는다. `char[] s_array = s.toCharArray();` 한 줄이면 된다.
- 한 칸씩 비교하는 반복문은 `Arrays.equals(s_array, t_array)`로 바꿀 수 있다. 배열끼리 `==`는 내용이 아니라 같은 배열인지(참조)를 비교하므로 쓰면 안 된다.
- 다른 풀이: 알파벳 26칸 `int[] count`에 `s`의 글자는 `+1`, `t`의 글자는 `-1` 한 뒤 전부 0인지 확인 (`c - 'a'`). 시간 O(n), 공간 O(1). Ransom Note와 같은 패턴이다.
