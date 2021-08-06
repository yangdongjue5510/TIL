---
title: 6.Median of Medians 알고리즘
date: 2021-07-28 19:42:57
tags:
category:
    - Computer Science
    - Algorithm
---
# MoM(Median of Medians) 알고리즘

퀵셀렉트는 세가지 영역으로 나누는데, 피벗보다 큰 쪽으로 너무 몰리면 수행시간이 길어졌었다.

##### MoM 알고리즘은 피벗을 적절하게 고르는 알고리즘이다.

피벗보다 작은 값의 집합 A, 피벗보다 큰 집합 B 둘 다 n/c보다 작도록 피벗을 설정하는 것이다!!

이런 과정으로 피벗을 고른다고 하면, 재귀 과정에서 집합의 크기가
n->n/c->n/c^2->n/c^3....->n/c^k=1. 총 logcn 번 하게 된다.

하지만 이런 과정에는 피벗을 설정하는 연산이 필요하다.
피벗 고르는데 필요햔 연산을 p라고 하고, 이 연산은 재귀를 거쳐도 동일하게 계산된다.

피벗과 다른 수들과 비교하는 횟수가 필요하게 된다.
이 횟수는 재귀를 거치면서
n->n/c->n/c^2....이렇게 된다.

결국 p+n + p+n/c + p+n/c^2 .....=logcn*(p+n)이다.

##### 결국 O(nlogn)이다.

###  MoM(L, k):
1. 5개씩 그룹화
2. 각 국릅의 중간값(median) 구하기. 5개에서 중간값 구하는 연산은 6번 비교해야하므로, n/5*6 비교해야 된다.
3. 중간 값을 한 집합에 모아 medians라고 하자.
4. m* = MoM(medians, len(medians)/2). 이때 T(n/5) 연산 소요
5. m*를 pivot으로 삼아 전체 집합을 A,pivot,B로 나눈다. 이때 n번 비교
6. pivot을 기준으로 내가 찾고자하는 값이 A에 있으면 MoM(A,k), B에 있으면 MoM(B,k) 아니면 return m*한다.
7. 이때 재귀호출에 따라 T(A) or T(B)만큼 연산하는데, A와 B모두 원소 갯수가 n/c보다 작기 때문에 둘 다 최대 소요 시간은 T(n/c)이 된다.
8. 결국 T(n) = 6/5*n + T(n/5) + n + T(n/c)
9. 이때 c를 4/3이라고 하면(이 부분은 다소 난해)
10. 점화식은 T(n) = T(3*n/4)+T(n/5)+11\*n/5가 된다. (휴..)
