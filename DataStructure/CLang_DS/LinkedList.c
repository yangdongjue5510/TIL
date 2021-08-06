//c에서 구조체와 포인터를 사용해 구현
//리스트 중간 지점에 노드를 추가하거나 삭제 가능해야 함
//필요할 때마다 메모리 공간 할당 받음
//시작 노드를 head, 끝 노드의 다음 위치는 null.
//데이터 삽입삭제가 많으면 불리
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int data;
    struct Node *next;
}Node;

Node *head;

void addFront(Node *root, int data){
    Node *node = (Node*) malloc(sizeof(Node));
    node->data = data;
    node->next = head->next;
    head->next = node;
}
void removeFront(Node *root){ //root 기준 다음 노드 제거
    Node *front = root->next;
    head->next = front->next;
    free(front);
}
void freeAll(Node *root){ //모든 원소 삭제.
    Node *cur = head->next;
    while(cur->next!=NULL){
        Node *next = cur->next;
        free(cur);
        cur = next;
    }
}
void showAll(Node *root){
    Node *cur = head->next;
    while(cur!=NULL){
        printf("%d ", cur->data);
        cur=cur->next;
    }
}

int main(void){
    head = (Node*)malloc(sizeof(Node));
    head-> next = NULL;
    addFront(head, 2);
    addFront(head, 1);
    addFront(head, 7);
    addFront(head, 9);
    showAll(head);
    return 0;
}