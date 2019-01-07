2018-06-29

## 字符串最长前缀后缀
1. 描述 以”ABCDABD”为例，进行介绍
    - ”A”的前缀和后缀都为空集，共有元素的长度为0；
    - ”AB”的前缀为[A]，后缀为[B]，共有元素的长度为0；
    - ”ABC”的前缀为[A, AB]，后缀为[BC, C]，共有元素的长度0；
    - ”ABCD”的前缀为[A, AB, ABC]，后缀为[BCD, CD, D]，共有元素的长度为0；
    - ”ABCDA”的前缀为[A, AB, ABC, ABCD]，后缀为[BCDA, CDA, DA, A]，共有元素为”A”，长度为1；
    - ”ABCDAB”的前缀为[A, AB, ABC, ABCD, ABCDA]，后缀为[BCDAB, CDAB, DAB, AB, B]，共有元素为”AB”，长度为2；
    - ”ABCDABD”的前缀为[A, AB, ABC, ABCD, ABCDA, ABCDAB]，后缀为[BCDABD, CDABD, DABD, ABD, BD, D]，共有元素的长度为0。