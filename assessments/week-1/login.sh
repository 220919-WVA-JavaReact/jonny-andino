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

echo 'Welcome Back!'
get_username
get_password
display_info
