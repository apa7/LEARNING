## 什么是Redis？  
>Redis通常被称为数据结构服务器。这意味着Redis通过一组命令提供对可变数据结构的访问，这些命令是使用带有TCP套接字和简单协议的服务器-客户端模型发送的。因此，不同的进程可以以共享的方式查询和修改相同的数据结构。 
Redis中实现的数据结构具有一些特殊属性：  
即使始终为它们提供服务并将它们修改到服务器内存中，Redis也会将它们存储在磁盘上。这意味着Redis速度很快，但这也是非易失性的。  
数据结构的实现着重于内存效率，因此与使用高级编程语言建模的相同数据结构相比，Redis内部的数据结构可能使用较少的内存。  
Redis提供了许多在数据库中自然可以找到的功能，例如复制，持久性的可调级别，集群，高可用性。  
另一个很好的例子是将Redis视为memcached的一个更复杂的版本，其中的操作不仅是SET和GET，而且是与复杂数据类型（如列表，集合，有序数据结构等）一起使用的操作。  
 

官网：http://redis.io   
源码：https://github.com/antirez/redis   
Redis数据类型简介：http://redis.io/topics/data-types-intro  
直接在浏览器中尝试Redis：http://try.redis.io  
Redis命令的完整列表：http://redis.io/commands  
Redis官方文档中还有更多内容：http://redis.io/documentation  

[TOC]
## 数据结构
### 动态字符串sds.c

### 整数集合intset.c
### 压缩列表ziplist.c
### 快速链表quicklist.c
### 字典dict.c
### Streams的底层实现
* listpack.c
* rax.c

## 数据类型底层实现

## 数据库的实现

## 服务端和客户端的实现

## 其他

### 主从

### 哨兵

### 集群

### lua脚本





