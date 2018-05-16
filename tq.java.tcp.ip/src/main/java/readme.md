2018-03-03

## 常用

### TCP 3次握手
1. C--(SYN=1, Seq=C_INS)--S
2. S--(SYN=1, **Seq=S_INS, ACK=C_INS + 1**)--C
3. C--(SYN=0, **Seq=C_INS + 1, ACK= S_INS + 1**)--S


