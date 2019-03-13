# MAYouTubeBot
![MAYouTubeBot](/images/youtube_telegram.png)
# Table of Contents
* [Project purpose](#purpose)
* [Project structure](#structure)
* [For user, how to start?](#user-start)
* [For developer](#developer-start)
* [Statistic of code quality](#statistic)
* [License](#license)
* [Authors](#authors)

# <a name="purpose"></a>Project purpose
MAYouTubeBot is the App for searching video on YouTube using TelegramBot.
<hr>
You can use MAYouTubeBot by going to Telegram, 
finding it by name, typing 2-3 words of interest and here it is! 
MAYouTubeBot would give you the most relative video to you search. Just there,
at your telegram chat!

<hr>

# <a name="structure"></a>Project Structure
* Java 8
* SpringFramework 2.1.3 RELEASE
* Maven 4.0.0
* MavenCheckstyle 2.17
* CheckstyleVersion 8.18
* CircleCI for checkstyle and build check
* Travis CI for checkstyle and build check
* HttpClient 4.5.6
* Jackson

<hr>

# <a name="user-start"></a>For user. How to start?

Install Git
Fork bchupika/mate_academy_wikibot_NOV18 branch into your personal GitHub account. 
![screenshotFor forking](/images/Fork_2.jpg)
<hr>
Clone the fork (from your personal GitHub) by next command:

git clone https://github.com/<*your_user_name*>/mate_academy_wikibot_NOV18

or

git clone git@github.com:<*your_user_name*>/mate_academy_wikibot_NOV18.git

Add bchupika/mate_academy_wikibot_NOV18 as another remote.
	git remote add bchupika https://github.com/boroda4436/mate_academy_wikibot_NOV18.git
Fetch latest from bchupika/mate_academy_wikibot_NOV18
	git fetch bchupika 
Create a local development branch out of bchupika/master
	git checkout -b <*a_branch_name*> bchupika/master
Build your project by: 
	mvn clean install
Start project

Point to http://localhost:8080 

# <a name="developer-start"></a>For developer

After following the above steps (description for user ) you will have two remotes ‘bchupika’
and ‘origin’. 
You may check it like this: 
git remote -vv

bchupika        https://github.com/boroda4436/mate_academy_wikibot_NOV18.git (fetch)
bchupika        https://github.com/boroda4436/mate_academy_wikibot_NOV18.git (push)
origin  https://github.com/<*your_github_user_name*>/mate_academy_wikibot_NOV18.git (fetch)
origin  https://github.com/<*your_github_user_name*>/mate_academy_wikibot_NOV18.git (push)


After you are done with your local changes push your current local branch to your origin

git push origin <*name_of_local_branch*>

![push origin](/images/push_origin_localBranch.jpg)

And then create a pull request to bchupika/master.

![pull request](/images/OpenPullRequest.jpg) If you push create pull request button and have such error
![405 Not allowed](/images/NotAllowed.jpg)

Go back and push compare across forks link:

![compareAcrossForks](/images/CompareAcrossForks.jpg)

And you can now create pull request by pushing green button:

![pushButton](/images/pushButton.jpg)

Add reviwers to your pull request.

After the PR test completed successfully and your changes are reviewed ‘Rebase and Merge’ the pull request.

If you have multiple commits and want to squash them into a single commit then either do it locally or click ‘Squash and merge’ when merging the PR.

# <a name="statistic"></a>Statistic of code quality

[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/boroda4436/mate_academy_wikibot_NOV18.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/boroda4436/mate_academy_wikibot_NOV18/context:java)

<hr>

# <a name="license"></a>License

***Copyright (c) 2019 Mate Academy (NOV18)***

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

<hr>

# <a name="authors"></a>Authors
* https://github.com/boroda4436
* https://github.com/BondarenkoJek
* https://github.com/Dinexpod
* https://github.com/DmitriyLitvin
* https://github.com/Illia1927
* https://github.com/Orbit419
* https://github.com/romaanankin
* https://github.com/YatKat
