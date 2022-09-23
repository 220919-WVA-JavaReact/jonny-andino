#!/bin/bash

n=$1
flag=0

if [ $n -eq 0 ] || [ $n -eq 1 ]
then
    flag=1
fi

end=$(( $n / 2 ))

for (( i=2; i <= $end; i++ ))
do
    div=$(( $n % $i ))

    if [ $div -eq 0 ]
    then 
        flag=1
    fi
done

if [ $flag -eq 0 ]
then
    echo "${n} is a prime number."
else 
    echo "${n} is not a prime number."
fi