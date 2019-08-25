# Algo-Study

# 알고리즘 스터디

## GitHub 사용방법
> Forking WorkFlow
1. git 설치
2. 해당 프로젝트 Fork
    - git repository fork를 하여 개인 git 계정에 repository를 생성한다.
3. 개인 remote repository를 Local로 clone 합니다.
<pre><code>git clone git@github.com:<username>/Algo-Study.git</code></pre>
4. public repository를 Upstream remote로 추가합니다.
    - origin, upstream remote가 생성된 것을 확인할 수 있습니다.
<pre>
<code>git remote add upstream git@github.com:KangPilGyu/Algo-Study.git</code>
<code>git remote -v</code>
</pre>
5. Branch를 생성합니다.
<pre><code> git checkout -b <branchName></code></pre>
6. 소스 코드를 생성, 수정 한 후 commit 를 생성합니다.
  - commit은 [이름][주차.스터디주제]간략한 커밋 내용
  - ex) [김제니][1.DP]1101문제 수정
<pre><code>git commit -m "[김제니][1.DP]1101문제 수정"</code></pre>
7. 개인 Remote Repository에 해당 브랜치를 push 합니다.
    - push 전 git fetch upstream를 통해 Upstream Repository의 최신 변경사항과 일치시킵니다.
<pre> <code>git push origin <branchName></code></pre>
8. 개인 Remote Repository에서 간단한 코멘트와 함께 Pull Request를 생성합니다.
