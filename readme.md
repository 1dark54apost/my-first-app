我会一直纯手工地制作这个网页app直到它变得完整，修改一下文字

好了现在我要记下来一些我觉得常用的远程推送以及本地git仓库提交命令
1）git remote add origin https://github/1dark54apost/my-first-app 绑定现在的远程仓库my-first-app到本地git
2）git push -u origin master 第一次推送会出现-u，master是分支名默认的
3) git branch -M main 将分支名改为main
4) git push origin main 将这个本地git推到关联好的仓库的分支main下
5) git push 直接简化跟4一样前提是这个git仓库不嵌套也不要嵌套最好
6) 以下是更新流程
7）git pull origin main 先拉取远程仓库
8) git add . 添加所有被改动的文件，也可以指定文件
9）git commit -m "提交说明" 提交文件至本地git仓库
10) git push origin main / git push 推送至远程保存

希望dark apostle能坚持写代码坚持学习，做一个更好的我
								----致未来的dark apostle
