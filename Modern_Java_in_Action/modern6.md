---
title: 스트림으로 데이터 수집
date: 2021-07-30 09:49:07
tags:
category:
    - Java
    - Modern Java in Action
---
## 컬렉터란 무엇인가?
일단 예시를 하나 보자.
```java
//통화별로 트랜잭션을 그룹화한 코드(명령형 버전)
Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>();
for (Transaction transaction : transactions){
    Currency currency = transaction.getCurrency();
    List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
    if (transactionsForCurrency == null){
        transactionsForCurrency = new ArrayList<>();
        transactionsByCurrencies.put(currency, transactionForCurrency);
    }
    transactionsForCurrency.add(transaction);
}

//함수형 버전
Map<Currency, List<Transaction>> transactionsByCurrencies = 
        transactions.stream().collect(groupingby(Transaction::getCurrency));
```

딱봐도 함수형 프로그래밍이 훨씬 쉽다.
위 예제에서 collect 메서드로 Collector 인터페이스 구현을 전달했다.
**Collector 인터페이스 구현은 스트림의 요소를 어떤 식으로 도출할지 지정한다.**

> 컬렉터는 고급 리듀싱 기능을 수행한다.

스트림에 collect를 호출하면, 스트림의 요소에 (컬렉터로 파라미터화된) 리듀싱 연산이 수행된다.
collect에서는 리듀싱 연산을 이용해서 스트림의 각 요소를 방문하면서 컬렉터가 작업을 처리한다.
![](/img/modern/6-1.jpeg)

## 미리 정의된 컬렉터

Collectors 클래스에서 미리 정의된 팩터리 메서드의 기능은 크게 세가지로 분류된다.
- 스트림 요소를 하나의 값으로 리듀스하고 요약.
- 요소 그룹화
- 요소 분할

이 세가지에 대해 더 알아보자.

### 리듀싱과 요약

컬렉터로 스트림의 모든 항목을 하나의 결과로 합칠 수 있었다.
하나의 결과란 복잡한 다수준 그룹화 맵 일 수도, 그냥 평범한 정수 형태 일 수도 있다.

counting()이란 팩토리 메서드가 반환하는 컬렉터로 메뉴에서 요리 수를 계산해보자
```java
long howManyDishes = menu.stream().collect(Collectors.counting());
//불필요한 과정을 제외하면,
long howManyDishes = menu.stream().count()
```
#### 요약 연산

스트림에 있는 객체의 숫자 필드의 합계나 평균 등을 반환하는 연산을 **요약 연산**이라 부른다.
물론 요약 연산에도 리듀싱 기능이 자주 사용된다.

Collectors 클래스는 Collectors.summingInt라는 요약 팩토리 메서드를 제공한다.
summingInt 인수로 전달된 함수는 객체를 int로 매핑하는 함수를 인수로 받는다.
int로 매핑한 컬렉터를 collet 메서드에 전달되면, 요약 작업을 수행한다.

```java
int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
```


