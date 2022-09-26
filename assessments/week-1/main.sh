#!/bin/bash

clear;

db="MOCK_DATA.csv"

prompt(){
    echo 'Welcome! Please select one of the following options. Enter one of the following numbers to proceed.'
    echo '1 - Login.'
    echo '2 - Register.'
    echo '3 - Display users.'

    read choice;

    if [ $choice -eq 1 ]
    then
        sh login.sh
    elif [ $choice -eq 2 ]
    then 
        sh register.sh
    elif [ $choice -eq 3 ]
    then
        sh parser.sh $db
    else
        echo 'Please select a chopice from 1-3'
        prompt
    fi
}

prompt