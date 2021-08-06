//연결리스트를 활용한 스택은 연결리스트에 스택의 top을 도입한 느낌이다...
#include <stdio.h>
#include <stdlib.h>
#define INF 99999999

typedef struct{
    int data;
    struct Node *next;
} Node;
typedef struct{
    Node* top; //최상단 위치
}Stack; //최상단 노드가 계속 stack->top을 가리키게 하면된다.

void push(Stack *stack, int data){
    Node *node = (Node*) malloc(sizeof(Node));
    node->data = data;
    node->next = stack->top;
    stack->top = node;
}
int pop(Stack *stack){
    if(stack->top==NULL){
        printf("stack underflow occurs...");
        return -INF;
    }
    Node *node = stack->top;
    stack->top = node->next;
    int data = node->data;
    free(node);
    return data;
}
void show(Stack *stack){
    Node* cur = stack->top;
    while(cur!=NULL){
        printf("%d\n", cur->data);
        cur=cur->next;
    }
}
int main(void){
    Stack s;
    s.top = NULL;
    push(&s, 1);
    push(&s, 2);
    push(&s, 4);
    pop(&s);
    show(&s);
    return 0;

}
