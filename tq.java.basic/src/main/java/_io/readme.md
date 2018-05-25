2018-05-25

## ReadLine

### 使用 BufferedReader/BufferedInputStream.readLine()
1. 每次读回来的都是一行，省了很多手动拼接buffer的琐碎
2. 它比较高效，相对于一个字符/字节地读取、转换、返回来说，它有一个缓冲区，读满缓冲区才返回；一般情况下，都建议使用它们把其它Reader/InputStream包起来，使得读取数据更高效
3. 对于文件来说，经常遇到一行一行的，特别相符情景

### 问题
1. while((request = reader.readLine()) != null)
    - 误以为readLine()是读取到没有数据时就返回null(因为其它read方法当读到没有数据时返回-1)
    - **而实际上readLine()是一个阻塞函数，当没有数据读取时，就一直会阻塞在那，而不是返回null**
    - **readLine()只有在数据流发生异常或者另一端被close()掉时，才会返回null值**
    - 如果不指定buffer大小，则readLine()使用的buffer有8192个字符。在达到buffer大小之前，只有遇到"/r"、"/n"、"/r/n"才会返回。

### 注意
1. 读入的数据要注意有/r或/n或/r/n
1. 没有数据时会阻塞，在数据流异常或断开时才会返回null
1. 使用socket之类的数据流时，要避免使用readLine()，以免为了等待一个换行/回车符而一直阻塞