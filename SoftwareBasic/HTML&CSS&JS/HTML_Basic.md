## 기본 형태

태그는 각자의 의미를 가지고 있고 다음과 같은 형태를 가짐

```
<TAG></TAG>
<TAG?CONTENT</TAG>
```

앞 태그는 열리는 태그 , 뒷 태그는 닫히는 태그이다.  
닫히는 태그는 슬래시/가 붙는다.

## 속성과 값

속성은 태그 사용을 확장시키는 개념이다.

```
<TAG 속성 = "값"></TAG>

<img src="./my_photo.jpg" alt="my profile photo" />
<이미지삽입 소스위치="./my_photo.jpg" 대체텍스트="my profile photo" />
<div class="name">yangdongjue</div>
<의미없는분할 태그별명="name">yangdongjue</의미없는분할>
```

div는 의미가 없는 태그다. 다만 class="홍길동"과 같이 이름을 붙여줄 때 사용된다.  
</ima />는 이미지를 사용할 때 쓴다. 다른 태그들과 다르게 태그가 쌍을 이루지 않는데, 이런 태그를 빈 태그라고 한다.

## 부모와 자식 요소

어떤 태그가 다른 태그의 컨텐츠로 사용되면 그 태그는 자식 요소가 되고, 자식 요소를 컨텐츠로 품고 있는 태그는 부모 요소가 된다.

```
<PARENT>
    <CHILD></CHILD>
</PARENT>

<section class="fruits">
    <h1>fruit list</h1>
    <ul>
        <li>apple</li>
        <li>banana</li>
        <li>orange</li>
    </ul>
</section>
```

section->h1->->ul->li 순으로 부모->자식 관계가 이뤄진다.  
이때 자식의 이하 자식들(즉 section입장에서 ul, li를 의미) 후손(하위) 요소이라 한다.  
반면 부모의 상위 부모들(즉 li 입장에서 h1, section을 의미) 조상(상위) 요소라 한다.

## 빈 태그

닫히는 개념이 없는 태그를 빈 태그라고 한다.  
혹은 여는 태그가 스스로 닫아버리는 태그도 빈 태그로 취급한다.  
슬래시를 붙이거나 붙이지 않는 두 가지 방법이 있는데, 하나의 방법으로 통일하는게 좋다.

```
<tag>
<tag/>
<tag />
```

## html 구조

index.html이라는 파일에 다믕과 같이 코딩했을 경우..

```
<!DOCTYPE html>
<html>
    <head>
        문서의 정보
    </head>
    <body>
        문서의 구조
    </body>
</html>
```

## DOCTYPE(DTD, 버전 지정)

DOCTYPE은 마크업 언어에서 문서 형식을 정의한다.  
우리 문서가 어떤 html버전을 쓰는 지 알려준다.

## head 태그에 사용되는 태그들

1.  title(웹 페이지의 제목)  
    html 문서의 제목을 정의. 브라우저에서 탭에서 이름으로 표시
2.  meta(웹페이지의 정보)  
    표시방식, 제작자, 내용, 키워드 등 웹페이지에 대한 정보를 검색엔진이나 브라우저에 제공. 빈태그임.

<table style="border-collapse: collapse; width: 100%; height: 100px;" border="1" data-ke-align="alignLeft" data-ke-style="style12"><tbody><tr style="height: 20px;"><td style="width: 33.3333%; height: 20px;">속성</td><td style="width: 33.3333%; height: 20px;">의미</td><td style="width: 33.3333%; height: 20px;">값</td></tr><tr style="height: 20px;"><td style="width: 33.3333%; height: 20px;">charset</td><td style="width: 33.3333%; height: 20px;">문자인코딩 방식</td><td style="width: 33.3333%; height: 20px;">UTF-8, EUC-KR...</td></tr><tr style="height: 40px;"><td style="width: 33.3333%; height: 40px;">name</td><td style="width: 33.3333%; height: 40px;">검색 엔진 등에 제공하기 위한 정보의 종류(메타 데이터)</td><td style="width: 33.3333%; height: 40px;">author, description, keywords, viewport 등...</td></tr><tr style="height: 20px;"><td style="width: 33.3333%; height: 20px;">content</td><td style="width: 33.3333%; height: 20px;">name 이나 http-equiv 속성의 값 제공</td><td style="width: 33.3333%; height: 20px;">&nbsp;</td></tr></tbody></table>

3.  link(css 불러오기) 외부 문서를 연결할 때 사용. 특히 css 문서를 연결할 때 사용. 빈태그임. 링크를 가져오려면 관계를 설정해야 한다.  
    <rel(필수) = "관계명" href="외부 문서 경로"> 이런식으로 관계를 맺어주면 된다.
4.  style(css 작성하기) css를 외부 문서에서 작성해 연결하는 것이 아닌 html 문서 내부에서 작성할 때 사용.(만약 base태그를 사용했으면, body)
5.  script(js 불러오거나 저장)  
    css는 link태그로 불러오고, style태그로 내용을 작성할 수 있는데, js는 script태그로 불러오고 작성할 수 있다!
6.  base(기준이 되는 base url(uri)를 설정하도록 하는 태그)
    만약 디렉토리에서 접근하면 html 기준 폴더에서 상대경로로 넣어주면 된다.


## body 태그에 쓰이는 태그들

1.  div(막 쓰는 태그)  
    분할을 뜻하고 문서의 섹션을 정의한다고 하지만, 정말 많은 경우 단순히 특정 범위를 묶는 용도로 사용한다. 변수 할당으로 생각하면 편할 듯
2.  img(이미지)  
    </img src= ./kitty.png" alt="cat"> 이런식으로 이미지의 url을 src에 넣고, 이미지의 대체 텍스트를 alt에 필수적으로 넣어야 한다.
    srcset 특성으로 브라우저가 현재 환경에 맞는 이미지를 골라서 사용하도록 할 수 있다.
3.  header(헤더를 가르키는 태그) - main(body 태그의 주요 컨텐츠를 가르키는 태그) - footer(구획 컨텐츠나 구획 루트의 푸터를 나타내는 태그)
    [header](https://developer.mozilla.org/ko/docs/Web/HTML/Element/header)
    [main](https://developer.mozilla.org/ko/docs/Web/HTML/Element/main)
    [footer](https://developer.mozilla.org/ko/docs/Web/HTML/Element/footer)
4.  nav(문서의 부분 중 현재 페이지 내부 혹은 다른 페이지로 링크들을 가지고 있는 태그)
    이 속에 ol, li, a 태그 등을 조합해서 사용한다!
    - a(=앵커요소, href 특성을 통해 다른 페이지, 혹은 같은 페이지 특정 위치, 파일, 이메일 주소 등 다른 url로 연결하는 하이퍼링크로 만듬)
    - ol(정렬된 목록을 나타냄, type 특성으로 카운트 문자를 설정 가능)
5.  textarea(멀티라인 일반 텍스트 편집 컨트롤을 나타냄)
    - rows, cols 특성을 활용해서 크기 조절가능!
6.  input(사용자의 데이터를 받을 수 있는 대화용 컨트롤.)
    - type 특성을 활용해서 유형을 골라 사용하자.
7.  article(문서, 페이지, 어플리케이션, 사이트에서 독립적으로 구분해 배포하거나 사용할 수 있는 영역)
