깃에서는 동작하지 않는 코드는 올리지 않는다.

브랜치를 따는 순간 공간은 여러개로 나뉜다.
어떤 브랜치 상태에서 한 작업은 다른 브랜치에 적용되지 않는다.
만약 합치려면 **git merge 합치려는 브랜치이름**
브랜치 지우기 **git branch -D 브랜치이름**

 
## conflict 해결하기
브랜치를 파서 분기가 나눠지고 나서, 메인에서도 어떤 파일을 변경하고, 브랜치에서도 그 파일을 변경했는데 이 두 브랜치를 둘이 합치는 경우...컨플릭트가 나게 된다. 이때 어떤 파일에서 컨플릭트가 났는지 알려주는데, 해당 파일을 들어가보면, 두가지 브랜치의 내용을 보여준다.
 

만약 아무생각없이 vi로 편집하다가 cli를 닫아버렸으면 ls해서 **swq를 파일을 지워라!**
 

## github.io

새로운 레포를 만듬(레포 이름 : 사용자이름.github.io)
hexo.io에 가서 hexo를 설치 명령어인 npm install hexo-cli -g로 설치.
만약 권한 에러가 생기면 sudo를 붙여준다.
근데 이걸 레포를 놓을 위치에서 설치하면 된다.


hexo init 폴더이름 -> hexo 프로젝트 시작
그 폴더에 들어가서 npm install (package.json이 node_modules에 있는 것들을 업데이트 및 설치)
새로운 포스트나 페이지를 만들려면 $ hexo new \[layout] <\title>
만들어진걸 vi로 들어가서 해


hexo clean && hexo generate : 파일로 정적인 사이트를 만들고 실행...
hexo server 로 서버 실행.
hexo 사이트 가서 theme 골라서 시키는 대로 config.yml 있는 곳에 깃 클론

 

config.yml 열어서 :set nu로 번호 만들기
config.yml열였으면, 이름, 자막, 요약 저자, 바꾸고, url"https://깃헙이름.github.io" (끝에 슬래시 넣지마라!)

100번줄에 (:100하면 바로 이동한다) theme: next (다른테마면 그 이름을 써라)
104번 줄에 deploy를
type: git
repo: 레포주소
branch: main
이렇게 설정하주자.


npm install hexo-deployer-git --save 를 설치하고,
이제 깃헙이름.github.io로 가면 된다.

근데 이제 hexo new post 이름 으로 만들어서 쓰고, hexo clean && hexo generate 하고 hexo server를 통해 확인하고, hexo clean && hexo deploy
hexo clean을 하면 public폴더가 초기화 되므로 이미지 같은걸 유지하고 싶으면 생략해라!
 

## git flow

(hotfix),main / (release), develop, feature 이렇게 브랜치 구성을 돕는 도구.


main / feature
ci 의존성 높음, pull request로 방지.

 
gitlab flow
production , pre-production / master, feature
deploy issue에 대응


태그는 우리가 어떤 일을 했는지를 작성

**git tag** => 태그확인
**git push --tags** 태그 푸시

 
### 버전 표시방법
v.x.xx.x
세번째자리는 minor 작은 수정
두번째자리는 major 큰 수정
첫번째자리는 기능단위의 큰 수정(롤 시즌)
 



파일 이름을 바꾸다보면,(mv로 바꿀시) 원본이 삭제된줄 알고 착각할 수 있음..
(파일을 지우고 다른 이름을 한 같은 파일을 만든다고 생각.)
그렇다면 git mv 원본이름 새이름 으로 하자! 그러면 이름을 바꾸는걸 깃이 인식할 수 있다!!!
 

어떤 파일을 잘못 건드려서 최신의 커밋상태로 되돌리기는?
**git checkout -- 해당 파일이름**

 
add된 파일을 다시 stage에서 내리고 싶으면?
**git reset HEAD 파일 이름**


최신 커밋을 수정하려고 할때는?
**git commit --amend**

 
커밋을 되돌리고 싶을 때
**git revert --no-commit HEAD~최신상태에서 얼마나 뒤로 가는지**
(기록이 남는다.)


## 협업 
깃허브의 이슈 탭 : 기술제안, 아젠다 제시 등 해당 레포에 대한 모든 커뮤니케이션

어떤 이슈를 해결한 마지막 커밋 메시지에 resolved: #이슈넘버

이러고나서 pull request할때, #를 누르면 자동완성이 생긴다..!

 

### 협업 프로젝트하기

**1단계**
팀장 : 레포 만들고 레포 주소 배포.(git flow init을 해도 좋음.
팀원 : 레포 주소에 들어가서 folk실행하고 자기꺼 git clone, git flow init
 

**2단계**
팀원 : 이슈 등록
팀장 : 팀원들의 이슈를 기반으로 프로젝트 생성(카반템플릿사용)

 

**3단계**
팀원 :  어떤 이슈를 최종적으로 해결한 커밋을 할 때 커밋 메세지에 resolved: #1 (이슈 넘버)를 붙여줌
팀원 :  이슈를 해결하기 위해 git flow feature start ~ / git flow feature finish ~
팀원 :   자신의 develop 브랜치에 푸시(처음 푸시 일 경우 -u)


**4단계**
팀원 : 팀장develop<-팀원 develop 으로 pull request하기(이때, resolve: #1 이슈 넘버)
팀장 : 내용 확인후 승인 및 거절.
팀원 : 수정 후 커밋 및 푸시

 
**5단계 (conflict 발생 시)**
팀원 : git remote -v 하여 팀장의 존재를 확인하고 없을 경우 git remote add upstream 깃주소를 통해 추가한다.(이건 팀원의 예시)
팀원 : 문제가 발생한 파일을 해결하기 위해 git fetch upstream branch를 하여 자신의 로컬에 FETCH_HEAD 브랜치에 팀장의 최신 커밋을 가져올 수 있음. 이것을 git merge FETCH_HEAD하면 어떤 파일에 conflict난지 알 수 있다.(이 과정을 통틀어 git pull upstream develop)
윗줄이 로컬, 아랫줄이 원격 저장소 임

 
**6단계 conflict 해결**
팀원: 파일을 열어 conflict를 해결하고, 저장 후 git add,  git commit, git push한다
팀장: 문제 해결을 확인하고 pull request를 승인하고 merge한다.


### .gitignore
특정 파일이 원격저장소에 올라가지 않기를 바랄때 .gitignore에 추가하면 된다.
반드시 해당 레포 폴더의 최상단에 .gitignore가 있어야 작동한다.


#### 패턴
- #로 시작하는 문장은 무시한다.
- 슬래시로 시작하면 하위 디렉토리에 적용되지 않음
- 디렉토리는 슬래시를 끝에 붙여서 표현
- !로 시작하는 패턴의 파일은 무시하지 않는다.
- Glob 패턴을 따름.


만약 push해도 안먹으면...
원격저장소 파일을 제거후 push하는 과정이다.
```
git rm -r --cached .
git add .
git commit
git push origin (브랜치)
```
