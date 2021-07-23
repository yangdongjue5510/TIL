//선택 정렬은 가장 작은 것을 선택해 앞으로 보내는 정렬기법.
//가장 작은 것 선택에 N번, 앞으로 보내는데 N번 연산하므로 O(N^2)의 시간 복잡도 가짐
#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <limits.h>
#define SIZE 1000

int a[SIZE];
int swap(int *a, int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}