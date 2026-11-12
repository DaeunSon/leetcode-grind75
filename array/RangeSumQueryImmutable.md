# 303. Range Sum Query - Immutable

- 링크: https://leetcode.com/problems/range-sum-query-immutable/
- 유형: 누적 합 (prefix sum), 클래스 설계
- 날짜: 2026-11-12
- 상태: 빈칸 뼈대로 풀이 확인 후 풂 → LeetCode 통과 → Google Docs 백지로 다시 씀 (Grind 75 외, 콜레봅스 면접 대비 연습)

## 접근

`sumRange`가 최대 10^4번 불린다. 호출마다 left~right를 더하면 O(n) × 10^4번 = 최악 10^8이라 위험하다.
그래서 생성자에서 누적합 배열을 **한 번** 만들어 필드에 저장하고, `sumRange`는 빼기 한 번으로 끝낸다.

- `prefix[i]` = 앞에서부터 **i개**를 더한 값. 크기는 `n + 1`, `prefix[0] = 0`
- `sumRange(left, right) = prefix[right + 1] - prefix[left]`

## 시간복잡도 / 공간복잡도

- 시간: 생성자 O(n), `sumRange` O(1) → q번 호출하면 O(n + q)
- 공간: O(n)

## 막혔던 점

- **`sumRange`에 배열이 안 넘어오는데 어떻게 계산하지?** → 생성자에서 만든 걸 **필드**에 저장해 두면 메서드에서 꺼내 쓸 수 있다.
- **왜 맨 앞에 0을 두고 한 칸 더 만드나?** 같은 길이(`p[i]` = 0~i 합)로 만들면 공식이 `p[right] - p[left - 1]`이라 `left = 0`일 때 `p[-1]`이 없어서 `if`가 필요하다. 맨 앞 0("아무것도 안 더한 잔고")을 두면 공식 하나로 끝난다.
- 빈칸 ①에 `nums.length`라고 씀 → 마지막 `i = n-1`에서 `prefix[n]`에 쓰므로 크기 `n + 1`이어야 한다.
- 빈칸 ③④에 `prefix[right] - prefix[left + 1]`이라고 씀 → `prefix[i]`를 "i번째까지 합"으로 착각. left는 답에 포함되므로 빼는 건 "left **바로 앞까지**" = `prefix[left]`. (통장 비유: 5일 밤 잔고 − 3일 아침 잔고)
- `public void NumArray`로 써야 하나 질문 → 생성자는 **클래스 이름 그대로, 반환 타입 없음**. `void`를 붙이면 일반 메서드가 되어 `new NumArray(nums)`가 컴파일 에러.

## Google Docs 백지 풀이 기록 (2026-11-12)

- 로직(크기 `n + 1`, 반복문, 빼기 공식)은 모두 맞게 씀
- **`class Solution`이라고 씀** → 생성자 이름이 `NumArray`라서 클래스 이름도 `NumArray`여야 한다. 클래스 이름과 생성자 이름이 다르면 컴파일 에러 (생성자가 아니라 반환 타입 없는 메서드로 읽힘)
- 들여쓰기가 탭/공백 섞임, 반복문 안 줄과 닫는 `}`가 들여쓰기 안 됨 → 중괄호 짝 세기가 어려워진다
