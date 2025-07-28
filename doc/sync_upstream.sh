#!/usr/bin/env zsh

source ~/.zshrc
if command -v sptn >/dev/null 2>&1; then
  echo "检测到 sptn 命令，正在执行..."
  sptn
else
  echo "未检测到 sptn 命令，跳过执行"
fi

cd ~/Development/IdeaProjects/xxl-job-r3 || exit

# 获取 upstream 最新内容
git fetch upstream

# 切换到 master 分支
git checkout master

# 比较 upstream/master 与本地 master 的差异
NEW_COMMITS=$(git log HEAD..upstream/master --oneline)

if [ -n "$NEW_COMMITS" ]; then
  echo "发现 upstream/master 有新提交："
  echo "$NEW_COMMITS"

  # 保存当前 README.md 状态
  git checkout master -- README.md

  # 合并 upstream/master 到本地 master
  echo "正在合并 upstream/master 到本地 master..."
  git merge upstream/master

  # 用本地的 README.md 覆盖合并后的（可能被 upstream/master 改写的）
  git checkout HEAD -- README.md
  echo "已忽略 README.md 的变更"
else
  echo "无更新"
fi
