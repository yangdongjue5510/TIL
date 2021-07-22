//배열이므로, 인덱스로 즉시 접근 가능
//데이터가 들어가야할 공간 미리 메모리에 할당해야 함
//원하는 위치로 삽입 삭제 비효율
#include <stdio.h>
#define INF 10000

int arr[INF];
int count = 0;

void addBack(int data){
    arr[count] = data;
    count++;
}

void addFirst(int data){
    for(int i = count; i>=1; i--){
        arr[i] = arr[i-1];
    }
    arr[0] = data;
    count++;
}

void show() {
    for (int i=0; i<count; i++){
        printf("%d ", arr[i]);
    }
}

void removeAt(int n){
    for(int i=n; i<count-1;i++){
        arr[n]=arr[n+1];
    }
    return 0;
}
int main(void){
    addFirst(4);
    addFirst(5);
    addFirst(1);
    addBack(7);
    addBack(6);
    addBack(8);
    show();
    return 0;
}