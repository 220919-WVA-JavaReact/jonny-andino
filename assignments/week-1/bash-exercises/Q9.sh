#!/bin/bash

div=$(( $1 % 2 ))

if [ $div -eq 0 ]
then 
    echo "${1} is even"
else
    echo "${1} is false"
fi