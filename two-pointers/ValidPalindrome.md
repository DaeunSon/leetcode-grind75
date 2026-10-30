# 125. Valid Palindrome

- 링크: https://leetcode.com/problems/valid-palindrome/
- 유형: two-pointers (양 끝에서 안쪽으로 비교) + 문자 걸러내기
- 날짜: 2026-10-21
- 상태: 혼자 풂. "non-alphanumeric"의 뜻을 몰라 처음에 숫자까지 걸러서 헤맴 → 2026-10-21 투 포인터 방식으로 다시 풂

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

## 두 번째 풀이: 배열 없이 투 포인터 (2026-10-21)

파일: [`ValidPalindromeTwoPointers.java`](ValidPalindromeTwoPointers.java)

### 접근

원래 문자열에서 바로 비교한다. 한 바퀴에 하는 일을 셋 중 하나로 정한다.

- `left`가 영문자/숫자가 아니면 → `left`만 이동하고 `continue`
- `right`가 영문자/숫자가 아니면 → `right`만 이동하고 `continue`
- 둘 다 영문자/숫자면 → 비교해서 다르면 `false`, 같으면 둘 다 안쪽으로

### 시간복잡도 / 공간복잡도

- 시간: O(n)
- 공간: O(n)  (`s.toLowerCase()`가 새 문자열을 만든다. 글자마다 `Character.toLowerCase`로 비교하면 O(1))

### 막혔던 점

- 처음에는 대소문자를 구분해서 `"Aa"`가 `false`가 됐다. 비교 전에 소문자로 맞춰야 한다.
- 기호를 건너뛴 직후 같은 바퀴에서 바로 비교했다. 다음 칸이 또 기호일 수 있고, `left`와 `right`가 엇갈릴 수도 있어서 `"ab, ba"`, `".,"`가 `false`가 됐다. 건너뛰었으면 `continue`로 반복문 처음(조건 검사)으로 돌아간다.

## 재풀이 기록 (2026-10-30)

05 투 포인터·슬라이딩 윈도우 노트(모양 1)를 공부한 뒤 배열 방식으로 다시 풀어서 통과. [`ValidPalindrome.java`](ValidPalindrome.java)는 재풀이한 코드로 바꿨다(처음 코드는 git 기록에 있다).

- 처음 풀 때 메모의 개선점 세 가지를 모두 반영했다.
  - 범위 비교 두 줄 → `Character.isLetterOrDigit`
  - 디버깅용 `System.out.println` 삭제
  - 필요 없던 `if (pos == 1) return true;` 삭제
- `while (left < right)`: 가운데 한 칸(`left == right`)은 자기 자신과 비교할 필요가 없다. 걸러낸 글자가 0개(`" "`)면 `right = -1`이라 반복문에 들어가지 않고 `true`.
