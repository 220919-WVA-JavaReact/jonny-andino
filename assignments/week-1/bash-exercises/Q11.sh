#!/bin/bash

score=$1

if [ $score -ge 90 ] && [ $score -le 100 ]
then
    echo 'Grade A'
elif [ $score -lt 90 ] && [ $score -ge 80 ]
then
    echo 'Grade B'
elif [ $score -lt 80 ] && [ $score -ge 70 ]
then
    echo 'Grade C'
elif [ $score -lt 70 ] && [ $score -ge 60 ]
then 
    echo 'Grade D'
elif [ $score -lt 60 ]
then
    echo 'Grade F'
else 
    echo 'Please enter a valid grade (number from 0 to 100)'
fi
