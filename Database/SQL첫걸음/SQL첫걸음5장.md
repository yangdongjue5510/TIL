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

```mysql
SELECT * FROM 테이블명 GROUP BY 열1, 열2,...
```

Group by는 집계함수로 넘겨줄 집합을 그룹화 한다.

```mysql
SELECT name, COUNT(name), SUM(quantity) FROM sample51 GROUP BY name;
+------+-------------+---------------+
| name | COUNT(name) | SUM(quantity) |
+------+-------------+---------------+
| A    |           2 |             3 |
| B    |           1 |            10 |
| C    |           1 |             3 |
| NULL |           0 |          NULL |
+------+-------------+---------------+
```

위 같이, GROUP BY하면 집합을 그룹화한다. (주로 집계함수와 사용.)

#### HAVING 구

그룹화가 필요한 집계함수는 WHERE 절에서 사용될 수 없다.

```mysql
SELECT name, COUNT(name) FROM sample51 WHERE COUNT(name) = 1 GROUP BY name;
```

위 쿼리는 부적절하다.
WHERE 절은 GROUP BY보다 먼저 호출되서 그룹화가 필요한 집계함수는 사용할 수 없다.

> 내부 처리 순서

WHERE - GROUP BY - HAVING - SELECT - ORDER BY

대신 HAVING을 사용하면 된다.

```mysql
SELECT name, COUNT(name) FROM sample51 GROUP BY name;
+------+-------------+
| name | COUNT(name) |
+------+-------------+
| A    |           2 |
| B    |           1 |
| C    |           1 |
| NULL |           0 |
+------+-------------+
```

HAVING은 그룹화보다 늦게 수행되므로 그룹을 사용할 수 있지만, SELECT에서 주어진 별명은 사용할 수 없다.

#### 복수열의 그룹화

GROUP BY 로 특정 열을 그룹화 했을 때, 다른 열을 SELECT에 기술하면 안된다.

```mysql
SELECT no, name, quantity FROM sample51 GROUP BY name;
```

name을 기준으로 그룹화 했는데 다른 열(no, quantity)를 SELECT에 포함하면 안된다.

하지만 집계함수를 사용한 경우 가능하다.

```mysql
SELECT MIN(no), name, SUM(quantity) FROM sample51 GROUP BY name;
+---------+------+---------------+
| MIN(no) | name | SUM(quantity) |
+---------+------+---------------+
|       1 | A    |             3 |
|       3 | B    |            10 |
|       4 | C    |             3 |
|       5 | NULL |          NULL |
+---------+------+---------------+
```

이때 GROUP BY를 여러 열을 했으면? 그 열들은 SELECT에 포함해도 된다.

```mysql
SELECT name, quantity, FROM sample51 GROUP BY name, quantity;
+------+----------+
| name | quantity |
+------+----------+
| A    |        1 |
| A    |        2 |
| B    |       10 |
| C    |        3 |
| NULL |     NULL |
+------+----------+
```

#### 결과값 정렬

```mysql
SELECT name, COUNT(name), SUM(quantity) FROM sample51 GROUP BY name ORDER BY SUM(quantity) DESC;
+------+-------------+---------------+
| name | COUNT(name) | SUM(quantity) |
+------+-------------+---------------+
| B    |           1 |            10 |
| A    |           2 |             3 |
| C    |           1 |             3 |
| NULL |           0 |          NULL |
+------+-------------+---------------+
```

ORDER BY로 집계함수 결과값을 넘겨주면 된다.
