from collections import deque
import sys

def bfs(grid, N, M):
    # 방문 여부를 저장: visited[x][y][b]는 (x,y)에 도달했을 때 b(0:벽을 아직 안 부숨, 1:부순 상태) 여부
    visited = [[[False]*2 for _ in range(M)] for _ in range(N)]
    # 시작점: (0,0)에서 시작, 아직 벽은 부수지 않음 (b = 0), 시작 칸까지 거리 1
    queue = deque([(0, 0, 0, 1)])
    visited[0][0][0] = True
    
    # 상하좌우 이동을 위한 델타
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    while queue:
        x, y, broken, dist = queue.popleft()
        # 도착점에 도달하면 거리 반환
        if x == N-1 and y == M-1:
            return dist
        
        # 4방향 탐색
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            # 범위 검사
            if 0 <= nx < N and 0 <= ny < M:
                # 이동 가능한 칸이고 아직 방문하지 않은 경우
                if grid[nx][ny] == 0 and not visited[nx][ny][broken]:
                    visited[nx][ny][broken] = True
                    queue.append((nx, ny, broken, dist+1))
                # 벽이 있는 칸인 경우, 아직 벽을 부수지 않은 상태라면
                elif grid[nx][ny] == 1 and broken == 0 and not visited[nx][ny][1]:
                    visited[nx][ny][1] = True
                    queue.append((nx, ny, 1, dist+1))
    # 도착점에 도달할 수 없는 경우
    return -1

if __name__ == "__main__":
    input = sys.stdin.readline
    N, M = map(int, input().split())
    grid = [list(map(int, list(input().strip()))) for _ in range(N)]
    result = bfs(grid, N, M)
    print(result)
