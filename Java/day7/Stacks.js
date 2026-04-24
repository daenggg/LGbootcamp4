/*

Java vs JavaScript 스택 핵심 차이점
- Java : java.util.Stack 클래스 import 필요
- Js : 배열(Array)이 스택 역할을 바로 할 수 있음! (push/pop 내장)
- Java의 경우 Deque 사용이 권장이 됨
- Js : const stack = []; (배열로 바로 사용)
*/

const stack = []; // 배열이 곧 스택

// push() : 맨 위(오른쪽,뒤)에 추가
stack.push(10);
console.log("push(10) -> ", [...stack]);
stack.push(20);
console.log("push(20) -> ", [...stack]);
stack.push(30);
console.log("push(30) -> ", [...stack]);
stack.push(40);
console.log("push(40) -> ", [...stack]);

// pop() : 맨 위에서 꺼냄 -> 후입선출
const poped = stack.pop();
console.log([...stack]);

//peek() : 맨 위 확인만 ()꺼내지 않음
const top = stack[stack.length - 1]; // 배열의 마지막 요소가 스택의 top

// isEmpty() : 비어있는지 확인
console.log("isEmpty:", stack.length === 0); // false

// + 여담
// 스택 클래스 직접 구현 Java Stack 클래스와 유사하게 구현

class Stack {
  #items = []; //private 배열 (스택 내부 저장소)

  push(item) {
    this.#items.push(item);
  }
  pop() {
    if (this.isEmpty()) throw new Error("Stack is Empty!");
    return this.#items.pop();
  }
  peek() {
    if (this.isEmpty()) throw new Error("Stack is Empty!");
    return this.#items[this.#items.length - 1];
  }
  isEmpty() {
    return this.#items.length === 0;
  }
  size() {
    return this.#items.length;
  }

  toString() {
    return this.#items.toString();
  }
}

const myStack = new Stack();
myStack.push(1);
myStack.push(2);
myStack.push(3);
console.log(myStack.toString());
console.log(myStack.peek());
console.log(myStack.pop());
console.log(myStack.size());

// JS로 푸는 괄호 검사
function isValidBrackets(s) {
  const stack = [];
  const matching = { ")": "(", "]": "[", "}": "{" };

  for (const ch of s) {
    if ("([{".includes(ch)) {
      stack.push(ch); // 여는 괄호는 push
    } else if (")]}".includes(ch)) {
      if (stack.length === 0 || stack[stack.length - 1] !== matching[ch]) {
        return false; // 짝이 맞지 않음
      }
      stack.pop();
    }
  }
  return stack.length === 0; // 스택이 비어야 올바른 괄호
}

// JS로 푸는 역순 출력

function reverseString(s) {
  const stack = [];
  for (const ch of s) stack.push(ch);
  let result = "";
  while (stack.length > 0) result += stack.pop();
  return result;
}

// 여담으로 JS에는 더 간단한 방법이 있음:
console.log(`"Hello" 역순 (JS방식): "${"Hello".split("").reverse().join("")}"`);

// 후위표기법 계산
function evalPostfix(tokens) {
  const stack = [];

  for (const token of tokens) {
    if (!isNaN(token)) {
      //숫자면 push
      stack.push(Number(token));
    } else {
      // 연산자면 두 값을 pop해서 계산
      const b = stack.pop();
      const a = stack.pop();
      switch (token) {
        case "+":
          stack.push(a + b);
          break;
        case "-":
          stack.push(a - b);
          break;
        case "*":
          stack.push(a * b);
          break;
        case "/":
          stack.push(Math.floor(a / b));
          break;
      }
    }
  }
  return stack.pop();
}

/*
JS의 경우에는 import가 필요없고 배열을 스택으로 취급하여 사용한다
push, pop 동일하게 사용할 수 있다
peek -> length - 1
isEmpty -> length === 0
size -> length

JS의 경우 배열 자체가 스택 역할 별도 클래스 불필요 크기 지정 해줄 필요 없음
Java에서 Deque를 사용하면 이게 더 빠르긴 함
*/
