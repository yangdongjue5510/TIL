### 집계 함수

```mysql
COUNT(집합) SUM(집합) AVG(집합) MIN(집합) MAX(집합)
```

집계함수는 여러 개의 값에서 하나의 값으로 계산하는 **함수**이다.
만약 SELECT 구에서 집계함수를 사용하면 **하나의 값으로 반환**된다.

```mysql
mysql> select count(*) from sample51 where name = 'A';
+----------+
| count(*) |
+----------+
|        2 |
+----------+
```

위 코드는 WHERE 절에서 검색 -> COUNT함수로 집계 -> SELECT 절 실행 순으로 진행됐다.

#### 집계함수와 NULL

```mysql
mysql> select * from sample51;
+------+------+----------+
| no   | name | quantity |
+------+------+----------+
|    1 | A    |        1 |
|    2 | A    |        2 |
|    3 | B    |       10 |
|    4 | C    |        3 |
|    5 | NULL |     NULL |
+------+------+----------+

mysql> select count(no), count(name) from sample51;
+-----------+-------------+
| count(no) | count(name) |
+-----------+-------------+
|         5 |           4 |
+-----------+-------------+
```

집계함수는 NULL인 행을 계산하지 않는다.

#### 집계함수와 DISTINCT & ALL

```mysql
mysql> select * from sample51;
+------+------+----------+
| no   | name | quantity |
+------+------+----------+
|    1 | A    |        1 |
|    2 | A    |        2 |
|    3 | B    |       10 |
|    4 | C    |        3 |
|    5 | NULL |     NULL |
+------+------+----------+

mysql> select count(distinct name), count(all name) from sample51;
+----------------------+-----------------+
| count(distinct name) | count(all name) |
+----------------------+-----------------+
|                    3 |               4 |
+----------------------+-----------------+
```

Distinct, all 둘다 null은 포함하지 않는다.
distinct는 중복된 데이터가 여러번 계산되지 않는다.

### 20강 행 갯수 구하기 - COUNT

#### COUNT의 특징

COUNT는 인수로 열명을 지정할 수 있다.
COUNT는 유일하게 *를 인수로 가질 수 있다.

### 21강 COUNT 이외 집계함수

```mysql
SUM([ALL|DISTINCT] 집합)
AVG([ALL|DISTINCT] 집합)
MIN([ALL|DISTINCT] 집합)
MAX([ALL|DISTINCT] 집합)
```

SUM은 집합의 데이터 값의 합.
AVG는 집합의 데이터 값의 평균.
MIN은 집합의 데이터 값의 최저치.
MAX는 집합의 데이터 값의 최고치.

### 22강 그룹화 - GROUP BY

