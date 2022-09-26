#!/bin/bash

db="MOCK_DATA.CSV"

get_username(){
    echo 'Please enter your username:';
    read username;

    found_user=$(sh parser.sh ${db} | grep "^Username: ${username}$");
    
    if [[ -z "$found_user" ]]
    then
        echo 'Error: Username not found. Please try again';
        get_username;
    fi
}

get_password(){
    echo 'Please enter your Password:';
    read -s password;

    password_encoded=$(echo $password | base64);
    found_password=$(sh parser.sh ${db} | grep "^Password (encoded): ${password_encoded}$");
    
    if [[ -z "$found_password" ]]
    then
        echo 'Error: Password incorrect. Please try again'
        get_password
    fi
}

display_info(){
    echo "Success! Welcome back to your User Page:"
    
    sh parser.sh ${db} | grep -A 4 -B 4 "^Username: ${username}$"
}

delete_account_or_exit(){
    echo "Please select one of the following options:"
    echo "1 - Delete user account and data"
    echo "2 - Logout"

    read choice;

    if [ $choice -eq 1 ]
    then
        sed "/${username}/d" $db > tmpfile
        mv tmpfile $db

        clear;
        echo "Successfully deleted profile! Thank you for your business!"
    elif [ $choice -eq 2 ]
    then
        clear;
        echo "Successfully logged out! Thank you for your business!"
    else
        echo 'Please select a choice from 1-2'
        delete_account_or_exit
    fi
}

echo 'Welcome Back!'
get_username
get_password
display_info
delete_account_or_exit