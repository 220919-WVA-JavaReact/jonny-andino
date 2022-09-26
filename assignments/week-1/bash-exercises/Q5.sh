#!/bin/bash
arr=("$@")

pos=0
neg=0

evaluate(){
    if [ $1 -gt 0 ]
    then
        pos=$(( $pos + 1 ))
        echo "pos: ${1}"
    else
        neg=$(( $neg + 1 ))
        echo "neg: ${1}"
    fi
}

for i in ${arr[@]}
do  
    evaluate $i
done

echo "Total number of positive numbers is: ${pos}"
echo "Total number of negative numbers is: ${neg}"