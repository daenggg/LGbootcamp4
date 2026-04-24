/*
* 스택
* 스택의 LIFO(Last In First Out) 원리를 이해한다
* Java의 Stack클래스와 Deque를 사용할 수 있다.
* push , pop, peek, isEmpty 를 활용할 수 있다
* 스택을 활용한 괄호 검사와 역순 출력을 할 수 있다.
* */


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Stacks {
    static void main(String[] args) {

        /*
        * 스택 이란?
        * 스택은 '접시 쌓기' 와 같은 자료구조입니다.
        * 접시를 쌓을 때 : 아래부터 위로 차례로 쌓음
        * 접시를 꺼낼 때 : 위에서부터 꺼냄 (마지막에 쌓은 것을 먼저 꺼냄)
        *
        * 이런 원리를 LIFO (후입선출) 이라고 한다
        * "마지막에 들어온 곳이 가장 먼저 나간다"
        *
        * 스택 연산
        * push(요소) : 맨 위에 요소를 추가
        * pop() : 맨 위의 요소를 꺼내고 반환 (비어있으면 예외 발생)
        * peek() : 맨 위의 요소를 확인만 함 (꺼내지 않음)
        * isEmpty() : 스택이 비어있으면 true
        * size() : 스택에 있는 요소 수
        *
        * 실생활 예:
        * - 브라우저 뒤로가기 : 방문한 페이지를 스택에 쌓고, 뒤로가기 시 pop
        * - 실행 취소(Undo) : 수행한 작업을 스택에 쌓고, Ctrl + z 시 pop
        * - 재귀 함수 호출 : 함수 호출 스택
        * */

        // Java Stack 클래스 사용
        // import java.util.Stack; 필요
        Stack<Integer> stack = new Stack<>();


//        push() - 스택에 요소 추가 (맨 위에)
        stack.push(10);
        System.out.println("10 넣음: "+ stack);
        stack.push(20);
        System.out.println("20 넣음: "+ stack);
        stack.push(30);
        System.out.println("30 넣음: "+ stack);
        stack.push(40);
        System.out.println("30 넣음: "+ stack);

//        peek() - 맨 위에 요소 확인 (꺼내지 않음)
        int top = stack.peek();
        System.out.println("peek: "+top);
        System.out.println(stack);

//        pop() - 맨 위에 요소 꺼내기 (반환합니다)
        int poped = stack.pop();
        System.out.println("pop() = "+poped);

        System.out.println(stack);

//        isEmpty() , size()
        System.out.println("비어있는가? -> "+stack.isEmpty());
        System.out.println("크기: " + stack.size());

//        search() - Java Stack 전용 메서드 (1-based 위치 반환)
//        search(요소) : 요소가 위에서 몇 번째에 있는지 반환 (1이 top)
//        없으면 -1 반환
        stack.push(40);
        System.out.println(stack);
        System.out.println("20의 위치: "+stack.search(20));
        System.out.println("40의 위치: "+stack.search(40));

//        Deque 를 스택으로 사용 (권장 방법)
        /*
        * 왜 Deque를 사용하나요?
        * Java의 Stack 클래스는 오래된 구현으로, 성능으로 문제가 있습니다
        * 현대적인 Java코드에서는 ArrayDeque를 스택으로 사용하는 것을 권장합니다.
        *
        * Deque(Double-Ended Queue) = 양쪽 끝에서 삽입/삭제가 가능한 자료구조
        * 스택으로 쓸 때는 한쪽 끝(앞쪽)만 사용합니다.
        *
        * 스택의 경우에는 배열 오른쪽이 뚫려 있고,
        * 데크의 경우에는 배열 왼쪽이 뚫려 있습니다.
        *
        * Stack 메서드 -> Deque 메서드 대응표:
        * push(e) -> push(e) or addFirst(e)
        * pop() -> pop() or removeFirst()
        * peek() -> peek() or peekFirst()
        * */
//      사용하기 위해서는 import java.util.Deque

        Deque<String> dequeStack = new ArrayDeque<>();

        dequeStack.addFirst("첫 번째");
        dequeStack.addFirst("두 번째");
        dequeStack.addFirst("세 번째");

        System.out.println(dequeStack);

        dequeStack.removeFirst();

        System.out.println(dequeStack);

        dequeStack.peekFirst();

        System.out.println(dequeStack);

        dequeStack.addLast("네 번째");

        System.out.println(dequeStack);

        System.out.println(dequeStack.peek());

//        스택 활용 - 괄호 검사

//        괄호 검사 알고리즘
        /*
        * 문자열에서 모든 괄호가 올바르게 열리고 닫히는지 확인합니다.
        *
        * 알고리즘:
        * 1) 문자를 하나씩 읽는다.
        * 2) 여는 괄호 (,[,{ 를 만나면 스택에 push
        * 3) 닫는 괄호 ),],} 를 만나면:
        *   - 스택이 비어있으면 -> 잘못된 괄호 (닫는 괄호가 더 많음)
        *   - 스택에서 pop 한 것과 짝이 맞으면 -> 계속
        *   - 짝이 맞지 않으면 -> 잘못된 괄호
        * 4) 문자열 끝까지 처리 후 스택이 비어있으면 -> 올바른 괄호
        *   - 비어있지 않으면 -> 잘못된 괄호 (열린 괄호가 더 많음)
        * */

        String[] testCases = {
                "()",
                "()[]{}",
                "(]",
                "([)]",
                "{[()]}",
                "(((",
                "",
                "({[hello world]})"
        };

        for (String s : testCases){
            boolean valid = isValidBracket(s);
            System.out.print(valid+", ");
        }

//        활용 - 역순 출력
//        스택의 후입선출 특성을 이용한 출력

//        예제 1  : 문자열 뒤집기
        String original = "Hello, World!";
        Stack<Character> charStack = new Stack<>();

        for (char c : original.toCharArray()) {
            charStack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!charStack.isEmpty()) {
            reversed.append(charStack.pop());
        }
        System.out.println("원본: "+ original);
        System.out.println("역순: "+ reversed.toString());

//        예제 2 : 방문 기록 (브라우저 뒤로가기)
        Stack<String> history = new Stack<>();

        // 페이지 방문
        history.push("google.com");
        System.out.println("방문: google.com");
        history.push("naver.com");
        System.out.println("방문: naver.com");
        history.push("github.com");
        System.out.println("방문: github.com");
        history.push("ureca.com");
        System.out.println("방문: ureca.com");

        System.out.println("뒤로가기");
        history.pop(); // 현재 페이지 pop
        System.out.println("현재 페이지: " + history.peek());

        history.pop(); // 현재 페이지 pop
        System.out.println("현재 페이지: " + history.peek());

//        후위 표기식(Postfix Notation)
        /*
        * 일반적인 수식 : 3 + 4 * 2 = 11 (중위 표기식)
        * 후위 표기식 : 3 4 2 * + (연산자가 피연산자 뒤에 옴)
        *
        * 계산 알고리즘
        * 1) 토큰을 왼쪽에서 오른쪽으로 읽는다
        * 2) 숫아지면 스택에 push
        * 3) 연산자이면 스택에서 두개를  pop , 계산 , 결과를 push
        * 4) 마지막에 스택에 남은 값이 결과
        * */

        // "3 4 2 * + " = 3 + (4 * 2)
        String[] postfix = {"3","4","2","*","+"};
        int result = evaluatePostfix(postfix);
        System.out.println(result);

//        "5 1 2 + 4 * + 3 -"

        /* TODO 실습문제
        * 문제1 올바른 괄호 최소 삭제
        * - 문자열 "lee(t(c)o)de)" 에서 최소한의 괄호를 삭제해서
        * 올바른 괄호 문자열을 만드세요.
        * 힌트 : 스택에 여는 괄호의 인덱스를 저장하고,
        * 닫는 괄호가 나왔을때 짝이 없으면 해당 인덱스를 삭제 대상으로 표시
        *
        * 문제 2 히스토그램에서 가장 큰 직사각형
        * 히스토그램 높이 배열 [2,1,5,6,2,3] 에서
        * 만들 수 있는 가장 넓은 직사각형의 넓이를 스택을 이용해 구하세요
        * 힌트 : 단조 증가 스택 사용 = 현재 높이가 스택 top 보다 작으면 pop하며 넓이 계산
        *
        * 문제 3 일일 온도 문제
        * 온도 배열 [73,74,75,71,69,72,76,73] 에서
        * 각 날보다 따뜻한 날이 며칠 뒤에 오는지 배열로 출력하세요
        * 예 : [1,1,4,2,1,1,0,0](0은 이후에 더 따뜻한 날이 없음)
        * 힌트: 스택에 인덱스를 저장하고 , 더 따뜻한 날이 오면 pop하며 차이를 기록
        * */

//        1.
        String bracketStr = "lee(t(c)o)de)";
//        스택에 여는 괄호의 인덱스를 저장
//        짝이 없는 닫는 괄호 : 바로 삭제 대상으로 표시
//        짝이 없는 여는 괄호 : 마지막에 스택에 남은 인덱스들을 삭제 대상으로 표시
        boolean[] toDelete = new boolean[bracketStr.length()];
        Stack<Integer> idxStack = new Stack<>();

        for (int i = 0; i <bracketStr.length(); i++){
            char ch = bracketStr.charAt(i);
            if(ch == '(') {
                idxStack.push(i); //여는 괄호의 인덱스를 스택에 저장
            } else if (ch == ')'){
                if (idxStack.isEmpty()){
                    // 짝 없는 닫는 괄호 -> 삭제 대상
                    toDelete[i] = true;
                } else {
                    idxStack.pop(); // 짝이 맞으므로 스택에서 제거
                }
            }
        }
        // 스택에 남은 여는 괄호들도 삭제 대상
        while (!idxStack.isEmpty()) {
            toDelete[idxStack.pop()] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bracketStr.length(); i++){
            if (!toDelete[i]) sb.append(bracketStr.charAt(i));
        }
        System.out.println(sb.toString());

//      2.
        System.out.println("TODO2");
        int[] heights =  {2,1,5,6,2,3};
        // 단조 증가 스택: 스택에 인덱스를 저장
//        현재 높이가 스택 top 보다 작으면 pop하며 넓이 계산
        Stack<Integer> histStack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i <= heights.length; i++){
            int currHeight = (i == heights.length) ? 0 : heights[i];
            while (!histStack.isEmpty() && currHeight < heights[histStack.peek()]){
                int h = heights[histStack.pop()];
                // 너비 : 스택이 비어 있으면 왼쪽 경계는 -1
                int w = histStack.isEmpty()? i : i-histStack.peek() -1;
                int area = h * w;
                if (area > maxArea) maxArea = area;
            }
            histStack.push(i);
        }
        System.out.println("가장 큰 직사각형 넓이: " +maxArea);

//        3.
        int[] temps = {73,74,75,71,69,72,76,73};
//        며칠 뒤에 따뜻해지는 담을 배열
        int[] waitDays = new int[temps.length];
//        스택에 인덱스를 저장 (아직 더 따뜻한 날을 못 찾은 날의 인덱스)
        Stack<Integer> tempStack = new Stack<>();
        for (int i =0; i < temps.length; i++){
//            현재 온도가 스택 Top의 온도보다 높으면 pop차이 기록
            while (!tempStack.isEmpty() && temps[i] > temps[tempStack.peek()]) {
                int prevIdx = tempStack.pop();
                waitDays[prevIdx] = i - prevIdx;
            }
            tempStack.push(i);
        }
//        스택에 남은 것들은 이후 더 따뜻한 날이 없음 (waitDays[i] = 0 기본값)
        System.out.println("결과: "+ java.util.Arrays.toString(waitDays));








    }
//    괄호 검사 메서드
    static boolean isValidBracket(String s){
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // 여는 괄호 : 스택에 push
            if (c == '(' || c == '[' || c=='{'){
                stack.push(c);
            }

            // 닫는 괄호 : 스택에서 pop 후 짝 확인
            else if (c == ')' || c == ']' || c== '}'){
                if (stack.isEmpty()) return false; // 닫는 괄호가 더 많음

                char top = stack.pop();
                // 짝이 맞는지 확인
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;

            }
        }
        // 스택이 비어있으면 모든 괄호가 짝을 맞춘 것
        return stack.isEmpty();
    }

//    후위 표기식 계산 메서드
    static int evaluatePostfix(String[] tokens){
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens){
            if (token.equals("+") || token.equals("-")
                    || token.equals("*") || token.equals("/")) {
                // 연산자: 두 연산자를 pop
                int b = stack.pop() ; // 두 번째 피연산자
                int a = stack.pop(); // 첫 번째 피연산자
                int result = switch (token){
                    case "+" -> a + b;
                    case "-" -> a - b;
                    case "*" -> a * b;
                    case "/" -> a / b;
                    default -> 0;
                };
                stack.push(result);
            } else {
                // 숫자 : 스택에 push
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();

    }















}
