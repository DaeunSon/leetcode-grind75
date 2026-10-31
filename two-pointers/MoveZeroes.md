# 283. Move Zeroes

- 링크: https://leetcode.com/problems/move-zeroes/
- 유형: 투 포인터 (같은 방향, 느린·빠른 포인터, [노트](https://github.com/DaeunSon/algorithm-notes/tree/main/05-two-pointers)의 모양 2). Grind 75 밖, 노트 연습 문제
- 날짜: 2026-10-31
- 상태: 혼자 풀어서 통과

## 접근

- `fast`는 처음부터 끝까지 모든 칸을 읽는다.
- `slow`는 "다음에 남길 값을 쓸 자리"다. 0이 아닌 값을 만나면 `nums[slow++] = nums[fast]`로 앞으로 모은다.
- 다 읽고 나면 `slow`부터 끝까지 0으로 채운다.

0이 아닌 값의 순서는 그대로 유지되고, 추가 배열 없이 제자리에서 끝난다.

## 시간복잡도 / 공간복잡도

- 시간: O(n)
- 공간: O(1)

## 막혔던 점

- 막힌 곳 없음.
- `else { continue; }`는 반복문의 마지막 문장이라 없어도 똑같이 다음 칸으로 간다. 지워도 된다.
- `slow`는 `fast`를 앞지를 수 없다. 그래서 덮어쓰는 칸은 항상 `fast`가 이미 읽은 칸이고, 아직 안 읽은 값을 잃지 않는다.
- 다른 풀이: 0이 아닌 값을 만나면 `nums[slow]`와 `nums[fast]`를 **맞바꾸고** `slow++`. 마지막에 0으로 채우는 반복문이 필요 없다.
