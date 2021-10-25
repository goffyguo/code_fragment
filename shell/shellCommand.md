查看某个端口是否开启: lsof -i:27017

```shell
root@dell-pc:/usr/local/mongodb/mongodb-linux-aarch64-amazon2-4.4.6/bin# lsof -i:27017
COMMAND   PID USER   FD   TYPE DEVICE SIZE/OFF NODE NAME
mongod  22714 root   11u  IPv4 165839      0t0  TCP *:27017 (LISTEN)
```

查看所有开放的端口： netstat -aptn

```shell
root@dell-pc:/usr/local/mongodb/mongodb-linux-aarch64-amazon2-4.4.6/bin# netstat -aptn
Active Internet connections (servers and established)
Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name    
tcp        0      0 0.0.0.0:27017           0.0.0.0:*               LISTEN      22714/mongod        
tcp        0      0 127.0.0.53:53           0.0.0.0:*               LISTEN      807/systemd-resolve 
tcp        0      0 0.0.0.0:22              0.0.0.0:*               LISTEN      920/sshd: /usr/sbin 
tcp        0      0 172.16.70.2:22          172.16.110.129:61671    ESTABLISHED 23092/sshd: dell [p 
tcp        0    196 172.16.70.2:22          172.16.110.107:54249    ESTABLISHED 22104/sshd: dell [p 
tcp        0      0 172.16.70.2:22          172.16.110.129:61672    ESTABLISHED 23201/sshd: dell [p 
tcp6       0      0 :::8080                 :::*                    LISTEN      4750/java           
tcp6       0      0 :::22                   :::*                    LISTEN      920/sshd: /usr/sbin
```

查看系统中使用 tcp 协议的端口号信息：netstat -ntpl

```shell
root@dell-pc:/usr/local/mongodb/mongodb-linux-aarch64-amazon2-4.4.6/bin# netstat -ntpl
Active Internet connections (only servers)
Proto Recv-Q Send-Q Local Address           Foreign Address         State       PID/Program name    
tcp        0      0 0.0.0.0:27017           0.0.0.0:*               LISTEN      22714/mongod        
tcp        0      0 127.0.0.53:53           0.0.0.0:*               LISTEN      807/systemd-resolve 
tcp        0      0 0.0.0.0:22              0.0.0.0:*               LISTEN      920/sshd: /usr/sbin 
tcp6       0      0 :::8080                 :::*                    LISTEN      4750/java           
tcp6       0      0 :::22                   :::*                    LISTEN      920/sshd: /usr/sbin
```