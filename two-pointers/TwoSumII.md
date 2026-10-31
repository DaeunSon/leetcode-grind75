# 167. Two Sum II - Input Array Is Sorted

- 링크: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
- 유형: 투 포인터 (양 끝에서 안쪽으로, [노트](https://github.com/DaeunSon/algorithm-notes/tree/main/05-two-pointers)의 모양 1). Grind 75 밖, 노트 연습 문제
- 날짜: 2026-10-31
- 상태: 혼자 풀어서 통과

## 접근

배열이 오름차순으로 정렬되어 있으므로 양 끝에서 시작한다.
- 합이 target이면 1부터 세는 인덱스(`left + 1`, `right + 1`)를 반환한다.
- 합이 작으면 `left++`: `numbers[left]`는 남은 가장 큰 수와 더해도 모자라므로 버린다.
- 합이 크면 `right--`: `numbers[right]`는 남은 가장 작은 수와 더해도 크므로 버린다.

## 시간복잡도 / 공간복잡도

- 시간: O(n)
- 공간: O(1)  (Two Sum 1번의 해시 풀이는 O(n) 공간이 필요했다. 정렬되어 있다는 조건 덕분에 공간이 줄었다)

## 막혔던 점

- 값을 넣어 배열을 바로 만드는 문법: `new int[]{left + 1, right + 1}`. `new int[a, b]`는 없는 문법이고, `new int[2]`는 크기 2짜리 `[0, 0]`이다. `{3, 5}`만 쓰는 건 선언하는 줄(`int[] a = {3, 5};`)에서만 된다.
- 반복문 뒤의 `return new int[]{left+1, right+1};`은 문제가 "답이 정확히 하나 있다"고 보장해서 실행되지 않는다. 그래도 답처럼 보이는 값을 돌려주기보다 `new int[]{-1, -1}`처럼 "못 찾음"이 드러나게 쓰는 편이 안전하다.
- 같은 합을 두 번 계산하므로 `int sum = numbers[left] + numbers[right];`로 한 번만 구해도 된다.
- Two Sum(1번)은 정렬되어 있지 않고 **원래 인덱스**를 답해야 해서, 정렬하는 순간 인덱스를 잃는다 → 해시. 이 문제는 이미 정렬되어 있어서 투 포인터가 된다.
