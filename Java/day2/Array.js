/*

java와의 핵심 차이점
java : int[] arr = {1,2,3}; -> js : const arr = [1,2,3];
java ,js : arr.length 동일
java : Arrays.toString(arr) -> js : arr.toString() 또는 JSON.stringify(arr)
java : Arrays.sort(arr) -> js : arr.sort((a,b) => a-b)
JS배열은 동적! 크기를 미리 지정하지 않아도 됨
*/

// JS  선형탐색
function linearSearch(arr, target) {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === target) {
      return i;
    }
  }
  return -1;
}

// 자바스크립트 에서는 이미 내장 탐색 메서드가 있음!
// arr.indexOf(target) : 첫 번째 인덱스 반환, 없으면 -1 (선형탐색과 동일)
// arr.includes(target) : 있으면 true , 없으면 false
// arr.findIndex(fn) : 조건 함수를 만족하는 첫 인덱스 반환

// 모든 위치 찾기 (중복 포함)
function findAll(arr, target) {
  const result = [];
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === target) result.push(i); // 동적으로 추가
  }
  return result;
}

// node 파일명.js 실행됨!

// TODO 풀이
// 1.
const names = ["김철수", "이영희", "박민준"];
function searchName(names, target) {
  for (let i = 0; i < names.length; i++) {
    if (names[i] === target) return i;
  }
  return -1;
}
// 2.
const searchArr = [4, 2, 7, 1, 8, 3, 6, 5];
let min1 = 100;
let min2 = 100;

for (const val of searchArr) {
  if (val < min1) {
    min2 = min1;
    min1 = val;
  } else if (val < min2 && val !== min1) {
    min2 = val;
  }
}
// 3.
const sortedForInsert = [1, 3, 5, 7, 9, 11, 13, 15];
const insertTarget = 6;
let iLeft = 0,
  iRight = sortedForInsert.length - 1;

let insertPos = sortedForInsert.length;

while (iLeft <= iRight) {
  const mid = Math.floor((iLeft + iRight) / 2);
  if (sortedForInsert[mid] >= insertTarget) {
    insertPos = mid;
    iRight = mid - 1;
  } else {
    iLeft = mid + 1;
  }
}
