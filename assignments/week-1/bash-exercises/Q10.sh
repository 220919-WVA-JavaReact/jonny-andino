#!/bin/bash
args=($@)

max(){
    if [ $1 -gt $2 ]
    then
        echo $1
    else
        echo $2
    fi
}

highest=$(max $1 $2)
highest=$(max $highest $3) 

echo $highest