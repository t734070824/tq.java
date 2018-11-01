2018-06-20

## 文件

### 文件大小排序
1. 删除过大文件
2. 按字节排序
    - du -s /usr/* | sort -rn
3. 按兆（M）来排序
    - du -sh /usr/* | sort -rn
4. 选出排在前面的10个
   - du -s /usr/* | sort -rn | head
5. 选出排在后面的10个
   - du -s /usr/* | sort -rn | tail

### 文件内容查找
1. grep -r common.dcorm.tcy365.net /projects/server/ROOT/*/configs