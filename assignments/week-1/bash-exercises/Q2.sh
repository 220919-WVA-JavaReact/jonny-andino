#! /bin/bash
n=100

a=0
b=1
count=2
echo $a
echo $b
while [ $count -le $n ]
do
    fib=`expr $a + $b`
    a=$b
    b=$fib
    echo $fib
    count=`expr $count + 1`
done