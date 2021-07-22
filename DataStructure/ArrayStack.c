//한쪽으로 들어가서 한쪽으로 나오는 자료구조.
//수식 계산 등에서 이용.
//배열을 이용한 스택.
//미리 공간을 잡아놔야되서 비효율적.
#include <stdio.h>
#define SIZE 10000
#define INF 99999999

int stack[SIZE];//배열로 스택구현
int top = -1; //가장 최근에 들어간 값의 인덱스
void push(int data){
    if( top == SIZE-1){
        printf("stack overflow happens.");
        return;
    }
    stack[++top]=data;
}
int pop(){
    if(top==-1){
        printf("stack underflow happens.");
        return -INF;
    }
    return stack[top--];
}
void show(){
    for (int i=top; i>=0; i--){
        printf("%d\n", stack[i]);
    }
}
int main(){
    push(1);
    push(4);
    push(7);
    push(8);
    pop();
    show();
}