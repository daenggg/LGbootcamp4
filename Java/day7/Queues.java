/*
* 큐
* 큐의 FIFO(First In First Out) 선입선출의 원리를 이해한다
* LinkedList 와 ArrayDeque 로 큐를 구현할 수 있다
* offer , poll, peek를 활용할 수 있다
* 큐를 이용한 BFS 기초를 이해한다
* */


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    static void main(String[] args) {
        /*
        * 큐(queue)란?
        * 큐는  ' 줄 서기 '와 같은 자료구조입니다
        * 버스 정류장에서 줄을 설 때:
        * 먼저 줄 선 사람이 먼저 탑니다.
        *
        * 이런 원리를 선입선출 이라고 합니다.
        * 먼저 들어온 것이 먼저 나간다
        *
        * 스택 vs 큐
        * 스택 : 접시 쌓기 -> 위에서 넣고 위에서 꺼냄
        * 큐 : 줄 서기 -> 뒤에서 넣고 앞에서 꺼냄
        *
        * 큐 연산:
        * offer(요소) : 큐의 뒤(rear) 에 요소 추가
        *               (add()도 같지만, offer는 실패시 false 반환, add는 예외 발생)
        * poll()     : 큐의 앞(front)에서 요소를 꺼내고 반환 (비어있으면 null 반환)
        *               (remove()도 같지만, poll는 false 반환 remove 예와 반환)
        * peek() : 큐의 앞 요소를 확인함 (꺼내지 않음, 비어있으면 null반환)
        * isEmpty() : 큐가 비어있으면 true
        * size() : 큐에 있는 요소 수
        *
        * 실생할 예
        * - 프린터 대기열 : 먼저 요청한 것부터 출력
        * - 고객 서비스 대기 : 먼저 전화한 고객부터 연결
        * - BFS(너비 우선 탐색) : 가까운 곳부터 탐색
        * */

//        import java.util.Queue; 와 import java.util.LinkedList; 가 필요하다
        Queue<String> queue = new LinkedList<>();

//      offer() - 큐의 뒤에 요소 추가
        queue.offer("고객1");
        System.out.println("offer 고객1 -> 큐: "+queue);
        queue.offer("고객2");
        System.out.println("offer 고객2 -> 큐: "+queue);
        queue.offer("고객3");
        System.out.println("offer 고객3 -> 큐: "+queue);
        queue.offer("고객4");
        System.out.println("offer 고객4 -> 큐: "+queue);
//        왼쪽이 front(앞) , 오른쪽이 rear(뒤)

//        peek() - 앞 요소 확인 (꺼내지 않음)
        String front = queue.peek();
        System.out.println(front);
        System.out.println(queue);

//        poll() - 앞 요소 꺼내지
        String served = queue.poll();
        System.out.println(served);
        System.out.println(queue);

//        isEmpty() , size()
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());

//        모두 꺼내기
        while (!queue.isEmpty()) {
            System.out.println("처리: "+ queue.poll());
        }
        System.out.println("모두 처리 후 비어 있는가? " + queue.isEmpty());

//        ArrayDeque로 큐 사용 (권장)
        /*
        * ArrayDeque는 LinkedList 보다 큐로 쓸 때 더 빠릅니다.
        * Queue 인터페이스 또는 Deque 인터페이스로 선언할 수 있습니다.
        *
        * Deque(양방향 큐)로 쓸 때 메서드:
        * offerLast(e) = offer(e) = addLast(e) : 뒤에 추가
        * pollFirst() = poll() = removeFirst() : 앞에서 꺼냄
        * peekFirst() = peek() = getFirst() : 앞 확인
        * */

        Queue<Integer> fastQueue =new ArrayDeque<>();
        fastQueue.offer(100);
        fastQueue.offer(200);
        fastQueue.offer(300);
        System.out.println(fastQueue);
        System.out.println(fastQueue.peek());
        System.out.println(fastQueue.poll());
        System.out.println(fastQueue);

//        프린터 대기열: 먼저 요청한 문서부터 인쇄
        Queue<String> printer = new ArrayDeque<>();
        printer.offer("보고서.pdf");
        printer.offer("사진.jpg");
        printer.offer("이력서.docx");
        printer.offer("청구서.xlsx");

        System.out.println("인쇄 대기열: "+ printer);

        int order = 1;
        while (!printer.isEmpty()) {
            String doc = printer.poll();
            System.out.println(order++ + "번째 인쇄: " + doc);
        }

//        큐의 활용 - BFS (너비 우선 탐색) 기초
        /*
        * BFS(Breadth-First Search, 너비 우선 탐색)란?
        * 그래프나 트리를 탐색하는 방법 중 하나입니다.
        * 시작 노드에서 가까운 노드부터 차례로 방문합니다.
        * ex 아래와 같은 예시
        *
        *          1 (시작 노드)
        *        /   \
        *        2    3
        *      /    \   \
        *     4     5    6
        * BFS 순서 : 1 -> 2 -> 3 -> 4 -> 5 -> 레벨별로 방문
        *
        * BFS 알고리즘 :
        * 1. 시작 노드를 큐에 넣고, 방문 표시
        * 2. 큐에서 노드를 꺼내서 방문
        * 3. 꺼낸 노드의 인접 노드 중 방문하지 않은 것을 큐에 추가
        * 4. 큐가 빌 때까지 반복
        * */

//        그래프를 인접 리스트로 표현 (7개 노드 , 0번은 사용 안 함)
//        graph[i] = 노드 i와 연결된 노드 목록
        LinkedList<Integer>[] graph = new LinkedList[7];
        for (int i = 0 ; i < 7 ; i++){
            graph[i] = new LinkedList<>();
        }
//        간선 추가 (양방향)
//        1-2 , 1-3 ,2-4,2-5 ,3-6
        addEdge(graph, 1,2);
        addEdge(graph, 1,3);
        addEdge(graph, 2,4);
        addEdge(graph, 2,5);
        addEdge(graph, 3,6);

        System.out.println("그래프 구조");
        for (int i = 1; i <= 6; i++){
            System.out.println(" "+i+" -> "+ graph[i]);
        }

        System.out.println("BFS 탐색 시작: 시작노드는 1");
        bfs(graph, 1, 6);

        //       미로 탈출 BFS
//        미로 : 0 - 길 , 1 - 벽, S = 시작 , E = 끝
//        BFS로 최단 경로 길이를 구해보자
        int[][] maze = {
                {0,0,1,0,0},
                {1,0,1,0,1},
                {0,0,0,0,0},
                {0,1,1,1,0},
                {0,0,0,0,0},
        };

        System.out.println("미로 최단거리 구하기");
        int steps = mazeBFS(maze, 0,0,4,4);
        System.out.println("0,0에서 출발하여 4,4까지의 최단 거리 : "+steps+"칸");




    }
// 그래프 간선 추가 (양방향)
    static void addEdge(LinkedList<Integer>[] graph, int u , int v){
        graph[u].add(v);
        graph[v].add(u);
    }

//    BFS 구현
    static void bfs(LinkedList<Integer>[] graph , int start, int nodeCount){
        boolean[] visited = new boolean[nodeCount + 1 ]; // 방문 여부
        Queue<Integer> queue = new ArrayDeque<>();

       // 시작 노드 처리
       visited[start] = true;
       queue.offer(start);

       while (!queue.isEmpty()) {
           int node = queue.poll(); //큐에서 노드 꺼냄
           System.out.print(node+ " ");

           // 인접 노드 방문
           for (int neighbor : graph[node]){
               if (!visited[neighbor]){
                   visited[neighbor] = true;
                   queue.offer(neighbor); //미방문 노드를 큐에 추가
               }
           }
       }
        System.out.println();
    }

//    미로 BFS - 최단 거리 계산
    static int mazeBFS(int[][] maze, int startR, int startC, int endR, int endC){
        int rows = maze.length;
        int cols = maze[0].length;
        boolean[][] visited = new boolean[rows][cols];

//        상하좌우 이동 방향
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

//        큐에 [행, 열, 거리] 저장
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startR,startC,0});
        visited[startR][startC] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], dist = cur[2];

            if (r == endR && c == endC){
                return dist; //목적지 도달!
            }

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                // 범위 내, 길(0), 미방문인 경우만 추가
                if (nr >= 0 && nr < rows && nc >=0 && nc < cols
                    && maze[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc,dist+1});
                }
            }
        }
        return -1; // 도달 불가

    }









}
