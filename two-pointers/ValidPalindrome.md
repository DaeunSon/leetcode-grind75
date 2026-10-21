# 125. Valid Palindrome

- 링크: https://leetcode.com/problems/valid-palindrome/
- 유형: two-pointers (양 끝에서 안쪽으로 비교) + 문자 걸러내기
- 날짜: 2026-10-21
- 상태: 혼자 풂. "non-alphanumeric"의 뜻을 몰라 처음에 숫자까지 걸러서 헤맴

## 접근

문자열을 소문자로 바꾸고, 영문자와 숫자만 `char[]`에 모은다.
`left = 0`, `right = 끝`에서 시작해서 안쪽으로 오면서 두 글자가 다르면 `false`, 다 같으면 `true`.

## 시간복잡도 / 공간복잡도

- 시간: O(n)
- 공간: O(n)  (걸러낸 글자를 담는 배열)

## 막혔던 점

- **alphanumeric = alphabetic(영문자) + numeric(숫자)**. non-alphanumeric은 영문자도 숫자도 아닌 것(공백, 쉼표, 콜론 등)이다. 숫자는 남겨야 한다. (`"0P"`는 숫자 0을 남겨야 `false`가 나온다.)
- 범위 비교 대신 `Character.isLetterOrDigit(c)`, 대소문자 무시는 `Character.toLowerCase(c)`를 쓸 수 있다.
- 디버깅용 `System.out.println`은 제출 전에 지운다. 입력이 길면 출력 때문에 느려질 수 있다.
- `if (pos==1) return true;`는 없어도 된다. `pos`가 0이나 1이면 `while(right > left)`에 들어가지 않고 `true`가 된다.
- 배열을 따로 만들지 않고 원래 문자열에서 바로 투 포인터로 비교할 수도 있다. 영문자나 숫자가 아니면 그 포인터만 건너뛰면 되고, 공간이 O(1)이 된다.
