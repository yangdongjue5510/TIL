### 16강 행 추가하기 - INSERT

```mysql
INSERT INTO 테이블명 VALUES(값1, 값2...);
```

```mysql
INSERT INTO sample41 VALUES(1, 'abc', '2014-01-25');
```

#### 스키마 정보 보기

```mysql
DESC 테이블명;
```

```mysql
mysql> DESC sample41;
+-------+-------------+------+-----+---------+-------+
| Field | Type        | Null | Key | Default | Extra |
+-------+-------------+------+-----+---------+-------+
| no    | int         | NO   |     | NULL    |       |
| a     | varchar(30) | YES  |     | NULL    |       |
| b     | date        | YES  |     | NULL    |       |
+-------+-------------+------+-----+---------+-------+
```

#### 일부 속성만 추가하기

```mysql
INSERT INTO 테이블명(속성1, 속성2...) VALUES(값1, 값2...);
```

```mysql
mysql> INSERT INTO sample41(a, no) VALUES('XYZ', 2);

mysql> SELECT * FROM sample41;
+----+------+------------+
| no | a    | b          |
+----+------+------------+
|  1 | abc  | 2014-01-25 |
|  2 | XYZ  | NULL       |
+----+------+------------+

mysql> INSERT INTO sample411(no) VALUES(2);

mysql> SELECT * FROM sample411;
+----+------+
| no | d    |
+----+------+
|  2 |    0 |
+----+------+
```

이때 입력하지 않은 속성은 NULL로 초기화 되어 추가된다.
만약 입력하지 않은 속성에 DEFAULT 값이 존재하면 DEFAULT로 초기화되어 추가된다.

### 17강 삭제하기 - DELETE

```mysql
DELETE FROM 테이블명 WHERE 조건식;
```

DELETE는 WHERE에 일치하는 모든 행을 삭제한다!!!

### 18강 데이터 갱신하기 - UPDATE

```mysql
UPDATE 테이블명 SET 열1=값1, 열2=값2,... WHERE 조건식
```

조건식에 맞는 행의 열들을 해당 값으로 수정한다. (WHERE절이 없으면 모든 행에 적용된다.)

```mysql
mysql> select * from sample41;
+----+------+------------+
| no | a    | b          |
+----+------+------------+
|  1 | abc  | 2014-01-25 |
+----+------+------------+

mysql> update sample41 SET b = '2022-01-01' where no=1;

mysql> select * from sample41;
+----+------+------------+
| no | a    | b          |
+----+------+------------+
|  1 | abc  | 2022-01-01 |
+----+------+------------+
```

#### 복수열 갱신

```mysql
UPDATE sample41 SET no = no + 1, a = no;
UPDATE sample41 SET a = no, no = no + 1;
```

위 두 식은 DBMS에 따라 결과가 다르다. 오라클은 같은 결과가 나오지만 MySQL은 다르게 나온다.

### 19강 물리삭제와 논리삭제

DELETE로 삭제를 할 때 물리 삭제와 논리 삭제가 가능하다.

물리 삭제 = 테이블에서 해당 데이터를 삭제함.
논리 삭제 = 삭제하지 않고 해당 데이터의 삭제 플래그에 표시를 해둠. 
이때 UPDATE문이 실행됨.
(되돌리기 쉽지만, 용량을 많이 차지하고 삭제했는데 UPDATE가 사용되서 혼동가능)
(조회할 때는 삭제 플래그에 표시된 데이터는 조회되지 않도록 함.)