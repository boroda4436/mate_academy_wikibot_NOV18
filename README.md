[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/boroda4436/mate_academy_wikibot_NOV18.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/boroda4436/mate_academy_wikibot_NOV18/context:java)
[![Build Status](https://travis-ci.com/boroda4436/mate_academy_wikibot_NOV18.svg?branch=master)](https://travis-ci.com/boroda4436/mate_academy_wikibot_NOV18)
[![Telegram](http://trellobot.doomdns.org/telegrambadge.svg)](https://telegram.me/mawb_nov_18_bot)

# MAYouTubeBot
![MAYouTubeBot](/images/youtube_telegram.png)

# Table of Contents
* [Project purpose](#purpose)
* [Project structure](#structure)
* [For user, how to start?](#user-start)
* [For developer](#developer-start)
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
* SpringBoot 2.1.3 RELEASE
* Maven 4.0.0
* MavenCheckstylePlugin 2.17
* com.puppycrawl.tools.Checkstyle 8.18
* CircleCI for checkstyle tests and build check
* Travis CI for checkstyle tests and build check
* GoogleCheckstyle
* HttpClient 4.5.6
* Jackson 2.9.7
* YouTube Java API v3
<hr>

# <a name="user-start"></a>For user. How to start?
*The description will be implemented later after deployment.*
 

# <a name="developer-start"></a>For developer

* Create a new telegram bot.

[Check how to obtain Telegram credentials](https://github.com/boroda4436/mate_academy_wikibot_NOV18/wiki/How-to-obtain--Telegram-bot-credentials%3F)

* Configure YouTube API v3 and obtain an API key.

[Check how to obtain YouTube credentials.](https://github.com/boroda4436/mate_academy_wikibot_NOV18/wiki/How-to-obtain-YouTube-API-key%3F)


* Install Git
* Fork bchupika/mate_academy_wikibot_NOV18 branch into your personal GitHub account. 
![screenshotFor forking](/images/Fork_2.jpg)

* Clone the fork (from your personal GitHub) by next command:
  * git clone https://github.com/<*your_user_name*>/mate_academy_wikibot_NOV18
or
  * git clone git@github.com:<*your_user_name*>/mate_academy_wikibot_NOV18.git

* Add bchupika/mate_academy_wikibot_NOV18 as another remote by:
  * git remote add bchupika https://github.com/boroda4436/mate_academy_wikibot_NOV18.git
* Fetch latest from bchupika/mate_academy_wikibot_NOV18 by:
  * git fetch bchupika 
* Create a local development branch out of bchupika/master by:
  * git checkout -b <*a_branch_name*> bchupika/master
* Build your project by: 
  * mvn clean install
Start project. Point to http://localhost:8080

After following the above steps you will have two remotes ‘bchupika’ and ‘origin’. You may check it like this: 
  * git remote -vv

bchupika https://github.com/boroda4436/mate_academy_wikibot_NOV18.git (fetch) <br />
bchupika https://github.com/boroda4436/mate_academy_wikibot_NOV18.git (push) <br />
origin https://github.com/<*your_github_user_name*>/mate_academy_wikibot_NOV18.git (fetch) <br />
origin https://github.com/<*your_github_user_name*>/mate_academy_wikibot_NOV18.git (push) <br />

After you are done with your local changes push your current local branch to your origin by:
  * git push origin <*name_of_local_branch*>

![push origin](/images/push_origin_localBranch.jpg)

And then create a pull request to bchupika/master.

![pull request](/images/OpenPullRequest.jpg) If you push create pull request button and have such error
![405 Not allowed](/images/NotAllowed.jpg)

Go back and push compare across forks link:

![compareAcrossForks](/images/CompareAcrossForks.jpg)

And you can now create pull request by pushing green button:

![pushButton](/images/pushButton.jpg)

Add reviewers to your pull request.

After the PR test completed successfully and your changes are reviewed ‘Rebase and Merge’ the pull request.

If you have multiple commits and want to squash them into a single commit then either do it locally or click ‘Squash and merge’ when merging the PR.

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
