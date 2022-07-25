bug

    npm WARN config global `--global`, `--local` are deprecated. Use `--location=global` instead.

solve

    找到并修改node.js目录下的npm.cmd , 将npm.cmd中的prefix -g修改为 prefix --location=global 

