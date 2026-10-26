# 217. Contains Duplicate

- 링크: https://leetcode.com/problems/contains-duplicate/
- 유형: 해시 ("이미 나왔는지" 확인)
- 날짜: 2026-10-26
- 상태: 혼자 풀어서 통과

## 접근

앞에서부터 하나씩 `HashMap`에 개수를 세면서 넣는다.
방금 넣은 값의 개수가 2 이상이 되는 순간 중복이므로 바로 `true`를 반환한다. 끝까지 없으면 `false`.

## 시간복잡도 / 공간복잡도

- 시간: O(n)  (해시 조회·삽입이 평균 O(1))
- 공간: O(n)

## 막혔던 점

- 막힌 곳 없음. 중복을 찾자마자 반환해서 끝까지 다 셀 필요가 없다.
- 개선: 개수가 아니라 "이미 나왔는지"만 알면 되므로 `HashSet`이면 충분하다. `set.add(x)`는 이미 있으면 `false`를 돌려준다 → `if (!set.add(nums[i])) return true;`
- 다른 풀이: 정렬한 뒤 이웃끼리 비교(`nums[i] == nums[i+1]`). 시간 O(n log n), 추가 공간은 거의 없다.
