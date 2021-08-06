//뒤쪽으로 들어가서 앞쪽으로 나오는 자료구조.
//스케줄링, 탐색 알고리즘에 사용.
#include <stdio.h>
#define SIZE 1000
#define INF 99999999

int queue[SIZE];
int front =0;//맨 앞 인덱스
int rear = 0;//맨 뒤 인덱스

void push(int data){
    if (rear>=SIZE){
        printf("queue overflow occurs");
        return;
    }
    queue[rear++]=data;
}
int pop() {
    if (front == rear){
        printf("queue underflow occurs");
        return -INF;
    }
    return queue[front++];
}
void show(){
    for (int i = front ; i<rear;i++){
        printf("%d\n", queue[i]);
    }
}
int main(void){
    push(7);
    push(6);
    push(3);
    push(1);
    pop();
    show();
    return 0;
}