## CSS 기초 구조

css는 html보다 더 쉽다.  
선택자, 속성, 값으로 이뤄져 있다

```
div {
    font-size: 20px;
    color: red;
}

선택자 {
    송성: 값;
    속성: 값;
}
```

선택자는 html의 어떤 요소에게 효과를 적용시킬지 인식하기 위해 사용되는 개념이다.  
선택자는 html의 태그를 통해 특정 요소를 가르키게 된다.(h1, div ..)  
속성(properties)과 값은 어떤 요소에 얼마나 효과를 적용시킬지를 결정할 때 사용된다.  
이때 html의 속성과 구분해야한다. html의 속성은 attribute이다.

### 클래스 선택자

태그로 찾는 것 뿐만 아니라 클래스로 요소를 찾을 수 있다.  
이렇게 클래스로 요소를 찾는 선택자를 '클래스 선택자'라고 한다

```
.title{
    color:red;
}
.main-text {
    color: blue;
}
```

### 속성

#### 크기

1.  width(가로너비) : px단위 사용
2.  height(세로너비) : px단위 사용

#### 여백

1.  margin(요소의 바깥 여백) : px 단위 사용  
    margin-top, margint-bottom, margin-right, margin-left로 방향 별로 다르게 설정가능
2.  padding(요소의 안쪽 여백) : px 단위 사용  
    margin과 같이 padding-top...이런식으로 개별 설정 가능

#### 색상

1.  color(글자 색상)
2.  background-color(요소 배경색상)  
    클래스로 찾으려면 클래스 이름 앞에 점을 찍어 선택자 자리에 넣으면 된다.

### 선언방식

#### 태그에 직접 작성하기(인라인)

html 태그에 직접 작성하는 방식으로 선택자가 필요없다.일일히 여러 요소에 손으로 코딩해줘야 하므로 추천하지는 않는다.

```
<div style="color: red;">태그에 직접 작성1</div> <!-- red -->
<div style="color: red;">태그에 직접 작성2</div> <!-- red -->
<div style="color: red;">태그에 직접 작성3</div> <!-- red -->
<div style="color: red;">태그에 직접 작성4</div> <!-- red -->
```

#### html에 포함하기(내장)

css에 따로 작성하는 방법으로 선택자가 필요하다.  
html의 style태그에 css코드를 집어 넣는 식이다.  
예시를 보면 한 html안에 있는 여러 div태그에 일괄적으로 효과를 적용시킬 수 있다는 것을 알 수 있다.

```
<head>
  <style>
    div {
      color: red;
    }
  </style>  
</head>
<body>
  <div>HTML에 포함1</div> <!-- red -->
  <div>HTML에 포함2</div> <!-- red -->
  <div>HTML에 포함3</div> <!-- red -->
</body>
```

#### html 외부에서 가져오기(외장)

css파일을 따로 생성하여 코딩하고 html에서 link태그를 통해 불러오는 방식이다.  
아래 예시를 보면, 하나의 css파일로 여러 html에 효과를 적용시킴을 알 수 있다.

```
<head>
  <link rel="stylesheet" href="/css/main.css">
</head>
<body>
  <div>HTML에 외부에서 불러오기1</div> <!-- red -->
</body>
```

```
<head>
  <link rel="stylesheet" href="/css/main.css">
</head>
<body>
  <div>HTML에 외부에서 불러오기2</div> <!-- red -->
</body>
```

```
div {
  color: red;
}
```