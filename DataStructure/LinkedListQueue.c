#include <stdio.h>
#include <stdlib.h>
#define INF 99999999

typedef struct {
    int data;
    struct Node *next;
}Node;
typedef struct{
    Node *front;//첫노드를 가르키는 포인터
    Node *rear;//마지막 노드를 가르키는 포인터
    int count;
} Queue;
void push(Queue *queue, int data){
    Node *node = (Node*)malloc(sizeof(Node));
    node->data = data;
    node->next = NULL;
    if(queue->count == 0){
        queue->front = node;
    }
    else{
        queue->rear->next = node;
    }
    queue->rear = node;
    queue -> count++;
}

int pop(Queue *queue){
    if(queue->count==0){
        printf("queue underflow occurs");
        return -INF;
    }
    Node* node = queue->front;
    queue->front=node->next;
    int data = node->data;
    free(node);
    queue->count--;
    return data;
}
void show(Queue* queue){
    Node* cur = queue->front;
    while(cur!=NULL){
        printf("%d\n", cur->data);
        cur = cur->next;
    }
}
int main(void){
    Queue queue;
    queue.front = queue.rear = NULL;
    queue.count=0;
    push(&queue, 7);
    push(&queue, 4);
    push(&queue, 1);
    pop(&queue);
    show(&queue);
    return 0;
}