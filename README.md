# leetcode-grind75

LeetCode Grind 75를 유형별로 풀고 기록하는 저장소입니다.

## 폴더 구조

| 폴더 | 유형 |
|---|---|
| `array` | 배열 |
| `string` | 문자열 |
| `hash` | 해시 (HashMap, HashSet) |
| `two-pointers` | 투 포인터 |
| `stack-queue` | 스택, 큐 |
| `sorting` | 정렬 |
| `binary-search` | 이분 탐색 |
| `linked-list` | 연결 리스트 |
| `tree` | 트리 |
| `graph` | 그래프 (BFS, DFS) |
| `dp` | 동적 계획법 |
| `math` | 수학, 비트 |

## 기록 방법

- 풀이 코드: `유형/문제이름.java` (예: `hash/TwoSum.java`)
- 풀이 메모: `TEMPLATE.md`를 복사해서 같은 폴더에 `문제이름.md`로 저장
- 문제 설명은 복사하지 않고 링크만 남깁니다.

## 유형별 외울 틀

코드를 통째로 외우지 않고 **뼈대만** 외운다. 문제를 읽고 유형을 정했으면 틀을 떠올리고, 문제마다 바뀌는 부분만 채운다. 코드 전체는 `algorithm-notes`의 [틀 모음](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md)에 있다.

| 폴더 | 틀 | 문제마다 바뀌는 것 |
|---|---|---|
| `array` | [정렬 → 이웃과 비교](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#03-정렬) · [누적 합](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#12-누적-합) · [방향 배열 + 경계 검사](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#06-구현-시뮬레이션) | 정렬 기준, 구간의 양 끝, 이동 규칙 |
| `string` | [개수 세기](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#01-해시) (`int[26]` 또는 `HashMap`) · [양 끝에서 안쪽으로](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#05-투-포인터-슬라이딩-윈도우) | 무엇을 세나, 건너뛸 문자 |
| `hash` | [개수 세기 · 짝 찾기(찾기 → 넣기)](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#01-해시) | 키와 값에 무엇을 넣나 |
| `two-pointers` | [양 끝에서 안쪽으로 · 가변 길이 창](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#05-투-포인터-슬라이딩-윈도우) | 포인터를 움직이는 조건 |
| `stack-queue` | [짝 맞추기 · 단조 스택](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#02-스택-큐) | 언제 `pop` 하나 |
| `sorting` | [정렬 → 한 번 훑으며 이웃과 비교](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#03-정렬) | 정렬 기준, 이웃과 비교하는 식 |
| `binary-search` | [`left <= right` + `answer`](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#04-이분-탐색) | `조건(mid)`, 참일 때 어느 쪽으로 가나 |
| `linked-list` | [`dummy` 노드 · 뒤집기 · 느린·빠른 포인터](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#연결-리스트) | 무엇을 이어 붙이나 |
| `tree` | [`null` 처리 → 왼쪽·오른쪽 답 → 합치기 · 레벨 순회](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#트리) | `null`일 때 값, 합치는 식 |
| `graph` | [DFS](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#08-dfs) · [BFS](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#10-bfs) · [인접 리스트 · 유니온 파인드](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#15-그래프) | 갈 수 있는 칸의 조건, 도착 조건 |
| `dp` | [`dp[i]` 뜻 → 처음 값 → 점화식 → 채우는 순서](https://github.com/DaeunSon/algorithm-notes/blob/main/틀-모음.md#14-dp) | `dp[i]`의 뜻과 점화식 |
| `math` | 정해진 틀 없음. 자릿수는 뒤에서부터 `% 10`, `/ 10`과 올림(`carry`) | |

가장 자주 쓰는 트리 재귀 틀:

```java
int dfs(TreeNode node) {
    if (node == null) return 기본값;      // 1. 빈 트리의 답
    int left = dfs(node.left);            // 2. 왼쪽·오른쪽 답을 받는다
    int right = dfs(node.right);
    return left와 right로 내 답 계산;      // 3. 합쳐서 반환 (문제마다 바뀜)
}
```

## 진행 상황

| 유형 | 푼 문제 수 |
|---|---|
| array | 3 |
| string | 3 |
| hash | 5 |
| two-pointers | 6 |
| stack-queue | 4 |
| sorting | 4 |
| binary-search | 5 |
| linked-list | 0 |
| tree | 5 |
| graph | 0 |
| dp | 0 |
| math | 1 |

## Grind 75 진행 목록

지금 풀 수 있는 문제와 나중에 풀 문제는 [GRIND75.md](GRIND75.md)에서 관리한다.
