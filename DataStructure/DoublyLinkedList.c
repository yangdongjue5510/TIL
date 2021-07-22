//링크가 앞 뒤 둘다 있음
#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int data;
    struct Node *prev;
    struct Node *next;
} Node;
Node *head, *tail;

void insert(int data){//데이터가 오름차 정렬이라고 가정했을 경우 데이터값을 입력받아 알아서 올바른 자리에 삽입.
    Node* node=(Node*)malloc(sizeof(Node));
    node->data = data;
    Node* cur = head->next;
    while(cur->data <data && cur!=tail){
        cur=cur->next;
    }
    Node* prev = cur->prev;
    prev->next=node;
    node->prev=prev;
    node->next=cur;
    cur->prev=node;
}
void removeFront(){
    if(head->next==tail){
        return;
    }
    Node* node = head->next;
    head->next = node->next;
    Node* next = node->next;
    next->prev = head;
    free(node);
}
void show(){
    Node* cur = head->next;
    while(cur!=tail){
        printf("%d ", cur->data);
        cur = cur->next;
    }
}
int main(void){
    head = (Node*)malloc(sizeof(Node));
    tail = (Node*)malloc(sizeof(Node));
    head->next = tail;
    tail->prev = head;
    head->prev = head;
    tail->next = tail;
    insert(9);
    insert(1);
    insert(45);
    insert(3);
    removeFront();
    show();
    return 0;
}