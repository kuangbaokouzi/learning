Git is a distributed version control system.
Git is a free software.

git 命令
git init 在仓库目录下创建一个.git目录，这个目录就是用来跟踪版本库的
git add 添加指定文件（该文件应该在仓库根目录或者其子目录下）

git commit -m "say something" 将修改过的文件提交到仓库，-m后面的文本内容最好填写，相当于对每次修改的注释内容，方便下次阅读

git status 随时掌握工作区的状态

git diff 查看修改的具体内容（文本，因为word在windows中被变态地处理成了二进制文件，所以无法查看具体的修改内容，那么，一般的文件，一定要保证是utf-8的文本文件，这样可以精确看到修改的内容）

<<<<<<< HEAD
git reset --hard head^ 回滚到上一个版本
git reset --hard head^^ 回滚到上上个版本
git reset --hard head~100 回滚到往上100个版本

git reflog 记录每一次命令
=======
git log 查看版本管理的日志
git log --pretty=oneline 查看版本管理日志的简要信息
>>>>>>> master

git checkout -- file 让文件回到最近一次git commit 或git add时的状态

git reset HEAD file 可以把暂存区的修改撤销掉，重新放回工作区‘

创建远程仓库
在Git Bash 下创建SSH Key：在用户主目录下（C:\Users\gohin\.ssh）
ssh-keygen -t rsa -C "35773597@qq.com"

在github上创建好关联公钥的项目后，在本地git仓库目录下运行下列命令：
git remote add origin git@github.com:kuangbaokouzi/mygit.git
git push -u origin master

使用sourcetree推送本地仓库到远程服务器需要设置工具选项中的ssh秘钥

创建分支
创建dev分支，然后切换到dev分支
git checkout -b dev
相当于下面两条命令
git branch dev --创建分支
git checkout dev --切换到dev分支

查看当前分支
git branch

合并指定分支到当前分支
git merge dev