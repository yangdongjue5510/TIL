### 9강 정렬 - ORDER BY

```mysql
SELECT 열명 FROM 테이블명 WHERE 조건식 ORDER BY 열명
SELECT 열명 FROM 테이블명 ORDER BY 열명
```

SELECT로 선택된 데이터를 ORDER BY로 정렬한다.

#### DESC, ASC

```mysql
SELECT 열명 FROM 테이블명 WHERE 조건식 ORDER BY 열명 DESC
SELECT 열명 FROM 테이블명 WHERE 조건식 ORDER BY 열명 ASC
```

**DESC**로 **내림차**, **ASC**로 **오름차로** 정렬할 수 있다.
기본값은 ASC 오름차 정렬이다.

#### 대소 관계

날짜는 **옛날 일 수록 작**다고 판별, 최신일수록 크다고 판별.
문자열은 사전식 순서에 따라 대소 관계를 판별.

이때 중요한 점은 문자열에 숫자를 저장할 경우, 숫자로 판별하지 않는다.사전식 순서에 따라 정렬한다.
**1, 2, 10, 11 이 있을 때 숫자식 판별은 1, 2, 10, 11 이지만 사전식 순서는 1, 10, 11, 2이다.**



### 10장 복수의 열을 지정해 정렬하기

```mysql
SELECT 열명 FROM 테이블명 WHERE 조건식 ORDER BY 열명1 [ASC/DESC], 열명2 [ASC/DESC]...
```

이렇게 하면 열명1을 먼저 정렬하고 그 다음 열명2를 정렬한다.

#### NULL 값의 정렬 순서

null은 상태이다. 따라서 대소를 판별할 수 없어서 별도로 취급한다.
ORDER BY로 정렬하면 NULL은 가장 먼저 표시되거나 가장 나중에 표시된다.

MySQL은 NULL을 가장 작은 값으로 취급한다.



### 11장 결과 행 제한하기 - LIMIT

```mysql
SELECT 열명 FROM 테이블명 LIMIT 행수 [OFFSET 시작행];
```

표준 SQL은 아니다. mysql과 postgresql에서만 사용한다.
select로 조회한 결과 갯수를 제한할 수 있다.

#### 정렬한 후 제한하기 (WHERE와 차이)

```mysql
SELECT * FROM sample33 ORDER BY no DESC LIMIT 3;
SELECT * FROM sample33 where no <= 3 ORDER BY no DESC;
```

sample33에 no 행에 1부터 7까지 있다고 하자.
위 두 식은 전혀 다른 값을 보여준다.

**LIMIT은 정렬을 모두 마친 다음에 결과를 제한 하는 것이고,**
**WHERE은 정렬하기 전에 조건식을 수행한다.**
그래서 첫번째식은 7, 6, 5를 출력하고 두번째 식은 3, 2, 1을 출력한다.

#### 다른 DB에서 비슷한 기능

SQL server

```sql
SELECT TOP 3 * FROM sample33;
```

Oracle ROWNUM (where절을 써서 정렬과 함께 사용할 경우 다른 결과를 보임.)

```sql
SELECT * FROM sample33 WHERE ROWNUM <= 3;
```

#### OFFSET 지정

흔히 페이징할 때 LIMIT을 사용하는데 OFFSET은 어디부터 제한을 시작할지를 나타낸다.
이때 재밌는건 **OFFSET은 인덱스 값을 통해 나타내므로, 순서 -1 한 값을 넣어줘야 한다.**

```mysql
SELECT * FROM sample33 LIMIT 3 OFFSET 3;
```

이런 식이면 4번째 부터 세개의 행을 출력한다.



### 12강 수치 연산

```mysql
+ - * / % MOD
```

다음 6가지가 SQL에서 제공하는 연산이다.

```mysql
mysql> select *, price * quantity from sample34;
+------+-------+----------+------------------+
| no   | price | quantity | price * quantity |
+------+-------+----------+------------------+
|    1 |   100 |       10 |             1000 |
|    2 |   230 |       24 |             5520 |
|    3 |  1980 |        1 |             1980 |
+------+-------+----------+------------------+
```

이런 식으로 select할 때 열을 연산으로 추가할 수 있다.

#### 열의 별명(alias) - AS

```mysql
mysql> select *, price * quantity as amount from sample34;
+------+-------+----------+--------+
| no   | price | quantity | amount |
+------+-------+----------+--------+
|    1 |   100 |       10 |   1000 |
|    2 |   230 |       24 |   5520 |
|    3 |  1980 |        1 |   1980 |
+------+-------+----------+--------+
```

as를 사용하면 임시 이름을 정해줄 수 있다.(as를 생략할 수도 있다.)
별명을 한글로 하려면 "별명" 쌍따옴표로 묶어라.**(이름에 ASCII 문자 이외의 것 포함하면 반드시 쌍따옴표)**
또한 숫자로 시작하지 않도록 한다.

#### WHERE 구에서 연산하기

```mysql
mysql> select *, price * quantity as amount from sample34 
where price * quantity >= 2000;
+------+-------+----------+--------+
| no   | price | quantity | amount |
+------+-------+----------+--------+
|    2 |   230 |       24 |   5520 |
+------+-------+----------+--------+
```

참 쉽죠? 근데 다음 식은 에러가 발생한다.

```mysql
select *, price * quantity as amount from sample34 
where amount >= 2000;
```

이 식이 에러가 나는 이유는 SQL 내부 서버가 **WHERE 구  ->  SELECT 구 순서로 실행하기 때문**이다.
SELECT에서 선언한 별명을 WHERE에서는 사용할 수 없다.

#### NULL 연산

NULL + 1은 1일까? 데이터베이스에서는 아니다!
NULL에 아무리 연산해도 NULL이다.

#### ORDER BY 구에서 연산하기

```mysql
mysql> select *, price * quantity as amount from sample34 order by price * quantity;
+------+-------+----------+--------+
| no   | price | quantity | amount |
+------+-------+----------+--------+
|    1 |   100 |       10 |   1000 |
|    3 |  1980 |        1 |   1980 |
|    2 |   230 |       24 |   5520 |
+------+-------+----------+--------+

mysql> select *, price * quantity as amount from sample34 order by amount;
+------+-------+----------+--------+
| no   | price | quantity | amount |
+------+-------+----------+--------+
|    1 |   100 |       10 |   1000 |
|    3 |  1980 |        1 |   1980 |
|    2 |   230 |       24 |   5520 |
+------+-------+----------+--------+
```

여기서 주목할 점은 ORDER BY 구에서 별명을 사용했다는 점이다.
**WHERE - SELECT - ORDER BY 순으로 진행되기 때문에 ORDER BY는 SELECT의 별명을 사용할 수 있다.**

#### 함수

```mysql
함수명(인수1, 인수2, ...)
```

sql에선 이런 형태로 만들어진 함수가 있다. 대표적으로 MOD는 나머지를 구하는 함수다.

```mysql
10 % 3 -> 1
MOD(10, 3) -> 1
```

#### ROUND 함수

```mysql
mysql> select * from sample341;
+---------+
| amount  |
+---------+
| 5961.60 |
| 2138.40 |
| 1080.00 |
+---------+

mysql> select amount, ROUND(amount)  from sample341;
+---------+---------------+
| amount  | ROUND(amount) |
+---------+---------------+
| 5961.60 |          5962 |
| 2138.40 |          2138 |
| 1080.00 |          1080 |
+---------+---------------+
```

ROUND함수는 해당 수를 반올림하다. 이때 하나의 인수만 주어지면 소수점 첫째 자리에서 반올림한다.

##### ROUND 함수 반올림 위치 지정

```mysql
mysql> select amount, round(amount, 1) from sample341;
+---------+------------------+
| amount  | round(amount, 1) |
+---------+------------------+
| 5961.60 |           5961.6 |
| 2138.40 |           2138.4 |
| 1080.00 |           1080.0 |
+---------+------------------+

mysql> select amount, round(amount, -2) from sample341;
+---------+-------------------+
| amount  | round(amount, -2) |
+---------+-------------------+
| 5961.60 |              6000 |
| 2138.40 |              2100 |
| 1080.00 |              1100 |
+---------+-------------------+
```

round함수는 두번째 인수로 반올림 위치를 지정한다.
0이 소수점 첫째 자리이고, 커질 수록 소수점 자리로 가고, 작아질 수록 정수로 간다.

### 13강 문자열 연산

```mysql
+ || CONCAT SUBSTRING TRIM CHARACTER_LENGTH
```

다음 6가지가 문자열 연산이다.

#### 문자열 결합

문자열 결합은 **+, ||, CONCAT**이 사용된다.
각 DBMS마다 다른데, MySQL은 CONCAT을 사용한다.

```mysql
mysql> select * from sample35;
+------+-------+----------+------+
| no   | price | quantity | unit |
+------+-------+----------+------+
|    1 |   100 |       10 | 개   |
|    2 |   230 |       24 | 통   |
|    3 |  1980 |        1 | 장   |
+------+-------+----------+------+

mysql> select concat(quantity, unit) from sample35;
+------------------------+
| concat(quantity, unit) |
+------------------------+
| 10개                   |
| 24통                   |
| 1장                    |
+------------------------+
```

#### SUBSTRING 함수

```mysql
SUBSTRING('20140125001', 1, 4) -> '2014'
SUBSTRING('20140125001', 5, 2) -> '01'
```

어떤 문자열을 어디부터 몇개를 가져올 것인지 나타내는 함수.

#### TRIM 함수

```mysql
TRIM(' AB C ') -> 'AB C'
```

#### CHARACTER_LENGTH 함수

```mysql
mysql> select *, CHAR_LENGTH(unit) from sample35;
+------+-------+----------+------+-------------------+
| no   | price | quantity | unit | CHAR_LENGTH(unit) |
+------+-------+----------+------+-------------------+
|    1 |   100 |       10 | 개   |                 1 |
|    2 |   230 |       24 | 통   |                 1 |
|    3 |  1980 |        1 | 장   |                 1 |
+------+-------+----------+------+-------------------+
```

문자열의 길이를 측정하는 함수. CHAR_LENGTH로 축약해서 사용해도 된다.

다만 OCTET_LENGTH라는 함수는 해당 데이터가 차지하는 바이트 수를 보여준다.

```mysql
mysql> select *, OCTET_LENGTH(QUANTITY), OCTET_LENGTH(UNIT) from sample35;
+------+-------+----------+------+------------------------+--------------------+
| no   | price | quantity | unit | OCTET_LENGTH(QUANTITY) | OCTET_LENGTH(UNIT) |
+------+-------+----------+------+------------------------+--------------------+
|    1 |   100 |       10 | 개   |                      2 |                  3 |
|    2 |   230 |       24 | 통   |                      2 |                  3 |
|    3 |  1980 |        1 | 장   |                      1 |                  3 |
+------+-------+----------+------+------------------------+--------------------+
```

이는 반드시 글자 갯수와 일치하지 않으며, 데이터 인코딩에 따라 달라진다.
ASCII나 EUC-KR, UTF-8로 저장되는 문자세트에 따라 한 문자에 사용되는 바이트 량이 달라진다.

### 14강 날짜 연산

```mysql
CURRENT_TIMESTAMP CURRENT_DATE INTERVAL
```

위 세가지가 날짜 연산에 쓰이는 것들이다.

#### 현재 날짜, 시간 얻기

```mysql
mysql> select CURRENT_TIMESTAMP;
+---------------------+
| CURRENT_TIMESTAMP   |
+---------------------+
| 2021-12-29 14:57:09 |
+---------------------+

mysql> select CURRENT_DATE;
+--------------+
| CURRENT_DATE |
+--------------+
| 2021-12-29   |
+--------------+
```

#### 날짜의 덧셈 뺄셈

날짜 시간형 데이터에서 덧셈 뺄셈은 기간형 데이터를 통해 이뤄진다.
이 기간형 데이터를 INTERVAL이다.

```mysql
mysql> SELECT CURRENT_DATE + INTERVAL 1 DAY;
+-------------------------------+
| CURRENT_DATE + INTERVAL 1 DAY |
+-------------------------------+
| 2021-12-30                    |
+-------------------------------+

mysql> SELECT CURRENT_DATE - INTERVAL 1 DAY;
+-------------------------------+
| CURRENT_DATE - INTERVAL 1 DAY |
+-------------------------------+
| 2021-12-28                    |
+-------------------------------+
```

#### 날짜 끼리 뺄셈

```mysql
select DATEDIFF('2021-01-01', '2020-01-01');
+--------------------------------------+
| DATEDIFF('2021-01-01', '2020-01-01') |
+--------------------------------------+
|                                  366 |
+--------------------------------------+
```

DATEDIFF함수는 두 날짜의 차이를 구한다.(오라클에선 뺄셈 기호로 한다.)

### 15강 CASE 문으로 데이터 변환하기

```mysql
CASE WHEN 조건식1 THEN 식1
	[WHEN 조건식2 THEN 식2 ...]
	[ELSE 식3]
END	
```

if 문과 비슷한 역할을 하는 CASE 문이다.

```mysql
mysql> select a from sample37;
+------+
| a    |
+------+
|    1 |
|    2 |
| NULL |
+------+

mysql> SELECT a, CASE WHEN a is NULL THEN 0 ELSE a END "a(null=0)" FROM sample37;
+------+-----------+
| a    | a(null=0) |
+------+-----------+
|    1 |         1 |
|    2 |         2 |
| NULL |         0 |
+------+-----------+
```

이런 식으로 CASE를 사용하면 NULL을 0으로 치환할 수 있다.
하지만 이런 식으로 NULL을 치환하기보다 COALESCE를 사용하는게 낫다.

```mysql
mysql> select a, COALESCE(a, 0) from sample37;
+------+----------------+
| a    | COALESCE(a, 0) |
+------+----------------+
|    1 |              1 |
|    2 |              2 |
| NULL |              0 |
+------+----------------+
```

#### 또 하나의 CASE문

```mysql
mysql> SELECT a AS "코드",
    -> CASE
    ->  WHEN a = 1 THEN '남자'
    ->  WHEN a = 2 THEN '여자'
    ->  ELSE '미지정'
    -> END AS "성별" FROM sample37;
+--------+-----------+
| 코드   | 성별      |
+--------+-----------+
|      1 | 남자      |
|      2 | 여자      |
|   NULL | 미지정    |
+--------+-----------+
```

여러 WHEN을 활용해 다음같이 사용할 수 있다.

#### CASE 주의사항

##### ELSE를 생략하면 ELSE인 경우에 NULL이 할당된다.

##### WHEN 조건에 NULL 지정하기

```mysql
mysql> SELECT a AS "코드",
    -> CASE
    ->  WHEN a = 1 THEN '남자'
    ->  WHEN a = 2 THEN '여자'
    ->  WHEN NULL THEN '데이터 없음'
    ->  ELSE '미지정'
    -> END AS "성별" FROM sample37;
+--------+-----------+
| 코드   | 성별      |
+--------+-----------+
|      1 | 남자      |
|      2 | 여자      |
|   NULL | 미지정    |
+--------+-----------+
```

위 같이 when 조건식에 null을 그냥 넣으면 인식이 제대로 안된다.
왜냐면 when은 해당 값이 같은지 (=) 를 검증하기 때문이다.

근데 null은 ? = null 이런식으로 검증할 수 없다. 그러므로 제대로 작동하지 않는 것.

차라리 a IS NULL 이라고 검증하는게 의도한대로 작동한다.