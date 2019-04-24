Feel free to contribute to this project. Below is the detailed instruction how you may do this:

1) Install Git
2) Fork bchupika/mate_academy_wikibot_NOV18 branch into your personal GitHub account. 
![screenshotFor forking](/images/Fork_2.jpg)

3) Clone the fork (from your personal GitHub) by next command:
  * git clone https://github.com/<*your_user_name*>/mate_academy_wikibot_NOV18
or
  * git clone git@github.com:<*your_user_name*>/mate_academy_wikibot_NOV18.git


4) Add bchupika/mate_academy_wikibot_NOV18 as another remote by:
  * git remote add bchupika https://github.com/boroda4436/mate_academy_wikibot_NOV18.git

5) Fetch latest from bchupika/mate_academy_wikibot_NOV18 by:
  * git fetch bchupika 

6) Create a local development branch out of bchupika/master by:
  * git checkout -b <*a_branch_name*> bchupika/master

7) Build your project by: 
  * mvn clean install

8) Start project. Point to http://localhost:8080

9) After following the above steps you will have two remotes ‘bchupika’ and ‘origin’. You may check it like this: 
  * git remote -vv

bchupika https://github.com/boroda4436/mate_academy_wikibot_NOV18.git (fetch) <br />
bchupika https://github.com/boroda4436/mate_academy_wikibot_NOV18.git (push) <br />
origin https://github.com/<*your_github_user_name*>/mate_academy_wikibot_NOV18.git (fetch) <br />
origin https://github.com/<*your_github_user_name*>/mate_academy_wikibot_NOV18.git (push) <br />

10) After you are done with your local changes push your current local branch to your origin by:
  * git push origin <*name_of_local_branch*>

![push origin](/images/push_origin_localBranch.jpg)

11) Then create a pull request to bchupika/master.

![pull request](/images/OpenPullRequest.jpg) 

12) If you push create pull request button and have such error

![405 Not allowed](/images/NotAllowed.jpg)

13) Go back and push compare across forks link:

![compareAcrossForks](/images/CompareAcrossForks.jpg)

14) Now you can create pull request by pushing green button:

![pushButton](/images/pushButton.jpg)

15) Add reviewers to your pull request.

After the PR test completed successfully and your changes are reviewed ‘Rebase and Merge’ the pull request.

If you have multiple commits and want to squash them into a single commit then either do it locally or click ‘Squash and merge’ when merging the PR.
