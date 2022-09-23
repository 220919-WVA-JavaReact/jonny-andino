#!/bin/bash

str=$1   
len="${#str}"   
i=0   
rev=""

while (( i<len ))
do 
    rev="${str:i++:1}$rev"
done

if [ $str == $rev ]
then
    echo "${str} is a palindrome"
else
    echo "${str} is not a palindrome"
fi