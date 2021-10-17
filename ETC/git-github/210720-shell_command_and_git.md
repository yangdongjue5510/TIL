# shell command and git

gitforwindows.org 에서 윈도우는 설치하면 된다. 공식페이지에는 git flow가 탑재가 안되어있다. 이걸 깔려면 힘들기때문에... gitforwindows.org로 하자.

iTerm 기본 터미널의 대체재

ohmyzsh

## **쉘 명령어에 대해 알아보자!!!**

**커널** : 하드웨어와 응용프로그램을 이어주는 운영체제의 핵심 시스템소프트웨어

**쉘** : 운영체제의 커널과 사용자를 이어주는 소프트웨어(bash가 대중적, zsh이 현재까지 가장 완벽)

**cli** (command line interface) <=> **GUI**(graphic user interface)

cli는 키보드만으로 조절. **#, %, $ 기호가 나오면 사용자의 입력을 받을 준비가 됐다는 의미**

**틸드(~)**는 로그인된 사용자의 최상위 폴더를 의미

**/**는 운영체제가 인식할 수 있는 최상위 폴더를 의미

**/ -> home -> 사용자폴더 -> ~ ** 이런 구조로 디렉토리가 되어 있다고 생각하자.

**사용자@지금 사용하고 있는 컴퓨터이름 : ~%** 이런식으로..  
**cat 텍스트파일**텍스트 파일을 shell창에 띄움

화면을 깔끔하게 하고 싶으면 **clear**

**..(점 두개)** 상위폴더를 의미한다

**.(점 한개)**현재폴더를 의미한다.

### ls(list segment)

지금내가 위치한 경로에서 아래로 선택할 수 있는 디렉토리나 파일을 리스트업

**ls -옵션** : 이렇게 -뒤에 뭘 쓰는 걸 플래그라고 함

**ls -l** : 줄별로 표현

**ls -a** : 숨김파일도 모두 표현(디렉토리 앞에 .을 붙이면 숨김처리가 가능하다.)

플래그들은 여러개 쓸 수 있다 ls -al 이렇게..

### cd(change directory)

디렉토리로 이동한다.

**cd 디렉토리명** 이런식으로 입력하면 해당 디렉토리로 이동한다.

### mkdir(make directory)

**디렉토리를 만든다**

**mkdir 디렉토리이름** 이런식으로 입력하면 해당 디렉토리에 새로운 디렉토리를 추가한다.

### touch

파일을 만든다

**touch test.txt** 이런식으로 입력하면 해당 디렉토리에 

### mv(move)

파일이나 디렉토리를 옮긴다.

**mv 이동시킬것 이동시킬위치 **이렇게 입력하면 이동시킬 것을 이동시킬 위치로 보낸다.

**mv server.py test.py**현재폴더의 server.py를 test.py로 이동시켜달라(이름바꾸기)

**mv test.py 주소/hello.py**현재폴더의 test.py를 어떤 주소의 hello.py로 이름바꿔서 이동(이동과 이름바꾸기 동시에)

### cp(copy)

파일이나 디렉토리를 복제

**cp test.js copy-test.js** 어떤걸 새이름으로 현 폴더로 복제

**cp 상대주소 원하는주소** 상대주소의 어떤 것을 원하는 주소로 복제

_#delete 와 remove delete는 물리적 제거 remove는 추상적 제거_

### rm(remove)

**rm test.txt** 이런 식으로 작성하면 현재 디렉토리에 있는 test.txt제거

**rm -rf 폴더명** 폴더와 폴더 안에 있는 내용 삭제

**(Recursive 안에 있는 녀석들을 다 지우고 디렉토리까지 지워라는 의미, f는 force 강제실행)**

(f플래그는 없어도 됨)

**rm server.\*** server라는 이름을 가진 모든 확장자 제거

**rm \*.py** py확장자를 가진 모든 파일 제거

## **vim 에디터 사용하기**

touch README.md 로 리드미 파일만들고

**vi README.md** 로 vim에디터로 리드미 파일을 수정 할 수 있음

vim 에디터에는 커맨드 노말 인서트 비주얼 네가지 모드가 존재.

처음 들어오면 노말

노말모드에서 :를 누르면 커맨드모드

노말모드에서 i 누르면 인서트모드

노말모드에서 v 누르면 비주얼모드

다른 모드에서 esc누르면 노말모드

## **마크다운 문법.**

<h1> heading</h2>이건 마크업언어

**\# heading** 이건 마크다운방식.

\# 이거 갯수에 따라 h1, h2....

본문은 그냥 막 휘갈기면됩니다..

1\. 이렇게 **번호.스페이스**는 숫자매기기

**\- 하이픈**은 순서가 필요없는 아이템 나열할 때 가능!(dot으로 치환되서 될것)

**\[주소\](텍스트)** 대괄호 사이에는 링크 **이동할 주소**를 넣으면 되고,

**!\[아트텍스트\](이미지 주소)** 느낌표앞에 붙이면 **이미지 첨부**

**\`\`** 로 감싸면 명령문처럼 나오게 된다. **\`command...\`**

**코드**를 쓰고싶으면 **\`\`\`세개**로 블록으로 만들어라!

**\`\`\`사용할 언어**

**해당 코드**

**\`\`\`**

**저장은 커맨드모드에서 가능하다.**

커서가 좌하단에 있으면 **w(저장), q(나가기), wq(저장후 나가기), q!(저장하지 않고 나가기)**

## **Git**

_vcs(version control System)_

_\==scm(source code management)_

_<scm (software configuration management형상관리) 리소스 시간 돈 소스코드..등등 여러가지 _

### 깃의 오브젝트들

**blob** : 파일 하나의 내용정보(변경사항)

**tree** : blob이나 subtree의 메타데이터(변경사항에 대한 메타 데이터. 디렉토리 위치 속성 이름 등)

**Commit** : 커밋 순간의 스냅샷

[##_Image|kage@186OQ/btq92yglGbl/dNUSK1bTHki2k38zkoCbxK/img.png|alignCenter|data-origin-width="631" data-origin-height="450" data-filename="스크린샷 2021-07-20 오후 3.22.20.png" data-ke-mobilestyle="widthOrigin"|||_##]

**git config --list** 로 환경설정확인

[##_Image|kage@c7f59m/btq9Y5ztyuG/uPpqJGksvkeTQzNdddTmf0/img.png|alignCenter|data-origin-width="864" data-origin-height="334" data-filename="스크린샷 2021-07-20 오후 4.07.04.png" data-ke-mobilestyle="widthOrigin"|환경설정을 다 하면 이런식으로 나온다 ㅎㅎ||_##]

**git config --global user.name ~~** 이런식으로 설정가능

**git config --global --unset user.name** 이런식으로 설정 해제 가능

이런식으로 **user.name, user.email, core.editor, init.defaultbranch, core.pager를 잘 설정해주자..!**

**git clone 깃주소**

레포지트에 있는 내용을 해당 디렉토리에 복제

**git staus** 현재위치에서 변경사항 추적

**git add 파일명** 특정 파일을 stage에 올림

**git add .** 모든 변경사항을 stage에 올림

**git commit** 스테이지에 있는 내용을 깃에 올림

위 코드를 입력하면 vim창이 뜨면서 커밋메시지를 쓸 수 있음

[##_Image|kage@cvfrcG/btq92xog4Qz/461kqaD0AgS1KFfXrjdds1/img.png|alignCenter|data-origin-width="1374" data-origin-height="530" data-filename="스크린샷 2021-07-20 오후 4.26.03.png" data-ke-mobilestyle="widthOrigin"|||_##]

맨 위에서부터 제목, 내용을 사용하면된다. **이때 제목과 내용은 공백으로 구분하자.(엔터로)**

**제목은 커밋 프리픽스를 준수하자**

[##_Image|kage@dDYjkF/btq97xglqVT/Et9b3b1A3bIUIXDprxJez0/img.png|alignCenter|data-origin-width="1274" data-origin-height="358" data-filename="스크린샷 2021-07-20 오후 4.30.14.png" data-ke-mobilestyle="widthOrigin"|||_##]

제목에 있는 docs: 을 프리픽스라고 한다.

투두리스트를 써주는게 좋다. 영어로 써주는게 좋다.

(교재 참고)

feat: features 기능 개발

docs : documet 문서작성

conf : configuration 환경설정

test: test 테스트

fix: 버그 수정

commit 이 정상적으로 됐으면, **git push origin main**으로 하면 main 브랜치로 푸쉬가 된다!

(처음 푸쉬하는 경우 username과 password를 입력해야할수도 있다.)

**브랜치를 활용해서 코드리뷰 하기**

**git branch** 브랜치를 확인

**git branch** **브랜치이름** 서브브랜치를 생성

**git checkout** **브랜치이름** 해당 브랜치로 이동

(**git siwtch 브랜치이름** 으로 해도 되는 경우도 있다.)

이렇게 브랜치를 만들고 커밋을 해도 깃허브(리모트)에는 없기 때문에

**git push -u origin 브랜치이름** 으로 -u이 옵션을 처음 할때만 붙여주면 된다.

이렇게 하면 브랜치에 새로운 커밋을 푸시하게 된다.

그리고 코드리뷰를 위해서는 pull request에 들어가

main <- 다른 브랜치로 설정한 상태에서 리뷰어를 초대한 다음,

코드 리뷰어가 승인해줄 때까지 코드를 반복 수정하게 된다.

리뷰어가 승인하고 나면, 머지를 통해 메인에 통합된다.

[##_Image|kage@cwh5D7/btq97bLFylM/MkukdVNHEAI4MD6dQuDJp0/img.png|alignLeft|data-origin-width="848" data-origin-height="312" data-filename="스크린샷 2021-07-20 오후 9.27.27.png" width="429" data-ke-mobilestyle="widthOrigin"|||_##]

**git pull origin main** 메인 브랜치의 내용을 로컬에 다운받는다.(하지만 문제가 있는 내용도 받을 수 있으므로..)

**git fetch origin main FETCH\_HEAD**라는 임시 브랜치에 리모트의 내용을 담고,

**git merge FETCH\_HEAD** 우리는 그 내용 중 일부를 머지해서 받는다.

근데 merge 하는 과정에서 합쳐지는 대상이 내가 아는 대상에서 변경된 경우, 머지에서 오류가 일어날 수 있다...
