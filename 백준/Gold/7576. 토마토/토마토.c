#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#pragma warning(disable:4996)
#define MAX_VERTICES 1000*1001
int dx[4] = { -1,0,1,0 };
int dy[4] = { 0,-1,0,1 };
typedef struct Queue {
    int x[MAX_VERTICES];
    int y[MAX_VERTICES];
    int front;
    int rear;
} Queue;
void initializeQueue(Queue* q) {
    q->front = -1;
    q->rear = -1;
}
int isEmpty(Queue* q) {
    return q->front == -1;
}
void enqueue(Queue* q, int nx,int ny) {
    if (q->rear == MAX_VERTICES - 1)
        return;
    if (q->front == -1)
        q->front = 0;
    q->rear++;
    q->x[q->rear] = nx;
    q->y[q->rear] = ny;
}
void dequeue(Queue* q,int*a) {
    
    if (isEmpty(q))
        return ;
    int item = q->x[q->front];
    int item2 = q->y[q->front];
    if (q->front == q->rear) {
        q->front = q->rear = -1;
    }
    else {
        q->front++;
    }
    a[0] = item;
    a[1] = item2;    
}
int** x;
int** v;
int n, m;
Queue q;

void bfs();
int main() {
	scanf("%d %d", &m, &n);
	x = (int**)malloc(n * sizeof(int*));
	for (int i = 0; i < n; i++) {
		x[i] = (int*)malloc(m * sizeof(int));
	}

    initializeQueue(&q);
	for(int i=0;i<n;i++){
		for (int j = 0; j < m; j++) {
			scanf("%d", &x[i][j]);
            if (x[i][j] == 1)enqueue(&q, i, j);
		}
	}
    bfs();
   
    int max = 0;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (x[i][j] == 0) {
                printf("-1");
                return 0;
            }
            if (max < x[i][j])max = x[i][j];
        }
    }
    printf("%d", max - 1);
	return 0;
}
 void bfs() {
    while (!isEmpty(&q)) {
        int a[2];
        dequeue(&q, a);
        for (int k = 0; k < 4; k++) {
            int nx = a[0] + dx[k];
            int ny = a[1] + dy[k];
            if (nx < n && ny < m && nx >= 0 && ny >= 0 && x[nx][ny] == 0 ) {
              
                x[nx][ny] = x[a[0]][a[1]] + 1;
                enqueue(&q, nx, ny);

            }
        }
    }


}